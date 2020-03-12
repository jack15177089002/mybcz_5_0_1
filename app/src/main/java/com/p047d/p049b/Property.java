package com.p047d.p049b;

/* renamed from: com.d.b.c */
public abstract class Property<T, V> {

    /* renamed from: a */
    public final String f3557a;

    /* renamed from: b */
    private final Class<V> f3558b;

    /* renamed from: a */
    public abstract V mo16169a(T t);

    public Property(Class<V> cls, String str) {
        this.f3557a = str;
        this.f3558b = cls;
    }

    /* renamed from: a */
    public void mo16217a(T t, V v) {
        throw new UnsupportedOperationException("Property " + this.f3557a + " is read-only");
    }
}
