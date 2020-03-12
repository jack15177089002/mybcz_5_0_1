//package com.baicizhan.client.wordlock.view;
//
//import android.annotation.SuppressLint;
//import android.annotation.TargetApi;
//import android.content.Context;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import androidx.fragment.app.FragmentStatePagerAdapter;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentStatePagerAdapter;
////import android.support.p004v4.view.C0156bm;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.ViewGroup;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.DecelerateInterpolator;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DispCnmeanEvent;
//import com.baicizhan.client.wordlock.fragment.TailFragment;
//import com.baicizhan.client.wordlock.fragment.WordLockFragment;
//import com.baicizhan.client.wordlock.view.drag.IDragObserver;
//import com.p047d.p048a.Animator;
//import com.p047d.p048a.AnimatorListenerAdapter;
//import com.p047d.p048a.AnimatorSet;
//import com.p047d.p048a.C1549b;
//import com.p047d.p048a.ObjectAnimator;
////import p000a.p001a.p002a.EventBus;
//
//public class LockShell extends VerticalViewPager implements IDragObserver {
//    private boolean mActivate = true;
//    /* access modifiers changed from: private */
//    public UncoverShellAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public AnimatorSet mAnimSet;
//    /* access modifiers changed from: private */
//    public OnShellChangeListener mListener;
//
//    public interface OnShellChangeListener {
//        void onShellUncovered();
//    }
//
//    class UncoverShellAdapter extends FragmentStatePagerAdapter {
//        /* access modifiers changed from: private */
//        public Fragment mCurFragment;
//        /* access modifiers changed from: private */
//        public TailFragment mTailFragment;
//
//        public UncoverShellAdapter(FragmentManager vVar) {
//            super(vVar);
//        }
//
//        public Fragment getItem(int i) {
////            if (i == 0) {
////                return new WordLockFragment();
////            }
////            this.mTailFragment = new TailFragment();
////            return this.mTailFragment;
//
//            return null;
//        }
//
//        public int getCount() {
//            return 2;
//        }
//
//        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
//            if (this.mCurFragment != obj) {
//                this.mCurFragment = (Fragment) obj;
//            }
//            super.setPrimaryItem(viewGroup, i, obj);
//        }
//    }
//
//    public void setOnShellChangeListener(OnShellChangeListener onShellChangeListener) {
//        this.mListener = onShellChangeListener;
//    }
//
//    public LockShell(Context context) {
//        super(context);
//        disableOverScroll();
//    }
//
//    public LockShell(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        disableOverScroll();
//    }
//
//    @TargetApi(9)
//    private void disableOverScroll() {
//        setOverScrollMode(2);
//    }
//
//    public void init(final WordLockClient wordLockClient, OnShellChangeListener onShellChangeListener) {
//        if (wordLockClient != null) {
//            this.mAdapter = new UncoverShellAdapter(wordLockClient.getSupportFragmentManager());
////            setAdapter(this.mAdapter);
//            wordLockClient.getDragObservers().addObserver(this);
////            setOnPageChangeListener(new C0156bm() {
////                long mStartPos = -1;
////
////                public void onPageScrollStateChanged(int i) {
////                }
////
////                public void onPageScrolled(int i, float f, int i2) {
////                    long j = 0;
////                    if (1 == i && LockShell.this.mListener != null) {
////                        LockShell.this.mListener.onShellUncovered();
////                        if (!(LockShell.this.mAdapter == null || LockShell.this.mAdapter.mTailFragment == null)) {
////                            LockShell.this.mAdapter.mTailFragment.exit();
////                        }
////                    }
////                    int i3 = (int) ((1.0f - f) * 255.0f);
////                    if (!(LockShell.this.mAdapter == null || LockShell.this.mAdapter.mTailFragment == null)) {
////                        LockShell.this.mAdapter.mTailFragment.fade(i3);
////                    }
////                    if (f <= 0.0f) {
////                        this.mStartPos = -1;
////                    } else if (this.mStartPos < 0) {
////                        this.mStartPos = System.currentTimeMillis();
////                    } else {
////                        j = System.currentTimeMillis() - this.mStartPos;
////                    }
////                    wordLockClient.shrinkWordCount(f, j);
////                }
////
////                public void onPageSelected(int i) {
////                    Log.d("whiz", "on page select: " + i);
////                }
////            });
//            this.mListener = onShellChangeListener;
//        }
//    }
//
//    public void resetWordLine(boolean z, boolean z2) {
//        if (this.mAdapter != null && (this.mAdapter.mCurFragment instanceof WordLockFragment)) {
//            ((WordLockFragment) this.mAdapter.mCurFragment).resetWordLine(z, z2);
//        }
//    }
//
//    public void setActivate(boolean z) {
//        this.mActivate = z;
//    }
//
//    public void onDragStart() {
//        this.mActivate = false;
//    }
//
//    public void onDragEnd() {
//        this.mActivate = true;
//    }
//
//    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
//        if (!this.mActivate) {
//            return false;
//        }
//        return super.onInterceptTouchEvent(motionEvent);
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if (!this.mActivate) {
//            return false;
//        }
//        if (1 == motionEvent.getAction()) {
////            DispCnmeanEvent dispCnmeanEvent = new DispCnmeanEvent();
////            dispCnmeanEvent.setDisplay(false);
////            EventBus.m0a().mo9c((Object) dispCnmeanEvent);
//        }
//        return super.onTouchEvent(motionEvent);
//    }
//
//    public void guideUnlock() {
//        if (this.mAnimSet != null) {
//            this.mAnimSet.mo16164b();
//        }
//        this.mAnimSet = new AnimatorSet();
//        float dip2px = (float) Common.dip2px(getContext(), 12.0f);
//        ObjectAnimator a = ObjectAnimator.m3360a(this, "translationY", 0.0f, -dip2px).mo16215a(80);
//        a.f3483k = new DecelerateInterpolator();
//        ObjectAnimator a2 = ObjectAnimator.m3360a(this, "translationY", -dip2px, 0.0f).mo16215a(80);
//        a2.f3483k = new AccelerateInterpolator();
//        float f = dip2px * 0.8f;
//        ObjectAnimator a3 = ObjectAnimator.m3360a(this, "translationY", 0.0f, -f).mo16215a(64);
//        a3.f3483k = new DecelerateInterpolator();
//        ObjectAnimator a4 = ObjectAnimator.m3360a(this, "translationY", -f, 0.0f).mo16215a(64);
//        a4.f3483k = new AccelerateInterpolator();
//        float f2 = f * 0.8f;
//        ObjectAnimator a5 = ObjectAnimator.m3360a(this, "translationY", 0.0f, -f2).mo16215a(40);
//        a5.f3483k = new DecelerateInterpolator();
//        ObjectAnimator a6 = ObjectAnimator.m3360a(this, "translationY", -f2, 0.0f).mo16215a(40);
//        a6.f3483k = new AccelerateInterpolator();
//        this.mAnimSet.mo16162a((C1549b) new AnimatorListenerAdapter() {
//            public void onAnimationEnd(Animator aVar) {
//                LockShell.this.mAnimSet = null;
//            }
//
//            public void onAnimationCancel(Animator aVar) {
//                LockShell.this.mAnimSet = null;
//            }
//        });
//        this.mAnimSet.mo16201a(a, a2, a3, a4, a5, a6);
//        this.mAnimSet.mo16161a();
//    }
//}
