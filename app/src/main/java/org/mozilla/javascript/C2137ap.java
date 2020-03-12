package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.ap */
/* compiled from: Interpreter */
final class C2137ap implements Serializable {

    /* renamed from: a */
    C2136ao f6042a;

    /* renamed from: b */
    C2136ao f6043b;

    /* renamed from: c */
    Object f6044c;

    /* renamed from: d */
    double f6045d;

    C2137ap(NativeContinuation biVar, C2136ao aoVar) {
        this.f6042a = (C2136ao) biVar.f6305a;
        if (this.f6042a == null || aoVar == null) {
            this.f6043b = null;
            return;
        }
        C2136ao aoVar2 = this.f6042a;
        int i = aoVar2.f6019b - aoVar.f6019b;
        if (i != 0) {
            if (i < 0) {
                i = -i;
                aoVar2 = aoVar;
                aoVar = this.f6042a;
            }
            do {
                aoVar2 = aoVar2.f6018a;
                i--;
            } while (i != 0);
            if (aoVar2.f6019b != aoVar.f6019b) {
                Kit.m5810a();
            }
        }
        while (aoVar2 != aoVar && aoVar2 != null) {
            aoVar2 = aoVar2.f6018a;
            aoVar = aoVar.f6018a;
        }
        this.f6043b = aoVar2;
        if (this.f6043b != null && !this.f6043b.f6020c) {
            Kit.m5810a();
        }
    }
}
