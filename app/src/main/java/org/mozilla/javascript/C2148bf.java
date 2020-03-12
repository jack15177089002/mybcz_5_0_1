package org.mozilla.javascript;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: org.mozilla.javascript.bf */
/* compiled from: NativeArray */
final class C2148bf implements ListIterator {

    /* renamed from: a */
    int f6294a = this.f6295b;

    /* renamed from: b */
    final /* synthetic */ int f6295b;

    /* renamed from: c */
    final /* synthetic */ int f6296c;

    /* renamed from: d */
    final /* synthetic */ NativeArray f6297d;

    C2148bf(NativeArray bcVar, int i, int i2) {
        this.f6297d = bcVar;
        this.f6295b = i;
        this.f6296c = i2;
    }

    public final boolean hasNext() {
        return this.f6294a < this.f6296c;
    }

    public final Object next() {
        if (this.f6294a == this.f6296c) {
            throw new NoSuchElementException();
        }
        NativeArray bcVar = this.f6297d;
        int i = this.f6294a;
        this.f6294a = i + 1;
        return bcVar.get(i);
    }

    public final boolean hasPrevious() {
        return this.f6294a > 0;
    }

    public final Object previous() {
        if (this.f6294a == 0) {
            throw new NoSuchElementException();
        }
        NativeArray bcVar = this.f6297d;
        int i = this.f6294a - 1;
        this.f6294a = i;
        return bcVar.get(i);
    }

    public final int nextIndex() {
        return this.f6294a;
    }

    public final int previousIndex() {
        return this.f6294a - 1;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
