package org.mozilla.javascript;

import java.io.Serializable;
import org.mozilla.javascript.p111c.DebugFrame;

/* renamed from: org.mozilla.javascript.ao */
/* compiled from: Interpreter */
final class C2136ao implements Serializable, Cloneable {

    /* renamed from: a */
    C2136ao f6018a;

    /* renamed from: b */
    int f6019b;

    /* renamed from: c */
    boolean f6020c;

    /* renamed from: d */
    InterpretedFunction f6021d;

    /* renamed from: e */
    InterpreterData f6022e;

    /* renamed from: f */
    Object[] f6023f;

    /* renamed from: g */
    int[] f6024g;

    /* renamed from: h */
    double[] f6025h;

    /* renamed from: i */
    C2136ao f6026i;

    /* renamed from: j */
    int f6027j;

    /* renamed from: k */
    int f6028k;

    /* renamed from: l */
    DebugFrame f6029l;

    /* renamed from: m */
    boolean f6030m;

    /* renamed from: n */
    boolean f6031n;

    /* renamed from: o */
    Scriptable f6032o;

    /* renamed from: p */
    Object f6033p;

    /* renamed from: q */
    double f6034q;

    /* renamed from: r */
    int f6035r;

    /* renamed from: s */
    int f6036s;

    /* renamed from: t */
    int f6037t;

    /* renamed from: u */
    Scriptable f6038u;

    /* renamed from: v */
    int f6039v;

    /* renamed from: w */
    int f6040w;

    /* renamed from: x */
    Object f6041x;

    private C2136ao() {
    }

    /* synthetic */ C2136ao(byte b) {
        this();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C2136ao mo18692a() {
        if (!this.f6020c) {
            Kit.m5810a();
        }
        try {
            C2136ao aoVar = (C2136ao) clone();
            aoVar.f6023f = (Object[]) this.f6023f.clone();
            aoVar.f6024g = (int[]) this.f6024g.clone();
            aoVar.f6025h = (double[]) this.f6025h.clone();
            aoVar.f6020c = false;
            return aoVar;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException();
        }
    }
}
