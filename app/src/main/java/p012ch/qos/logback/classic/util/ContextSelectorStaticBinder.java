package p012ch.qos.logback.classic.util;

import p012ch.qos.logback.classic.ClassicConstants;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.classic.selector.ContextSelector;
import p012ch.qos.logback.classic.selector.DefaultContextSelector;
import p012ch.qos.logback.core.util.Loader;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.util.ContextSelectorStaticBinder */
public class ContextSelectorStaticBinder {
    static ContextSelectorStaticBinder singleton = new ContextSelectorStaticBinder();
    ContextSelector contextSelector;
    Object key;

    public static ContextSelectorStaticBinder getSingleton() {
        return singleton;
    }

    public void init(LoggerContext loggerContext, Object obj) {
        if (this.key == null) {
            this.key = obj;
        } else if (this.key != obj) {
            throw new IllegalAccessException("Only certain classes can access this method.");
        }
        String systemProperty = OptionHelper.getSystemProperty(ClassicConstants.LOGBACK_CONTEXT_SELECTOR);
        if (systemProperty == null) {
            this.contextSelector = new DefaultContextSelector(loggerContext);
        } else if (systemProperty.equals("JNDI")) {
            throw new RuntimeException("JNDI not supported");
        } else {
            this.contextSelector = dynamicalContextSelector(loggerContext, systemProperty);
        }
    }

    static ContextSelector dynamicalContextSelector(LoggerContext loggerContext, String str) {
        return (ContextSelector) Loader.loadClass(str).getConstructor(new Class[]{LoggerContext.class}).newInstance(new Object[]{loggerContext});
    }

    public ContextSelector getContextSelector() {
        return this.contextSelector;
    }
}
