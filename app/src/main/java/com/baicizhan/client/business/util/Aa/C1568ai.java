package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* renamed from: com.f.a.ai */
/* compiled from: Picasso */
final class C1568ai extends Handler {
    C1568ai(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
//        switch (message.what) {
//            case 3:
//                Action aVar = (Action) message.obj;
//                if (aVar.f3589a.f3636m) {
//                    C1584bj.m3558a("Main", "canceled", aVar.f3590b.mo16321a(), "target got garbage collected");
//                }
//                aVar.f3589a.mo16306a(aVar.mo16279c());
//                return;
//            case 8:
//                List list = (List) message.obj;
//                int size = list.size();
//                for (int i = 0; i < size; i++) {
//                    BitmapHunter dVar = (BitmapHunter) list.get(i);
//                    Picasso ahVar = dVar.f3765b;
//                    Action aVar2 = dVar.f3773j;
//                    List<Action> list2 = dVar.f3774k;
//                    boolean z = list2 != null && !list2.isEmpty();
//                    if (aVar2 != null || z) {
//                        Uri uri = dVar.f3770g.f3676d;
//                        Exception exc = dVar.f3778o;
//                        Bitmap bitmap = dVar.f3775l;
//                        C1573an anVar = dVar.f3777n;
//                        if (aVar2 != null) {
//                            ahVar.mo16304a(bitmap, anVar, aVar2);
//                        }
//                        if (z) {
//                            int size2 = list2.size();
//                            for (int i2 = 0; i2 < size2; i2++) {
//                                ahVar.mo16304a(bitmap, anVar, (Action) list2.get(i2));
//                            }
//                        }
//                    }
//                }
//                return;
//            case 13:
//                List list3 = (List) message.obj;
//                int size3 = list3.size();
//                for (int i3 = 0; i3 < size3; i3++) {
//                    Action aVar3 = (Action) list3.get(i3);
//                    Picasso ahVar2 = aVar3.f3589a;
//                    Bitmap bitmap2 = null;
//                    if (!aVar3.f3592d) {
//                        bitmap2 = ahVar2.mo16307b(aVar3.f3596h);
//                    }
//                    if (bitmap2 != null) {
//                        ahVar2.mo16304a(bitmap2, C1573an.MEMORY, aVar3);
//                        if (ahVar2.f3636m) {
//                            C1584bj.m3558a("Main", "completed", aVar3.f3590b.mo16321a(), "from " + C1573an.MEMORY);
//                        }
//                    } else {
//                        ahVar2.mo16305a(aVar3);
//                        if (ahVar2.f3636m) {
//                            C1584bj.m3557a("Main", "resumed", aVar3.f3590b.mo16321a());
//                        }
//                    }
//                }
//                return;
//            default:
//                throw new AssertionError("Unknown handler message received: " + message.what);
//        }
    }
}
