package p012ch.qos.logback.core.joran.action;

import java.util.Properties;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.util.ContextUtil;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.ActionUtil */
public class ActionUtil {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope;

    /* renamed from: ch.qos.logback.core.joran.action.ActionUtil$Scope */
    public enum Scope {
        LOCAL,
        CONTEXT,
        SYSTEM
    }

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope;
        if (iArr == null) {
            iArr = new int[Scope.values().length];
            try {
                iArr[Scope.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Scope.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Scope.SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope = iArr;
        }
        return iArr;
    }

    public static Scope stringToScope(String str) {
        if (Scope.SYSTEM.toString().equalsIgnoreCase(str)) {
            return Scope.SYSTEM;
        }
        if (Scope.CONTEXT.toString().equalsIgnoreCase(str)) {
            return Scope.CONTEXT;
        }
        return Scope.LOCAL;
    }

    public static void setProperty(InterpretationContext interpretationContext, String str, String str2, Scope scope) {
        switch ($SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope()[scope.ordinal()]) {
            case 1:
                interpretationContext.addSubstitutionProperty(str, str2);
                return;
            case 2:
                interpretationContext.getContext().putProperty(str, str2);
                return;
            case 3:
                OptionHelper.setSystemProperty(interpretationContext, str, str2);
                return;
            default:
                return;
        }
    }

    public static void setProperties(InterpretationContext interpretationContext, Properties properties, Scope scope) {
        switch ($SWITCH_TABLE$ch$qos$logback$core$joran$action$ActionUtil$Scope()[scope.ordinal()]) {
            case 1:
                interpretationContext.addSubstitutionProperties(properties);
                return;
            case 2:
                new ContextUtil(interpretationContext.getContext()).addProperties(properties);
                return;
            case 3:
                OptionHelper.setSystemProperties(interpretationContext, properties);
                return;
            default:
                return;
        }
    }
}
