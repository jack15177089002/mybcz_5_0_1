package org.mozilla.javascript.p113e;

import org.mozilla.javascript.C2163cs;
import org.mozilla.javascript.ObjToIntMap;

/* renamed from: org.mozilla.javascript.e.b */
/* compiled from: Block */
final class C2185b {

    /* renamed from: a */
    ObjToIntMap f6559a;

    /* renamed from: b */
    ObjToIntMap f6560b;

    /* renamed from: c */
    C2184a f6561c;

    private C2185b() {
        this.f6559a = new ObjToIntMap();
        this.f6560b = new ObjToIntMap();
    }

    /* synthetic */ C2185b(byte b) {
        this();
    }

    /* renamed from: a */
    static C2184a[] m6514a(ObjToIntMap crVar) {
        boolean z;
        if (crVar.f6418d == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        C2184a[] aVarArr = new C2184a[crVar.f6418d];
        C2163cs a = crVar.mo18965a();
        a.mo18970a();
        int i = 0;
        while (!a.mo18971b()) {
            int i2 = i + 1;
            aVarArr[i] = ((C2185b) a.mo18973d()).f6561c;
            a.mo18972c();
            i = i2;
        }
        return aVarArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19064a(C2185b bVar) {
        this.f6559a.mo18968b(bVar, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo19065b(C2185b bVar) {
        this.f6560b.mo18968b(bVar, 0);
    }
}
