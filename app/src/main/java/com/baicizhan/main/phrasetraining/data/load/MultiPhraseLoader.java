//package com.baicizhan.main.phrasetraining.data.load;
//
//import android.content.res.AssetManager;
//import android.util.Log;
//import java.util.Iterator;
//import java.util.List;
//
//public class MultiPhraseLoader implements IPhraseLoader {
//    /* access modifiers changed from: private */
//    public PLContext mContext;
//    /* access modifiers changed from: private */
//    public PhraseDownloader mDownloader;
//    /* access modifiers changed from: private */
//    public OnMultiPhraseLoadListener mListener;
//
//    public class Builder {
//        private AssetManager mAM;
//        private List<Integer> mGroupIds;
//        private OnMultiPhraseLoadListener mListener;
//
//        public Builder setGroupIds(List<Integer> list) {
//            this.mGroupIds = list;
//            return this;
//        }
//
//        public Builder setAssetManager(AssetManager assetManager) {
//            this.mAM = assetManager;
//            return this;
//        }
//
//        public Builder setCallback(OnMultiPhraseLoadListener onMultiPhraseLoadListener) {
//            this.mListener = onMultiPhraseLoadListener;
//            return this;
//        }
//
//        public MultiPhraseLoader build() {
//            MultiPhraseLoader multiPhraseLoader = new MultiPhraseLoader();
//            multiPhraseLoader.mContext.mAM = this.mAM;
//            multiPhraseLoader.mContext.mGroupIds = this.mGroupIds;
//            multiPhraseLoader.mContext.mCallback = multiPhraseLoader;
//            multiPhraseLoader.mListener = this.mListener;
//            multiPhraseLoader.mDownloader = new PhraseDownloader(multiPhraseLoader.mContext);
//            return multiPhraseLoader;
//        }
//    }
//
//    public interface OnMultiPhraseLoadListener {
//        void onMultiCancelled();
//
//        void onMultiLoadInited(int i, float f, float f2);
//
//        void onMultiLoadProgress(int i, float f, float f2);
//
//        void onMultiLoaded(boolean z, int i);
//    }
//
//    private MultiPhraseLoader() {
//        this.mContext = new PLContext();
//    }
//
//    public void init() {
//        this.mDownloader.init();
//    }
//
//    public void load() {
//        this.mDownloader.download();
//    }
//
//    public void cancel() {
//        this.mDownloader.cancel();
//    }
//
//    public boolean isCancelled() {
//        return this.mDownloader.isCancelled();
//    }
//
//    public void reset() {
//        this.mDownloader.reset();
//    }
//
//    public void setGroupIds(List<Integer> list) {
//        if (this.mContext.mGroupIds == list) {
//            this.mDownloader.mNewDownload = false;
//        } else if (list == null || this.mContext.mGroupIds == null || list.size() != this.mContext.mGroupIds.size()) {
//            this.mDownloader.mNewDownload = true;
//            this.mContext.mGroupIds = list;
//        } else {
//            Iterator it = list.iterator();
//            int i = 0;
//            while (it.hasNext() && ((Integer) this.mContext.mGroupIds.get(i)).intValue() == ((Integer) it.next()).intValue()) {
//                i++;
//            }
//            this.mDownloader.mNewDownload = false;
//        }
//    }
//
//    public void setAssetManager(AssetManager assetManager) {
//        this.mContext.mAM = assetManager;
//    }
//
//    public void setCallback(OnMultiPhraseLoadListener onMultiPhraseLoadListener) {
//        this.mListener = onMultiPhraseLoadListener;
//    }
//
//    public void onLoadInited(int i, float f, float f2) {
//        if (this.mListener != null) {
//            this.mListener.onMultiLoadInited(i, f, f2);
//        }
//    }
//
//    public void onLoadProgress(int i, float f, float f2) {
//        if (this.mListener != null) {
//            this.mListener.onMultiLoadProgress(i, f, f2);
//            Log.d("whiz", "on multi load progress: " + i + "; completed: " + f + "; total: " + f2);
//        }
//    }
//
//    public void onLoaded(boolean z, int i) {
//        if (this.mListener != null) {
//            this.mListener.onMultiLoaded(z, i);
//            Log.d("whiz", "on multi loaded: " + z + "; code: " + i);
//        }
//    }
//
//    public void onCancelled() {
//        if (this.mListener != null) {
//            this.mListener.onMultiCancelled();
//        }
//    }
//}
