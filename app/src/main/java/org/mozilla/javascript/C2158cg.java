package org.mozilla.javascript;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: org.mozilla.javascript.cg */
/* compiled from: NativeObject */
final class C2158cg implements Iterator<Object> {

    /* renamed from: a */
    Object[] f6372a = this.f6375d.f6371a.getIds();

    /* renamed from: b */
    Object f6373b;

    /* renamed from: c */
    int f6374c = 0;

    /* renamed from: d */
    final /* synthetic */ C2157cf f6375d;

    C2158cg(C2157cf cfVar) {
        this.f6375d = cfVar;
    }

    public final boolean hasNext() {
        return this.f6374c < this.f6372a.length;
    }

    public final Object next() {
        try {
            Object[] objArr = this.f6372a;
            int i = this.f6374c;
            this.f6374c = i + 1;
            Object obj = objArr[i];
            this.f6373b = obj;
            return obj;
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f6373b = null;
            throw new NoSuchElementException();
        }
    }

    public final void remove() {
        if (this.f6373b == null) {
            throw new IllegalStateException();
        }
        this.f6375d.f6371a.remove(this.f6373b);
        this.f6373b = null;
    }
}
