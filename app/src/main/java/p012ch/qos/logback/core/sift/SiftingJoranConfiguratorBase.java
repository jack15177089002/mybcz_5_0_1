package p012ch.qos.logback.core.sift;

import java.util.List;
import java.util.Map;
import p012ch.qos.logback.core.Appender;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.joran.GenericConfigurator;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.action.DefinePropertyAction;
import p012ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import p012ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import p012ch.qos.logback.core.joran.action.PropertyAction;
import p012ch.qos.logback.core.joran.action.TimestampAction;
import p012ch.qos.logback.core.joran.event.SaxEvent;
import p012ch.qos.logback.core.joran.spi.ElementSelector;
import p012ch.qos.logback.core.joran.spi.Interpreter;
import p012ch.qos.logback.core.joran.spi.RuleStore;

/* renamed from: ch.qos.logback.core.sift.SiftingJoranConfiguratorBase */
public abstract class SiftingJoranConfiguratorBase<E> extends GenericConfigurator {
    static final String ONE_AND_ONLY_ONE_URL = "http://logback.qos.ch/codes.html#1andOnly1";
    int errorEmmissionCount = 0;
    public final String key;
    public final Map<String, String> parentPropertyMap;
    public final String value;

    public abstract Appender<E> getAppender();

    public SiftingJoranConfiguratorBase(String str, String str2, Map<String, String> map) {
        this.key = str;
        this.value = str2;
        this.parentPropertyMap = map;
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

    public void addInstanceRules(RuleStore ruleStore) {
        ruleStore.addRule(new ElementSelector("configuration/property"), (Action) new PropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/timestamp"), (Action) new TimestampAction());
        ruleStore.addRule(new ElementSelector("configuration/define"), (Action) new DefinePropertyAction());
    }

    public void oneAndOnlyOneCheck(Map<?, ?> map) {
        String str = null;
        if (map.size() == 0) {
            this.errorEmmissionCount++;
            str = "No nested appenders found within the <sift> element in SiftingAppender.";
        } else if (map.size() > 1) {
            this.errorEmmissionCount++;
            str = "Only and only one appender can be nested the <sift> element in SiftingAppender. See also http://logback.qos.ch/codes.html#1andOnly1";
        }
        if (str != null && this.errorEmmissionCount < 4) {
            addError(str);
        }
    }

    public void doConfigure(List<SaxEvent> list) {
        super.doConfigure(list);
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("{").append(this.key).append("=").append(this.value).append(CoreConstants.CURLY_RIGHT).toString();
    }
}
