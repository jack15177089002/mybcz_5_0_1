package p012ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.classic.spi.LoggerContextListener;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.joran.action.LoggerContextListenerAction */
public class LoggerContextListenerAction extends Action {
    boolean inError = false;
    LoggerContextListener lcl;

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.inError = false;
        String value = attributes.getValue(Action.CLASS_ATTRIBUTE);
        if (OptionHelper.isEmpty(value)) {
            addError("Mandatory \"class\" attribute not set for <loggerContextListener> element");
            this.inError = true;
            return;
        }
        try {
            this.lcl = (LoggerContextListener) OptionHelper.instantiateByClassName(value, LoggerContextListener.class, this.context);
            if (this.lcl instanceof ContextAware) {
                ((ContextAware) this.lcl).setContext(this.context);
            }
            interpretationContext.pushObject(this.lcl);
            addInfo("Adding LoggerContextListener of type [" + value + "] to the object stack");
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create LoggerContextListener of type " + value + "].", e);
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
        if (!this.inError) {
            if (interpretationContext.peekObject() != this.lcl) {
                addWarn("The object on the top the of the stack is not the LoggerContextListener pushed earlier.");
                return;
            }
            if (this.lcl instanceof LifeCycle) {
                ((LifeCycle) this.lcl).start();
                addInfo("Starting LoggerContextListener");
            }
            ((LoggerContext) this.context).addListener(this.lcl);
            interpretationContext.popObject();
        }
    }
}
