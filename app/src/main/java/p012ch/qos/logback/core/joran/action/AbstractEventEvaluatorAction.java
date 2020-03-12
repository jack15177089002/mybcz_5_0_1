package p012ch.qos.logback.core.joran.action;

import java.util.Map;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.boolex.EventEvaluator;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction */
public abstract class AbstractEventEvaluatorAction extends Action {
    EventEvaluator<?> evaluator;
    boolean inError = false;

    /* access modifiers changed from: protected */
    public abstract String defaultClassName();

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.inError = false;
        this.evaluator = null;
        String value = attributes.getValue(Action.CLASS_ATTRIBUTE);
        if (OptionHelper.isEmpty(value)) {
            value = defaultClassName();
            addInfo("Assuming default evaluator class [" + value + "]");
        }
        String str2 = value;
        if (OptionHelper.isEmpty(str2)) {
            defaultClassName();
            this.inError = true;
            addError("Mandatory \"class\" attribute not set for <evaluator>");
            return;
        }
        String value2 = attributes.getValue("name");
        if (OptionHelper.isEmpty(value2)) {
            this.inError = true;
            addError("Mandatory \"name\" attribute not set for <evaluator>");
            return;
        }
        try {
            this.evaluator = (EventEvaluator) OptionHelper.instantiateByClassName(str2, EventEvaluator.class, this.context);
            this.evaluator.setContext(this.context);
            this.evaluator.setName(value2);
            interpretationContext.pushObject(this.evaluator);
            addInfo("Adding evaluator named [" + value2 + "] to the object stack");
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create evaluator of type " + str2 + "].", e);
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
        if (!this.inError) {
            if (this.evaluator instanceof LifeCycle) {
                this.evaluator.start();
                addInfo("Starting evaluator named [" + this.evaluator.getName() + "]");
            }
            if (interpretationContext.peekObject() != this.evaluator) {
                addWarn("The object on the top the of the stack is not the evaluator pushed earlier.");
                return;
            }
            interpretationContext.popObject();
            try {
                Map map = (Map) this.context.getObject(CoreConstants.EVALUATOR_MAP);
                if (map == null) {
                    addError("Could not find EvaluatorMap");
                } else {
                    map.put(this.evaluator.getName(), this.evaluator);
                }
            } catch (Exception e) {
                addError("Could not set evaluator named [" + this.evaluator + "].", e);
            }
        }
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
