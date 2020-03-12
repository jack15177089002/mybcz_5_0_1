package p012ch.qos.logback.classic.joran;

import p012ch.qos.logback.classic.joran.action.ConditionalIncludeAction;
import p012ch.qos.logback.classic.joran.action.ConfigurationAction;
import p012ch.qos.logback.classic.joran.action.ContextNameAction;
import p012ch.qos.logback.classic.joran.action.FindIncludeAction;
import p012ch.qos.logback.classic.joran.action.LevelAction;
import p012ch.qos.logback.classic.joran.action.LoggerAction;
import p012ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
import p012ch.qos.logback.classic.joran.action.ReceiverAction;
import p012ch.qos.logback.classic.joran.action.RootLoggerAction;
import p012ch.qos.logback.classic.sift.SiftAction;
import p012ch.qos.logback.classic.util.DefaultNestedComponentRules;
import p012ch.qos.logback.core.joran.JoranConfiguratorBase;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.action.AppenderRefAction;
import p012ch.qos.logback.core.joran.action.IncludeAction;
import p012ch.qos.logback.core.joran.action.NOPAction;
import p012ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p012ch.qos.logback.core.joran.spi.ElementSelector;
import p012ch.qos.logback.core.joran.spi.RuleStore;

/* renamed from: ch.qos.logback.classic.joran.JoranConfigurator */
public class JoranConfigurator extends JoranConfiguratorBase {
    public void addInstanceRules(RuleStore ruleStore) {
        super.addInstanceRules(ruleStore);
        ruleStore.addRule(new ElementSelector("configuration"), (Action) new ConfigurationAction());
        ruleStore.addRule(new ElementSelector("configuration/contextName"), (Action) new ContextNameAction());
        ruleStore.addRule(new ElementSelector("configuration/contextListener"), (Action) new LoggerContextListenerAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift"), (Action) new SiftAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift/*"), (Action) new NOPAction());
        ruleStore.addRule(new ElementSelector("configuration/logger"), (Action) new LoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/level"), (Action) new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/root"), (Action) new RootLoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/root/level"), (Action) new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/appender-ref"), (Action) new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/root/appender-ref"), (Action) new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/include"), (Action) new IncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/includes"), (Action) new FindIncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/includes/include"), (Action) new ConditionalIncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/receiver"), (Action) new ReceiverAction());
    }

    /* access modifiers changed from: protected */
    public void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(defaultNestedComponentRegistry);
    }
}
