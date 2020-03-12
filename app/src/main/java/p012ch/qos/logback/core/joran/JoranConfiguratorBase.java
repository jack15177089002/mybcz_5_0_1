package p012ch.qos.logback.core.joran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.action.ActionConst;
import p012ch.qos.logback.core.joran.action.AppenderAction;
import p012ch.qos.logback.core.joran.action.AppenderRefAction;
import p012ch.qos.logback.core.joran.action.ConversionRuleAction;
import p012ch.qos.logback.core.joran.action.DefinePropertyAction;
import p012ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import p012ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import p012ch.qos.logback.core.joran.action.NewRuleAction;
import p012ch.qos.logback.core.joran.action.ParamAction;
import p012ch.qos.logback.core.joran.action.PropertyAction;
import p012ch.qos.logback.core.joran.action.StatusListenerAction;
import p012ch.qos.logback.core.joran.action.TimestampAction;
import p012ch.qos.logback.core.joran.spi.ElementSelector;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.Interpreter;
import p012ch.qos.logback.core.joran.spi.RuleStore;

/* renamed from: ch.qos.logback.core.joran.JoranConfiguratorBase */
public abstract class JoranConfiguratorBase extends GenericConfigurator {
    public List getErrorList() {
        return null;
    }

    public void addInstanceRules(RuleStore ruleStore) {
        ruleStore.addRule(new ElementSelector("configuration/property"), (Action) new PropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/substitutionProperty"), (Action) new PropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/timestamp"), (Action) new TimestampAction());
        ruleStore.addRule(new ElementSelector("configuration/define"), (Action) new DefinePropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/conversionRule"), (Action) new ConversionRuleAction());
        ruleStore.addRule(new ElementSelector("configuration/statusListener"), (Action) new StatusListenerAction());
        ruleStore.addRule(new ElementSelector("configuration/appender"), (Action) new AppenderAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/appender-ref"), (Action) new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/newRule"), (Action) new NewRuleAction());
        ruleStore.addRule(new ElementSelector("*/param"), (Action) new ParamAction());
    }

    /* access modifiers changed from: protected */
    public void addImplicitRules(Interpreter interpreter) {
        NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA();
        nestedComplexPropertyIA.setContext(this.context);
        interpreter.addImplicitAction(nestedComplexPropertyIA);
        NestedBasicPropertyIA nestedBasicPropertyIA = new NestedBasicPropertyIA();
        nestedBasicPropertyIA.setContext(this.context);
        interpreter.addImplicitAction(nestedBasicPropertyIA);
    }

    /* access modifiers changed from: protected */
    public void buildInterpreter() {
        super.buildInterpreter();
        Map objectMap = this.interpreter.getInterpretationContext().getObjectMap();
        objectMap.put(ActionConst.APPENDER_BAG, new HashMap());
        objectMap.put(ActionConst.FILTER_CHAIN_BAG, new HashMap());
    }

    public InterpretationContext getInterpretationContext() {
        return this.interpreter.getInterpretationContext();
    }
}
