package p012ch.qos.logback.classic.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

/* renamed from: ch.qos.logback.classic.util.LogbackMDCAdapter */
public final class LogbackMDCAdapter implements MDCAdapter {
    private static final int READ_OPERATION = 2;
    private static final int WRITE_OPERATION = 1;
    final InheritableThreadLocal<Map<String, String>> copyOnInheritThreadLocal = new InheritableThreadLocal<>();
    final ThreadLocal<Integer> lastOperation = new ThreadLocal<>();

    private Integer getAndSetLastOperation(int i) {
        Integer num = (Integer) this.lastOperation.get();
        this.lastOperation.set(Integer.valueOf(i));
        return num;
    }

    private boolean wasLastOpReadOrNull(Integer num) {
        return num == null || num.intValue() == 2;
    }

    private Map<String, String> duplicateAndInsertNewMap(Map<String, String> map) {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            synchronized (map) {
                synchronizedMap.putAll(map);
            }
        }
        this.copyOnInheritThreadLocal.set(synchronizedMap);
        return synchronizedMap;
    }

    public final void put(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map map = (Map) this.copyOnInheritThreadLocal.get();
        if (wasLastOpReadOrNull(getAndSetLastOperation(1)) || map == null) {
            duplicateAndInsertNewMap(map).put(str, str2);
        } else {
            map.put(str, str2);
        }
    }

    public final void remove(String str) {
        if (str != null) {
            Map map = (Map) this.copyOnInheritThreadLocal.get();
            if (map == null) {
                return;
            }
            if (wasLastOpReadOrNull(getAndSetLastOperation(1))) {
                duplicateAndInsertNewMap(map).remove(str);
            } else {
                map.remove(str);
            }
        }
    }

    public final void clear() {
        this.lastOperation.set(Integer.valueOf(1));
        this.copyOnInheritThreadLocal.remove();
    }

    public final String get(String str) {
        Map propertyMap = getPropertyMap();
        if (propertyMap == null || str == null) {
            return null;
        }
        return (String) propertyMap.get(str);
    }

    public final Map<String, String> getPropertyMap() {
        this.lastOperation.set(Integer.valueOf(2));
        return (Map) this.copyOnInheritThreadLocal.get();
    }

    public final Set<String> getKeys() {
        Map propertyMap = getPropertyMap();
        if (propertyMap != null) {
            return propertyMap.keySet();
        }
        return null;
    }

    public final Map getCopyOfContextMap() {
        this.lastOperation.set(Integer.valueOf(2));
        Map map = (Map) this.copyOnInheritThreadLocal.get();
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    public final void setContextMap(Map map) {
        this.lastOperation.set(Integer.valueOf(1));
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        synchronizedMap.putAll(map);
        this.copyOnInheritThreadLocal.set(synchronizedMap);
    }
}
