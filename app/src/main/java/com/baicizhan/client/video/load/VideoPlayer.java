package com.baicizhan.client.video.load;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import android.view.SurfaceHolder;
import com.baicizhan.client.framework.log.C0789L;
import java.io.IOException;

public class VideoPlayer implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final SurfaceHolder mHolder;
    private OnPlaySateListener mOnPlaySateListener;
    private MediaPlayer mPlayer;
    private State mState = State.Stopped;

    public interface OnPlaySateListener {
        void onPlayStateChanged(State state);
    }

    public enum State {
        Completed,
        Stopped,
        Preparing,
        Playing,
        Paused
    }

    public void setOnPlaySateListener(OnPlaySateListener onPlaySateListener) {
        this.mOnPlaySateListener = onPlaySateListener;
    }

    private VideoPlayer(SurfaceHolder surfaceHolder) {
        this.mHolder = surfaceHolder;
    }

    public static final VideoPlayer create(SurfaceHolder surfaceHolder) {
        return new VideoPlayer(surfaceHolder);
    }

    private void createMediaPlayerIfNeeded() {
        if (this.mPlayer == null) {
            this.mPlayer = new MediaPlayer();
            this.mPlayer.setOnPreparedListener(this);
            this.mPlayer.setOnCompletionListener(this);
            this.mPlayer.setOnErrorListener(this);
            this.mPlayer.setDisplay(this.mHolder);
            return;
        }
        this.mPlayer.reset();
    }

    private void relaxResources(boolean z) {
        if (z && this.mPlayer != null) {
            this.mPlayer.reset();
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    public void release() {
        stop();
        setState(State.Stopped);
        relaxResources(true);
    }

    public void destroy() {
        release();
        this.mOnPlaySateListener = null;
    }

    public boolean newPlay(String str) {
        setState(State.Stopped);
        relaxResources(false);
        Log.d("whiz", "new play: " + str);
        try {
            createMediaPlayerIfNeeded();
            this.mPlayer.setDataSource(str);
            setState(State.Preparing);
            this.mPlayer.prepareAsync();
            return true;
        } catch (IOException e) {
            C0789L.log.error("IOException prepare playing video: ", (Throwable) e);
            e.printStackTrace();
            Log.d("whiz", "new play ex: " + e);
            return false;
        }
    }

    public void stop() {
        if (State.Playing == this.mState || State.Paused == this.mState) {
            setState(State.Stopped);
            relaxResources(true);
        }
    }

    public void pause() {
        if (State.Playing == this.mState) {
            setState(State.Paused);
            this.mPlayer.pause();
            relaxResources(false);
        }
    }

    public void play() {
        if (State.Paused == this.mState) {
            setState(State.Playing);
            startPlayer();
        }
    }

    public void toggle() {
        if (State.Playing == this.mState) {
            pause();
        } else if (State.Paused == this.mState) {
            play();
        }
    }

    public State getPlayState() {
        return this.mState;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C0789L.log.error("play video error occured, what [{}], extra [{}]", (Object) Integer.valueOf(i2));
        setState(State.Stopped);
        relaxResources(true);
        return true;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        setState(State.Completed);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setState(State.Playing);
        startPlayer();
    }

    private void startPlayer() {
        if (!this.mPlayer.isPlaying()) {
            this.mPlayer.start();
        }
    }

    private void setState(State state) {
        this.mState = state;
        if (this.mOnPlaySateListener != null) {
            this.mOnPlaySateListener.onPlayStateChanged(state);
        }
    }
}
