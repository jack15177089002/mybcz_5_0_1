package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.ek */
public final class UniqueTag implements Serializable {

    /* renamed from: a */
    public static final UniqueTag f6690a = new UniqueTag(1);

    /* renamed from: b */
    public static final UniqueTag f6691b = new UniqueTag(2);

    /* renamed from: c */
    public static final UniqueTag f6692c = new UniqueTag(3);

    /* renamed from: d */
    private final int f6693d;

    private UniqueTag(int i) {
        this.f6693d = i;
    }

    public final String toString() {
        String str;
        switch (this.f6693d) {
            case 1:
                str = "NOT_FOUND";
                break;
            case 2:
                str = "NULL_VALUE";
                break;
            case 3:
                str = "DOUBLE_MARK";
                break;
            default:
                throw Kit.m5810a();
        }
        return super.toString() + ": " + str;
    }
}
