package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.dv */
/* compiled from: ScriptableObject */
class C2181dv implements Serializable {

    /* renamed from: c */
    String f6537c;

    /* renamed from: d */
    int f6538d;

    /* renamed from: e */
    volatile short f6539e;

    /* renamed from: f */
    volatile transient boolean f6540f;

    /* renamed from: g */
    volatile Object f6541g;

    /* renamed from: h */
    transient C2181dv f6542h;

    /* renamed from: i */
    volatile transient C2181dv f6543i;

    C2181dv(String str, int i, int i2) {
        this.f6537c = str;
        this.f6538d = i;
        this.f6539e = (short) i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19060a(Object obj, Scriptable drVar, Scriptable drVar2) {
        if ((this.f6539e & 1) != 0) {
            return true;
        }
        if (drVar != drVar2) {
            return false;
        }
        this.f6541g = obj;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo19057a(Scriptable drVar) {
        return this.f6541g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo19062b() {
        return this.f6539e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo19061a(int i) {
        ScriptableObject.checkValidAttributes(i);
        this.f6539e = (short) i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19059a() {
        this.f6540f = true;
        this.f6541g = null;
        this.f6537c = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ScriptableObject mo19058a(Context lVar, Scriptable drVar) {
        return ScriptableObject.buildDataDescriptor(drVar, this.f6541g, this.f6539e);
    }
}
