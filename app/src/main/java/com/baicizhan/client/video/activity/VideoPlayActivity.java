//package com.baicizhan.client.video.activity;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
//import com.baicizhan.client.business.theme.ThemeActivity;
//import com.baicizhan.client.business.util.LogWrapper;
////import com.baicizhan.client.video.R;
//import com.baicizhan.client.video.stats.UMStats;
//import com.baicizhan.client.video.view.VideoView;
//import com.jiongji.andriod.card.R;
//
//public class VideoPlayActivity extends ThemeActivity {
//    private static final String STATE_EXIT_FOR_RECREATE = "exit";
//    private static final String TAG = VideoPlayActivity.class.getName();
//    private boolean mFinishSelf = false;
//    private SysLockReceiver mReceiver;
//    private UMStats mUMStats;
//    /* access modifiers changed from: private */
//    public VideoView mVideoView;
//
//    class SysLockReceiver extends BroadcastReceiver {
//        private SysLockReceiver() {
//        }
//
//        public void onReceive(Context context, Intent intent) {
//            if (VideoPlayActivity.this.mVideoView != null) {
//                String action = intent.getAction();
//                if ("android.intent.action.USER_PRESENT".equals(action)) {
//                    VideoPlayActivity.this.mVideoView.setUserPresent(true);
//                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
//                    VideoPlayActivity.this.mVideoView.setUserPresent(false);
//                }
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, VideoPlayActivity.class));
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean("exit", true);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!tryFinishSelf(bundle)) {
//            setContentView(R.layout.video_play_view);
//            getWindow().addFlags(128);
//            setVolumeControlStream(3);
//            this.mVideoView = (VideoView) findViewById(R.id.video_view);
//            this.mReceiver = new SysLockReceiver();
//            IntentFilter intentFilter = new IntentFilter();
//            intentFilter.addAction("android.intent.action.USER_PRESENT");
//            intentFilter.addAction("android.intent.action.SCREEN_OFF");
//            registerReceiver(this.mReceiver, intentFilter);
//            this.mUMStats = new UMStats(this);
//            this.mVideoView.startRun();
//        }
//    }
//
//    private boolean tryFinishSelf(Bundle bundle) {
//        if (bundle == null || !bundle.getBoolean("exit", false)) {
//            return false;
//        }
//        LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, finish!");
//        this.mFinishSelf = true;
//        finish();
//        return true;
//    }
//
//    public void onResume() {
//        super.onResume();
//        if (!this.mFinishSelf) {
//            this.mUMStats.resume();
//            if (this.mVideoView != null) {
//                this.mVideoView.setResumed(true);
//            }
//        }
//    }
//
//    public void onPause() {
//        super.onPause();
//        if (!this.mFinishSelf) {
//            this.mUMStats.pause();
//            if (this.mVideoView != null) {
//                this.mVideoView.setResumed(false);
//            }
//        }
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (!this.mFinishSelf) {
//            this.mVideoView.destroy();
//            unregisterReceiver(this.mReceiver);
//        }
//    }
//}
