//package com.baicizhan.client.p029fm.view;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.os.FileObserver;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.ScaleAnimation;
//import android.widget.CompoundButton;
//import android.widget.CompoundButton.OnCheckedChangeListener;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.view.StrokeButton;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.framework.util.FileHelper;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.PopupEvent;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import com.baicizhan.client.p029fm.util.FmUtil;
//import com.baicizhan.main.utils.GuideFlags;
//import com.jiongji.andriod.card.R;
//import com.kyleduo.switchbutton.SwitchButton;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmSettingsView */
//public class FmSettingsView extends LinearLayout implements OnClickListener, OnCheckedChangeListener {
//    private static final int EVENT_DELETE_FM_DIR = 1;
//    private static final int EVENT_GET_FM_DIR_SIZE = 0;
//    private boolean mCacheDownHigh = false;
//    private int mCacheLoopNum;
//    private int mCachePlusNum;
//    /* access modifiers changed from: private */
//    public CallbackHandler mCallback;
//    private StrokeButton mClear;
//    private TextView mClearMemSize;
//    private TextView mDownHighSize;
//    private SwitchButton mDownHighSwitch;
//    private int mFmCount;
//    /* access modifiers changed from: private */
//    public FmDirObserver mFmDirObserver;
//    private HandlerThread mFmDirThread;
//    private WorkerHandler mFmDirWorker;
//    List<OnFmSettingsChangeListener> mListeners = new ArrayList();
//    private View mLoopMinus;
//    private View mLoopPlus;
//    private TextView mLoopStep;
//    private TextView mLoopTime;
//    private TextView mPlusCount;
//    private View mPlusMinus;
//    private View mPlusPlus;
//    /* access modifiers changed from: private */
//    public boolean mScaling = false;
//    private int mTotalSize;
//
//    /* renamed from: com.baicizhan.client.fm.view.FmSettingsView$CallbackHandler */
//    class CallbackHandler extends Handler {
//        private final WeakReference<FmSettingsView> mSettings;
//
//        CallbackHandler(FmSettingsView fmSettingsView) {
//            this.mSettings = new WeakReference<>(fmSettingsView);
//        }
//
//        public void handleMessage(Message message) {
//            FmSettingsView fmSettingsView = (FmSettingsView) this.mSettings.get();
//            if (fmSettingsView != null) {
//                WorkerArgs workerArgs = (WorkerArgs) message.obj;
//                switch (message.what) {
//                    case 0:
//                        fmSettingsView.onGetFmDirSize(workerArgs.dirsize);
//                        return;
//                    case 1:
//                        fmSettingsView.onDeleteFmDir(workerArgs.delsuccess);
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmSettingsView$FmDirObserver */
//    class FmDirObserver extends FileObserver {
//        FmDirObserver() {
//            super(FmUtil.FM_DIR);
//        }
//
//        public void onEvent(int i, String str) {
//            switch (i) {
//                case 256:
//                case GuideFlags.FLAG_PATTERN_3 /*512*/:
//                    FmSettingsView.this.getFmDirSize();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmSettingsView$OnFmSettingsChangeListener */
//    public interface OnFmSettingsChangeListener {
//        void onClearedMemory();
//
//        void onDownloadHighChanged(boolean z);
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmSettingsView$WorkerArgs */
//    class WorkerArgs {
//        /* access modifiers changed from: private */
//        public boolean delsuccess;
//        /* access modifiers changed from: private */
//        public long dirsize;
//
//        private WorkerArgs() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmSettingsView$WorkerHandler */
//    class WorkerHandler extends Handler {
//        WorkerHandler(Looper looper) {
//            super(looper);
//        }
//
//        public void handleMessage(Message message) {
//            File file = new File(FmUtil.FM_DIR);
//            WorkerArgs workerArgs = (WorkerArgs) message.obj;
//            int i = message.what;
//            switch (i) {
//                case 0:
//                    workerArgs.dirsize = file.exists() ? FileHelper.getDirectorySize(file, false) : 0;
//                    break;
//                case 1:
//                    workerArgs.delsuccess = file.exists() ? FileHelper.deleteDir(file, false) : true;
//                    break;
//            }
//            Message obtainMessage = FmSettingsView.this.mCallback.obtainMessage(i);
//            obtainMessage.obj = workerArgs;
//            obtainMessage.sendToTarget();
//        }
//    }
//
//    public FmSettingsView(Context context) {
//        super(context);
//    }
//
//    public FmSettingsView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mFmDirThread = new HandlerThread("FmDirThread");
//        this.mFmDirThread.start();
//        this.mFmDirWorker = new WorkerHandler(this.mFmDirThread.getLooper());
//        this.mCallback = new CallbackHandler(this);
//        getFmDirSize();
//        this.mFmDirObserver = new FmDirObserver();
//        this.mDownHighSize = (TextView) findViewById(R.id.fm_settings_download_high_sub);
//        this.mDownHighSize.setVisibility(8);
//        this.mDownHighSwitch = (SwitchButton) findViewById(R.id.fm_settings_download_high_switch);
//        this.mDownHighSwitch.setOnCheckedChangeListener(this);
//        this.mClearMemSize = (TextView) findViewById(R.id.fm_settings_clear_mem_sub);
//        this.mClearMemSize.setVisibility(8);
//        this.mClear = (StrokeButton) findViewById(R.id.fm_settings_clear_do);
//        this.mClear.setOnClickListener(this);
//        this.mLoopStep = (TextView) findViewById(R.id.fm_settings_loop);
//        this.mLoopTime = (TextView) findViewById(R.id.fm_settings_loop_sub);
//        this.mLoopTime.setVisibility(8);
//        this.mLoopPlus = findViewById(R.id.fm_settings_loop_plus);
//        this.mLoopPlus.setOnClickListener(this);
//        this.mLoopMinus = findViewById(R.id.fm_settings_loop_minus);
//        this.mLoopMinus.setOnClickListener(this);
//        this.mPlusCount = (TextView) findViewById(R.id.fm_settings_plus);
//        this.mPlusPlus = findViewById(R.id.fm_settings_plus_plus);
//        this.mPlusPlus.setOnClickListener(this);
//        this.mPlusMinus = findViewById(R.id.fm_settings_plus_minus);
//        this.mPlusMinus.setOnClickListener(this);
//        setOnClickListener(this);
//        readSettings();
//    }
//
//    private void readSettings() {
//        this.mCacheDownHigh = FmSettings.isDownloadHigh();
//        this.mCacheLoopNum = FmSettings.getLoopNum();
//        this.mCachePlusNum = FmSettings.getPlusNum();
//        this.mLoopStep.setText(getResources().getString(R.string.fm_settings_loop, new Object[]{Integer.valueOf(this.mCacheLoopNum)}));
//        this.mPlusCount.setText(getResources().getString(R.string.fm_settings_plus, new Object[]{Integer.valueOf(this.mCachePlusNum)}));
//        this.mLoopTime.setText(getResources().getString(R.string.fm_settings_loop_sub, new Object[]{Integer.valueOf((this.mCacheLoopNum * this.mFmCount) / 2)}));
//        String format = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(0.15f * ((float) this.mTotalSize))});
//        this.mDownHighSize.setText(getResources().getString(R.string.fm_settings_download_high_sub, new Object[]{format}));
//        this.mDownHighSwitch.setChecked(this.mCacheDownHigh);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void updateFmCount(int i) {
//        this.mFmCount = i;
//        updatetLoopTime();
//        this.mLoopTime.setVisibility(0);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void updateTotalSize(int i) {
//        this.mTotalSize = i;
//        doUpdateTotalSize();
//        this.mDownHighSize.setVisibility(0);
//    }
//
//    private void doUpdateTotalSize() {
//        this.mDownHighSize.setText(getResources().getString(R.string.fm_settings_download_high_sub, new Object[]{String.format(Locale.US, "%.2f", new Object[]{Float.valueOf((this.mDownHighSwitch.isChecked() ? 0.15f : 0.1f) * ((float) this.mTotalSize))})}));
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        this.mFmDirThread.quit();
//        this.mFmDirObserver.stopWatching();
//    }
//
//    public void onClick(View view) {
//        if (view == this.mClear) {
//            doClear();
//        } else if (view == this.mLoopPlus) {
//            doPlusLoop();
//        } else if (view == this.mLoopMinus) {
//            doMinusLoop();
//        } else if (view == this.mPlusPlus) {
//            doPlusPlus();
//        } else if (view == this.mPlusMinus) {
//            doMinusPlus();
//        }
//    }
//
//    private void doClear() {
//        Builder builder = new Builder(getContext());
//        builder.setTitle(R.string.fm_load_warn_title).setMessage((CharSequence) getResources().getString(R.string.fm_settings_clear_warn_msg, new Object[]{StudyManager.getInstance().getCurrentUser().getVerboseSex()})).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                FmSettingsView.this.deleteFmDir();
//            }
//        });
//        builder.create().show();
//    }
//
//    private void doPlusLoop() {
//        if (this.mCacheLoopNum < 4) {
//            this.mCacheLoopNum++;
//            this.mLoopStep.setText(getResources().getString(R.string.fm_settings_loop, new Object[]{Integer.valueOf(this.mCacheLoopNum)}));
//            updatetLoopTime();
//            FmSettings.setLoopNum(this.mCacheLoopNum);
//        }
//    }
//
//    private void doMinusLoop() {
//        if (1 < this.mCacheLoopNum) {
//            this.mCacheLoopNum--;
//            this.mLoopStep.setText(getResources().getString(R.string.fm_settings_loop, new Object[]{Integer.valueOf(this.mCacheLoopNum)}));
//            updatetLoopTime();
//            FmSettings.setLoopNum(this.mCacheLoopNum);
//        }
//    }
//
//    private void updatetLoopTime() {
//        int i = (this.mCacheLoopNum * this.mFmCount) / 2;
//        this.mLoopTime.setText(getResources().getString(R.string.fm_settings_loop_sub, new Object[]{Integer.valueOf(i)}));
//    }
//
//    private void doPlusPlus() {
//        if (this.mCachePlusNum < 200) {
//            this.mCachePlusNum += 10;
//            this.mPlusCount.setText(getResources().getString(R.string.fm_settings_plus, new Object[]{Integer.valueOf(this.mCachePlusNum)}));
//            updatetLoopTime();
//            FmSettings.setPlusNum(this.mCachePlusNum);
//        }
//    }
//
//    private void doMinusPlus() {
//        if (50 < this.mCachePlusNum) {
//            this.mCachePlusNum -= 10;
//            this.mPlusCount.setText(getResources().getString(R.string.fm_settings_plus, new Object[]{Integer.valueOf(this.mCachePlusNum)}));
//            updatetLoopTime();
//            FmSettings.setPlusNum(this.mCachePlusNum);
//        }
//    }
//
//    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//        if (this.mDownHighSwitch == compoundButton) {
//            this.mCacheDownHigh = z;
//            FmSettings.setDownloadHigh(z);
//            doUpdateTotalSize();
//            if (this.mListeners != null) {
//                for (OnFmSettingsChangeListener onDownloadHighChanged : this.mListeners) {
//                    onDownloadHighChanged.onDownloadHighChanged(z);
//                }
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void scale(final boolean z) {
//        ScaleAnimation scaleAnimation;
//        if (!z) {
//            this.mFmDirObserver.stopWatching();
//        }
//        this.mScaling = true;
//        if (z) {
//            setVisibility(0);
//            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.9f, 1, 0.0f);
//        } else {
//            setVisibility(8);
//            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.9f, 1, 0.0f);
//        }
//        scaleAnimation.setDuration(200);
//        scaleAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                FmSettingsView.this.mScaling = false;
//                if (z) {
//                    FmSettingsView.this.mFmDirObserver.startWatching();
//                }
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        startAnimation(scaleAnimation);
//        PopupEvent popupEvent = new PopupEvent();
//        popupEvent.setState(z ? 0 : 1);
////        EventBus.m0a().mo9c((Object) popupEvent);
//    }
//
//    /* access modifiers changed from: private */
//    public void onGetFmDirSize(long j) {
//        this.mClearMemSize.setVisibility(0);
//        String format = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(((float) j) / 1048576.0f)});
//        this.mClearMemSize.setText(getResources().getString(R.string.fm_settings_clear_mem_sub, new Object[]{format}));
//    }
//
//    /* access modifiers changed from: private */
//    public void onDeleteFmDir(boolean z) {
//        Toast.makeText(getContext(), z ? R.string.fm_settings_clear_success : R.string.fm_settings_clear_failed, 0).show();
//        if (this.mListeners != null) {
//            for (OnFmSettingsChangeListener onClearedMemory : this.mListeners) {
//                onClearedMemory.onClearedMemory();
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void getFmDirSize() {
//        WorkerArgs workerArgs = new WorkerArgs();
//        Message obtainMessage = this.mFmDirWorker.obtainMessage(0);
//        obtainMessage.obj = workerArgs;
//        this.mFmDirWorker.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void deleteFmDir() {
//        WorkerArgs workerArgs = new WorkerArgs();
//        Message obtainMessage = this.mFmDirWorker.obtainMessage(1);
//        obtainMessage.obj = workerArgs;
//        this.mFmDirWorker.sendMessage(obtainMessage);
//    }
//}
