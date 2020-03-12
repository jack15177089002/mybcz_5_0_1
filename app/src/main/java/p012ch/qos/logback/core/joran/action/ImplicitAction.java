package p012ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.spi.ElementPath;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.action.ImplicitAction */
public abstract class ImplicitAction extends Action {
    public abstract boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext interpretationContext);
}
