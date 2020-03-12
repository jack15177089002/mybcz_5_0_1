//package com.baicizhan.main.phrasetraining.data.load;
//
//import android.content.res.AssetManager;
//import android.util.Log;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns;
//import java.util.ArrayList;
//import java.util.Map;
//
//public class SinglePhraseLoader implements IPhraseLoader {
//    /* access modifiers changed from: private */
//    public PLContext mContext;
//    /* access modifiers changed from: private */
//    public PhraseDownloader mDownloader;
//    /* access modifiers changed from: private */
//    public OnPhraseLoadListener mListener;
//
//    public class Builder {
//        private AssetManager mAM;
//        private int mGroupId;
//        private OnPhraseLoadListener mListener;
//
//        public Builder setGroupId(int i) {
//            this.mGroupId = i;
//            return this;
//        }
//
//        public Builder setAssetManager(AssetManager assetManager) {
//            this.mAM = assetManager;
//            return this;
//        }
//
//        public Builder setCallback(OnPhraseLoadListener onPhraseLoadListener) {
//            this.mListener = onPhraseLoadListener;
//            return this;
//        }
//
//        public SinglePhraseLoader build() {
//            SinglePhraseLoader singlePhraseLoader = new SinglePhraseLoader();
//            singlePhraseLoader.mContext.mAM = this.mAM;
//            singlePhraseLoader.mContext.mGroupIds = new ArrayList(1);
//            singlePhraseLoader.mContext.mGroupIds.add(Integer.valueOf(this.mGroupId));
//            singlePhraseLoader.mContext.mCallback = singlePhraseLoader;
//            singlePhraseLoader.mListener = this.mListener;
//            singlePhraseLoader.mDownloader = new PhraseDownloader(singlePhraseLoader.mContext);
//            return singlePhraseLoader;
//        }
//    }
//
//    public interface OnPhraseLoadListener {
//        void onCancelled();
//
//        void onLoadProgress(int i);
//
//        void onLoaded(boolean z, int i);
//    }
//
//    private SinglePhraseLoader() {
//        this.mContext = new PLContext();
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
//    public void setGroupId(int i) {
//        if (this.mContext.mGroupIds != null && 1 == this.mContext.mGroupIds.size() && ((Integer) this.mContext.mGroupIds.get(0)).intValue() == i) {
//            this.mDownloader.mNewDownload = false;
//            return;
//        }
//        if (this.mContext.mGroupIds != null) {
//            this.mContext.mGroupIds.clear();
//        }
//        this.mContext.mGroupIds.add(Integer.valueOf(i));
//        this.mDownloader.mNewDownload = true;
//    }
//
//    public void setAssetManager(AssetManager assetManager) {
//        this.mContext.mAM = assetManager;
//    }
//
//    public void setCallback(OnPhraseLoadListener onPhraseLoadListener) {
//        this.mListener = onPhraseLoadListener;
//    }
//
//    public TopicPatterns getTopicPatterns() {
//        if (!this.mContext.mPatternsList.isEmpty()) {
//            return (TopicPatterns) this.mContext.mPatternsList.get(0);
//        }
//        return null;
//    }
//
//    public Map<Integer, Phrase> getPhrases() {
//        if (!this.mContext.mPhrasesList.isEmpty()) {
//            return (Map) this.mContext.mPhrasesList.get(0);
//        }
//        return null;
//    }
//
//    public void onLoadInited(int i, float f, float f2) {
//    }
//
//    public void onLoadProgress(int i, float f, float f2) {
//        if (this.mListener != null) {
//            this.mListener.onLoadProgress(i);
//            Log.d("whiz", "on load progress: " + i + "; completed: " + f + "; total: " + f2);
//        }
//    }
//
//    public void onLoaded(boolean z, int i) {
//        if (this.mListener != null) {
//            this.mListener.onLoaded(z, i);
//            Log.d("whiz", "on loaded: " + z + "; code: " + i);
//        }
//    }
//
//    public void onCancelled() {
//        if (this.mListener != null) {
//            this.mListener.onCancelled();
//        }
//    }
//}
