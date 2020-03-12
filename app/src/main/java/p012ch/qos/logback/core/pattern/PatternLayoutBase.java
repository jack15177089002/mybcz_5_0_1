package p012ch.qos.logback.core.pattern;

import java.util.HashMap;
import java.util.Map;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.LayoutBase;
import p012ch.qos.logback.core.pattern.parser.Parser;
import p012ch.qos.logback.core.spi.ScanException;
import p012ch.qos.logback.core.status.ErrorStatus;
import p012ch.qos.logback.core.status.Status;

/* renamed from: ch.qos.logback.core.pattern.PatternLayoutBase */
public abstract class PatternLayoutBase<E> extends LayoutBase<E> {
    Converter<E> head;
    Map<String, String> instanceConverterMap = new HashMap();
    protected boolean outputPatternAsHeader = false;
    String pattern;
    public PostCompileProcessor<E> postCompileProcessor;

    public abstract Map<String, String> getDefaultConverterMap();

    public Map<String, String> getEffectiveConverterMap() {
        HashMap hashMap = new HashMap();
        Map defaultConverterMap = getDefaultConverterMap();
        if (defaultConverterMap != null) {
            hashMap.putAll(defaultConverterMap);
        }
        Context context = getContext();
        if (context != null) {
            Map map = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY);
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        hashMap.putAll(this.instanceConverterMap);
        return hashMap;
    }

    public void start() {
        if (this.pattern == null || this.pattern.length() == 0) {
            addError("Empty or null pattern.");
            return;
        }
        try {
            Parser parser = new Parser(this.pattern);
            if (getContext() != null) {
                parser.setContext(getContext());
            }
            this.head = parser.compile(parser.parse(), getEffectiveConverterMap());
            if (this.postCompileProcessor != null) {
                this.postCompileProcessor.process(this.head);
            }
            ConverterUtil.setContextForConverters(getContext(), this.head);
            ConverterUtil.startConverters(this.head);
            super.start();
        } catch (ScanException e) {
            getContext().getStatusManager().add((Status) new ErrorStatus("Failed to parse pattern \"" + getPattern() + "\".", this, e));
        }
    }

    public void setPostCompileProcessor(PostCompileProcessor<E> postCompileProcessor2) {
        this.postCompileProcessor = postCompileProcessor2;
    }

    /* access modifiers changed from: protected */
    public void setContextForConverters(Converter<E> converter) {
        ConverterUtil.setContextForConverters(getContext(), converter);
    }

    public String writeLoopOnConverters(E e) {
        StringBuilder sb = new StringBuilder(128);
        for (Converter<E> converter = this.head; converter != null; converter = converter.getNext()) {
            converter.write(sb, e);
        }
        return sb.toString();
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("(\"").append(getPattern()).append("\")").toString();
    }

    public Map<String, String> getInstanceConverterMap() {
        return this.instanceConverterMap;
    }

    /* access modifiers changed from: protected */
    public String getPresentationHeaderPrefix() {
        return "";
    }

    public boolean isOutputPatternAsHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsHeader(boolean z) {
        this.outputPatternAsHeader = z;
    }

    public String getPresentationHeader() {
        if (this.outputPatternAsHeader) {
            return getPresentationHeaderPrefix() + this.pattern;
        }
        return super.getPresentationHeader();
    }
}
