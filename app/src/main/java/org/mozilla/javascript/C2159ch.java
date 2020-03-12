package org.mozilla.javascript;

import java.util.AbstractCollection;
import java.util.Iterator;

/* renamed from: org.mozilla.javascript.ch */
/* compiled from: NativeObject */
final class C2159ch extends AbstractCollection<Object> {

    /* renamed from: a */
    final /* synthetic */ NativeObject f6376a;

    C2159ch(NativeObject cbVar) {
        this.f6376a = cbVar;
    }

    public final Iterator<Object> iterator() {
        return new C2160ci(this);
    }

    public final int size() {
        return this.f6376a.size();
    }
}
