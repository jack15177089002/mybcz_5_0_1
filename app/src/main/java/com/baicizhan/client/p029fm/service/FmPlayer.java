//package com.baicizhan.client.p029fm.service;
//
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlayErrorListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.p029fm.FmAppHandler;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.load.FmLoader;
//import com.baicizhan.client.p029fm.data.load.FmLoader.OnFmLoadListener;
//import com.baicizhan.client.p029fm.service.proxy.FmPlayState;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.service.FmPlayer */
//public class FmPlayer implements OnPlayErrorListener, OnPlaySateListener {
//    private AudioPlayer mAudioPlayer;
//    private Context mContext;
//    private int mCurIndex;
//    private int mCurMidIndex;
//    private File mCurPlayFile;
//    private FmLoadTask mFmLoadTask;
//    /* access modifiers changed from: private */
//    public FmLoader<FmList> mFmLoader;
//    /* access modifiers changed from: private */
//    public FmLoader<FmMidList> mFmMidLoader;
//    private boolean mLoadHigh;
//    /* access modifiers changed from: private */
//    public boolean mOffline;
//    /* access modifiers changed from: private */
//    public int mPlayLimit;
//    private int mPlayType;
//    private int mState;
//    private boolean mWaitting;
//
//    /* renamed from: com.baicizhan.client.fm.service.FmPlayer$Builder */
//    public static final class Builder {
//        private Context mContext;
//        private FmLoader<FmList> mFmLoader;
//        private FmLoader<FmMidList> mFmMidLoader;
//        private int mPlayLimit = -1;
//
//        public final Builder with(Context context) {
//            this.mContext = context;
//            return this;
//        }
//
//        public final Builder setFmLoader(FmLoader<FmList> fmLoader) {
//            this.mFmLoader = fmLoader;
//            return this;
//        }
//
//        public final Builder setFmMidLoader(FmLoader<FmMidList> fmLoader) {
//            this.mFmMidLoader = fmLoader;
//            return this;
//        }
//
//        public final Builder setPlayLimit(int i) {
//            this.mPlayLimit = i;
//            return this;
//        }
//
//        public final FmPlayer build() {
//            FmPlayer fmPlayer = new FmPlayer(this.mContext);
//            fmPlayer.mFmLoader = this.mFmLoader;
//            fmPlayer.mFmMidLoader = this.mFmMidLoader;
//            fmPlayer.mPlayLimit = this.mPlayLimit;
//            if (this.mPlayLimit == 0) {
//                fmPlayer.mOffline = false;
//            }
//            this.mContext = null;
//            return fmPlayer;
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.service.FmPlayer$FmLoadTask */
//    class FmLoadTask implements OnFmLoadListener {
//        final WeakReference<FmPlayer> mPlayer;
//
//        FmLoadTask(FmPlayer fmPlayer) {
//            this.mPlayer = new WeakReference<>(fmPlayer);
//        }
//
//        public void onLoaded(boolean z, int i, String str, String str2) {
//            FmPlayer fmPlayer = (FmPlayer) this.mPlayer.get();
//            if (fmPlayer != null) {
//                fmPlayer.onLoaded(z, i, str, str2);
//            }
//        }
//
//        public void onIdle() {
//            FmPlayer fmPlayer = (FmPlayer) this.mPlayer.get();
//            if (fmPlayer != null) {
//                fmPlayer.onIdle();
//            }
//        }
//    }
//
//    private FmPlayer(Context context) {
//        this.mOffline = true;
//        this.mLoadHigh = false;
//        this.mWaitting = false;
//        this.mContext = context;
//        this.mFmLoadTask = new FmLoadTask(this);
//        this.mAudioPlayer = new AudioPlayer(context);
//        this.mAudioPlayer.setOnPlaySateListener(this);
//        this.mAudioPlayer.setOnPlayErrorListener(this);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public FmLoader<FmList> getFmLoader() {
//        return this.mFmLoader;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public FmLoader<FmMidList> getFmMidLoader() {
//        return this.mFmMidLoader;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void destroy() {
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//        if (this.mFmLoader != null) {
//            this.mFmLoader.cancel();
//        }
//        if (this.mFmMidLoader != null) {
//            this.mFmMidLoader.cancel();
//        }
//        this.mContext = null;
//    }
//
//    private boolean isDestroyed() {
//        return this.mContext == null;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setPlayLimit(int i) {
//        this.mPlayLimit = i;
//        if (-1 == this.mPlayLimit) {
//            extractOfflineFms();
//            notifyPlayLimitChanged();
//        }
//    }
//
//    private void extractOfflineFms() {
//        if (this.mFmLoader != null) {
//            this.mFmLoader.extractOfflineFms();
//        }
//        if (this.mFmMidLoader != null) {
//            this.mFmMidLoader.extractOfflineFms();
//        }
//    }
//
//    private void notifyPlayLimitChanged() {
//        List list;
//        ArrayList arrayList = null;
//        if (!isDestroyed() && this.mContext != null && (this.mContext instanceof FmService)) {
//            if (this.mFmLoader == null || this.mFmLoader.getTargets() == null) {
//                list = null;
//            } else {
//                FmList fmList = (FmList) this.mFmLoader.getTargets();
//                int size = fmList.size();
//                list = new ArrayList(size);
//                for (int i = 0; i < size; i++) {
//                    list.add(fmList.get(i).getWordid());
//                }
//            }
//            if (!(this.mFmMidLoader == null || this.mFmMidLoader.getTargets() == null)) {
//                FmMidList fmMidList = (FmMidList) this.mFmMidLoader.getTargets();
//                int size2 = fmMidList.size();
//                arrayList = new ArrayList(size2);
//                for (int i2 = 0; i2 < size2; i2++) {
//                    arrayList.add(fmMidList.getSavedPath(i2, false));
//                }
//            }
//            ((FmService) this.mContext).onPlayLimitChanged(this.mPlayLimit, list, arrayList);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlay(int i) {
//        File file;
//        if (!isDestroyed()) {
//            Log.d("whiz", "new play, start, fmloader: " + this.mFmLoader);
//            this.mAudioPlayer.stop();
//            this.mCurIndex = i;
//            setSkipped();
//            this.mPlayType = FmPlayState.TYPE_NORMAL_FM;
//            if (this.mFmLoader == null) {
//                C0789L.log.error("FM loader is null, cannot be played.");
//                this.mState = 8;
//                notifyState();
//                return;
//            }
//            FmList fmList = (FmList) this.mFmLoader.getTargets();
//            if (fmList == null || fmList.isEmpty()) {
//                C0789L.log.error("FM list is null or empty, cannot be played.");
//                this.mState = 7;
//                notifyState();
//            } else if (i >= fmList.size() || i < 0) {
//                C0789L.log.error("FM play index is out of range, expected index is [{}], but the factual range is [{}, {}]", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(fmList.size() - 1));
//            } else {
//                File file2 = new File(fmList.getSavedPath(i, false));
//                File file3 = new File(fmList.getSavedPath(i, true));
//                if (file3.exists() || !file2.exists()) {
//                    file = file3;
//                } else {
//                    file = file2;
//                }
//                this.mCurPlayFile = file;
//                Log.d("whiz", "new play file: " + file + "; exists? " + file.exists() + "; offline? " + this.mOffline);
//                if (this.mOffline) {
//                    if (canOnline()) {
//                        this.mFmLoader.load(i, this.mFmLoadTask);
//                        if (!file.exists()) {
//                            notifyLoading();
//                            return;
//                        }
//                    }
//                    if (file.exists()) {
//                        doPlay(file);
//                    } else if (!this.mFmLoader.hasOfflineFms()) {
//                        this.mState = 5;
//                        notifyState();
//                    } else {
//                        playNext();
//                    }
//                } else if (!canOnline()) {
//                    this.mOffline = true;
//                    this.mFmLoader.cancel();
//                    this.mFmMidLoader.cancel();
//                    newPlay(i);
//                } else {
//                    Log.d("whiz", "new play file: " + file + "; exists? " + file.exists());
//                    if (!file.exists()) {
//                        this.mFmMidLoader.cancel();
//                        this.mWaitting = true;
//                        notifyLoading();
//                    } else {
//                        this.mWaitting = false;
//                        doPlay(file);
//                    }
//                    this.mFmLoader.load(i, this.mFmLoadTask);
//                }
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlayMid(int i) {
//        boolean z;
//        boolean z2;
//        if (!isDestroyed()) {
//            this.mAudioPlayer.stop();
//            this.mPlayType = FmPlayState.TYPE_MID_FM;
//            if (this.mFmMidLoader == null) {
//                C0789L.log.error("FM mid loader is null, cannot be played, just play next fm.");
//                z2 = false;
//            } else {
//                FmMidList fmMidList = (FmMidList) this.mFmMidLoader.getTargets();
//                if (fmMidList == null || fmMidList.isEmpty()) {
//                    C0789L.log.error("FM mid list is null or empty, cannot be played, just play next fm.");
//                    z = false;
//                } else if (i < 0 || i >= fmMidList.size()) {
//                    C0789L.log.error("FM mid play index is out of range, expected index is [{}], but the factual range is [{}, {}]", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(fmMidList.size() - 1));
//                    z = false;
//                } else {
//                    z = true;
//                }
//                if (z) {
//                    File file = new File(fmMidList.getSavedPath(i, false));
//                    File file2 = new File(fmMidList.getSavedPath(i, true));
//                    if (file2.exists() || !file.exists()) {
//                        file = file2;
//                    }
//                    this.mCurPlayFile = file;
//                    if (file.exists()) {
//                        if (!this.mAudioPlayer.newPlay(file.getAbsolutePath())) {
//                            file.delete();
//                            if (this.mFmMidLoader.hasOfflineFms()) {
//                                this.mCurMidIndex = (this.mCurMidIndex + 1) % fmMidList.size();
//                                newPlayMid(this.mCurMidIndex);
//                                z2 = z;
//                            } else {
//                                z2 = false;
//                            }
//                        } else {
//                            this.mCurMidIndex = (this.mCurMidIndex + 1) % fmMidList.size();
//                            z2 = z;
//                        }
//                    } else if (this.mFmMidLoader.hasOfflineFms()) {
//                        this.mCurMidIndex = (this.mCurMidIndex + 1) % fmMidList.size();
//                        newPlayMid(this.mCurMidIndex);
//                        z2 = z;
//                    } else {
//                        z2 = false;
//                    }
//                } else {
//                    z2 = z;
//                }
//            }
//            if (!z2) {
//                playNext();
//                if (canOnline()) {
//                    this.mFmMidLoader.load(i, null);
//                }
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void newPlay(String str) {
//        if (!isDestroyed()) {
//            this.mAudioPlayer.stop();
//            this.mPlayType = 1000;
//            if (str == null) {
//                this.mState = 6;
//                notifyState();
//            }
//            File file = new File(str);
//            this.mCurPlayFile = file;
//            if (file.exists()) {
//                if (!this.mAudioPlayer.newPlay(str)) {
//                    file.delete();
//                } else {
//                    return;
//                }
//            }
//            this.mState = 6;
//            notifyState();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void play() {
//        if (!isDestroyed()) {
//            this.mAudioPlayer.play();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playNext() {
//        if (!isDestroyed()) {
//            this.mPlayType = FmPlayState.TYPE_NORMAL_FM;
//            if (this.mFmLoader == null) {
//                C0789L.log.error("FM loader is null, cannot be played.");
//                this.mState = 8;
//                notifyState();
//                return;
//            }
//            FmList fmList = (FmList) this.mFmLoader.getTargets();
//            if (fmList != null) {
//                this.mCurIndex = (this.mCurIndex + 1) % fmList.size();
//                newPlay(this.mCurIndex);
//                return;
//            }
//            this.mState = 7;
//            notifyState();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void playPrev() {
//        if (!isDestroyed()) {
//            this.mPlayType = FmPlayState.TYPE_NORMAL_FM;
//            if (this.mFmLoader == null) {
//                C0789L.log.error("FM loader is null, cannot be played.");
//                this.mState = 8;
//                notifyState();
//                return;
//            }
//            FmList fmList = (FmList) this.mFmLoader.getTargets();
//            if (fmList != null) {
//                this.mCurIndex = ((this.mCurIndex - 1) + fmList.size()) % fmList.size();
//                newPlay(this.mCurIndex);
//                return;
//            }
//            this.mState = 7;
//            this.mPlayType = FmPlayState.TYPE_NORMAL_FM;
//            notifyState();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void pause() {
//        if (!isDestroyed()) {
//            this.mAudioPlayer.pause();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void stop() {
//        if (!isDestroyed()) {
//            this.mAudioPlayer.stop();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void toggle() {
//        if (!isDestroyed()) {
//            if (3 == this.mState) {
//                play();
//            } else if (2 == this.mState) {
//                pause();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void notifyLoading() {
//        if (!isDestroyed()) {
//            this.mState = 4;
//            notifyState();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void notifyState() {
//        if (!isDestroyed() && this.mContext != null && (this.mContext instanceof FmService)) {
//            ((FmService) this.mContext).onPlayStateChanged(this.mState, 1002 == this.mPlayType ? this.mCurMidIndex : this.mCurIndex, this.mPlayType);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void loadHigh(boolean z) {
//        if (!isDestroyed()) {
//            this.mLoadHigh = z;
//            if (this.mFmLoader != null) {
//                this.mFmLoader.setLoadHigh(z);
//            }
//            if (this.mFmMidLoader != null) {
//                this.mFmMidLoader.setLoadHigh(z);
//            }
//        }
//    }
//
//    private boolean doPlay(File file) {
//        if (this.mAudioPlayer.newPlay(file.getAbsolutePath())) {
//            accumViewed();
//            return true;
//        }
//        Log.d("whiz", "!!! fm play failed for damaged audio file: " + file);
//        C0789L.log.error("fm play failed for damaged audio file [{}], delete it and re dwonload", (Object) file);
//        file.delete();
//        newPlay(this.mCurIndex);
//        return false;
//    }
//
//    private boolean canOnline() {
//        switch (NetworkUtils.getActiveNetworkType(FmAppHandler.getApp())) {
//            case -1:
//                return false;
//            case 1:
//            case 2:
//            case 3:
//                if (-4 == this.mPlayLimit) {
//                    return false;
//                }
//                break;
//        }
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public void onLoaded(boolean z, int i, String str, String str2) {
//        if (z) {
//            if (this.mWaitting) {
//                this.mWaitting = false;
//                FmList fmList = (FmList) this.mFmLoader.getTargets();
//                String savedPath = fmList.getSavedPath(this.mCurIndex, false);
//                String savedPath2 = fmList.getSavedPath(this.mCurIndex, true);
//                if ((savedPath == null && savedPath2 == null) || str == null || (!savedPath.equals(str) && !savedPath2.equals(str))) {
//                    C0789L.log.error("cannot play fm after loaded for downloaded file is not the one should be played. should [{} or {}], fact [{}]", savedPath, savedPath2, str);
//                    this.mWaitting = true;
//                    return;
//                }
//                Log.d("whiz", "!!! loaded and new play index: " + this.mCurIndex);
//                if (4 == this.mState) {
//                    newPlay(this.mCurIndex);
//                }
//            }
//        } else if (!isActive()) {
//            C0789L.log.error("load fm failed for network reason. Url [{}], err code [{}]", (Object) str2, (Object) Integer.valueOf(i));
//            this.mState = 9;
//            notifyState();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onIdle() {
//        if (this.mFmMidLoader != null) {
//            FmMidList fmMidList = (FmMidList) this.mFmMidLoader.getTargets();
//            if (fmMidList != null && !fmMidList.isEmpty()) {
//                Log.d("whiz", "fm mid start load...");
//                this.mFmMidLoader.load(null);
//            }
//        }
//    }
//
//    private boolean isActive() {
//        if (this.mAudioPlayer == null || (2 != this.mState && 3 != this.mState)) {
//            return false;
//        }
//        return true;
//    }
//
//    private void setSkipped() {
//        FmList fmList = (FmList) this.mFmLoader.getTargets();
//        if (isActive() && fmList != null && !fmList.isEmpty()) {
//            fmList.get(((this.mCurIndex - 1) + fmList.size()) % fmList.size()).setSkipped(true);
//        }
//    }
//
//    private void accumViewed() {
//        FmList fmList = (FmList) this.mFmLoader.getTargets();
//        if (fmList != null && !fmList.isEmpty()) {
//            fmList.get(this.mCurIndex).accumViewed();
//        }
//    }
//
//    public void onPlayStateChanged(State state) {
//        this.mState = 0;
//        switch (state) {
//            case Completed:
//                this.mState = 11;
//                break;
//            case Stopped:
//                this.mState = 0;
//                break;
//            case Preparing:
//                this.mState = 1;
//                break;
//            case Playing:
//                this.mState = 2;
//                break;
//            case Paused:
//                this.mState = 3;
//                break;
//        }
//        notifyState();
//    }
//
//    public void onPlayError(int i, int i2) {
//        if (this.mCurPlayFile != null && this.mCurPlayFile.exists()) {
//            this.mCurPlayFile.delete();
//        }
//        this.mState = 10;
//        notifyState();
//    }
//}
