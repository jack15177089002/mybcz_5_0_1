package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/* renamed from: com.f.a.ba */
final class ResourceRequestHandler extends RequestHandler {

    /* renamed from: a */
    private final Context f3722a;

    ResourceRequestHandler(Context context) {
        this.f3722a = context;
    }

    public final boolean canHandleRequest(Request auVar) {
        if (auVar.f3677e != 0) {
            return true;
        }
        return "android.resource".equals(auVar.f3676d.getScheme());
    }

    public final C1580az load(Request auVar) {
//        Resources a = C1584bj.m3548a(this.f3722a, auVar);
//        int a2 = C1584bj.m3545a(a, auVar);
//        Options createBitmapOptions = createBitmapOptions(auVar);
//        if (requiresInSampleSize(createBitmapOptions)) {
//            BitmapFactory.decodeResource(a, a2, createBitmapOptions);
//            calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
//        }
//        return new C1580az(BitmapFactory.decodeResource(a, a2, createBitmapOptions), C1573an.DISK);
        return null;
    }
}
