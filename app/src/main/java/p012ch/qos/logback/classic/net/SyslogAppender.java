package p012ch.qos.logback.classic.net;

import java.io.IOException;
import java.io.OutputStream;
import p012ch.qos.logback.classic.PatternLayout;
import p012ch.qos.logback.classic.pattern.SyslogStartConverter;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.classic.spi.IThrowableProxy;
import p012ch.qos.logback.classic.spi.StackTraceElementProxy;
import p012ch.qos.logback.classic.util.LevelToSyslogSeverity;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.Layout;
import p012ch.qos.logback.core.net.SyslogAppenderBase;

/* renamed from: ch.qos.logback.classic.net.SyslogAppender */
public class SyslogAppender extends SyslogAppenderBase<ILoggingEvent> {
    public static final String DEFAULT_STACKTRACE_PATTERN = "\t";
    public static final String DEFAULT_SUFFIX_PATTERN = "[%thread] %logger %msg";
    PatternLayout stackTraceLayout = new PatternLayout();
    String stackTracePattern = DEFAULT_STACKTRACE_PATTERN;
    boolean throwableExcluded = false;

    public void start() {
        super.start();
        setupStackTraceLayout();
    }

    /* access modifiers changed from: 0000 */
    public String getPrefixPattern() {
        return "%syslogStart{" + getFacility() + "}%nopex{}";
    }

    public int getSeverityForEvent(Object obj) {
        return LevelToSyslogSeverity.convert((ILoggingEvent) obj);
    }

    /* access modifiers changed from: protected */
    public void postProcess(Object obj, OutputStream outputStream) {
        if (!this.throwableExcluded) {
            ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
            IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
            if (throwableProxy != null) {
                String doLayout = this.stackTraceLayout.doLayout(iLoggingEvent);
                boolean z = true;
                while (throwableProxy != null) {
                    StackTraceElementProxy[] stackTraceElementProxyArray = throwableProxy.getStackTraceElementProxyArray();
                    try {
                        handleThrowableFirstLine(outputStream, throwableProxy, doLayout, z);
                        for (StackTraceElementProxy stackTraceElementProxy : stackTraceElementProxyArray) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(doLayout).append(stackTraceElementProxy);
                            outputStream.write(sb.toString().getBytes());
                            outputStream.flush();
                        }
                        throwableProxy = throwableProxy.getCause();
                        z = false;
                    } catch (IOException e) {
                        return;
                    }
                }
            }
        }
    }

    private void handleThrowableFirstLine(OutputStream outputStream, IThrowableProxy iThrowableProxy, String str, boolean z) {
        StringBuilder append = new StringBuilder().append(str);
        if (!z) {
            append.append(CoreConstants.CAUSED_BY);
        }
        append.append(iThrowableProxy.getClassName()).append(": ").append(iThrowableProxy.getMessage());
        outputStream.write(append.toString().getBytes());
        outputStream.flush();
    }

    /* access modifiers changed from: 0000 */
    public boolean stackTraceHeaderLine(StringBuilder sb, boolean z) {
        return false;
    }

    public Layout<ILoggingEvent> buildLayout() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.getInstanceConverterMap().put("syslogStart", SyslogStartConverter.class.getName());
        if (this.suffixPattern == null) {
            this.suffixPattern = DEFAULT_SUFFIX_PATTERN;
        }
        patternLayout.setPattern(getPrefixPattern() + this.suffixPattern);
        patternLayout.setContext(getContext());
        patternLayout.start();
        return patternLayout;
    }

    private void setupStackTraceLayout() {
        this.stackTraceLayout.getInstanceConverterMap().put("syslogStart", SyslogStartConverter.class.getName());
        this.stackTraceLayout.setPattern(getPrefixPattern() + this.stackTracePattern);
        this.stackTraceLayout.setContext(getContext());
        this.stackTraceLayout.start();
    }

    public boolean isThrowableExcluded() {
        return this.throwableExcluded;
    }

    public void setThrowableExcluded(boolean z) {
        this.throwableExcluded = z;
    }

    public String getStackTracePattern() {
        return this.stackTracePattern;
    }

    public void setStackTracePattern(String str) {
        this.stackTracePattern = str;
    }
}
