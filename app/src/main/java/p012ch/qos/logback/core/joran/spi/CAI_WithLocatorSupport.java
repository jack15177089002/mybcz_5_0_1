package p012ch.qos.logback.core.joran.spi;

import org.xml.sax.Locator;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.spi.ContextAwareImpl;

/* renamed from: ch.qos.logback.core.joran.spi.CAI_WithLocatorSupport */
/* compiled from: Interpreter */
class CAI_WithLocatorSupport extends ContextAwareImpl {
    CAI_WithLocatorSupport(Context context, Interpreter interpreter) {
        super(context, interpreter);
    }

    /* access modifiers changed from: protected */
    public Object getOrigin() {
        Locator locator = ((Interpreter) super.getOrigin()).locator;
        if (locator != null) {
            return new StringBuilder(String.valueOf(Interpreter.class.getName())).append("@").append(locator.getLineNumber()).append(":").append(locator.getColumnNumber()).toString();
        }
        return new StringBuilder(String.valueOf(Interpreter.class.getName())).append("@NA:NA").toString();
    }
}
