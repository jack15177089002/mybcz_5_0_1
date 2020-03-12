package p012ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.Logger;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.action.ActionConst;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;

@Deprecated
/* renamed from: ch.qos.logback.classic.joran.action.LevelAction */
public class LevelAction extends Action {
    boolean inError = false;

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        Object peekObject = interpretationContext.peekObject();
        if (!(peekObject instanceof Logger)) {
            this.inError = true;
            addError("For element <level>, could not find a logger at the top of execution stack.");
            return;
        }
        Logger logger = (Logger) peekObject;
        String name = logger.getName();
        String subst = interpretationContext.subst(attributes.getValue("value"));
        if (ActionConst.INHERITED.equalsIgnoreCase(subst) || ActionConst.NULL.equalsIgnoreCase(subst)) {
            logger.setLevel(null);
        } else {
            logger.setLevel(Level.toLevel(subst, Level.DEBUG));
        }
        addInfo(new StringBuilder(String.valueOf(name)).append(" level set to ").append(logger.getLevel()).toString());
    }

    public void finish(InterpretationContext interpretationContext) {
    }

    public void end(InterpretationContext interpretationContext, String str) {
    }
}
