package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* renamed from: com.f.a.bg */
final class TargetAction extends Action<Target> {
    TargetAction(Picasso ahVar, Target bfVar, Request auVar, boolean z, int i, Drawable drawable, String str, Object obj) {
        super(ahVar, bfVar, auVar, z, false, i, drawable, str, obj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16277a(Bitmap bitmap, C1573an anVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        Target bfVar = (Target) mo16279c();
        if (bfVar != null) {
            bfVar.onBitmapLoaded(bitmap, anVar);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16276a() {
        Target bfVar = (Target) mo16279c();
        if (bfVar == null) {
            return;
        }
        if (this.f3594f != 0) {
            bfVar.onBitmapFailed(this.f3589a.f3628e.getResources().getDrawable(this.f3594f));
        } else {
            bfVar.onBitmapFailed(this.f3595g);
        }
    }
}
