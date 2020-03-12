package p012ch.qos.logback.classic.sift;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.event.InPlayListener;
import p012ch.qos.logback.core.joran.event.SaxEvent;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.sift.SiftAction */
public class SiftAction extends Action implements InPlayListener {
    List<SaxEvent> seList;

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.seList = new ArrayList();
        interpretationContext.addInPlayListener(this);
    }

    public void end(InterpretationContext interpretationContext, String str) {
        interpretationContext.removeInPlayListener(this);
        Object peekObject = interpretationContext.peekObject();
        if (peekObject instanceof SiftingAppender) {
            SiftingAppender siftingAppender = (SiftingAppender) peekObject;
            siftingAppender.setAppenderFactory(new AppenderFactoryUsingJoran(this.seList, siftingAppender.getDiscriminatorKey(), interpretationContext.getCopyOfPropertyMap()));
        }
    }

    public void inPlay(SaxEvent saxEvent) {
        this.seList.add(saxEvent);
    }

    public List<SaxEvent> getSeList() {
        return this.seList;
    }
}
