package p012ch.qos.logback.core.sift;

import p012ch.qos.logback.core.Appender;
import p012ch.qos.logback.core.Context;

/* renamed from: ch.qos.logback.core.sift.AppenderFactory */
public interface AppenderFactory<E> {
    Appender<E> buildAppender(Context context, String str);
}
