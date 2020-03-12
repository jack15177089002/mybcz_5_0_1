//package com.baicizhan.client.video.load;
//
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.http.download.DownloadManager;
//import com.baicizhan.client.framework.network.http.download.IDownloadManager.DownloadCallback;
//import com.baicizhan.client.framework.resource.ResourceLibrary;
//import com.baicizhan.client.framework.util.Common;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Downloader {
//    static final int DEF_TURN_SIZE = 1;
//    List<DownloadManager> mDLManagers = new ArrayList(1);
//    Set<String> mFailedUrls = new HashSet(1);
//    String mHome = PathUtil.getBaicizhanFile("res/video").getAbsolutePath();
//    /* access modifiers changed from: private */
//    public final VideoLoader mLoader;
//    /* access modifiers changed from: private */
//    public int mTrace;
//    int mTurnSize;
//
//    class SaveTask extends LAsyncTask<String, Void, Boolean> {
//        static final long MAX_CAPACITY = 419430400;
//        static final int MAX_FILE_COUNT = 3020;
//        final DownloadManager mDM;
//        final WeakReference<Downloader> mDownloader;
//
//        SaveTask(DownloadManager downloadManager, Downloader downloader) {
//            this.mDownloader = new WeakReference<>(downloader);
//            setKey(Downloader.genKey(downloadManager));
//            parallelTask(1);
//            this.mDM = downloadManager;
//        }
//
//        /* access modifiers changed from: protected */
//        public Boolean doInBackground(String... strArr) {
//            Downloader downloader = (Downloader) this.mDownloader.get();
//            if (downloader == null) {
//                return Boolean.valueOf(false);
//            }
//            String str = strArr[0];
//            ResourceLibrary resourceLibrary = new ResourceLibrary(downloader.mHome, MAX_CAPACITY, MAX_FILE_COUNT);
//            try {
//                C0789L.log.info("save single video, start open video resource.");
//                if (resourceLibrary.open(true)) {
//                    int indexOf = this.mDM.getUrl().indexOf(downloader.mLoader.mUrlHost);
//                    int length = downloader.mLoader.mUrlHost.length();
//                    if (indexOf < 0) {
//                        this.mDM.getUrl().indexOf(downloader.mLoader.mUrlHostCand);
//                        length = downloader.mLoader.mUrlHostCand.length();
//                    }
//                    boolean save = resourceLibrary.save(this.mDM.getUrl().substring(length), new File(str), true);
//                    C0789L.log.info("save single video, home [{}], to name [{}], from [{}], ret [{}]", downloader.mHome, this.mDM.getUrl().substring(length), str, Boolean.valueOf(save));
//                    if (save) {
//                        return Boolean.valueOf(true);
//                    }
//                }
//                resourceLibrary.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                resourceLibrary.close();
//            }
//            return Boolean.valueOf(false);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(Boolean bool) {
//            Downloader downloader = (Downloader) this.mDownloader.get();
//            if (downloader != null) {
//                if (bool == null || !bool.booleanValue()) {
//                    downloader.mFailedUrls.add(this.mDM.getUrl());
//                    downloader.mLoader.onDownloaded(false, this.mDM.getUrl());
//                } else {
//                    downloader.mLoader.onDownloaded(true, this.mDM.getUrl());
//                }
//                downloader.mTrace = downloader.mTrace + 1;
//                if (downloader.mTurnSize == downloader.mTrace) {
//                    downloader.mDLManagers.clear();
//                    downloader.mLoader.onTurnFinished();
//                }
//            }
//        }
//    }
//
//    Downloader(VideoLoader videoLoader) {
//        if (videoLoader == null) {
//            throw new RuntimeException("video downloader cannot be initialized for null video loader.");
//        }
//        this.mLoader = videoLoader;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void download() {
//        int i = 0;
//        this.mFailedUrls.clear();
//        this.mTurnSize = this.mDLManagers.size();
//        this.mTrace = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 < this.mTurnSize) {
//                final DownloadManager downloadManager = (DownloadManager) this.mDLManagers.get(i2);
//                downloadManager.setCallback(new DownloadCallback() {
//                    public void onComplete(boolean z, String str, int i) {
//                        C0789L.log.info("single video download result, success [{}], target [{}], err [{}]", Boolean.valueOf(z), str, Integer.valueOf(i));
//                        if (z) {
//                            Downloader.this.getTask(downloadManager).execute(str);
//                        } else if (Downloader.this.mFailedUrls.contains(downloadManager.getUrl()) || downloadManager.getUrl().indexOf(Downloader.this.mLoader.mUrlHost) < 0) {
//                            Downloader.this.mLoader.onDownloaded(false, downloadManager.getUrl());
//                        } else {
//                            String str2 = Downloader.this.mLoader.mUrlHostCand + downloadManager.getUrl().substring(Downloader.this.mLoader.mUrlHost.length());
//                            downloadManager.setUrl(str2).start();
//                            C0789L.log.info("single video download with a candidate url [{}]", (Object) str2);
//                            Downloader.this.mFailedUrls.add(downloadManager.getUrl());
//                        }
//                    }
//
//                    public void onGroupComplete(boolean z, List<String> list, int i) {
//                    }
//
//                    public void onPause() {
//                    }
//
//                    public void onProgress(int i) {
//                    }
//
//                    public void onResume() {
//                    }
//
//                    public void onStart() {
//                    }
//
//                    public void onStartDecompress() {
//                    }
//
//                    public void onStop() {
//                    }
//                }).start();
//                i = i2 + 1;
//            } else {
//                return;
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void cancel() {
//        for (DownloadManager stop : this.mDLManagers) {
//            stop.stop();
//        }
//        this.mDLManagers.clear();
//    }
//
//    /* access modifiers changed from: private */
//    public static final String genKey(DownloadManager downloadManager) {
//        return Common.md5(downloadManager.getUrl());
//    }
//
//    /* access modifiers changed from: private */
//    public SaveTask getTask(DownloadManager downloadManager) {
//        String genKey = genKey(downloadManager);
//        LAsyncTask searchTask = SaveTask.searchTask(genKey);
//        if (searchTask != null) {
//            searchTask.cancel();
//            SaveTask.removeAllTask(0, genKey);
//        }
//        return new SaveTask(downloadManager, this);
//    }
//}
