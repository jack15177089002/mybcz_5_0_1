package com.baicizhan.client.friend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.p047d.p048a.C1548at;
import com.p047d.p048a.ValueAnimator;
import com.p047d.p050c.ViewHelper;

public class FoldableContainer extends FrameLayout {
    private static final int ANIMATION_DURATION = 200;

    public FoldableContainer(Context context) {
        super(context);
    }

    public FoldableContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoldableContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        post(new Runnable() {
            public void run() {
                ViewHelper.m3394f(FoldableContainer.this.getPlaceHoler(), (float) FoldableContainer.this.getTitleBar().getHeight());
            }
        });
    }

    public View getTitleBar() {
        return getChildAt(0);
    }

    public View getPlaceHoler() {
        return getChildAt(1);
    }

    public void unfold() {
        final View titleBar = getTitleBar();
        final View placeHoler = getPlaceHoler();
        if (ViewHelper.m3388a(titleBar) != 0.0f) {
            ValueAnimator b = ValueAnimator.m3295b(0.0f, 1.0f);
            b.mo16184a((C1548at) new C1548at() {
                public void onAnimationUpdate(ValueAnimator amVar) {
                    ViewHelper.m3394f(titleBar, ((float) (-titleBar.getHeight())) + (((float) titleBar.getHeight()) * amVar.f3476d));
                    ViewHelper.m3394f(placeHoler, ((float) titleBar.getHeight()) * amVar.f3476d);
                }
            });
            b.mo16188b(200);
            b.mo16161a();
        }
    }

    public void fold() {
        final View titleBar = getTitleBar();
        final View placeHoler = getPlaceHoler();
        if (ViewHelper.m3388a(titleBar) != ((float) (-titleBar.getHeight()))) {
            ValueAnimator b = ValueAnimator.m3295b(0.0f, 1.0f);
            b.mo16184a((C1548at) new C1548at() {
                public void onAnimationUpdate(ValueAnimator amVar) {
                    float f = ((float) (-titleBar.getHeight())) * amVar.f3476d;
                    ViewHelper.m3394f(titleBar, f);
                    ViewHelper.m3394f(placeHoler, f + ((float) titleBar.getHeight()));
                }
            });
            b.mo16188b(200);
            b.mo16161a();
        }
    }
}
