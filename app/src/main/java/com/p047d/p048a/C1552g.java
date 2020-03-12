package com.p047d.p048a;

/* renamed from: com.d.a.g */
/* compiled from: AnimatorSet */
public final class C1552g {

    /* renamed from: a */
    C1555j f3506a;

    /* renamed from: b */
    final /* synthetic */ AnimatorSet f3507b;

    C1552g(AnimatorSet dVar, Animator aVar) {
        this.f3507b = dVar;
        this.f3506a = (C1555j) dVar.f3492d.get(aVar);
        if (this.f3506a == null) {
            this.f3506a = new C1555j(aVar);
            dVar.f3492d.put(aVar, this.f3506a);
            dVar.f3493e.add(this.f3506a);
        }
    }
}
