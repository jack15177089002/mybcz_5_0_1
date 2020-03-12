package com.baicizhan.client.framework.network.http.upload;

import android.os.Handler;
import android.os.Message;
import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.asynctask.LAsyncTaskTags;
import com.baicizhan.client.framework.network.http.ApacheHttpRequest;
import com.baicizhan.client.framework.network.http.HttpContext;
import com.baicizhan.client.framework.network.http.HttpManager;
import com.baicizhan.client.framework.network.http.upload.IUploadManager.UploadCallback;
import com.baicizhan.client.framework.util.Common;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;

public class UploadManager implements IUploadManager {
    private static final int DEF_CONCURRENCE = 1;
    private static final int DEF_CONN_TIMEOUT = 0;
    private static final int DEF_MAX_RETRY = 0;
    private static final int DEF_READ_TIMEOUT = 0;
    /* access modifiers changed from: private */
    public UploadCallback mCallback;
    /* access modifiers changed from: private */
    public UploadHandler mHandler = new UploadHandler(this);
    /* access modifiers changed from: private */
    public HttpManager mManager;
    private RequestParam mRequestParam = new RequestParam();
    /* access modifiers changed from: private */
    public State mState = State.None;
    private UploadTask mTask;

    class RequestParam {
        UploadCallback callback;
        int concurrence;
        int connTimeout;
        int maxRetry;
        LinkedList<BasicNameValuePair> parts;
        int readTimeout;
        String srcPath;
        String url;
        HashMap<String, String> urls;

        private RequestParam() {
            this.urls = new HashMap<>();
            this.parts = new LinkedList<>();
            this.concurrence = 1;
            this.maxRetry = 0;
            this.readTimeout = 0;
            this.connTimeout = 0;
        }
    }

    enum State {
        None,
        Uploading,
        Stopped,
        Successed,
        Failed
    }

    class UploadHandler extends Handler {
        final WeakReference<UploadManager> mUPManager;

        UploadHandler(UploadManager uploadManager) {
            this.mUPManager = new WeakReference<>(uploadManager);
        }

