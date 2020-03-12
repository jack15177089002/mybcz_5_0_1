//package com.baicizhan.client.framework.audio;
//
//import android.content.Context;
//import android.content.res.AssetFileDescriptor;
//import android.content.res.AssetManager;
//import android.media.MediaPlayer;
//import android.media.MediaPlayer.OnCompletionListener;
//import android.media.MediaPlayer.OnErrorListener;
//import android.media.MediaPlayer.OnPreparedListener;
//import android.os.Build.VERSION;
//import android.text.TextUtils;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.log.LSwitcher;
//import java.io.File;
//import java.io.FileDescriptor;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class AudioPlayer implements OnCompletionListener, OnErrorListener, OnPreparedListener, MusicFocusable {
//    public static final float DUCK_VOLUME = 0.1f;
//    public static final String TAG = "AudioPlayer";
//    private AssetManager mAssetManager;
//    AudioFocus mAudioFocus = AudioFocus.NoFocusNoDuck;
//    AudioFocusHelper mAudioFocusHelper = null;
//    private Context mContext;
//    private OnPlayErrorListener mOnPlayErrorListener;
//    private OnPlaySateListener mOnPlaySateListener;
//    MediaPlayer mPlayer = null;
//    State mState = State.Stopped;
//
//    enum AudioFocus {
//        NoFocusNoDuck,
//        NoFocusCanDuck,
//        Focused
//    }
//
//    public interface OnPlayErrorListener {
//        void onPlayError(int i, int i2);
//    }
//
//    public interface OnPlaySateListener {
//        void onPlayStateChanged(State state);
//    }
//
//    public enum State {
//        Completed,
//        Stopped,
//        Preparing,
//        Playing,
//        Paused
//    }
//
//    public AudioPlayer(Context context) {
//        this.mContext = context;
//        if (VERSION.SDK_INT >= 8) {
//            this.mAudioFocusHelper = new AudioFocusHelper(this.mContext.getApplicationContext(), this);
//        } else {
//            this.mAudioFocus = AudioFocus.Focused;
//        }
//    }
//
//    public void destroy() {
//        stop();
//        setState(State.Stopped);
//        relaxResources(true);
//        giveUpAudioFocus();
//        this.mContext = null;
//        this.mOnPlaySateListener = null;
//    }
//
//    public void setOnPlaySateListener(OnPlaySateListener onPlaySateListener) {
//        this.mOnPlaySateListener = onPlaySateListener;
//    }
//
//    public void setOnPlayErrorListener(OnPlayErrorListener onPlayErrorListener) {
//        this.mOnPlayErrorListener = onPlayErrorListener;
//    }
//
//    private void createMediaPlayerIfNeeded() {
//        if (this.mContext != null) {
//            if (this.mPlayer == null) {
//                this.mPlayer = new MediaPlayer();
//                this.mPlayer.setWakeMode(this.mContext.getApplicationContext(), 1);
//                this.mPlayer.setOnPreparedListener(this);
//                this.mPlayer.setOnCompletionListener(this);
//                this.mPlayer.setOnErrorListener(this);
//                this.mAssetManager = this.mContext.getAssets();
//                return;
//            }
//            this.mPlayer.reset();
//        }
//    }
//
//    private void relaxResources(boolean z) {
//        if (z && this.mPlayer != null) {
//            this.mPlayer.reset();
//            this.mPlayer.release();
//            this.mPlayer = null;
//        }
//    }
//
//    private void giveUpAudioFocus() {
//        if (this.mAudioFocus == AudioFocus.Focused && this.mAudioFocusHelper != null && this.mAudioFocusHelper.abandonFocus()) {
//            this.mAudioFocus = AudioFocus.NoFocusNoDuck;
//        }
//    }
//
//    private void tryToGetAudioFocus() {
//        if (this.mAudioFocus != AudioFocus.Focused && this.mAudioFocusHelper != null && this.mAudioFocusHelper.requestFocus()) {
//            this.mAudioFocus = AudioFocus.Focused;
//        }
//    }
//
//    private void configAndStartMediaPlayer() {
//        if (AudioFocus.NoFocusNoDuck != this.mAudioFocus) {
//            if (AudioFocus.NoFocusCanDuck == this.mAudioFocus) {
//                this.mPlayer.setVolume(0.1f, 0.1f);
//            } else {
//                this.mPlayer.setVolume(1.0f, 1.0f);
//            }
//            if (!this.mPlayer.isPlaying()) {
//                this.mPlayer.start();
//            }
//        } else if (this.mPlayer.isPlaying()) {
//            this.mPlayer.pause();
//        }
//    }
//
//    public void play() {
//        tryToGetAudioFocus();
//        if (State.Paused == this.mState) {
//            setState(State.Playing);
//            configAndStartMediaPlayer();
//        }
//    }
//
//    public void pause() {
//        if (State.Playing == this.mState) {
//            setState(State.Paused);
//            this.mPlayer.pause();
//            relaxResources(false);
//        }
//    }
//
//    public void stop() {
//        if (State.Playing == this.mState || State.Paused == this.mState) {
//            setState(State.Stopped);
//            relaxResources(true);
//            giveUpAudioFocus();
//        }
//    }
//
//    public boolean newPlay(String str) {
//        return newPlay(new File(str));
//    }
//
//    public boolean newPlay(File file) {
//        if (file == null || !file.exists() || file.length() == 0) {
//            return false;
//        }
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            boolean newPlay = newPlay(fileInputStream.getFD(), 0, file.length());
//            fileInputStream.close();
//            return newPlay;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean newPlayAssets(String str, boolean z) {
//        if (TextUtils.isEmpty(str)) {
//            return false;
//        }
//        try {
//            createMediaPlayerIfNeeded();
//            AssetFileDescriptor openFd = this.mAssetManager.openFd(str);
//            boolean newPlay = newPlay(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
//            openFd.close();
//            this.mPlayer.setLooping(z);
//            return newPlay;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean newPlayRaw(int i) {
//        try {
//            AssetFileDescriptor openRawResourceFd = this.mContext.getResources().openRawResourceFd(i);
//            boolean newPlay = newPlay(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
//            openRawResourceFd.close();
//            return newPlay;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean newPlay(FileDescriptor fileDescriptor, long j, long j2) {
//        tryToGetAudioFocus();
//        setState(State.Stopped);
//        relaxResources(false);
//        try {
//            createMediaPlayerIfNeeded();
//            this.mPlayer.setAudioStreamType(3);
//            this.mPlayer.setDataSource(fileDescriptor, j, j2);
//            setState(State.Preparing);
//            this.mPlayer.prepareAsync();
//            return true;
//        } catch (IOException e) {
//            if (LSwitcher.isOpened()) {
//                C0789L.log.error("IOException prepare playing song: " + e.getMessage());
//            }
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
//        if (LSwitcher.isOpened()) {
//            C0789L.log.error("Error: what=" + String.valueOf(i) + ", extra=" + String.valueOf(i2));
//        }
//        if (this.mOnPlayErrorListener != null) {
//            this.mOnPlayErrorListener.onPlayError(i, i2);
//        }
//        setState(State.Stopped);
//        relaxResources(true);
//        giveUpAudioFocus();
//        return true;
//    }
//
//    public void onCompletion(MediaPlayer mediaPlayer) {
//        setState(State.Completed);
//    }
//
//    public void onPrepared(MediaPlayer mediaPlayer) {
//        setState(State.Playing);
//        configAndStartMediaPlayer();
//    }
//
//    public void onGainedAudioFocus() {
//        this.mAudioFocus = AudioFocus.Focused;
//        if (State.Playing == this.mState) {
//            configAndStartMediaPlayer();
//        }
//    }
//
//    public void onLostAudioFocus(boolean z) {
//        this.mAudioFocus = z ? AudioFocus.NoFocusCanDuck : AudioFocus.NoFocusNoDuck;
//        if (this.mPlayer != null && this.mPlayer.isPlaying()) {
//            configAndStartMediaPlayer();
//        }
//    }
//
//    private void setState(State state) {
//        this.mState = state;
//        if (this.mOnPlaySateListener != null) {
//            this.mOnPlaySateListener.onPlayStateChanged(state);
//        }
//    }
//
//    public int getDuration() {
//        if (this.mPlayer != null) {
//            return this.mPlayer.getDuration();
//        }
//        return 0;
//    }
//}
