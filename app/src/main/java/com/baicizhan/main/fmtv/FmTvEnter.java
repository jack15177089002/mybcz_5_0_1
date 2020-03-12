//package com.baicizhan.main.fmtv;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AlphaAnimation;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.media.update.MediaUpdator;
//import com.baicizhan.client.business.media.update.MediaUpdator.OnMediaUpdateListener;
//import com.baicizhan.client.business.media.update.MediaUpdatorService;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.p029fm.activity.FmActivity;
//import com.baicizhan.client.video.activity.VideoPlayActivity;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import p116pl.droidsonroids.gif.GifImageView;
//
//public class FmTvEnter extends Activity implements OnClickListener, OnMediaUpdateListener {
//    private static final String TAG = FmTvEnter.class.getName();
//    private GifImageView mFmAnimView;
//    private MediaUpdator mFmTvUpdator;
//    private Button mGoFmBtn;
//    private Button mGoTvBtn;
//    private Handler mHandler = new Handler();
//    private View mHome;
//    /* access modifiers changed from: private */
//    public ProgressBar mProgress;
//    private ProgressRun mProgressRun;
//    private GifImageView mTvAnimView;
//
//    class ProgressRun implements Runnable {
//        final WeakReference<FmTvEnter> mEnter;
//
//        ProgressRun(FmTvEnter fmTvEnter) {
//            this.mEnter = new WeakReference<>(fmTvEnter);
//        }
//
//        public void run() {
//            FmTvEnter fmTvEnter = (FmTvEnter) this.mEnter.get();
//            if (fmTvEnter != null) {
//                int progress = fmTvEnter.mProgress.getProgress();
//                if (progress < 950) {
//                    fmTvEnter.mProgress.setProgress(progress + 2);
//                    fmTvEnter.accumProgress();
//                }
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, FmTvEnter.class));
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        tryKillSelf(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.fm_tv_entrance);
//        this.mFmAnimView = (GifImageView) findViewById(R.id.fm_anim);
//        this.mFmAnimView.setOnClickListener(this);
//        this.mTvAnimView = (GifImageView) findViewById(R.id.tv_anim);
//        this.mTvAnimView.setOnClickListener(this);
//        if (PropertyHelper.getBoolean("key_giflib_enabled", true)) {
//            this.mFmAnimView.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(this, R.attr.drawable_baofm));
//            this.mTvAnimView.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(this, R.attr.drawable_baotv));
//        }
//        this.mHome = findViewById(R.id.fm_tv_home);
//        this.mHome.setOnClickListener(this);
//        this.mGoFmBtn = (Button) findViewById(R.id.fm_go_btn);
//        ThemeResUtil.setFmTvGoBtnShape(this, this.mGoFmBtn);
//        this.mGoTvBtn = (Button) findViewById(R.id.tv_go_btn);
//        ThemeResUtil.setFmTvGoBtnShape(this, this.mGoTvBtn);
//        this.mProgress = (ProgressBar) findViewById(R.id.data_load_progress);
//        this.mProgress.setMax(1000);
//        this.mGoFmBtn.setOnClickListener(this);
//        this.mGoTvBtn.setOnClickListener(this);
//        this.mProgress.setVisibility(8);
//        MediaUpdatorService.start(this);
//    }
//
//    private void tryKillSelf(Bundle bundle) {
//        if (bundle != null && bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, exit!");
//            System.exit(0);
//        }
//    }
//
//    private boolean needWaitLoadData() {
//        BookRecord currentBook = StudyManager.getInstance().getCurrentBook();
//        if (currentBook == null || currentBook.localRadioResVer != currentBook.remoteRadioResVer || !WordMediaRecordHelper.isBookLoaded(this, currentBook.bookId)) {
//            return true;
//        }
//        return false;
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mFmTvUpdator != null) {
//            this.mFmTvUpdator.cancel(true);
//        }
//        this.mHandler.removeCallbacks(this.mProgressRun);
//        System.gc();
//    }
//
//    /* access modifiers changed from: private */
//    public void accumProgress() {
//        int i = 25;
//        if (this.mProgress.getProgress() > 500) {
//            i = 100;
//        }
//        this.mHandler.postDelayed(this.mProgressRun, (long) i);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mGoFmBtn || view == this.mFmAnimView) {
//            FmActivity.start(this);
//            UMStats.statFmClick(this);
//            OperationStats.statMediaFM();
//        } else if (view == this.mGoTvBtn || view == this.mTvAnimView) {
//            VideoPlayActivity.start(this);
//            UMStats.statTvClick(this);
//            OperationStats.statMediaTV();
//        } else if (view == this.mHome) {
//            finish();
//        }
//    }
//
//    public void onMediaUpdated(boolean z, int i) {
//        this.mHandler.removeCallbacks(this.mProgressRun);
//        this.mProgress.setProgress(1000);
//        this.mProgress.postDelayed(new Runnable() {
//            public void run() {
//                FmTvEnter.this.mProgress.setVisibility(8);
//            }
//        }, 300);
//        if (z) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation.setDuration(300);
//            this.mGoFmBtn.setVisibility(0);
//            this.mGoFmBtn.setOnClickListener(this);
//            this.mGoFmBtn.startAnimation(alphaAnimation);
//            this.mGoTvBtn.setVisibility(0);
//            this.mGoTvBtn.setOnClickListener(this);
//            this.mGoTvBtn.startAnimation(alphaAnimation);
//            return;
//        }
//        int i2 = R.string.fmtv_enter_failed_unknown;
//        if (-1 == i) {
//            i2 = R.string.fmtv_enter_failed_networks;
//        }
//        Toast.makeText(this, i2, 0).show();
//    }
//}
