//package com.baicizhan.client.p029fm.data.load;
//
//import android.util.Log;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.DownloadManager;
//import com.baicizhan.client.p029fm.FmAppHandler;
//import com.baicizhan.client.p029fm.data.ITargetList;
//import com.baicizhan.client.p029fm.util.FmUtil;
//
///* renamed from: com.baicizhan.client.fm.data.load.FmLoader */
//public class FmLoader<T extends ITargetList> {
//    private static final int DEF_MAX_BUFFER_SIZE = 10;
//    public static final int LOAD_DOWNLOAD_FAILED = -2;
//    public static final int LOAD_NO_FM = -1;
//    public static final int LOAD_SUCCESS = 0;
//    private static final int WIFI_MAX_BUFFER_SIZE = 10;
//    private static final int _2G_MAX_BUFFER_SIZE = 2;
//    private static final int _3G_MAX_BUFFER_SIZE = 3;
//    private static final int _4G_MAX_BUFFER_SIZE = 5;
//    private int mBufferSize;
//    private int mCrawlIndex;
//    private final Downloader mDownloader = new Downloader(this);
//    private OnFmLoadListener mListener;
//    boolean mLoadHigh = false;
//    private int mMaxBufferSize = 10;
//    T mTargets;
//    final String mUrlHost = hostFromCheckInfo();
//    final String mUrlHostCand = hostCandFromCheckInfo();
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmLoader$OnFmLoadListener */
//    public interface OnFmLoadListener {
//        void onIdle();
//
//        void onLoaded(boolean z, int i, String str, String str2);
//    }
//
//    FmLoader() {
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
//    public T getTargets() {
//        return this.mTargets;
//    }
//
//    public void setLoadHigh(boolean z) {
//        Log.d("whiz", "fm download high: " + z);
//        this.mLoadHigh = z;
//    }
//
//    public boolean hasOfflineFms() {
//        if (this.mTargets == null || this.mTargets.isEmpty()) {
//            return false;
//        }
//        int size = this.mTargets.size();
//        for (int i = 0; i < size; i++) {
//            if (this.mTargets.getLocalPath(i) != null) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void extractOfflineFms() {
//        if (this.mTargets != null) {
//            this.mTargets.extractOfflines();
//        }
//    }
//
//    private void adjustMaxBufferSize() {
//        switch (NetworkUtils.getActiveNetworkType(FmAppHandler.getApp())) {
//            case -1:
//            case 3:
//                this.mMaxBufferSize = 2;
//                return;
//            case 1:
//                this.mMaxBufferSize = 5;
//                return;
//            case 2:
//                this.mMaxBufferSize = 3;
//                return;
//            default:
//                this.mMaxBufferSize = 10;
//                return;
//        }
//    }
//
//    private boolean loadHigh() {
//        if (NetworkUtils.getActiveNetworkType(FmAppHandler.getApp()) == 0) {
//            return true;
//        }
//        return this.mLoadHigh;
//    }
//
//    public void load(int i, OnFmLoadListener onFmLoadListener) {
//        this.mCrawlIndex = i;
//        this.mBufferSize = 0;
//        cancel();
//        load(onFmLoadListener);
//    }
//
//    public void load(OnFmLoadListener onFmLoadListener) {
//        this.mListener = onFmLoadListener;
//        if (this.mTargets != null && !this.mTargets.isEmpty()) {
//            adjustMaxBufferSize();
//            int size = this.mTargets.size();
//            if (this.mCrawlIndex >= size) {
//                this.mCrawlIndex = 0;
//            }
//            boolean loadHigh = loadHigh();
//            int i = this.mCrawlIndex;
//            int i2 = 0;
//            while (i2 <= 0) {
//                String localPath = this.mTargets.getLocalPath(i);
//                if (localPath != null) {
//                    this.mBufferSize++;
//                    if (this.mListener != null) {
//                        this.mListener.onLoaded(true, 0, localPath, null);
//                    }
//                } else {
//                    DownloadManager downloadManager = new DownloadManager();
//                    downloadManager.setUrl(this.mUrlHost + this.mTargets.getPath(i, loadHigh)).setDestPath(this.mTargets.getSavedPath(i, loadHigh));
//                    this.mDownloader.mDLManagers.add(downloadManager);
//                }
//                i2++;
//                this.mCrawlIndex = (this.mCrawlIndex + 1) % size;
//            }
//            if (this.mDownloader.mDLManagers.isEmpty()) {
//                if (this.mBufferSize < Math.min(this.mMaxBufferSize, this.mTargets.size())) {
//                    load(this.mListener);
//                } else if (this.mListener != null) {
//                    this.mListener.onIdle();
//                }
//            } else {
//                this.mDownloader.download();
//            }
//        } else if (this.mListener != null) {
//            this.mListener.onLoaded(false, -1, null, null);
//        }
//    }
//
//    public void cancel() {
//        this.mDownloader.cancel();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onDownloaded(boolean z, String str, String str2) {
//        if (z) {
//            this.mBufferSize++;
//        }
//        if (this.mListener != null) {
//            this.mListener.onLoaded(z, z ? 0 : -2, str, str2);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onTurnFinished() {
//        if (this.mBufferSize < Math.min(this.mMaxBufferSize, this.mTargets.size())) {
//            load(this.mListener);
//        } else if (this.mListener != null) {
//            this.mListener.onIdle();
//        }
//    }
//}
