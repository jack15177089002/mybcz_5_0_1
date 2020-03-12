package p012ch.qos.logback.classic;

import com.baicizhan.main.auth.ThirdPartyUserInfo;
import com.baicizhan.store.api.KdtApiProtocol;
//import com.tencent.android.tpush.common.MessageKey;
import java.util.HashMap;
import java.util.Map;
import p012ch.qos.logback.classic.pattern.CallerDataConverter;
import p012ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import p012ch.qos.logback.classic.pattern.ContextNameConverter;
import p012ch.qos.logback.classic.pattern.DateConverter;
import p012ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import p012ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import p012ch.qos.logback.classic.pattern.FileOfCallerConverter;
import p012ch.qos.logback.classic.pattern.LevelConverter;
import p012ch.qos.logback.classic.pattern.LineOfCallerConverter;
import p012ch.qos.logback.classic.pattern.LineSeparatorConverter;
import p012ch.qos.logback.classic.pattern.LocalSequenceNumberConverter;
import p012ch.qos.logback.classic.pattern.LoggerConverter;
import p012ch.qos.logback.classic.pattern.MDCConverter;
import p012ch.qos.logback.classic.pattern.MarkerConverter;
import p012ch.qos.logback.classic.pattern.MessageConverter;
import p012ch.qos.logback.classic.pattern.MethodOfCallerConverter;
import p012ch.qos.logback.classic.pattern.NopThrowableInformationConverter;
import p012ch.qos.logback.classic.pattern.PropertyConverter;
import p012ch.qos.logback.classic.pattern.RelativeTimeConverter;
import p012ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import p012ch.qos.logback.classic.pattern.ThreadConverter;
import p012ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.pattern.PatternLayoutBase;
import p012ch.qos.logback.core.pattern.parser.Parser;
import p012ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* renamed from: ch.qos.logback.classic.PatternLayout */
public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {
    public static final Map<String, String> defaultConverterMap;

    static {
        HashMap hashMap = new HashMap();
        defaultConverterMap = hashMap;
        hashMap.putAll(Parser.DEFAULT_COMPOSITE_CONVERTER_MAP);
        defaultConverterMap.put(DateTokenConverter.CONVERTER_KEY, DateConverter.class.getName());
//        defaultConverterMap.put(MessageKey.MSG_DATE, DateConverter.class.getName());
        defaultConverterMap.put("r", RelativeTimeConverter.class.getName());
        defaultConverterMap.put("relative", RelativeTimeConverter.class.getName());
        defaultConverterMap.put("level", LevelConverter.class.getName());
        defaultConverterMap.put("le", LevelConverter.class.getName());
        defaultConverterMap.put("p", LevelConverter.class.getName());
        defaultConverterMap.put("t", ThreadConverter.class.getName());
        defaultConverterMap.put("thread", ThreadConverter.class.getName());
        defaultConverterMap.put("lo", LoggerConverter.class.getName());
        defaultConverterMap.put("logger", LoggerConverter.class.getName());
        defaultConverterMap.put("c", LoggerConverter.class.getName());
        defaultConverterMap.put(ThirdPartyUserInfo.GENDER_MALE, MessageConverter.class.getName());
        defaultConverterMap.put("msg", MessageConverter.class.getName());
        defaultConverterMap.put("message", MessageConverter.class.getName());
        defaultConverterMap.put("C", ClassOfCallerConverter.class.getName());
        defaultConverterMap.put(Action.CLASS_ATTRIBUTE, ClassOfCallerConverter.class.getName());
        defaultConverterMap.put("M", MethodOfCallerConverter.class.getName());
        defaultConverterMap.put(KdtApiProtocol.METHOD_KEY, MethodOfCallerConverter.class.getName());
        defaultConverterMap.put("L", LineOfCallerConverter.class.getName());
        defaultConverterMap.put("line", LineOfCallerConverter.class.getName());
        defaultConverterMap.put("F", FileOfCallerConverter.class.getName());
        defaultConverterMap.put(Action.FILE_ATTRIBUTE, FileOfCallerConverter.class.getName());
        defaultConverterMap.put("X", MDCConverter.class.getName());
        defaultConverterMap.put("mdc", MDCConverter.class.getName());
        defaultConverterMap.put("ex", ThrowableProxyConverter.class.getName());
        defaultConverterMap.put("exception", ThrowableProxyConverter.class.getName());
        defaultConverterMap.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
        defaultConverterMap.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
        defaultConverterMap.put("throwable", ThrowableProxyConverter.class.getName());
        defaultConverterMap.put("xEx", ExtendedThrowableProxyConverter.class.getName());
        defaultConverterMap.put("xException", ExtendedThrowableProxyConverter.class.getName());
        defaultConverterMap.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());
        defaultConverterMap.put("nopex", NopThrowableInformationConverter.class.getName());
        defaultConverterMap.put("nopexception", NopThrowableInformationConverter.class.getName());
        defaultConverterMap.put("cn", ContextNameConverter.class.getName());
        defaultConverterMap.put("contextName", ContextNameConverter.class.getName());
        defaultConverterMap.put("caller", CallerDataConverter.class.getName());
        defaultConverterMap.put("marker", MarkerConverter.class.getName());
        defaultConverterMap.put("property", PropertyConverter.class.getName());
        defaultConverterMap.put("n", LineSeparatorConverter.class.getName());
        defaultConverterMap.put("lsn", LocalSequenceNumberConverter.class.getName());
    }

    public PatternLayout() {
        this.postCompileProcessor = new EnsureExceptionHandling();
    }

    public Map<String, String> getDefaultConverterMap() {
        return defaultConverterMap;
    }

    public String doLayout(ILoggingEvent iLoggingEvent) {
        if (!isStarted()) {
            return "";
        }
        return writeLoopOnConverters(iLoggingEvent);
    }
}
