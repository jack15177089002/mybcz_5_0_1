//package com.baicizhan.client.video.data.p032db;
//
//import android.app.Application;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.video.VideoAppHandler;
//import com.baicizhan.client.video.data.VideoInfo;
////import com.baicizhan.online.bs_words.BSWords.Client;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.video.data.db.VideoDataManager */
//public class VideoDataManager {
//    public static final int ERR_NET = -1;
//    public static final int NO_ERR = 0;
//    private static final int TOKEN_VIDEO = 1;
//    private static final int TOKEN_VIDEO_ID = 0;
//    private static final int TOKEN_VIDEO_MID = 2;
//    /* access modifiers changed from: private */
//    public OnVideoDataLoadListener mLoadListener;
//    /* access modifiers changed from: private */
//    public OnVideoDataSyncListener mSyncListener;
//
//    /* renamed from: com.baicizhan.client.video.data.db.VideoDataManager$OnVideoDataLoadListener */
//    public interface OnVideoDataLoadListener {
//        void onGetMidVideos(boolean z, int i, List<VideoInfo> list);
//
//        void onGetVideIds(boolean z, int i, List<Integer> list);
//
//        void onGetVideos(boolean z, int i, List<VideoInfo> list);
//    }
//
//    /* renamed from: com.baicizhan.client.video.data.db.VideoDataManager$OnVideoDataSyncListener */
//    public interface OnVideoDataSyncListener {
//        void onVideoDataSynced();
//    }
//
//    /* renamed from: com.baicizhan.client.video.data.db.VideoDataManager$Params */
//    class Params {
//        /* access modifiers changed from: private */
//        public List<Integer> videoIds;
//        /* access modifiers changed from: private */
//        public List<VideoInfo> videoInfos;
//
//        private Params() {
//        }
//    }
//
//    private VideoDataManager() {
//    }
//
//    public static VideoDataManager createInstance(OnVideoDataLoadListener onVideoDataLoadListener, OnVideoDataSyncListener onVideoDataSyncListener) {
//        VideoDataManager videoDataManager = new VideoDataManager();
//        videoDataManager.mLoadListener = onVideoDataLoadListener;
//        videoDataManager.mSyncListener = onVideoDataSyncListener;
//        return videoDataManager;
//    }
//
//    public void getVideoIds() {
//        doGetVideos(0, new Params());
//    }
//
//    public void getVideos(List<Integer> list) {
//        Params params = new Params();
//        params.videoIds = list;
//        doGetVideos(1, params);
//    }
//
//    public void getMidVideos() {
//        doGetVideos(2, new Params());
//    }
//
//    private void doGetVideos(final int i, final Params params) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Params>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public Params doInBackground(Client client) {
////                if (i == 0) {
////                    params.videoIds = VideoDataManager.this.doGetVideoIds(client);
////                } else if (1 == i) {
////                    params.videoInfos = VideoDataManager.this.doGetVideos(client, params.videoIds);
////                } else if (2 == i) {
////                    params.videoInfos = VideoDataManager.this.doGetMidVideos();
////                }
////                return params;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (VideoDataManager.this.mLoadListener == null) {
////                    return;
////                }
////                if (i == 0) {
////                    VideoDataManager.this.mLoadListener.onGetVideIds(false, -1, null);
////                } else if (1 == i) {
////                    VideoDataManager.this.mLoadListener.onGetVideos(false, -1, null);
////                } else if (2 == i) {
////                    VideoDataManager.this.mLoadListener.onGetMidVideos(false, -1, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Params params) {
////                if (VideoDataManager.this.mLoadListener == null) {
////                    return;
////                }
////                if (i == 0) {
////                    VideoDataManager.this.mLoadListener.onGetVideIds(true, 0, params.videoIds);
////                } else if (1 == i) {
////                    VideoDataManager.this.mLoadListener.onGetVideos(true, 0, params.videoInfos);
////                } else if (2 == i) {
////                    VideoDataManager.this.mLoadListener.onGetMidVideos(true, 0, params.videoInfos);
////                }
////            }
////        });
//    }
//
//    /* access modifiers changed from: private */
////    public List<Integer> doGetVideoIds(Client client) {
////        Application app = VideoAppHandler.getApp();
////        int currentBookId = StudyManager.getInstance().getCurrentBookId();
////        if (WordMediaRecordHelper.isWordMediaUpdRecordsEmpty(app, currentBookId)) {
////            WordMediaLoader.refreshWordMediaUpdRecords(app, currentBookId, client);
////        }
////        return VideoInfoHelper.reorderVideos(app, currentBookId, WordMediaRecordHelper.getAllExistWordMediaRecordsFromUpdate(app, currentBookId, 1));
////    }
//
//    /* access modifiers changed from: private */
////    public List<VideoInfo> doGetVideos(Client client, List<Integer> list) {
////        List<Integer> list2;
////        if (list == null || list.isEmpty()) {
////            return null;
////        }
////        Application app = VideoAppHandler.getApp();
////        int currentBookId = StudyManager.getInstance().getCurrentBookId();
////        ArrayList<WordMediaRecord> arrayList = new ArrayList<>(VideoInfoHelper.getPreparedWordMediaRecords(app, currentBookId, list));
////        ArrayList arrayList2 = new ArrayList();
////        if (arrayList.isEmpty()) {
////            list2 = list;
////        } else {
////            HashSet hashSet = new HashSet(list);
////            for (WordMediaRecord wordid : arrayList) {
////                int intValue = Integer.valueOf(wordid.getWordid()).intValue();
////                if (hashSet.contains(Integer.valueOf(intValue))) {
////                    hashSet.remove(Integer.valueOf(intValue));
////                }
////            }
////            arrayList2.addAll(hashSet);
////            list2 = arrayList2;
////        }
////        if (list2 != null && !list2.isEmpty()) {
////            List doRequestWordMediaRecords = WordMediaLoader.doRequestWordMediaRecords(list2, client);
////            WordMediaRecordHelper.insertWordMediaRecords(app, currentBookId, doRequestWordMediaRecords);
////            arrayList.addAll(doRequestWordMediaRecords);
////        }
////        return VideoInfoHelper.mergeViewState(app, currentBookId, arrayList, list);
////    }
//
//    /* access modifiers changed from: private */
//    public List<VideoInfo> doGetMidVideos() {
//        return VideoInfoHelper.getVideoMidList(VideoAppHandler.getApp());
//    }
//
////    public void syncVideoData(final List<VideoInfo> list) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public Void doInBackground(Client client) {
////                VideoInfoHelper.updateVideoLearnRecords(VideoAppHandler.getApp(), StudyManager.getInstance().getCurrentBookId(), list);
////                return null;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Void voidR) {
////                if (VideoDataManager.this.mSyncListener != null) {
////                    VideoDataManager.this.mSyncListener.onVideoDataSynced();
////                }
////            }
////        });
////    }
//}
