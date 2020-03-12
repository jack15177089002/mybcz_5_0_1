package p012ch.qos.logback.classic.util;

import p012ch.qos.logback.classic.PatternLayout;
import p012ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import p012ch.qos.logback.core.AppenderBase;
import p012ch.qos.logback.core.UnsynchronizedAppenderBase;
import p012ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;

/* renamed from: ch.qos.logback.classic.util.DefaultNestedComponentRules */
public class DefaultNestedComponentRules {
    public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        defaultNestedComponentRegistry.add(AppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.add(AppenderBase.class, "encoder", PatternLayoutEncoder.class);
        defaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "encoder", PatternLayoutEncoder.class);
    }
}
