package com.p047d.p048a;

import java.util.ArrayList;

/* renamed from: com.d.a.f */
/* compiled from: AnimatorSet */
final class C1551f implements C1549b {

    /* renamed from: a */
    final /* synthetic */ AnimatorSet f3504a;

    /* renamed from: b */
    private AnimatorSet f3505b;

    C1551f(AnimatorSet dVar, AnimatorSet dVar2) {
        this.f3504a = dVar;
        this.f3505b = dVar2;
    }

    public final void onAnimationCancel(Animator aVar) {
        if (!this.f3504a.f3490b && this.f3504a.f3491c.size() == 0 && this.f3504a.f3437a != null) {
            int size = this.f3504a.f3437a.size();
            for (int i = 0; i < size; i++) {
                ((C1549b) this.f3504a.f3437a.get(i)).onAnimationCancel(this.f3505b);
            }
        }
    }

    public final void onAnimationEnd(Animator aVar) {
        boolean z;
        aVar.mo16165b(this);
        this.f3504a.f3491c.remove(aVar);
        ((C1555j) this.f3505b.f3492d.get(aVar)).f3518f = true;
        if (!this.f3504a.f3490b) {
            ArrayList c = this.f3505b.f3494f;
            int size = c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                } else if (!((C1555j) c.get(i)).f3518f) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                if (this.f3504a.f3437a != null) {
                    ArrayList arrayList = (ArrayList) this.f3504a.f3437a.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C1549b) arrayList.get(i2)).onAnimationEnd(this.f3505b);
                    }
                }
                this.f3505b.f3497i = false;
            }
        }
    }

    public final void onAnimationRepeat(Animator aVar) {
    }

    public final void onAnimationStart(Animator aVar) {
    }
}
