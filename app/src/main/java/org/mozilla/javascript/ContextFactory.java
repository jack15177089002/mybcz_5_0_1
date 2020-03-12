package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.o */
public class ContextFactory {

    /* renamed from: c */
    private static ContextFactory f6806c = new ContextFactory();

    /* renamed from: a */
    volatile boolean f6807a;

    /* renamed from: b */
    ClassLoader f6808b;

    /* renamed from: d */
    private final Object f6809d = new Object();

    /* renamed from: e */
    private volatile Object f6810e;

    /* renamed from: a */
    public static ContextFactory m6787a() {
        return f6806c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Context mo19146b() {
        return new Context(this);
    }

    /* renamed from: a */
    protected static boolean m6788a(Context lVar, int i) {
        switch (i) {
            case 1:
                int i2 = lVar.f6785i;
                if (i2 == 100 || i2 == 110 || i2 == 120) {
                    return true;
                }
                return false;
            case 2:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return false;
            case 3:
                return true;
            case 4:
                if (lVar.f6785i == 120) {
                    return true;
                }
                return false;
            case 5:
                return true;
            case 6:
                int i3 = lVar.f6785i;
                return i3 == 0 || i3 >= 160;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* renamed from: c */
    static boolean m6789c() {
        Class a = Kit.m5805a("org.w3c.dom.Node");
        if (a == null) {
            return false;
        }
        try {
            a.getMethod("getUserData", new Class[]{String.class});
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /* renamed from: a */
    protected static Object m6786a(Callable eVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Object call = eVar.call(lVar, drVar, drVar2, objArr);
        return call instanceof ConsString ? call.toString() : call;
    }

    /* renamed from: d */
    protected static void m6790d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo19147e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (((C2200q) Kit.m5807a(this.f6810e, i2)) != null) {
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo19148f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (((C2200q) Kit.m5807a(this.f6810e, i2)) != null) {
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
