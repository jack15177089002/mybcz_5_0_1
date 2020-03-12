package org.mozilla.javascript;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: org.mozilla.javascript.cc */
/* compiled from: NativeObject */
final class C2154cc extends AbstractSet<Entry<Object, Object>> {

    /* renamed from: a */
    final /* synthetic */ NativeObject f6363a;

    C2154cc(NativeObject cbVar) {
        this.f6363a = cbVar;
    }

    public final Iterator<Entry<Object, Object>> iterator() {
        return new C2155cd(this);
    }

    public final int size() {
        return this.f6363a.size();
    }
}
