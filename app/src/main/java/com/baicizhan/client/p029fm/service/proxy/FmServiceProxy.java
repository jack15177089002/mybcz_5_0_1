//package com.baicizhan.client.p029fm.service.proxy;
//
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.os.Handler;
//import android.os.IBinder;
//import android.os.Message;
//import android.os.RemoteException;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.p029fm.service.FmService;
//import com.baicizhan.client.p029fm.service.IFmService;
//import com.baicizhan.client.p029fm.service.IFmServiceCallback.Stub;
//import java.lang.ref.WeakReference;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy */
//public class FmServiceProxy {
//    private static final int MSG_PLAY_LIMIT_SET = 1;
//    private static final int MSG_PLAY_STATE_CHANGED = 2;
//    private static final int MSG_SERVICE_LAUNCHED = 0;
//    /* access modifiers changed from: private */
//    public Stub mCallback = new Stub() {
//        public void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, int i) {
//            FmServiceProxy.this.processOnFmServiceLaunched(z, list, list2, i);
//        }
//
//        public void onPlayLimitSet(int i, List<String> list, List<String> list2) {
//            FmServiceProxy.this.processOnPlayLimitSet(i, list, list2);
//        }
//
//        public void onPlayStateChanged(int i, int i2, int i3) {
//            FmServiceProxy.this.processOnPlayStateChanged(i, i2, i3);
//        }
//    };
//    private ServiceConnection mConnection = new ServiceConnection() {
//        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            FmServiceProxy.this.mFmService = IFmService.Stub.asInterface(iBinder);
//            try {
//                FmServiceProxy.this.mFmService.launch(FmServiceProxy.this.mCallback);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void onServiceDisconnected(ComponentName componentName) {
//            FmServiceProxy.this.mFmService = null;
//        }
//    };
//    /* access modifiers changed from: private */
//    public IFmService mFmService;
//    private CallbakHandler mHandler = new CallbakHandler(this);
//    private boolean mIsBound = false;
//    /* access modifiers changed from: private */
//    public Callback mProxyCallback;
//
//    /* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy$Callback */
//    public interface Callback {
//        void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, FmPlayerProxy fmPlayerProxy, int i);
//
//        void onPlayLimitSet(int i, List<String> list, List<String> list2);
//
//        void onPlayStateChanged(int i, int i2, int i3);
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy$CallbakHandler */
//    class CallbakHandler extends Handler {
//        final WeakReference<FmServiceProxy> mProxy;
//
//        CallbakHandler(FmServiceProxy fmServiceProxy) {
//            this.mProxy = new WeakReference<>(fmServiceProxy);
//        }
//
//        public void handleMessage(Message message) {
//            FmServiceProxy fmServiceProxy = (FmServiceProxy) this.mProxy.get();
//            if (fmServiceProxy != null) {
//                switch (message.what) {
//                    case 0:
//                        ServiceLaunchBean serviceLaunchBean = (ServiceLaunchBean) message.obj;
//                        if (fmServiceProxy.mProxyCallback != null) {
//                            FmPlayerProxy fmPlayerProxy = new FmPlayerProxy();
//                            fmPlayerProxy.mServiceProxy = fmServiceProxy;
//                            fmServiceProxy.mProxyCallback.onFmServiceLaunched(serviceLaunchBean.success, serviceLaunchBean.wordids, serviceLaunchBean.midPaths, fmPlayerProxy, serviceLaunchBean.errCode);
//                            return;
//                        }
//                        return;
//                    case 1:
//                        PlayLimitBean playLimitBean = (PlayLimitBean) message.obj;
//                        if (fmServiceProxy.mProxyCallback != null) {
//                            fmServiceProxy.mProxyCallback.onPlayLimitSet(playLimitBean.limit, playLimitBean.wordids, playLimitBean.midPaths);
//                            return;
//                        }
//                        return;
//                    case 2:
//                        PlayStateBean playStateBean = (PlayStateBean) message.obj;
//                        if (fmServiceProxy.mProxyCallback != null) {
//                            fmServiceProxy.mProxyCallback.onPlayStateChanged(playStateBean.state, playStateBean.curIndex, playStateBean.type);
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy$PlayLimitBean */
//    class PlayLimitBean {
//        int limit;
//        List<String> midPaths;
//        List<String> wordids;
//
//        private PlayLimitBean() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy$PlayStateBean */
//    class PlayStateBean {
//        int curIndex;
//        int state;
//        int type;
//
//        private PlayStateBean() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.proxy.FmServiceProxy$ServiceLaunchBean */
//    class ServiceLaunchBean {
//        int errCode;
//        List<String> midPaths;
//        boolean success;
//        List<String> wordids;
//
//        private ServiceLaunchBean() {
//        }
//    }
//
//    public static FmServiceProxy createInstance(Callback callback) {
//        FmServiceProxy fmServiceProxy = new FmServiceProxy();
//        fmServiceProxy.mProxyCallback = callback;
//        return fmServiceProxy;
//    }
//
//    private FmServiceProxy() {
//    }
//
//    public void launch(Context context) {
//        context.bindService(new Intent(context, FmService.class), this.mConnection, 1);
//        this.mIsBound = true;
//    }
//
//    public void close(Context context) {
//        if (this.mIsBound) {
//            if (this.mFmService != null) {
//                try {
//                    this.mFmService.close(this.mCallback);
//                } catch (RemoteException e) {
//                    C0789L.log.error("close fm service callback failed for remote exception occured!", (Throwable) e);
//                    e.printStackTrace();
//                }
//            }
//            context.unbindService(this.mConnection);
//            this.mIsBound = false;
//            return;
//        }
//        C0789L.log.error("unbind fm service failed for bound flag not correct!");
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlay(int i) {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.newPlay(i);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlayMid(int i) {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.newPlayMid(i);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlay(String str) {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.newPlayPath(str);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void play() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.play();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playNext() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.playNext();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playPrev() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.playPrev();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void pause() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.pause();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void stop() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.stop();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void toggle() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.toggle();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setPlayQuality(boolean z) {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.setPlayQuality(z);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setPlayLimit(int i) {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.setPlayLimit(i);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void playMore() {
//        if (this.mFmService != null) {
//            try {
//                this.mFmService.playMore();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void processOnFmServiceLaunched(boolean z, List<String> list, List<String> list2, int i) {
//        ServiceLaunchBean serviceLaunchBean = new ServiceLaunchBean();
//        serviceLaunchBean.success = z;
//        serviceLaunchBean.wordids = list;
//        serviceLaunchBean.midPaths = list2;
//        serviceLaunchBean.errCode = i;
//        Message obtainMessage = this.mHandler.obtainMessage(0);
//        obtainMessage.obj = serviceLaunchBean;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processOnPlayLimitSet(int i, List<String> list, List<String> list2) {
//        PlayLimitBean playLimitBean = new PlayLimitBean();
//        playLimitBean.limit = i;
//        playLimitBean.wordids = list;
//        playLimitBean.midPaths = list2;
//        Message obtainMessage = this.mHandler.obtainMessage(1);
//        obtainMessage.obj = playLimitBean;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void processOnPlayStateChanged(int i, int i2, int i3) {
//        PlayStateBean playStateBean = new PlayStateBean();
//        playStateBean.state = i;
//        playStateBean.curIndex = i2;
//        playStateBean.type = i3;
//        Message obtainMessage = this.mHandler.obtainMessage(2);
//        obtainMessage.obj = playStateBean;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//}
