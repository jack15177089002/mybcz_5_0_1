//package com.baicizhan.main.utils;
//
//import android.graphics.drawable.AnimationDrawable;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ImageView;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//
//public class VividPlayManager implements OnClickListener, OnPlaySateListener {
//    private String mAudioName;
//    private OnPlayListener mListener;
//    private String mPath;
//    private View mPlayFrame;
//    private ImageView mPlayView;
//    private AudioPlayer mPlayer;
//    private State mState;
//    private TopicRecord mTopicRecord;
//
//    public interface OnPlayListener {
//        void onPlayCompleted();
//
//        void onPlayStart();
//    }
//
//    public void setPlayListener(OnPlayListener onPlayListener) {
//        this.mListener = onPlayListener;
//    }
//
//    public VividPlayManager(AudioPlayer audioPlayer, String str, ImageView imageView) {
//        this(audioPlayer, str, (View) null, imageView);
//    }
//
//    public VividPlayManager(AudioPlayer audioPlayer, String str, View view, ImageView imageView) {
//        this.mPlayer = audioPlayer;
//        this.mPath = str;
//        this.mPlayFrame = view;
//        this.mPlayView = imageView;
//        this.mPlayView.setOnClickListener(this);
//        if (this.mPlayFrame != null) {
//            this.mPlayFrame.setOnClickListener(this);
//        }
//    }
//
//    public VividPlayManager(AudioPlayer audioPlayer, TopicRecord topicRecord, String str, ImageView imageView) {
//        this(audioPlayer, topicRecord, str, null, imageView);
//    }
//
//    public VividPlayManager(AudioPlayer audioPlayer, TopicRecord topicRecord, String str, View view, ImageView imageView) {
//        this.mPlayer = audioPlayer;
//        this.mTopicRecord = topicRecord;
//        this.mAudioName = str;
//        this.mPlayFrame = view;
//        this.mPlayView = imageView;
//        this.mPlayView.setOnClickListener(this);
//        if (this.mPlayFrame != null) {
//            this.mPlayFrame.setOnClickListener(this);
//        }
//    }
//
//    private void togglePlay() {
//        if (State.Playing == this.mState) {
//            stop();
//        } else {
//            play();
//        }
//    }
//
//    private void animPlayView(boolean z) {
//        AnimationDrawable animationDrawable = (AnimationDrawable) this.mPlayView.getBackground();
//        if (z) {
//            animationDrawable.start();
//            return;
//        }
//        animationDrawable.stop();
//        animationDrawable.selectDrawable(0);
//    }
//
//    public void play() {
//        if (this.mPath != null) {
//            CommonUtils.playBaicizhanAudio(this.mPlayer, this.mPath, this);
//        } else {
//            this.mPlayer.setOnPlaySateListener(this);
//            ZPackUtils.loadAudioCompat(this.mPlayer, this.mTopicRecord, this.mAudioName);
//        }
//        animPlayView(true);
//        if (this.mListener != null) {
//            this.mListener.onPlayStart();
//        }
//    }
//
//    public void stop() {
//        this.mPlayer.stop();
//        animPlayView(false);
//    }
//
//    public void onPlayStateChanged(State state) {
//        this.mState = state;
//        if (State.Stopped == state || State.Completed == state) {
//            animPlayView(false);
//            if (this.mListener != null && State.Completed == state) {
//                this.mListener.onPlayCompleted();
//            }
//        }
//    }
//
//    public void onClick(View view) {
//        togglePlay();
//    }
//}
