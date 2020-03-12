package com.p047d.p048a;

import java.util.ArrayList;

/* renamed from: com.d.a.e */
/* compiled from: AnimatorSet */
final class C1550e extends AnimatorListenerAdapter {

    /* renamed from: a */
    boolean f3501a = false;

    /* renamed from: b */
    final /* synthetic */ AnimatorSet f3502b;

    /* renamed from: c */
    private final /* synthetic */ ArrayList f3503c;

    C1550e(AnimatorSet dVar, ArrayList arrayList) {
        this.f3502b = dVar;
        this.f3503c = arrayList;
    }

    public final void onAnimationCancel(Animator aVar) {
        this.f3501a = true;
    }

    public final void onAnimationEnd(Animator aVar) {
        if (!this.f3501a) {
            int size = this.f3503c.size();
            for (int i = 0; i < size; i++) {
                C1555j jVar = (C1555j) this.f3503c.get(i);
                jVar.f3513a.mo16161a();
                this.f3502b.f3491c.add(jVar.f3513a);
            }
        }
    }
}
