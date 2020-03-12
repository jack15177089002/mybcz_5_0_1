package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
//import com.handmark.pulltorefresh.library.g$com.handmark.pulltorefresh.library.v;
import com.handmark.pulltorefresh.library.p057a.C1603i;
import com.handmark.pulltorefresh.library.p057a.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.p057a.LoadingLayout;
import com.handmark.pulltorefresh.library.p057a.RotateLoadingLayout;

/* renamed from: com.handmark.pulltorefresh.library.g */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    static final boolean DEBUG = false;
    static final int DEMO_SCROLL_INTERVAL = 225;
    static final float FRICTION = 0.8f;
    static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    static final boolean USE_HW_LAYERS = false;
    private C1620n mCurrentMode;
//    private v mCurrentSmoothScrollRunnable;
    private boolean mFilterTouchEvents = true;
    private LoadingLayout mFooterLayout;
    private float mFooterScale = 1.0f;
    private float mFriction = FRICTION;
    private LoadingLayout mHeaderLayout;
    private float mHeaderScale = 1.0f;
    private boolean mHideLoadingLayout = false;
    private boolean mIgnoreTouchSlop = false;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged = false;
    private float mLastMotionX;
    private float mLastMotionY;
    private boolean mLayoutVisibilityChangesEnabled = true;
    private int mLoadingAnimationStyle$66fe114b = C1619m.m3639b();
    private C1620n mMode = C1620n.m3640a();
    private C1622p<T> mOnPullEventListener;
    private C1623q<T> mOnPullingEventListener;
    private C1624r<T> mOnRefreshListener;
    private C1625s<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled = true;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    /* access modifiers changed from: private */
    public Interpolator mScrollAnimationInterpolator;
    private boolean mScrollingWhileRefreshingEnabled = false;
    private boolean mShowViewWhileRefreshing = true;
    private C1629w mState = C1629w.RESET;
    private int mTouchSlop;

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract int getPullToRefreshScrollDirection$2ae02adb();

    public abstract boolean isReadyForPullEnd();

    public abstract boolean isReadyForPullStart();

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, C1620n nVar) {
        super(context);
        this.mMode = nVar;
        init(context, null);
    }

    public PullToRefreshBase(Context context, C1620n nVar, int i) {
        super(context);
        this.mMode = nVar;
        this.mLoadingAnimationStyle$66fe114b = i;
        init(context, null);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        View refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    public final boolean demo() {
        if (this.mMode.mo16493c() && isReadyForPullStart()) {
            smoothScrollToAndBack((-getHeaderSize()) * 2);
            return true;
        } else if (!this.mMode.mo16494d() || !isReadyForPullEnd()) {
            return false;
        } else {
            smoothScrollToAndBack(getFooterSize() * 2);
            return true;
        }
    }

    public final C1620n getCurrentMode() {
        return this.mCurrentMode;
    }

    public final boolean getFilterTouchEvents() {
        return this.mFilterTouchEvents;
    }

    public final ILoadingLayout getLoadingLayoutProxy() {
        return getLoadingLayoutProxy(true, true);
    }

    public final ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2) {
        return createLoadingLayoutProxy(z, z2);
    }

    public final C1620n getMode() {
        return this.mMode;
    }

    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.mShowViewWhileRefreshing;
    }

    public final C1629w getState() {
        return this.mState;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        return !isScrollingWhileRefreshingEnabled();
    }

    public final boolean isPullToRefreshEnabled() {
        return this.mMode.mo16492b();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        if (VERSION.SDK_INT >= 9 && this.mOverScrollEnabled) {
            if (this.mRefreshableView.getOverScrollMode() != 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRefreshing() {
        return this.mState == C1629w.REFRESHING || this.mState == C1629w.MANUAL_REFRESHING;
    }

    public final boolean isScrollingWhileRefreshingEnabled() {
        return this.mScrollingWhileRefreshingEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        boolean z = false;
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            return false;
        } else if (action != 0 && this.mIsBeingDragged) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (isReadyForPull()) {
                        float y = motionEvent.getY();
                        this.mInitialMotionY = y;
                        this.mLastMotionY = y;
                        float x = motionEvent.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        this.mIsBeingDragged = false;
                        break;
                    }
                    break;
                case 2:
                    if (this.mScrollingWhileRefreshingEnabled || !isRefreshing()) {
                        if (isReadyForPull()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
                                case 1:
                                    f = x2 - this.mLastMotionX;
                                    f2 = y2 - this.mLastMotionY;
                                    break;
                                default:
                                    f = y2 - this.mLastMotionY;
                                    f2 = x2 - this.mLastMotionX;
                                    break;
                            }
                            float abs = Math.abs(f);
                            boolean z2 = !this.mFilterTouchEvents || abs > Math.abs(f2);
                            if (this.mIgnoreTouchSlop) {
                                z = z2;
                            } else if (z2 && abs > ((float) this.mTouchSlop)) {
                                z = true;
                            }
                            if (z) {
                                if (!this.mMode.mo16493c() || f < 1.0f || !isReadyForPullStart()) {
                                    if (this.mMode.mo16494d() && f <= -1.0f && isReadyForPullEnd()) {
                                        this.mLastMotionY = y2;
                                        this.mLastMotionX = x2;
                                        this.mIsBeingDragged = true;
                                        if (this.mMode == C1620n.BOTH) {
                                            this.mCurrentMode = C1620n.PULL_FROM_END;
                                            break;
                                        }
                                    }
                                } else {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.mMode == C1620n.BOTH) {
                                        this.mCurrentMode = C1620n.PULL_FROM_START;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        return true;
                    }
                    break;
            }
            return this.mIsBeingDragged;
        }
    }

    public final void onRefreshComplete() {
        if (isRefreshing()) {
            setState(C1629w.RESET, new boolean[0]);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (!isReadyForPull()) {
                    return false;
                }
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                return true;
            case 1:
            case 3:
                if (!this.mIsBeingDragged) {
                    return false;
                }
                this.mIsBeingDragged = false;
                if (this.mState == C1629w.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
                    setState(C1629w.REFRESHING, true);
                    return true;
                } else if (isRefreshing()) {
                    smoothScrollTo(0);
                    return true;
                } else {
                    setState(C1629w.RESET, new boolean[0]);
                    return true;
                }
            case 2:
                if (!this.mIsBeingDragged) {
                    return false;
                }
                this.mLastMotionY = motionEvent.getY();
                this.mLastMotionX = motionEvent.getX();
                pullEvent();
                return true;
            default:
                return false;
        }
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.mScrollingWhileRefreshingEnabled = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.mFilterTouchEvents = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, C1620n nVar) {
        getLoadingLayoutProxy(nVar.mo16493c(), nVar.mo16494d()).setLoadingDrawable(drawable);
    }

    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(C1620n nVar) {
        if (nVar != this.mMode) {
            this.mMode = nVar;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(C1622p<T> pVar) {
        this.mOnPullEventListener = pVar;
    }

    public final void setOnRefreshListener(C1624r<T> rVar) {
        this.mOnRefreshListener = rVar;
        this.mOnRefreshListener2 = null;
    }

    public final void setOnRefreshListener(C1625s<T> sVar) {
        this.mOnRefreshListener2 = sVar;
        this.mOnRefreshListener = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, C1620n nVar) {
        getLoadingLayoutProxy(nVar.mo16493c(), nVar.mo16494d()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? C1620n.m3640a() : C1620n.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.mOverScrollEnabled = z;
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            setState(C1629w.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setRefreshingLabel(CharSequence charSequence, C1620n nVar) {
        getLoadingLayoutProxy(nVar.mo16493c(), nVar.mo16494d()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, C1620n.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, C1620n nVar) {
        getLoadingLayoutProxy(nVar.mo16493c(), nVar.mo16494d()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.mScrollAnimationInterpolator = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.mShowViewWhileRefreshing = z;
    }

    /* access modifiers changed from: 0000 */
    public final void setState(C1629w wVar, boolean... zArr) {
        this.mState = wVar;
        switch (C1618l.f3855b[this.mState.ordinal()]) {
            case 1:
                onReset();
                break;
            case 2:
                onPullToRefresh();
                break;
            case 3:
                onReleaseToRefresh();
                break;
            case 4:
            case 5:
                onRefreshing(zArr[0]);
                break;
        }
        if (this.mOnPullEventListener != null) {
            this.mOnPullEventListener.onPullEvent(this, this.mState, this.mCurrentMode);
        }
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    /* access modifiers changed from: protected */
    public LoadingLayout createLoadingLayout(Context context, C1620n nVar, TypedArray typedArray) {
        LoadingLayout bVar;
        int i = this.mLoadingAnimationStyle$66fe114b;
        int pullToRefreshScrollDirection$2ae02adb = getPullToRefreshScrollDirection$2ae02adb();
        switch (C1618l.f3857d[i - 1]) {
            case 2:
                bVar = new FlipLoadingLayout(context, nVar, pullToRefreshScrollDirection$2ae02adb, typedArray);
                break;
            default:
                bVar = new RotateLoadingLayout(context, nVar, pullToRefreshScrollDirection$2ae02adb, typedArray);
                break;
        }
        bVar.setVisibility(4);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public LoadingLayoutProxy createLoadingLayoutProxy(boolean z, boolean z2) {
        LoadingLayoutProxy bVar = new LoadingLayoutProxy();
        if (z && this.mMode.mo16493c()) {
            bVar.mo16404a(this.mHeaderLayout);
        }
        if (z2 && this.mMode.mo16494d()) {
            bVar.mo16404a(this.mFooterLayout);
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public final void disableLoadingLayoutVisibilityChanges() {
        this.mLayoutVisibilityChangesEnabled = false;
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    /* access modifiers changed from: protected */
    public final int getFooterSize() {
        return this.mFooterLayout.getContentSize();
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    /* access modifiers changed from: protected */
    public final int getHeaderSize() {
        return this.mHeaderLayout.getContentSize();
    }

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDuration() {
        return 200;
    }

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDurationLonger() {
        return SMOOTH_SCROLL_LONG_DURATION_MS;
    }

    /* access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray typedArray) {
    }

    /* access modifiers changed from: protected */
    public void onPtrRestoreInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onPtrSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
        switch (C1618l.f3856c[this.mCurrentMode.ordinal()]) {
            case 1:
                this.mFooterLayout.mo16395f();
                return;
            case 2:
                this.mHeaderLayout.mo16395f();
                return;
            default:
                return;
        }
    }

    public void onRefreshing(boolean z) {
        if (this.mMode.mo16493c()) {
            this.mHeaderLayout.mo16396g();
        }
        if (this.mMode.mo16494d()) {
            this.mFooterLayout.mo16396g();
        }
        if (!z) {
            callRefreshListener();
        } else if (this.mShowViewWhileRefreshing) {
            C1614h hVar = new C1614h(this);
            switch (C1618l.f3856c[this.mCurrentMode.ordinal()]) {
                case 1:
                case 3:
                    smoothScrollTo(getFooterSize(), (C1626t) hVar);
                    return;
                default:
                    smoothScrollTo(-getHeaderSize(), (C1626t) hVar);
                    return;
            }
        } else {
            smoothScrollTo(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
        switch (C1618l.f3856c[this.mCurrentMode.ordinal()]) {
            case 1:
                this.mFooterLayout.mo16398h();
                return;
            case 2:
                this.mHeaderLayout.mo16398h();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.mIsBeingDragged = false;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mHeaderLayout.mo16399i();
        this.mFooterLayout.mo16399i();
        smoothScrollTo(0);
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(C1620n.m3641a(bundle.getInt(STATE_MODE, 0)));
            this.mCurrentMode = C1620n.m3641a(bundle.getInt(STATE_CURRENT_MODE, 0));
            this.mScrollingWhileRefreshingEnabled = bundle.getBoolean(STATE_SCROLLING_REFRESHING_ENABLED, false);
            this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, true);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            C1629w a = C1629w.m3647a(bundle.getInt(STATE_STATE, 0));
            if (a == C1629w.REFRESHING || a == C1629w.MANUAL_REFRESHING) {
                setState(a, true);
            }
            onPtrRestoreInstanceState(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt(STATE_STATE, this.mState.f3890h);
        bundle.putInt(STATE_MODE, this.mMode.f3869h);
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.f3869h);
        bundle.putBoolean(STATE_SCROLLING_REFRESHING_ENABLED, this.mScrollingWhileRefreshingEnabled);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new C1615i(this));
    }

    /* access modifiers changed from: protected */
    public final void refreshLoadingViewsSize() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int maximumPullScroll = (int) (((float) getMaximumPullScroll()) * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                if (this.mMode.mo16493c()) {
                    this.mHeaderLayout.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.mMode.mo16494d()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.mFooterLayout.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case 2:
                if (this.mMode.mo16493c()) {
                    this.mHeaderLayout.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.mMode.mo16494d()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.mFooterLayout.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                }
            default:
                i6 = paddingBottom;
                i3 = paddingRight;
                i2 = paddingTop;
                i4 = paddingLeft;
                break;
        }
        setPadding(i4, i2, i3, i6);
    }

    /* access modifiers changed from: protected */
    public final void refreshRefreshableViewSize(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                return;
            case 2:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.mLayoutVisibilityChangesEnabled) {
            if (min < 0 && !this.mHideLoadingLayout) {
                this.mHeaderLayout.setVisibility(0);
            } else if (min <= 0 || this.mHideLoadingLayout) {
                this.mHeaderLayout.setVisibility(4);
                this.mFooterLayout.setVisibility(4);
            } else {
                this.mFooterLayout.setVisibility(0);
            }
        }
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                scrollTo(min, 0);
                return;
            case 2:
                scrollTo(0, min);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration());
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i, C1626t tVar) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration(), 0, tVar);
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollToLonger(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDurationLonger());
    }

    /* access modifiers changed from: protected */
    public void updateUIForMode() {
        LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.mHeaderLayout.getParent()) {
            removeView(this.mHeaderLayout);
        }
        if (this.mMode.mo16493c()) {
            addViewInternal(this.mHeaderLayout, 0, loadingLayoutLayoutParams);
        }
        if (this == this.mFooterLayout.getParent()) {
            removeView(this.mFooterLayout);
        }
        if (this.mMode.mo16494d()) {
            addViewInternal(this.mFooterLayout, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.mCurrentMode = this.mMode != C1620n.BOTH ? this.mMode : C1620n.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.mRefreshableViewWrapper = new FrameLayout(context);
        this.mRefreshableViewWrapper.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LayoutParams(-1, -1));
    }

    public void callRefreshListener() {
        if (this.mOnRefreshListener != null) {
            this.mOnRefreshListener.onRefresh(this);
        } else if (this.mOnRefreshListener2 == null) {
        } else {
            if (this.mCurrentMode == C1620n.PULL_FROM_START) {
                this.mOnRefreshListener2.onPullDownToRefresh(this);
            } else if (this.mCurrentMode == C1620n.PULL_FROM_END) {
                this.mOnRefreshListener2.onPullUpToRefresh(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1611ah.PullToRefresh);
        if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrMode)) {
            this.mMode = C1620n.m3641a(obtainStyledAttributes.getInteger(C1611ah.PullToRefresh_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrAnimationStyle)) {
            this.mLoadingAnimationStyle$66fe114b = C1619m.m3637a(obtainStyledAttributes.getInteger(C1611ah.PullToRefresh_ptrAnimationStyle, 0));
        }
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.mRefreshableView);
        this.mHeaderLayout = createLoadingLayout(context, C1620n.PULL_FROM_START, obtainStyledAttributes);
        this.mFooterLayout = createLoadingLayout(context, C1620n.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(C1611ah.PullToRefresh_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrAdapterViewBackground)) {
            C1603i.m3630a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(C1611ah.PullToRefresh_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrOverScroll)) {
            this.mOverScrollEnabled = obtainStyledAttributes.getBoolean(C1611ah.PullToRefresh_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(C1611ah.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
            this.mScrollingWhileRefreshingEnabled = obtainStyledAttributes.getBoolean(C1611ah.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean isReadyForPull() {
        switch (C1618l.f3856c[this.mMode.ordinal()]) {
            case 1:
                return isReadyForPullEnd();
            case 2:
                return isReadyForPullStart();
            case 4:
                return isReadyForPullEnd() || isReadyForPullStart();
            default:
                return false;
        }
    }

    private void pullEvent() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (C1618l.f3856c[this.mCurrentMode.ordinal()]) {
            case 1:
                round = Math.round(Math.max(f - f2, 0.0f) / this.mFriction);
                footerSize = (int) (((float) getFooterSize()) * this.mFooterScale);
                break;
            default:
                round = Math.round(Math.min(f - f2, 0.0f) / this.mFriction);
                footerSize = (int) (((float) getHeaderSize()) * this.mHeaderScale);
                break;
        }
        setHeaderScroll(round);
        if (round != 0 && !isRefreshing()) {
            float abs = ((float) Math.abs(round)) / ((float) footerSize);
            switch (C1618l.f3856c[this.mCurrentMode.ordinal()]) {
                case 1:
                    this.mFooterLayout.mo16393b(abs);
                    break;
                default:
                    this.mHeaderLayout.mo16393b(abs);
                    break;
            }
            if (this.mState != C1629w.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                setState(C1629w.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.mState != C1629w.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                setState(C1629w.RELEASE_TO_REFRESH, new boolean[0]);
            } else if (this.mState == C1629w.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                setState(C1629w.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LayoutParams getLoadingLayoutLayoutParams() {
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                return new LayoutParams(-2, -1);
            default:
                return new LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                return Math.round(((float) getWidth()) / this.mFriction);
            default:
                return Math.round(((float) getHeight()) / this.mFriction);
        }
    }

    private final void smoothScrollTo(int i, long j) {
        smoothScrollTo(i, j, 0, new C1616j(this));
    }

    /* access modifiers changed from: private */
    public final void smoothScrollTo(int i, long j, long j2, C1626t tVar) {
        int scrollX;
//        if (this.mCurrentSmoothScrollRunnable != null) {
//            v vVar = this.mCurrentSmoothScrollRunnable;
//            vVar.f3873a = false;
//            vVar.f3874b.removeCallbacks(vVar);
//        }
//        switch (C1618l.f3854a[getPullToRefreshScrollDirection$2ae02adb() - 1]) {
//            case 1:
//                scrollX = getScrollX();
//                break;
//            default:
//                scrollX = getScrollY();
//                break;
//        }
//        if (scrollX != i) {
//            if (this.mScrollAnimationInterpolator == null) {
//                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
//            }
//            this.mCurrentSmoothScrollRunnable = new C1628v(this, scrollX, i, j, tVar);
//            if (j2 > 0) {
//                postDelayed(this.mCurrentSmoothScrollRunnable, j2);
//            } else {
//                post(this.mCurrentSmoothScrollRunnable);
//            }
//        }
    }

    private final void smoothScrollToAndBack(int i) {
        smoothScrollTo(i, 200, 0, new C1617k(this));
    }

    public void setHeaderScale(float f) {
        this.mHeaderScale = f;
    }

    public void setFooterScale(float f) {
        this.mFooterScale = f;
    }

    public void setHideLoadingLayout(boolean z) {
        this.mHideLoadingLayout = z;
    }

    public float getLastMotionX() {
        return this.mLastMotionX;
    }

    public float getLastMotionY() {
        return this.mLastMotionY;
    }

    public void setIgnoreTouchSlop(boolean z) {
        this.mIgnoreTouchSlop = z;
    }

    public void setOnPullingEventListener(C1623q<T> qVar) {
        this.mOnPullingEventListener = qVar;
    }

    public void setOverPullFriction(float f) {
        this.mFriction = f;
    }
}
