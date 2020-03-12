//package com.baicizhan.client.video.load;
//
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.DownloadManager;
//import com.baicizhan.client.framework.resource.ResourceLibrary;
//import com.baicizhan.client.video.VideoAppHandler;
//import com.baicizhan.client.video.data.VideoInfo;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
//public class VideoLoader {
//    private static final int DEF_MAX_BUFFER_SIZE = 10;
//    private static final int WIFI_MAX_BUFFER_SIZE = 10;
//    private static final int _2G_MAX_BUFFER_SIZE = 0;
//    private static final int _3G_MAX_BUFFER_SIZE = 2;
//    private static final int _4G_MAX_BUFFER_SIZE = 2;
//    private int mBufferSize;
//    private int mCrawlIndex;
//    private final Downloader mDownloader = new Downloader(this);
//    private OnVideoLoadListener mListener;
//    private int mMaxBufferSize = 10;
//    final String mUrlHost;
//    final String mUrlHostCand;
//    private final List<VideoInfo> mVideos;
//
//    public interface OnVideoLoadListener {
//        void onIdle();
//
//        void onLoaded(boolean z, String str);
//    }
//
//    public VideoLoader(String str, String str2, List<VideoInfo> list) {
//        this.mUrlHost = str;
//        this.mUrlHostCand = str2;
//        this.mVideos = list;
//        try {
//            new URL(this.mUrlHost);
//            new URL(this.mUrlHostCand);
//        } catch (MalformedURLException e) {
//            C0789L.log.error("Illegal video url host: " + str + "; or: " + str2);
//        }
//        if (this.mVideos == null || this.mVideos.isEmpty()) {
//            C0789L.log.error("Not a valid video can be loaded.");
//        }
//    }
//
//    private void adjustMaxBufferSize() {
//        switch (NetworkUtils.getActiveNetworkType(VideoAppHandler.getApp())) {
//            case -1:
//            case 3:
//                this.mMaxBufferSize = 0;
//                return;
//            case 1:
//                this.mMaxBufferSize = 2;
//                return;
//            case 2:
//                this.mMaxBufferSize = 2;
//                return;
//            default:
//                this.mMaxBufferSize = 10;
//                return;
//        }
//    }
//
//    public void load(int i, OnVideoLoadListener onVideoLoadListener) {
//        this.mCrawlIndex = i;
//        this.mBufferSize = 0;
//        cancel();
//        load(onVideoLoadListener);
//    }
//
//    public void load(OnVideoLoadListener onVideoLoadListener) {
//        if (this.mVideos != null && !this.mVideos.isEmpty()) {
//            adjustMaxBufferSize();
//            if (this.mMaxBufferSize > 0) {
//                this.mListener = onVideoLoadListener;
//                int size = this.mVideos.size();
//                if (this.mCrawlIndex >= size) {
//                    this.mCrawlIndex = 0;
//                }
//                int i = this.mCrawlIndex;
//                int i2 = 0;
//                while (i2 <= 0) {
//                    if (isVideoLocal(((VideoInfo) this.mVideos.get(i)).getPath())) {
//                        this.mBufferSize++;
//                        if (this.mListener != null) {
//                            this.mListener.onLoaded(true, this.mUrlHost + ((VideoInfo) this.mVideos.get(i)).getPath());
//                        }
//                    } else {
//                        DownloadManager downloadManager = new DownloadManager();
//                        downloadManager.setUrl(this.mUrlHost + ((VideoInfo) this.mVideos.get(i)).getPath());
//                        this.mDownloader.mDLManagers.add(downloadManager);
//                    }
//                    int i3 = i2 + 1;
//                    this.mCrawlIndex = (this.mCrawlIndex + 1) % size;
//                    i2 = i3;
//                }
//                if (this.mDownloader.mDLManagers.isEmpty()) {
//                    if (this.mBufferSize < Math.min(this.mMaxBufferSize, this.mVideos.size())) {
//                        load(this.mListener);
//                    } else if (this.mListener != null) {
//                        this.mListener.onIdle();
//                    }
//                } else {
//                    this.mDownloader.download();
//                }
//            }
//        }
//    }
//
//    public void cancel() {
//        this.mDownloader.cancel();
//    }
//
//    /* JADX INFO: finally extract failed */
//    public boolean isVideoLocal(String str) {
//        ResourceLibrary resourceLibrary = new ResourceLibrary(this.mDownloader.mHome);
//        try {
//            resourceLibrary.open(true);
//            boolean exists = resourceLibrary.exists(str);
//            resourceLibrary.close();
//            return exists;
//        } catch (Exception e) {
//            e.printStackTrace();
//            resourceLibrary.close();
//            return false;
//        } catch (Throwable th) {
//            resourceLibrary.close();
//            throw th;
//        }
//    }
//
//    /* JADX INFO: finally extract failed */
//    public File getVideo(String str) {
//        ResourceLibrary resourceLibrary = new ResourceLibrary(this.mDownloader.mHome);
//        try {
//            resourceLibrary.open(true);
//            File file = resourceLibrary.getFile(str);
//            resourceLibrary.close();
//            return file;
//        } catch (Exception e) {
//            e.printStackTrace();
//            resourceLibrary.close();
//            return null;
//        } catch (Throwable th) {
//            resourceLibrary.close();
//            throw th;
//        }
//    }
//
//    public File getVideoFromUrl(String str) {
//        int indexOf = str.indexOf(this.mUrlHost);
//        int length = this.mUrlHost.length();
//        if (indexOf != 0) {
//            indexOf = str.indexOf(this.mUrlHostCand);
//            length = this.mUrlHostCand.length();
//        }
//        if (indexOf != 0) {
//            return null;
//        }
//        return getVideo(str.substring(length));
//    }
//
//    public List<VideoInfo> getVideoInfos() {
//        return this.mVideos;
//    }
//
//    public String getHost() {
//        return this.mUrlHost;
//    }
//
//    public String getHostCandidate() {
//        return this.mUrlHostCand;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onDownloaded(boolean z, String str) {
//        if (z) {
//            this.mBufferSize++;
//        }
//        if (this.mListener != null) {
//            this.mListener.onLoaded(z, str);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onTurnFinished() {
//        if (this.mBufferSize < Math.min(this.mMaxBufferSize, this.mVideos.size())) {
//            load(this.mListener);
//        } else if (this.mListener != null) {
//            this.mListener.onIdle();
//        }
//    }
//}
