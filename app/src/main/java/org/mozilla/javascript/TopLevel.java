package org.mozilla.javascript;

import java.util.EnumMap;

/* renamed from: org.mozilla.javascript.eg */
public class TopLevel extends IdScriptableObject {

    /* renamed from: a */
    static final /* synthetic */ boolean f6672a = (!TopLevel.class.desiredAssertionStatus());

    /* renamed from: b */
    private EnumMap<C2193eh, BaseFunction> f6673b;

    public String getClassName() {
        return "global";
    }

    /* renamed from: a */
    public final void mo19089a() {
        C2193eh[] values;
        this.f6673b = new EnumMap<>(C2193eh.class);
        for (C2193eh ehVar : C2193eh.values()) {
            Object property = ScriptableObject.getProperty((Scriptable) this, ehVar.name());
            if (property instanceof BaseFunction) {
                this.f6673b.put(ehVar, (BaseFunction) property);
            }
        }
    }

    /* renamed from: a */
    public static Scriptable m6647a(Scriptable drVar, C2193eh ehVar) {
        if (f6672a || drVar.getParentScope() == null) {
            if (drVar instanceof TopLevel) {
                TopLevel egVar = (TopLevel) drVar;
                BaseFunction bVar = egVar.f6673b != null ? (BaseFunction) egVar.f6673b.get(ehVar) : null;
                Object obj = bVar != null ? bVar.getPrototypeProperty() : null;
                Scriptable drVar2 = obj instanceof Scriptable ? (Scriptable) obj : null;
                if (drVar2 != null) {
                    return drVar2;
                }
            }
            return ScriptableObject.getClassPrototype(drVar, ehVar.name());
        }
        throw new AssertionError();
    }
}
