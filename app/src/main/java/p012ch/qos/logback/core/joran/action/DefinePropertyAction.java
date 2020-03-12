package p012ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.action.ActionUtil.Scope;
import p012ch.qos.logback.core.joran.spi.ActionException;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.spi.PropertyDefiner;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.DefinePropertyAction */
public class DefinePropertyAction extends Action {
    PropertyDefiner definer;
    boolean inError;
    String propertyName;
    Scope scope;
    String scopeStr;

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.scopeStr = null;
        this.scope = null;
        this.propertyName = null;
        this.definer = null;
        this.inError = false;
        this.propertyName = attributes.getValue("name");
        this.scopeStr = attributes.getValue(Action.SCOPE_ATTRIBUTE);
        this.scope = ActionUtil.stringToScope(this.scopeStr);
        if (OptionHelper.isEmpty(this.propertyName)) {
            addError("Missing property name for property definer. Near [" + str + "] line " + getLineNumber(interpretationContext));
            this.inError = true;
            return;
        }
        String value = attributes.getValue(Action.CLASS_ATTRIBUTE);
        if (OptionHelper.isEmpty(value)) {
            addError("Missing class name for property definer. Near [" + str + "] line " + getLineNumber(interpretationContext));
            this.inError = true;
            return;
        }
        try {
            addInfo("About to instantiate property definer of type [" + value + "]");
            this.definer = (PropertyDefiner) OptionHelper.instantiateByClassName(value, PropertyDefiner.class, this.context);
            this.definer.setContext(this.context);
            if (this.definer instanceof LifeCycle) {
                ((LifeCycle) this.definer).start();
            }
            interpretationContext.pushObject(this.definer);
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create an PropertyDefiner of type [" + value + "].", e);
            throw new ActionException(e);
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
        if (!this.inError) {
            if (interpretationContext.peekObject() != this.definer) {
                addWarn("The object at the of the stack is not the property definer for property named [" + this.propertyName + "] pushed earlier.");
                return;
            }
            addInfo("Popping property definer for property named [" + this.propertyName + "] from the object stack");
            interpretationContext.popObject();
            String propertyValue = this.definer.getPropertyValue();
            if (propertyValue != null) {
                ActionUtil.setProperty(interpretationContext, this.propertyName, propertyValue, this.scope);
            }
        }
    }
}
