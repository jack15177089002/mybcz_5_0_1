//package com.baicizhan.client.p029fm.view;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.content.Intent;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.managers.AdLoader;
//import com.baicizhan.client.business.managers.AdLoader.AdLoaderListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.framework.log.C0789L;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.load.FmHandler;
//import com.baicizhan.client.p029fm.data.load.FmListLoader;
//import com.baicizhan.client.p029fm.data.load.FmListLoader.OnFmListLoadListener;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ListenMoreEvent;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.PopupEvent;
//import com.baicizhan.client.p029fm.service.proxy.FmPlayerProxy;
//import com.baicizhan.client.p029fm.service.proxy.FmServiceProxy;
//import com.baicizhan.client.p029fm.service.proxy.FmServiceProxy.Callback;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import com.baicizhan.client.p029fm.view.FmController.OnPlayerControlListener;
//import com.baicizhan.client.p029fm.view.FmSettingsView.OnFmSettingsChangeListener;
//import com.jiongji.andriod.card.R;
////import com.baicizhan.store.StoreItemDetailActivity;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.List;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmView */
//public class FmView extends RelativeLayout implements Callback, OnPlayerControlListener, OnFmSettingsChangeListener {
//    private static final int PLAY_TYPE_END = 1;
//    private static final int PLAY_TYPE_MID = 3;
//    private static final int PLAY_TYPE_NORMAL = 2;
//    private static final int PLAY_TYPE_START = 0;
//    private AdLoadCallback mAdLoadCallback;
//    /* access modifiers changed from: private */
//    public boolean mAdLoaded = false;
//    /* access modifiers changed from: private */
//    public AdLoader mAdLoader;
//    /* access modifiers changed from: private */
//    public FmBorderGetter mFmBorderGetter;
//    /* access modifiers changed from: private */
//    public FmController mFmCtrl;
//    /* access modifiers changed from: private */
//    public String mFmEndPath;
//    /* access modifiers changed from: private */
//    public FmListLoader mFmGetter;
//    private FmGetterListener mFmGetterListener;
//    private FmLine mFmLine;
//    /* access modifiers changed from: private */
//    public boolean mFmLoaded = false;
//    /* access modifiers changed from: private */
//    public FmPlayerProxy mFmPlayer;
//    private FmServiceProxy mFmService;
//    /* access modifiers changed from: private */
//    public String mFmStartPath;
//    /* access modifiers changed from: private */
//    public List<String> mFmWordids;
//    /* access modifiers changed from: private */
//    public FmList mFmlist;
//    /* access modifiers changed from: private */
//    public ImageView mLoadProgress;
//    private List<String> mMidPaths;
//    private boolean mMoreMode = false;
//    private int mPlayState = 0;
//    private int mPlayType = 0;
//    private boolean mRetried = false;
//    private int mToRecoverState = 0;
//    /* access modifiers changed from: private */
//    public boolean mWait4Finish = false;
//
//    /* renamed from: com.baicizhan.client.fm.view.FmView$AdLoadCallback */
//    class AdLoadCallback implements AdLoaderListener {
//        private final WeakReference<FmView> mFmView;
//
//        private AdLoadCallback(FmView fmView) {
//            this.mFmView = new WeakReference<>(fmView);
//        }
//
//        public void onAdLoaded() {
//            FmView fmView = (FmView) this.mFmView.get();
//            if (fmView != null) {
//                fmView.mAdLoaded = true;
//                if (!fmView.mFmLoaded) {
//                    fmView.mLoadProgress.setVisibility(0);
//                } else if (fmView.mWait4Finish) {
//                    fmView.finish4NoFm();
//                } else {
//                    fmView.mAdLoader.gone();
//                    fmView.goAndPlay();
//                }
//            }
//        }
//
//        public Intent getNativeStoreIntent(String str) {
////            FmView fmView = (FmView) this.mFmView.get();
////            if (fmView == null) {
//                return null;
////            }
////            return StoreItemDetailActivity.getStartIntent(fmView.getContext(), str);
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmView$FmBorderGetter */
//    class FmBorderGetter extends FmHandler {
//        final WeakReference<FmView> mFmView;
//
//        public FmBorderGetter(FmView fmView) {
//            super(fmView.getContext());
//            this.mFmView = new WeakReference<>(fmView);
//        }
//
//        public void onGetFmBorders(int i, List<String> list, Object obj) {
//            FmView fmView = (FmView) this.mFmView.get();
//            if (fmView != null) {
//                if (list != null && list.size() >= 2) {
//                    fmView.mFmStartPath = PathUtil.reformFmPath(PathUtil.BCZ_HOME + ((String) list.get(0)));
//                    fmView.mFmEndPath = PathUtil.reformFmPath(PathUtil.BCZ_HOME + ((String) list.get(1)));
//                    if (!new File(fmView.mFmStartPath).exists()) {
//                        fmView.mFmStartPath = PathUtil.reformFmPath(PathUtil.BCZ_HOME + WordMediaRecordHelper.DEF_FM_START);
//                    }
//                    if (!new File(fmView.mFmEndPath).exists()) {
//                        fmView.mFmEndPath = PathUtil.reformFmPath(PathUtil.BCZ_HOME + WordMediaRecordHelper.DEF_FM_END);
//                    }
//                    Log.d("whiz", "get fm borders finished, start: " + fmView.mFmStartPath + "; end: " + fmView.mFmEndPath);
//                }
//                fmView.onFmLoaded();
//                fmView.updateSettings();
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.view.FmView$FmGetterListener */
//    class FmGetterListener implements OnFmListLoadListener {
//        final WeakReference<FmView> mFmView;
//
//        FmGetterListener(FmView fmView) {
//            this.mFmView = new WeakReference<>(fmView);
//        }
//
//        public void onGetFmList(FmList fmList, FmMidList fmMidList, Object obj) {
//            Log.d("whiz", "on get fm list: " + fmList);
//            FmView fmView = (FmView) this.mFmView.get();
//            if (fmView != null) {
//                if (isConsistent(fmView, fmList)) {
//                    fmView.mFmlist = fmList;
//                    Log.d("whiz", "get fm borders start");
//                    C0789L.log.info("get fm list, get fm borders start.");
//                    fmView.mFmBorderGetter.getFmBorders(0, null);
//                    return;
//                }
//                Toast.makeText(fmView.getContext(), R.string.fm_data_err, 0).show();
//            }
//        }
//
//        public void onGetWordIds(List<String> list, List<WordMediaRecord> list2, Object obj) {
//        }
//
//        public void onGetFmInfos(List<WordMediaRecord> list, Object obj) {
//        }
//
//        private  boolean isConsistent(FmView fmView, FmList fmList) {
//            if (fmList == null) {
//                Log.d("whiz", "consistence failed 0");
//                C0789L.log.error("get fm list failed for data inconsistent, list is null");
//                return false;
//            } else if (fmList.needBorn()) {
//                Log.d("whiz", "consistence failed 1");
//                C0789L.log.error("get fm list failed for data inconsistent, list need born");
//                return false;
//            } else {
//                int size = fmList.size();
//                if (size != fmView.mFmWordids.size()) {
//                    Log.d("whiz", "consistence failed 2");
//                    C0789L.log.error("get fm list failed for data inconsistent, list size from client [{}], from service [{}]", (Object) Integer.valueOf(size), (Object) Integer.valueOf(fmView.mFmWordids != null ? fmView.mFmWordids.size() : 0));
//                    return false;
//                }
//                for (int i = 0; i < size; i++) {
//                    if (!((String) fmView.mFmWordids.get(i)).equals(fmList.get(i).getWordid())) {
//                        Log.d("whiz", "consistence failed 3");
//                        C0789L.log.error("get fm list failed for data inconsistent, word id inconsistent [{}] - [{}]", fmView.mFmWordids.get(i), (Object) fmList.get(i).getWordid());
//                        return false;
//                    }
//                }
//                C0789L.log.info("get fm list consistent!");
//                Log.d("whiz", "consistence success");
//                return true;
//            }
//        }
//    }
//
//    public FmView(Context context) {
//        super(context);
//    }
//
//    public FmView(Context context, AttributeSet attributeSet) {
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
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mFmCtrl = (FmController) findViewById(R.id.fm_controller);
//        this.mFmLine = (FmLine) findViewById(R.id.fm_line);
//        this.mFmLine.setFmView(this);
//        this.mFmCtrl.setOnPlayerControlListener(this);
//        this.mFmCtrl.addOnFmSettingsChangeListener(this);
//        this.mLoadProgress = (ImageView) findViewById(R.id.fm_load_progress);
//        this.mLoadProgress.setVisibility(8);
//        this.mFmService = FmServiceProxy.createInstance(this);
//        this.mFmGetterListener = new FmGetterListener(this);
//        this.mFmGetter = FmListLoader.born(getContext()).setListener(this.mFmGetterListener);
//        this.mFmBorderGetter = new FmBorderGetter(this);
////        this.mAdLoadCallback = new AdLoadCallback();
//        this.mAdLoader = AdLoader.createLoader((Activity) getContext(), this).setListener(this.mAdLoadCallback).enableFadeout(true).load();
//    }
//
//    public void start() {
//        Log.d("whiz", "launch fm service, proxy: " + this.mFmService);
//        if (this.mFmService != null) {
//            this.mFmService.launch(getContext());
//        }
//    }
//
//    public void close() {
//        if (this.mFmService != null) {
//            this.mFmService.close(getContext());
//        } else {
//            C0789L.log.error("fm service is null when close? why?");
//        }
//        this.mAdLoader.cancel();
//    }
//
//    /* access modifiers changed from: private */
//    public void goAndPlay() {
//        this.mFmLine.update(this.mFmlist, this.mMidPaths, null);
//        this.mFmLine.postDelayed(new Runnable() {
//            public void run() {
//                FmView.this.playStart();
//            }
//        }, 1000);
//        this.mFmCtrl.setProgress(1, this.mFmlist.size());
//        if (this.mLoadProgress.getVisibility() == 0) {
//            this.mLoadProgress.setVisibility(8);
//            this.mLoadProgress.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void updateSettings() {
//        this.mFmCtrl.updateFmCount(this.mFmlist.size());
//    }
//
//    private File getPlayStart() {
//        if (TextUtils.isEmpty(this.mFmStartPath)) {
//            return null;
//        }
//        return new File(this.mFmStartPath);
//    }
//
//    private File getPlayEnd() {
//        if (TextUtils.isEmpty(this.mFmEndPath)) {
//            return null;
//        }
//        return new File(this.mFmEndPath);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void play(int i) {
//        if (this.mFmPlayer != null) {
//            Log.d("whiz", "!!! start new play index: " + i);
//            this.mPlayType = 2;
//            this.mFmPlayer.newPlay(i);
//            this.mFmCtrl.setProgress(i + 1, this.mFmlist.size());
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playStart() {
//        if (this.mFmPlayer != null) {
//            this.mPlayType = 0;
//            File playStart = getPlayStart();
//            if (playStart == null || !playStart.exists()) {
//                this.mFmLine.moveToNext(true);
//            } else {
//                this.mFmPlayer.newPlay(playStart.getAbsolutePath());
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playMid(int i) {
//        if (this.mFmPlayer != null) {
//            Log.d("whiz", "play mid, index: " + i);
//            this.mPlayType = 3;
//            this.mFmPlayer.newPlayMid(i);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playEnd() {
//        if (this.mFmPlayer != null) {
//            this.mPlayType = 1;
//            File playEnd = getPlayEnd();
//            if (playEnd == null || !playEnd.exists()) {
//                this.mFmLine.moveToNext(true);
//            } else {
//                this.mFmPlayer.newPlay(playEnd.getAbsolutePath());
//            }
//        }
//    }
//
//    public void onEventMainThread(ListenMoreEvent listenMoreEvent) {
//        playMore();
//    }
//
//    public void onEventMainThread(PopupEvent popupEvent) {
//        int state = popupEvent.getState();
//        if (state == 0) {
//            this.mToRecoverState = this.mPlayState;
//            pause();
//        } else if (1 == state && 2 == this.mToRecoverState) {
//            resume();
//        }
//    }
//
//    private void playMore() {
//        if (this.mFmService != null) {
//            Log.d("whiz", "frag cache, play more");
//            stop();
//            this.mMoreMode = true;
//            this.mFmService.playMore();
//            if (this.mFmLine != null) {
//                this.mFmLine.resetLoop();
//            }
//            this.mLoadProgress.setVisibility(0);
//        }
//    }
//
//    private void pause() {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.pause();
//        }
//    }
//
//    private void resume() {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.play();
//        }
//    }
//
//    private void stop() {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.stop();
//        }
//    }
//
//    public void onToggle() {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.toggle();
//        }
//    }
//
//    public void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, FmPlayerProxy fmPlayerProxy, int i) {
//        boolean z2 = true;
//        Log.d("whiz", "launch fm service callback, player: " + fmPlayerProxy + "; success: " + z + "; wordids: " + list);
//        this.mFmPlayer = fmPlayerProxy;
//        this.mFmPlayer.setPlayQuality(FmSettings.isDownloadHigh());
//        if (!z || this.mFmPlayer == null || list == null || list.isEmpty()) {
//            this.mFmLoaded = true;
//            if (!this.mAdLoaded) {
//                this.mWait4Finish = true;
//            } else {
//                finish4NoFm();
//            }
//        } else {
//            Log.d("whiz", "start get fm list in client, word ids: " + list + "; mid paths: " + list2);
//            C0789L.log.info("get fm list, start get fm list in client, word ids [{}], mid paths [{}], code [{}]", list, list2, Integer.valueOf(i));
//            this.mFmWordids = list;
//            this.mMidPaths = list2;
//            switch (i) {
//                case -7:
//                case -6:
//                    if (-7 != i) {
//                        z2 = false;
//                    }
//                    askIfPlayOnMobileNet(z2);
//                    return;
//                case -5:
//                case -2:
//                    Toast.makeText(getContext(), R.string.fm_play_no_offline, 0).show();
//                    finish();
//                    return;
//                case -1:
//                    Toast.makeText(getContext(), R.string.fm_play_offline, 0).show();
//                    break;
//            }
//            this.mFmGetter.getFmList(StudyManager.getInstance().getCurrentBookId(), list, (Object) null);
//            this.mFmCtrl.initAllDownload();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void finish4NoFm() {
//        Toast.makeText(getContext(), R.string.fm_no_fms, 0).show();
//        finish();
//    }
//
//    private void askIfPlayOnMobileNet(final boolean z) {
//        int i = z ? R.string.fm_load_warn_play_offline : 17039360;
////        Builder builder = new Builder(getContext());
////        builder.setTitle(R.string.fm_load_warn_title).setMessage(R.string.fm_load_warn_msg_down_mobile).setNegativeButton(i, (OnClickListener) new OnClickListener() {
////            public void onClick(DialogInterface dialogInterface, int i) {
////                if (FmView.this.mFmPlayer != null) {
////                    FmView.this.mFmPlayer.setPlayLimit(z ? -1 : -4);
////                }
////                if (!z) {
////                    FmView.this.finish();
////                } else {
////                    Toast.makeText(FmView.this.getContext(), R.string.fm_play_offline, 0).show();
////                }
////            }
////        }).setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
////            public void onClick(DialogInterface dialogInterface, int i) {
////                FmView.this.mFmGetter.getFmList(StudyManager.getInstance().getCurrentBookId(), FmView.this.mFmWordids, (Object) null);
////                FmView.this.mFmCtrl.initAllDownload();
////            }
////        });
////        BczDialog create = builder.create();
////        create.setCanceledOnTouchOutside(false);
////        create.setCancelable(false);
////        create.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void finish() {
//        if (getContext() instanceof Activity) {
//            ((Activity) getContext()).finish();
//        }
//    }
//
//    public void onPlayLimitSet(int i, List<String> list, List<String> list2) {
//        this.mFmWordids = list;
//        this.mMidPaths = list2;
//        this.mFmGetter.getFmList(StudyManager.getInstance().getCurrentBookId(), this.mFmWordids, (Object) null);
//        this.mFmCtrl.initAllDownload();
//    }
//
//    public void onPlayStateChanged(int i, int i2, int i3) {
//        this.mFmCtrl.onPlayStateChanged(i);
//        if (this.mFmlist != null) {
//            this.mPlayState = i;
//            switch (i) {
//                case 0:
//                    C0789L.log.error("stopped state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    Log.d("whiz", "!!! state stopped, cur index: " + i2);
//                    return;
//                case 1:
//                case 3:
//                    return;
//                case 2:
//                    Log.d("whiz", "!!! state playing, cur index: " + i2);
//                    if (1001 == i3) {
//                        this.mFmLine.moveTo(i2, false);
//                        return;
//                    }
//                    return;
//                case 4:
//                    C0789L.log.info("loading state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    Log.d("whiz", "!!! state loading, cur index: " + i2);
//                    return;
//                case 5:
//                    C0789L.log.error("stopped state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    Log.d("whiz", "!!! state stopped and no offline fms, cur index: " + i2);
//                    return;
//                case 6:
//                    C0789L.log.error("stopped state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    Log.d("whiz", "!!! state stopped and invalid path, cur index: " + i2);
//                    return;
//                case 7:
//                    C0789L.log.error("stopped state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    Log.d("whiz", "!!! state stopped and null playlist, cur index: " + i2);
//                    return;
//                case 9:
//                    Log.d("whiz", "!!! state stopped and net err, cur index: " + i2);
//                    return;
//                case 10:
//                    this.mFmLine.forcePlayCur();
//                    return;
//                case 11:
//                    Log.d("whiz", "!!! state completed, cur index: " + i2);
//                    this.mFmLine.moveToNext(true);
//                    return;
//                default:
//                    C0789L.log.error("undefined state, state [{}], index [{}], type [{}]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
//                    return;
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onFmLoaded() {
//        C0789L.log.info("get fm list, on fm loaded [{}], ad loaded [{}]", (Object) Boolean.valueOf(this.mFmLoaded), (Object) Boolean.valueOf(this.mAdLoaded));
//        this.mFmLoaded = true;
//        if (this.mAdLoaded) {
//            this.mAdLoader.gone();
//            goAndPlay();
//        }
//    }
//
//    public void onDownloadHighChanged(boolean z) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.setPlayQuality(z);
//        }
//    }
//
//    public void onClearedMemory() {
//    }
//}
