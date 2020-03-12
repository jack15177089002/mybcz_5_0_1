//package com.baicizhan.client.p029fm.service;
//
//import android.app.Notification;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.os.Handler;
//import android.os.IBinder;
//import android.os.Looper;
//import android.os.Message;
//import android.os.RemoteCallbackList;
//import android.os.RemoteException;
////import android.support.p004v4.app.C0026bc;
//import android.util.Log;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.media.update.MediaUpdatorService;
//import com.baicizhan.client.framework.log.C0789L;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.activity.FmActivity;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.load.FmHandler;
//import com.baicizhan.client.p029fm.data.load.FmLoader;
//import com.baicizhan.client.p029fm.data.load.FmLoaderCreator;
//import com.baicizhan.client.p029fm.data.load.FmLoaderCreator.Builder;
//import com.baicizhan.client.p029fm.data.load.FmLoaderCreator.OnFmLoaderCreateListener;
//import com.baicizhan.client.p029fm.data.update.FmUpdatorService;
//import com.baicizhan.client.p029fm.service.IFmService.Stub;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.service.FmService */
//public class FmService extends Service implements OnFmLoaderCreateListener {
//    private static final int MSG_CLOSE = 1;
//    private static final int MSG_LAUNCH = 0;
//    private static final int MSG_NEWPLAY = 2;
//    private static final int MSG_NEWPLAY_MID = 3;
//    private static final int MSG_NEWPLAY_PATH = 4;
//    private static final int MSG_PAUSE = 8;
//    private static final int MSG_PLAY = 5;
//    private static final int MSG_PLAY_MORE = 12;
//    private static final int MSG_PLAY_NEXT = 6;
//    private static final int MSG_PLAY_PREV = 7;
//    private static final int MSG_SET_PLAY_LIMIT = 13;
//    private static final int MSG_SET_PLAY_QUALITY = 11;
//    private static final int MSG_STOP = 9;
//    private static final int MSG_TOGGLE = 10;
//    private static final int NOTIFY_ID = ((FmService.class.getName().length() * 100) + 1);
//    private static final int STATE_LAUNCHING = 0;
//    private static final int STATE_LAUNCH_FAILED = 2;
//    private static final int STATE_LAUNCH_SUCCEED = 1;
//    private static final int STATE_NONE = -1;
//    private static final int TOKEN_PLAY_MORE = 0;
//    private final Stub mBinder = new Stub() {
//        public void launch(IFmServiceCallback iFmServiceCallback) {
//            Log.d("whiz", "launch fm service, state: " + FmService.this.mState + "; callback: " + iFmServiceCallback);
//            FmService.this.processLaunch(iFmServiceCallback);
//        }
//
//        public void close(IFmServiceCallback iFmServiceCallback) {
//            FmService.this.processClose(iFmServiceCallback);
//        }
//
//        public void newPlay(int i) {
//            Log.d("whiz", "new play in service, index: " + i + "; player: " + FmService.this.mFmPlayer);
//            FmService.this.processNewPlay(i);
//        }
//
//        public void newPlayMid(int i) {
//            FmService.this.processNewPlayMid(i);
//        }
//
//        public void newPlayPath(String str) {
//            FmService.this.processNewPlayPath(str);
//        }
//
//        public void play() {
//            FmService.this.processPlay();
//        }
//
//        public void playNext() {
//            FmService.this.processPlayNext();
//        }
//
//        public void playPrev() {
//            FmService.this.processPlayPrev();
//        }
//
//        public void pause() {
//            FmService.this.processPause();
//        }
//
//        public void stop() {
//            FmService.this.processStop();
//        }
//
//        public void toggle() {
//            FmService.this.processToggle();
//        }
//
//        public void setPlayQuality(boolean z) {
//            FmService.this.processPlayQuality(z);
//        }
//
//        public void playMore() {
//            FmService.this.processPlayMore();
//        }
//
//        public void setPlayLimit(int i) {
//            FmService.this.processSetPlayLimit(i);
//        }
//    };
//    private List<String> mCBKMidPaths;
//    private List<String> mCBKWordids;
//    private final RemoteCallbackList<IFmServiceCallback> mCallbacks = new RemoteCallbackList<>();
//    private int mCallbacksCount = 0;
//    /* access modifiers changed from: private */
//    public FmLoaderCreator mFmLoaderCreator;
//    /* access modifiers changed from: private */
//    public FmPlayer mFmPlayer;
//    private FmUpdator mFmUpdator;
//    private StubHandler mHandler;
//    /* access modifiers changed from: private */
//    public int mState = -1;
//
//    /* renamed from: com.baicizhan.client.fm.service.FmService$FmUpdator */
//    class FmUpdator extends FmHandler {
//        final WeakReference<FmService> mService;
//
//        FmUpdator(FmService fmService) {
//            super(fmService);
//            this.mService = new WeakReference<>(fmService);
//        }
//
//        public void onUpdateFmLearnRecords(int i, Object obj) {
//            FmService fmService = (FmService) this.mService.get();
//            if (fmService != null) {
//                if (i == 0) {
//                    fmService.mFmLoaderCreator = new Builder().with(fmService).autoDestroy(true).setPlanCount(FmSettings.getPlusNum()).setCallback(fmService).build();
//                    fmService.mFmLoaderCreator.create();
//                    C0789L.log.info("get fm list, start create fm loader creator from service for play more.");
//                }
//                MediaUpdatorService.start(fmService);
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.FmService$StubHandler */
//    class StubHandler extends Handler {
//        final WeakReference<FmService> mFmService;
//
//        StubHandler(FmService fmService) {
//            this.mFmService = new WeakReference<>(fmService);
//        }
//
//        public void handleMessage(Message message) {
//            FmService fmService = (FmService) this.mFmService.get();
//            if (fmService != null) {
//                switch (message.what) {
//                    case 0:
//                        fmService.doprocessLaunch(message);
//                        return;
//                    case 1:
//                        fmService.doprocessClose(message);
//                        return;
//                    case 2:
//                        fmService.doprocessNewPlay(message);
//                        return;
//                    case 3:
//                        fmService.doprocessNewPlayMid(message);
//                        return;
//                    case 4:
//                        fmService.doprocessNewPlayPath(message);
//                        return;
//                    case 5:
//                        fmService.doprocessPlay(message);
//                        return;
//                    case 6:
//                        fmService.doprocessPlayNext(message);
//                        return;
//                    case 7:
//                        fmService.doprocessPlayPrev(message);
//                        return;
//                    case 8:
//                        fmService.doprocessPause(message);
//                        return;
//                    case 9:
//                        fmService.doprocessStop(message);
//                        return;
//                    case 10:
//                        fmService.doprocessToggle(message);
//                        return;
//                    case 11:
//                        fmService.doprocessPlayQuality(message);
//                        return;
//                    case 12:
//                        fmService.doprocessPlayMore(message);
//                        return;
//                    case 13:
//                        fmService.doprocessSetPlayLimit(message);
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mHandler = new StubHandler(this);
//        this.mFmUpdator = new FmUpdator(this);
//    }
//
//    public IBinder onBind(Intent intent) {
//        return this.mBinder;
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        C0789L.log.info("get fm list, fm service is destroyed.");
//        stopForeground(true);
//        this.mCallbacks.kill();
//        delegateUpdate();
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.destroy();
//        }
//        if (this.mFmLoaderCreator != null && this.mFmLoaderCreator.isAlive()) {
//            this.mFmLoaderCreator.destroy();
//        }
//        this.mFmUpdator.destroy();
//    }
//
//    private void delegateUpdate() {
//        if (this.mFmPlayer != null) {
//            FmLoader fmLoader = this.mFmPlayer.getFmLoader();
//            if (fmLoader != null) {
//                FmUpdatorService.start(this, (FmList) fmLoader.getTargets());
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void processLaunch(IFmServiceCallback iFmServiceCallback) {
//        Message obtainMessage = this.mHandler.obtainMessage(0);
//        obtainMessage.obj = iFmServiceCallback;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processClose(IFmServiceCallback iFmServiceCallback) {
//        Message obtainMessage = this.mHandler.obtainMessage(1);
//        obtainMessage.obj = iFmServiceCallback;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processNewPlay(int i) {
//        Message obtainMessage = this.mHandler.obtainMessage(2);
//        obtainMessage.arg1 = i;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processNewPlayMid(int i) {
//        Message obtainMessage = this.mHandler.obtainMessage(3);
//        obtainMessage.arg1 = i;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processNewPlayPath(String str) {
//        Message obtainMessage = this.mHandler.obtainMessage(4);
//        obtainMessage.obj = str;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPlay() {
//        this.mHandler.sendEmptyMessage(5);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPlayNext() {
//        this.mHandler.sendEmptyMessage(6);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPlayPrev() {
//        this.mHandler.sendEmptyMessage(7);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPause() {
//        this.mHandler.sendEmptyMessage(8);
//    }
//
//    /* access modifiers changed from: private */
//    public void processStop() {
//        this.mHandler.sendEmptyMessage(9);
//    }
//
//    /* access modifiers changed from: private */
//    public void processToggle() {
//        this.mHandler.sendEmptyMessage(10);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPlayQuality(boolean z) {
//        Message obtainMessage = this.mHandler.obtainMessage(11);
//        obtainMessage.arg1 = z ? 1 : 0;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processPlayMore() {
//        this.mHandler.sendEmptyMessage(12);
//    }
//
//    /* access modifiers changed from: private */
//    public void processSetPlayLimit(int i) {
//        Message obtainMessage = this.mHandler.obtainMessage(13);
//        obtainMessage.arg1 = i;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessLaunch(Message message) {
//        startForeground(NOTIFY_ID, getNotification());
//        IFmServiceCallback iFmServiceCallback = (IFmServiceCallback) message.obj;
//        if (iFmServiceCallback != null) {
//            this.mCallbacks.register(iFmServiceCallback);
//            this.mCallbacksCount++;
//        }
//        switch (this.mState) {
//            case 0:
//                return;
//            case 1:
//                onFmServiceLaunched(true, this.mCBKWordids, this.mCBKMidPaths, 0);
//                if (this.mFmPlayer != null) {
//                    this.mFmPlayer.notifyState();
//                    return;
//                }
//                return;
//            default:
//                this.mState = 0;
//                this.mFmLoaderCreator = new Builder().with(this).autoDestroy(true).setCallback(this).build();
//                this.mFmLoaderCreator.create();
//                C0789L.log.info("get fm list, start create fm loader creator from service.");
//                return;
//        }
//    }
//
//    private Notification getNotification() {
////        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), FmActivity.class), 0);
////        C0026bc bcVar = new C0026bc(this);
////        C0026bc a = bcVar.mo222a(R.drawable.ic_baicizhan_white);
////        a.f172g = BitmapFactory.decodeResource(getResources(), R.drawable.baofm_notification);
////        a.mo227a((CharSequence) getString(R.string.fm_notification_title)).mo230b(getString(R.string.fm_notification_subtitle)).mo231c(getString(R.string.fm_notificaiton_ticker)).f169d = activity;
////        return bcVar.mo229b();
//
//        return null;
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessClose(Message message) {
//        IFmServiceCallback iFmServiceCallback = (IFmServiceCallback) message.obj;
//        if (iFmServiceCallback != null) {
//            this.mCallbacks.unregister(iFmServiceCallback);
//            this.mCallbacksCount--;
//        }
//        if (this.mCallbacksCount == 0) {
//            stopSelf();
//        } else {
//            C0789L.log.info("fm service callbacks is not empty, count is [{}]", (Object) Integer.valueOf(this.mCallbacksCount));
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessNewPlay(Message message) {
//        int i = message.arg1;
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.newPlay(i);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessNewPlayMid(Message message) {
//        int i = message.arg1;
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.newPlayMid(i);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessNewPlayPath(Message message) {
//        String str = (String) message.obj;
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.newPlay(str);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPlay(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.play();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPlayNext(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.playNext();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPlayPrev(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.playPrev();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPause(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.pause();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessStop(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.stop();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessToggle(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.toggle();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPlayQuality(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.loadHigh(message.arg1 != 0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessPlayMore(Message message) {
//        if (this.mFmPlayer != null) {
//            FmLoader fmLoader = this.mFmPlayer.getFmLoader();
//            if (fmLoader != null) {
//                this.mFmUpdator.updateFmLearnRecords(0, StudyManager.getInstance().getCurrentBookId(), (FmList) fmLoader.getTargets(), null);
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doprocessSetPlayLimit(Message message) {
//        if (this.mFmPlayer != null) {
//            this.mFmPlayer.setPlayLimit(message.arg1);
//        }
//    }
//
//    private int getCurrentBook() {
//        return 0;
//    }
//
//    private void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, int i) {
//        Log.d("whiz", "launch fm service callback start 0");
//        int beginBroadcast = this.mCallbacks.beginBroadcast();
//        for (int i2 = 0; i2 < beginBroadcast; i2++) {
//            try {
//                Log.d("whiz", "launch fm service callback, item: " + i2 + "; mid paths: " + list2);
//                ((IFmServiceCallback) this.mCallbacks.getBroadcastItem(i2)).onFmServiceLaunched(z, list, list2, i);
//            } catch (Exception e) {
//            }
//        }
//        this.mCallbacks.finishBroadcast();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onPlayLimitChanged(int i, List<String> list, List<String> list2) {
//        Log.d("whiz", "launch fm service callback start 1");
//        int beginBroadcast = this.mCallbacks.beginBroadcast();
//        for (int i2 = 0; i2 < beginBroadcast; i2++) {
//            try {
//                ((IFmServiceCallback) this.mCallbacks.getBroadcastItem(i2)).onPlayLimitSet(i, list, list2);
//            } catch (Exception e) {
//            }
//        }
//        this.mCallbacks.finishBroadcast();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void onPlayStateChanged(int i, int i2, int i3) {
//        boolean z;
//        String str = "whiz";
//        StringBuilder sb = new StringBuilder("launch fm service callback start 2, main thread? ");
//        if (Looper.getMainLooper() == Looper.myLooper()) {
//            z = true;
//        } else {
//            z = false;
//        }
//        Log.d(str, sb.append(z).toString());
//        int beginBroadcast = this.mCallbacks.beginBroadcast();
//        for (int i4 = 0; i4 < beginBroadcast; i4++) {
//            try {
//                ((IFmServiceCallback) this.mCallbacks.getBroadcastItem(i4)).onPlayStateChanged(i, i2, i3);
//            } catch (Exception e) {
//            }
//        }
//        this.mCallbacks.finishBroadcast();
//    }
//
//    public void onFmLoaderCreate(FmLoader<FmList> fmLoader, FmLoader<FmMidList> fmLoader2, int i) {
//        boolean z = i != -3;
//        int convertErrCode = convertErrCode(i);
//        if (-1 == convertErrCode) {
//            if (fmLoader != null) {
//                fmLoader.extractOfflineFms();
//            }
//            if (fmLoader2 != null) {
//                fmLoader2.extractOfflineFms();
//            }
//        }
//        if (!(fmLoader == null || fmLoader.getTargets() == null)) {
//            FmList fmList = (FmList) fmLoader.getTargets();
//            int size = fmList.size();
//            this.mCBKWordids = new ArrayList(size);
//            for (int i2 = 0; i2 < size; i2++) {
//                this.mCBKWordids.add(fmList.get(i2).getWordid());
//            }
//        }
//        if (!(fmLoader2 == null || fmLoader2.getTargets() == null)) {
//            FmMidList fmMidList = (FmMidList) fmLoader2.getTargets();
//            int size2 = fmMidList.size();
//            this.mCBKMidPaths = new ArrayList(size2);
//            for (int i3 = 0; i3 < size2; i3++) {
//                this.mCBKMidPaths.add(fmMidList.getSavedPath(i3, false));
//            }
//        }
//        Log.d("whiz", "launch fm service complete, success: " + z + "; err code: " + i + "; fmlist: " + this.mCBKWordids + "; midlist: " + this.mCBKMidPaths);
//        C0789L.log.info("get fm list, fm loader created, success [{}], err code [{}], fmlist [{}], midlist [{}]", Boolean.valueOf(z), Integer.valueOf(i), this.mCBKWordids, this.mCBKMidPaths);
//        if (z) {
//            this.mState = 1;
//            this.mFmPlayer = new FmPlayer.Builder().with(this).setFmLoader(fmLoader).setFmMidLoader(fmLoader2).setPlayLimit(convertErrCode).build();
//        } else {
//            this.mState = 2;
//        }
//        onFmServiceLaunched(z, this.mCBKWordids, this.mCBKMidPaths, convertErrCode);
//    }
//
//    private static int convertErrCode(int i) {
//        switch (i) {
//            case -7:
//                return -7;
//            case -6:
//                return -6;
//            case -5:
//                return -5;
//            case -4:
//                return -4;
//            case -3:
//                return -3;
//            case -2:
//                return -2;
//            case -1:
//                return -1;
//            default:
//                return 0;
//        }
//    }
//}
