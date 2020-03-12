//package com.baicizhan.client.video.view;
//
//import android.os.Handler;
//import android.os.Message;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.ScaleAnimation;
////import com.baicizhan.client.video.R;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
//
//public class CtrlAnimationManager {
//    private boolean mCtrlsHide = false;
//    private CtrlsHideHandler mHandler;
//    private VideoView mVideoView;
//
//    class CtrlsHideHandler extends Handler {
//        final WeakReference<CtrlAnimationManager> mMng;
//
//        CtrlsHideHandler(CtrlAnimationManager ctrlAnimationManager) {
//            this.mMng = new WeakReference<>(ctrlAnimationManager);
//        }
//
//        public void handleMessage(Message message) {
//            if (message.what == 0) {
//                CtrlAnimationManager ctrlAnimationManager = (CtrlAnimationManager) this.mMng.get();
//                if (ctrlAnimationManager != null) {
//                    ctrlAnimationManager.fadeoOutCtrls();
//                }
//            }
//        }
//    }
//
//    CtrlAnimationManager(VideoView videoView) {
//        this.mVideoView = videoView;
//        this.mHandler = new CtrlsHideHandler(this);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void touchContent() {
//        if (this.mCtrlsHide) {
//            fadeInCtrls();
//            delayHideCtrls();
//            return;
//        }
//        cancelDelayHideCtrls();
//        fadeoOutCtrls();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void touchCtrls() {
//        if (!this.mCtrlsHide) {
//            delayHideCtrls();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void toggleInfo(boolean z) {
//        if (!this.mCtrlsHide && z) {
//            if (this.mVideoView.mVideoInfoLayout.getVisibility() == 0) {
//                scaleInfo(false);
//            } else {
//                scaleInfo(true);
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void forceHide() {
//        if (this.mVideoView.mNavBar != null) {
//            this.mVideoView.mNavBar.setVisibility(8);
//        }
//        if (this.mVideoView.mPlayCtrl != null) {
//            this.mVideoView.mPlayCtrl.setVisibility(8);
//        }
//        if (this.mVideoView.mPlayList != null) {
//            this.mVideoView.mPlayList.setVisibility(8);
//        }
//        if (this.mHandler != null) {
//            this.mHandler.removeMessages(0);
//        }
//        this.mCtrlsHide = true;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void destroy() {
//        this.mHandler.removeMessages(0);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void delayHideCtrls() {
//        this.mHandler.removeMessages(0);
//        this.mHandler.sendEmptyMessageDelayed(0, 4000);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void cancelDelayHideCtrls() {
//        this.mHandler.removeMessages(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void fadeoOutCtrls() {
//        long j = 0;
//        if (this.mVideoView.mPlayList.getVisibility() == 0) {
//            this.mVideoView.mPlayList.startAnimation(AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadeout_to_right));
//            this.mVideoView.mPlayList.setVisibility(8);
//            this.mVideoView.mNavBar.setSelected(false);
//            j = 300;
//        }
//        if (this.mVideoView.mVideoInfoLayout.getVisibility() == 0) {
//            scaleInfo(false);
//        }
//        Animation loadAnimation = AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadeout_to_top);
//        loadAnimation.setStartOffset(j);
//        this.mVideoView.mNavBar.startAnimation(loadAnimation);
//        this.mVideoView.mNavBar.setVisibility(8);
//        this.mVideoView.mNavBar.setEnabled(false);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadeout_to_bottom);
//        loadAnimation2.setStartOffset(j);
//        this.mVideoView.mPlayCtrl.startAnimation(loadAnimation2);
//        this.mVideoView.mPlayCtrl.setVisibility(8);
//        this.mCtrlsHide = true;
//    }
//
//    private void fadeInCtrls() {
//        this.mVideoView.mNavBar.startAnimation(AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadein_from_top));
//        this.mVideoView.mPlayCtrl.startAnimation(AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadein_from_bottom));
//        this.mVideoView.mNavBar.setEnabled(true);
//        this.mVideoView.mNavBar.setVisibility(0);
//        this.mVideoView.mPlayCtrl.setVisibility(0);
//        Animation loadAnimation = AnimationUtils.loadAnimation(this.mVideoView.getContext(), R.anim.video_fadein_from_right);
//        loadAnimation.setStartOffset(300);
//        this.mVideoView.mPlayList.startAnimation(loadAnimation);
//        this.mVideoView.mPlayList.setVisibility(0);
//        this.mCtrlsHide = false;
//    }
//
//    private void scaleInfo(boolean z) {
//        ScaleAnimation scaleAnimation;
//        if (z) {
//            this.mVideoView.mVideoInfoLayout.setVisibility(0);
//            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.9f, 1, 1.0f);
//        } else {
//            this.mVideoView.mVideoInfoLayout.setVisibility(8);
//            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.9f, 1, 1.0f);
//        }
//        scaleAnimation.setDuration(200);
//        this.mVideoView.mVideoInfoLayout.startAnimation(scaleAnimation);
//    }
//}
