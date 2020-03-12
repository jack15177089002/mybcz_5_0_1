package p012ch.qos.logback.core.pattern;

import p012ch.qos.logback.core.Layout;
import p012ch.qos.logback.core.encoder.LayoutWrappingEncoder;

/* renamed from: ch.qos.logback.core.pattern.PatternLayoutEncoderBase */
public class PatternLayoutEncoderBase<E> extends LayoutWrappingEncoder<E> {
    public boolean outputPatternAsHeader = false;
    String pattern;

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public boolean isOutputPatternAsHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsHeader(boolean z) {
        this.outputPatternAsHeader = z;
    }

    public boolean isOutputPatternAsPresentationHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsPresentationHeader(boolean z) {
        addWarn("[outputPatternAsPresentationHeader] property is deprecated. Please use [outputPatternAsHeader] option instead.");
        this.outputPatternAsHeader = z;
    }

    public void setLayout(Layout<E> layout) {
        throw new UnsupportedOperationException("one cannot set the layout of " + getClass().getName());
    }
}
