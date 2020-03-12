package org.mozilla.javascript;

import java.util.List;
import java.util.Stack;

/* renamed from: org.mozilla.javascript.bt */
/* compiled from: NativeJSON */
final class C2152bt {

    /* renamed from: a */
    Stack<Scriptable> f6330a = new Stack<>();

    /* renamed from: b */
    String f6331b;

    /* renamed from: c */
    String f6332c;

    /* renamed from: d */
    Callable f6333d;

    /* renamed from: e */
    List<Object> f6334e;

    /* renamed from: f */
    Object f6335f;

    /* renamed from: g */
    Context f6336g;

    /* renamed from: h */
    Scriptable f6337h;

    C2152bt(Context lVar, Scriptable drVar, String str, String str2, Callable eVar, List<Object> list, Object obj) {
        this.f6336g = lVar;
        this.f6337h = drVar;
        this.f6331b = str;
        this.f6332c = str2;
        this.f6333d = eVar;
        this.f6334e = list;
        this.f6335f = obj;
    }
}
