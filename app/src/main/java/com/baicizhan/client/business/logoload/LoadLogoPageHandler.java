package com.baicizhan.client.business.logoload;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baicizhan.client.business.logoload.LPDaos.Loading;
import java.util.List;

public class LoadLogoPageHandler extends Handler {
    private static final int EVENT_GET_ONE_LOADED_LOADING = 1;
    private static final int EVENT_GET_ONE_LOADING_PREFER_UNLOADED = 2;
    private static final int EVENT_GET_VERSION = 4;
    private static final int EVENT_INIT = 0;
    private static final int EVENT_MARK_LOADED = 3;
    private static final int EVENT_SET_VERSION = 5;
    private static final int EVENT_UPGRADE = 6;
    private Looper mLooper;
    private Handler mWorkerThreadHandler = new WorkerHandler(this.mLooper);

    final class WorkerArgs {
        public Handler handler;
        public boolean loaded;
        public Loading loading;
        public List<Loading> loadings;
        public String url;
        public int version;

        private WorkerArgs() {
        }
    }

    class WorkerHandler extends Handler {
        private LPDaos mDaos = new LPDaos();

        public WorkerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            WorkerArgs workerArgs = (WorkerArgs) message.obj;
            int i = message.what;
            int i2 = message.arg1;
            switch (i2) {
                case 0:
                    this.mDaos.init(workerArgs.loadings, workerArgs.version);
                    break;
                case 1:
                    workerArgs.loading = this.mDaos.getOneLoadedLoading();
                    break;
                case 2:
                    workerArgs.loading = this.mDaos.getOneLoadingPreferUnloaded();
                    break;
                case 3:
                    this.mDaos.markLoaded(workerArgs.url, workerArgs.loaded);
                    break;
                case 4:
                    workerArgs.version = this.mDaos.getVersion();
                    break;
                case 5:
                    this.mDaos.setVersion(workerArgs.version);
                    break;
                case 6:
                    this.mDaos.upgrade(workerArgs.loadings, workerArgs.version);
                    break;
            }
            Message obtainMessage = workerArgs.handler.obtainMessage(i);
            obtainMessage.obj = workerArgs;
            obtainMessage.arg1 = i2;
            obtainMessage.sendToTarget();
        }
    }

    public LoadLogoPageHandler() {
        HandlerThread handlerThread = new HandlerThread("LoadingPageHandlerWorker");
        handlerThread.start();
        this.mLooper = handlerThread.getLooper();
    }

    public void destroy() {
        if (this.mLooper != null) {
            this.mLooper.quit();
            this.mLooper = null;
            removeCallbacksAndMessages(null);
            if (this.mWorkerThreadHandler != null) {
                this.mWorkerThreadHandler.removeCallbacksAndMessages(null);
            }
        }
    }

    public void init(List<Loading> list, int i, int i2) {
        this.mWorkerThreadHandler.removeMessages(i2);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i2);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.loadings = list;
        workerArgs.version = i;
        obtainMessage.arg1 = 0;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void getOneLoadedLoading(int i) {
        this.mWorkerThreadHandler.removeMessages(i);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        obtainMessage.arg1 = 1;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void getOneLoadingPreferUnloaded(int i) {
        this.mWorkerThreadHandler.removeMessages(i);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        obtainMessage.arg1 = 2;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void markLoaded(String str, boolean z, int i) {
        this.mWorkerThreadHandler.removeMessages(i);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.url = str;
        workerArgs.loaded = z;
        obtainMessage.arg1 = 3;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void getVersion(int i) {
        this.mWorkerThreadHandler.removeMessages(i);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        obtainMessage.arg1 = 4;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void setVersion(int i, int i2) {
        this.mWorkerThreadHandler.removeMessages(i2);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i2);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.version = i;
        obtainMessage.arg1 = 5;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void upgrade(List<Loading> list, int i, int i2) {
        Log.d("whiz", "logo, json loadings: " + list + "; version: " + i);
        this.mWorkerThreadHandler.removeMessages(i2);
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i2);
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.loadings = list;
        workerArgs.version = i;
        obtainMessage.arg1 = 6;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public void onInit(int i) {
    }

    /* access modifiers changed from: protected */
    public void onGetOneLoadedLoading(int i, Loading loading) {
    }

    /* access modifiers changed from: protected */
    public void onGetOneLoadingPreferUnloaded(int i, Loading loading) {
    }

    /* access modifiers changed from: protected */
    public void onMarkLoaded(int i) {
    }

    /* access modifiers changed from: protected */
    public void onGetVersion(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onSetVersion(int i) {
    }

    /* access modifiers changed from: protected */
    public void onUpgrade(int i) {
    }

    public void handleMessage(Message message) {
        WorkerArgs workerArgs = (WorkerArgs) message.obj;
        int i = message.what;
        switch (message.arg1) {
            case 0:
                onInit(i);
                return;
            case 1:
                onGetOneLoadedLoading(i, workerArgs.loading);
                return;
            case 2:
                onGetOneLoadingPreferUnloaded(i, workerArgs.loading);
                return;
            case 3:
                onMarkLoaded(i);
                return;
            case 4:
                onGetVersion(i, workerArgs.version);
                return;
            case 5:
                onSetVersion(i);
                return;
            case 6:
                onUpgrade(i);
                return;
            default:
                return;
        }
    }
}
