//package com.baicizhan.main.phrasetraining.activity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p004v4.app.Fragment;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import java.lang.ref.WeakReference;
//
//public abstract class TrainingFragment extends Fragment {
//    static final int ACTION_TYPE_FROM_WIKI = 2;
//    static final int ACTION_TYPE_NORMAL = 0;
//    static final int ACTION_TYPE_TO_WIKI = 1;
//    protected Handler mHandler = new Handler();
//    protected OnTrainingFragmentInteractionListener mListener;
//    private NextRun mRun;
//
//    class NextRun implements Runnable {
//        final WeakReference<TrainingFragment> mFragment;
//        boolean mRight;
//
//        NextRun(TrainingFragment trainingFragment, boolean z) {
//            this.mFragment = new WeakReference<>(trainingFragment);
//            this.mRight = z;
//        }
//
//        public void run() {
//            TrainingFragment trainingFragment = (TrainingFragment) this.mFragment.get();
//            if (trainingFragment != null) {
//                trainingFragment.next(this.mRight);
//            }
//        }
//    }
//
//    interface OnTrainingFragmentInteractionListener {
//        void onEnd();
//
//        void onNext(int i, Object obj);
//
//        void onNextGroup(Fragment fragment);
//
//        void onResult(boolean z);
//    }
//
//    /* access modifiers changed from: protected */
//    public abstract void next(boolean z);
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            this.mListener = (OnTrainingFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean recreated(Bundle bundle) {
//        if (bundle == null || !bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            return false;
//        }
//        return true;
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (this.mRun != null) {
//            this.mHandler.removeCallbacks(this.mRun);
//        }
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        this.mListener = null;
//    }
//
//    /* access modifiers changed from: protected */
//    public void goNext(boolean z) {
//        goNext(z, 400);
//    }
//
//    /* access modifiers changed from: protected */
//    public void goNext(boolean z, long j) {
//        this.mRun = new NextRun(this, z);
//        this.mHandler.postDelayed(this.mRun, j);
//    }
//}
