package p012ch.qos.logback.classic.joran.action;

import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.action.AbstractIncludeAction;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.joran.action.ConditionalIncludeAction */
public class ConditionalIncludeAction extends AbstractIncludeAction {

    /* renamed from: ch.qos.logback.classic.joran.action.ConditionalIncludeAction$State */
    class State {
        private URL url;

        State() {
        }

        /* access modifiers changed from: 0000 */
        public URL getUrl() {
            return this.url;
        }

        /* access modifiers changed from: 0000 */
        public void setUrl(URL url2) {
            this.url = url2;
        }
    }

    /* access modifiers changed from: protected */
    public void handleError(String str, Exception exc) {
        if (exc == null || (exc instanceof FileNotFoundException) || (exc instanceof UnknownHostException)) {
            addInfo(str);
        } else {
            addWarn(str, exc);
        }
    }

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        if (peekPath(interpretationContext) == null) {
            super.begin(interpretationContext, str, attributes);
        }
    }

    /* access modifiers changed from: protected */
    public void processInclude(InterpretationContext interpretationContext, URL url) {
        pushPath(interpretationContext, url);
    }

    private URL peekPath(InterpretationContext interpretationContext) {
        if (!interpretationContext.isEmpty()) {
            Object peekObject = interpretationContext.peekObject();
            if (peekObject instanceof State) {
                URL url = ((State) peekObject).getUrl();
                if (url != null) {
                    return url;
                }
            }
        }
        return null;
    }

    private URL pushPath(InterpretationContext interpretationContext, URL url) {
        State state = new State();
        state.setUrl(url);
        interpretationContext.pushObject(state);
        return url;
    }
}
