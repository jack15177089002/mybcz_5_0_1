package com.tonicartos.widget.stickygridheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: com.tonicartos.widget.stickygridheaders.g */
/* compiled from: StickyGridHeadersBaseAdapterWrapper */
public final class C2004g extends FrameLayout {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersBaseAdapterWrapper f5376a;

    /* renamed from: b */
    private boolean f5377b;

    /* renamed from: c */
    private int f5378c;

    /* renamed from: d */
    private int f5379d;

    /* renamed from: e */
    private View[] f5380e;

    public C2004g(StickyGridHeadersBaseAdapterWrapper bVar, Context context) {
        this.f5376a = bVar;
        super(context);
    }

    public final Object getTag() {
        return getChildAt(0).getTag();
    }

    public final Object getTag(int i) {
        return getChildAt(0).getTag(i);
    }

    public final View getView() {
        return getChildAt(0);
    }

    public final void setNumColumns(int i) {
        this.f5378c = i;
    }

    public final void setPosition(int i) {
        this.f5379d = i;
    }

    @SuppressLint({"NewApi"})
    public final void setRowSiblings(View[] viewArr) {
        this.f5380e = viewArr;
    }

    public final void setTag(int i, Object obj) {
        getChildAt(0).setTag(i, obj);
    }

    public final void setTag(Object obj) {
        getChildAt(0).setTag(obj);
    }

    /* access modifiers changed from: protected */
    public final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        View[] viewArr;
        super.onMeasure(i, i2);
        if (this.f5378c != 1 && this.f5376a.f5367i != null) {
            if (this.f5379d % this.f5378c == 0 && !this.f5377b) {
                this.f5377b = true;
                for (View measure : this.f5380e) {
                    measure.measure(i, i2);
                }
                this.f5377b = false;
            }
            int measuredHeight = getMeasuredHeight();
            int i3 = measuredHeight;
            for (View view : this.f5380e) {
                if (view != null) {
                    i3 = Math.max(i3, view.getMeasuredHeight());
                }
            }
            if (i3 != measuredHeight) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
        }
    }
}
