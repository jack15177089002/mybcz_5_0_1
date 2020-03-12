package p012ch.qos.logback.core.sift;

import java.util.List;
import java.util.Map;
import p012ch.qos.logback.core.Appender;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.joran.event.SaxEvent;

/* renamed from: ch.qos.logback.core.sift.AbstractAppenderFactoryUsingJoran */
public abstract class AbstractAppenderFactoryUsingJoran<E> implements AppenderFactory<E> {
    final List<SaxEvent> eventList;
    public String key;
    public Map<String, String> parentPropertyMap;

    public abstract SiftingJoranConfiguratorBase<E> getSiftingJoranConfigurator(String str);

    public AbstractAppenderFactoryUsingJoran(List<SaxEvent> list, String str, Map<String, String> map) {
        this.eventList = removeSiftElement(list);
        this.key = str;
        this.parentPropertyMap = map;
    }

    /* access modifiers changed from: 0000 */
    public List<SaxEvent> removeSiftElement(List<SaxEvent> list) {
        return list.subList(1, list.size() - 1);
    }

    public Appender<E> buildAppender(Context context, String str) {
        SiftingJoranConfiguratorBase siftingJoranConfigurator = getSiftingJoranConfigurator(str);
        siftingJoranConfigurator.setContext(context);
        siftingJoranConfigurator.doConfigure(this.eventList);
        return siftingJoranConfigurator.getAppender();
    }

    public List<SaxEvent> getEventList() {
        return this.eventList;
    }
}
