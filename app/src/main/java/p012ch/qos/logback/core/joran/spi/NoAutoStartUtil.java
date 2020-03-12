package p012ch.qos.logback.core.joran.spi;

/* renamed from: ch.qos.logback.core.joran.spi.NoAutoStartUtil */
public class NoAutoStartUtil {
    public static boolean notMarkedWithNoAutoStart(Object obj) {
        if (obj == null) {
            return false;
        }
        return ((NoAutoStart) obj.getClass().getAnnotation(NoAutoStart.class)) == null;
    }
}
