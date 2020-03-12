package com.p047d.p048a;

/* renamed from: com.d.a.k */
public final class FloatEvaluator implements TypeEvaluator<Number> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16182a(float f, Object obj, Object obj2) {
        Number number = (Number) obj2;
        float floatValue = ((Number) obj).floatValue();
        return Float.valueOf(floatValue + ((number.floatValue() - floatValue) * f));
    }
}
