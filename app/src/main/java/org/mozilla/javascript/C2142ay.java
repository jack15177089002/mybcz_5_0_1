package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.ay */
/* compiled from: Kit */
final class C2142ay {

    /* renamed from: a */
    private Object f6092a;

    /* renamed from: b */
    private Object f6093b;

    /* renamed from: c */
    private int f6094c;

    C2142ay(Object obj, Object obj2) {
        this.f6092a = obj;
        this.f6093b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2142ay)) {
            return false;
        }
        C2142ay ayVar = (C2142ay) obj;
        if (!this.f6092a.equals(ayVar.f6092a) || !this.f6093b.equals(ayVar.f6093b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f6094c == 0) {
            this.f6094c = this.f6092a.hashCode() ^ this.f6093b.hashCode();
        }
        return this.f6094c;
    }
}
