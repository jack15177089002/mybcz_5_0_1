package com.baicizhan.client.framework.network.http.download;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.asynctask.LAsyncTask.LAsyncTaskStatus;
import com.baicizhan.client.framework.asynctask.LAsyncTaskTags;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import com.baicizhan.client.framework.network.http.HttpContext;
import com.baicizhan.client.framework.network.http.HttpManager;
import com.baicizhan.client.framework.network.http.HttpProgressor;
import com.baicizhan.client.framework.network.http.HttpRequest;
import com.baicizhan.client.framework.network.http.HttpRequest.HTTP_METHOD;
import com.baicizhan.client.framework.network.http.backoff.DefaultBFPolicy;
import com.baicizhan.client.framework.network.http.download.IDownloadManager.DownloadCallback;
import com.baicizhan.client.framework.network.http.download.IDownloadManager.State;
import com.baicizhan.client.framework.util.Common;
import com.baicizhan.client.framework.util.IBackoffPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DownloadManager implements IDownloadManager {
    /* access modifiers changed from: private */
    public static final IBackoffPolicy DEF_BF_POLICY = new DefaultBFPolicy();
    private static final int DEF_CONCURRENCE = 1;
    private static final int DEF_CONN_TIMEOUT = 0;
    private static final int DEF_MAX_RETRY = 0;
    private static final int DEF_READ_TIMEOUT = 0;
    /* access modifiers changed from: private */
    public DownloadCallback mCallback;
    /* access modifiers changed from: private */
    public GroupDownloadHandler mGroupHandler = new GroupDownloadHandler(this);
    private GroupDownloadTask mGroupTask;
    /* access modifiers changed from: private */
    public DownloadHandler mHandler = new DownloadHandler(this);
    /* access modifiers changed from: private */
    public HttpManager mManager;
    /* access modifiers changed from: private */
    public List<HttpManager> mManagers = new ArrayList();
    /* access modifiers changed from: private */
    public RequestParam mRequestParam = new RequestParam();
    /* access modifiers changed from: private */
    public State mState = State.None;
    private DownloadTask mTask;

    class DownloadHandler extends Handler {
        final WeakReference<DownloadManager> mDNManager;

        DownloadHandler(DownloadManager downloadManager) {
            this.mDNManager = new WeakReference<>(downloadManager);
        }

        public void handleMessage(Message message) {
            long j = 0;
            DownloadManager downloadManager = (DownloadManager) this.mDNManager.get();
            if (downloadManager != null && downloadManager.mState == State.Downloading) {
                HttpProgressor httpProgressor = (HttpProgressor) message.obj;
                switch (message.what) {
                    case 0:
                        long currentSize = httpProgressor.getCurrentSize();
                        long totalSize = httpProgressor.getTotalSize();
                        if (totalSize > 0) {
                            j = (100 * currentSize) / totalSize;
                        }
                        int i = (int) j;
                        if (i < 0) {
                            i = 0;
                        } else if (i > 100) {
                            i = 100;
                        }
                        if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
                            C0789L.log.info("trace download, completed [{}], total [{}], progress [{}]", Long.valueOf(currentSize), Long.valueOf(totalSize), Integer.valueOf(i));
                        }
                        if (downloadManager != null && downloadManager.mCallback != null) {
                            downloadManager.mCallback.onProgress(i);
                            return;
                        }
                        return;
                    case 1:
                        if (downloadManager != null && downloadManager.mCallback != null) {
                            downloadManager.mCallback.onStartDecompress();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    final class DownloadTask extends LAsyncTask<HttpManager, Integer, Boolean> {
        DownloadTask(String str, int i) {
            setTag(LAsyncTaskTags.TAG_DOWNLOAD);
            setKey(str);
            parallelTask(i);
        }

        /* access modifiers changed from: protected */
        public final Boolean doInBackground(HttpManager... httpManagerArr) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Boolean.valueOf(httpManagerArr[0].downloadFile(DownloadManager.this.mHandler));
        }

        /* access modifiers changed from: protected */
        public final void onPostExecute(Boolean bool) {
            Log.d("whiz", "onPostExecute, state: " + DownloadManager.this.mState);
            if (DownloadManager.this.mManager != null) {
                if (DownloadManager.this.mCallback == null) {
                    DownloadManager.this.mState = State.None;
                    return;
                }
                int i = DownloadManager.this.mManager.getContext().getResponse().responseCode;
                String downloadPath = DownloadManager.this.mManager.getContext().getResponse().getDownloadPath();
                if (!bool.booleanValue()) {
                    if (State.Stopped == DownloadManager.this.mState) {
                        DownloadManager.this.mCallback.onStop();
                    } else if (State.Paused == DownloadManager.this.mState) {
                        DownloadManager.this.mCallback.onPause();
                    }
                    DownloadManager.this.mState = State.Failed;
                    DownloadManager.this.mCallback.onComplete(false, downloadPath, i);
                } else if (State.Downloading == DownloadManager.this.mState) {
                    DownloadManager.this.mState = State.Successed;
                    DownloadManager.this.mCallback.onProgress(100);
                    DownloadManager.this.mCallback.onComplete(true, downloadPath, i);
                } else {
                    throw new IllegalStateException("The download state is illegal right now. Expect state is: [" + State.Downloading + "], but the actual one is: [" + DownloadManager.this.mState + "].");
                }
            }
        }

        public final void cancel() {
            super.cancel();
            if (DownloadManager.this.mManager != null) {
                DownloadManager.this.mManager.getContext().getResponse().isCancel = true;
                DownloadManager.this.mManager.getContext().getResponse().cancelable.mCanceled = true;
            }
        }

        public final void onCancelled() {
            super.onCancelled();
            Log.d("whiz", "onCancelled, state: " + DownloadManager.this.mState);
            if (DownloadManager.this.mCallback == null) {
                DownloadManager.this.mState = State.None;
            } else if (State.Stopped == DownloadManager.this.mState) {
                DownloadManager.this.mCallback.onStop();
            } else if (State.Paused == DownloadManager.this.mState) {
                DownloadManager.this.mCallback.onPause();
            }
        }
    }

    class GroupDownloadHandler extends Handler {
        final WeakReference<DownloadManager> mDNManager;
        private int mSuccessed = 0;

        GroupDownloadHandler(DownloadManager downloadManager) {
            this.mDNManager = new WeakReference<>(downloadManager);
        }

        public void handleMessage(Message message) {
            DownloadManager downloadManager = (DownloadManager) this.mDNManager.get();
            if (downloadManager != null && downloadManager.mState == State.Downloading) {
                HttpProgressor httpProgressor = (HttpProgressor) message.obj;
                switch (message.what) {
                    case 0:
                        if (downloadManager != null && downloadManager.mCallback != null) {
                            long currentSize = httpProgressor.getCurrentSize();
                            long totalSize = httpProgressor.getTotalSize();
                            float size = 100.0f / ((float) downloadManager.mRequestParam.urls.size());
                            int i = totalSize > 0 ? (int) ((((float) currentSize) * size) / ((float) totalSize)) : 0;
                            if (i < 0) {
                                i = 0;
                            } else if (((float) i) > size) {
                                i = (int) size;
                            }
                            downloadManager.mCallback.onProgress((int) (((float) i) + (((float) this.mSuccessed) * size)));
                            return;
                        }
                        return;
                    case 1:
                        if (downloadManager != null && downloadManager.mCallback != null) {
                            downloadManager.mCallback.onStartDecompress();
                            return;
                        }
                        return;
                    case 2:
                        this.mSuccessed++;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    final class GroupDownloadTask extends LAsyncTask<List<HttpManager>, Integer, Boolean> {
        GroupDownloadTask(String str, int i) {
            setTag(LAsyncTaskTags.TAG_DOWNLOAD);
            setKey(str);
            parallelTask(i);
        }

        /* access modifiers changed from: protected */
        public final Boolean doInBackground(List<HttpManager>... listArr) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (HttpManager downloadFile : listArr[0]) {
                if (!downloadFile.downloadFile(DownloadManager.this.mGroupHandler)) {
                    return Boolean.valueOf(false);
                }
            }
            return Boolean.valueOf(true);
        }

        /* access modifiers changed from: protected */
        public final void onPostExecute(Boolean bool) {
            int i;
            if (!DownloadManager.this.mManagers.isEmpty()) {
                if (DownloadManager.this.mCallback == null) {
                    DownloadManager.this.mState = State.None;
                    return;
                }
                int i2 = ((HttpManager) DownloadManager.this.mManagers.get(DownloadManager.this.mManagers.size() - 1)).getContext().getResponse().responseCode;
                ArrayList arrayList = new ArrayList(DownloadManager.this.mManagers.size());
                for (HttpManager context : DownloadManager.this.mManagers) {
                    arrayList.add(context.getContext().getResponse().getDownloadPath());
                }
                if (!bool.booleanValue()) {
                    if (State.Stopped == DownloadManager.this.mState) {
                        DownloadManager.this.mCallback.onStop();
                    } else if (State.Paused == DownloadManager.this.mState) {
                        DownloadManager.this.mCallback.onPause();
                    }
                    DownloadManager.this.mState = State.Failed;
                    for (HttpManager httpManager : DownloadManager.this.mManagers) {
                        if (httpManager.getContext().getResponse().responseCode < 0) {
                            i = httpManager.getContext().getResponse().responseCode;
                        } else {
                            i = i2;
                        }
                        i2 = i;
                    }
                    DownloadManager.this.mCallback.onGroupComplete(false, arrayList, i2);
                } else if (State.Downloading == DownloadManager.this.mState) {
                    DownloadManager.this.mState = State.Successed;
                    DownloadManager.this.mCallback.onProgress(100);
                    DownloadManager.this.mCallback.onGroupComplete(true, arrayList, i2);
                } else {
                    throw new IllegalStateException("The download state is illegal right now. Expect state is: [" + State.Downloading + "], but the actual one is: [" + DownloadManager.this.mState + "].");
                }
            }
        }

        public final void cancel() {
            super.cancel();
            for (HttpManager httpManager : DownloadManager.this.mManagers) {
                httpManager.getContext().getResponse().isCancel = true;
                httpManager.getContext().getResponse().cancelable.mCanceled = true;
            }
        }

        public final void onCancelled() {
            super.onCancelled();
            if (DownloadManager.this.mCallback == null) {
                DownloadManager.this.mState = State.None;
            } else if (State.Stopped == DownloadManager.this.mState) {
                DownloadManager.this.mCallback.onStop();
            } else if (State.Paused == DownloadManager.this.mState) {
                DownloadManager.this.mCallback.onPause();
            }
        }
    }

    class RequestParam {
        boolean autoDecomp;
        IBackoffPolicy bfpolicy;
        DownloadCallback callback;
        int concurrence;
        int connTimeout;
        String destPath;
        int maxRetry;
        int readTimeout;
        String url;
        HashMap<String, String> urls;

        private RequestParam() {
            this.urls = new HashMap<>();
            this.autoDecomp = true;
            this.concurrence = 1;
            this.maxRetry = 0;
            this.readTimeout = 0;
            this.connTimeout = 0;
            this.bfpolicy = DownloadManager.DEF_BF_POLICY;
        }
    }

    public boolean start() {
        if (this.mRequestParam.url != null) {
            return start(this.mRequestParam.url, this.mRequestParam.destPath, this.mRequestParam.autoDecomp, this.mRequestParam.concurrence, this.mRequestParam.maxRetry, this.mRequestParam.readTimeout, this.mRequestParam.connTimeout, this.mRequestParam.bfpolicy, this.mRequestParam.callback);
        } else if (this.mRequestParam.urls.isEmpty()) {
            return false;
        } else {
            if (State.Downloading == this.mState || State.Paused == this.mState) {
                return false;
            }
            if (this.mTask != null) {
                throw new RuntimeException("A single download task exists as you start a group download task.");
            }
            for (Entry entry : this.mRequestParam.urls.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                HttpContext httpContext = new HttpContext();
                HttpManager httpManager = new HttpManager(httpContext);
                HttpRequest request = httpContext.getRequest();
                request.setUrl(str);
                request.setMethod(HTTP_METHOD.GET);
                request.setDestPath(str2);
                request.setAutoDecompress(this.mRequestParam.autoDecomp);
                request.setMaxRetry(this.mRequestParam.maxRetry);
                request.setReadTimeout(this.mRequestParam.readTimeout);
                request.setConnTimeout(this.mRequestParam.connTimeout);
                request.setConcurrence(this.mRequestParam.concurrence);
                request.setBackoffPolicy(this.mRequestParam.bfpolicy);
                this.mManagers.add(httpManager);
            }
            this.mCallback = this.mRequestParam.callback;
            if (this.mGroupTask != null && !this.mGroupTask.isCancelled()) {
                this.mGroupTask.cancel();
                for (HttpManager httpManager2 : this.mManagers) {
                    httpManager2.getContext().getResponse().isCancel = false;
                    httpManager2.getContext().getResponse().cancelable.mCanceled = false;
                }
            }
            this.mGroupTask = getGroupDownloadTask();
            this.mGroupTask.execute(this.mManagers);
            this.mState = State.Downloading;
            if (this.mCallback != null) {
                this.mCallback.onStart();
            }
            return true;
        }
    }

    public IDownloadManager setUrl(String str) {
        this.mRequestParam.url = str;
        return this;
    }

    public String getUrl() {
        return this.mRequestParam.url;
    }

    public IDownloadManager addUrl(String str) {
        return addUrl(str, null);
    }

    public IDownloadManager addUrl(String str, String str2) {
        this.mRequestParam.urls.put(str, str2);
        return this;
    }

    public Map<String, String> getUrls() {
        return this.mRequestParam.urls;
    }

    public IDownloadManager setDestPath(String str) {
        this.mRequestParam.destPath = str;
        return this;
    }

    public String getDestPath() {
        return this.mRequestParam.destPath;
    }

    public IDownloadManager setAutoDecompress(boolean z) {
        this.mRequestParam.autoDecomp = z;
        return this;
    }

    public boolean isAutoDecompress() {
        return this.mRequestParam.autoDecomp;
    }

    public IDownloadManager setConcurrence(int i) {
        this.mRequestParam.concurrence = i;
        return this;
    }

    public int getConcurrence() {
        return this.mRequestParam.concurrence;
    }

    public IDownloadManager setMaxRetry(int i) {
        this.mRequestParam.maxRetry = i;
        return this;
    }

    public int getMaxRetry() {
        return this.mRequestParam.maxRetry;
    }

    public IDownloadManager setReadTimeout(int i) {
        this.mRequestParam.readTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.mRequestParam.readTimeout;
    }

    public IDownloadManager setConnTimeout(int i) {
        this.mRequestParam.connTimeout = i;
        return this;
    }

    public int getConnTimeout() {
        return this.mRequestParam.connTimeout;
    }

    public IDownloadManager setBackoffPolicy(IBackoffPolicy iBackoffPolicy) {
        this.mRequestParam.bfpolicy = iBackoffPolicy;
        return this;
    }

    public IDownloadManager setCallback(DownloadCallback downloadCallback) {
        this.mRequestParam.callback = downloadCallback;
        return this;
    }

    public boolean start(String str, DownloadCallback downloadCallback) {
        return start(str, 1, downloadCallback);
    }

    public boolean start(String str, int i, DownloadCallback downloadCallback) {
        return start(str, (String) null, i, downloadCallback);
    }

    public boolean start(String str, String str2, DownloadCallback downloadCallback) {
        return start(str, str2, true, 1, downloadCallback);
    }

    public boolean start(String str, String str2, int i, DownloadCallback downloadCallback) {
        return start(str, str2, true, i, downloadCallback);
    }

    public boolean start(String str, boolean z, DownloadCallback downloadCallback) {
        return start(str, z, 1, downloadCallback);
    }

    public boolean start(String str, boolean z, int i, DownloadCallback downloadCallback) {
        return start(str, null, z, i, downloadCallback);
    }

    public boolean start(String str, String str2, boolean z, DownloadCallback downloadCallback) {
        return start(str, str2, z, 1, downloadCallback);
    }

    public boolean start(String str, String str2, boolean z, int i, DownloadCallback downloadCallback) {
        return start(str, str2, z, i, 0, 0, 0, DEF_BF_POLICY, downloadCallback);
    }

    public boolean start(String str, String str2, boolean z, int i, int i2, int i3, IBackoffPolicy iBackoffPolicy, DownloadCallback downloadCallback) {
        return start(str, str2, z, 1, i, i2, i3, iBackoffPolicy, downloadCallback);
    }

    public boolean start(String str, String str2, boolean z, int i, int i2, int i3, int i4, IBackoffPolicy iBackoffPolicy, DownloadCallback downloadCallback) {
        if (State.Downloading == this.mState || State.Paused == this.mState) {
            return false;
        }
        if (this.mGroupTask != null) {
            throw new RuntimeException("A group download task exists as you start a single download task.");
        }
        HttpContext httpContext = new HttpContext();
        this.mManager = new HttpManager(httpContext);
        HttpRequest request = httpContext.getRequest();
        request.setUrl(str);
        request.setMethod(HTTP_METHOD.GET);
        request.setDestPath(str2);
        request.setAutoDecompress(z);
        request.setMaxRetry(i2);
        request.setReadTimeout(i3);
        request.setConnTimeout(i4);
        request.setConcurrence(i);
        request.setBackoffPolicy(iBackoffPolicy);
        this.mCallback = downloadCallback;
        if (this.mTask != null && !this.mTask.isCancelled()) {
            this.mTask.cancel();
            this.mManager.getContext().getResponse().isCancel = false;
            this.mManager.getContext().getResponse().cancelable.mCanceled = false;
        }
        this.mTask = getDownloadTask();
        this.mTask.execute(this.mManager);
        this.mState = State.Downloading;
        if (this.mCallback == null) {
            return true;
        }
        this.mCallback.onStart();
        return true;
    }

    public boolean pause() {
        if (State.Downloading == this.mState) {
            if (this.mTask != null && this.mGroupTask == null) {
                this.mTask.cancel();
                this.mState = State.Paused;
                return true;
            } else if (this.mGroupTask != null && this.mTask == null) {
                this.mGroupTask.cancel();
                this.mState = State.Paused;
                return true;
            } else if (!(this.mTask == null || this.mGroupTask == null)) {
                throw new RuntimeException("Single download and group download exist at the same time.");
            }
        }
        return false;
    }

    public boolean resume() {
        if (State.Paused == this.mState) {
            if (this.mManager != null && this.mManagers.isEmpty()) {
                if (this.mTask != null && !this.mTask.isCancelled()) {
                    this.mTask.cancel();
                }
                this.mManager.getContext().getResponse().isCancel = false;
                this.mManager.getContext().getResponse().cancelable.mCanceled = false;
                this.mTask = getDownloadTask();
                this.mTask.execute(this.mManager);
                this.mState = State.Downloading;
                if (this.mCallback != null) {
                    this.mCallback.onResume();
                }
                return true;
            } else if (!this.mManagers.isEmpty() && this.mManager == null) {
                if (this.mGroupTask != null && !this.mGroupTask.isCancelled()) {
                    this.mGroupTask.cancel();
                }
                for (HttpManager context : this.mManagers) {
                    context.getContext().getResponse().isCancel = false;
                }
                this.mGroupTask = getGroupDownloadTask();
                this.mGroupTask.execute(this.mManagers);
                this.mState = State.Downloading;
                if (this.mCallback != null) {
                    this.mCallback.onResume();
                }
                return true;
            } else if (!this.mManagers.isEmpty() && this.mManager != null) {
                throw new RuntimeException("Single download and group download exist at the same time.");
            }
        }
        return false;
    }

    public boolean stop() {
        if (State.Downloading == this.mState || State.Paused == this.mState) {
            if (this.mTask != null && this.mGroupTask == null) {
                this.mTask.cancel();
                this.mTask = null;
                this.mManager = null;
                this.mState = State.Stopped;
                this.mRequestParam.url = null;
                this.mRequestParam.destPath = null;
                this.mRequestParam.autoDecomp = true;
                this.mRequestParam.concurrence = 1;
                this.mRequestParam.maxRetry = 0;
                this.mRequestParam.readTimeout = 0;
                this.mRequestParam.connTimeout = 0;
                this.mRequestParam.callback = null;
                this.mRequestParam.bfpolicy = null;
                return true;
            } else if (this.mGroupTask != null && this.mTask == null) {
                this.mGroupTask.cancel();
                this.mGroupTask = null;
                this.mManagers.clear();
                this.mState = State.Stopped;
                this.mRequestParam.urls.clear();
                this.mRequestParam.urls = null;
                this.mRequestParam.autoDecomp = true;
                this.mRequestParam.concurrence = 1;
                this.mRequestParam.maxRetry = 0;
                this.mRequestParam.readTimeout = 0;
                this.mRequestParam.connTimeout = 0;
                this.mRequestParam.callback = null;
                this.mRequestParam.bfpolicy = null;
                return true;
            } else if (!(this.mTask == null || this.mGroupTask == null)) {
                throw new RuntimeException("Single download and group download exist at the same time.");
            }
        }
        return false;
    }

    public State currentState() {
        return this.mState;
    }

    private DownloadTask getDownloadTask() {
        HttpRequest request = this.mManager.getContext().getRequest();
        String genKey = genKey(request.getUrl());
        int concurrence = request.getConcurrence();
        LAsyncTask searchTask = DownloadTask.searchTask(genKey);
        if (searchTask != null && LAsyncTaskStatus.RUNNING == searchTask.getStatus()) {
            searchTask.cancel();
            DownloadTask.removeAllTask(LAsyncTaskTags.TAG_DOWNLOAD, genKey);
        }
        return new DownloadTask(genKey, concurrence);
    }

    private GroupDownloadTask getGroupDownloadTask() {
        StringBuilder sb = new StringBuilder();
        for (HttpManager context : this.mManagers) {
            sb.append(context.getContext().getRequest().getUrl()).append("; ");
        }
        String genKey = genKey(sb.toString());
        int i = this.mRequestParam.concurrence;
        LAsyncTask searchTask = GroupDownloadTask.searchTask(genKey);
        if (searchTask != null && LAsyncTaskStatus.RUNNING == searchTask.getStatus()) {
            searchTask.cancel();
            DownloadTask.removeAllTask(LAsyncTaskTags.TAG_DOWNLOAD, genKey);
        }
        return new GroupDownloadTask(genKey, i);
    }

    private static final String genKey(String str) {
        return Common.md5(str);
    }
}
