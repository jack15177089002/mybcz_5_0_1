package p012ch.qos.logback.classic.joran.action;

import java.io.InputStream;
import java.net.URL;
import org.xml.sax.Attributes;
import p012ch.qos.logback.classic.android.ASaxEventRecorder;
import p012ch.qos.logback.core.joran.action.IncludeAction;
import p012ch.qos.logback.core.joran.event.SaxEventRecorder;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.JoranException;

/* renamed from: ch.qos.logback.classic.joran.action.FindIncludeAction */
public class FindIncludeAction extends IncludeAction {
    private static final int EVENT_OFFSET = 1;

    public FindIncludeAction() {
        setEventOffset(1);
    }

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
    }

    public void end(InterpretationContext interpretationContext, String str) {
        if (!interpretationContext.isEmpty() && (interpretationContext.peekObject() instanceof State)) {
            URL url = ((State) interpretationContext.popObject()).getUrl();
            if (url != null) {
                addInfo("Path found [" + url.toString() + "]");
                try {
                    processInclude(interpretationContext, url);
                } catch (JoranException e) {
                    addError("Failed to process include [" + url.toString() + "]", e);
                }
            } else {
                addInfo("No paths found from includes");
            }
        }
    }

    /* access modifiers changed from: protected */
    public SaxEventRecorder createRecorder(InputStream inputStream, URL url) {
        if (!url.toString().endsWith("AndroidManifest.xml")) {
            return new SaxEventRecorder(getContext());
        }
        ASaxEventRecorder aSaxEventRecorder = new ASaxEventRecorder();
        aSaxEventRecorder.setFilter("logback");
        return aSaxEventRecorder;
    }
}
