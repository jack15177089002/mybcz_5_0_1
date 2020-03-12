//package com.baicizhan.main.phrasetraining.data.load;
//
//import android.content.res.AssetManager;
//import android.util.SparseArray;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.phrasetraining.data.Pattern;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup;
//import java.util.List;
//
//public class PhraseGroupLoader {
//    /* access modifiers changed from: private */
//    public AssetManager mAM;
//    /* access modifiers changed from: private */
//    public OnPhraseGroupLoadListener mCallback;
//    private LoadTask mTask;
//
//    public class Builder {
//        private AssetManager mAM;
//        private OnPhraseGroupLoadListener mCallback;
//
//        public Builder setAssetManager(AssetManager assetManager) {
//            this.mAM = assetManager;
//            return this;
//        }
//
//        public Builder setCallback(OnPhraseGroupLoadListener onPhraseGroupLoadListener) {
//            this.mCallback = onPhraseGroupLoadListener;
//            return this;
//        }
//
//        public PhraseGroupLoader build() {
//            PhraseGroupLoader phraseGroupLoader = new PhraseGroupLoader();
//            phraseGroupLoader.mAM = this.mAM;
//            phraseGroupLoader.mCallback = this.mCallback;
//            return phraseGroupLoader;
//        }
//    }
//
//    class LoadTask extends LAsyncTask<Void, Void, Result> {
//        LoadTask() {
//            setKey(Common.md5(PhraseGroupLoader.class.getName()));
//            parallelTask(1);
//        }
//
//        /* access modifiers changed from: protected */
//        public Result doInBackground(Void... voidArr) {
//            Result result = new Result();
//            result.datas = PhraseGroup.getPhraseGroups(PhraseGroupLoader.this.mAM);
//            if (result.datas == null || result.datas.isEmpty()) {
//                result.success = false;
//                return result;
//            }
//            result.studyTags = new SparseArray<>(result.datas.size());
//            for (PhraseGroup phraseGroup : result.datas) {
//                result.studyTags.put(phraseGroup.getGroupId(), Boolean.valueOf(PropertyHelper.getBoolean(new StringBuilder(Pattern.STUDIED_KEY).append(phraseGroup.getGroupId()).toString())));
//            }
//            result.success = true;
//            return result;
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(Result result) {
//            if (PhraseGroupLoader.this.mCallback != null) {
//                PhraseGroupLoader.this.mCallback.onLoaded(result.success, result.datas, result.studyTags);
//            }
//        }
//    }
//
//    public interface OnPhraseGroupLoadListener {
//        void onLoaded(boolean z, List<PhraseGroup> list, SparseArray<Boolean> sparseArray);
//    }
//
//    class Result {
//        List<PhraseGroup> datas;
//        SparseArray<Boolean> studyTags;
//        boolean success;
//
//        private Result() {
//        }
//    }
//
//    private PhraseGroupLoader() {
//    }
//
//    public void setAssetManager(AssetManager assetManager) {
//        this.mAM = assetManager;
//    }
//
//    public void setCallback(OnPhraseGroupLoadListener onPhraseGroupLoadListener) {
//        this.mCallback = onPhraseGroupLoadListener;
//    }
//
//    public void load() {
//        this.mTask = getTask();
//        this.mTask.execute(new Void[0]);
//    }
//
//    private LoadTask getTask() {
//        String md5 = Common.md5(PhraseGroupLoader.class.getName());
//        LAsyncTask searchTask = LoadTask.searchTask(md5);
//        if (searchTask != null) {
//            searchTask.cancel();
//            LoadTask.removeAllTask(0, md5);
//        }
//        return new LoadTask();
//    }
//}