        public void handleMessage(Message message) {
            int i = 100;
            UploadManager uploadManager = (UploadManager) this.mUPManager.get();
            switch (message.what) {
                case 4:
                    int i2 = (message.arg1 * 100) / message.arg2;
                    if (i2 < 0) {
                        i = 0;
                    } else if (i2 <= 100) {
                        i = i2;
                    }
                    if (uploadManager != null && uploadManager.mCallback != null) {
                        uploadManager.mCallback.onProgress(i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    final class UploadTask extends LAsyncTask<HttpManager, Integer, Boolean> {
        UploadTask(String str, int i) {
            setTag(LAsyncTaskTags.TAG_UPLOAD);
            setKey(str);
            parallelTask(i);
        }

        /* access modifiers changed from: protected */
        public final Boolean doInBackground(HttpManager... httpManagerArr) {
            return Boolean.valueOf(httpManagerArr[0].uploadFile(UploadManager.this.mHandler));
        }

        /* access modifiers changed from: protected */
        public final void onPostExecute(Boolean bool) {
            if (UploadManager.this.mManager != null) {
                if (UploadManager.this.mCallback == null) {
                    UploadManager.this.mState = State.None;
                    return;
                }
//                int i = UploadManager.this.mManager.getContext().getApacheHttpResponse().responseCode;
//                if (!bool.booleanValue()) {
//                    if (State.Stopped == UploadManager.this.mState) {
//                        UploadManager.this.mCallback.onStop();
//                    }
//                    UploadManager.this.mState = State.Failed;
//                    UploadManager.this.mCallback.onComplete(false, i);
//                } else if (State.Uploading == UploadManager.this.mState) {
//                    UploadManager.this.mState = State.Successed;
//                    UploadManager.this.mCallback.onProgress(100);
//                    UploadManager.this.mCallback.onComplete(true, i);
//                } else {
//                    throw new IllegalStateException("The upload state is illegal right now. Expect state is: [" + State.Uploading + "], but the actual one is: [" + UploadManager.this.mState + "].");
//                }
            }
        }

        public final void cancel() {
            super.cancel();
//            if (UploadManager.this.mManager != null) {
//                UploadManager.this.mManager.getContext().getApacheHttpResponse().cancelable.mCanceled = true;
//            }
        }

        public final void onCancelled() {
            super.onCancelled();
            if (UploadManager.this.mCallback == null) {
                UploadManager.this.mState = State.None;
            } else if (State.Stopped == UploadManager.this.mState) {
                UploadManager.this.mCallback.onStop();
            }
        }
    }

    public IUploadManager setUrl(String str) {
        this.mRequestParam.url = str;
        return this;
    }

    public IUploadManager addUrl(String str) {
        return addUrl(str, null);
    }

    public IUploadManager addUrl(String str, String str2) {
        this.mRequestParam.urls.put(str, str2);
        return this;
    }

    public IUploadManager setSrcPath(String str) {
        this.mRequestParam.srcPath = str;
        return this;
    }

    public IUploadManager addPart(String str, String str2) {
        this.mRequestParam.parts.add(new BasicNameValuePair(str, str2));
        return this;
    }

    public IUploadManager setConcurrence(int i) {
        this.mRequestParam.concurrence = i;
        return this;
    }

    public IUploadManager setMaxRetry(int i) {
        this.mRequestParam.maxRetry = i;
        return this;
    }

    public IUploadManager setReadTimeout(int i) {
        this.mRequestParam.readTimeout = i;
        return this;
    }

    public IUploadManager setConnTimeout(int i) {
        this.mRequestParam.connTimeout = i;
        return this;
    }

    public IUploadManager setCallback(UploadCallback uploadCallback) {
        this.mRequestParam.callback = uploadCallback;
        return this;
    }

    public boolean start() {
        if (this.mRequestParam.url == null) {
            return false;
        }
        return start(this.mRequestParam.url, this.mRequestParam.srcPath, this.mRequestParam.parts, this.mRequestParam.concurrence, this.mRequestParam.maxRetry, this.mRequestParam.readTimeout, this.mRequestParam.connTimeout, this.mRequestParam.callback);
    }

    private boolean start(String str, String str2, LinkedList<BasicNameValuePair> linkedList, int i, int i2, int i3, int i4, UploadCallback uploadCallback) {
        if (State.Uploading == this.mState) {
            return false;
        }
        HttpContext httpContext = new HttpContext();
        this.mManager = new HttpManager(httpContext);
        ApacheHttpRequest apacheHttpRequest = httpContext.getApacheHttpRequest();
        apacheHttpRequest.setUrl(str);
        apacheHttpRequest.setFile2Upload(str2);
        apacheHttpRequest.addPostData(linkedList);
        apacheHttpRequest.setMaxRetry(i2);
        apacheHttpRequest.setReadTimeout(i3);
        apacheHttpRequest.setConnTimeout(i4);
        apacheHttpRequest.setConcurrence(i);
        this.mCallback = uploadCallback;
//        if (this.mTask != null && !this.mTask.isCancelled()) {
//            this.mTask.cancel();
//            this.mManager.getContext().getApacheHttpResponse().cancelable.mCanceled = false;
//        }
        this.mTask = getUploadTask();
        this.mTask.execute(this.mManager);
        this.mState = State.Uploading;
        if (this.mCallback != null) {
            this.mCallback.onStart();
        }
        return true;
    }

    public boolean stop() {
        if (State.Uploading != this.mState || this.mTask == null) {
            return false;
        }
        this.mTask.cancel();
        this.mTask = null;
        this.mManager = null;
        this.mState = State.Stopped;
        this.mRequestParam.url = null;
        this.mRequestParam.srcPath = null;
        this.mRequestParam.concurrence = 1;
        this.mRequestParam.maxRetry = 0;
        this.mRequestParam.readTimeout = 0;
        this.mRequestParam.connTimeout = 0;
        this.mRequestParam.callback = null;
        return true;
    }

    private UploadTask getUploadTask() {
        ApacheHttpRequest apacheHttpRequest = this.mManager.getContext().getApacheHttpRequest();
        String genKey = genKey(apacheHttpRequest.getUrl());
        int concurrence = apacheHttpRequest.getConcurrence();
        LAsyncTask searchTask = UploadTask.searchTask(genKey);
        if (searchTask != null) {
            searchTask.cancel();
            UploadTask.removeAllTask(LAsyncTaskTags.TAG_UPLOAD, genKey);
        }
        return new UploadTask(genKey, concurrence);
    }

    private static final String genKey(String str) {
        return Common.md5(str);
    }
}
