//package com.baicizhan.client.business.media.update;
//
//import android.content.Context;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader.OnWordMediaLoaderListener;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader.OnWordMediaReviewSyncListener;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import java.util.List;
//
//public class MediaUpdator implements OnWordMediaLoaderListener, OnWordMediaReviewSyncListener {
//    public static final int ERR_NETWORKS = -1;
//    public static final int ERR_UNKNOWN = -2;
//    public static final int NO_ERR = 0;
//    private FmBordersUpdator mBorderUpdator;
//    private boolean mCancel = false;
//    private Context mContext;
//    private boolean mDestroyOnCancel = false;
//    private OnMediaUpdateListener mListener;
//    private WordMediaLoader mWordMediaLoader;
//
//    public interface OnMediaUpdateListener {
//        void onMediaUpdated(boolean z, int i);
//    }
//
//    public static MediaUpdator createInstance(Context context, OnMediaUpdateListener onMediaUpdateListener) {
//        MediaUpdator mediaUpdator = new MediaUpdator(context);
//        mediaUpdator.mListener = onMediaUpdateListener;
//        return mediaUpdator;
//    }
//
//    private MediaUpdator(Context context) {
//        this.mContext = context;
//        this.mBorderUpdator = new FmBordersUpdator(this.mContext, this);
//        this.mWordMediaLoader = WordMediaLoader.createLoader(this.mContext, this, this);
//    }
//
//    public void update() {
//        if (!tryCancel()) {
//            this.mWordMediaLoader.refreshMid();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public final void onBorderUpdate() {
//        if (!tryCancel()) {
//            this.mWordMediaLoader.update(StudyManager.getInstance().getCurrentBookId());
//        }
//    }
//
//    private boolean tryCancel() {
//        if (!this.mCancel) {
//            return false;
//        }
//        if (this.mDestroyOnCancel) {
//            this.mDestroyOnCancel = false;
//            destroy();
//        }
//        this.mCancel = false;
//        return true;
//    }
//
//    public void cancel(boolean z) {
//        this.mDestroyOnCancel = z;
//        this.mCancel = true;
//    }
//
//    public void destroy() {
//        this.mWordMediaLoader.destroy();
//        this.mContext = null;
//    }
//
//    public void onUpdated(boolean z, int i) {
//        int i2 = -1;
//        if (!tryCancel()) {
//            if (z) {
//                this.mWordMediaLoader.updateReviewRecords(StudyManager.getInstance().getCurrentBookId());
//            } else if (this.mListener != null) {
//                OnMediaUpdateListener onMediaUpdateListener = this.mListener;
//                if (-1 != i) {
//                    i2 = -2;
//                }
//                onMediaUpdateListener.onMediaUpdated(false, i2);
//                destroy();
//            }
//        }
//    }
//
//    public void onInserted(boolean z, int i, List<WordMediaRecord> list) {
//    }
//
//    public void onMidRefreshed(boolean z, int i) {
//        if (!tryCancel()) {
//            this.mBorderUpdator.update();
//        }
//    }
//
//    public void onWordMeidaReviewSynced(boolean z, int i) {
//        OnMediaUpdateListener onMediaUpdateListener;
//        boolean z2;
//        int i2 = 0;
//        if (!tryCancel()) {
//            if (z) {
//                if (this.mListener != null) {
//                    onMediaUpdateListener = this.mListener;
//                    z2 = true;
//                }
//                destroy();
//            }
//            if (this.mListener != null) {
//                onMediaUpdateListener = this.mListener;
//                if (-1 == i) {
//                    z2 = false;
//                    i2 = -1;
//                } else {
//                    z2 = false;
//                    i2 = -2;
//                }
//            }
//            destroy();
//            onMediaUpdateListener.onMediaUpdated(z2, i2);
//            destroy();
//        }
//    }
//}
