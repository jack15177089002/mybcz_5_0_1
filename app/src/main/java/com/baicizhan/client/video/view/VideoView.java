//package com.baicizhan.client.video.view;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.os.Build.VERSION;
//import android.os.Handler;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceHolder.Callback;
//import android.view.SurfaceView;
//import android.view.View;
//import android.view.View.BaseSavedState;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.util.PhoneCallMoniter;
//import com.baicizhan.client.business.util.PhoneCallMoniter.PhoneCallListener;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.framework.util.SystemKeyguardUtil;
////import com.baicizhan.client.video.R;
//import com.baicizhan.client.video.VideoAppHandler;
//import com.baicizhan.client.video.data.VideoInfo;
//import com.baicizhan.client.video.load.VideoLoader;
//import com.baicizhan.client.video.load.VideoLoader.OnVideoLoadListener;
//import com.baicizhan.client.video.load.VideoLoaderCreator;
//import com.baicizhan.client.video.load.VideoLoaderCreator.OnVideoLoaderCreateListener;
//import com.baicizhan.client.video.load.VideoPlayer;
//import com.baicizhan.client.video.load.VideoPlayer.OnPlaySateListener;
//import com.baicizhan.client.video.load.VideoPlayer.State;
//import com.baicizhan.client.video.service.StateUpdateService;
//import com.baicizhan.client.video.stats.UMStats;
//import com.baicizhan.client.video.view.NavigationBar.OnSelectToggleListener;
//import com.baicizhan.client.video.view.PlayController.OnPlayerControlListener;
//import com.jiongji.andriod.card.R;
//
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.List;
//
//public class VideoView extends RelativeLayout implements Callback, OnClickListener, OnTouchListener, OnScrollListener, OnItemClickListener, PhoneCallListener, OnPlaySateListener, OnSelectToggleListener, OnPlayerControlListener {
//    private static final int THRESHOLD_4_MIDFIELD = 10;
//    /* access modifiers changed from: private */
//    public VideoAdapter mAdapter;
//    private CtrlAnimationManager mAnimManager;
//    private Handler mCommonHandler = new Handler();
//    private boolean mCreatingLoader = false;
//    /* access modifiers changed from: private */
//    public int mCur;
//    private int mCurMidfield = -1;
//    /* access modifiers changed from: private */
//    public VideoLoadTask mLoadTask = new VideoLoadTask(this);
//    private VideoLoader mLoader;
//    /* access modifiers changed from: private */
//    public TextView mLoading;
//    private View mMask;
//    private VideoLoader mMidfieldLoader;
//    private List<VideoInfo> mMidfieldVideos;
//    NavigationBar mNavBar;
//    private boolean mOffline = false;
//    private int mPersistCount;
//    PlayController mPlayCtrl;
//    ListView mPlayList;
//    private VideoPlayer mPlayer;
//    private boolean mResumed = false;
//    private SurfaceView mSurface;
//    private boolean mSurfaceEnabled = false;
//    private UMStats mUMStats;
//    private boolean mUserPresent = true;
//    /* access modifiers changed from: private */
//    public VideoLoaderCreator mVLCreator = new VideoLoaderCreator();
//    private TextView mVideoInfo;
//    View mVideoInfoLayout;
//    /* access modifiers changed from: private */
//    public List<VideoInfo> mVideos;
//    private boolean mWaitting = false;
//
//    class CreateLoaderRun implements Runnable {
//        final WeakReference<VideoView> mVideoView;
//
//        CreateLoaderRun(VideoView videoView) {
//            this.mVideoView = new WeakReference<>(videoView);
//            if (videoView != null && videoView.mVideos != null) {
//                videoView.mVideos.clear();
//                if (videoView.mAdapter != null) {
//                    videoView.mAdapter.notifyDataSetChanged();
//                }
//            }
//        }
//
//        public void run() {
//            VideoView videoView = (VideoView) this.mVideoView.get();
//            if (videoView != null) {
//                if (videoView.mVLCreator == null) {
//                    videoView.mVLCreator = new VideoLoaderCreator();
//                }
//                videoView.mVLCreator.create(videoView.mLoadTask, videoView.getContext());
//            }
//        }
//    }
//
//    class HideLoadingForNohostRun implements Runnable {
//        final WeakReference<VideoView> mVideoView;
//
//        HideLoadingForNohostRun(VideoView videoView) {
//            this.mVideoView = new WeakReference<>(videoView);
//        }
//
//        public void run() {
//            VideoView videoView = (VideoView) this.mVideoView.get();
//            if (videoView != null) {
//                if (!videoView.hasOfflineVideos()) {
//                    videoView.mLoading.setText(R.string.video_load_err_no_offline_video);
//                    return;
//                }
//                videoView.mLoading.setVisibility(8);
//                videoView.start();
//            }
//        }
//    }
//
//    class SavedState extends BaseSavedState {
//        public  final Creator<SavedState> CREATOR = new Creator<SavedState>() {
//            public final SavedState createFromParcel(Parcel parcel) {
//                return new SavedState(parcel);
//            }
//
//            public final SavedState[] newArray(int i) {
//                return new SavedState[i];
//            }
//        };
//        int cur;
//        int curMidfield = -1;
//
//        public SavedState(Parcelable parcelable) {
//            super(parcelable);
//        }
//
//        public SavedState(Parcel parcel) {
//            super(parcel);
//            this.cur = parcel.readInt();
//            this.curMidfield = parcel.readInt();
//        }
//
//        public void writeToParcel(Parcel parcel, int i) {
//            super.writeToParcel(parcel, i);
//            parcel.writeInt(this.cur);
//            parcel.writeInt(this.curMidfield);
//        }
//    }
//
//    class VideoAdapter extends BaseAdapter {
//        private VideoAdapter() {
//        }
//
//        public int getCount() {
//            if (VideoView.this.mVideos != null) {
//                return VideoView.this.mVideos.size();
//            }
//            return 0;
//        }
//
//        public Object getItem(int i) {
//            if (VideoView.this.mVideos != null) {
//                return VideoView.this.mVideos.get(i);
//            }
//            return null;
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        @SuppressLint({"InflateParams"})
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = ((LayoutInflater) VideoView.this.getContext().getSystemService("layout_inflater")).inflate(R.layout.video_list_item, null);
//                ViewHolder viewHolder2 = new ViewHolder();
//                viewHolder2.word = (TextView) view.findViewById(R.id.video_play_word);
//                view.setTag(viewHolder2);
//                viewHolder = viewHolder2;
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            if (VideoView.this.mVideos != null) {
//                viewHolder.word.setText(((VideoInfo) VideoView.this.mVideos.get(i)).getWord());
//            }
//            return view;
//        }
//    }
//
//    final class VideoLoadTask implements OnVideoLoadListener, OnVideoLoaderCreateListener {
//        final SimpleBackoff mBackoff = new SimpleBackoff();
//        final WeakReference<VideoView> mVideoView;
//
//        VideoLoadTask(VideoView videoView) {
//            this.mVideoView = new WeakReference<>(videoView);
//        }
//
//        public final void onVideoLoaderCreate(VideoLoader videoLoader, VideoLoader videoLoader2, int i) {
//            VideoView videoView = (VideoView) this.mVideoView.get();
//            if (videoView != null) {
//                if (-1 == i) {
//                    long backoff = this.mBackoff.getBackoff();
//                    if (backoff >= 0) {
//                        videoView.delayCreateLoader(backoff);
//                        return;
//                    }
//                }
//                this.mBackoff.reset();
//                videoView.onVideoLoaderCreate(videoLoader, videoLoader2, i);
//            }
//        }
//
//        public final void onLoaded(boolean z, String str) {
//            VideoView videoView = (VideoView) this.mVideoView.get();
//            if (videoView != null) {
//                videoView.onLoaded(z, str);
//            }
//        }
//
//        public final void onIdle() {
//            VideoView videoView = (VideoView) this.mVideoView.get();
//            if (videoView != null) {
//                videoView.onIdle();
//            }
//        }
//    }
//
//    class ViewHolder {
//        TextView word;
//
//        private ViewHolder() {
//        }
//    }
//
//    public VideoView(Context context) {
//        super(context);
//        this.mUMStats = new UMStats(context);
//    }
//
//    public VideoView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.mUMStats = new UMStats(context);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mSurface = (SurfaceView) findViewById(R.id.video_surface);
//        this.mNavBar = (NavigationBar) findViewById(R.id.video_ctrl_top);
//        this.mPlayCtrl = (PlayController) findViewById(R.id.video_ctrl_bottom);
//        this.mVideoInfoLayout = findViewById(R.id.video_info_layout);
//        this.mVideoInfo = (TextView) findViewById(R.id.video_info);
//        this.mPlayList = (ListView) findViewById(R.id.video_play_list);
//        this.mLoading = (TextView) findViewById(R.id.video_loading);
//        this.mMask = findViewById(R.id.video_mask);
//        this.mSurface.getHolder().addCallback(this);
//        API11_setSurfaceBufferType();
//        this.mNavBar.setOnSelectToggleListener(this);
//        this.mPlayCtrl.setOnPlayerControlListener(this);
//        this.mPlayList.setOnItemClickListener(this);
//        this.mMask.setOnClickListener(this);
//        this.mNavBar.setOnClickListener(this);
//        this.mPlayCtrl.setOnClickListener(this);
//        this.mVideoInfoLayout.setOnClickListener(this);
//        this.mVideoInfo.setText(getResources().getString(R.string.video_info_tip, new Object[]{Integer.valueOf(0)}));
//        this.mPlayList.setOnTouchListener(this);
//        this.mPlayList.setOnScrollListener(this);
//        this.mPlayer = VideoPlayer.create(this.mSurface.getHolder());
//        this.mLoading.setVisibility(0);
//        if (!Common.isScreenOn(getContext()) || SystemKeyguardUtil.isKeyguardLocked(getContext())) {
//            this.mUserPresent = false;
//        }
//        this.mAnimManager = new CtrlAnimationManager(this);
//        PhoneCallMoniter.born(getContext()).setListener(this).start();
//    }
//
//    private void API11_setSurfaceBufferType() {
//        if (VERSION.SDK_INT <= 11) {
//            this.mSurface.getHolder().setType(3);
//        }
//    }
//
//    public void startRun() {
//        if (this.mVLCreator != null && !this.mCreatingLoader) {
//            this.mCreatingLoader = true;
//            this.mVLCreator.create(this.mLoadTask, getContext());
//        }
//    }
//
//    public void destroy() {
//        StateUpdateService.start(getContext(), this.mVideos);
//        if (this.mPlayer != null) {
//            this.mPlayer.destroy();
//        }
//        if (this.mLoader != null) {
//            this.mLoader.cancel();
//        }
//        if (this.mMidfieldLoader != null) {
//            this.mMidfieldLoader.cancel();
//        }
//        if (this.mAnimManager != null) {
//            this.mAnimManager.destroy();
//        }
//        if (this.mCommonHandler != null) {
//            this.mCommonHandler.removeCallbacksAndMessages(null);
//        }
//    }
//
//    public void onSelectToggle(boolean z) {
//        this.mAnimManager.touchCtrls();
//    }
//
//    public void onToggle() {
//        if (this.mPlayer != null) {
//            this.mPlayer.toggle();
//        }
//        this.mAnimManager.touchCtrls();
//    }
//
//    public void onPrev() {
//        markSkipped(this.mCur, true);
//        playPrev();
//        this.mAnimManager.touchCtrls();
//        this.mPersistCount = 1;
//    }
//
//    public void onNext() {
//        markSkipped(this.mCur, true);
//        playNext();
//        this.mAnimManager.touchCtrls();
//        this.mPersistCount = 1;
//    }
//
//    public void onToggleInfo() {
//        this.mAnimManager.touchCtrls();
//        this.mAnimManager.toggleInfo(this.mVideos != null && this.mVideos.size() > 0);
//    }
//
//    public void onPlayStateChanged(State state) {
//        if (this.mPlayCtrl != null) {
//            this.mPlayCtrl.onPlayStateChanged(state);
//        }
//        switch (state) {
//            case Completed:
//                markSkipped(this.mCur, false);
//                if (this.mPersistCount >= 10) {
//                    playMidfield();
//                    return;
//                }
//                playNext();
//                this.mPersistCount++;
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
//        this.mSurfaceEnabled = true;
//    }
//
//    public void surfaceCreated(SurfaceHolder surfaceHolder) {
//        this.mSurfaceEnabled = true;
//        start();
//    }
//
//    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//        this.mSurfaceEnabled = false;
//        if (this.mPlayer != null) {
//            this.mPlayer.destroy();
//        }
//        this.mAnimManager.forceHide();
//    }
//
//    public void setResumed(boolean z) {
//        this.mResumed = z;
//        if (z) {
//            start();
//        }
//    }
//
//    public void setUserPresent(boolean z) {
//        this.mUserPresent = z;
//        if (z) {
//            start();
//        } else if (this.mPlayer != null && State.Playing == this.mPlayer.getPlayState()) {
//            this.mPlayer.pause();
//        }
//    }
//
//    private boolean canPlay() {
//        return this.mSurfaceEnabled && this.mResumed && this.mUserPresent;
//    }
//
//    public boolean isActive() {
//        if (this.mPlayer == null || (State.Playing != this.mPlayer.getPlayState() && State.Paused != this.mPlayer.getPlayState())) {
//            return false;
//        }
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public void onLoaded(boolean z, String str) {
//        Log.d("whiz", "on video loaded, url: " + str);
//        if (z) {
//            if (this.mWaitting) {
//                this.mWaitting = false;
//                this.mLoading.setVisibility(8);
//                if (!canPlay()) {
//                    C0789L.log.error("cannot play after loaded for not being prepared.");
//                } else if (this.mVideos == null || this.mVideos.isEmpty()) {
//                    C0789L.log.error("cannot play after loaded for videos data being empty.");
//                } else {
//                    if (this.mCur >= this.mVideos.size()) {
//                        this.mCur = 0;
//                    }
//                    File video = this.mLoader.getVideo(((VideoInfo) this.mVideos.get(this.mCur)).getPath());
//                    File videoFromUrl = this.mLoader.getVideoFromUrl(str);
//                    if (video == null || videoFromUrl == null || !video.getAbsolutePath().equals(videoFromUrl.getAbsolutePath())) {
//                        C0789L.log.error("cannot play after loaded for downloaded file is not the one should be played. should [{}], fact [{}]", (Object) video, (Object) videoFromUrl);
//                        this.mWaitting = true;
//                        return;
//                    }
//                    newPlay(videoFromUrl);
//                }
//            }
//        } else if (!isActive()) {
//            Log.d("whiz", "on load video failed, url: " + str);
//            int i = R.string.video_load_failed;
//            if (!NetworkUtils.isNetworkAvailable(getContext())) {
//                i = R.string.video_load_failed_4_no_net;
//            }
//            this.mLoading.setText(i);
//            this.mLoading.setVisibility(0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onIdle() {
//        if (this.mMidfieldVideos != null && !this.mMidfieldVideos.isEmpty() && canOnline()) {
//            this.mMidfieldLoader.load(null);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onVideoLoaderCreate(VideoLoader videoLoader, VideoLoader videoLoader2, int i) {
//        List<VideoInfo> list = null;
//        switch (i) {
//            case -3:
//            case -2:
//                if (videoLoader != null || this.mLoader != null) {
//                    int i2 = R.string.video_load_err_no_host;
//                    if (-3 == i) {
//                        i2 = R.string.video_load_err_usr_cancel;
//                    }
//                    this.mLoading.setText(i2);
//                    delayHideLoadingForNohost(2000);
//                    this.mLoader = videoLoader;
//                    this.mMidfieldLoader = videoLoader2;
//                    this.mVideos = videoLoader.getVideoInfos();
//                    if (this.mAdapter != null) {
//                        this.mAdapter.notifyDataSetChanged();
//                    }
//                    if (videoLoader2 != null) {
//                        list = videoLoader2.getVideoInfos();
//                    }
//                    this.mMidfieldVideos = list;
//                    this.mOffline = true;
//                    break;
//                } else {
//                    this.mLoading.setText(R.string.video_load_err_unkonwn);
//                    break;
//                }
//            case -1:
//                if (this.mLoader == null) {
//                    this.mLoading.setText(R.string.video_load_err_no_video);
//                    break;
//                }
//                break;
//            case 0:
//                if (videoLoader != null || this.mLoader != null) {
//                    this.mLoader = videoLoader;
//                    this.mMidfieldLoader = videoLoader2;
//                    this.mVideos = videoLoader.getVideoInfos();
//                    if (this.mAdapter != null) {
//                        this.mAdapter.notifyDataSetChanged();
//                    }
//                    if (videoLoader2 != null) {
//                        list = videoLoader2.getVideoInfos();
//                    }
//                    this.mMidfieldVideos = list;
//                    this.mOffline = false;
//                    start();
//                    break;
//                } else {
//                    this.mLoading.setText(R.string.video_load_err_unkonwn);
//                    break;
//                }
//        }
//        if (this.mVideos != null) {
//            this.mVideoInfo.setText(getResources().getString(R.string.video_info_tip, new Object[]{Integer.valueOf(this.mVLCreator.getVideoCount())}));
//        }
//        this.mAnimManager.delayHideCtrls();
//        this.mCreatingLoader = false;
//    }
//
//    public void onPhoneCallStart() {
//        if (this.mPlayer != null && State.Playing == this.mPlayer.getPlayState()) {
//            this.mPlayer.pause();
//        }
//    }
//
//    public void onPhoneCallStop() {
//    }
//
//    public void onScrollStateChanged(AbsListView absListView, int i) {
//        int lastVisiblePosition = absListView.getLastVisiblePosition();
//        if (i == 0 && this.mAdapter.getCount() - lastVisiblePosition <= 10) {
//            startRun();
//        }
//    }
//
//    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
//    }
//
//    /* access modifiers changed from: private */
//    public void delayCreateLoader(long j) {
//        this.mCommonHandler.postDelayed(new CreateLoaderRun(this), j);
//    }
//
//    private void delayHideLoadingForNohost(long j) {
//        this.mCommonHandler.postDelayed(new HideLoadingForNohostRun(this), j);
//    }
//
//    /* access modifiers changed from: private */
//    public boolean hasOfflineVideos() {
//        if (this.mVideos == null || this.mVideos.isEmpty() || this.mLoader == null) {
//            return false;
//        }
//        for (VideoInfo path : this.mVideos) {
//            File video = this.mLoader.getVideo(path.getPath());
//            if (video != null && video.exists()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /* access modifiers changed from: private */
//    public void start() {
//        int i = 0;
//        if (!isActive()) {
//            if (this.mAdapter == null) {
//                this.mAdapter = new VideoAdapter();
//                this.mPlayList.setAdapter(this.mAdapter);
//                this.mCur = 0;
//            } else {
//                i = this.mCur;
//            }
//            scrollToCur();
//            this.mPlayer.setOnPlaySateListener(this);
//            if (this.mVideos != null) {
//                play(i);
//                this.mPersistCount = 1;
//            }
//        }
//    }
//
//    private void playMidfield() {
//        if (this.mMidfieldVideos != null && !this.mMidfieldVideos.isEmpty()) {
//            this.mCurMidfield = (this.mCurMidfield + 1) % this.mMidfieldVideos.size();
//            File video = this.mMidfieldLoader.getVideo(((VideoInfo) this.mMidfieldVideos.get(this.mCurMidfield)).getPath());
//            if (video == null || !video.exists()) {
//                if (canOnline()) {
//                    this.mMidfieldLoader.load(this.mCurMidfield, null);
//                }
//                this.mCurMidfield = ((this.mCurMidfield - 1) + this.mMidfieldVideos.size()) % this.mMidfieldVideos.size();
//                playNext();
//                return;
//            }
//            this.mLoading.setVisibility(8);
//            if (canPlay()) {
//                if (this.mPlayer.newPlay(video.getAbsolutePath())) {
//                    this.mPersistCount = 0;
//                    return;
//                }
//            } else {
//                return;
//            }
//        }
//        playNext();
//    }
//
//    private void play(int i) {
//        while (this.mVideos != null && !this.mVideos.isEmpty()) {
//            if (i >= this.mVideos.size()) {
//                i = 0;
//            }
//            File video = this.mLoader.getVideo(((VideoInfo) this.mVideos.get(i)).getPath());
//            if (this.mOffline) {
//                if (canOnline()) {
//                    this.mLoading.setVisibility(0);
//                    this.mLoading.setText(R.string.video_loading_for_netchange);
//                    delayCreateLoader(2000);
//                    return;
//                } else if (video == null || !video.exists()) {
//                    Log.d("whiz", "next video file: " + video);
//                    if (hasOfflineVideos()) {
//                        playNext();
//                    } else {
//                        return;
//                    }
//                } else {
//                    this.mLoading.setVisibility(8);
//                    if (canPlay()) {
//                        newPlay(video);
//                    } else {
//                        return;
//                    }
//                }
//            } else if (!canOnline()) {
//                this.mLoader.cancel();
//                this.mMidfieldLoader.cancel();
//                Toast.makeText(getContext(), R.string.video_play_offline_for_netchange, 0).show();
//                this.mOffline = true;
//            } else {
//                if (video == null || !video.exists()) {
//                    Log.d("whiz", "play from net");
//                    this.mPlayer.release();
//                    this.mLoading.setText(R.string.video_caching);
//                    this.mLoading.setVisibility(0);
//                    this.mWaitting = true;
//                    this.mMidfieldLoader.cancel();
//                } else {
//                    Log.d("whiz", "play from local, can play? " + canPlay());
//                    this.mWaitting = false;
//                    this.mLoading.setVisibility(8);
//                    if (canPlay()) {
//                        newPlay(video);
//                    } else {
//                        return;
//                    }
//                }
//                this.mLoader.load(i, this.mLoadTask);
//            }
//            this.mPlayCtrl.setProgress(i + 1, this.mVLCreator.getVideoCount());
//            return;
//        }
//    }
//
//    private void playNext() {
//        if (this.mPlayList != null && this.mVideos != null) {
//            this.mCur = (this.mCur + 1) % this.mVideos.size();
//            scrollToCur();
//            play(this.mCur);
//        }
//    }
//
//    private void playPrev() {
//        if (this.mPlayList != null && this.mVideos != null) {
//            this.mCur = ((this.mCur - 1) + this.mVideos.size()) % this.mVideos.size();
//            scrollToCur();
//            play(this.mCur);
//        }
//    }
//
//    private void scrollToCur() {
//        if (Math.abs(this.mCur - this.mPlayList.getFirstVisiblePosition()) > 3) {
//            this.mPlayList.post(new Runnable() {
//                public void run() {
//                    VideoView.this.mPlayList.setSelection(VideoView.this.mCur);
//                }
//            });
//        } else {
//            this.mPlayList.smoothScrollToPosition(this.mCur);
//        }
//        this.mPlayList.setItemChecked(this.mCur, true);
//    }
//
//    private void stop() {
//        if (this.mPlayer != null) {
//            this.mPlayer.stop();
//        }
//    }
//
//    private boolean newPlay(File file) {
//        if (this.mAdapter.getCount() - this.mCur <= 10) {
//            startRun();
//        }
//        if (this.mPlayer.newPlay(file.getAbsolutePath())) {
//            markViewed(this.mCur);
//            return true;
//        }
//        C0789L.log.error("video play failed for damaged video file [{}], delete it and re dwonload", (Object) file);
//        file.delete();
//        play(this.mCur);
//        return false;
//    }
//
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//        if (this.mCur != i) {
//            markSkipped(this.mCur, true);
//            stop();
//            this.mCur = i;
//            play(i);
//            this.mPersistCount = 1;
//        }
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        this.mAnimManager.touchCtrls();
//        return false;
//    }
//
//    public void onClick(View view) {
//        if (this.mMask == view) {
//            this.mAnimManager.touchContent();
//        } else {
//            this.mAnimManager.touchCtrls();
//        }
//    }
//
//    private boolean canOnline() {
//        switch (NetworkUtils.getActiveNetworkType(VideoAppHandler.getApp())) {
//            case -1:
//            case 3:
//                return false;
//            case 1:
//            case 2:
//                if (!this.mVLCreator.is3G4GCapable()) {
//                    return false;
//                }
//                break;
//        }
//        return true;
//    }
//
//    private void markViewed(int i) {
//        if (this.mVideos != null && i >= 0 && i < this.mVideos.size()) {
//            ((VideoInfo) this.mVideos.get(i)).accumViewed();
//        }
//    }
//
//    private void markSkipped(int i, boolean z) {
//        if (this.mVideos != null && i >= 0 && i < this.mVideos.size()) {
//            ((VideoInfo) this.mVideos.get(i)).setSkipped(z);
//            if (z) {
//                this.mUMStats.statSkippedWord(((VideoInfo) this.mVideos.get(i)).getWord());
//            }
//        }
//    }
//
//    public Parcelable onSaveInstanceState() {
//        SavedState savedState = new SavedState(super.onSaveInstanceState());
//        savedState.cur = this.mCur;
//        savedState.curMidfield = this.mCurMidfield;
//        return savedState;
//    }
//
//    public void onRestoreInstanceState(Parcelable parcelable) {
//        SavedState savedState = (SavedState) parcelable;
//        super.onRestoreInstanceState(savedState.getSuperState());
//        this.mCur = savedState.cur;
//        this.mCurMidfield = savedState.curMidfield;
//        if (this.mPlayList != null && this.mPlayList.getCount() > this.mCur) {
//            this.mPlayList.setSelection(this.mCur);
//        }
//    }
//}
