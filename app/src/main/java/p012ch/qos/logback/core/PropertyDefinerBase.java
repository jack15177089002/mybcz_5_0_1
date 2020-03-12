package p012ch.qos.logback.core;

import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.PropertyDefiner;

/* renamed from: ch.qos.logback.core.PropertyDefinerBase */
public abstract class PropertyDefinerBase extends ContextAwareBase implements PropertyDefiner {
    public static String booleanAsStr(boolean z) {
        return z ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
    }
}
