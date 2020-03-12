package com.p047d.p049b;

/* renamed from: com.d.b.b */
public abstract class IntProperty<T> extends Property<T, Integer> {
    /* renamed from: a */
    public abstract void mo16216a(T t, int i);

    /* renamed from: a */
    public final /* synthetic */ void mo16217a(Object obj, Object obj2) {
        Integer num = (Integer) obj2;
        while (true) {
            num = Integer.valueOf(num.intValue());
        }
    }

    public IntProperty(String str) {
        super(Integer.class, str);
    }
}
