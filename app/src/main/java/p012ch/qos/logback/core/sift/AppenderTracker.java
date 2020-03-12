package p012ch.qos.logback.core.sift;

import p012ch.qos.logback.core.Appender;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.helpers.NOPAppender;
import p012ch.qos.logback.core.joran.spi.JoranException;
import p012ch.qos.logback.core.spi.AbstractComponentTracker;
import p012ch.qos.logback.core.spi.ContextAwareImpl;

/* renamed from: ch.qos.logback.core.sift.AppenderTracker */
public class AppenderTracker<E> extends AbstractComponentTracker<Appender<E>> {
    final AppenderFactory<E> appenderFactory;
    final Context context;
    final ContextAwareImpl contextAware;
    int nopaWarningCount = 0;

    public AppenderTracker(Context context2, AppenderFactory<E> appenderFactory2) {
        this.context = context2;
        this.appenderFactory = appenderFactory2;
        this.contextAware = new ContextAwareImpl(context2, this);
    }

    /* access modifiers changed from: protected */
    public void processPriorToRemoval(Appender<E> appender) {
        appender.stop();
    }

    /* access modifiers changed from: protected */
    public Appender<E> buildComponent(String str) {
        Appender<E> appender = null;
        try {
            appender = this.appenderFactory.buildAppender(this.context, str);
        } catch (JoranException e) {
            this.contextAware.addError("Error while building appender with discriminating value [" + str + "]");
        }
        if (appender == null) {
            return buildNOPAppender(str);
        }
        return appender;
    }

    private NOPAppender<E> buildNOPAppender(String str) {
        if (this.nopaWarningCount < 4) {
            this.nopaWarningCount++;
            this.contextAware.addError("Building NOPAppender for discriminating value [" + str + "]");
        }
        NOPAppender<E> nOPAppender = new NOPAppender<>();
        nOPAppender.setContext(this.context);
        nOPAppender.start();
        return nOPAppender;
    }

    /* access modifiers changed from: protected */
    public boolean isComponentStale(Appender<E> appender) {
        return !appender.isStarted();
    }
}
