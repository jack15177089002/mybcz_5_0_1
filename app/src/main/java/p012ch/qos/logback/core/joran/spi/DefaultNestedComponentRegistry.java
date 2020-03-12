package p012ch.qos.logback.core.joran.spi;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry */
public class DefaultNestedComponentRegistry {
    Map<HostClassAndPropertyDouble, Class<?>> defaultComponentMap = new HashMap();

    public void add(Class<?> cls, String str, Class<?> cls2) {
        this.defaultComponentMap.put(new HostClassAndPropertyDouble(cls, str.toLowerCase()), cls2);
    }

    public Class<?> findDefaultComponentType(Class<?> cls, String str) {
        String lowerCase = str.toLowerCase();
        while (cls != null) {
            Class<?> oneShotFind = oneShotFind(cls, lowerCase);
            if (oneShotFind != null) {
                return oneShotFind;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private Class<?> oneShotFind(Class<?> cls, String str) {
        return (Class) this.defaultComponentMap.get(new HostClassAndPropertyDouble(cls, str));
    }
}
