//package com.baicizhan.client.business.media.update;
//
//import android.content.Context;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
//import com.baicizhan.client.framework.util.Common;
//import java.io.File;
//import java.util.ArrayList;
//
//public class FmBordersUpdator {
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public MediaUpdator mFmUpdator;
//    private DownloadTask mTask;
//
//    class DownloadTask extends LAsyncTask<Void, Void, Void> {
//        DownloadTask() {
//            setKey(Common.md5(FmBordersUpdator.class.getName()));
//            parallelTask(1);
//        }
//
//        /* access modifiers changed from: protected */
//        public Void doInBackground(Void... voidArr) {
//            String borderMediaPath = WordMediaRecordHelper.getBorderMediaPath(FmBordersUpdator.this.mContext, 2);
//            String borderMediaPath2 = WordMediaRecordHelper.getBorderMediaPath(FmBordersUpdator.this.mContext, 3);
//            ArrayList<String> arrayList = new ArrayList<>(2);
//            arrayList.add(borderMediaPath);
//            arrayList.add(borderMediaPath2);
//            int activeNetworkType = NetworkUtils.getActiveNetworkType(FmBordersUpdator.this.mContext);
//            if (!(3 == activeNetworkType || -1 == activeNetworkType)) {
//                SyncDownloadManager build = new Builder().build();
//                for (String str : arrayList) {
//                    String str2 = PathUtil.getResDns() + str;
//                    String reformFmPath = PathUtil.reformFmPath(PathUtil.BCZ_HOME + str);
//                    if (reformFmPath != null) {
//                        File file = new File(reformFmPath);
//                        if (!file.exists() || file.length() <= 0) {
//                            build.setUrl(str2);
//                            build.setDestPath(reformFmPath);
//                            if (!build.start()) {
//                                build.setUrl(PathUtil.getCandResDns() + str);
//                                build.start();
//                            }
//                        }
//                    }
//                }
//            }
//            return null;
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(Void voidR) {
//            if (FmBordersUpdator.this.mFmUpdator != null) {
//                FmBordersUpdator.this.mFmUpdator.onBorderUpdate();
//            }
//        }
//    }
//
//    FmBordersUpdator(Context context, MediaUpdator mediaUpdator) {
//        this.mContext = context;
//        this.mFmUpdator = mediaUpdator;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void update() {
//        int activeNetworkType = NetworkUtils.getActiveNetworkType(this.mContext);
//        if (3 != activeNetworkType && -1 != activeNetworkType) {
//            this.mTask = getTask();
//            this.mTask.execute(null);
//        } else if (this.mFmUpdator != null) {
//            this.mFmUpdator.onBorderUpdate();
//        }
//    }
//
//    private DownloadTask getTask() {
//        String md5 = Common.md5(FmBordersUpdator.class.getName());
//        LAsyncTask searchTask = DownloadTask.searchTask(md5);
//        if (searchTask != null) {
//            searchTask.cancel();
//            DownloadTask.removeAllTask(0, md5);
//        }
//        return new DownloadTask();
//    }
//}
