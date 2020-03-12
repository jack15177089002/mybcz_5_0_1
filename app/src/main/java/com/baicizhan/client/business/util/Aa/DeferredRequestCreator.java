package com.baicizhan.client.business.util.Aa;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.f.a.p */
final class DeferredRequestCreator implements OnPreDrawListener {

    /* renamed from: a */
    final RequestCreator f3791a;

    /* renamed from: b */
    final WeakReference<ImageView> f3792b;

    /* renamed from: c */
    Callback f3793c;

    DeferredRequestCreator(RequestCreator awVar, ImageView imageView, Callback mVar) {
        this.f3791a = awVar;
        this.f3792b = new WeakReference<>(imageView);
        this.f3793c = mVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f3792b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    RequestCreator awVar = this.f3791a;
                    awVar.f3709e = false;
                    awVar.mo16331a(width, height).mo16333a(imageView, this.f3793c);
                }
            }
        }
        return true;
    }
}
