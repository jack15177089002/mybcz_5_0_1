package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.cs */
/* compiled from: ObjToIntMap */
public final class C2163cs {

    /* renamed from: a */
    ObjToIntMap f6421a;

    /* renamed from: b */
    int f6422b;

    /* renamed from: c */
    int f6423c;

    /* renamed from: d */
    Object[] f6424d;

    /* renamed from: e */
    int[] f6425e;

    C2163cs(ObjToIntMap crVar) {
        this.f6421a = crVar;
    }

    /* renamed from: a */
    public final void mo18970a() {
        ObjToIntMap crVar = this.f6421a;
        Object[] objArr = crVar.f6416b;
        int[] iArr = crVar.f6417c;
        int i = crVar.f6418d;
        this.f6424d = objArr;
        this.f6425e = iArr;
        this.f6422b = -1;
        this.f6423c = i;
        mo18972c();
    }

    /* renamed from: b */
    public final boolean mo18971b() {
        return this.f6423c < 0;
    }

    /* renamed from: c */
    public final void mo18972c() {
        if (this.f6423c == -1) {
            Kit.m5810a();
        }
        if (this.f6423c == 0) {
            this.f6423c = -1;
            this.f6422b = -1;
            return;
        }
        this.f6422b++;
        while (true) {
            Object obj = this.f6424d[this.f6422b];
            if (obj == null || obj == ObjToIntMap.f6415a) {
                this.f6422b++;
            } else {
                this.f6423c--;
                return;
            }
        }
    }

    /* renamed from: d */
    public final Object mo18973d() {
        Object obj = this.f6424d[this.f6422b];
        if (obj == UniqueTag.f6691b) {
            return null;
        }
        return obj;
    }

    /* renamed from: e */
    public final int mo18974e() {
        return this.f6425e[this.f6422b];
    }
}
