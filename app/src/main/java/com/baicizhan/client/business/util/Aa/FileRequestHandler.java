package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import p012ch.qos.logback.core.joran.action.Action;

/* renamed from: com.f.a.z */
final class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    public final boolean canHandleRequest(Request auVar) {
        return Action.FILE_ATTRIBUTE.equals(auVar.f3676d.getScheme());
    }

    public final C1580az load(Request auVar) {
        int i = 0;
        Bitmap a = mo16353a(auVar);
        C1573an anVar = C1573an.DISK;
//        switch (new ExifInterface(auVar.f3676d.getPath()).getAttributeInt("Orientation", 1)) {
//            case 3:
//                i = 180;
//                break;
//            case 6:
//                i = 90;
//                break;
//            case 8:
//                i = 270;
//                break;
//            default:
//                i = 0;
//                break;
//        }
        return new C1580az(a, anVar, i);
    }
}
