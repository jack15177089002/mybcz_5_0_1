package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.p057a.LoadingLayout;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    private boolean mBackToEnd = true;
    private boolean mBackToStart = true;
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private boolean mListViewExtrasEnabled;
    private int mLoadingVisibility = 0;
    /* access modifiers changed from: private */
    public FrameLayout mLvFooterLoadingFrame;

    public PullToRefreshListView(Context context) {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshListView(Context context, C1620n nVar) {
        super(context, nVar);
    }

    public PullToRefreshListView(Context context, C1620n nVar, int i) {
        super(context, nVar, i);
    }

    public final int getPullToRefreshScrollDirection$2ae02adb() {
        return C1627u.f3870a;
    }

    /* access modifiers changed from: protected */
    public void onRefreshing(boolean z) {
        LoadingLayout footerLayout;
        LoadingLayout fVar;
        LoadingLayout fVar2;
        int count;
        int scrollY;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (!this.mListViewExtrasEnabled || !getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.onRefreshing(z);
            return;
        }
        super.onRefreshing(false);
        switch (C1630x.f3891a[getCurrentMode().ordinal()]) {
            case 1:
            case 2:
                footerLayout = getFooterLayout();
                fVar = this.mFooterLoadingView;
                fVar2 = this.mHeaderLoadingView;
                count = ((ListView) this.mRefreshableView).getCount() - 1;
                scrollY = getScrollY() - getFooterSize();
                break;
            default:
                LoadingLayout headerLayout = getHeaderLayout();
                LoadingLayout fVar3 = this.mHeaderLoadingView;
                scrollY = getScrollY() + getHeaderSize();
                footerLayout = headerLayout;
                fVar = fVar3;
                fVar2 = this.mFooterLoadingView;
                count = 0;
                break;
        }
        footerLayout.mo16399i();
        footerLayout.mo16394e();
        fVar2.setVisibility(8);
        fVar.setVisibility(0);
        fVar.mo16396g();
        if (z) {
            disableLoadingLayoutVisibilityChanges();
            switch (C1630x.f3891a[getCurrentMode().ordinal()]) {
                case 1:
                case 2:
                    if (this.mBackToEnd) {
                        setHeaderScroll(scrollY);
                        smoothScrollTo(0);
                        break;
                    }
                    break;
                default:
                    if (this.mBackToStart) {
                        setHeaderScroll(scrollY);
                        smoothScrollTo(0);
                        break;
                    }
                    break;
            }
            ((ListView) this.mRefreshableView).setSelection(count);
        }
        switch (this.mLoadingVisibility) {
            case 4:
                fVar.setVisibility(4);
                return;
            case 8:
                fVar.setVisibility(8);
                return;
            default:
                fVar.setVisibility(0);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        boolean z;
        int i;
        LoadingLayout fVar;
        LoadingLayout fVar2;
        int i2 = 0;
        boolean z2 = true;
        if (!this.mListViewExtrasEnabled) {
            super.onReset();
            return;
        }
        switch (C1630x.f3891a[getCurrentMode().ordinal()]) {
            case 1:
            case 2:
                LoadingLayout footerLayout = getFooterLayout();
                LoadingLayout fVar3 = this.mFooterLoadingView;
                int count = ((ListView) this.mRefreshableView).getCount() - 1;
                int footerSize = getFooterSize();
                if (Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - count) <= 1) {
                    z = true;
                } else {
                    z = false;
                }
                i2 = count;
                i = footerSize;
                fVar = fVar3;
                fVar2 = footerLayout;
                break;
            default:
                LoadingLayout headerLayout = getHeaderLayout();
                LoadingLayout fVar4 = this.mHeaderLoadingView;
                int i3 = -getHeaderSize();
                if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() + 0) > 1) {
                    z2 = false;
                }
                z = z2;
                i = i3;
                fVar = fVar4;
                fVar2 = headerLayout;
                break;
        }
        if (fVar.getVisibility() == 0) {
            fVar2.mo16400j();
            fVar.setVisibility(8);
            if (z && getState() != C1629w.MANUAL_REFRESHING) {
                ((ListView) this.mRefreshableView).setSelection(i2);
                setHeaderScroll(i);
            }
        }
        super.onReset();
    }

    /* access modifiers changed from: protected */
    public LoadingLayoutProxy createLoadingLayoutProxy(boolean z, boolean z2) {
        LoadingLayoutProxy createLoadingLayoutProxy = super.createLoadingLayoutProxy(z, z2);
        if (this.mListViewExtrasEnabled) {
            C1620n mode = getMode();
            if (z && mode.mo16493c()) {
                createLoadingLayoutProxy.mo16404a(this.mHeaderLoadingView);
            }
            if (z2 && mode.mo16494d()) {
                createLoadingLayoutProxy.mo16404a(this.mFooterLoadingView);
            }
        }
        return createLoadingLayoutProxy;
    }

    /* access modifiers changed from: protected */
    public ListView createListView(Context context, AttributeSet attributeSet) {
        if (VERSION.SDK_INT >= 9) {
            return new C1632z(this, context, attributeSet);
        }
        return new C1631y(this, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView createListView = createListView(context, attributeSet);
        createListView.setId(16908298);
        return createListView;
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray typedArray) {
        super.handleStyledAttributes(typedArray);
        this.mListViewExtrasEnabled = typedArray.getBoolean(C1611ah.PullToRefresh_ptrListViewExtrasEnabled, true);
        if (this.mListViewExtrasEnabled) {
            LayoutParams layoutParams = new LayoutParams(-1, -2, 1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mHeaderLoadingView = createLoadingLayout(getContext(), C1620n.PULL_FROM_START, typedArray);
            this.mHeaderLoadingView.setVisibility(8);
            frameLayout.addView(this.mHeaderLoadingView, layoutParams);
            ((ListView) this.mRefreshableView).addHeaderView(frameLayout, null, false);
            this.mLvFooterLoadingFrame = new FrameLayout(getContext());
            this.mFooterLoadingView = createLoadingLayout(getContext(), C1620n.PULL_FROM_END, typedArray);
            this.mFooterLoadingView.setVisibility(8);
            this.mLvFooterLoadingFrame.addView(this.mFooterLoadingView, layoutParams);
            if (!typedArray.hasValue(C1611ah.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    public void setBackToStart(boolean z) {
        this.mBackToStart = z;
    }

    public void setBackToEnd(boolean z) {
        this.mBackToEnd = z;
    }

    public void setLoadingVisibility(int i) {
        this.mLoadingVisibility = i;
    }
}
