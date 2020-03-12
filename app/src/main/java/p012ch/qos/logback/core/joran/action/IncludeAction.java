package p012ch.qos.logback.core.joran.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import p012ch.qos.logback.core.joran.event.SaxEvent;
import p012ch.qos.logback.core.joran.event.SaxEventRecorder;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.JoranException;
import p012ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;

/* renamed from: ch.qos.logback.core.joran.action.IncludeAction */
public class IncludeAction extends AbstractIncludeAction {
    private static final String CONFIG_TAG = "configuration";
    private static final String INCLUDED_TAG = "included";
    private int eventOffset = 2;

    public void setEventOffset(int i) {
        this.eventOffset = i;
    }

    public SaxEventRecorder createRecorder(InputStream inputStream, URL url) {
        return new SaxEventRecorder(getContext());
    }

    public void processInclude(InterpretationContext interpretationContext, URL url) {
        InputStream openURL = openURL(url);
        if (openURL != null) {
            try {
                ConfigurationWatchListUtil.addToWatchList(getContext(), url);
                SaxEventRecorder createRecorder = createRecorder(openURL, url);
                createRecorder.setContext(getContext());
                createRecorder.recordEvents(openURL);
                trimHeadAndTail(createRecorder);
                interpretationContext.getJoranInterpreter().getEventPlayer().addEventsDynamically(createRecorder.getSaxEventList(), this.eventOffset);
            } catch (JoranException e) {
                addError("Failed processing [" + url.toString() + "]", e);
                close(openURL);
                return;
            } catch (Throwable th) {
                close(openURL);
                throw th;
            }
        }
        close(openURL);
    }

    private InputStream openURL(URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            if (!isOptional()) {
                addError("Failed to open [" + url.toString() + "]", e);
            }
            return null;
        }
    }

    private void trimHeadAndTail(SaxEventRecorder saxEventRecorder) {
        boolean z;
        boolean z2;
        List saxEventList = saxEventRecorder.getSaxEventList();
        if (saxEventList.size() != 0) {
            SaxEvent saxEvent = (SaxEvent) saxEventList.get(0);
            if (saxEvent != null) {
                String eventName = getEventName(saxEvent);
                boolean equalsIgnoreCase = INCLUDED_TAG.equalsIgnoreCase(eventName);
                z2 = equalsIgnoreCase;
                z = CONFIG_TAG.equalsIgnoreCase(eventName);
            } else {
                z = false;
                z2 = false;
            }
            if (z2 || z) {
                saxEventList.remove(0);
                int size = saxEventList.size();
                if (size != 0) {
                    int i = size - 1;
                    SaxEvent saxEvent2 = (SaxEvent) saxEventList.get(i);
                    if (saxEvent2 != null) {
                        String eventName2 = getEventName(saxEvent2);
                        if ((z2 && INCLUDED_TAG.equalsIgnoreCase(eventName2)) || (z && CONFIG_TAG.equalsIgnoreCase(eventName2))) {
                            saxEventList.remove(i);
                        }
                    }
                }
            }
        }
    }

    private String getEventName(SaxEvent saxEvent) {
        return saxEvent.qName.length() > 0 ? saxEvent.qName : saxEvent.localName;
    }
}
