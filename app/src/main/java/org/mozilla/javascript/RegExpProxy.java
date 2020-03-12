package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.df */
public interface RegExpProxy {
    Object action(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr, int i);

    Object compileRegExp(Context lVar, String str, String str2);

    int find_split(Context lVar, Scriptable drVar, String str, String str2, Scriptable drVar2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr);

    boolean isRegExp(Scriptable drVar);

    Object js_split(Context lVar, Scriptable drVar, String str, Object[] objArr);

    Scriptable wrapRegExp(Context lVar, Scriptable drVar, Object obj);
}
