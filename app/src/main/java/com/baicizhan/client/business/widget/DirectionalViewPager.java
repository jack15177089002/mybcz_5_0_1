//package com.baicizhan.client.business.widget;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.database.DataSetObserver;
//import android.graphics.Canvas;
//import android.graphics.Matrix;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.graphics.drawable.Drawable;
//import android.os.Build.VERSION;
//import android.os.Bundle;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import android.os.SystemClock;
//import android.support.p004v4.p005a.ParcelableCompat;
//import android.support.p004v4.p005a.ParcelableCompatCreatorCallbacks;
//import android.support.p004v4.view.AccessibilityDelegateCompat;
//import android.support.p004v4.view.KeyEventCompat;
//import android.support.p004v4.view.MotionEventCompat;
//import android.support.p004v4.view.PagerAdapter;
//import android.support.p004v4.view.VelocityTrackerCompat;
//import android.support.p004v4.view.ViewCompat;
//import android.support.p004v4.view.ViewConfigurationCompat;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.support.p004v4.view.p007a.AccessibilityNodeInfoCompat;
//import android.support.p004v4.view.p007a.AccessibilityRecordCompat;
//import android.support.p004v4.widget.EdgeEffectCompat;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.VelocityTracker;
//import android.view.View;
//import android.view.View.BaseSavedState;
//import android.view.View.MeasureSpec;
//import android.view.ViewConfiguration;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//import android.view.accessibility.AccessibilityEvent;
//import android.view.animation.Interpolator;
//import android.widget.Scroller;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class DirectionalViewPager extends ViewGroup {
//    private static final int CLOSE_ENOUGH = 2;
//    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
//        public final int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
//            return itemInfo.position - itemInfo2.position;
//        }
//    };
//    private static final boolean DEBUG = false;
//    private static final int DEFAULT_GUTTER_SIZE = 16;
//    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
//    private static final int DRAW_ORDER_DEFAULT = 0;
//    private static final int DRAW_ORDER_FORWARD = 1;
//    private static final int DRAW_ORDER_REVERSE = 2;
//    public static final int HORIZONTAL = 0;
//    private static final int INVALID_POINTER = -1;
//    /* access modifiers changed from: private */
//    public static final int[] LAYOUT_ATTRS = {16842931};
//    public static final int MAX_SETTLE_DURATION = 600;
//    private static final int MIN_DISTANCE_FOR_FLING = 25;
//    private static final int MIN_FLING_VELOCITY = 400;
//    public static final int SCROLL_STATE_DRAGGING = 1;
//    public static final int SCROLL_STATE_IDLE = 0;
//    public static final int SCROLL_STATE_SETTLING = 2;
//    private static final String TAG = "ViewPager";
//    private static final boolean USE_CACHE = false;
//    public static final int VERTICAL = 1;
//    private static final Interpolator sInterpolator = new Interpolator() {
//        public final float getInterpolation(float f) {
//            float f2 = f - 1.0f;
//            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
//        }
//    };
//    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
//    private int mActivePointerId = -1;
//    /* access modifiers changed from: private */
//    public PagerAdapter mAdapter;
//    private OnAdapterChangeListener mAdapterChangeListener;
//    private int mBottomPageBounds;
//    private boolean mCalledSuper;
//    private int mChildHeightMeasureSpec;
//    private int mChildWidthMeasureSpec;
//    private int mCloseEnough;
//    /* access modifiers changed from: private */
//    public int mCurItem;
//    private int mDecorChildCount;
//    private int mDefaultGutterSize;
//    private int mDrawingOrder;
//    private ArrayList<View> mDrawingOrderedChildren;
//    private EdgeEffectCompat mEndEdge;
//    private Matrix mEndEdgeMatrix;
//    private final Runnable mEndScrollRunnable = new Runnable() {
//        public void run() {
//            DirectionalViewPager.this.setScrollState(0);
//            DirectionalViewPager.this.populate();
//        }
//    };
//    private int mExpectedAdapterCount;
//    private long mFakeDragBeginTime;
//    private boolean mFakeDragging;
//    private boolean mFirstLayout = true;
//    private float mFirstOffset = -3.4028235E38f;
//    private int mFlingDistance;
//    private int mGutterSize;
//    private boolean mInLayout;
//    private float mInitialMotionX;
//    private float mInitialMotionY;
//    private OnPageChangeListener mInternalPageChangeListener;
//    private boolean mIsBeingDragged;
//    private boolean mIsUnableToDrag;
//    private final ArrayList<ItemInfo> mItems = new ArrayList<>();
//    private float mLastMotionX;
//    private float mLastMotionY;
//    private float mLastOffset = Float.MAX_VALUE;
//    private int mLeftPageBounds;
//    private Drawable mMarginDrawable;
//    private int mMaximumVelocity;
//    private int mMinimumVelocity;
//    private PagerObserver mObserver;
//    private int mOffscreenPageLimit = 1;
//    private OnPageChangeListener mOnPageChangeListener;
//    private int mOrientation = 0;
//    private int mPageMargin;
//    private PageTransformer mPageTransformer;
//    private boolean mPopulatePending;
//    private Parcelable mRestoredAdapterState = null;
//    private ClassLoader mRestoredClassLoader = null;
//    private int mRestoredCurItem = -1;
//    private int mRightPageBounds;
//    private int mScrollState = 0;
//    private Scroller mScroller;
//    private boolean mScrollingCacheEnabled;
//    private Method mSetChildrenDrawingOrderEnabled;
//    private EdgeEffectCompat mStartEdge;
//    private final ItemInfo mTempItem = new ItemInfo();
//    private final Rect mTempRect = new Rect();
//    private int mTopPageBounds;
//    private int mTouchSlop;
//    private VelocityTracker mVelocityTracker;
//
//    interface Decor {
//    }
//
//    class ItemInfo {
//        float dimensionFactor;
//        Object object;
//        float offset;
//        int position;
//        boolean scrolling;
//
//        ItemInfo() {
//        }
//    }
//
//    public class LayoutParams extends ViewGroup.LayoutParams {
//        int childIndex;
//        float dimensionFactor = 0.0f;
//        public int gravity;
//        public boolean isDecor;
//        boolean needsMeasure;
//        int position;
//
//        public LayoutParams() {
//            super(-1, -1);
//        }
//
//        public LayoutParams(Context context, AttributeSet attributeSet) {
//            super(context, attributeSet);
//            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DirectionalViewPager.LAYOUT_ATTRS);
//            this.gravity = obtainStyledAttributes.getInteger(0, 48);
//            obtainStyledAttributes.recycle();
//        }
//    }
//
//    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
//        MyAccessibilityDelegate() {
//        }
//
//        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
//            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
//            accessibilityEvent.setClassName(ViewPager.class.getName());
//            AccessibilityRecordCompat a = AccessibilityRecordCompat.m333a();
//            a.mo622a(canScroll());
//            if (accessibilityEvent.getEventType() == 4096 && DirectionalViewPager.this.mAdapter != null) {
//                a.mo621a(DirectionalViewPager.this.mAdapter.getCount());
//                a.mo623b(DirectionalViewPager.this.mCurItem);
//                a.mo624c(DirectionalViewPager.this.mCurItem);
//            }
//        }
//
//        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat eVar) {
//            super.onInitializeAccessibilityNodeInfo(view, eVar);
//            eVar.mo636a((CharSequence) ViewPager.class.getName());
//            eVar.mo638a(canScroll());
//            if (DirectionalViewPager.this.canScrollHorizontally(1)) {
//                eVar.mo633a(4096);
//            }
//            if (DirectionalViewPager.this.canScrollHorizontally(-1)) {
//                eVar.mo633a(8192);
//            }
//        }
//
//        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
//            if (super.performAccessibilityAction(view, i, bundle)) {
//                return true;
//            }
//            switch (i) {
//                case 4096:
//                    if (!DirectionalViewPager.this.canScrollHorizontally(1)) {
//                        return false;
//                    }
//                    DirectionalViewPager.this.setCurrentItem(DirectionalViewPager.this.mCurItem + 1);
//                    return true;
//                case 8192:
//                    if (!DirectionalViewPager.this.canScrollHorizontally(-1)) {
//                        return false;
//                    }
//                    DirectionalViewPager.this.setCurrentItem(DirectionalViewPager.this.mCurItem - 1);
//                    return true;
//                default:
//                    return false;
//            }
//        }
//
//        private boolean canScroll() {
//            return DirectionalViewPager.this.mAdapter != null && DirectionalViewPager.this.mAdapter.getCount() > 1;
//        }
//    }
//
//    interface OnAdapterChangeListener {
//        void onAdapterChanged(PagerAdapter aaVar, PagerAdapter aaVar2);
//    }
//
//    public interface OnPageChangeListener {
//        void onPageScrollStateChanged(int i);
//
//        void onPageScrolled(int i, float f, int i2);
//
//        void onPageSelected(int i);
//    }
//
//    public interface PageTransformer {
//        void transformPage(View view, float f);
//    }
//
//    class PagerObserver extends DataSetObserver {
//        private PagerObserver() {
//        }
//
//        public void onChanged() {
//            DirectionalViewPager.this.dataSetChanged();
//        }
//
//        public void onInvalidated() {
//            DirectionalViewPager.this.dataSetChanged();
//        }
//    }
//
//    public class SavedState extends BaseSavedState {
//        public static final Creator<SavedState> CREATOR = ParcelableCompat.m45a(new ParcelableCompatCreatorCallbacks<SavedState>() {
//            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
//                return new SavedState(parcel, classLoader);
//            }
//
//            public final SavedState[] newArray(int i) {
//                return new SavedState[i];
//            }
//        });
//        Parcelable adapterState;
//        ClassLoader loader;
//        int position;
//
//        public SavedState(Parcelable parcelable) {
//            super(parcelable);
//        }
//
//        public void writeToParcel(Parcel parcel, int i) {
//            super.writeToParcel(parcel, i);
//            parcel.writeInt(this.position);
//            parcel.writeParcelable(this.adapterState, i);
//        }
//
//        public String toString() {
//            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
//        }
//
//        SavedState(Parcel parcel, ClassLoader classLoader) {
//            super(parcel);
//            if (classLoader == null) {
//                classLoader = getClass().getClassLoader();
//            }
//            this.position = parcel.readInt();
//            this.adapterState = parcel.readParcelable(classLoader);
//            this.loader = classLoader;
//        }
//    }
//
//    public class SimpleOnPageChangeListener implements OnPageChangeListener {
//        public void onPageScrolled(int i, float f, int i2) {
//        }
//
//        public void onPageSelected(int i) {
//        }
//
//        public void onPageScrollStateChanged(int i) {
//        }
//    }
//
//    class ViewPositionComparator implements Comparator<View> {
//        ViewPositionComparator() {
//        }
//
//        public int compare(View view, View view2) {
//            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
//            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
//            if (layoutParams.isDecor != layoutParams2.isDecor) {
//                return layoutParams.isDecor ? 1 : -1;
//            }
//            return layoutParams.position - layoutParams2.position;
//        }
//    }
//
//    public DirectionalViewPager(Context context) {
//        super(context);
//        initViewPager();
//    }
//
//    public DirectionalViewPager(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948});
//        int i = obtainStyledAttributes.getInt(0, 0);
//        if (i == 0 || i == 1) {
//            setOrientation(i);
//        }
//        obtainStyledAttributes.recycle();
//        initViewPager();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void initViewPager() {
//        setWillNotDraw(false);
//        setDescendantFocusability(262144);
//        setFocusable(true);
//        Context context = getContext();
//        this.mScroller = new Scroller(context, sInterpolator);
//        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
//        float f = context.getResources().getDisplayMetrics().density;
//        this.mTouchSlop = ViewConfigurationCompat.m673a(viewConfiguration);
//        this.mMinimumVelocity = (int) (400.0f * f);
//        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
//        this.mStartEdge = new EdgeEffectCompat(context);
//        this.mEndEdge = new EdgeEffectCompat(context);
//        this.mFlingDistance = (int) (25.0f * f);
//        this.mCloseEnough = (int) (2.0f * f);
//        this.mDefaultGutterSize = (int) (16.0f * f);
//        ViewCompat.m538a((View) this, (AccessibilityDelegateCompat) new MyAccessibilityDelegate());
//        if (ViewCompat.m553f(this) == 0) {
//            ViewCompat.m547c((View) this, 1);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDetachedFromWindow() {
//        removeCallbacks(this.mEndScrollRunnable);
//        super.onDetachedFromWindow();
//    }
//
//    /* access modifiers changed from: private */
//    public void setScrollState(int i) {
//        if (this.mScrollState != i) {
//            this.mScrollState = i;
//            if (this.mPageTransformer != null) {
//                enableLayers(i != 0);
//            }
//            if (this.mOnPageChangeListener != null) {
//                this.mOnPageChangeListener.onPageScrollStateChanged(i);
//            }
//        }
//    }
//
//    public void setAdapter(PagerAdapter aaVar) {
//        if (this.mAdapter != null) {
//            this.mAdapter.unregisterDataSetObserver(this.mObserver);
//            this.mAdapter.startUpdate((ViewGroup) this);
//            for (int i = 0; i < this.mItems.size(); i++) {
//                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
//                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
//            }
//            this.mAdapter.finishUpdate((ViewGroup) this);
//            this.mItems.clear();
//            removeNonDecorViews();
//            this.mCurItem = 0;
//            scrollTo(0, 0);
//        }
//        PagerAdapter aaVar2 = this.mAdapter;
//        this.mAdapter = aaVar;
//        this.mExpectedAdapterCount = 0;
//        if (this.mAdapter != null) {
//            if (this.mObserver == null) {
//                this.mObserver = new PagerObserver();
//            }
//            this.mAdapter.registerDataSetObserver(this.mObserver);
//            this.mPopulatePending = false;
//            boolean z = this.mFirstLayout;
//            this.mFirstLayout = true;
//            this.mExpectedAdapterCount = this.mAdapter.getCount();
//            if (this.mRestoredCurItem >= 0) {
//                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
//                setCurrentItemInternal(this.mRestoredCurItem, false, true);
//                this.mRestoredCurItem = -1;
//                this.mRestoredAdapterState = null;
//                this.mRestoredClassLoader = null;
//            } else if (!z) {
//                populate();
//            } else {
//                requestLayout();
//            }
//        }
//        if (this.mAdapterChangeListener != null && aaVar2 != aaVar) {
//            this.mAdapterChangeListener.onAdapterChanged(aaVar2, aaVar);
//        }
//    }
//
//    private void removeNonDecorViews() {
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 < getChildCount()) {
//                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
//                    removeViewAt(i2);
//                    i2--;
//                }
//                i = i2 + 1;
//            } else {
//                return;
//            }
//        }
//    }
//
//    public PagerAdapter getAdapter() {
//        return this.mAdapter;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
//        this.mAdapterChangeListener = onAdapterChangeListener;
//    }
//
//    private int getClientDimension() {
//        return this.mOrientation == 0 ? getClientWidth() : getClientHeight();
//    }
//
//    private int getClientHeight() {
//        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
//    }
//
//    private int getClientWidth() {
//        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
//    }
//
//    public void setCurrentItem(int i) {
//        boolean z;
//        this.mPopulatePending = false;
//        if (!this.mFirstLayout) {
//            z = true;
//        } else {
//            z = false;
//        }
//        setCurrentItemInternal(i, z, false);
//    }
//
//    public void setCurrentItem(int i, boolean z) {
//        this.mPopulatePending = false;
//        setCurrentItemInternal(i, z, false);
//    }
//
//    public int getCurrentItem() {
//        return this.mCurItem;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
//        setCurrentItemInternal(i, z, z2, 0);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
//        boolean z3 = false;
//        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
//            setScrollingCacheEnabled(false);
//        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
//            if (i < 0) {
//                i = 0;
//            } else if (i >= this.mAdapter.getCount()) {
//                i = this.mAdapter.getCount() - 1;
//            }
//            int i3 = this.mOffscreenPageLimit;
//            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
//                for (int i4 = 0; i4 < this.mItems.size(); i4++) {
//                    ((ItemInfo) this.mItems.get(i4)).scrolling = true;
//                }
//            }
//            if (this.mCurItem != i) {
//                z3 = true;
//            }
//            if (this.mFirstLayout) {
//                this.mCurItem = i;
//                if (z3 && this.mOnPageChangeListener != null) {
//                    this.mOnPageChangeListener.onPageSelected(i);
//                }
//                if (z3 && this.mInternalPageChangeListener != null) {
//                    this.mInternalPageChangeListener.onPageSelected(i);
//                }
//                requestLayout();
//                return;
//            }
//            populate(i);
//            scrollToItem(i, z, i2, z3);
//        } else {
//            setScrollingCacheEnabled(false);
//        }
//    }
//
//    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
//        int i3;
//        ItemInfo infoForPosition = infoForPosition(i);
//        if (infoForPosition != null) {
//            i3 = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * ((float) getClientDimension()));
//        } else {
//            i3 = 0;
//        }
//        if (z) {
//            if (this.mOrientation == 0) {
//                smoothScrollTo(i3, 0, i2);
//            } else {
//                smoothScrollTo(0, i3, i2);
//            }
//            if (z2 && this.mOnPageChangeListener != null) {
//                this.mOnPageChangeListener.onPageSelected(i);
//            }
//            if (z2 && this.mInternalPageChangeListener != null) {
//                this.mInternalPageChangeListener.onPageSelected(i);
//                return;
//            }
//            return;
//        }
//        if (z2 && this.mOnPageChangeListener != null) {
//            this.mOnPageChangeListener.onPageSelected(i);
//        }
//        if (z2 && this.mInternalPageChangeListener != null) {
//            this.mInternalPageChangeListener.onPageSelected(i);
//        }
//        completeScroll(false);
//        if (this.mOrientation == 0) {
//            scrollTo(i3, 0);
//        } else {
//            scrollTo(0, i3);
//        }
//        pageScrolled(i3);
//    }
//
//    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        this.mOnPageChangeListener = onPageChangeListener;
//    }
//
//    public void setOrientation(int i) {
//        this.mOrientation = i;
//    }
//
//    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
//        boolean z2;
//        int i = 1;
//        if (VERSION.SDK_INT >= 11) {
//            boolean z3 = pageTransformer != null;
//            if (this.mPageTransformer != null) {
//                z2 = true;
//            } else {
//                z2 = false;
//            }
//            boolean z4 = z3 != z2;
//            this.mPageTransformer = pageTransformer;
//            setChildrenDrawingOrderEnabledCompat(z3);
//            if (z3) {
//                if (z) {
//                    i = 2;
//                }
//                this.mDrawingOrder = i;
//            } else {
//                this.mDrawingOrder = 0;
//            }
//            if (z4) {
//                populate();
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
//        if (VERSION.SDK_INT >= 7) {
//            if (this.mSetChildrenDrawingOrderEnabled == null) {
//                try {
//                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
//                } catch (NoSuchMethodException e) {
//                    Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
//                }
//            }
//            try {
//                this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(z)});
//            } catch (Exception e2) {
//                Log.e(TAG, "Error changing children drawing order", e2);
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public int getChildDrawingOrder(int i, int i2) {
//        if (this.mDrawingOrder == 2) {
//            i2 = (i - 1) - i2;
//        }
//        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).childIndex;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
//        this.mInternalPageChangeListener = onPageChangeListener;
//        return onPageChangeListener2;
//    }
//
//    private void setLastOffset(float f) {
//        if (f != this.mLastOffset) {
//            this.mEndEdgeMatrix = null;
//            this.mLastOffset = f;
//        }
//    }
//
//    public int getOffscreenPageLimit() {
//        return this.mOffscreenPageLimit;
//    }
//
//    public void setOffscreenPageLimit(int i) {
//        if (i <= 0) {
//            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to 1");
//            i = 1;
//        }
//        if (i != this.mOffscreenPageLimit) {
//            this.mOffscreenPageLimit = i;
//            populate();
//        }
//    }
//
//    public void setPageMargin(int i) {
//        int i2 = this.mPageMargin;
//        this.mPageMargin = i;
//        int width = getWidth();
//        recomputeScrollPosition(width, width, i, i2);
//        requestLayout();
//    }
//
//    public int getPageMargin() {
//        return this.mPageMargin;
//    }
//
//    public int getScrollCoord() {
//        return this.mOrientation == 0 ? getScrollX() : getScrollY();
//    }
//
//    public void setPageMarginDrawable(Drawable drawable) {
//        this.mMarginDrawable = drawable;
//        if (drawable != null) {
//            refreshDrawableState();
//        }
//        setWillNotDraw(drawable == null);
//        invalidate();
//    }
//
//    public void setPageMarginDrawable(int i) {
//        setPageMarginDrawable(getContext().getResources().getDrawable(i));
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean verifyDrawable(Drawable drawable) {
//        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
//    }
//
//    /* access modifiers changed from: protected */
//    public void drawableStateChanged() {
//        super.drawableStateChanged();
//        Drawable drawable = this.mMarginDrawable;
//        if (drawable != null && drawable.isStateful()) {
//            drawable.setState(getDrawableState());
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public float distanceInfluenceForSnapDuration(float f) {
//        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void smoothScrollTo(int i, int i2) {
//        smoothScrollTo(i, i2, 0);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void smoothScrollTo(int i, int i2, int i3) {
//        if (getChildCount() == 0) {
//            setScrollingCacheEnabled(false);
//            return;
//        }
//        int scrollX = getScrollX();
//        int scrollY = getScrollY();
//        int i4 = i - scrollX;
//        int i5 = i2 - scrollY;
//        if (i4 == 0 && i5 == 0) {
//            completeScroll(false);
//            populate();
//            setScrollState(0);
//            return;
//        }
//        setScrollingCacheEnabled(true);
//        setScrollState(2);
//        distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) getClientWidth())));
//        this.mScroller.startScroll(scrollX, scrollY, i4, i5, 600);
//        ViewCompat.m551e(this);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public ItemInfo addNewItem(int i, int i2) {
//        ItemInfo itemInfo = new ItemInfo();
//        itemInfo.position = i;
//        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
//        itemInfo.dimensionFactor = this.mAdapter.getPageWidth(i);
//        if (i2 < 0 || i2 >= this.mItems.size()) {
//            this.mItems.add(itemInfo);
//        } else {
//            this.mItems.add(i2, itemInfo);
//        }
//        return itemInfo;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void dataSetChanged() {
//        int i;
//        boolean z;
//        int i2;
//        boolean z2;
//        int count = this.mAdapter.getCount();
//        this.mExpectedAdapterCount = count;
//        boolean z3 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
//        boolean z4 = false;
//        int i3 = this.mCurItem;
//        boolean z5 = z3;
//        int i4 = 0;
//        while (i4 < this.mItems.size()) {
//            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i4);
//            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
//            if (itemPosition != -1) {
//                if (itemPosition == -2) {
//                    this.mItems.remove(i4);
//                    int i5 = i4 - 1;
//                    if (!z4) {
//                        this.mAdapter.startUpdate((ViewGroup) this);
//                        z4 = true;
//                    }
//                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
//                    if (this.mCurItem == itemInfo.position) {
//                        i = i5;
//                        z = z4;
//                        i2 = Math.max(0, Math.min(this.mCurItem, count - 1));
//                        z2 = true;
//                    } else {
//                        i = i5;
//                        z = z4;
//                        i2 = i3;
//                        z2 = true;
//                    }
//                } else if (itemInfo.position != itemPosition) {
//                    if (itemInfo.position == this.mCurItem) {
//                        i3 = itemPosition;
//                    }
//                    itemInfo.position = itemPosition;
//                    i = i4;
//                    z = z4;
//                    i2 = i3;
//                    z2 = true;
//                }
//                z5 = z2;
//                i3 = i2;
//                z4 = z;
//                i4 = i + 1;
//            }
//            i = i4;
//            z = z4;
//            i2 = i3;
//            z2 = z5;
//            z5 = z2;
//            i3 = i2;
//            z4 = z;
//            i4 = i + 1;
//        }
//        if (z4) {
//            this.mAdapter.finishUpdate((ViewGroup) this);
//        }
//        Collections.sort(this.mItems, COMPARATOR);
//        if (z5) {
//            int childCount = getChildCount();
//            for (int i6 = 0; i6 < childCount; i6++) {
//                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
//                if (!layoutParams.isDecor) {
//                    layoutParams.dimensionFactor = 0.0f;
//                }
//            }
//            setCurrentItemInternal(i3, false, true);
//            requestLayout();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void populate() {
//        populate(this.mCurItem);
//    }
//
//    /* access modifiers changed from: 0000 */
//    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fb, code lost:
//        if (r2.position == r18.mCurItem) goto L_0x00fd;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void populate(int r19) {
//        /*
//            r18 = this;
//            r3 = 0
//            r2 = 2
//            r0 = r18
//            int r4 = r0.mCurItem
//            r0 = r19
//            if (r4 == r0) goto L_0x0340
//            r0 = r18
//            int r2 = r0.mCurItem
//            r0 = r19
//            if (r2 >= r0) goto L_0x0030
//            r2 = 66
//        L_0x0014:
//            r0 = r18
//            int r3 = r0.mCurItem
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r3 = r0.infoForPosition(r3)
//            r0 = r19
//            r1 = r18
//            r1.mCurItem = r0
//            r4 = r3
//            r3 = r2
//        L_0x0026:
//            r0 = r18
//            android.support.v4.view.aa r2 = r0.mAdapter
//            if (r2 != 0) goto L_0x0033
//            r18.sortChildDrawingOrder()
//        L_0x002f:
//            return
//        L_0x0030:
//            r2 = 17
//            goto L_0x0014
//        L_0x0033:
//            r0 = r18
//            boolean r2 = r0.mPopulatePending
//            if (r2 == 0) goto L_0x003d
//            r18.sortChildDrawingOrder()
//            goto L_0x002f
//        L_0x003d:
//            android.os.IBinder r2 = r18.getWindowToken()
//            if (r2 == 0) goto L_0x002f
//            r0 = r18
//            android.support.v4.view.aa r2 = r0.mAdapter
//            r0 = r18
//            r2.startUpdate(r0)
//            r0 = r18
//            int r2 = r0.mOffscreenPageLimit
//            r5 = 0
//            r0 = r18
//            int r6 = r0.mCurItem
//            int r6 = r6 - r2
//            int r11 = java.lang.Math.max(r5, r6)
//            r0 = r18
//            android.support.v4.view.aa r5 = r0.mAdapter
//            int r12 = r5.getCount()
//            int r5 = r12 + -1
//            r0 = r18
//            int r6 = r0.mCurItem
//            int r2 = r2 + r6
//            int r13 = java.lang.Math.min(r5, r2)
//            r0 = r18
//            int r2 = r0.mExpectedAdapterCount
//            if (r12 == r2) goto L_0x00d6
//            android.content.res.Resources r2 = r18.getResources()     // Catch:{ NotFoundException -> 0x00cc }
//            int r3 = r18.getId()     // Catch:{ NotFoundException -> 0x00cc }
//            java.lang.String r2 = r2.getResourceName(r3)     // Catch:{ NotFoundException -> 0x00cc }
//        L_0x007f:
//            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
//            java.lang.StringBuilder r4 = new java.lang.StringBuilder
//            java.lang.String r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
//            r4.<init>(r5)
//            r0 = r18
//            int r5 = r0.mExpectedAdapterCount
//            java.lang.StringBuilder r4 = r4.append(r5)
//            java.lang.String r5 = ", found: "
//            java.lang.StringBuilder r4 = r4.append(r5)
//            java.lang.StringBuilder r4 = r4.append(r12)
//            java.lang.String r5 = " Pager id: "
//            java.lang.StringBuilder r4 = r4.append(r5)
//            java.lang.StringBuilder r2 = r4.append(r2)
//            java.lang.String r4 = " Pager class: "
//            java.lang.StringBuilder r2 = r2.append(r4)
//            java.lang.Class r4 = r18.getClass()
//            java.lang.StringBuilder r2 = r2.append(r4)
//            java.lang.String r4 = " Problematic adapter: "
//            java.lang.StringBuilder r2 = r2.append(r4)
//            r0 = r18
//            android.support.v4.view.aa r4 = r0.mAdapter
//            java.lang.Class r4 = r4.getClass()
//            java.lang.StringBuilder r2 = r2.append(r4)
//            java.lang.String r2 = r2.toString()
//            r3.<init>(r2)
//            throw r3
//        L_0x00cc:
//            r2 = move-exception
//            int r2 = r18.getId()
//            java.lang.String r2 = java.lang.Integer.toHexString(r2)
//            goto L_0x007f
//        L_0x00d6:
//            r6 = 0
//            r2 = 0
//            r5 = r2
//        L_0x00d9:
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            int r2 = r2.size()
//            if (r5 >= r2) goto L_0x033d
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r5)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//            int r7 = r2.position
//            r0 = r18
//            int r8 = r0.mCurItem
//            if (r7 < r8) goto L_0x0176
//            int r7 = r2.position
//            r0 = r18
//            int r8 = r0.mCurItem
//            if (r7 != r8) goto L_0x033d
//        L_0x00fd:
//            if (r2 != 0) goto L_0x033a
//            if (r12 <= 0) goto L_0x033a
//            r0 = r18
//            int r2 = r0.mCurItem
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = r0.addNewItem(r2, r5)
//            r10 = r2
//        L_0x010c:
//            if (r10 == 0) goto L_0x029b
//            r9 = 0
//            int r8 = r5 + -1
//            if (r8 < 0) goto L_0x017b
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r8)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//        L_0x011d:
//            int r14 = r18.getClientDimension()
//            r0 = r18
//            int r6 = r0.mOrientation
//            if (r6 != 0) goto L_0x017d
//            int r6 = r18.getPaddingLeft()
//            float r6 = (float) r6
//        L_0x012c:
//            if (r14 > 0) goto L_0x0183
//            r6 = 0
//        L_0x012f:
//            r0 = r18
//            int r7 = r0.mCurItem
//            int r7 = r7 + -1
//            r16 = r7
//            r7 = r9
//            r9 = r16
//            r17 = r8
//            r8 = r5
//            r5 = r17
//        L_0x013f:
//            if (r9 < 0) goto L_0x01c4
//            int r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
//            if (r15 < 0) goto L_0x018e
//            if (r9 >= r11) goto L_0x018e
//            if (r2 == 0) goto L_0x01c4
//            int r15 = r2.position
//            if (r9 != r15) goto L_0x0173
//            boolean r15 = r2.scrolling
//            if (r15 != 0) goto L_0x0173
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r15 = r0.mItems
//            r15.remove(r5)
//            r0 = r18
//            android.support.v4.view.aa r15 = r0.mAdapter
//            java.lang.Object r2 = r2.object
//            r0 = r18
//            r15.destroyItem(r0, r9, r2)
//            int r5 = r5 + -1
//            int r8 = r8 + -1
//            if (r5 < 0) goto L_0x018c
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r5)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//        L_0x0173:
//            int r9 = r9 + -1
//            goto L_0x013f
//        L_0x0176:
//            int r2 = r5 + 1
//            r5 = r2
//            goto L_0x00d9
//        L_0x017b:
//            r2 = 0
//            goto L_0x011d
//        L_0x017d:
//            int r6 = r18.getPaddingTop()
//            float r6 = (float) r6
//            goto L_0x012c
//        L_0x0183:
//            r7 = 1073741824(0x40000000, float:2.0)
//            float r15 = r10.dimensionFactor
//            float r7 = r7 - r15
//            float r15 = (float) r14
//            float r6 = r6 / r15
//            float r6 = r6 + r7
//            goto L_0x012f
//        L_0x018c:
//            r2 = 0
//            goto L_0x0173
//        L_0x018e:
//            if (r2 == 0) goto L_0x01a8
//            int r15 = r2.position
//            if (r9 != r15) goto L_0x01a8
//            float r2 = r2.dimensionFactor
//            float r7 = r7 + r2
//            int r5 = r5 + -1
//            if (r5 < 0) goto L_0x01a6
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r5)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//            goto L_0x0173
//        L_0x01a6:
//            r2 = 0
//            goto L_0x0173
//        L_0x01a8:
//            int r2 = r5 + 1
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = r0.addNewItem(r9, r2)
//            float r2 = r2.dimensionFactor
//            float r7 = r7 + r2
//            int r8 = r8 + 1
//            if (r5 < 0) goto L_0x01c2
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r5)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//            goto L_0x0173
//        L_0x01c2:
//            r2 = 0
//            goto L_0x0173
//        L_0x01c4:
//            float r6 = r10.dimensionFactor
//            int r9 = r8 + 1
//            r2 = 1073741824(0x40000000, float:2.0)
//            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
//            if (r2 >= 0) goto L_0x0296
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            int r2 = r2.size()
//            if (r9 >= r2) goto L_0x0238
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r9)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//            r7 = r2
//        L_0x01e3:
//            if (r14 > 0) goto L_0x023a
//            r2 = 0
//            r5 = r2
//        L_0x01e7:
//            r0 = r18
//            int r2 = r0.mCurItem
//            int r2 = r2 + 1
//            r16 = r7
//            r7 = r9
//            r9 = r2
//            r2 = r16
//        L_0x01f3:
//            if (r9 >= r12) goto L_0x0296
//            int r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
//            if (r11 < 0) goto L_0x0248
//            if (r9 <= r13) goto L_0x0248
//            if (r2 == 0) goto L_0x0296
//            int r11 = r2.position
//            if (r9 != r11) goto L_0x0333
//            boolean r11 = r2.scrolling
//            if (r11 != 0) goto L_0x0333
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r11 = r0.mItems
//            r11.remove(r7)
//            r0 = r18
//            android.support.v4.view.aa r11 = r0.mAdapter
//            java.lang.Object r2 = r2.object
//            r0 = r18
//            r11.destroyItem(r0, r9, r2)
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            int r2 = r2.size()
//            if (r7 >= r2) goto L_0x0246
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r7)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//        L_0x022b:
//            r16 = r6
//            r6 = r2
//            r2 = r16
//        L_0x0230:
//            int r9 = r9 + 1
//            r16 = r2
//            r2 = r6
//            r6 = r16
//            goto L_0x01f3
//        L_0x0238:
//            r7 = 0
//            goto L_0x01e3
//        L_0x023a:
//            int r2 = r18.getPaddingRight()
//            float r2 = (float) r2
//            float r5 = (float) r14
//            float r2 = r2 / r5
//            r5 = 1073741824(0x40000000, float:2.0)
//            float r2 = r2 + r5
//            r5 = r2
//            goto L_0x01e7
//        L_0x0246:
//            r2 = 0
//            goto L_0x022b
//        L_0x0248:
//            if (r2 == 0) goto L_0x026f
//            int r11 = r2.position
//            if (r9 != r11) goto L_0x026f
//            float r2 = r2.dimensionFactor
//            float r6 = r6 + r2
//            int r7 = r7 + 1
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            int r2 = r2.size()
//            if (r7 >= r2) goto L_0x026d
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r7)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//        L_0x0267:
//            r16 = r6
//            r6 = r2
//            r2 = r16
//            goto L_0x0230
//        L_0x026d:
//            r2 = 0
//            goto L_0x0267
//        L_0x026f:
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = r0.addNewItem(r9, r7)
//            int r7 = r7 + 1
//            float r2 = r2.dimensionFactor
//            float r6 = r6 + r2
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            int r2 = r2.size()
//            if (r7 >= r2) goto L_0x0294
//            r0 = r18
//            java.util.ArrayList<com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo> r2 = r0.mItems
//            java.lang.Object r2 = r2.get(r7)
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.ItemInfo) r2
//        L_0x028e:
//            r16 = r6
//            r6 = r2
//            r2 = r16
//            goto L_0x0230
//        L_0x0294:
//            r2 = 0
//            goto L_0x028e
//        L_0x0296:
//            r0 = r18
//            r0.calculatePageOffsets(r10, r8, r4)
//        L_0x029b:
//            r0 = r18
//            android.support.v4.view.aa r4 = r0.mAdapter
//            r0 = r18
//            int r5 = r0.mCurItem
//            if (r10 == 0) goto L_0x02ea
//            java.lang.Object r2 = r10.object
//        L_0x02a7:
//            r0 = r18
//            r4.setPrimaryItem(r0, r5, r2)
//            r0 = r18
//            android.support.v4.view.aa r2 = r0.mAdapter
//            r0 = r18
//            r2.finishUpdate(r0)
//            int r5 = r18.getChildCount()
//            r2 = 0
//            r4 = r2
//        L_0x02bb:
//            if (r4 >= r5) goto L_0x02ec
//            r0 = r18
//            android.view.View r6 = r0.getChildAt(r4)
//            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
//            com.baicizhan.client.business.widget.DirectionalViewPager$LayoutParams r2 = (com.baicizhan.client.business.widget.DirectionalViewPager.LayoutParams) r2
//            r2.childIndex = r4
//            boolean r7 = r2.isDecor
//            if (r7 != 0) goto L_0x02e6
//            float r7 = r2.dimensionFactor
//            r8 = 0
//            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
//            if (r7 != 0) goto L_0x02e6
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r6 = r0.infoForChild(r6)
//            if (r6 == 0) goto L_0x02e6
//            float r7 = r6.dimensionFactor
//            r2.dimensionFactor = r7
//            int r6 = r6.position
//            r2.position = r6
//        L_0x02e6:
//            int r2 = r4 + 1
//            r4 = r2
//            goto L_0x02bb
//        L_0x02ea:
//            r2 = 0
//            goto L_0x02a7
//        L_0x02ec:
//            r18.sortChildDrawingOrder()
//            boolean r2 = r18.hasFocus()
//            if (r2 == 0) goto L_0x002f
//            android.view.View r2 = r18.findFocus()
//            if (r2 == 0) goto L_0x0331
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r2 = r0.infoForAnyChild(r2)
//        L_0x0301:
//            if (r2 == 0) goto L_0x030b
//            int r2 = r2.position
//            r0 = r18
//            int r4 = r0.mCurItem
//            if (r2 == r4) goto L_0x002f
//        L_0x030b:
//            r2 = 0
//        L_0x030c:
//            int r4 = r18.getChildCount()
//            if (r2 >= r4) goto L_0x002f
//            r0 = r18
//            android.view.View r4 = r0.getChildAt(r2)
//            r0 = r18
//            com.baicizhan.client.business.widget.DirectionalViewPager$ItemInfo r5 = r0.infoForChild(r4)
//            if (r5 == 0) goto L_0x032e
//            int r5 = r5.position
//            r0 = r18
//            int r6 = r0.mCurItem
//            if (r5 != r6) goto L_0x032e
//            boolean r4 = r4.requestFocus(r3)
//            if (r4 != 0) goto L_0x002f
//        L_0x032e:
//            int r2 = r2 + 1
//            goto L_0x030c
//        L_0x0331:
//            r2 = 0
//            goto L_0x0301
//        L_0x0333:
//            r16 = r6
//            r6 = r2
//            r2 = r16
//            goto L_0x0230
//        L_0x033a:
//            r10 = r2
//            goto L_0x010c
//        L_0x033d:
//            r2 = r6
//            goto L_0x00fd
//        L_0x0340:
//            r4 = r3
//            r3 = r2
//            goto L_0x0026
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.widget.DirectionalViewPager.populate(int):void");
//    }
//
//    private void sortChildDrawingOrder() {
//        if (this.mDrawingOrder != 0) {
//            if (this.mDrawingOrderedChildren == null) {
//                this.mDrawingOrderedChildren = new ArrayList<>();
//            } else {
//                this.mDrawingOrderedChildren.clear();
//            }
//            int childCount = getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                this.mDrawingOrderedChildren.add(getChildAt(i));
//            }
//            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
//        }
//    }
//
//    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
//        float f;
//        ItemInfo itemInfo3;
//        ItemInfo itemInfo4;
//        int count = this.mAdapter.getCount();
//        int clientDimension = getClientDimension();
//        if (clientDimension > 0) {
//            f = ((float) this.mPageMargin) / ((float) clientDimension);
//        } else {
//            f = 0.0f;
//        }
//        if (itemInfo2 != null) {
//            int i2 = itemInfo2.position;
//            if (i2 < itemInfo.position) {
//                float f2 = itemInfo2.offset + itemInfo2.dimensionFactor + f;
//                int i3 = i2 + 1;
//                int i4 = 0;
//                while (true) {
//                    float f3 = f2;
//                    int i5 = i3;
//                    if (i5 > itemInfo.position || i4 >= this.mItems.size()) {
//                        break;
//                    }
//                    Object obj = this.mItems.get(i4);
//                    while (true) {
//                        itemInfo4 = (ItemInfo) obj;
//                        if (i5 <= itemInfo4.position || i4 >= this.mItems.size() - 1) {
//                            int i6 = i5;
//                            float f4 = f3;
//                            int i7 = i6;
//                        } else {
//                            i4++;
//                            obj = this.mItems.get(i4);
//                        }
//                    }
//                    int i62 = i5;
//                    float f42 = f3;
//                    int i72 = i62;
//                    while (i72 < itemInfo4.position) {
//                        float pageWidth = this.mAdapter.getPageWidth(i72) + f + f42;
//                        i72++;
//                        f42 = pageWidth;
//                    }
//                    itemInfo4.offset = f42;
//                    f2 = f42 + itemInfo4.dimensionFactor + f;
//                    i3 = i72 + 1;
//                }
//            } else if (i2 > itemInfo.position) {
//                int size = this.mItems.size() - 1;
//                float f5 = itemInfo2.offset;
//                int i8 = i2 - 1;
//                int i9 = size;
//                while (true) {
//                    float f6 = f5;
//                    int i10 = i8;
//                    if (i10 < itemInfo.position || i9 < 0) {
//                        break;
//                    }
//                    Object obj2 = this.mItems.get(i9);
//                    while (true) {
//                        itemInfo3 = (ItemInfo) obj2;
//                        if (i10 >= itemInfo3.position || i9 <= 0) {
//                            int i11 = i10;
//                            float f7 = f6;
//                            int i12 = i11;
//                        } else {
//                            i9--;
//                            obj2 = this.mItems.get(i9);
//                        }
//                    }
//                    int i112 = i10;
//                    float f72 = f6;
//                    int i122 = i112;
//                    while (i122 > itemInfo3.position) {
//                        float pageWidth2 = f72 - (this.mAdapter.getPageWidth(i122) + f);
//                        i122--;
//                        f72 = pageWidth2;
//                    }
//                    f5 = f72 - (itemInfo3.dimensionFactor + f);
//                    itemInfo3.offset = f5;
//                    i8 = i122 - 1;
//                }
//            }
//        }
//        int size2 = this.mItems.size();
//        float f8 = itemInfo.offset;
//        int i13 = itemInfo.position - 1;
//        this.mFirstOffset = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
//        setLastOffset(itemInfo.position == count + -1 ? (itemInfo.offset + itemInfo.dimensionFactor) - 1.0f : Float.MAX_VALUE);
//        for (int i14 = i - 1; i14 >= 0; i14--) {
//            ItemInfo itemInfo5 = (ItemInfo) this.mItems.get(i14);
//            while (i13 > itemInfo5.position) {
//                f8 -= this.mAdapter.getPageWidth(i13) + f;
//                i13--;
//            }
//            f8 -= itemInfo5.dimensionFactor + f;
//            itemInfo5.offset = f8;
//            if (itemInfo5.position == 0) {
//                this.mFirstOffset = f8;
//            }
//            i13--;
//        }
//        float f9 = itemInfo.offset + itemInfo.dimensionFactor + f;
//        int i15 = itemInfo.position + 1;
//        for (int i16 = i + 1; i16 < size2; i16++) {
//            ItemInfo itemInfo6 = (ItemInfo) this.mItems.get(i16);
//            while (i15 < itemInfo6.position) {
//                f9 += this.mAdapter.getPageWidth(i15) + f;
//                i15++;
//            }
//            if (itemInfo6.position == count - 1) {
//                setLastOffset((itemInfo6.dimensionFactor + f9) - 1.0f);
//            }
//            itemInfo6.offset = f9;
//            f9 += itemInfo6.dimensionFactor + f;
//            i15++;
//        }
//    }
//
//    public Parcelable onSaveInstanceState() {
//        SavedState savedState = new SavedState(super.onSaveInstanceState());
//        savedState.position = this.mCurItem;
//        if (this.mAdapter != null) {
//            savedState.adapterState = this.mAdapter.saveState();
//        }
//        return savedState;
//    }
//
//    public void onRestoreInstanceState(Parcelable parcelable) {
//        if (!(parcelable instanceof SavedState)) {
//            super.onRestoreInstanceState(parcelable);
//            return;
//        }
//        SavedState savedState = (SavedState) parcelable;
//        super.onRestoreInstanceState(savedState.getSuperState());
//        if (this.mAdapter != null) {
//            this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
//            setCurrentItemInternal(savedState.position, false, true);
//            return;
//        }
//        this.mRestoredCurItem = savedState.position;
//        this.mRestoredAdapterState = savedState.adapterState;
//        this.mRestoredClassLoader = savedState.loader;
//    }
//
//    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
//        ViewGroup.LayoutParams layoutParams2;
//        if (!checkLayoutParams(layoutParams)) {
//            layoutParams2 = generateLayoutParams(layoutParams);
//        } else {
//            layoutParams2 = layoutParams;
//        }
//        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
//        layoutParams3.isDecor |= view instanceof Decor;
//        if (!this.mInLayout) {
//            super.addView(view, i, layoutParams2);
//        } else if (layoutParams3 == null || !layoutParams3.isDecor) {
//            layoutParams3.needsMeasure = true;
//            addViewInLayout(view, i, layoutParams2);
//        } else {
//            throw new IllegalStateException("Cannot add pager decor view during layout");
//        }
//    }
//
//    public void removeView(View view) {
//        if (this.mInLayout) {
//            removeViewInLayout(view);
//        } else {
//            super.removeView(view);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public ItemInfo infoForChild(View view) {
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 >= this.mItems.size()) {
//                return null;
//            }
//            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
//            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
//                return itemInfo;
//            }
//            i = i2 + 1;
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public ItemInfo infoForAnyChild(View view) {
//        while (true) {
//            ViewParent parent = view.getParent();
//            if (parent == this) {
//                return infoForChild(view);
//            }
//            if (parent != null && (parent instanceof View)) {
//                view = (View) parent;
//            }
//        }
//        return null;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public ItemInfo infoForPosition(int i) {
//        int i2 = 0;
//        while (true) {
//            int i3 = i2;
//            if (i3 >= this.mItems.size()) {
//                return null;
//            }
//            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i3);
//            if (itemInfo.position == i) {
//                return itemInfo;
//            }
//            i2 = i3 + 1;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        this.mFirstLayout = true;
//    }
//
//    /* access modifiers changed from: protected */
//    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
//    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void onMeasure(int r14, int r15) {
//        /*
//            r13 = this;
//            r0 = 0
//            int r0 = getDefaultSize(r0, r14)
//            r1 = 0
//            int r1 = getDefaultSize(r1, r15)
//            r13.setMeasuredDimension(r0, r1)
//            int r1 = r13.getMeasuredWidth()
//            int r2 = r13.getMeasuredHeight()
//            int r0 = r13.mOrientation
//            if (r0 != 0) goto L_0x00af
//            int r0 = r1 / 10
//        L_0x001b:
//            int r3 = r13.mDefaultGutterSize
//            int r0 = java.lang.Math.min(r0, r3)
//            r13.mGutterSize = r0
//            int r0 = r13.getPaddingLeft()
//            int r0 = r1 - r0
//            int r1 = r13.getPaddingRight()
//            int r3 = r0 - r1
//            int r0 = r13.getPaddingTop()
//            int r0 = r2 - r0
//            int r1 = r13.getPaddingBottom()
//            int r5 = r0 - r1
//            int r9 = r13.getChildCount()
//            r0 = 0
//            r8 = r0
//        L_0x0041:
//            if (r8 >= r9) goto L_0x00c6
//            android.view.View r10 = r13.getChildAt(r8)
//            int r0 = r10.getVisibility()
//            r1 = 8
//            if (r0 == r1) goto L_0x00ab
//            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
//            com.baicizhan.client.business.widget.DirectionalViewPager$LayoutParams r0 = (com.baicizhan.client.business.widget.DirectionalViewPager.LayoutParams) r0
//            if (r0 == 0) goto L_0x00ab
//            boolean r1 = r0.isDecor
//            if (r1 == 0) goto L_0x00ab
//            int r1 = r0.gravity
//            r6 = r1 & 7
//            int r1 = r0.gravity
//            r4 = r1 & 112(0x70, float:1.57E-43)
//            r2 = -2147483648(0xffffffff80000000, float:-0.0)
//            r1 = -2147483648(0xffffffff80000000, float:-0.0)
//            r7 = 48
//            if (r4 == r7) goto L_0x006f
//            r7 = 80
//            if (r4 != r7) goto L_0x00b3
//        L_0x006f:
//            r4 = 1
//            r7 = r4
//        L_0x0071:
//            r4 = 3
//            if (r6 == r4) goto L_0x0077
//            r4 = 5
//            if (r6 != r4) goto L_0x00b6
//        L_0x0077:
//            r4 = 1
//            r6 = r4
//        L_0x0079:
//            if (r7 == 0) goto L_0x00b9
//            r2 = 1073741824(0x40000000, float:2.0)
//        L_0x007d:
//            int r4 = r0.width
//            r11 = -2
//            if (r4 == r11) goto L_0x012c
//            r4 = 1073741824(0x40000000, float:2.0)
//            int r2 = r0.width
//            r11 = -1
//            if (r2 == r11) goto L_0x0129
//            int r2 = r0.width
//        L_0x008b:
//            int r11 = r0.height
//            r12 = -2
//            if (r11 == r12) goto L_0x0126
//            r1 = 1073741824(0x40000000, float:2.0)
//            int r11 = r0.height
//            r12 = -1
//            if (r11 == r12) goto L_0x0126
//            int r0 = r0.height
//        L_0x0099:
//            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)
//            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
//            r10.measure(r2, r0)
//            if (r7 == 0) goto L_0x00be
//            int r0 = r10.getMeasuredHeight()
//            int r5 = r5 - r0
//        L_0x00ab:
//            int r0 = r8 + 1
//            r8 = r0
//            goto L_0x0041
//        L_0x00af:
//            int r0 = r2 / 10
//            goto L_0x001b
//        L_0x00b3:
//            r4 = 0
//            r7 = r4
//            goto L_0x0071
//        L_0x00b6:
//            r4 = 0
//            r6 = r4
//            goto L_0x0079
//        L_0x00b9:
//            if (r6 == 0) goto L_0x007d
//            r1 = 1073741824(0x40000000, float:2.0)
//            goto L_0x007d
//        L_0x00be:
//            if (r6 == 0) goto L_0x00ab
//            int r0 = r10.getMeasuredWidth()
//            int r3 = r3 - r0
//            goto L_0x00ab
//        L_0x00c6:
//            r0 = 1073741824(0x40000000, float:2.0)
//            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r0)
//            r13.mChildWidthMeasureSpec = r0
//            r0 = 1073741824(0x40000000, float:2.0)
//            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
//            r13.mChildHeightMeasureSpec = r0
//            r0 = 1
//            r13.mInLayout = r0
//            r13.populate()
//            r0 = 0
//            r13.mInLayout = r0
//            int r4 = r13.getChildCount()
//            r0 = 0
//            r2 = r0
//        L_0x00e5:
//            if (r2 >= r4) goto L_0x0125
//            android.view.View r6 = r13.getChildAt(r2)
//            int r0 = r6.getVisibility()
//            r1 = 8
//            if (r0 == r1) goto L_0x0113
//            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
//            com.baicizhan.client.business.widget.DirectionalViewPager$LayoutParams r0 = (com.baicizhan.client.business.widget.DirectionalViewPager.LayoutParams) r0
//            if (r0 == 0) goto L_0x00ff
//            boolean r1 = r0.isDecor
//            if (r1 != 0) goto L_0x0113
//        L_0x00ff:
//            int r1 = r13.mOrientation
//            if (r1 != 0) goto L_0x0117
//            float r1 = (float) r3
//            float r0 = r0.dimensionFactor
//            float r0 = r0 * r1
//            int r0 = (int) r0
//            r1 = 1073741824(0x40000000, float:2.0)
//            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
//            int r0 = r13.mChildHeightMeasureSpec
//        L_0x0110:
//            r6.measure(r1, r0)
//        L_0x0113:
//            int r0 = r2 + 1
//            r2 = r0
//            goto L_0x00e5
//        L_0x0117:
//            int r1 = r13.mChildWidthMeasureSpec
//            float r7 = (float) r5
//            float r0 = r0.dimensionFactor
//            float r0 = r0 * r7
//            int r0 = (int) r0
//            r7 = 1073741824(0x40000000, float:2.0)
//            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r7)
//            goto L_0x0110
//        L_0x0125:
//            return
//        L_0x0126:
//            r0 = r5
//            goto L_0x0099
//        L_0x0129:
//            r2 = r3
//            goto L_0x008b
//        L_0x012c:
//            r4 = r2
//            r2 = r3
//            goto L_0x008b
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.widget.DirectionalViewPager.onMeasure(int, int):void");
//    }
//
//    /* access modifiers changed from: protected */
//    public void onSizeChanged(int i, int i2, int i3, int i4) {
//        super.onSizeChanged(i, i2, i3, i4);
//        if (i != i3) {
//            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
//        }
//    }
//
//    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
//        if (i2 <= 0 || this.mItems.isEmpty()) {
//            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
//            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
//            if (min != getScrollX()) {
//                completeScroll(false);
//                scrollTo(min, getScrollY());
//                return;
//            }
//            return;
//        }
//        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
//        scrollTo(paddingLeft, getScrollY());
//        if (!this.mScroller.isFinished()) {
//            this.mScroller.startScroll(paddingLeft, 0, (int) (infoForPosition(this.mCurItem).offset * ((float) i)), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
//        int i5;
//        int i6;
//        int makeMeasureSpec;
//        int i7;
//        int i8;
//        int i9;
//        int i10;
//        int measuredHeight;
//        int i11;
//        int i12;
//        int childCount = getChildCount();
//        int i13 = i3 - i;
//        int i14 = i4 - i2;
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//        int scrollX = getScrollX();
//        int scrollY = getScrollY();
//        int i15 = 0;
//        int i16 = 0;
//        while (i16 < childCount) {
//            View childAt = getChildAt(i16);
//            if (childAt.getVisibility() != 8) {
//                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
//                if (layoutParams.isDecor) {
//                    int i17 = layoutParams.gravity & 112;
//                    switch (layoutParams.gravity & 7) {
//                        case 1:
//                            i10 = Math.max((i13 - childAt.getMeasuredWidth()) / 2, paddingLeft);
//                            break;
//                        case 3:
//                            i10 = paddingLeft;
//                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
//                            break;
//                        case 5:
//                            int measuredWidth = (i13 - paddingRight) - childAt.getMeasuredWidth();
//                            paddingRight += childAt.getMeasuredWidth();
//                            i10 = measuredWidth;
//                            break;
//                        default:
//                            i10 = paddingLeft;
//                            break;
//                    }
//                    switch (i17) {
//                        case 16:
//                            measuredHeight = Math.max((i14 - childAt.getMeasuredHeight()) / 2, paddingTop);
//                            int i18 = paddingBottom;
//                            i11 = paddingTop;
//                            i12 = i18;
//                            break;
//                        case 48:
//                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
//                            int i19 = paddingTop;
//                            i12 = paddingBottom;
//                            i11 = measuredHeight2;
//                            measuredHeight = i19;
//                            break;
//                        case 80:
//                            measuredHeight = (i14 - paddingBottom) - childAt.getMeasuredHeight();
//                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
//                            i11 = paddingTop;
//                            i12 = measuredHeight3;
//                            break;
//                        default:
//                            measuredHeight = paddingTop;
//                            int i20 = paddingBottom;
//                            i11 = paddingTop;
//                            i12 = i20;
//                            break;
//                    }
//                    int i21 = i10 + scrollX;
//                    int i22 = measuredHeight + scrollY;
//                    childAt.layout(i21, i22, childAt.getMeasuredWidth() + i21, childAt.getMeasuredHeight() + i22);
//                    i8 = i15 + 1;
//                    i9 = i11;
//                    paddingBottom = i12;
//                    int i23 = paddingRight;
//                    i16++;
//                    paddingLeft = paddingLeft;
//                    paddingRight = i23;
//                    paddingTop = i9;
//                    i15 = i8;
//                }
//            }
//            i8 = i15;
//            i9 = paddingTop;
//            int i232 = paddingRight;
//            i16++;
//            paddingLeft = paddingLeft;
//            paddingRight = i232;
//            paddingTop = i9;
//            i15 = i8;
//        }
//        int i24 = (i13 - paddingLeft) - paddingRight;
//        int i25 = (i14 - paddingTop) - paddingBottom;
//        for (int i26 = 0; i26 < childCount; i26++) {
//            View childAt2 = getChildAt(i26);
//            if (childAt2.getVisibility() != 8) {
//                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
//                if (!layoutParams2.isDecor) {
//                    ItemInfo infoForChild = infoForChild(childAt2);
//                    if (infoForChild != null) {
//                        if (this.mOrientation == 0) {
//                            i6 = ((int) (infoForChild.offset * ((float) i24))) + paddingLeft;
//                            i5 = paddingTop;
//                        } else {
//                            i5 = ((int) (infoForChild.offset * ((float) i25))) + paddingTop;
//                            i6 = paddingLeft;
//                        }
//                        if (layoutParams2.needsMeasure) {
//                            layoutParams2.needsMeasure = false;
//                            if (this.mOrientation == 0) {
//                                i7 = MeasureSpec.makeMeasureSpec((int) (layoutParams2.dimensionFactor * ((float) i24)), 1073741824);
//                                makeMeasureSpec = MeasureSpec.makeMeasureSpec((i14 - paddingTop) - paddingBottom, 1073741824);
//                            } else {
//                                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((i13 - paddingLeft) - paddingRight, 1073741824);
//                                makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (layoutParams2.dimensionFactor * ((float) i25)), 1073741824);
//                                i7 = makeMeasureSpec2;
//                            }
//                            childAt2.measure(i7, makeMeasureSpec);
//                        }
//                        childAt2.layout(i6, i5, childAt2.getMeasuredWidth() + i6, childAt2.getMeasuredHeight() + i5);
//                    }
//                }
//            }
//        }
//        this.mLeftPageBounds = paddingLeft;
//        this.mTopPageBounds = paddingTop;
//        this.mRightPageBounds = paddingRight;
//        this.mBottomPageBounds = i14 - paddingBottom;
//        this.mDecorChildCount = i15;
//        if (this.mFirstLayout) {
//            scrollToItem(this.mCurItem, false, 0, false);
//        }
//        this.mFirstLayout = false;
//    }
//
//    public void computeScroll() {
//        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
//            completeScroll(true);
//            return;
//        }
//        int scrollX = getScrollX();
//        int scrollY = getScrollY();
//        int currX = this.mScroller.getCurrX();
//        int currY = this.mScroller.getCurrY();
//        if (!(scrollX == currX && scrollY == currY)) {
//            scrollTo(currX, currY);
//            if (this.mOrientation == 0) {
//                if (!pageScrolled(currX)) {
//                    this.mScroller.abortAnimation();
//                    scrollTo(0, currY);
//                }
//            } else if (!pageScrolled(currY)) {
//                this.mScroller.abortAnimation();
//                scrollTo(currX, 0);
//            }
//        }
//        ViewCompat.m551e(this);
//    }
//
//    private boolean pageScrolled(int i) {
//        if (this.mItems.size() == 0) {
//            this.mCalledSuper = false;
//            onPageScrolled(0, 0.0f, 0);
//            if (this.mCalledSuper) {
//                return false;
//            }
//            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
//        }
//        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
//        int clientDimension = getClientDimension();
//        int i2 = this.mPageMargin + clientDimension;
//        float f = ((float) this.mPageMargin) / ((float) clientDimension);
//        int i3 = infoForCurrentScrollPosition.position;
//        float f2 = ((((float) i) / ((float) clientDimension)) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.dimensionFactor + f);
//        int i4 = (int) (((float) i2) * f2);
//        this.mCalledSuper = false;
//        onPageScrolled(i3, f2, i4);
//        if (this.mCalledSuper) {
//            return true;
//        }
//        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPageScrolled(int i, float f, int i2) {
//        int i3;
//        int i4;
//        int measuredWidth;
//        if (this.mDecorChildCount > 0) {
//            int scrollX = getScrollX();
//            int paddingLeft = getPaddingLeft();
//            int paddingRight = getPaddingRight();
//            int width = getWidth();
//            int childCount = getChildCount();
//            int i5 = 0;
//            while (i5 < childCount) {
//                View childAt = getChildAt(i5);
//                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
//                if (layoutParams.isDecor) {
//                    switch (layoutParams.gravity & 7) {
//                        case 1:
//                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
//                            int i6 = paddingRight;
//                            i3 = paddingLeft;
//                            i4 = i6;
//                            break;
//                        case 3:
//                            int width2 = childAt.getWidth() + paddingLeft;
//                            int i7 = paddingLeft;
//                            i4 = paddingRight;
//                            i3 = width2;
//                            measuredWidth = i7;
//                            break;
//                        case 5:
//                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
//                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
//                            i3 = paddingLeft;
//                            i4 = measuredWidth2;
//                            break;
//                        default:
//                            measuredWidth = paddingLeft;
//                            int i8 = paddingRight;
//                            i3 = paddingLeft;
//                            i4 = i8;
//                            break;
//                    }
//                    int left = (measuredWidth + scrollX) - childAt.getLeft();
//                    if (left != 0) {
//                        childAt.offsetLeftAndRight(left);
//                    }
//                } else {
//                    int i9 = paddingRight;
//                    i3 = paddingLeft;
//                    i4 = i9;
//                }
//                i5++;
//                int i10 = i4;
//                paddingLeft = i3;
//                paddingRight = i10;
//            }
//        }
//        if (this.mOnPageChangeListener != null) {
//            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
//        }
//        if (this.mInternalPageChangeListener != null) {
//            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
//        }
//        if (this.mPageTransformer != null) {
//            int scrollX2 = getScrollX();
//            int childCount2 = getChildCount();
//            for (int i11 = 0; i11 < childCount2; i11++) {
//                View childAt2 = getChildAt(i11);
//                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
//                    this.mPageTransformer.transformPage(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
//                }
//            }
//        }
//        this.mCalledSuper = true;
//    }
//
//    private void completeScroll(boolean z) {
//        boolean z2 = this.mScrollState == 2;
//        if (z2) {
//            setScrollingCacheEnabled(false);
//            this.mScroller.abortAnimation();
//            int scrollX = getScrollX();
//            int scrollY = getScrollY();
//            int currX = this.mScroller.getCurrX();
//            int currY = this.mScroller.getCurrY();
//            if (!(scrollX == currX && scrollY == currY)) {
//                scrollTo(currX, currY);
//            }
//        }
//        this.mPopulatePending = false;
//        boolean z3 = z2;
//        for (int i = 0; i < this.mItems.size(); i++) {
//            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
//            if (itemInfo.scrolling) {
//                itemInfo.scrolling = false;
//                z3 = true;
//            }
//        }
//        if (!z3) {
//            return;
//        }
//        if (z) {
//            ViewCompat.m539a((View) this, this.mEndScrollRunnable);
//        } else {
//            this.mEndScrollRunnable.run();
//        }
//    }
//
//    private boolean isGutterDrag(float f, float f2) {
//        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
//    }
//
//    private void enableLayers(boolean z) {
//        int i;
//        int childCount = getChildCount();
//        for (int i2 = 0; i2 < childCount; i2++) {
//            if (z) {
//                i = 2;
//            } else {
//                i = 0;
//            }
//            ViewCompat.m536a(getChildAt(i2), i, (Paint) null);
//        }
//    }
//
//    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
//        int finalY;
//        int action = motionEvent.getAction() & 255;
//        if (action == 3 || action == 1) {
//            this.mIsBeingDragged = false;
//            this.mIsUnableToDrag = false;
//            this.mActivePointerId = -1;
//            if (this.mVelocityTracker != null) {
//                this.mVelocityTracker.recycle();
//                this.mVelocityTracker = null;
//            }
//            return false;
//        }
//        if (action != 0) {
//            if (this.mIsBeingDragged) {
//                return true;
//            }
//            if (this.mIsUnableToDrag) {
//                return false;
//            }
//        }
//        switch (action) {
//            case 0:
//                float x = motionEvent.getX();
//                this.mInitialMotionX = x;
//                this.mLastMotionX = x;
//                float y = motionEvent.getY();
//                this.mInitialMotionY = y;
//                this.mLastMotionY = y;
//                this.mActivePointerId = MotionEventCompat.m811b(motionEvent, 0);
//                this.mIsUnableToDrag = false;
//                this.mScroller.computeScrollOffset();
//                if (this.mOrientation == 0) {
//                    finalY = this.mScroller.getFinalX() - this.mScroller.getCurrX();
//                } else {
//                    finalY = this.mScroller.getFinalY() - this.mScroller.getCurrY();
//                }
//                if (this.mScrollState == 2 && Math.abs(finalY) > this.mCloseEnough) {
//                    this.mScroller.abortAnimation();
//                    this.mPopulatePending = false;
//                    populate();
//                    this.mIsBeingDragged = true;
//                    setScrollState(1);
//                    break;
//                } else {
//                    completeScroll(false);
//                    this.mIsBeingDragged = false;
//                    break;
//                }
//            case 2:
//                int i = this.mActivePointerId;
//                if (i != -1) {
//                    int a = MotionEventCompat.m809a(motionEvent, i);
//                    float c = MotionEventCompat.m812c(motionEvent, a);
//                    float d = MotionEventCompat.m814d(motionEvent, a);
//                    if (this.mOrientation != 0) {
//                        float f = d - this.mLastMotionY;
//                        float abs = Math.abs(f);
//                        float abs2 = Math.abs(c - this.mInitialMotionX);
//                        if (f != 0.0f && !isGutterDrag(this.mLastMotionY, f)) {
//                            if (canScroll(this, false, 0, (int) f, (int) c, (int) d)) {
//                                this.mLastMotionX = c;
//                                this.mLastMotionY = d;
//                                this.mIsUnableToDrag = true;
//                                return false;
//                            }
//                        }
//                        if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
//                            this.mIsBeingDragged = true;
//                            setScrollState(1);
//                            this.mLastMotionX = c;
//                            this.mLastMotionY = f > 0.0f ? this.mInitialMotionY + ((float) this.mTouchSlop) : this.mInitialMotionY - ((float) this.mTouchSlop);
//                            setScrollingCacheEnabled(true);
//                        } else if (abs2 > ((float) this.mTouchSlop)) {
//                            this.mIsUnableToDrag = true;
//                        }
//                        if (this.mIsBeingDragged && performDrag(d)) {
//                            ViewCompat.m551e(this);
//                            break;
//                        }
//                    } else {
//                        float f2 = c - this.mLastMotionX;
//                        float abs3 = Math.abs(f2);
//                        float abs4 = Math.abs(d - this.mInitialMotionY);
//                        if (f2 != 0.0f && !isGutterDrag(this.mLastMotionX, f2)) {
//                            if (canScroll(this, false, (int) f2, 0, (int) c, (int) d)) {
//                                this.mLastMotionX = c;
//                                this.mLastMotionY = d;
//                                this.mIsUnableToDrag = true;
//                                return false;
//                            }
//                        }
//                        if (abs3 > ((float) this.mTouchSlop) && 0.5f * abs3 > abs4) {
//                            this.mIsBeingDragged = true;
//                            setScrollState(1);
//                            this.mLastMotionX = f2 > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
//                            this.mLastMotionY = d;
//                            setScrollingCacheEnabled(true);
//                        } else if (abs4 > ((float) this.mTouchSlop)) {
//                            this.mIsUnableToDrag = true;
//                        }
//                        if (this.mIsBeingDragged && performDrag(c)) {
//                            ViewCompat.m551e(this);
//                            break;
//                        }
//                    }
//                }
//                break;
//            case 6:
//                onSecondaryPointerUp(motionEvent);
//                break;
//        }
//        if (this.mVelocityTracker == null) {
//            this.mVelocityTracker = VelocityTracker.obtain();
//        }
//        this.mVelocityTracker.addMovement(motionEvent);
//        return this.mIsBeingDragged;
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        int b;
//        int i;
//        float f;
//        DirectionalViewPager directionalViewPager;
//        float f2;
//        boolean z = false;
//        if (this.mFakeDragging) {
//            return true;
//        }
//        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
//            return false;
//        }
//        if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
//            return false;
//        }
//        if (this.mVelocityTracker == null) {
//            this.mVelocityTracker = VelocityTracker.obtain();
//        }
//        this.mVelocityTracker.addMovement(motionEvent);
//        switch (motionEvent.getAction() & 255) {
//            case 0:
//                this.mScroller.abortAnimation();
//                this.mPopulatePending = false;
//                populate();
//                this.mIsBeingDragged = true;
//                setScrollState(1);
//                float x = motionEvent.getX();
//                this.mInitialMotionX = x;
//                this.mLastMotionX = x;
//                float y = motionEvent.getY();
//                this.mInitialMotionY = y;
//                this.mLastMotionY = y;
//                this.mActivePointerId = MotionEventCompat.m811b(motionEvent, 0);
//                break;
//            case 1:
//                if (this.mIsBeingDragged) {
//                    VelocityTracker velocityTracker = this.mVelocityTracker;
//                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
//                    if (this.mOrientation == 0) {
//                        b = (int) VelocityTrackerCompat.m525a(velocityTracker, this.mActivePointerId);
//                    } else {
//                        b = (int) VelocityTrackerCompat.m526b(velocityTracker, this.mActivePointerId);
//                    }
//                    this.mPopulatePending = true;
//                    int clientDimension = getClientDimension();
//                    int scrollCoord = getScrollCoord();
//                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
//                    int i2 = infoForCurrentScrollPosition.position;
//                    float f3 = ((((float) scrollCoord) / ((float) clientDimension)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.dimensionFactor;
//                    int a = MotionEventCompat.m809a(motionEvent, this.mActivePointerId);
//                    float d = this.mOrientation == 0 ? MotionEventCompat.m812c(motionEvent, a) : MotionEventCompat.m814d(motionEvent, a);
//                    if (this.mOrientation == 0) {
//                        i = (int) (d - this.mInitialMotionX);
//                    } else {
//                        i = (int) (d - this.mInitialMotionY);
//                    }
//                    setCurrentItemInternal(determineTargetPage(i2, f3, b, i), true, true, b);
//                    this.mActivePointerId = -1;
//                    endDrag();
//                    z = this.mStartEdge.mo1029c() | this.mEndEdge.mo1029c();
//                    break;
//                }
//                break;
//            case 2:
//                if (!this.mIsBeingDragged) {
//                    int a2 = MotionEventCompat.m809a(motionEvent, this.mActivePointerId);
//                    float c = MotionEventCompat.m812c(motionEvent, a2);
//                    float abs = Math.abs(c - this.mLastMotionX);
//                    float d2 = MotionEventCompat.m814d(motionEvent, a2);
//                    float abs2 = Math.abs(d2 - this.mLastMotionY);
//                    if (this.mOrientation == 0) {
//                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
//                            this.mIsBeingDragged = true;
//                            if (c - this.mInitialMotionX > 0.0f) {
//                                f2 = this.mInitialMotionX + ((float) this.mTouchSlop);
//                            } else {
//                                f2 = this.mInitialMotionX - ((float) this.mTouchSlop);
//                            }
//                            this.mLastMotionX = f2;
//                            f = d2;
//                            directionalViewPager = this;
//                        }
//                    } else if (abs2 > ((float) this.mTouchSlop) && abs2 > abs) {
//                        this.mIsBeingDragged = true;
//                        this.mLastMotionX = c;
//                        if (d2 - this.mInitialMotionY > 0.0f) {
//                            f = this.mInitialMotionY + ((float) this.mTouchSlop);
//                            directionalViewPager = this;
//                        } else {
//                            f = this.mInitialMotionY - ((float) this.mTouchSlop);
//                            directionalViewPager = this;
//                        }
//                    }
//                    directionalViewPager.mLastMotionY = f;
//                    setScrollState(1);
//                    setScrollingCacheEnabled(true);
//                }
//                if (this.mIsBeingDragged) {
//                    int a3 = MotionEventCompat.m809a(motionEvent, this.mActivePointerId);
//                    z = performDrag(this.mOrientation == 0 ? MotionEventCompat.m812c(motionEvent, a3) : MotionEventCompat.m814d(motionEvent, a3)) | false;
//                    break;
//                }
//                break;
//            case 3:
//                if (this.mIsBeingDragged) {
//                    scrollToItem(this.mCurItem, true, 0, false);
//                    this.mActivePointerId = -1;
//                    endDrag();
//                    z = this.mStartEdge.mo1029c() | this.mEndEdge.mo1029c();
//                    break;
//                }
//                break;
//            case 5:
//                int b2 = MotionEventCompat.m810b(motionEvent);
//                if (this.mOrientation == 0) {
//                    this.mLastMotionX = MotionEventCompat.m812c(motionEvent, b2);
//                } else {
//                    this.mLastMotionY = MotionEventCompat.m814d(motionEvent, b2);
//                }
//                this.mActivePointerId = MotionEventCompat.m811b(motionEvent, b2);
//                break;
//            case 6:
//                onSecondaryPointerUp(motionEvent);
//                if (this.mOrientation != 0) {
//                    this.mLastMotionY = MotionEventCompat.m814d(motionEvent, MotionEventCompat.m809a(motionEvent, this.mActivePointerId));
//                    break;
//                } else {
//                    this.mLastMotionX = MotionEventCompat.m812c(motionEvent, MotionEventCompat.m809a(motionEvent, this.mActivePointerId));
//                    break;
//                }
//        }
//        if (z) {
//            ViewCompat.m551e(this);
//        }
//        return true;
//    }
//
//    private boolean performDrag(float f) {
//        float f2;
//        boolean z;
//        float f3;
//        boolean z2 = true;
//        boolean z3 = false;
//        if (this.mOrientation == 0) {
//            f2 = this.mLastMotionX - f;
//            this.mLastMotionX = f;
//        } else {
//            f2 = this.mLastMotionY - f;
//            this.mLastMotionY = f;
//        }
//        float scrollCoord = ((float) getScrollCoord()) + f2;
//        int clientDimension = getClientDimension();
//        float f4 = ((float) clientDimension) * this.mFirstOffset;
//        float f5 = ((float) clientDimension) * this.mLastOffset;
//        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
//        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
//        if (itemInfo.position != 0) {
//            f4 = itemInfo.offset * ((float) clientDimension);
//            z = false;
//        } else {
//            z = true;
//        }
//        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
//            f3 = itemInfo2.offset * ((float) clientDimension);
//            z2 = false;
//        } else {
//            f3 = f5;
//        }
//        if (scrollCoord < f4) {
//            if (z) {
//                z3 = this.mStartEdge.mo1025a(Math.abs(f4 - scrollCoord) / ((float) clientDimension));
//            }
//        } else if (scrollCoord > f3) {
//            if (z2) {
//                z3 = this.mEndEdge.mo1025a(Math.abs(scrollCoord - f3) / ((float) clientDimension));
//            }
//            f4 = f3;
//        } else {
//            f4 = scrollCoord;
//        }
//        if (this.mOrientation == 0) {
//            this.mLastMotionX += f4 - ((float) ((int) f4));
//            scrollTo((int) f4, getScrollY());
//        } else {
//            this.mLastMotionY += f4 - ((float) ((int) f4));
//            scrollTo(getScrollX(), (int) f4);
//        }
//        pageScrolled((int) f4);
//        return z3;
//    }
//
//    private ItemInfo infoForCurrentScrollPosition() {
//        float f;
//        int i;
//        ItemInfo itemInfo;
//        int clientDimension = getClientDimension();
//        float f2 = clientDimension > 0 ? ((float) getScrollCoord()) / ((float) clientDimension) : 0.0f;
//        if (clientDimension > 0) {
//            f = ((float) this.mPageMargin) / ((float) clientDimension);
//        } else {
//            f = 0.0f;
//        }
//        float f3 = 0.0f;
//        float f4 = 0.0f;
//        int i2 = -1;
//        int i3 = 0;
//        boolean z = true;
//        ItemInfo itemInfo2 = null;
//        while (i3 < this.mItems.size()) {
//            ItemInfo itemInfo3 = (ItemInfo) this.mItems.get(i3);
//            if (z || itemInfo3.position == i2 + 1) {
//                ItemInfo itemInfo4 = itemInfo3;
//                i = i3;
//                itemInfo = itemInfo4;
//            } else {
//                ItemInfo itemInfo5 = this.mTempItem;
//                itemInfo5.offset = f3 + f4 + f;
//                itemInfo5.position = i2 + 1;
//                itemInfo5.dimensionFactor = this.mAdapter.getPageWidth(itemInfo5.position);
//                ItemInfo itemInfo6 = itemInfo5;
//                i = i3 - 1;
//                itemInfo = itemInfo6;
//            }
//            float f5 = itemInfo.offset;
//            float f6 = itemInfo.dimensionFactor + f5 + f;
//            if (!z && f2 < f5) {
//                return itemInfo2;
//            }
//            if (f2 < f6 || i == this.mItems.size() - 1) {
//                return itemInfo;
//            }
//            f4 = f5;
//            i2 = itemInfo.position;
//            z = false;
//            f3 = itemInfo.dimensionFactor;
//            itemInfo2 = itemInfo;
//            i3 = i + 1;
//        }
//        return itemInfo2;
//    }
//
//    private int determineTargetPage(int i, float f, int i2, int i3) {
//        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
//            i = (int) ((i >= this.mCurItem ? 0.4f : 0.6f) + ((float) i) + f);
//        } else if (i2 <= 0) {
//            i++;
//        }
//        if (this.mItems.size() <= 0) {
//            return i;
//        }
//        return Math.max(((ItemInfo) this.mItems.get(0)).position, Math.min(i, ((ItemInfo) this.mItems.get(this.mItems.size() - 1)).position));
//    }
//
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//        boolean z = false;
//        int a = ViewCompat.m533a((View) this);
//        if (a == 0 || (a == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
//            if (!this.mStartEdge.mo1024a()) {
//                int save = canvas.save();
//                if (this.mOrientation == 0) {
//                    int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
//                    int width = getWidth();
//                    canvas.rotate(270.0f);
//                    canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
//                    this.mStartEdge.mo1023a(height, width);
//                } else {
//                    int height2 = getHeight();
//                    int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
//                    canvas.translate((float) getPaddingLeft(), this.mFirstOffset * ((float) height2));
//                    this.mStartEdge.mo1023a(width2, height2);
//                }
//                z = this.mStartEdge.mo1027a(canvas) | false;
//                canvas.restoreToCount(save);
//            }
//            if (!this.mEndEdge.mo1024a()) {
//                int save2 = canvas.save();
//                if (this.mOrientation == 0) {
//                    int width3 = getWidth();
//                    int height3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
//                    canvas.rotate(90.0f);
//                    canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width3));
//                    this.mEndEdge.mo1023a(height3, width3);
//                } else {
//                    int width4 = (getWidth() - getPaddingLeft()) - getPaddingRight();
//                    int height4 = getHeight();
//                    if (this.mEndEdgeMatrix == null) {
//                        this.mEndEdgeMatrix = new Matrix();
//                        this.mEndEdgeMatrix.setScale(1.0f, -1.0f);
//                        this.mEndEdgeMatrix.postTranslate(0.0f, (this.mLastOffset + 1.0f) * ((float) height4));
//                    }
//                    canvas.concat(this.mEndEdgeMatrix);
//                    this.mEndEdge.mo1023a(width4, height4);
//                }
//                z |= this.mEndEdge.mo1027a(canvas);
//                canvas.restoreToCount(save2);
//            }
//        } else {
//            this.mStartEdge.mo1028b();
//            this.mEndEdge.mo1028b();
//        }
//        if (z) {
//            ViewCompat.m551e(this);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDraw(Canvas canvas) {
//        float f;
//        super.onDraw(canvas);
//        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
//            int scrollCoord = getScrollCoord();
//            int height = this.mOrientation == 0 ? getWidth() : getHeight();
//            float f2 = ((float) this.mPageMargin) / ((float) height);
//            ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
//            float f3 = itemInfo.offset;
//            int size = this.mItems.size();
//            int i = itemInfo.position;
//            int i2 = ((ItemInfo) this.mItems.get(size - 1)).position;
//            int i3 = 0;
//            int i4 = i;
//            while (i4 < i2) {
//                while (i4 > itemInfo.position && i3 < size) {
//                    i3++;
//                    itemInfo = (ItemInfo) this.mItems.get(i3);
//                }
//                if (i4 == itemInfo.position) {
//                    f = (itemInfo.offset + itemInfo.dimensionFactor) * ((float) height);
//                    f3 = itemInfo.offset + itemInfo.dimensionFactor + f2;
//                } else {
//                    float pageWidth = this.mAdapter.getPageWidth(i4);
//                    f = (f3 + pageWidth) * ((float) height);
//                    f3 += pageWidth + f2;
//                }
//                if (((float) this.mPageMargin) + f > ((float) scrollCoord)) {
//                    if (this.mOrientation == 0) {
//                        this.mMarginDrawable.setBounds((int) f, this.mTopPageBounds, (int) (((float) this.mPageMargin) + f + 0.5f), this.mBottomPageBounds);
//                    } else {
//                        this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int) f, this.mRightPageBounds, (int) (((float) this.mPageMargin) + f + 0.5f));
//                    }
//                    this.mMarginDrawable.draw(canvas);
//                }
//                if (f <= ((float) (scrollCoord + height))) {
//                    i4++;
//                } else {
//                    return;
//                }
//            }
//        }
//    }
//
//    public boolean beginFakeDrag() {
//        if (this.mIsBeingDragged) {
//            return false;
//        }
//        this.mFakeDragging = true;
//        setScrollState(1);
//        this.mLastMotionX = 0.0f;
//        this.mInitialMotionX = 0.0f;
//        this.mLastMotionY = 0.0f;
//        this.mInitialMotionY = 0.0f;
//        if (this.mVelocityTracker == null) {
//            this.mVelocityTracker = VelocityTracker.obtain();
//        } else {
//            this.mVelocityTracker.clear();
//        }
//        long uptimeMillis = SystemClock.uptimeMillis();
//        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
//        this.mVelocityTracker.addMovement(obtain);
//        obtain.recycle();
//        this.mFakeDragBeginTime = uptimeMillis;
//        return true;
//    }
//
//    public void endFakeDrag() {
//        if (!this.mFakeDragging) {
//            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
//        }
//        VelocityTracker velocityTracker = this.mVelocityTracker;
//        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
//        int a = (int) VelocityTrackerCompat.m525a(velocityTracker, this.mActivePointerId);
//        this.mPopulatePending = true;
//        int clientDimension = getClientDimension();
//        int scrollCoord = getScrollCoord();
//        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
//        setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollCoord) / ((float) clientDimension)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.dimensionFactor, a, this.mOrientation == 0 ? (int) (this.mLastMotionX - this.mInitialMotionX) : (int) (this.mLastMotionY - this.mInitialMotionY)), true, true, a);
//        endDrag();
//        this.mFakeDragging = false;
//    }
//
//    public void fakeDragBy(float f) {
//        float f2;
//        float f3;
//        if (!this.mFakeDragging) {
//            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
//        }
//        if (this.mOrientation == 0) {
//            this.mLastMotionX += f;
//        } else {
//            this.mLastMotionY += f;
//        }
//        float scrollCoord = ((float) getScrollCoord()) - f;
//        int clientDimension = getClientDimension();
//        float f4 = ((float) clientDimension) * this.mFirstOffset;
//        float f5 = ((float) clientDimension) * this.mLastOffset;
//        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
//        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
//        if (itemInfo.position != 0) {
//            f2 = itemInfo.offset * ((float) clientDimension);
//        } else {
//            f2 = f4;
//        }
//        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
//            f3 = itemInfo2.offset * ((float) clientDimension);
//        } else {
//            f3 = f5;
//        }
//        if (scrollCoord >= f2) {
//            if (scrollCoord > f3) {
//                f2 = f3;
//            } else {
//                f2 = scrollCoord;
//            }
//        }
//        if (this.mOrientation == 0) {
//            this.mLastMotionX += f2 - ((float) ((int) f2));
//            scrollTo((int) f2, getScrollY());
//        } else {
//            this.mLastMotionY += f2 - ((float) ((int) f2));
//            scrollTo(getScrollX(), (int) f2);
//        }
//        pageScrolled((int) f2);
//        long uptimeMillis = SystemClock.uptimeMillis();
//        MotionEvent obtain = this.mOrientation == 0 ? MotionEvent.obtain(this.mFakeDragBeginTime, uptimeMillis, 2, this.mLastMotionX, 0.0f, 0) : MotionEvent.obtain(this.mFakeDragBeginTime, uptimeMillis, 2, 0.0f, this.mLastMotionY, 0);
//        this.mVelocityTracker.addMovement(obtain);
//        obtain.recycle();
//    }
//
//    public boolean isFakeDragging() {
//        return this.mFakeDragging;
//    }
//
//    private void onSecondaryPointerUp(MotionEvent motionEvent) {
//        int b = MotionEventCompat.m810b(motionEvent);
//        if (MotionEventCompat.m811b(motionEvent, b) == this.mActivePointerId) {
//            int i = b == 0 ? 1 : 0;
//            this.mLastMotionX = MotionEventCompat.m812c(motionEvent, i);
//            this.mActivePointerId = MotionEventCompat.m811b(motionEvent, i);
//            if (this.mVelocityTracker != null) {
//                this.mVelocityTracker.clear();
//            }
//        }
//    }
//
//    private void endDrag() {
//        this.mIsBeingDragged = false;
//        this.mIsUnableToDrag = false;
//        if (this.mVelocityTracker != null) {
//            this.mVelocityTracker.recycle();
//            this.mVelocityTracker = null;
//        }
//    }
//
//    private void setScrollingCacheEnabled(boolean z) {
//        if (this.mScrollingCacheEnabled != z) {
//            this.mScrollingCacheEnabled = z;
//        }
//    }
//
//    public boolean canScrollHorizontally(int i) {
//        if (this.mAdapter == null) {
//            return false;
//        }
//        int clientWidth = getClientWidth();
//        int scrollX = getScrollX();
//        if (i < 0) {
//            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
//                return true;
//            }
//            return false;
//        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    public boolean canScrollVertically(int i) {
//        if (this.mAdapter == null) {
//            return false;
//        }
//        int clientHeight = getClientHeight();
//        int scrollY = getScrollY();
//        if (i < 0) {
//            if (scrollY > ((int) (((float) clientHeight) * this.mFirstOffset))) {
//                return true;
//            }
//            return false;
//        } else if (i <= 0 || scrollY >= ((int) (((float) clientHeight) * this.mLastOffset))) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
//        if (view instanceof ViewGroup) {
//            ViewGroup viewGroup = (ViewGroup) view;
//            int scrollX = view.getScrollX();
//            int scrollY = view.getScrollY();
//            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
//                View childAt = viewGroup.getChildAt(childCount);
//                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
//                    if (canScroll(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return z && ViewCompat.m542a(view, -i);
//    }
//
//    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
//        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
//    }
//
//    public boolean executeKeyEvent(KeyEvent keyEvent) {
//        if (keyEvent.getAction() != 0) {
//            return false;
//        }
//        switch (keyEvent.getKeyCode()) {
//            case 21:
//                return arrowScroll(17);
//            case 22:
//                return arrowScroll(66);
//            case 61:
//                if (VERSION.SDK_INT < 11) {
//                    return false;
//                }
//                if (KeyEventCompat.m794b(keyEvent)) {
//                    return arrowScroll(2);
//                }
//                if (KeyEventCompat.m793a(keyEvent)) {
//                    return arrowScroll(1);
//                }
//                return false;
//            default:
//                return false;
//        }
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c9, code lost:
//        if (r10 != 2) goto L_0x00d1;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public boolean arrowScroll(int r10) {
//        /*
//            r9 = this;
//            r1 = 0
//            r8 = 66
//            r7 = 17
//            r4 = 1
//            r3 = 0
//            android.view.View r2 = r9.findFocus()
//            if (r2 != r9) goto L_0x003e
//            r0 = r1
//        L_0x000e:
//            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
//            android.view.View r1 = r1.findNextFocus(r9, r0, r10)
//            if (r1 == 0) goto L_0x00bc
//            if (r1 == r0) goto L_0x00bc
//            if (r10 != r7) goto L_0x00a0
//            android.graphics.Rect r2 = r9.mTempRect
//            android.graphics.Rect r2 = r9.getChildRectInPagerCoordinates(r2, r1)
//            int r2 = r2.left
//            android.graphics.Rect r3 = r9.mTempRect
//            android.graphics.Rect r3 = r9.getChildRectInPagerCoordinates(r3, r0)
//            int r3 = r3.left
//            if (r0 == 0) goto L_0x009b
//            if (r2 < r3) goto L_0x009b
//            boolean r0 = r9.pageLeft()
//        L_0x0034:
//            if (r0 == 0) goto L_0x003d
//            int r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r10)
//            r9.playSoundEffect(r1)
//        L_0x003d:
//            return r0
//        L_0x003e:
//            if (r2 == 0) goto L_0x00d4
//            android.view.ViewParent r0 = r2.getParent()
//        L_0x0044:
//            boolean r5 = r0 instanceof android.view.ViewGroup
//            if (r5 == 0) goto L_0x00d7
//            if (r0 != r9) goto L_0x007b
//            r0 = r4
//        L_0x004b:
//            if (r0 != 0) goto L_0x00d4
//            java.lang.StringBuilder r5 = new java.lang.StringBuilder
//            r5.<init>()
//            java.lang.Class r0 = r2.getClass()
//            java.lang.String r0 = r0.getSimpleName()
//            r5.append(r0)
//            android.view.ViewParent r0 = r2.getParent()
//        L_0x0061:
//            boolean r2 = r0 instanceof android.view.ViewGroup
//            if (r2 == 0) goto L_0x0080
//            java.lang.String r2 = " => "
//            java.lang.StringBuilder r2 = r5.append(r2)
//            java.lang.Class r6 = r0.getClass()
//            java.lang.String r6 = r6.getSimpleName()
//            r2.append(r6)
//            android.view.ViewParent r0 = r0.getParent()
//            goto L_0x0061
//        L_0x007b:
//            android.view.ViewParent r0 = r0.getParent()
//            goto L_0x0044
//        L_0x0080:
//            java.lang.String r0 = "ViewPager"
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder
//            java.lang.String r6 = "arrowScroll tried to find focus based on non-child current focused view "
//            r2.<init>(r6)
//            java.lang.String r5 = r5.toString()
//            java.lang.StringBuilder r2 = r2.append(r5)
//            java.lang.String r2 = r2.toString()
//            android.util.Log.e(r0, r2)
//            r0 = r1
//            goto L_0x000e
//        L_0x009b:
//            boolean r0 = r1.requestFocus()
//            goto L_0x0034
//        L_0x00a0:
//            if (r10 != r8) goto L_0x00d1
//            android.graphics.Rect r2 = r9.mTempRect
//            android.graphics.Rect r2 = r9.getChildRectInPagerCoordinates(r2, r1)
//            int r2 = r2.left
//            android.graphics.Rect r3 = r9.mTempRect
//            android.graphics.Rect r3 = r9.getChildRectInPagerCoordinates(r3, r0)
//            int r3 = r3.left
//            if (r0 == 0) goto L_0x00b6
//            if (r2 <= r3) goto L_0x00cb
//        L_0x00b6:
//            boolean r0 = r1.requestFocus()
//            goto L_0x0034
//        L_0x00bc:
//            if (r10 == r7) goto L_0x00c0
//            if (r10 != r4) goto L_0x00c6
//        L_0x00c0:
//            boolean r0 = r9.pageLeft()
//            goto L_0x0034
//        L_0x00c6:
//            if (r10 == r8) goto L_0x00cb
//            r0 = 2
//            if (r10 != r0) goto L_0x00d1
//        L_0x00cb:
//            boolean r0 = r9.pageRight()
//            goto L_0x0034
//        L_0x00d1:
//            r0 = r3
//            goto L_0x0034
//        L_0x00d4:
//            r0 = r2
//            goto L_0x000e
//        L_0x00d7:
//            r0 = r3
//            goto L_0x004b
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.widget.DirectionalViewPager.arrowScroll(int):boolean");
//    }
//
//    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
//        Rect rect2;
//        if (rect == null) {
//            rect2 = new Rect();
//        } else {
//            rect2 = rect;
//        }
//        if (view == null) {
//            rect2.set(0, 0, 0, 0);
//            return rect2;
//        }
//        rect2.left = view.getLeft();
//        rect2.right = view.getRight();
//        rect2.top = view.getTop();
//        rect2.bottom = view.getBottom();
//        ViewParent parent = view.getParent();
//        while ((parent instanceof ViewGroup) && parent != this) {
//            ViewGroup viewGroup = (ViewGroup) parent;
//            rect2.left += viewGroup.getLeft();
//            rect2.right += viewGroup.getRight();
//            rect2.top += viewGroup.getTop();
//            rect2.bottom += viewGroup.getBottom();
//            parent = viewGroup.getParent();
//        }
//        return rect2;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean pageLeft() {
//        if (this.mCurItem <= 0) {
//            return false;
//        }
//        setCurrentItem(this.mCurItem - 1, true);
//        return true;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean pageRight() {
//        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
//            return false;
//        }
//        setCurrentItem(this.mCurItem + 1, true);
//        return true;
//    }
//
//    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
//        int size = arrayList.size();
//        int descendantFocusability = getDescendantFocusability();
//        if (descendantFocusability != 393216) {
//            for (int i3 = 0; i3 < getChildCount(); i3++) {
//                View childAt = getChildAt(i3);
//                if (childAt.getVisibility() == 0) {
//                    ItemInfo infoForChild = infoForChild(childAt);
//                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
//                        childAt.addFocusables(arrayList, i, i2);
//                    }
//                }
//            }
//        }
//        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
//            return;
//        }
//        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
//            arrayList.add(this);
//        }
//    }
//
//    public void addTouchables(ArrayList<View> arrayList) {
//        for (int i = 0; i < getChildCount(); i++) {
//            View childAt = getChildAt(i);
//            if (childAt.getVisibility() == 0) {
//                ItemInfo infoForChild = infoForChild(childAt);
//                if (infoForChild != null && infoForChild.position == this.mCurItem) {
//                    childAt.addTouchables(arrayList);
//                }
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean onRequestFocusInDescendants(int i, Rect rect) {
//        int i2;
//        int i3 = -1;
//        int childCount = getChildCount();
//        if ((i & 2) != 0) {
//            i3 = 1;
//            i2 = 0;
//        } else {
//            i2 = childCount - 1;
//            childCount = -1;
//        }
//        while (i2 != childCount) {
//            View childAt = getChildAt(i2);
//            if (childAt.getVisibility() == 0) {
//                ItemInfo infoForChild = infoForChild(childAt);
//                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
//                    return true;
//                }
//            }
//            i2 += i3;
//        }
//        return false;
//    }
//
//    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
//        if (accessibilityEvent.getEventType() == 4096) {
//            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
//        }
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View childAt = getChildAt(i);
//            if (childAt.getVisibility() == 0) {
//                ItemInfo infoForChild = infoForChild(childAt);
//                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /* access modifiers changed from: protected */
//    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
//        return new LayoutParams();
//    }
//
//    /* access modifiers changed from: protected */
//    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
//        return generateDefaultLayoutParams();
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
//        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
//    }
//
//    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
//        return new LayoutParams(getContext(), attributeSet);
//    }
//}
