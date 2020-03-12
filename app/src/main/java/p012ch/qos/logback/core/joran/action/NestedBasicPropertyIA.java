package p012ch.qos.logback.core.joran.action;

import java.util.Stack;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.spi.ElementPath;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.util.PropertySetter;
import p012ch.qos.logback.core.util.AggregationType;

/* renamed from: ch.qos.logback.core.joran.action.NestedBasicPropertyIA */
public class NestedBasicPropertyIA extends ImplicitAction {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$util$AggregationType;
    Stack<IADataForBasicProperty> actionDataStack = new Stack<>();

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
            case 3:
            case 5:
                return false;
            case 2:
            case 4:
                this.actionDataStack.push(new IADataForBasicProperty(propertySetter, computeAggregationType, peekLast));
                return true;
            default:
                addError("PropertySetter.canContainComponent returned " + computeAggregationType);
                return false;
        }
    }

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
    }

    public void body(InterpretationContext interpretationContext, String str) {
        String subst = interpretationContext.subst(str);
        IADataForBasicProperty iADataForBasicProperty = (IADataForBasicProperty) this.actionDataStack.peek();
        switch ($SWITCH_TABLE$ch$qos$logback$core$util$AggregationType()[iADataForBasicProperty.aggregationType.ordinal()]) {
            case 2:
                iADataForBasicProperty.parentBean.setProperty(iADataForBasicProperty.propertyName, subst);
                return;
            case 4:
                iADataForBasicProperty.parentBean.addBasicProperty(iADataForBasicProperty.propertyName, subst);
                return;
            default:
                return;
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
        this.actionDataStack.pop();
    }
}
