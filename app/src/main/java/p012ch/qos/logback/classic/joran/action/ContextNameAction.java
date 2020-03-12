package p012ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.joran.action.ContextNameAction */
public class ContextNameAction extends Action {
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
    }

    public void body(InterpretationContext interpretationContext, String str) {
        String subst = interpretationContext.subst(str);
        addInfo("Setting logger context name as [" + subst + "]");
        try {
            this.context.setName(subst);
        } catch (IllegalStateException e) {
            addError("Failed to rename context [" + this.context.getName() + "] as [" + subst + "]", e);
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
    }
}
