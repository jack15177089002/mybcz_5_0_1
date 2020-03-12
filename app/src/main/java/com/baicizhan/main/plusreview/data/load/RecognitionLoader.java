//package com.baicizhan.main.plusreview.data.load;
//
//import android.content.Context;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.FileUtils;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.plusreview.data.RecognitionData;
//import com.baicizhan.main.plusreview.data.p034db.RecognitionHelper;
//import com.baicizhan.main.plusreview.data.p034db.RecognitionRecord;
//import com.jiongji.andriod.card.R;
//import java.io.File;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class RecognitionLoader {
//    public static final int ERR_DOWN_OPEN_EARS_FAILED = -2;
//    public static final int ERR_INPUT = -3;
//    public static final int ERR_RAW_COPY_FAILED = -1;
//    public static final int NO_ERR = 0;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public RecognitionLoadListener mListener;
//    /* access modifiers changed from: private */
//    public int mPreLoadCount = -1;
//    private LoadTask mTask;
//
//    class LoadTask extends LAsyncTask<List<Integer>, Void, Result> {
//        LoadTask() {
//            setKey(Common.md5(RecognitionLoader.class.getName()));
//            parallelTask(1);
//        }
//
//        /* access modifiers changed from: protected */
//        public Result doInBackground(List<Integer>... listArr) {
//            Result result = new Result();
//            List<Integer> list = listArr[0];
//            if (list == null) {
//                result.success = false;
//                result.errCode = -3;
//                result.datas = null;
//            } else {
//                try {
//                    if (tryCopyRaws(result)) {
//                        tryLoadOpenEars(list, result);
//                    }
//                } catch (Exception e) {
//                    if (RecognitionLoader.this.mContext != null) {
//                        throw e;
//                    }
//                }
//            }
//            return result;
//        }
//
//        private boolean tryCopyRaws(Result result) {
//            boolean z;
//            if (!RecognitionData.isOpenEarsDBExists()) {
//                z = FileUtils.copyFromRaw(RecognitionLoader.this.mContext.getResources(), R.raw.jiong100openears, Settings.getString(Settings.PREF_BAICIZHAN_PATH), "jiong100openears.sqlite");
//            } else {
//                z = true;
//            }
//            if (!z) {
//                result.success = false;
//                result.errCode = -1;
//                result.datas = null;
//                return false;
//            }
//            if (!RecognitionData.isVoiceModelFilesExists()) {
//                RecognitionData.clearVoiceModelDir();
//                z = FileUtils.copyAndUnzipFromRaw(RecognitionLoader.this.mContext.getResources(), R.raw.hub4wsj_sc_8k, Settings.getString(Settings.PREF_BAICIZHAN_PATH), "hub4wsj_sc_8k.zip");
//            }
//            if (z) {
//                return true;
//            }
//            result.success = false;
//            result.errCode = -1;
//            result.datas = null;
//            return false;
//        }
//
//        private boolean tryLoadOpenEars(List<Integer> list, Result result) {
//            result.datas = new HashMap();
//            int i = 0;
//            for (Integer intValue : list) {
//                int intValue2 = intValue.intValue();
//                RecognitionRecord recRecord = RecognitionHelper.getRecRecord(RecognitionLoader.this.mContext, StudyManager.getInstance().getCurrentBookId(), intValue2);
//                if (recRecord != null) {
//                    File baicizhanFile = PathUtil.getBaicizhanFile("dict_audios_of_word_level/" + recRecord.getFileName() + ".dic");
//                    if (!baicizhanFile.exists() && (RecognitionLoader.this.mPreLoadCount < 0 || i < RecognitionLoader.this.mPreLoadCount)) {
//                        SyncDownloadManager build = new Builder().setUrl(PathUtil.getResDns() + "/pack/info/dict_audios_of_word_level/" + recRecord.getFileName() + ".dic").setDestPath(baicizhanFile.getAbsolutePath()).build();
//                        boolean start = build.start();
//                        if (!start) {
//                            build.setUrl(PathUtil.getCandResDns() + "/pack/info/dict_audios_of_word_level/" + recRecord.getFileName() + ".dic");
//                            start = build.start();
//                        }
//                        if (!start) {
//                            result.success = false;
//                            result.errCode = -2;
//                            result.datas = null;
//                            return false;
//                        }
//                    }
//                    File baicizhanFile2 = PathUtil.getBaicizhanFile("dict_audios_of_word_level/" + recRecord.getFileName() + ".DMP");
//                    if (!baicizhanFile2.exists() && (RecognitionLoader.this.mPreLoadCount < 0 || i < RecognitionLoader.this.mPreLoadCount)) {
//                        SyncDownloadManager build2 = new Builder().setUrl(PathUtil.getResDns() + "/pack/info/dict_audios_of_word_level/" + recRecord.getFileName() + ".DMP").setDestPath(baicizhanFile2.getAbsolutePath()).build();
//                        boolean start2 = build2.start();
//                        if (!start2) {
//                            build2.setUrl(PathUtil.getCandResDns() + "/pack/info/dict_audios_of_word_level/" + recRecord.getFileName() + ".DMP");
//                            start2 = build2.start();
//                        }
//                        if (!start2) {
//                            result.success = false;
//                            result.errCode = -2;
//                            result.datas = null;
//                            return false;
//                        }
//                        i++;
//                    }
//                    int i2 = i;
//                    RecognitionData recognitionData = new RecognitionData();
//                    recognitionData.setTopicId(intValue2);
//                    recognitionData.setDicPath(baicizhanFile.getAbsolutePath());
//                    recognitionData.setDmpPath(baicizhanFile2.getAbsolutePath());
//                    result.datas.put(Integer.valueOf(intValue2), recognitionData);
//                    i = i2;
//                }
//            }
//            result.success = true;
//            result.errCode = 0;
//            return true;
//        }
//
//        public void onPostExecute(Result result) {
//            if (RecognitionLoader.this.mListener != null && RecognitionLoader.this.mContext != null) {
//                RecognitionLoader.this.mListener.onLoaded(result.success, result.errCode, result.datas);
//            }
//        }
//    }
//
//    public interface RecognitionLoadListener {
//        void onLoaded(boolean z, int i, Map<Integer, RecognitionData> map);
//    }
//
//    class Result {
//        Map<Integer, RecognitionData> datas;
//        int errCode;
//        boolean success;
//
//        private Result() {
//        }
//    }
//
//    private RecognitionLoader() {
//    }
//
//    public static RecognitionLoader createInstance(Context context, RecognitionLoadListener recognitionLoadListener) {
//        return createInstance(context, recognitionLoadListener, -1);
//    }
//
//    public static RecognitionLoader createInstance(Context context, RecognitionLoadListener recognitionLoadListener, int i) {
//        RecognitionLoader recognitionLoader = new RecognitionLoader();
//        recognitionLoader.mContext = context;
//        recognitionLoader.mListener = recognitionLoadListener;
//        recognitionLoader.mPreLoadCount = i;
//        return recognitionLoader;
//    }
//
//    public void destroy() {
//        this.mContext = null;
//    }
//
//    public void load(List<Integer> list) {
//        this.mTask = getTask();
//        this.mTask.execute(list);
//    }
//
//    private LoadTask getTask() {
//        String md5 = Common.md5(RecognitionLoader.class.getName());
//        LAsyncTask searchTask = LoadTask.searchTask(md5);
//        if (searchTask != null) {
//            searchTask.cancel();
//            LoadTask.removeAllTask(0, md5);
//        }
//        return new LoadTask();
//    }
//}
