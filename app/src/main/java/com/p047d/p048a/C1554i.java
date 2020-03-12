package com.p047d.p048a;

/* renamed from: com.d.a.i */
/* compiled from: AnimatorSet */
final class C1554i implements C1549b {

    /* renamed from: a */
    private AnimatorSet f3510a;

    /* renamed from: b */
    private C1555j f3511b;

    /* renamed from: c */
    private int f3512c;

    public C1554i(AnimatorSet dVar, C1555j jVar, int i) {
        this.f3510a = dVar;
        this.f3511b = jVar;
        this.f3512c = i;
    }

    public final void onAnimationCancel(Animator aVar) {
    }

    public final void onAnimationEnd(Animator aVar) {
        if (this.f3512c == 1) {
            m3336a(aVar);
        }
    }

    public final void onAnimationRepeat(Animator aVar) {
    }

    public final void onAnimationStart(Animator aVar) {
        if (this.f3512c == 0) {
            m3336a(aVar);
        }
    }

    /* renamed from: a */
    private void m3336a(Animator aVar) {
        C1553h hVar;
        if (!this.f3510a.f3490b) {
            int size = this.f3511b.f3515c.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    hVar = (C1553h) this.f3511b.f3515c.get(i);
                    if (hVar.f3509b == this.f3512c && hVar.f3508a.f3513a == aVar) {
                        aVar.mo16165b(this);
                        break;
                    }
                    i++;
                } else {
                    hVar = null;
                    break;
                }
            }
            this.f3511b.f3515c.remove(hVar);
            if (this.f3511b.f3515c.size() == 0) {
                this.f3511b.f3513a.mo16161a();
                this.f3510a.f3491c.add(this.f3511b.f3513a);
            }
        }
    }
}
