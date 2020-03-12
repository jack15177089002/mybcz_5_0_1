package org.mozilla.javascript.p113e;

import org.mozilla.javascript.ScriptRuntime;

/* renamed from: org.mozilla.javascript.e.i */
public final class OptRuntime extends ScriptRuntime {

    /* renamed from: A */
    public static final Double f6624A = new Double(1.0d);

    /* renamed from: B */
    public static final Double f6625B = new Double(-1.0d);

    /* renamed from: z */
    public static final Double f6626z = new Double(0.0d);

    /* renamed from: a */
    static String m6611a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        char[] cArr = new char[((length * 2) + 1)];
        cArr[0] = 1;
        for (int i = 0; i != length; i++) {
            int i2 = iArr[i];
            int i3 = (i * 2) + 1;
            cArr[i3] = (char) (i2 >>> 16);
            cArr[i3 + 1] = (char) i2;
        }
        return new String(cArr);
    }
}
