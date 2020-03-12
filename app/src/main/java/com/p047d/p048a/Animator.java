package com.p047d.p048a;

import java.util.ArrayList;

/* renamed from: com.d.a.a */
public abstract class Animator implements Cloneable {

    /* renamed from: a */
    ArrayList<C1549b> f3437a = null;

    /* renamed from: a */
    public void mo16161a() {
    }

    /* renamed from: b */
    public void mo16164b() {
    }

    /* renamed from: c */
    public void mo16166c() {
    }

    /* renamed from: a */
    public final void mo16162a(C1549b bVar) {
        if (this.f3437a == null) {
            this.f3437a = new ArrayList<>();
        }
        this.f3437a.add(bVar);
    }

    /* renamed from: b */
    public final void mo16165b(C1549b bVar) {
        if (this.f3437a != null) {
            this.f3437a.remove(bVar);
            if (this.f3437a.size() == 0) {
                this.f3437a = null;
            }
        }
    }

    /* renamed from: d */
    public Animator clone() {
        try {
            Animator aVar = (Animator) super.clone();
            if (this.f3437a != null) {
                ArrayList<C1549b> arrayList = this.f3437a;
                aVar.f3437a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    aVar.f3437a.add((C1549b) arrayList.get(i));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo16163a(Object obj) {
    }
}
