package org.mozilla.javascript;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: org.mozilla.javascript.cn */
/* compiled from: Node */
public final class C2161cn implements Iterator<Node> {

    /* renamed from: a */
    final /* synthetic */ Node f6395a;

    /* renamed from: b */
    private Node f6396b;

    /* renamed from: c */
    private Node f6397c = Node.f6388g;

    /* renamed from: d */
    private Node f6398d;

    /* renamed from: e */
    private boolean f6399e = false;

    public final /* synthetic */ Object next() {
        if (this.f6396b == null) {
            throw new NoSuchElementException();
        }
        this.f6399e = false;
        this.f6398d = this.f6397c;
        this.f6397c = this.f6396b;
        this.f6396b = this.f6396b.f6390b;
        return this.f6397c;
    }

    public C2161cn(Node cmVar) {
        this.f6395a = cmVar;
        this.f6396b = cmVar.f6391c;
    }

    public final boolean hasNext() {
        return this.f6396b != null;
    }

    public final void remove() {
        if (this.f6397c == Node.f6388g) {
            throw new IllegalStateException("next() has not been called");
        } else if (this.f6399e) {
            throw new IllegalStateException("remove() already called for current element");
        } else if (this.f6397c == this.f6395a.f6391c) {
            this.f6395a.f6391c = this.f6397c.f6390b;
        } else if (this.f6397c == this.f6395a.f6392d) {
            this.f6398d.f6390b = null;
            this.f6395a.f6392d = this.f6398d;
        } else {
            this.f6398d.f6390b = this.f6396b;
        }
    }
}
