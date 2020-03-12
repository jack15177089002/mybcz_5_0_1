//package com.baicizhan.client.p029fm.data.load;
//
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader.OnWordMediaLoaderListener;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.load.FmListLoader.OnFmListLoadListener;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import java.lang.ref.WeakReference;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.load.FmLoaderCreator */
//public class FmLoaderCreator implements OnWordMediaLoaderListener {
//    public static final int ERR_MOBILE_NET = -6;
//    public static final int ERR_MOBILE_NET_HAS_OFFLINE = -7;
//    public static final int ERR_NETWORKS = -5;
//    public static final int ERR_NOFM = -3;
//    public static final int ERR_OFFLINE = -1;
//    public static final int ERR_OFFLINE_NO_FM = -2;
//    public static final int ERR_USR_CANCEL = -4;
//    public static final int NO_ERR = 0;
//    /* access modifiers changed from: private */
//    public boolean mAutoDestroy;
//    private Context mContext;
//    /* access modifiers changed from: private */
//    public boolean mDownloadHigh;
//    /* access modifiers changed from: private */
//    public int mErrCode;
//    private FmListLoader mFmGetter;
//    private FmGetterListener mFmGetterListener;
//    /* access modifiers changed from: private */
//    public FmList mFmlist;
//    /* access modifiers changed from: private */
//    public OnFmLoaderCreateListener mListener;
//    /* access modifiers changed from: private */
//    public FmMidList mMidlist;
//    private boolean mMobileCapable;
//    /* access modifiers changed from: private */
//    public int mPlayCount;
//    /* access modifiers changed from: private */
//    public WordMediaLoader mWordMediaLoader;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmLoaderCreator$Builder */
//    public static class Builder {
//        private boolean mAutoDestroy = false;
//        private Context mContext;
//        private boolean mDownloadHigh = false;
//        private OnFmLoaderCreateListener mListener;
//        private int mPlayCount = 50;
//
//        public Builder() {
//            int plusNum = FmSettings.getPlusNum();
//            if (plusNum > 0) {
//                this.mPlayCount = plusNum;
//            }
//        }
//
//        public Builder with(Context context) {
//            this.mContext = context;
//            return this;
//        }
//
//        public Builder autoDestroy(boolean z) {
//            this.mAutoDestroy = z;
//            return this;
//        }
//
//        public Builder downloadHigh(boolean z) {
//            this.mDownloadHigh = z;
//            return this;
//        }
//
//        public Builder setPlanCount(int i) {
//            this.mPlayCount = i;
//            return this;
//        }
//
//        public Builder setCallback(OnFmLoaderCreateListener onFmLoaderCreateListener) {
//            this.mListener = onFmLoaderCreateListener;
//            return this;
//        }
//
//        public FmLoaderCreator build() {
//            FmLoaderCreator fmLoaderCreator = new FmLoaderCreator(this.mContext);
//            fmLoaderCreator.mAutoDestroy = this.mAutoDestroy;
//            fmLoaderCreator.mDownloadHigh = this.mDownloadHigh;
//            fmLoaderCreator.mPlayCount = this.mPlayCount;
//            fmLoaderCreator.mListener = this.mListener;
//            this.mContext = null;
//            return fmLoaderCreator;
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmLoaderCreator$FmGetterListener */
//    class FmGetterListener implements OnFmListLoadListener {
//        final WeakReference<FmLoaderCreator> mCreator;
//
//        FmGetterListener(FmLoaderCreator fmLoaderCreator) {
//            this.mCreator = new WeakReference<>(fmLoaderCreator);
//        }
//
//        public void onGetFmList(FmList fmList, FmMidList fmMidList, Object obj) {
//            FmLoaderCreator fmLoaderCreator = (FmLoaderCreator) this.mCreator.get();
//            if (fmLoaderCreator != null) {
//                fmLoaderCreator.mFmlist = fmList;
//                fmLoaderCreator.mMidlist = fmMidList;
//                if (fmList == null || fmList.isEmpty()) {
//                    fmLoaderCreator.mErrCode = -3;
//                    Log.d("whiz", "notify loader created 1.");
//                    fmLoaderCreator.notifyCallback();
//                    fmLoaderCreator.tryDestroy();
//                    return;
//                }
//                List born = fmList.born();
//                if (born == null || born.isEmpty()) {
//                    Log.d("whiz", "notify loader created 0.");
//                    fmLoaderCreator.notifyCallback();
//                    fmLoaderCreator.tryDestroy();
//                    return;
//                }
//                Log.d("whiz", "word media need borns: " + born);
//                C0789L.log.info("get fm list, word media need borns [{}]", (Object) born);
//                fmLoaderCreator.mWordMediaLoader.insert(StudyManager.getInstance().getCurrentBookId(), born);
//            }
//        }
//
//        public void onGetWordIds(List<String> list, List<WordMediaRecord> list2, Object obj) {
//        }
//
//        public void onGetFmInfos(List<WordMediaRecord> list, Object obj) {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmLoaderCreator$OnFmLoaderCreateListener */
//    public interface OnFmLoaderCreateListener {
//        void onFmLoaderCreate(FmLoader<FmList> fmLoader, FmLoader<FmMidList> fmLoader2, int i);
//    }
//
//    public boolean isMobileCapable() {
//        return this.mMobileCapable;
//    }
//
//    public static FmLoaderCreator with(Context context) {
//        return new FmLoaderCreator(context);
//    }
//
//    private FmLoaderCreator(Context context) {
//        this.mAutoDestroy = false;
//        this.mDownloadHigh = false;
//        this.mErrCode = 0;
//        this.mMobileCapable = true;
//        this.mPlayCount = 50;
//        this.mContext = context;
//        this.mFmGetterListener = new FmGetterListener(this);
//        this.mFmGetter = FmListLoader.born(context).setListener(this.mFmGetterListener);
//        this.mWordMediaLoader = WordMediaLoader.createLoader(context, this, null);
//        int plusNum = FmSettings.getPlusNum();
//        if (plusNum > 0) {
//            this.mPlayCount = plusNum;
//        }
//    }
//
//    public void create() {
//        this.mFmGetter.getFmList(StudyManager.getInstance().getCurrentBookId(), this.mPlayCount, (Object) null);
//        C0789L.log.info("get fm list, start create fm loader creator, listener [{}]", (Object) this.mListener);
//    }
//
//    /* access modifiers changed from: private */
//    public void tryDestroy() {
//        if (this.mAutoDestroy) {
//            destroy();
//        }
//    }
//
//    public void destroy() {
//        this.mWordMediaLoader.destroy();
//        this.mContext = null;
//    }
//
//    public boolean isAlive() {
//        return this.mContext != null;
//    }
//
//    public void onUpdated(boolean z, int i) {
//    }
//
//    public void onInserted(boolean z, int i, List<WordMediaRecord> list) {
//        if (!z && this.mErrCode == 0) {
//            this.mErrCode = -5;
//        }
//        if (this.mFmlist != null) {
//            this.mFmlist.completeBorn(list);
//            C0789L.log.info("get fm list, after inserted and complete born [{}]", (Object) this.mFmlist);
//            if (this.mFmlist.isEmpty()) {
//                this.mErrCode = -3;
//            }
//            Log.d("whiz", "notify loader created 2.");
//        } else {
//            this.mErrCode = -3;
//        }
//        C0789L.log.info("get fm list, do notify callback, listener [{}]", (Object) this.mListener);
//        notifyCallback();
//        tryDestroy();
//    }
//
//    public void onMidRefreshed(boolean z, int i) {
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyCallback() {
//        C0789L.log.info("get fm list, notify callback, listener [{}]", (Object) this.mListener);
//        if (this.mListener == null) {
//            C0789L.log.info("get fm list, notify callback, return [-1]");
//        } else if (this.mFmlist == null || this.mFmlist.isEmpty()) {
//            C0789L.log.info("get fm list, notify callback, return [0]");
//            doNotify();
//        } else {
//            boolean hasOfflineFms = hasOfflineFms();
//            int activeNetworkType = NetworkUtils.getActiveNetworkType(this.mContext);
//            switch (activeNetworkType) {
//                case 0:
//                    doNotify();
//                    C0789L.log.info("get fm list, notify callback, return [3]");
//                    break;
//                case 1:
//                case 2:
//                case 3:
//                    this.mErrCode = hasOfflineFms ? -7 : -6;
//                    doNotify();
//                    C0789L.log.info("get fm list, notify callback, return [2] and pop dialog");
//                    break;
//                default:
//                    if (hasOfflineFms) {
//                        this.mErrCode = -1;
//                    } else {
//                        this.mErrCode = -2;
//                    }
//                    doNotify();
//                    C0789L.log.info("get fm list, notify callback, return [1]");
//                    break;
//            }
//            C0789L.log.info("get fm list, notify callback, return [4], and net type [{}]", (Object) Integer.valueOf(activeNetworkType));
//        }
//    }
//
//    private void doNotify() {
//        C0789L.log.info("get fm list, do notify, listener [{}]", (Object) this.mListener);
//        FmLoader fmLoader = new FmLoader();
//        fmLoader.mTargets = this.mFmlist;
//        fmLoader.mLoadHigh = this.mDownloadHigh;
//        FmLoader fmLoader2 = new FmLoader();
//        fmLoader2.mTargets = this.mMidlist;
//        fmLoader2.mLoadHigh = this.mDownloadHigh;
//        this.mListener.onFmLoaderCreate(fmLoader, fmLoader2, this.mErrCode);
//    }
//
//    public boolean hasOfflineFms() {
//        if (this.mFmlist == null || this.mFmlist.isEmpty()) {
//            return false;
//        }
//        int size = this.mFmlist.size();
//        for (int i = 0; i < size; i++) {
//            if (this.mFmlist.getLocalPath(i) != null) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
