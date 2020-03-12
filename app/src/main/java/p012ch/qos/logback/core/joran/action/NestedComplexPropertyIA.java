package p012ch.qos.logback.core.joran.action;

import java.util.Stack;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.spi.ElementPath;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import p012ch.qos.logback.core.joran.util.PropertySetter;
import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.util.AggregationType;
import p012ch.qos.logback.core.util.Loader;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.NestedComplexPropertyIA */
public class NestedComplexPropertyIA extends ImplicitAction {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType;
    Stack<IADataForComplexProperty> actionDataStack = new Stack<>();

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType;
        if (iArr == null) {
            iArr = new int[AggregationType.values().length];
            try {
                iArr[AggregationType.AS_BASIC_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AggregationType.AS_BASIC_PROPERTY_COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AggregationType.AS_COMPLEX_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AggregationType.AS_COMPLEX_PROPERTY_COLLECTION.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AggregationType.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType = iArr;
        }
        return iArr;
    }

    public boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext interpretationContext) {
        String peekLast = elementPath.peekLast();
        if (interpretationContext.isEmpty()) {
            return false;
        }
        PropertySetter propertySetter = new PropertySetter(interpretationContext.peekObject());
        propertySetter.setContext(this.context);
        AggregationType computeAggregationType = propertySetter.computeAggregationType(peekLast);
        switch ($SWITCH_TABLE$ch$qos$logback$core$util$AggregationType()[computeAggregationType.ordinal()]) {
            case 1:
            case 2:
            case 4:
                return false;
            case 3:
            case 5:
                this.actionDataStack.push(new IADataForComplexProperty(propertySetter, computeAggregationType, peekLast));
                return true;
            default:
                addError("PropertySetter.computeAggregationType returned " + computeAggregationType);
                return false;
        }
    }

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        Class classNameViaImplicitRules;
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.actionDataStack.peek();
        String subst = interpretationContext.subst(attributes.getValue(Action.CLASS_ATTRIBUTE));
        try {
            if (!OptionHelper.isEmpty(subst)) {
                classNameViaImplicitRules = Loader.loadClass(subst, this.context);
            } else {
                classNameViaImplicitRules = iADataForComplexProperty.parentBean.getClassNameViaImplicitRules(iADataForComplexProperty.getComplexPropertyName(), iADataForComplexProperty.getAggregationType(), interpretationContext.getDefaultNestedComponentRegistry());
            }
            if (classNameViaImplicitRules == null) {
                iADataForComplexProperty.inError = true;
                addError("Could not find an appropriate class for property [" + str + "]");
                return;
            }
            if (OptionHelper.isEmpty(subst)) {
                addInfo("Assuming default type [" + classNameViaImplicitRules.getName() + "] for [" + str + "] property");
            }
            iADataForComplexProperty.setNestedComplexProperty(classNameViaImplicitRules.newInstance());
            if (iADataForComplexProperty.getNestedComplexProperty() instanceof ContextAware) {
                ((ContextAware) iADataForComplexProperty.getNestedComplexProperty()).setContext(this.context);
            }
            interpretationContext.pushObject(iADataForComplexProperty.getNestedComplexProperty());
        } catch (Exception e) {
            iADataForComplexProperty.inError = true;
            addError("Could not create component [" + str + "] of type [" + subst + "]", e);
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.actionDataStack.pop();
        if (!iADataForComplexProperty.inError) {
            PropertySetter propertySetter = new PropertySetter(iADataForComplexProperty.getNestedComplexProperty());
            propertySetter.setContext(this.context);
            if (propertySetter.computeAggregationType("parent") == AggregationType.AS_COMPLEX_PROPERTY) {
                propertySetter.setComplexProperty("parent", iADataForComplexProperty.parentBean.getObj());
            }
            Object nestedComplexProperty = iADataForComplexProperty.getNestedComplexProperty();
            if ((nestedComplexProperty instanceof LifeCycle) && NoAutoStartUtil.notMarkedWithNoAutoStart(nestedComplexProperty)) {
                ((LifeCycle) nestedComplexProperty).start();
            }
            if (interpretationContext.peekObject() != iADataForComplexProperty.getNestedComplexProperty()) {
                addError("The object on the top the of the stack is not the component pushed earlier.");
                return;
            }
            interpretationContext.popObject();
            switch ($SWITCH_TABLE$ch$qos$logback$core$util$AggregationType()[iADataForComplexProperty.aggregationType.ordinal()]) {
                case 3:
                    iADataForComplexProperty.parentBean.setComplexProperty(str, iADataForComplexProperty.getNestedComplexProperty());
                    return;
                case 5:
                    iADataForComplexProperty.parentBean.addComplexProperty(str, iADataForComplexProperty.getNestedComplexProperty());
                    return;
                default:
                    return;
            }
        }
    }
}
