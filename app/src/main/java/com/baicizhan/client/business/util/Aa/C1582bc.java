package com.baicizhan.client.business.util.Aa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.f.a.bc */
/* compiled from: Stats */
final class C1582bc extends Handler {

    /* renamed from: a */
    private final Stats f3737a;

    public C1582bc(Looper looper, Stats bbVar) {
        super(looper);
        this.f3737a = bbVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f3737a.f3726d++;
                return;
            case 1:
                this.f3737a.f3727e++;
                return;
            case 2:
                Stats bbVar = this.f3737a;
                long j = (long) message.arg1;
                bbVar.f3735m++;
                bbVar.f3729g = j + bbVar.f3729g;
                bbVar.f3732j = bbVar.f3729g / ((long) bbVar.f3735m);
                return;
            case 3:
                Stats bbVar2 = this.f3737a;
                long j2 = (long) message.arg1;
                bbVar2.f3736n++;
                bbVar2.f3730h = j2 + bbVar2.f3730h;
                bbVar2.f3733k = bbVar2.f3730h / ((long) bbVar2.f3735m);
                return;
            case 4:
                Stats bbVar3 = this.f3737a;
                Long l = (Long) message.obj;
                bbVar3.f3734l++;
                bbVar3.f3728f += l.longValue();
                bbVar3.f3731i = bbVar3.f3728f / ((long) bbVar3.f3734l);
                return;
            default:
                Picasso.f3624a.post(new C1583bd(this, message));
                return;
        }
    }
}
