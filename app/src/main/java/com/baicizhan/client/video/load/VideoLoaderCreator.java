//package com.baicizhan.client.video.load;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.text.TextUtils;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.framework.network.NetworkUtils;
////import com.baicizhan.client.video.R;
//import com.baicizhan.client.video.VideoAppHandler;
//import com.baicizhan.client.video.data.VideoInfo;
//import com.baicizhan.client.video.data.p032db.VideoDataManager;
//import com.baicizhan.client.video.data.p032db.VideoDataManager.OnVideoDataLoadListener;
//import com.jiongji.andriod.card.R;
////import com.baicizhan.online.bs_users.BBCheckInfo;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class VideoLoaderCreator {
//    public static final int ERR_NO_HOST = -2;
//    public static final int ERR_NO_VIDEO = -1;
//    public static final int ERR_USR_CANCEL = -3;
//    private static final int LOAD_COUNT_PER_LOOP = 20;
//    public static final int NO_ERR = 0;
//    /* access modifiers changed from: private */
//    public boolean m3G4GCapable = true;
//    /* access modifiers changed from: private */
//    public boolean mAsked = false;
//    /* access modifiers changed from: private */
//    public boolean mCancel = false;
//    /* access modifiers changed from: private */
//    public String mCandidate;
//    /* access modifiers changed from: private */
//    public int mErrCode = 0;
//    /* access modifiers changed from: private */
//    public String mHost;
//    private OnVideoLoaderCreateListener mListener;
//    /* access modifiers changed from: private */
//    public List<VideoInfo> mMidfieldVideos;
//    /* access modifiers changed from: private */
//    public final VideoDataManager mVDM = VideoDataManager.createInstance(this.mVideosGetter, null);
//    /* access modifiers changed from: private */
//    public List<Integer> mVideoIds;
//    /* access modifiers changed from: private */
//    public List<VideoInfo> mVideos;
//    private final VideosGetter mVideosGetter = new VideosGetter(this);
//
//    public interface OnVideoLoaderCreateListener {
//        void onVideoLoaderCreate(VideoLoader videoLoader, VideoLoader videoLoader2, int i);
//    }
//
//    class VideosGetter implements OnVideoDataLoadListener {
//        private final WeakReference<VideoLoaderCreator> mCreator;
//
//        VideosGetter(VideoLoaderCreator videoLoaderCreator) {
//            this.mCreator = new WeakReference<>(videoLoaderCreator);
//        }
//
//        public void onGetVideIds(boolean z, int i, List<Integer> list) {
//            VideoLoaderCreator videoLoaderCreator = (VideoLoaderCreator) this.mCreator.get();
//            if (videoLoaderCreator != null) {
//                videoLoaderCreator.mVideoIds = list;
//                if (list == null || list.isEmpty()) {
//                    videoLoaderCreator.mErrCode = -1;
//                    videoLoaderCreator.notifyCallback();
//                    return;
//                }
//                videoLoaderCreator.getVideos();
//            }
//        }
//
//        public void onGetVideos(boolean z, int i, List<VideoInfo> list) {
//            VideoLoaderCreator videoLoaderCreator = (VideoLoaderCreator) this.mCreator.get();
//            if (videoLoaderCreator != null) {
//                if (list == null || list.isEmpty()) {
//                    videoLoaderCreator.mErrCode = -1;
//                    videoLoaderCreator.mVideos = null;
//                    videoLoaderCreator.mCancel = true;
//                    videoLoaderCreator.notifyCallback();
//                    return;
//                }
//                if (videoLoaderCreator.mVideos == null) {
//                    videoLoaderCreator.mVideos = list;
//                } else {
//                    videoLoaderCreator.mVideos.addAll(list);
//                }
//                videoLoaderCreator.mVDM.getMidVideos();
//            }
//        }
//
//        public void onGetMidVideos(boolean z, int i, List<VideoInfo> list) {
//            VideoLoaderCreator videoLoaderCreator = (VideoLoaderCreator) this.mCreator.get();
//            if (videoLoaderCreator != null) {
//                videoLoaderCreator.mMidfieldVideos = list;
//                videoLoaderCreator.notifyCallback();
//            }
//        }
//    }
//
//    public boolean is3G4GCapable() {
//        return this.m3G4GCapable;
//    }
//
//    public VideoLoaderCreator() {
////        BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
////        if (checkInfo != null) {
////            this.mHost = checkInfo.getRes_dns();
////            this.mCandidate = checkInfo.getOther_res_dns();
////        }
////        if (TextUtils.isEmpty(this.mHost)) {
////            this.mHost = ConstantsUtil.DEFAULT_DNS;
////        }
////        if (TextUtils.isEmpty(this.mCandidate)) {
////            this.mCandidate = ConstantsUtil.DEFAULT_DNS_CAND;
////        }
//    }
//
//    public void create(OnVideoLoaderCreateListener onVideoLoaderCreateListener, Context context) {
//        this.mListener = onVideoLoaderCreateListener;
//        int activeNetworkType = NetworkUtils.getActiveNetworkType(VideoAppHandler.getApp());
//        if (activeNetworkType == -1 || activeNetworkType == 3) {
//            if (this.m3G4GCapable) {
//                getVideos();
//                return;
//            }
//            this.mErrCode = -2;
//            this.mHost = null;
//            this.mCandidate = null;
//            notifyCallback();
//            getVideos();
//        } else if (activeNetworkType == 0) {
//            getVideos();
//        } else if (!this.mAsked) {
//            Builder builder = new Builder(context);
//            builder.setTitle(R.string.video_load_warn_title).setMessage(R.string.video_load_warn_msg).setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    VideoLoaderCreator.this.mErrCode = -3;
//                    VideoLoaderCreator.this.mHost = null;
//                    VideoLoaderCreator.this.mCandidate = null;
//                    VideoLoaderCreator.this.notifyCallback();
//                    VideoLoaderCreator.this.getVideos();
//                    VideoLoaderCreator.this.m3G4GCapable = false;
//                    VideoLoaderCreator.this.mAsked = true;
//                }
//            }).setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    VideoLoaderCreator.this.getVideos();
//                    VideoLoaderCreator.this.m3G4GCapable = true;
//                    VideoLoaderCreator.this.mAsked = true;
//                }
//            });
//            BczDialog create = builder.create();
//            create.setCanceledOnTouchOutside(false);
//            create.setCancelable(false);
//            create.show();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void getVideos() {
//        if (this.mVideoIds == null || this.mVideoIds.isEmpty()) {
//            this.mVDM.getVideoIds();
//            return;
//        }
//        int i = 0;
//        if (this.mVideos != null) {
//            i = this.mVideos.size();
//        }
//        int min = Math.min(this.mVideoIds.size(), i + 20);
//        if (i < min && i < this.mVideoIds.size() && min <= this.mVideoIds.size()) {
//            this.mVDM.getVideos(this.mVideoIds.subList(i, min));
//        }
//    }
//
//    public void reset() {
//        this.mListener = null;
//        this.mErrCode = 0;
//        if (this.mVideos != null) {
//            this.mVideos.clear();
//        }
//        if (this.mMidfieldVideos != null) {
//            this.mMidfieldVideos.clear();
//        }
//        this.mVideos = null;
//        this.mMidfieldVideos = null;
//        this.mHost = null;
//        this.mCandidate = null;
//    }
//
//    public int getVideoCount() {
//        if (this.mVideoIds != null) {
//            return this.mVideoIds.size();
//        }
//        return 0;
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyCallback() {
//        ArrayList arrayList = null;
//        if (this.mListener != null && !this.mCancel) {
//            ArrayList arrayList2 = this.mVideos != null ? new ArrayList(this.mVideos) : null;
//            if (this.mMidfieldVideos != null) {
//                arrayList = new ArrayList(this.mMidfieldVideos);
//            }
//            this.mListener.onVideoLoaderCreate(new VideoLoader(this.mHost, this.mCandidate, arrayList2), new VideoLoader(this.mHost, this.mCandidate, arrayList), this.mErrCode);
//        }
//    }
//}
