package com.p047d.p049b;

/* renamed from: com.d.b.a */
public abstract class FloatProperty<T> extends Property<T, Float> {
    /* renamed from: a */
    public abstract void mo16170a(T t, float f);

    /* renamed from: a */
    public final /* synthetic */ void mo16217a(Object obj, Object obj2) {
        mo16170a((T) obj, ((Float) obj2).floatValue());
    }

    public FloatProperty(String str) {
        super(Float.class, str);
    }
}
