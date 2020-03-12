//package com.baicizhan.client.p029fm.view;
//
//import android.content.Context;
//
//import androidx.fragment.app.FragmentManager;//mport android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentActivity;
////import android.support.p004v4.app.FragmentStatePagerAdapter;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.util.SparseArray;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//
//import androidx.fragment.app.Fragment;
//
//import androidx.fragment.app.FragmentStatePagerAdapter;
//
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.p029fm.data.FmData;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.util.FmSettings;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.view.FmLine */
//public class FmLine extends ViewPager {
//    static final int FM_MID_DISTANCE = 11;
//    private static final int TYPE_END = -3;
//    private static final int TYPE_MID = -1;
//    private static final int TYPE_START = -2;
//    private FmChangeAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public FmList mFmList;
//    private SparseArray<Integer> mFmMap;
//    private FmView mFmView;
//    /* access modifiers changed from: private */
//    public SparseArray<WeakReference<IFragmentUpdator>> mFragmentCache = new SparseArray<>();
//    private int mLoopCount;
//    private SparseArray<Integer> mMidMap;
//    private List<String> mMidPaths;
//    private boolean mPlayAfterMove = true;
//    /* access modifiers changed from: private */
//    public SparseArray<Integer> mTypeMap;
//
//    /* renamed from: com.baicizhan.client.fm.view.FmLine$FmChangeAdapter */
//    class FmChangeAdapter extends FragmentStatePagerAdapter {
//        private Fragment mCurFragment;
//
//        public FmChangeAdapter(FragmentManager vVar) {
//            super(vVar);
//        }
//
//        public Fragment getItem(int i) {
//            int size;
//            int size2;
//            int intValue = ((Integer) FmLine.this.mTypeMap.get(i)).intValue();
//            Log.d("whiz", "frag cache, get item: " + intValue);
//            switch (intValue) {
//                case -3:
//                    FmEndFragment createInstance = FmEndFragment.createInstance();
//                    FmLine.this.mFragmentCache.put(i, new WeakReference(createInstance));
////                    return createInstance;
//                case -2:
//                    FmStartFragment createInstance2 = FmStartFragment.createInstance(FmLine.this.mFmList.size());
//                    FmLine.this.mFragmentCache.put(i, new WeakReference(createInstance2));
////                    return createInstance2;
//                case -1:
//                    ArrayList arrayList = new ArrayList();
//                    int i2 = i / 11;
//                    if (i % 11 == 0) {
//                        size = (i2 - 1) * 10;
//                        size2 = Math.min(i2 * 10, FmLine.this.mFmList.size());
//                    } else {
//                        size = FmLine.this.mFmList.size() - (FmLine.this.mFmList.size() % 10);
//                        size2 = FmLine.this.mFmList.size();
//                    }
//                    for (int i3 = size; i3 < size2; i3++) {
//                        FmData fmData = FmLine.this.mFmList.get(i3);
//                        if (fmData == null) {
//                            throw new NullPointerException("null data cannot be transferred to middle fragment, i: " + i + "; start: " + size + "; end: " + size2 + "; index: " + i3);
//                        }
//                        arrayList.add(fmData);
//                    }
//                    FmMidFragment createInstance3 = FmMidFragment.createInstance(arrayList);
//                    FmLine.this.mFragmentCache.put(i, new WeakReference(createInstance3));
////                    return createInstance3;
//                default:
//                    FmNormalFragment createInstance4 = FmNormalFragment.createInstance(FmLine.this.mFmList.get(intValue));
//                    FmLine.this.mFragmentCache.put(i, new WeakReference(createInstance4));
////                    return createInstance4;
//            }
//
//            return null;
//        }
//
//        public int getCount() {
//            if (FmLine.this.mFmList == null || FmLine.this.mFmList.isEmpty()) {
//                return 0;
//            }
//            return FmLine.this.mTypeMap.size();
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
//    /* renamed from: com.baicizhan.client.fm.view.FmLine$OnUpdateListener */
//    public interface OnUpdateListener {
//        void onUpdated();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void resetLoop() {
//        this.mLoopCount = 0;
//        setAdapter(null);
//        setVisibility(8);
//    }
//
//    public FmLine(Context context) {
//        super(context);
//        setPageMargin(Common.dip2px(getContext(), 36.0f));
//        setClipChildren(false);
//        setOffscreenPageLimit(3);
//    }
//
//    public FmLine(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        setPageMargin(Common.dip2px(getContext(), 36.0f));
//        setClipChildren(false);
//        setOffscreenPageLimit(3);
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        clearFragmentCache();
//    }
//
//    private void clearFragmentCache() {
//        int size = this.mFragmentCache.size();
//        for (int i = 0; i < size; i++) {
//            ((WeakReference) this.mFragmentCache.valueAt(i)).clear();
//        }
//        this.mFragmentCache.clear();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setFmView(FmView fmView) {
//        this.mFmView = fmView;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void update(FmList fmList, List<String> list, OnUpdateListener onUpdateListener) {
//        clearFragmentCache();
//        this.mMidPaths = list;
//        this.mFmList = fmList;
//        int size = this.mFmList.size() + 2 + (((this.mFmList.size() + 11) - 1) / 10);
//        if (this.mFmList.size() % 10 == 0) {
//            size--;
//        }
//        this.mTypeMap = new SparseArray<>(size);
//        this.mFmMap = new SparseArray<>(this.mFmList.size());
//        this.mMidMap = new SparseArray<>();
//        int i = 0;
//        int i2 = 0;
//        for (int i3 = 0; i3 < size; i3++) {
//            int i4 = i3 % 11;
//            if ((i3 != 0 && i4 == 0 && i3 != size - 1) || i3 == size - 2) {
//                this.mTypeMap.put(i3, Integer.valueOf(-1));
//                if (this.mMidPaths != null && !this.mMidPaths.isEmpty()) {
//                    this.mMidMap.put(i3, Integer.valueOf(i));
//                    i = (i + 1) % this.mMidPaths.size();
//                }
//            } else if (i3 == size - 1) {
//                this.mTypeMap.put(i3, Integer.valueOf(-3));
//            } else if (i3 == 0) {
//                this.mTypeMap.put(i3, Integer.valueOf(-2));
//            } else {
//                this.mTypeMap.put(i3, Integer.valueOf(i2));
//                this.mFmMap.put(i2, Integer.valueOf(i3));
//                i2++;
//            }
//        }
//        Log.d("whiz", "frag cache, re adapt");
////        this.mAdapter = new FmChangeAdapter(((FragmentActivity) getContext()).getSupportFragmentManager());
////        setAdapter(this.mAdapter);
//        setVisibility(0);
//    }
//
//    private void updateAnim(final OnUpdateListener onUpdateListener) {
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//        alphaAnimation.setDuration(1000);
//        alphaAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                if (FmLine.this.getVisibility() != 0) {
//                    FmLine.this.setVisibility(0);
//                }
//                if (onUpdateListener != null) {
//                    onUpdateListener.onUpdated();
//                }
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        startAnimation(alphaAnimation);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void moveTo(int i, boolean z) {
//        if (i < 0 || i >= this.mFmList.size()) {
//            C0789L.log.error("cannot move fm line, the target index is invalid [{}], valid rage is [{}, {}]", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(this.mFmList.size() - 1));
//            return;
//        }
//        int intValue = ((Integer) this.mFmMap.get(i)).intValue();
//        this.mPlayAfterMove = canPlay(z, intValue);
//        smoothScrollTo(intValue);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void moveToNext(boolean z) {
//        int currentItem = getCurrentItem() + 1;
//        if (currentItem <= this.mAdapter.getCount() - 1 && currentItem >= 0) {
//            this.mPlayAfterMove = canPlay(z, currentItem);
//            smoothScrollTo(currentItem);
//        } else if (currentItem > this.mAdapter.getCount() - 1) {
//            this.mLoopCount++;
//            if (this.mLoopCount < FmSettings.getLoopNum()) {
//                moveTo(0, true);
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void moveToPrev(boolean z) {
//        int currentItem = getCurrentItem() - 1;
//        if (currentItem <= this.mAdapter.getCount() - 1 && currentItem >= 0) {
//            this.mPlayAfterMove = canPlay(z, currentItem);
//            smoothScrollTo(currentItem);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void forcePlayCur() {
//        doPageSelected(getCurrentItem());
//    }
//
//    private boolean canPlay(boolean z, int i) {
//        if (i != getCurrentItem()) {
//            return z;
//        }
//        if (z) {
//            return true;
//        }
//        return this.mPlayAfterMove;
//    }
//
//    private void update(int i) {
//        WeakReference weakReference = (WeakReference) this.mFragmentCache.get(i);
//        WeakReference weakReference2 = (WeakReference) this.mFragmentCache.get(i - 1);
//        WeakReference weakReference3 = (WeakReference) this.mFragmentCache.get(i + 1);
//        if (weakReference != null) {
//            IFragmentUpdator iFragmentUpdator = (IFragmentUpdator) weakReference.get();
//            if (iFragmentUpdator != null) {
//                iFragmentUpdator.setEnabled(true);
//            }
//        }
//        if (weakReference2 != null) {
//            IFragmentUpdator iFragmentUpdator2 = (IFragmentUpdator) weakReference2.get();
//            if (iFragmentUpdator2 != null) {
//                iFragmentUpdator2.setEnabled(false);
//            }
//        }
//        if (weakReference3 != null) {
//            IFragmentUpdator iFragmentUpdator3 = (IFragmentUpdator) weakReference3.get();
//            if (iFragmentUpdator3 != null) {
//                iFragmentUpdator3.setEnabled(false);
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void doPageScrolled(int i, float f, int i2) {
//        Log.d("whiz", "on page scrolled: " + i);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void doPageSelected(int i) {
//        update(i);
//        Log.d("whiz", "on page selected: " + i + "; play? " + this.mPlayAfterMove);
//        if (!this.mPlayAfterMove) {
//            this.mPlayAfterMove = true;
//        } else if (this.mFmView != null) {
//            int intValue = ((Integer) this.mTypeMap.get(i)).intValue();
//            switch (intValue) {
//                case -3:
//                    this.mFmView.playEnd();
//                    return;
//                case -2:
//                    this.mFmView.playStart();
//                    return;
//                case -1:
//                    if (this.mMidMap == null || this.mMidMap.size() == 0) {
//                        moveToNext(true);
//                        return;
//                    } else {
//                        this.mFmView.playMid(((Integer) this.mMidMap.get(i)).intValue());
//                        return;
//                    }
//                default:
//                    this.mFmView.play(intValue);
//                    return;
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void doPageScrollStateChanged(int i) {
//        Log.d("whiz", "on page changed: " + i);
//    }
//}
