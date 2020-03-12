package com.baicizhan.client.business.util.Aa;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.f.a.r */
/* compiled from: Dispatcher */
final class C1594r extends Handler {

    /* renamed from: a */
    private final Dispatcher f3810a;

    public C1594r(Looper looper, Dispatcher qVar) {
        super(looper);
        this.f3810a = qVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f3810a.mo16356a((Action) message.obj, true);
                return;
            case 2:
                Action aVar = (Action) message.obj;
                Dispatcher qVar = this.f3810a;
                String str = aVar.f3596h;
                BitmapHunter dVar = (BitmapHunter) qVar.f3798e.get(str);
                if (dVar != null) {
                    dVar.mo16344a(aVar);
                    if (dVar.mo16345a()) {
                        qVar.f3798e.remove(str);
//                        if (aVar.f3589a.f3636m) {
//                            C1584bj.m3557a("Dispatcher", "canceled", aVar.f3590b.mo16321a());
//                        }
                    }
                }
                if (qVar.f3801h.contains(aVar.f3597i)) {
                    qVar.f3800g.remove(aVar.mo16279c());
//                    if (aVar.f3589a.f3636m) {
//                        C1584bj.m3558a("Dispatcher", "canceled", aVar.f3590b.mo16321a(), "because paused request got canceled");
//                    }
                }
                Action aVar2 = (Action) qVar.f3799f.remove(aVar.mo16279c());
//                if (aVar2 != null && aVar2.f3589a.f3636m) {
//                    C1584bj.m3558a("Dispatcher", "canceled", aVar2.f3590b.mo16321a(), "from replaying");
//                    return;
//                }
                return;
            case 4:
                BitmapHunter dVar2 = (BitmapHunter) message.obj;
                Dispatcher qVar2 = this.f3810a;
                if (!dVar2.f3771h) {
                    qVar2.f3804k.mo16283a(dVar2.f3769f, dVar2.f3775l);
                }
                qVar2.f3798e.remove(dVar2.f3769f);
                qVar2.mo16361c(dVar2);
//                if (dVar2.f3765b.f3636m) {
//                    C1584bj.m3558a("Dispatcher", "batched", C1584bj.m3553a(dVar2), "for completion");
//                    return;
//                }
                return;
            case 5:
                this.f3810a.mo16360b((BitmapHunter) message.obj);
                return;
            case 6:
                this.f3810a.mo16358a((BitmapHunter) message.obj, false);
                return;
            case 7:
                Dispatcher qVar3 = this.f3810a;
                ArrayList arrayList = new ArrayList(qVar3.f3806m);
                qVar3.f3806m.clear();
                qVar3.f3803j.sendMessage(qVar3.f3803j.obtainMessage(8, arrayList));
                Dispatcher.m3587a((List<BitmapHunter>) arrayList);
                return;
            case 9:
                this.f3810a.mo16355a((NetworkInfo) message.obj);
                return;
            case 10:
                this.f3810a.f3809p = message.arg1 == 1;
                return;
            case 11:
                Object obj = message.obj;
                Dispatcher qVar4 = this.f3810a;
                if (qVar4.f3801h.add(obj)) {
                    Iterator it = qVar4.f3798e.values().iterator();
                    while (it.hasNext()) {
                        BitmapHunter dVar3 = (BitmapHunter) it.next();
//                        boolean z = dVar3.f3765b.f3636m;
                        Action aVar3 = dVar3.f3773j;
                        List<Action> list = dVar3.f3774k;
                        boolean z2 = list != null && !list.isEmpty();
                        if (aVar3 != null || z2) {
                            if (aVar3 != null && aVar3.f3597i.equals(obj)) {
                                dVar3.mo16344a(aVar3);
                                qVar4.f3800g.put(aVar3.mo16279c(), aVar3);
//                                if (z) {
//                                    C1584bj.m3558a("Dispatcher", "paused", aVar3.f3590b.mo16321a(), "because tag '" + obj + "' was paused");
//                                }
                            }
                            if (z2) {
                                for (int size = list.size() - 1; size >= 0; size--) {
                                    Action aVar4 = (Action) list.get(size);
                                    if (aVar4.f3597i.equals(obj)) {
                                        dVar3.mo16344a(aVar4);
                                        qVar4.f3800g.put(aVar4.mo16279c(), aVar4);
//                                        if (z) {
//                                            C1584bj.m3558a("Dispatcher", "paused", aVar4.f3590b.mo16321a(), "because tag '" + obj + "' was paused");
//                                        }
                                    }
                                }
                            }
                            if (dVar3.mo16345a()) {
                                it.remove();
//                                if (z) {
//                                    C1584bj.m3558a("Dispatcher", "canceled", C1584bj.m3553a(dVar3), "all actions paused");
//                                }
                            }
                        }
                    }
                    return;
                }
                return;
            case 12:
                this.f3810a.mo16359a(message.obj);
                return;
            default:
                Picasso.f3624a.post(new C1595s(this, message));
                return;
        }
    }
}
