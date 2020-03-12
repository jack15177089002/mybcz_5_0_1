package com.p047d.p048a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.d.a.d */
public final class AnimatorSet extends Animator {

    /* renamed from: b */
    boolean f3490b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<Animator> f3491c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<Animator, C1555j> f3492d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<C1555j> f3493e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<C1555j> f3494f = new ArrayList<>();

    /* renamed from: g */
    private boolean f3495g = true;

    /* renamed from: h */
    private C1551f f3496h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3497i = false;

    /* renamed from: j */
    private long f3498j = 0;

    /* renamed from: k */
    private ValueAnimator f3499k = null;

    /* renamed from: l */
    private long f3500l = -1;

    /* renamed from: d */
    public final /* synthetic */ Animator mo16168d() {
        AnimatorSet dVar = (AnimatorSet) super.clone();
        dVar.f3495g = true;
        dVar.f3490b = false;
        dVar.f3497i = false;
        dVar.f3491c = new ArrayList<>();
        dVar.f3492d = new HashMap<>();
        dVar.f3493e = new ArrayList<>();
        dVar.f3494f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator it = this.f3493e.iterator();
        while (it.hasNext()) {
            C1555j jVar = (C1555j) it.next();
            C1555j a = jVar.clone();
            hashMap.put(jVar, a);
            dVar.f3493e.add(a);
            dVar.f3492d.put(a.f3513a, a);
            a.f3514b = null;
            a.f3515c = null;
            a.f3517e = null;
            a.f3516d = null;
            ArrayList<C1549b> arrayList = a.f3513a.f3437a;
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = null;
                while (it2.hasNext()) {
                    C1549b bVar = (C1549b) it2.next();
                    if (bVar instanceof C1551f) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(bVar);
                    }
                }
                if (arrayList2 != null) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        arrayList.remove((C1549b) it3.next());
                    }
                }
            }
        }
        Iterator it4 = this.f3493e.iterator();
        while (it4.hasNext()) {
            C1555j jVar2 = (C1555j) it4.next();
            C1555j jVar3 = (C1555j) hashMap.get(jVar2);
            if (jVar2.f3514b != null) {
                Iterator it5 = jVar2.f3514b.iterator();
                while (it5.hasNext()) {
                    C1553h hVar = (C1553h) it5.next();
                    jVar3.mo16203a(new C1553h((C1555j) hashMap.get(hVar.f3508a), hVar.f3509b));
                }
            }
        }
        return dVar;
    }

    /* renamed from: a */
    public final void mo16200a(Collection<Animator> collection) {
        if (collection.size() > 0) {
            this.f3495g = true;
            C1552g gVar = null;
            for (Animator aVar : collection) {
                if (gVar == null) {
                    gVar = m3322a(aVar);
                } else {
                    C1555j jVar = (C1555j) gVar.f3507b.f3492d.get(aVar);
                    if (jVar == null) {
                        jVar = new C1555j(aVar);
                        gVar.f3507b.f3492d.put(aVar, jVar);
                        gVar.f3507b.f3493e.add(jVar);
                    }
                    jVar.mo16203a(new C1553h(gVar.f3506a, 0));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo16201a(Animator... aVarArr) {
        int i = 0;
        this.f3495g = true;
        if (aVarArr.length == 1) {
            m3322a(aVarArr[0]);
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < aVarArr.length - 1) {
                C1552g a = m3322a(aVarArr[i2]);
                Animator aVar = aVarArr[i2 + 1];
                C1555j jVar = (C1555j) a.f3507b.f3492d.get(aVar);
                if (jVar == null) {
                    jVar = new C1555j(aVar);
                    a.f3507b.f3492d.put(aVar, jVar);
                    a.f3507b.f3493e.add(jVar);
                }
                jVar.mo16203a(new C1553h(a.f3506a, 1));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo16163a(Object obj) {
        Iterator it = this.f3493e.iterator();
        while (it.hasNext()) {
            Animator aVar = ((C1555j) it.next()).f3513a;
            if (aVar instanceof AnimatorSet) {
                ((AnimatorSet) aVar).mo16163a(obj);
            } else if (aVar instanceof ObjectAnimator) {
                ((ObjectAnimator) aVar).mo16163a(obj);
            }
        }
    }

    /* renamed from: a */
    private C1552g m3322a(Animator aVar) {
        if (aVar == null) {
            return null;
        }
        this.f3495g = true;
        return new C1552g(this, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo16164b() {
        /*
            r5 = this;
            r2 = 0
            r3 = 1
            r5.f3490b = r3
            boolean r0 = r5.f3497i
            if (r0 == 0) goto L_0x0044
            r0 = 0
            java.util.ArrayList r1 = r5.f3437a
            if (r1 == 0) goto L_0x007b
            java.util.ArrayList r0 = r5.f3437a
            java.lang.Object r0 = r0.clone()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r4 = r0.iterator()
        L_0x0019:
            boolean r1 = r4.hasNext()
            if (r1 != 0) goto L_0x0045
            r1 = r0
        L_0x0020:
            com.d.a.am r0 = r5.f3499k
            if (r0 == 0) goto L_0x0051
            com.d.a.am r0 = r5.f3499k
            int r4 = r0.f3477e
            if (r4 == r3) goto L_0x004f
            boolean r0 = r0.f3478f
            if (r0 != 0) goto L_0x004f
            r0 = r2
        L_0x002f:
            if (r0 == 0) goto L_0x0051
            com.d.a.am r0 = r5.f3499k
            r0.mo16164b()
        L_0x0036:
            if (r1 == 0) goto L_0x0042
            java.util.Iterator r1 = r1.iterator()
        L_0x003c:
            boolean r0 = r1.hasNext()
            if (r0 != 0) goto L_0x0071
        L_0x0042:
            r5.f3497i = r2
        L_0x0044:
            return
        L_0x0045:
            java.lang.Object r1 = r4.next()
            com.d.a.b r1 = (com.p047d.p048a.C1549b) r1
            r1.onAnimationCancel(r5)
            goto L_0x0019
        L_0x004f:
            r0 = r3
            goto L_0x002f
        L_0x0051:
            java.util.ArrayList<com.d.a.j> r0 = r5.f3494f
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0036
            java.util.ArrayList<com.d.a.j> r0 = r5.f3494f
            java.util.Iterator r3 = r0.iterator()
        L_0x005f:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r3.next()
            com.d.a.j r0 = (com.p047d.p048a.C1555j) r0
            com.d.a.a r0 = r0.f3513a
            r0.mo16164b()
            goto L_0x005f
        L_0x0071:
            java.lang.Object r0 = r1.next()
            com.d.a.b r0 = (com.p047d.p048a.C1549b) r0
            r0.onAnimationEnd(r5)
            goto L_0x003c
        L_0x007b:
            r1 = r0
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p047d.p048a.AnimatorSet.mo16164b():void");
    }

    /* renamed from: c */
    public final void mo16166c() {
        this.f3490b = true;
        if (this.f3497i) {
            if (this.f3494f.size() != this.f3493e.size()) {
                m3328e();
                Iterator it = this.f3494f.iterator();
                while (it.hasNext()) {
                    C1555j jVar = (C1555j) it.next();
                    if (this.f3496h == null) {
                        this.f3496h = new C1551f(this, this);
                    }
                    jVar.f3513a.mo16162a((C1549b) this.f3496h);
                }
            }
            if (this.f3499k != null) {
                this.f3499k.mo16164b();
            }
            if (this.f3494f.size() > 0) {
                Iterator it2 = this.f3494f.iterator();
                while (it2.hasNext()) {
                    ((C1555j) it2.next()).f3513a.mo16166c();
                }
            }
            if (this.f3437a != null) {
                Iterator it3 = ((ArrayList) this.f3437a.clone()).iterator();
                while (it3.hasNext()) {
                    ((C1549b) it3.next()).onAnimationEnd(this);
                }
            }
            this.f3497i = false;
        }
    }

    /* renamed from: a */
    public final void mo16161a() {
        this.f3490b = false;
        this.f3497i = true;
        m3328e();
        int size = this.f3494f.size();
        for (int i = 0; i < size; i++) {
            C1555j jVar = (C1555j) this.f3494f.get(i);
            ArrayList<C1549b> arrayList = jVar.f3513a.f3437a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = new ArrayList(arrayList).iterator();
                while (it.hasNext()) {
                    C1549b bVar = (C1549b) it.next();
                    if ((bVar instanceof C1554i) || (bVar instanceof C1551f)) {
                        jVar.f3513a.mo16165b(bVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C1555j jVar2 = (C1555j) this.f3494f.get(i2);
            if (this.f3496h == null) {
                this.f3496h = new C1551f(this, this);
            }
            if (jVar2.f3514b == null || jVar2.f3514b.size() == 0) {
                arrayList2.add(jVar2);
            } else {
                int size2 = jVar2.f3514b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1553h hVar = (C1553h) jVar2.f3514b.get(i3);
                    hVar.f3508a.f3513a.mo16162a((C1549b) new C1554i(this, jVar2, hVar.f3509b));
                }
                jVar2.f3515c = (ArrayList) jVar2.f3514b.clone();
            }
            jVar2.f3513a.mo16162a((C1549b) this.f3496h);
        }
        if (this.f3498j <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C1555j jVar3 = (C1555j) it2.next();
                jVar3.f3513a.mo16161a();
                this.f3491c.add(jVar3.f3513a);
            }
        } else {
            this.f3499k = ValueAnimator.m3295b(0.0f, 1.0f);
            this.f3499k.mo16188b(this.f3498j);
            this.f3499k.mo16162a((C1549b) new C1550e(this, arrayList2));
            this.f3499k.mo16161a();
        }
        if (this.f3437a != null) {
            ArrayList arrayList3 = (ArrayList) this.f3437a.clone();
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((C1549b) arrayList3.get(i4)).onAnimationStart(this);
            }
        }
        if (this.f3493e.size() == 0 && this.f3498j == 0) {
            this.f3497i = false;
            if (this.f3437a != null) {
                ArrayList arrayList4 = (ArrayList) this.f3437a.clone();
                int size4 = arrayList4.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    ((C1549b) arrayList4.get(i5)).onAnimationEnd(this);
                }
            }
        }
    }

    /* renamed from: e */
    private void m3328e() {
        if (this.f3495g) {
            this.f3494f.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f3493e.size();
            for (int i = 0; i < size; i++) {
                C1555j jVar = (C1555j) this.f3493e.get(i);
                if (jVar.f3514b == null || jVar.f3514b.size() == 0) {
                    arrayList.add(jVar);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C1555j jVar2 = (C1555j) arrayList.get(i2);
                    this.f3494f.add(jVar2);
                    if (jVar2.f3517e != null) {
                        int size3 = jVar2.f3517e.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            C1555j jVar3 = (C1555j) jVar2.f3517e.get(i3);
                            jVar3.f3516d.remove(jVar2);
                            if (jVar3.f3516d.size() == 0) {
                                arrayList2.add(jVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f3495g = false;
            if (this.f3494f.size() != this.f3493e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f3493e.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C1555j jVar4 = (C1555j) this.f3493e.get(i4);
            if (jVar4.f3514b != null && jVar4.f3514b.size() > 0) {
                int size5 = jVar4.f3514b.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    C1553h hVar = (C1553h) jVar4.f3514b.get(i5);
                    if (jVar4.f3516d == null) {
                        jVar4.f3516d = new ArrayList<>();
                    }
                    if (!jVar4.f3516d.contains(hVar.f3508a)) {
                        jVar4.f3516d.add(hVar.f3508a);
                    }
                }
            }
            jVar4.f3518f = false;
        }
    }
}
