package org.mozilla.javascript;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: org.mozilla.javascript.cd */
/* compiled from: NativeObject */
final class C2155cd implements Iterator<Entry<Object, Object>> {

    /* renamed from: a */
    Object[] f6364a = this.f6367d.f6363a.getIds();

    /* renamed from: b */
    Object f6365b = null;

    /* renamed from: c */
    int f6366c = 0;

    /* renamed from: d */
    final /* synthetic */ C2154cc f6367d;

    C2155cd(C2154cc ccVar) {
        this.f6367d = ccVar;
    }

    public final /* synthetic */ Object next() {
        Object[] objArr = this.f6364a;
        int i = this.f6366c;
        this.f6366c = i + 1;
        Object obj = objArr[i];
        this.f6365b = obj;
        return new C2156ce(this, obj, this.f6367d.f6363a.get(this.f6365b));
    }

    public final boolean hasNext() {
        return this.f6366c < this.f6364a.length;
    }

    public final void remove() {
        if (this.f6365b == null) {
            throw new IllegalStateException();
        }
        this.f6367d.f6363a.remove(this.f6365b);
        this.f6365b = null;
    }
}
