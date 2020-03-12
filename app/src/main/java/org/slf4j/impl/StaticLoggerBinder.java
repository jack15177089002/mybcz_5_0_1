package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.classic.util.ContextSelectorStaticBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {
    private static Object KEY = new Object();
    static final String NULL_CS_URL = "http://logback.qos.ch/codes.html#null_CS";
    public static String REQUESTED_API_VERSION = "1.6";
    private static StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    private final ContextSelectorStaticBinder contextSelectorBinder = ContextSelectorStaticBinder.getSingleton();
    private LoggerContext defaultLoggerContext = new LoggerContext();
    private boolean initialized = false;

    static {
        SINGLETON.init();
    }

    private StaticLoggerBinder() {
        this.defaultLoggerContext.setName("default");
    }

    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    static void reset() {
        StaticLoggerBinder staticLoggerBinder = new StaticLoggerBinder();
        SINGLETON = staticLoggerBinder;
        staticLoggerBinder.init();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init() {
        /*
            r3 = this;
            ch.qos.logback.classic.util.ContextInitializer r0 = new ch.qos.logback.classic.util.ContextInitializer     // Catch:{ JoranException -> 0x0024 }
            ch.qos.logback.classic.LoggerContext r1 = r3.defaultLoggerContext     // Catch:{ JoranException -> 0x0024 }
            r0.<init>(r1)     // Catch:{ JoranException -> 0x0024 }
            r0.autoConfig()     // Catch:{ JoranException -> 0x0024 }
        L_0x000a:
            ch.qos.logback.classic.LoggerContext r0 = r3.defaultLoggerContext     // Catch:{ Throwable -> 0x002b }
            boolean r0 = p012ch.qos.logback.core.status.StatusUtil.contextHasStatusListener(r0)     // Catch:{ Throwable -> 0x002b }
            if (r0 != 0) goto L_0x0017
            ch.qos.logback.classic.LoggerContext r0 = r3.defaultLoggerContext     // Catch:{ Throwable -> 0x002b }
            p012ch.qos.logback.core.util.StatusPrinter.printInCaseOfErrorsOrWarnings(r0)     // Catch:{ Throwable -> 0x002b }
        L_0x0017:
            ch.qos.logback.classic.util.ContextSelectorStaticBinder r0 = r3.contextSelectorBinder     // Catch:{ Throwable -> 0x002b }
            ch.qos.logback.classic.LoggerContext r1 = r3.defaultLoggerContext     // Catch:{ Throwable -> 0x002b }
            java.lang.Object r2 = KEY     // Catch:{ Throwable -> 0x002b }
            r0.init(r1, r2)     // Catch:{ Throwable -> 0x002b }
            r0 = 1
            r3.initialized = r0     // Catch:{ Throwable -> 0x002b }
        L_0x0023:
            return
        L_0x0024:
            r0 = move-exception
            java.lang.String r1 = "Failed to auto configure default logger context"
            org.slf4j.helpers.Util.report(r1, r0)     // Catch:{ Throwable -> 0x002b }
            goto L_0x000a
        L_0x002b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to instantiate ["
            r1.<init>(r2)
            java.lang.Class<ch.qos.logback.classic.LoggerContext> r2 = p012ch.qos.logback.classic.LoggerContext.class
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "]"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            org.slf4j.helpers.Util.report(r1, r0)
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.impl.StaticLoggerBinder.init():void");
    }

    public ILoggerFactory getLoggerFactory() {
        if (!this.initialized) {
            return this.defaultLoggerContext;
        }
        if (this.contextSelectorBinder.getContextSelector() != null) {
            return this.contextSelectorBinder.getContextSelector().getLoggerContext();
        }
        throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
    }

    public String getLoggerFactoryClassStr() {
        return this.contextSelectorBinder.getClass().getName();
    }
}
