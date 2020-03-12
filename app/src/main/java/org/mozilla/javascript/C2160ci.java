package org.mozilla.javascript;

import java.util.Iterator;

/* renamed from: org.mozilla.javascript.ci */
/* compiled from: NativeObject */
final class C2160ci implements Iterator<Object> {

    /* renamed from: a */
    Object[] f6377a = this.f6380d.f6376a.getIds();

    /* renamed from: b */
    Object f6378b;

    /* renamed from: c */
    int f6379c = 0;

    /* renamed from: d */
    final /* synthetic */ C2159ch f6380d;

    C2160ci(C2159ch chVar) {
        this.f6380d = chVar;
    }

    public final boolean hasNext() {
        return this.f6379c < this.f6377a.length;
    }

    public final Object next() {
        NativeObject cbVar = this.f6380d.f6376a;
        Object[] objArr = this.f6377a;
        int i = this.f6379c;
        this.f6379c = i + 1;
        Object obj = objArr[i];
        this.f6378b = obj;
        return cbVar.get(obj);
    }

    public final void remove() {
        if (this.f6378b == null) {
            throw new IllegalStateException();
        }
        this.f6380d.f6376a.remove(this.f6378b);
        this.f6378b = null;
    }
}
