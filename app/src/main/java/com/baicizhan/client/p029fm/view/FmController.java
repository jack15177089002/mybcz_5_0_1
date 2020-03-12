//package com.baicizhan.client.p029fm.view;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Handler;
//import android.os.Message;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageButton;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.CommentCircleProgressView;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.data.load.AllDownloader;
//import com.baicizhan.client.p029fm.data.load.AllDownloader.OnAllDownloadListener;
//import com.baicizhan.client.p029fm.data.load.AllDownloaderCreator;
//import com.baicizhan.client.p029fm.data.load.AllDownloaderCreator.Builder;
//import com.baicizhan.client.p029fm.data.load.AllDownloaderCreator.OnAllDownloaderCreateListener;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ClickEvent;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import com.baicizhan.client.p029fm.view.FmSettingsView.OnFmSettingsChangeListener;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmController */
//public class FmController extends RelativeLayout implements OnClickListener, OnAllDownloadListener, OnAllDownloaderCreateListener, OnFmSettingsChangeListener {
//    /* access modifiers changed from: private */
//    public boolean mAnimating = false;
//    private View mBG;
//    private View mBottom;
//    private boolean mCtrlsHide = false;
//    private TextView mCur;
//    private AllDownloaderCreator mDNDCreator;
//    private TextView mDownAll;
//    private CommentCircleProgressView mDowningAll;
//    /* access modifiers changed from: private */
//    public boolean mDownloadToggling = false;
//    private AllDownloader mDownloader;
//    private CtrlsHideHandler mHandler;
//    private View mHome;
//    private OnPlayerControlListener mListener;
//    private TextView mMax;
//    private ProgressBar mProgress;
//    private View mSettings;
//    private FmSettingsView mSettingsPanel;
//    private ImageButton mToggle;
//    private View mTop;
//
//    /* renamed from: com.baicizhan.client.fm.view.FmController$CtrlsHideHandler */
//    class CtrlsHideHandler extends Handler {
//        final WeakReference<FmController> mController;
//
//        CtrlsHideHandler(FmController fmController) {
//            this.mController = new WeakReference<>(fmController);
//        }
//
//        public void handleMessage(Message message) {
//            if (message.what == 0) {
//                FmController fmController = (FmController) this.mController.get();
//                if (fmController != null) {
//                    fmController.fadeoOutCtrls();
//                }
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmController$OnPlayerControlListener */
//    public interface OnPlayerControlListener {
//        void onToggle();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setOnPlayerControlListener(OnPlayerControlListener onPlayerControlListener) {
//        this.mListener = onPlayerControlListener;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void addOnFmSettingsChangeListener(OnFmSettingsChangeListener onFmSettingsChangeListener) {
//        if (this.mSettingsPanel != null) {
//            this.mSettingsPanel.mListeners.add(onFmSettingsChangeListener);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setProgress(int i, int i2) {
//        if (i >= 0 && i2 > 0 && i <= i2) {
//            int i3 = (i * 100) / i2;
//            if (this.mProgress != null) {
//                this.mProgress.setProgress(i3);
//            }
//            if (this.mCur != null) {
//                this.mCur.setText(String.valueOf(i));
//            }
//            if (this.mMax != null) {
//                this.mMax.setText(String.valueOf(i2));
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void updateFmCount(int i) {
//        if (this.mSettingsPanel != null) {
//            this.mSettingsPanel.updateFmCount(i);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onPlayStateChanged(int i) {
//        Log.d("whiz", "play state: " + i);
//        switch (i) {
//            case 2:
//                this.mToggle.setEnabled(true);
//                this.mToggle.setImageResource(R.drawable.pause_default);
//                return;
//            case 3:
//                this.mToggle.setEnabled(true);
//                this.mToggle.setImageResource(R.drawable.play_default);
//                return;
//            default:
//                this.mToggle.setEnabled(false);
//                return;
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void initAllDownload() {
//        if (this.mDNDCreator != null) {
//            this.mDNDCreator.create();
//        }
//    }
//
//    public FmController(Context context) {
//        super(context);
//    }
//
//    public FmController(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
////        EventBus.m0a().mo5a((Object) this);
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
////        EventBus.m0a().mo8b((Object) this);
//        cancelDelayHideCtrls();
//        if (this.mDNDCreator != null) {
//            this.mDNDCreator.destroy();
//        }
//        if (this.mDownloader != null) {
//            if (this.mDownloader.isDownloading()) {
//                this.mDownloader.cancel();
//            }
//            this.mDownloader.destroy();
//        }
//    }
//
//    public void onEventMainThread(ClickEvent clickEvent) {
//        if (clickEvent != null) {
//            switch (clickEvent.getClickType()) {
//                case 0:
//                    touchContent();
//                    return;
//                case 1:
//                    touchCtrls();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mBG = findViewById(R.id.fm_controller_bg);
//        this.mBG.setOnClickListener(this);
//        this.mTop = findViewById(R.id.fm_controller_top);
//        this.mTop.setOnClickListener(this);
//        this.mHome = findViewById(R.id.fm_home);
//        this.mHome.setOnClickListener(this);
//        this.mProgress = (ProgressBar) findViewById(R.id.fm_play_progress);
//        ThemeResUtil.setBaicizhanProgress(getContext(), this.mProgress);
//        this.mCur = (TextView) findViewById(R.id.fm_cur_progress);
//        this.mMax = (TextView) findViewById(R.id.fm_max_progress);
//        this.mSettings = findViewById(R.id.fm_settings);
//        this.mSettings.setOnClickListener(this);
//        this.mSettingsPanel = (FmSettingsView) findViewById(R.id.fm_settings_panel);
//        addOnFmSettingsChangeListener(this);
//        this.mBottom = findViewById(R.id.fm_controller_bottom);
//        this.mBottom.setOnClickListener(this);
//        this.mToggle = (ImageButton) findViewById(R.id.fm_toggle);
//        this.mToggle.setOnClickListener(this);
//        this.mDownAll = (TextView) findViewById(R.id.fm_download);
//        this.mDownAll.setOnClickListener(this);
//        this.mDowningAll = (CommentCircleProgressView) findViewById(R.id.fm_downloading);
//        this.mDowningAll.setOnClickListener(this);
//        this.mDowningAll.setVisibility(8);
//        this.mDowningAll.setComment(R.string.fm_download_all);
//        this.mDNDCreator = new Builder().with(getContext()).setBookid(StudyManager.getInstance().getCurrentBookId()).downloadHigh(FmSettings.isDownloadHigh()).setCreateCallback(this).setDownloadCallback(this).build();
//        this.mHandler = new CtrlsHideHandler(this);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mBG) {
//            touchContent();
//        } else {
//            touchCtrls();
//        }
//        if (view == this.mHome) {
//            doHome();
//        } else if (view == this.mSettings) {
//            doSettings();
//        } else if (view == this.mToggle) {
//            doToggle();
//        } else if (view != this.mDownAll && view != this.mDowningAll) {
//        } else {
//            if ((this.mDownloader == null || !this.mDownloader.hasDownloaded()) && !this.mDownloadToggling) {
//                this.mDownloadToggling = true;
//                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadeout);
//                Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein);
//                loadAnimation2.setStartOffset(400);
//                loadAnimation.setAnimationListener(new AnimationListener() {
//                    public void onAnimationStart(Animation animation) {
//                    }
//
//                    public void onAnimationEnd(Animation animation) {
//                        FmController.this.mDownloadToggling = false;
//                    }
//
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//                });
//                loadAnimation2.setAnimationListener(new AnimationListener() {
//                    public void onAnimationStart(Animation animation) {
//                    }
//
//                    public void onAnimationEnd(Animation animation) {
//                        FmController.this.mDownloadToggling = false;
//                    }
//
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//                });
//                if (view == this.mDownAll) {
//                    this.mDownAll.setVisibility(8);
//                    this.mDownAll.startAnimation(loadAnimation);
//                    this.mDowningAll.setVisibility(0);
//                    this.mDowningAll.startAnimation(loadAnimation2);
//                } else {
//                    this.mDowningAll.setVisibility(8);
//                    this.mDowningAll.startAnimation(loadAnimation);
//                    this.mDownAll.setVisibility(0);
//                    this.mDownAll.startAnimation(loadAnimation2);
//                }
//                doDownload();
//            }
//        }
//    }
//
//    private void doHome() {
//        Context context = getContext();
//        if (context instanceof Activity) {
//            ((Activity) context).finish();
//        }
//    }
//
//    private void doSettings() {
//        if (!this.mCtrlsHide) {
//            if (this.mSettingsPanel.getVisibility() == 0) {
//                touchCtrls();
//                this.mSettingsPanel.scale(false);
//                this.mBG.setVisibility(8);
//                return;
//            }
//            freezeCtrls();
//            this.mSettingsPanel.scale(true);
//            this.mBG.setVisibility(0);
//        }
//    }
//
//    private void doToggle() {
//        if (this.mListener != null) {
//            this.mListener.onToggle();
//        }
//    }
//
//    private void doDownload() {
//        if (this.mDownloader == null) {
//            return;
//        }
//        if (this.mDownloader.isDownloading()) {
//            this.mDownloader.cancel();
//        } else {
//            this.mDownloader.download();
//        }
//    }
//
//    private void touchContent() {
//        if (!this.mAnimating) {
//            if (this.mCtrlsHide) {
//                fadeInCtrls();
//                delayHideCtrls();
//                return;
//            }
//            cancelDelayHideCtrls();
//            fadeoOutCtrls();
//        }
//    }
//
//    private void touchCtrls() {
//        if (!this.mCtrlsHide && this.mSettingsPanel.getVisibility() != 0) {
//            delayHideCtrls();
//        }
//    }
//
//    private void delayHideCtrls() {
//        this.mHandler.removeMessages(0);
//        this.mHandler.sendEmptyMessageDelayed(0, 4000);
//    }
//
//    private void freezeCtrls() {
//        if (!this.mCtrlsHide) {
//            this.mHandler.removeMessages(0);
//        } else {
//            fadeInCtrls();
//        }
//    }
//
//    private void cancelDelayHideCtrls() {
//        this.mHandler.removeMessages(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void fadeoOutCtrls() {
//        this.mTop.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fm_fadeout_to_top));
//        this.mTop.setVisibility(8);
//        this.mTop.setEnabled(false);
//        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fm_fadeout_to_bottom);
//        this.mBottom.startAnimation(loadAnimation);
//        this.mBottom.setVisibility(8);
//        this.mAnimating = true;
//        loadAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                FmController.this.mAnimating = false;
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        if (this.mSettingsPanel.getVisibility() == 0) {
//            this.mSettingsPanel.scale(false);
//            this.mBG.setVisibility(8);
//        }
//        this.mCtrlsHide = true;
//    }
//
//    private void fadeInCtrls() {
//        this.mTop.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fm_fadein_from_top));
//        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fm_fadein_from_bottom);
//        this.mBottom.startAnimation(loadAnimation);
//        this.mAnimating = true;
//        loadAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                FmController.this.mAnimating = false;
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        this.mTop.setEnabled(true);
//        this.mTop.setVisibility(0);
//        this.mBottom.setVisibility(0);
//        this.mCtrlsHide = false;
//    }
//
//    public void onAllDownloaderCreate(AllDownloader allDownloader, int i) {
//        if (allDownloader != null && i == 0) {
//            this.mDownloader = allDownloader;
//            if (this.mDownloader.isPrepared()) {
//                this.mDownloader.init();
//            }
//            this.mSettingsPanel.updateTotalSize(allDownloader.getTotalSize());
//        }
//    }
//
//    public void onAllDownloadInited(int i, int i2, int i3) {
//        if (this.mDownloader.hasDownloaded()) {
//            this.mDownAll.setText(R.string.fm_download_all_finished);
//            return;
//        }
//        if (i2 > 0) {
//            float f = (100.0f * ((float) i2)) / ((float) i3);
//            String string = getResources().getString(R.string.has_finished, new Object[]{String.format("%.2f", new Object[]{Float.valueOf(f)}) + "%"});
//            this.mDownAll.setText(string);
//            this.mDowningAll.setProgress(i);
//            this.mDowningAll.setComment((CharSequence) string);
//        }
//        if (this.mDownAll.getVisibility() != 0 && this.mDowningAll.getVisibility() != 0) {
//            this.mDownAll.setVisibility(0);
//            this.mDownAll.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein));
//        }
//    }
//
//    public void onAllDownloadProgress(int i, int i2, int i3) {
//        float f = (100.0f * ((float) i2)) / ((float) i3);
//        String string = getResources().getString(R.string.has_finished, new Object[]{String.format("%.2f", new Object[]{Float.valueOf(f)}) + "%"});
//        this.mDownAll.setText(string);
//        this.mDowningAll.setProgress(i);
//        this.mDowningAll.setComment((CharSequence) string);
//    }
//
//    public void onAllDownloaded(boolean z, int i) {
//        Log.d("whiz", "on all downloaded, success: " + z + "; errcode: " + i);
//        int i2 = R.string.fm_download_all_finished;
//        if (!z) {
//            if (-1 == i) {
//                i2 = R.string.fm_download_all_failed_offline;
//            } else {
//                i2 = R.string.fm_download_all_failed;
//            }
//        }
//        this.mDownAll.setText(i2);
//        this.mDowningAll.setComment(i2);
//        if (this.mDowningAll.getVisibility() == 0) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadeout);
//            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein);
//            if (z) {
//                loadAnimation.setStartOffset(300);
//                this.mDowningAll.startAnimation(loadAnimation);
//                this.mDowningAll.setVisibility(8);
//                return;
//            }
//            loadAnimation2.setStartOffset(400);
//            this.mDowningAll.startAnimation(loadAnimation);
//            this.mDowningAll.setVisibility(8);
//            this.mDownAll.startAnimation(loadAnimation2);
//            this.mDownAll.setVisibility(0);
//        }
//    }
//
//    public void onDownloadHighChanged(boolean z) {
//        if (this.mDownloader != null) {
//            this.mDownloader.setDownLoadHigh(z);
//        }
//    }
//
//    public void onClearedMemory() {
//        if (this.mDownloader != null && this.mDownloader.isDownloading()) {
//            this.mDownloader.cancel();
//            String string = getResources().getString(R.string.has_finished, new Object[]{String.format("%.2f", new Object[]{Float.valueOf(0.0f)}) + "%"});
//            this.mDownAll.setText(string);
//            this.mDownAll.setVisibility(0);
//            this.mDowningAll.setComment((CharSequence) string);
//            this.mDowningAll.setProgress(0);
//            this.mDowningAll.setVisibility(8);
//        }
//    }
//}
