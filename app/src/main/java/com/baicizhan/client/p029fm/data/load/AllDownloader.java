//package com.baicizhan.client.p029fm.data.load;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.os.AsyncTask;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.util.FmUtil;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.Executor;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
///* renamed from: com.baicizhan.client.fm.data.load.AllDownloader */
//public class AllDownloader {
//    public static final int ERR_NETWORKS = -4;
//    public static final int ERR_NOWORDS = -2;
//    public static final int ERR_OFFLINE = -1;
//    public static final int ERR_USR_CANCEL = -3;
//    private static final int KEEP_ALIVE = 0;
//    private static final int MSG_FAILED = 1;
//    private static final int MSG_PROGRESS = 0;
//    public static final int NO_ERR = 0;
//    private static final int POOL_SIZE = 4;
//    private static final int STATE_DOWNLOADING = 2;
//    private static final int STATE_INITING = 1;
//    private static final int STATE_STOPPED = 0;
//    /* access modifiers changed from: private */
//    public static final String sHome = PathUtil.getBaicizhanAppRoot();
//    private Context mContext;
//    AllDownloaderCreator mCreator;
//    volatile boolean mDownLoadHigh = false;
//    private DownloadHandler mDownloadHandler;
//    private List<SegDownloadTask> mDownloadTasks = new ArrayList(4);
//    /* access modifiers changed from: private */
//    public int mDownloaded;
//    /* access modifiers changed from: private */
//    public int mErrCode = 0;
//    OnAllDownloadListener mListener;
//    List<WordMediaRecord> mMediaRecords;
//    /* access modifiers changed from: private */
//    public boolean mMobileCapable = true;
//    private int mState = 0;
//    private Executor mThreadPoolExecutor;
//    private final UnDownloadedMediasGetter mUnDownloadedMediasGetter;
//    private List<WordMediaRecord> mUndndMediaRecords;
//    private final String mUrlHost;
//    private final String mUrlHostCand;
//    List<String> mWordIds;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloader$DownloadHandler */
//    class DownloadHandler extends Handler {
//        final WeakReference<AllDownloader> mDownloader;
//
//        DownloadHandler(AllDownloader allDownloader) {
//            super(Looper.getMainLooper());
//            this.mDownloader = new WeakReference<>(allDownloader);
//        }
//
//        public void handleMessage(Message message) {
//            AllDownloader allDownloader = (AllDownloader) this.mDownloader.get();
//            if (allDownloader != null) {
//                switch (message.what) {
//                    case 0:
//                        if (allDownloader.isDownloading()) {
//                            allDownloader.mDownloaded = allDownloader.mDownloaded + 1;
//                            if (allDownloader.mDownloaded >= allDownloader.mMediaRecords.size()) {
//                                if (allDownloader.mListener != null) {
//                                    allDownloader.mErrCode = 0;
//                                    allDownloader.mListener.onAllDownloaded(true, allDownloader.mErrCode);
//                                    allDownloader.reset();
//                                    return;
//                                }
//                                return;
//                            } else if (allDownloader.mListener != null) {
//                                allDownloader.mListener.onAllDownloadProgress((allDownloader.mDownloaded * 100) / allDownloader.mMediaRecords.size(), allDownloader.mDownloaded, allDownloader.mMediaRecords.size());
//                                return;
//                            } else {
//                                return;
//                            }
//                        } else {
//                            return;
//                        }
//                    case 1:
//                        allDownloader.cancelDownload();
//                        if (allDownloader.mListener != null) {
//                            allDownloader.mErrCode = -4;
//                            allDownloader.mListener.onAllDownloaded(false, allDownloader.mErrCode);
//                            allDownloader.reset();
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloader$OnAllDownloadListener */
//    public interface OnAllDownloadListener {
//        void onAllDownloadInited(int i, int i2, int i3);
//
//        void onAllDownloadProgress(int i, int i2, int i3);
//
//        void onAllDownloaded(boolean z, int i);
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloader$SegDownloadTask */
//    class SegDownloadTask extends AsyncTask<List<WordMediaRecord>, Void, Boolean> {
//        transient boolean mCanceling = false;
//        final String mHost;
//
//        SegDownloadTask(String str) {
//            this.mHost = str;
//        }
//
//        /* access modifiers changed from: protected */
//        public Boolean doInBackground(List<WordMediaRecord>... listArr) {
//            if (listArr == null || listArr.length == 0) {
//                return Boolean.valueOf(false);
//            }
//            List<WordMediaRecord> list = listArr[0];
//            if (list == null || list.isEmpty()) {
//                return Boolean.valueOf(false);
//            }
//            SyncDownloadManager build = new Builder().build();
//            Iterator it = list.iterator();
//            while (true) {
//                if (!it.hasNext()) {
//                    break;
//                }
//                WordMediaRecord wordMediaRecord = (WordMediaRecord) it.next();
//                if (this.mCanceling) {
//                    Log.d("whiz", "download fm cancelled, thread # " + Thread.currentThread().getId());
//                    super.cancel(true);
//                    break;
//                }
//                String fmpath = AllDownloader.this.downloadHigh() ? wordMediaRecord.getHighfmpath() : wordMediaRecord.getFmpath();
//                String str = this.mHost + fmpath;
//                String reformFmPath = FmUtil.reformFmPath(AllDownloader.sHome + fmpath);
//                build.setUrl(str);
//                build.setDestPath(reformFmPath);
//                if (!build.start()) {
//                    C0789L.log.error("download fm failed, url [{}], errCode [{}]", (Object) str, (Object) Integer.valueOf(build.getResCode()));
//                    AllDownloader.this.sendFailed();
//                    return Boolean.valueOf(false);
//                }
//                AllDownloader.this.sendProgress();
//            }
//            return Boolean.valueOf(true);
//        }
//
//        public void cancel() {
//            this.mCanceling = true;
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloader$UnDownloadedMediasGetter */
//    class UnDownloadedMediasGetter extends AllDownloaderHandler {
//        final WeakReference<AllDownloader> mDownloader;
//
//        UnDownloadedMediasGetter(AllDownloader allDownloader) {
//            this.mDownloader = new WeakReference<>(allDownloader);
//        }
//
//        public void onGetUnDownloadedMedias(int i, List<WordMediaRecord> list, Object obj) {
//            AllDownloader allDownloader = (AllDownloader) this.mDownloader.get();
//            if (allDownloader != null) {
//                allDownloader.onGetUnDownloadedMedias(i, list);
//            }
//        }
//    }
//
//    AllDownloader(Context context, AllDownloaderCreator allDownloaderCreator) {
//        this.mContext = context;
//        this.mCreator = allDownloaderCreator;
//        this.mUrlHost = hostFromCheckInfo();
//        this.mUrlHostCand = hostCandFromCheckInfo();
//        this.mUnDownloadedMediasGetter = new UnDownloadedMediasGetter(this);
//        this.mDownloadHandler = new DownloadHandler(this);
//    }
//
//    public void setDownLoadHigh(boolean z) {
//        this.mDownLoadHigh = z;
//    }
//
//    public int getTotalSize() {
//        if (this.mWordIds == null) {
//            return 0;
//        }
//        return this.mWordIds.size();
//    }
//
//    public boolean isPrepared() {
//        return this.mMediaRecords != null && !this.mMediaRecords.isEmpty();
//    }
//
//    public void init() {
//        if (this.mState == 0) {
//            this.mState |= 1;
//            doinit();
//        }
//    }
//
//    private void doinit() {
//        if (isPrepared()) {
//            this.mUnDownloadedMediasGetter.getUnDownloadedMedias(0, this.mMediaRecords, null);
//        } else {
//            this.mCreator.getFmInfos(this);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onGetFmInfos(List<WordMediaRecord> list) {
//        this.mMediaRecords = list;
//        if (!isPrepared()) {
//            if (this.mListener != null) {
//                this.mListener.onAllDownloadInited(0, 0, 0);
//            }
//            if (isDownloading() && this.mListener != null) {
//                this.mListener.onAllDownloaded(false, -2);
//            }
//            reset();
//            return;
//        }
//        this.mUnDownloadedMediasGetter.getUnDownloadedMedias(0, this.mMediaRecords, null);
//    }
//
//    public void download() {
//        if (!isDownloading()) {
//            if (isIniting()) {
//                this.mState |= 2;
//                return;
//            }
//            init();
//            this.mState |= 3;
//        }
//    }
//
//    public void cancel() {
//        if (isDownloading()) {
//            resetDownloading();
//        }
//        cancelDownload();
//    }
//
//    public boolean isIniting() {
//        return (this.mState & 1) == 1;
//    }
//
//    public boolean isDownloading() {
//        return (this.mState & 2) == 2;
//    }
//
//    private void resetIniting() {
//        this.mState ^= 1;
//    }
//
//    private void resetDownloading() {
//        this.mState ^= 2;
//    }
//
//    public void reset() {
//        this.mState = 0;
//    }
//
//    public boolean hasDownloaded() {
//        if (isPrepared() && this.mDownloaded == this.mMediaRecords.size()) {
//            return true;
//        }
//        return false;
//    }
//
//    public void destroy() {
//        this.mUnDownloadedMediasGetter.destroy();
//        this.mContext = null;
//    }
//
//    /* access modifiers changed from: private */
//    public boolean downloadHigh() {
//        if (NetworkUtils.getActiveNetworkType(this.mContext) == 0) {
//            return true;
//        }
//        return this.mDownLoadHigh;
//    }
//
//    private void doDownload() {
//        String string = null;
//        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
//            this.mErrCode = -1;
//            if (this.mListener != null) {
//                this.mListener.onAllDownloaded(false, this.mErrCode);
//            }
//        } else if (this.mMediaRecords == null || this.mMediaRecords.isEmpty()) {
//            this.mErrCode = -2;
//            if (this.mListener != null) {
//                this.mListener.onAllDownloaded(false, this.mErrCode);
//            }
//        } else {
//            if (this.mUndndMediaRecords != null) {
//                this.mDownloaded = this.mMediaRecords.size() - this.mUndndMediaRecords.size();
//                if (this.mListener != null) {
//                    this.mListener.onAllDownloadProgress((this.mDownloaded * 100) / this.mMediaRecords.size(), this.mDownloaded, this.mMediaRecords.size());
//                }
//                if (this.mDownloaded == this.mMediaRecords.size()) {
//                    this.mErrCode = 0;
//                    if (this.mListener != null) {
//                        this.mListener.onAllDownloaded(true, this.mErrCode);
//                        return;
//                    }
//                    return;
//                }
//            }
//            switch (NetworkUtils.getActiveNetworkType(this.mContext)) {
//                case 0:
//                    this.mErrCode = 0;
//                    startDownload();
//                    return;
//                case 1:
//                case 2:
//                case 3:
//                    int size = this.mUndndMediaRecords.size();
//                    int i = (int) (0.05f * ((float) size));
//                    int i2 = (int) (0.15f * ((float) size));
////                    if (this.mDownLoadHigh) {
////                        string = this.mContext.getString(R.string.fm_load_warn_msg_downall_mobile_high, new Object[]{Integer.valueOf(size), Integer.valueOf(i2)});
////                    } else {
////                        string = this.mContext.getString(R.string.fm_load_warn_msg_downall_mobile_low, new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
////                    }
//                    BczDialog.Builder builder = new BczDialog.Builder(this.mContext);
//                    builder.setTitle(R.string.fm_load_warn_title).setMessage((CharSequence) string).setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            AllDownloader.this.mErrCode = -3;
//                            if (AllDownloader.this.mListener != null) {
//                                AllDownloader.this.mListener.onAllDownloaded(false, AllDownloader.this.mErrCode);
//                            }
//                            AllDownloader.this.mMobileCapable = false;
//                        }
//                    }).setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            AllDownloader.this.startDownload();
//                            AllDownloader.this.mMobileCapable = true;
//                        }
//                    });
//                    BczDialog create = builder.create();
//                    create.setCanceledOnTouchOutside(false);
//                    create.setCancelable(false);
//                    create.show();
//                    return;
//                default:
//                    this.mErrCode = -1;
//                    if (this.mListener != null) {
//                        this.mListener.onAllDownloaded(false, this.mErrCode);
//                        return;
//                    }
//                    return;
//            }
//        }
//    }
//
//    private static String hostFromCheckInfo() {
//        return FmUtil.getDataDns();
//    }
//
//    private static String hostCandFromCheckInfo() {
//        return FmUtil.getCandDataDns();
//    }
//
//    /* access modifiers changed from: private */
//    public void onGetUnDownloadedMedias(int i, List<WordMediaRecord> list) {
//        this.mUndndMediaRecords = list;
//        if (this.mUndndMediaRecords != null) {
//            this.mDownloaded = this.mMediaRecords.size() - this.mUndndMediaRecords.size();
//        }
//        if (this.mListener != null) {
//            this.mListener.onAllDownloadInited((this.mDownloaded * 100) / this.mMediaRecords.size(), this.mDownloaded, this.mMediaRecords.size());
//        }
//        if (isDownloading()) {
//            resetIniting();
//            doDownload();
//            return;
//        }
//        reset();
//    }
//
//    /* access modifiers changed from: private */
//    public void startDownload() {
//        int size = this.mUndndMediaRecords.size();
//        if (size != 0) {
//            this.mThreadPoolExecutor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactory() {
//                private final AtomicInteger mCount = new AtomicInteger(1);
//
//                public Thread newThread(Runnable runnable) {
//                    return new Thread(runnable, "SegDownloadTask #" + this.mCount.getAndIncrement());
//                }
//            });
//            int min = Math.min(4, size);
//            int i = size / min;
//            this.mDownloadTasks.clear();
//            int i2 = 0;
//            while (i2 < min) {
//                List subList = this.mUndndMediaRecords.subList(i2 * i, i2 == min + -1 ? size : (i2 + 1) * i);
//                SegDownloadTask segDownloadTask = new SegDownloadTask(i2 % 2 == 0 ? this.mUrlHost : this.mUrlHostCand);
//                segDownloadTask.executeOnExecutor(this.mThreadPoolExecutor, new List[]{subList});
//                this.mDownloadTasks.add(segDownloadTask);
//                i2++;
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void cancelDownload() {
//        for (SegDownloadTask cancel : this.mDownloadTasks) {
//            cancel.cancel();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void sendProgress() {
//        this.mDownloadHandler.sendEmptyMessage(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void sendFailed() {
//        this.mDownloadHandler.sendEmptyMessage(1);
//    }
//}
