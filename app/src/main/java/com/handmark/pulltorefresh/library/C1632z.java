package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;

@TargetApi(9)
/* renamed from: com.handmark.pulltorefresh.library.z */
/* compiled from: PullToRefreshListView */
final class C1632z extends C1631y {

    /* renamed from: b */
    final /* synthetic */ PullToRefreshListView f3894b;

    public C1632z(PullToRefreshListView pullToRefreshListView, Context context, AttributeSet attributeSet) {
        this.f3894b = pullToRefreshListView;
        super(pullToRefreshListView, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        OverscrollHelper.m3633a(this.f3894b, i, i3, i2, i4, z);
        return overScrollBy;
    }
}
