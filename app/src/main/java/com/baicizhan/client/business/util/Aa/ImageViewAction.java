package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: com.f.a.aa */
final class ImageViewAction extends Action<ImageView> {

    /* renamed from: l */
    Callback f3600l;

    ImageViewAction(Picasso ahVar, ImageView imageView, Request auVar, boolean z, boolean z2, int i, Drawable drawable, String str, Object obj, Callback mVar) {
        super(ahVar, imageView, auVar, z, z2, i, drawable, str, obj);
        this.f3600l = mVar;
    }

    /* renamed from: a */
    public final void mo16277a(Bitmap bitmap, C1573an anVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.f3591c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            C1573an anVar2 = anVar;
//            PicassoDrawable.m3520a(imageView, this.f3589a.f3628e, bitmap2, anVar2, this.f3593e, this.f3589a.f3635l);
//            if (this.f3600l != null) {
//                this.f3600l.onSuccess();
//            }
        }
    }

    /* renamed from: a */
    public final void mo16276a() {
        ImageView imageView = (ImageView) this.f3591c.get();
        if (imageView != null) {
            if (this.f3594f != 0) {
                imageView.setImageResource(this.f3594f);
            } else if (this.f3595g != null) {
                imageView.setImageDrawable(this.f3595g);
            }
            if (this.f3600l != null) {
                this.f3600l.onError();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo16278b() {
        super.mo16278b();
        if (this.f3600l != null) {
            this.f3600l = null;
        }
    }
}
