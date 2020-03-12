//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.media.MediaPlayer;
//import android.media.MediaPlayer.OnCompletionListener;
//import android.media.MediaPlayer.OnErrorListener;
//import android.media.MediaPlayer.OnPreparedListener;
//import android.net.Uri;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.view.RotatingImageView;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//
//public class WikiVideoView extends FrameLayout implements OnClickListener {
//    private static final int ASPECT_H = 9;
//    private static final int ASPECT_W = 16;
//    private static final String TAG = WikiVideoView.class.getSimpleName();
//    private boolean mExpanded;
//    private boolean mHasUriSetted;
//    private int mInitHeight;
//    private int mInitWidth;
//    /* access modifiers changed from: private */
//    public RotatingImageView mLoadingView;
//    private ImageView mPlayButton;
//    /* access modifiers changed from: private */
//    public boolean mPrepared;
//    private ImageView mSnapShot;
//    private Uri mUri;
//    private VideoView mVideoView;
//
//    public WikiVideoView(Context context) {
//        this(context, null, 0);
//    }
//
//    public WikiVideoView(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0);
//    }
//
//    public WikiVideoView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mHasUriSetted = false;
//        this.mPrepared = false;
//        this.mExpanded = false;
//        this.mInitWidth = -1;
//        this.mInitHeight = -1;
//        LayoutInflater.from(context).inflate(R.layout.wiki_video_view, this, true);
//        this.mVideoView = (VideoView) findViewById(R.id.video_view);
//        this.mSnapShot = (ImageView) findViewById(R.id.snapshot);
//        this.mPlayButton = (ImageView) findViewById(R.id.play);
//        this.mLoadingView = (RotatingImageView) findViewById(R.id.loading_view);
//        setOnClickListener(this);
//        this.mPlayButton.setOnClickListener(this);
//        this.mVideoView.setOnErrorListener(new OnErrorListener() {
//            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
//                return true;
//            }
//        });
//        this.mVideoView.setOnCompletionListener(new OnCompletionListener() {
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                WikiVideoView.this.reset(false);
//            }
//        });
//        this.mVideoView.setOnPreparedListener(new OnPreparedListener() {
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                WikiVideoView.this.mPrepared = true;
//                WikiVideoView.this.mLoadingView.setVisibility(8);
//            }
//        });
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        int size = MeasureSpec.getSize(i);
//        int size2 = MeasureSpec.getSize(i2);
//        Log.d(TAG, "onMeasure " + size + ", " + size2);
//        int i3 = size * 9;
//        int i4 = size2 * 16;
//        if (i4 == 0) {
//            size2 = i3 / 16;
//        }
//        if (i3 == 0) {
//            size = i4 / 9;
//        }
//        if (i3 > 0 && i4 > 0) {
//            if (i3 > i4) {
//                size = i4 / 9;
//            } else {
//                size2 = i3 / 16;
//            }
//        }
//        if (!this.mExpanded && size > 0 && size2 > 0) {
//            this.mInitWidth = size;
//            this.mInitHeight = size2;
//        }
//        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(size2, 1073741824));
//    }
//
//    public void setSnapshot(String str) {
//        if (TextUtils.isEmpty(str)) {
//            Picasso.with(getContext()).load((int) R.drawable.tv_default_normal_default).into(this.mSnapShot, (Callback) null);
//            return;
//        }
//        RequestCreator b = Picasso.with(getContext()).load(str).placeholder((int) R.drawable.tv_default_normal_default).error(R.drawable.tv_default_normal_default);
//        b.f3707c = true;
//        b.into(this.mSnapShot, (Callback) null);
//    }
//
//    public void setVideoURI(String str) {
//        try {
//            this.mUri = Uri.parse(str);
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, e.toString());
//            this.mUri = null;
//        }
//    }
//
//    public void doPauseResume() {
//        if (this.mVideoView.isPlaying()) {
//            pause();
//            return;
//        }
//        start(-1);
//        OperationStats.statWikiTV();
//    }
//
//    public void pause() {
//        this.mPlayButton.setVisibility(0);
//        this.mVideoView.pause();
//    }
//
//    public void start(int i) {
//        if (!this.mHasUriSetted) {
//            this.mHasUriSetted = true;
//            this.mVideoView.setVideoURI(this.mUri);
//        }
//        this.mVideoView.setVisibility(0);
//        this.mSnapShot.setVisibility(4);
//        this.mPlayButton.setVisibility(4);
//        expandHorizontal();
//        if (i >= 0) {
//            this.mVideoView.seekTo(i);
//        }
//        this.mVideoView.start();
//        if (!this.mPrepared) {
//            this.mLoadingView.setVisibility(0);
//        }
//    }
//
//    public void reset(boolean z) {
//        if (this.mVideoView.isPlaying() || this.mVideoView.getCurrentPosition() > 0) {
//            this.mVideoView.seekTo(0);
//            this.mVideoView.pause();
//        }
//        this.mSnapShot.setVisibility(0);
//        this.mPlayButton.setVisibility(0);
//        this.mLoadingView.setVisibility(8);
//        if (z) {
//            this.mExpanded = false;
//            LayoutParams layoutParams = getLayoutParams();
//            layoutParams.width = this.mInitWidth;
//            layoutParams.height = this.mInitHeight;
//            setLayoutParams(layoutParams);
//        }
//    }
//
//    public void expandHorizontal() {
//        if (!this.mExpanded) {
//            LayoutParams layoutParams = getLayoutParams();
//            layoutParams.width = -1;
//            layoutParams.height = 0;
//            setLayoutParams(layoutParams);
//            this.mExpanded = true;
//            requestLayout();
//            invalidate();
//        }
//    }
//
//    public void onClick(View view) {
//        if (view != this) {
//            switch (view.getId()) {
//                case R.id.play /*2131297129*/:
//                    break;
//                default:
//                    return;
//            }
//        }
//        doPauseResume();
//    }
//}
