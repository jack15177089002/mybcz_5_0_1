package p012ch.qos.logback.classic.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.classic.spi.IThrowableProxy;
import p012ch.qos.logback.classic.spi.StackTraceElementProxy;
import p012ch.qos.logback.classic.spi.ThrowableProxyUtil;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.boolex.EvaluationException;
import p012ch.qos.logback.core.boolex.EventEvaluator;
import p012ch.qos.logback.core.status.ErrorStatus;

/* renamed from: ch.qos.logback.classic.pattern.ThrowableProxyConverter */
public class ThrowableProxyConverter extends ThrowableHandlingConverter {
    protected static final int BUILDER_CAPACITY = 2048;
    int errorCount = 0;
    List<EventEvaluator<ILoggingEvent>> evaluatorList = null;
    int lengthOption;

    public void start() {
        String firstOption = getFirstOption();
        if (firstOption == null) {
            this.lengthOption = Integer.MAX_VALUE;
        } else {
            String lowerCase = firstOption.toLowerCase();
            if ("full".equals(lowerCase)) {
                this.lengthOption = Integer.MAX_VALUE;
            } else if ("short".equals(lowerCase)) {
                this.lengthOption = 1;
            } else {
                try {
                    this.lengthOption = Integer.parseInt(lowerCase);
                } catch (NumberFormatException e) {
                    addError("Could not parse [" + lowerCase + "] as an integer");
                    this.lengthOption = Integer.MAX_VALUE;
                }
            }
        }
        List optionList = getOptionList();
        if (optionList != null && optionList.size() > 1) {
            int size = optionList.size();
            for (int i = 1; i < size; i++) {
                addEvaluator((EventEvaluator) ((Map) getContext().getObject(CoreConstants.EVALUATOR_MAP)).get((String) optionList.get(i)));
            }
        }
        super.start();
    }

    private void addEvaluator(EventEvaluator<ILoggingEvent> eventEvaluator) {
        if (this.evaluatorList == null) {
            this.evaluatorList = new ArrayList();
        }
        this.evaluatorList.add(eventEvaluator);
    }

    public void stop() {
        this.evaluatorList = null;
        super.stop();
    }

    /* access modifiers changed from: protected */
    public void extraData(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        boolean z = false;
        IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
        if (throwableProxy == null) {
            return "";
        }
        if (this.evaluatorList != null) {
            int i = 0;
            while (true) {
                if (i >= this.evaluatorList.size()) {
                    z = true;
                    break;
                }
                EventEvaluator eventEvaluator = (EventEvaluator) this.evaluatorList.get(i);
                try {
                    if (eventEvaluator.evaluate(iLoggingEvent)) {
                        break;
                    }
                    i++;
                } catch (EvaluationException e) {
                    this.errorCount++;
                    if (this.errorCount < 4) {
                        addError("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", e);
                    } else if (this.errorCount == 4) {
                        ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, e);
                        errorStatus.add(new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        addStatus(errorStatus);
                    }
                }
            }
            if (!z) {
                return "";
            }
        }
        return throwableProxyToString(throwableProxy);
    }

    /* access modifiers changed from: protected */
    public String throwableProxyToString(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        recursiveAppend(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }

    private void recursiveAppend(StringBuilder sb, String str, int i, IThrowableProxy iThrowableProxy) {
        while (iThrowableProxy != null) {
            subjoinFirstLine(sb, str, i, iThrowableProxy);
            sb.append(CoreConstants.LINE_SEPARATOR);
            subjoinSTEPArray(sb, i, iThrowableProxy);
            IThrowableProxy[] suppressed = iThrowableProxy.getSuppressed();
            if (suppressed != null) {
                for (IThrowableProxy recursiveAppend : suppressed) {
                    recursiveAppend(sb, CoreConstants.SUPPRESSED, i + 1, recursiveAppend);
                }
            }
            str = CoreConstants.CAUSED_BY;
            iThrowableProxy = iThrowableProxy.getCause();
        }
    }

    private void subjoinFirstLine(StringBuilder sb, String str, int i, IThrowableProxy iThrowableProxy) {
        ThrowableProxyUtil.indent(sb, i - 1);
        if (str != null) {
            sb.append(str);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }

    private void subjoinExceptionMessage(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        sb.append(iThrowableProxy.getClassName()).append(": ").append(iThrowableProxy.getMessage());
    }

    /* access modifiers changed from: protected */
    public void subjoinSTEPArray(StringBuilder sb, int i, IThrowableProxy iThrowableProxy) {
        StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        int commonFrames = iThrowableProxy.getCommonFrames();
        boolean z = this.lengthOption > stackTraceElementProxyArray.length;
        int i2 = z ? stackTraceElementProxyArray.length : this.lengthOption;
        if (commonFrames > 0 && z) {
            i2 -= commonFrames;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            ThrowableProxyUtil.indent(sb, i);
            sb.append(stackTraceElementProxyArray[i3]);
            extraData(sb, stackTraceElementProxyArray[i3]);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        if (commonFrames > 0 && z) {
            ThrowableProxyUtil.indent(sb, i);
            sb.append("... ").append(iThrowableProxy.getCommonFrames()).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
        }
    }
}
