package com.tonicartos.widget.stickygridheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: com.tonicartos.widget.stickygridheaders.e */
/* compiled from: StickyGridHeadersBaseAdapterWrapper */
public final class C2002e extends FrameLayout {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersBaseAdapterWrapper f5370a;

    /* renamed from: b */
    private int f5371b;

    /* renamed from: c */
    private int f5372c;

    public C2002e(StickyGridHeadersBaseAdapterWrapper bVar, Context context) {
        this.f5370a = bVar;
        super(context);
    }

    public final int getHeaderId() {
        return this.f5371b;
    }

    public final void setHeaderId(int i) {
        this.f5371b = i;
    }

    public final void setHeaderWidth(int i) {
        this.f5372c = i;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        View view = (View) getTag();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(generateDefaultLayoutParams());
        }
        if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
            view.measure(MeasureSpec.makeMeasureSpec(this.f5372c, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
        setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }
}
