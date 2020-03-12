package com.p047d.p048a;

/* renamed from: com.d.a.m */
public final class IntEvaluator implements TypeEvaluator<Integer> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16182a(float f, Object obj, Object obj2) {
        Integer num = (Integer) obj2;
        int intValue = ((Integer) obj).intValue();
        return Integer.valueOf((int) ((((float) (num.intValue() - intValue)) * f) + ((float) intValue)));
    }
}
