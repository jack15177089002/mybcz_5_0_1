package p012ch.qos.logback.classic.spi;

import java.io.Serializable;
import p012ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.spi.LoggerRemoteView */
public class LoggerRemoteView implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!LoggerRemoteView.class.desiredAssertionStatus());
    private static final long serialVersionUID = 5028223666108713696L;
    final LoggerContextVO loggerContextView;
    final String name;

    public LoggerRemoteView(String str, LoggerContext loggerContext) {
        this.name = str;
        if ($assertionsDisabled || loggerContext.getLoggerContextRemoteView() != null) {
            this.loggerContextView = loggerContext.getLoggerContextRemoteView();
            return;
        }
        throw new AssertionError();
    }

    public LoggerContextVO getLoggerContextView() {
        return this.loggerContextView;
    }

    public String getName() {
        return this.name;
    }
}
