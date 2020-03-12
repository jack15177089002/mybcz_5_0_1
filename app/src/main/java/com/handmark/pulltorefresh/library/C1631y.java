package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.p057a.EmptyViewMethodAccessor;

/* renamed from: com.handmark.pulltorefresh.library.y */
/* compiled from: PullToRefreshListView */
public class C1631y extends ListView implements EmptyViewMethodAccessor {

    /* renamed from: a */
    final /* synthetic */ PullToRefreshListView f3892a;

    /* renamed from: b */
    private boolean f3893b = false;

    public C1631y(PullToRefreshListView pullToRefreshListView, Context context, AttributeSet attributeSet) {
        this.f3892a = pullToRefreshListView;
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f3892a.mLvFooterLoadingFrame != null && !this.f3893b) {
            addFooterView(this.f3892a.mLvFooterLoadingFrame, null, false);
            this.f3893b = true;
        }
        super.setAdapter(listAdapter);
    }

    public void setEmptyView(View view) {
        this.f3892a.setEmptyView(view);
    }

    public void setEmptyViewInternal(View view) {
        super.setEmptyView(view);
    }
}
