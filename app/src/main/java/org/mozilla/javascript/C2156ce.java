package org.mozilla.javascript;

import java.util.Map.Entry;

/* renamed from: org.mozilla.javascript.ce */
/* compiled from: NativeObject */
final class C2156ce implements Entry<Object, Object> {

    /* renamed from: a */
    final /* synthetic */ Object f6368a;

    /* renamed from: b */
    final /* synthetic */ Object f6369b;

    /* renamed from: c */
    final /* synthetic */ C2155cd f6370c;

    C2156ce(C2155cd cdVar, Object obj, Object obj2) {
        this.f6370c = cdVar;
        this.f6368a = obj;
        this.f6369b = obj2;
    }

    public final Object getKey() {
        return this.f6368a;
    }

    public final Object getValue() {
        return this.f6369b;
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (this.f6368a == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f6368a.equals(entry.getKey())) {
            return false;
        }
        if (this.f6369b == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!this.f6369b.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f6368a == null ? 0 : this.f6368a.hashCode();
        if (this.f6369b != null) {
            i = this.f6369b.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        return this.f6368a + "=" + this.f6369b;
    }
}
