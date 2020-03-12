package org.mozilla.javascript;

import java.util.AbstractSet;
import java.util.Iterator;

/* renamed from: org.mozilla.javascript.cf */
/* compiled from: NativeObject */
final class C2157cf extends AbstractSet<Object> {

    /* renamed from: a */
    final /* synthetic */ NativeObject f6371a;

    C2157cf(NativeObject cbVar) {
        this.f6371a = cbVar;
    }

    public final boolean contains(Object obj) {
        return this.f6371a.containsKey(obj);
    }

    public final Iterator<Object> iterator() {
        return new C2158cg(this);
    }

    public final int size() {
        return this.f6371a.size();
    }
}
