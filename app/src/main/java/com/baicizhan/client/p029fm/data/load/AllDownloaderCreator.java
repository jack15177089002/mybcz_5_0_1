//package com.baicizhan.client.p029fm.data.load;
//
//import android.content.Context;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader.OnWordMediaLoaderListener;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.load.AllDownloader.OnAllDownloadListener;
//import com.baicizhan.client.p029fm.data.load.FmListLoader.OnFmListLoadListener;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderCreator */
//public class AllDownloaderCreator implements OnWordMediaLoaderListener {
//    public static final int ERR_NETWORKS = -1;
//    public static final int ERR_NODATA = -2;
//    public static final int NO_ERR = 0;
//    /* access modifiers changed from: private */
//    public OnAllDownloadListener mAllDownloadListener;
//    /* access modifiers changed from: private */
//    public boolean mAutoDestroy;
//    /* access modifiers changed from: private */
//    public int mBookid;
//    private Context mContext;
//    /* access modifiers changed from: private */
//    public boolean mDownloadHigh;
//    /* access modifiers changed from: private */
//    public OnAllDownloaderCreateListener mListener;
//    /* access modifiers changed from: private */
//    public List<WordMediaRecord> mMediaRecords;
//    /* access modifiers changed from: private */
//    public List<String> mWordIds;
//    private FmListLoader mWordIdsGetter;
//    private WordIdsGetterListener mWordIdsGetterListener;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderCreator$Builder */
//    public static class Builder {
//        private OnAllDownloadListener mAllDownloadListener;
//        private boolean mAutoDestroy = false;
//        private int mBookid;
//        private Context mContext;
//        private boolean mDownloadHigh = false;
//        private OnAllDownloaderCreateListener mListener;
//
//        public Builder with(Context context) {
//            this.mContext = context;
//            return this;
//        }
//
//        public Builder autoDestroy(boolean z) {
//            this.mAutoDestroy = z;
//            return this;
//        }
//
//        public Builder downloadHigh(boolean z) {
//            this.mDownloadHigh = z;
//            return this;
//        }
//
//        public Builder setBookid(int i) {
//            this.mBookid = i;
//            return this;
//        }
//
//        public Builder setCreateCallback(OnAllDownloaderCreateListener onAllDownloaderCreateListener) {
//            this.mListener = onAllDownloaderCreateListener;
//            return this;
//        }
//
//        public Builder setDownloadCallback(OnAllDownloadListener onAllDownloadListener) {
//            this.mAllDownloadListener = onAllDownloadListener;
//            return this;
//        }
//
//        public AllDownloaderCreator build() {
//            AllDownloaderCreator allDownloaderCreator = new AllDownloaderCreator(this.mContext);
//            allDownloaderCreator.mAutoDestroy = this.mAutoDestroy;
//            allDownloaderCreator.mDownloadHigh = this.mDownloadHigh;
//            allDownloaderCreator.mBookid = this.mBookid;
//            allDownloaderCreator.mListener = this.mListener;
//            allDownloaderCreator.mAllDownloadListener = this.mAllDownloadListener;
//            this.mContext = null;
//            return allDownloaderCreator;
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderCreator$OnAllDownloaderCreateListener */
//    public interface OnAllDownloaderCreateListener {
//        void onAllDownloaderCreate(AllDownloader allDownloader, int i);
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderCreator$WordIdsGetterListener */
//    class WordIdsGetterListener implements OnFmListLoadListener {
//        final WeakReference<AllDownloaderCreator> mCreator;
//
//        WordIdsGetterListener(AllDownloaderCreator allDownloaderCreator) {
//            this.mCreator = new WeakReference<>(allDownloaderCreator);
//        }
//
//        public void onGetFmList(FmList fmList, FmMidList fmMidList, Object obj) {
//        }
//
//        public void onGetWordIds(List<String> list, List<WordMediaRecord> list2, Object obj) {
//            AllDownloaderCreator allDownloaderCreator = (AllDownloaderCreator) this.mCreator.get();
//            if (allDownloaderCreator != null) {
//                if (list != null && !list.isEmpty()) {
//                    allDownloaderCreator.mWordIds = list;
//                }
//                if (list2 != null && !list2.isEmpty()) {
//                    allDownloaderCreator.mMediaRecords = list2;
//                }
//                allDownloaderCreator.notifyCallback(null);
//            }
//        }
//
//        public void onGetFmInfos(List<WordMediaRecord> list, Object obj) {
//            AllDownloaderCreator allDownloaderCreator = (AllDownloaderCreator) this.mCreator.get();
//            if (allDownloaderCreator != null) {
//                if (list != null && !list.isEmpty()) {
//                    allDownloaderCreator.mMediaRecords = list;
//                }
//                allDownloaderCreator.notifyCallback((AllDownloader) obj);
//            }
//        }
//    }
//
//    public boolean isAlive() {
//        return this.mContext != null;
//    }
//
//    private AllDownloaderCreator(Context context) {
//        this.mAutoDestroy = false;
//        this.mDownloadHigh = false;
//        this.mBookid = -1;
//        this.mWordIds = new ArrayList();
//        this.mContext = context;
//        this.mWordIdsGetterListener = new WordIdsGetterListener(this);
//        this.mWordIdsGetter = FmListLoader.born(context).setListener(this.mWordIdsGetterListener);
//    }
//
//    public void create() {
//        this.mWordIdsGetter.getWordIds(this.mBookid, null);
//    }
//
//    public void onUpdated(boolean z, int i) {
//    }
//
//    public void onInserted(boolean z, int i, List<WordMediaRecord> list) {
//    }
//
//    public void onMidRefreshed(boolean z, int i) {
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void getFmInfos(AllDownloader allDownloader) {
//        if (this.mWordIdsGetter != null) {
//            this.mWordIdsGetter.getFmInfos(this.mBookid, allDownloader);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyCallback(AllDownloader allDownloader) {
//        if (allDownloader != null) {
//            allDownloader.onGetFmInfos(this.mMediaRecords);
//        } else if (this.mListener != null) {
//            AllDownloader allDownloader2 = new AllDownloader(this.mContext, this);
//            allDownloader2.mWordIds = this.mWordIds;
//            allDownloader2.mMediaRecords = this.mMediaRecords;
//            allDownloader2.mDownLoadHigh = this.mDownloadHigh;
//            allDownloader2.mListener = this.mAllDownloadListener;
//            if (this.mWordIds == null || this.mWordIds.isEmpty()) {
//                this.mListener.onAllDownloaderCreate(allDownloader2, -2);
//            } else {
//                this.mListener.onAllDownloaderCreate(allDownloader2, 0);
//            }
//        }
//    }
//
//    private void tryDestroy() {
//        if (this.mAutoDestroy) {
//            destroy();
//        }
//    }
//
//    public void destroy() {
//        this.mContext = null;
//    }
//}
