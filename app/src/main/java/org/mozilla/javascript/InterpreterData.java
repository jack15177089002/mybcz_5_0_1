package org.mozilla.javascript;

import java.io.Serializable;
import org.mozilla.javascript.p111c.DebuggableScript;

/* renamed from: org.mozilla.javascript.ar */
final class InterpreterData implements Serializable, DebuggableScript {

    /* renamed from: A */
    int f6049A = -1;

    /* renamed from: B */
    InterpreterData f6050B;

    /* renamed from: C */
    boolean f6051C;

    /* renamed from: a */
    String f6052a;

    /* renamed from: b */
    String f6053b;

    /* renamed from: c */
    boolean f6054c;

    /* renamed from: d */
    int f6055d;

    /* renamed from: e */
    String[] f6056e;

    /* renamed from: f */
    double[] f6057f;

    /* renamed from: g */
    InterpreterData[] f6058g;

    /* renamed from: h */
    Object[] f6059h;

    /* renamed from: i */
    byte[] f6060i;

    /* renamed from: j */
    int[] f6061j;

    /* renamed from: k */
    int f6062k;

    /* renamed from: l */
    int f6063l;

    /* renamed from: m */
    int f6064m;

    /* renamed from: n */
    int f6065n;

    /* renamed from: o */
    String[] f6066o;

    /* renamed from: p */
    boolean[] f6067p;

    /* renamed from: q */
    int f6068q;

    /* renamed from: r */
    int f6069r;

    /* renamed from: s */
    String f6070s;

    /* renamed from: t */
    int f6071t;

    /* renamed from: u */
    int f6072u;

    /* renamed from: v */
    int f6073v;

    /* renamed from: w */
    boolean f6074w;

    /* renamed from: x */
    boolean f6075x;

    /* renamed from: y */
    Object[] f6076y;

    /* renamed from: z */
    UintMap f6077z;

    InterpreterData(int i, String str, String str2, boolean z) {
        this.f6073v = i;
        this.f6053b = str;
        this.f6070s = str2;
        this.f6074w = z;
        m5771a();
    }

    InterpreterData(InterpreterData arVar) {
        this.f6050B = arVar;
        this.f6073v = arVar.f6073v;
        this.f6053b = arVar.f6053b;
        this.f6070s = arVar.f6070s;
        m5771a();
    }

    /* renamed from: a */
    private void m5771a() {
        this.f6060i = new byte[1024];
        this.f6056e = new String[64];
    }
}
