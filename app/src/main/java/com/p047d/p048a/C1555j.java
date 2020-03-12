package com.p047d.p048a;

import java.util.ArrayList;

/* renamed from: com.d.a.j */
/* compiled from: AnimatorSet */
final class C1555j implements Cloneable {

    /* renamed from: a */
    public Animator f3513a;

    /* renamed from: b */
    public ArrayList<C1553h> f3514b = null;

    /* renamed from: c */
    public ArrayList<C1553h> f3515c = null;

    /* renamed from: d */
    public ArrayList<C1555j> f3516d = null;

    /* renamed from: e */
    public ArrayList<C1555j> f3517e = null;

    /* renamed from: f */
    public boolean f3518f = false;

    public C1555j(Animator aVar) {
        this.f3513a = aVar;
    }

    /* renamed from: a */
    public final void mo16203a(C1553h hVar) {
        if (this.f3514b == null) {
            this.f3514b = new ArrayList<>();
            this.f3516d = new ArrayList<>();
        }
        this.f3514b.add(hVar);
        if (!this.f3516d.contains(hVar.f3508a)) {
            this.f3516d.add(hVar.f3508a);
        }
        C1555j jVar = hVar.f3508a;
        if (jVar.f3517e == null) {
            jVar.f3517e = new ArrayList<>();
        }
        jVar.f3517e.add(this);
    }

    /* renamed from: a */
    public final C1555j clone() {
        try {
            C1555j jVar = (C1555j) super.clone();
            jVar.f3513a = this.f3513a.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
