//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Canvas;
//import android.media.MediaFormat;
//import android.media.MediaPlayer;
//import android.media.MediaPlayer.OnBufferingUpdateListener;
//import android.media.MediaPlayer.OnCompletionListener;
//import android.media.MediaPlayer.OnErrorListener;
//import android.media.MediaPlayer.OnInfoListener;
//import android.media.MediaPlayer.OnPreparedListener;
//import android.media.MediaPlayer.OnVideoSizeChangedListener;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.util.Pair;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceHolder.Callback;
//import android.view.SurfaceView;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.accessibility.AccessibilityEvent;
//import android.view.accessibility.AccessibilityNodeInfo;
//import android.widget.MediaController;
//import android.widget.MediaController.MediaPlayerControl;
//import com.tencent.android.tpush.common.MessageKey;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Map;
//import java.util.Vector;
//
//public class VideoView extends SurfaceView implements MediaPlayerControl {
//    private static final int STATE_ERROR = -1;
//    private static final int STATE_IDLE = 0;
//    private static final int STATE_PAUSED = 4;
//    private static final int STATE_PLAYBACK_COMPLETED = 5;
//    private static final int STATE_PLAYING = 3;
//    private static final int STATE_PREPARED = 2;
//    private static final int STATE_PREPARING = 1;
//    /* access modifiers changed from: private */
//    public String TAG;
//    private int mAudioSession;
//    private OnBufferingUpdateListener mBufferingUpdateListener;
//    /* access modifiers changed from: private */
//    public boolean mCanPause;
//    /* access modifiers changed from: private */
//    public boolean mCanSeekBack;
//    /* access modifiers changed from: private */
//    public boolean mCanSeekForward;
//    private OnCompletionListener mCompletionListener;
//    private Context mContext;
//    /* access modifiers changed from: private */
//    public int mCurrentBufferPercentage;
//    /* access modifiers changed from: private */
//    public int mCurrentState;
//    private OnErrorListener mErrorListener;
//    private OnInfoListener mInfoListener;
//    /* access modifiers changed from: private */
//    public MediaController mMediaController;
//    /* access modifiers changed from: private */
//    public MediaPlayer mMediaPlayer;
//    /* access modifiers changed from: private */
//    public OnCompletionListener mOnCompletionListener;
//    /* access modifiers changed from: private */
//    public OnErrorListener mOnErrorListener;
//    /* access modifiers changed from: private */
//    public OnInfoListener mOnInfoListener;
//    /* access modifiers changed from: private */
//    public OnPreparedListener mOnPreparedListener;
//    private Vector<Pair<InputStream, MediaFormat>> mPendingSubtitleTracks;
//    OnPreparedListener mPreparedListener;
//    Callback mSHCallback;
//    /* access modifiers changed from: private */
//    public int mSeekWhenPrepared;
//    OnVideoSizeChangedListener mSizeChangedListener;
//    /* access modifiers changed from: private */
//    public int mSurfaceHeight;
//    /* access modifiers changed from: private */
//    public SurfaceHolder mSurfaceHolder;
//    /* access modifiers changed from: private */
//    public int mSurfaceWidth;
//    /* access modifiers changed from: private */
//    public int mTargetState;
//    private Uri mUri;
//    /* access modifiers changed from: private */
//    public int mVideoHeight;
//    /* access modifiers changed from: private */
//    public int mVideoWidth;
//
//    public VideoView(Context context) {
//        super(context);
//        this.TAG = "VideoView";
//        this.mCurrentState = 0;
//        this.mTargetState = 0;
//        this.mSurfaceHolder = null;
//        this.mMediaPlayer = null;
//        this.mSizeChangedListener = new OnVideoSizeChangedListener() {
//            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
//                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
//                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
//                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
//                    Log.d(VideoView.this.TAG, "OnVideoSizeChangedListener " + VideoView.this.mVideoWidth + "/" + VideoView.this.mVideoHeight);
//                    VideoView.this.requestLayout();
//                }
//            }
//        };
//        this.mPreparedListener = new OnPreparedListener() {
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                VideoView.this.mCurrentState = 2;
//                VideoView.this.mCanPause = VideoView.this.mCanSeekBack = VideoView.this.mCanSeekForward = true;
//                if (VideoView.this.mOnPreparedListener != null) {
//                    VideoView.this.mOnPreparedListener.onPrepared(VideoView.this.mMediaPlayer);
//                }
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.setEnabled(true);
//                }
//                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
//                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
//                int access$1000 = VideoView.this.mSeekWhenPrepared;
//                if (access$1000 != 0) {
//                    VideoView.this.seekTo(access$1000);
//                }
//                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
//                    Log.i(VideoView.this.TAG, "video size: " + VideoView.this.mVideoWidth + "/" + VideoView.this.mVideoHeight + ", surfaceSize " + VideoView.this.mSurfaceWidth + "/" + VideoView.this.mSurfaceHeight + ", ");
//                    if (VideoView.this.mTargetState == 3) {
//                        VideoView.this.start();
//                        if (VideoView.this.mMediaController != null) {
//                            VideoView.this.mMediaController.show();
//                        }
//                    } else if (VideoView.this.isPlaying()) {
//                    } else {
//                        if ((access$1000 != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.mMediaController != null) {
//                            VideoView.this.mMediaController.show(0);
//                        }
//                    }
//                } else if (VideoView.this.mTargetState == 3) {
//                    VideoView.this.start();
//                }
//            }
//        };
//        this.mCompletionListener = new OnCompletionListener() {
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                VideoView.this.mCurrentState = 5;
//                VideoView.this.mTargetState = 5;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                if (VideoView.this.mOnCompletionListener != null) {
//                    VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
//                }
//            }
//        };
//        this.mInfoListener = new OnInfoListener() {
//            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
//                if (VideoView.this.mOnInfoListener != null) {
//                    VideoView.this.mOnInfoListener.onInfo(mediaPlayer, i, i2);
//                }
//                return true;
//            }
//        };
//        this.mErrorListener = new OnErrorListener() {
//            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
//                Log.d(VideoView.this.TAG, "Error: " + i + "," + i2);
//                VideoView.this.mCurrentState = -1;
//                VideoView.this.mTargetState = -1;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                if (VideoView.this.mOnErrorListener == null || VideoView.this.mOnErrorListener.onError(VideoView.this.mMediaPlayer, i, i2)) {
//                }
//                return true;
//            }
//        };
//        this.mBufferingUpdateListener = new OnBufferingUpdateListener() {
//            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
//                VideoView.this.mCurrentBufferPercentage = i;
//            }
//        };
//        this.mSHCallback = new Callback() {
//            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
//                boolean z = true;
//                VideoView.this.mSurfaceWidth = i2;
//                VideoView.this.mSurfaceHeight = i3;
//                boolean z2 = VideoView.this.mTargetState == 3;
//                if (!(VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3)) {
//                    z = false;
//                }
//                Log.d(VideoView.this.TAG, "surfaceChanged " + i2 + "/" + i3 + ", " + z2 + ", " + z);
//                if (VideoView.this.mMediaPlayer != null && z2 && z) {
//                    if (VideoView.this.mSeekWhenPrepared != 0) {
//                        VideoView.this.seekTo(VideoView.this.mSeekWhenPrepared);
//                    }
//                    VideoView.this.start();
//                }
//            }
//
//            public void surfaceCreated(SurfaceHolder surfaceHolder) {
//                Log.d(VideoView.this.TAG, "surfaceCreated");
//                VideoView.this.mSurfaceHolder = surfaceHolder;
//                VideoView.this.openVideo();
//            }
//
//            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//                Log.d(VideoView.this.TAG, "surfaceDestroyed");
//                VideoView.this.mSurfaceHolder = null;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                VideoView.this.release(true);
//            }
//        };
//        initVideoView();
//    }
//
//    public VideoView(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0);
//        initVideoView();
//    }
//
//    public VideoView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.TAG = "VideoView";
//        this.mCurrentState = 0;
//        this.mTargetState = 0;
//        this.mSurfaceHolder = null;
//        this.mMediaPlayer = null;
//        this.mSizeChangedListener = new OnVideoSizeChangedListener() {
//            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
//                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
//                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
//                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
//                    Log.d(VideoView.this.TAG, "OnVideoSizeChangedListener " + VideoView.this.mVideoWidth + "/" + VideoView.this.mVideoHeight);
//                    VideoView.this.requestLayout();
//                }
//            }
//        };
//        this.mPreparedListener = new OnPreparedListener() {
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                VideoView.this.mCurrentState = 2;
//                VideoView.this.mCanPause = VideoView.this.mCanSeekBack = VideoView.this.mCanSeekForward = true;
//                if (VideoView.this.mOnPreparedListener != null) {
//                    VideoView.this.mOnPreparedListener.onPrepared(VideoView.this.mMediaPlayer);
//                }
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.setEnabled(true);
//                }
//                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
//                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
//                int access$1000 = VideoView.this.mSeekWhenPrepared;
//                if (access$1000 != 0) {
//                    VideoView.this.seekTo(access$1000);
//                }
//                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
//                    Log.i(VideoView.this.TAG, "video size: " + VideoView.this.mVideoWidth + "/" + VideoView.this.mVideoHeight + ", surfaceSize " + VideoView.this.mSurfaceWidth + "/" + VideoView.this.mSurfaceHeight + ", ");
//                    if (VideoView.this.mTargetState == 3) {
//                        VideoView.this.start();
//                        if (VideoView.this.mMediaController != null) {
//                            VideoView.this.mMediaController.show();
//                        }
//                    } else if (VideoView.this.isPlaying()) {
//                    } else {
//                        if ((access$1000 != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.mMediaController != null) {
//                            VideoView.this.mMediaController.show(0);
//                        }
//                    }
//                } else if (VideoView.this.mTargetState == 3) {
//                    VideoView.this.start();
//                }
//            }
//        };
//        this.mCompletionListener = new OnCompletionListener() {
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                VideoView.this.mCurrentState = 5;
//                VideoView.this.mTargetState = 5;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                if (VideoView.this.mOnCompletionListener != null) {
//                    VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
//                }
//            }
//        };
//        this.mInfoListener = new OnInfoListener() {
//            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
//                if (VideoView.this.mOnInfoListener != null) {
//                    VideoView.this.mOnInfoListener.onInfo(mediaPlayer, i, i2);
//                }
//                return true;
//            }
//        };
//        this.mErrorListener = new OnErrorListener() {
//            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
//                Log.d(VideoView.this.TAG, "Error: " + i + "," + i2);
//                VideoView.this.mCurrentState = -1;
//                VideoView.this.mTargetState = -1;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                if (VideoView.this.mOnErrorListener == null || VideoView.this.mOnErrorListener.onError(VideoView.this.mMediaPlayer, i, i2)) {
//                }
//                return true;
//            }
//        };
//        this.mBufferingUpdateListener = new OnBufferingUpdateListener() {
//            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
//                VideoView.this.mCurrentBufferPercentage = i;
//            }
//        };
//        this.mSHCallback = new Callback() {
//            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
//                boolean z = true;
//                VideoView.this.mSurfaceWidth = i2;
//                VideoView.this.mSurfaceHeight = i3;
//                boolean z2 = VideoView.this.mTargetState == 3;
//                if (!(VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3)) {
//                    z = false;
//                }
//                Log.d(VideoView.this.TAG, "surfaceChanged " + i2 + "/" + i3 + ", " + z2 + ", " + z);
//                if (VideoView.this.mMediaPlayer != null && z2 && z) {
//                    if (VideoView.this.mSeekWhenPrepared != 0) {
//                        VideoView.this.seekTo(VideoView.this.mSeekWhenPrepared);
//                    }
//                    VideoView.this.start();
//                }
//            }
//
//            public void surfaceCreated(SurfaceHolder surfaceHolder) {
//                Log.d(VideoView.this.TAG, "surfaceCreated");
//                VideoView.this.mSurfaceHolder = surfaceHolder;
//                VideoView.this.openVideo();
//            }
//
//            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//                Log.d(VideoView.this.TAG, "surfaceDestroyed");
//                VideoView.this.mSurfaceHolder = null;
//                if (VideoView.this.mMediaController != null) {
//                    VideoView.this.mMediaController.hide();
//                }
//                VideoView.this.release(true);
//            }
//        };
//        initVideoView();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        Log.i(this.TAG, "onMeasure(" + MeasureSpec.toString(i) + ", " + MeasureSpec.toString(i2) + ")");
//        setMeasuredDimension(getDefaultSize(this.mVideoWidth, i), getDefaultSize(this.mVideoHeight, i2));
//    }
//
//    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
//        super.onInitializeAccessibilityEvent(accessibilityEvent);
//        accessibilityEvent.setClassName(VideoView.class.getName());
//    }
//
//    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
//        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
//    }
//
//    public int resolveAdjustedSize(int i, int i2) {
//        return getDefaultSize(i, i2);
//    }
//
//    private void initVideoView() {
//        this.mContext = getContext();
//        this.mVideoWidth = 0;
//        this.mVideoHeight = 0;
//        getHolder().addCallback(this.mSHCallback);
//        getHolder().setType(3);
//        setFocusable(true);
//        setFocusableInTouchMode(true);
//        requestFocus();
//        this.mPendingSubtitleTracks = new Vector<>();
//        this.mCurrentState = 0;
//        this.mTargetState = 0;
//    }
//
//    public void setVideoPath(String str) {
//        setVideoURI(Uri.parse(str));
//    }
//
//    public void setVideoURI(Uri uri) {
//        setVideoURI(uri, null);
//    }
//
//    public void setVideoURI(Uri uri, Map<String, String> map) {
//        this.mUri = uri;
//        this.mSeekWhenPrepared = 0;
//        openVideo();
//        requestLayout();
//        invalidate();
//    }
//
//    public void stopPlayback() {
//        if (this.mMediaPlayer != null) {
//            this.mMediaPlayer.stop();
//            this.mMediaPlayer.release();
//            this.mMediaPlayer = null;
//            this.mCurrentState = 0;
//            this.mTargetState = 0;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void openVideo() {
//        if (this.mUri == null || this.mSurfaceHolder == null) {
//            Log.d(this.TAG, "openVideo SurfaceHolder null");
//            return;
//        }
//        Log.d(this.TAG, "openVideo");
//        Intent intent = new Intent("com.android.music.musicservicecommand");
//        intent.putExtra("command", "pause");
//        this.mContext.sendBroadcast(intent);
//        release(false);
//        try {
//            this.mMediaPlayer = new MediaPlayer();
//            getContext();
//            if (this.mAudioSession != 0) {
//                this.mMediaPlayer.setAudioSessionId(this.mAudioSession);
//            } else {
//                this.mAudioSession = this.mMediaPlayer.getAudioSessionId();
//            }
//            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
//            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
//            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
//            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
//            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
//            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
//            this.mCurrentBufferPercentage = 0;
//            this.mMediaPlayer.setDataSource(this.mContext, this.mUri);
//            this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
//            this.mMediaPlayer.setAudioStreamType(3);
//            this.mMediaPlayer.setScreenOnWhilePlaying(true);
//            this.mMediaPlayer.prepareAsync();
//            this.mCurrentState = 1;
//            attachMediaController();
//        } catch (IOException e) {
//            Log.w(this.TAG, "Unable to open content: " + this.mUri, e);
//            this.mCurrentState = -1;
//            this.mTargetState = -1;
//            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
//        } catch (IllegalArgumentException e2) {
//            Log.w(this.TAG, "Unable to open content: " + this.mUri, e2);
//            this.mCurrentState = -1;
//            this.mTargetState = -1;
//            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
//        } finally {
//            this.mPendingSubtitleTracks.clear();
//        }
//    }
//
//    public void setMediaController(MediaController mediaController) {
//        if (this.mMediaController != null) {
//            this.mMediaController.hide();
//        }
//        this.mMediaController = mediaController;
//        attachMediaController();
//    }
//
//    private void attachMediaController() {
//        if (this.mMediaPlayer != null && this.mMediaController != null) {
//            this.mMediaController.setMediaPlayer(this);
//            this.mMediaController.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
//            this.mMediaController.setEnabled(isInPlaybackState());
//        }
//    }
//
//    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
//        this.mOnPreparedListener = onPreparedListener;
//    }
//
//    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
//        this.mOnCompletionListener = onCompletionListener;
//    }
//
//    public void setOnErrorListener(OnErrorListener onErrorListener) {
//        this.mOnErrorListener = onErrorListener;
//    }
//
//    public void setOnInfoListener(OnInfoListener onInfoListener) {
//        this.mOnInfoListener = onInfoListener;
//    }
//
//    /* access modifiers changed from: private */
//    public void release(boolean z) {
//        if (this.mMediaPlayer != null) {
//            new AsyncTask<MediaPlayer, Void, Void>() {
//                /* access modifiers changed from: protected */
//                public Void doInBackground(MediaPlayer... mediaPlayerArr) {
//                    try {
//                        MediaPlayer mediaPlayer = mediaPlayerArr[0];
//                        mediaPlayer.reset();
//                        mediaPlayer.release();
//                    } catch (Exception e) {
//                    }
//                    return null;
//                }
//            }.execute(new MediaPlayer[]{this.mMediaPlayer});
//            this.mMediaPlayer = null;
//            this.mPendingSubtitleTracks.clear();
//            this.mCurrentState = 0;
//            if (z) {
//                this.mTargetState = 0;
//            }
//        }
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if (isInPlaybackState() && this.mMediaController != null) {
//            toggleMediaControlsVisiblity();
//        }
//        return false;
//    }
//
//    public boolean onTrackballEvent(MotionEvent motionEvent) {
//        if (isInPlaybackState() && this.mMediaController != null) {
//            toggleMediaControlsVisiblity();
//        }
//        return false;
//    }
//
//    public boolean onKeyDown(int i, KeyEvent keyEvent) {
//        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
//        if (isInPlaybackState() && z && this.mMediaController != null) {
//            if (i == 79 || i == 85) {
//                if (this.mMediaPlayer.isPlaying()) {
//                    pause();
//                    this.mMediaController.show();
//                    return true;
//                }
//                start();
//                this.mMediaController.hide();
//                return true;
//            } else if (i == 126) {
//                if (this.mMediaPlayer.isPlaying()) {
//                    return true;
//                }
//                start();
//                this.mMediaController.hide();
//                return true;
//            } else if (i != 86 && i != 127) {
//                toggleMediaControlsVisiblity();
//            } else if (!this.mMediaPlayer.isPlaying()) {
//                return true;
//            } else {
//                pause();
//                this.mMediaController.show();
//                return true;
//            }
//        }
//        return super.onKeyDown(i, keyEvent);
//    }
//
//    private void toggleMediaControlsVisiblity() {
//        if (this.mMediaController.isShowing()) {
//            this.mMediaController.hide();
//        } else {
//            this.mMediaController.show();
//        }
//    }
//
//    public void start() {
//        Log.i(this.TAG, MessageKey.MSG_ACCEPT_TIME_START);
//        if (isInPlaybackState()) {
//            this.mMediaPlayer.start();
//            this.mCurrentState = 3;
//        }
//        this.mTargetState = 3;
//    }
//
//    public void pause() {
//        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
//            this.mMediaPlayer.pause();
//            this.mCurrentState = 4;
//        }
//        this.mTargetState = 4;
//    }
//
//    public void suspend() {
//        release(false);
//    }
//
//    public void resume() {
//        openVideo();
//    }
//
//    public int getDuration() {
//        if (isInPlaybackState()) {
//            return this.mMediaPlayer.getDuration();
//        }
//        return -1;
//    }
//
//    public int getCurrentPosition() {
//        if (isInPlaybackState()) {
//            return this.mMediaPlayer.getCurrentPosition();
//        }
//        return 0;
//    }
//
//    public void seekTo(int i) {
//        if (isInPlaybackState()) {
//            this.mMediaPlayer.seekTo(i);
//            this.mSeekWhenPrepared = 0;
//            return;
//        }
//        this.mSeekWhenPrepared = i;
//    }
//
//    public boolean isPlaying() {
//        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
//    }
//
//    public int getBufferPercentage() {
//        if (this.mMediaPlayer != null) {
//            return this.mCurrentBufferPercentage;
//        }
//        return 0;
//    }
//
//    private boolean isInPlaybackState() {
//        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
//    }
//
//    public boolean canPause() {
//        return this.mCanPause;
//    }
//
//    public boolean canSeekBackward() {
//        return this.mCanSeekBack;
//    }
//
//    public boolean canSeekForward() {
//        return this.mCanSeekForward;
//    }
//
//    public int getAudioSessionId() {
//        if (this.mAudioSession == 0) {
//            MediaPlayer mediaPlayer = new MediaPlayer();
//            this.mAudioSession = mediaPlayer.getAudioSessionId();
//            mediaPlayer.release();
//        }
//        return this.mAudioSession;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
//        super.onLayout(z, i, i2, i3, i4);
//    }
//
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//    }
//
//    private void measureAndLayoutSubtitleWidget() {
//        getWidth();
//        getPaddingLeft();
//        getPaddingRight();
//        getHeight();
//        getPaddingTop();
//        getPaddingBottom();
//    }
//}
