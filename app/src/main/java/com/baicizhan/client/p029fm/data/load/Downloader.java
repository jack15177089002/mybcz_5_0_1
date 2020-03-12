//package com.baicizhan.client.p029fm.data.load;
//
//import android.util.Log;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.http.download.DownloadManager;
//import com.baicizhan.client.framework.network.http.download.IDownloadManager.DownloadCallback;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.fm.data.load.Downloader */
//public class Downloader {
//    static final int DEF_TURN_SIZE = 1;
//    List<DownloadManager> mDLManagers = new ArrayList(1);
//    Set<String> mFailedUrls = new HashSet(1);
//    /* access modifiers changed from: private */
//    public final FmLoader mLoader;
//    /* access modifiers changed from: private */
//    public int mTrace;
//    int mTurnSize;
//
//    Downloader(FmLoader fmLoader) {
//        if (fmLoader == null) {
//            throw new RuntimeException("fm downloader cannot be initialized for null fm loader.");
//        }
//        this.mLoader = fmLoader;
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
//                    public void onProgress(int i) {
//                    }
//
//                    public void onComplete(boolean z, String str, int i) {
//                        Log.d("whiz", "!!! download success: " + z + "; target: " + str + "; errcode: " + i);
//                        if (z) {
//                            Downloader.this.mLoader.onDownloaded(true, str, downloadManager.getUrl());
//                            Downloader.this.mTrace = Downloader.this.mTrace + 1;
//                            if (Downloader.this.mTurnSize == Downloader.this.mTrace) {
//                                Downloader.this.mDLManagers.clear();
//                                Downloader.this.mLoader.onTurnFinished();
//                            }
//                        } else if (Downloader.this.mFailedUrls.contains(downloadManager.getUrl()) || downloadManager.getUrl().indexOf(Downloader.this.mLoader.mUrlHost) < 0) {
//                            Downloader.this.mLoader.onDownloaded(false, str, downloadManager.getUrl());
//                        } else {
//                            String str2 = Downloader.this.mLoader.mUrlHostCand + downloadManager.getUrl().substring(Downloader.this.mLoader.mUrlHost.length());
//                            downloadManager.setUrl(str2).start();
//                            C0789L.log.info("single fm download with a candidate url [{}]", (Object) str2);
//                            Downloader.this.mFailedUrls.add(downloadManager.getUrl());
//                        }
//                    }
//
//                    public void onGroupComplete(boolean z, List<String> list, int i) {
//                    }
//
//                    public void onStart() {
//                    }
//
//                    public void onPause() {
//                    }
//
//                    public void onResume() {
//                    }
//
//                    public void onStop() {
//                    }
//
//                    public void onStartDecompress() {
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
//}
