package p012ch.qos.logback.classic.turbo;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: ch.qos.logback.classic.turbo.LRUMessageCache */
class LRUMessageCache extends LinkedHashMap<String, Integer> {
    private static final long serialVersionUID = 1;
    final int cacheSize;

    LRUMessageCache(int i) {
        super((int) (((float) i) * 1.3333334f), 0.75f, true);
        if (i <= 0) {
            throw new IllegalArgumentException("Cache size cannot be smaller than 1");
        }
        this.cacheSize = i;
    }

    /* access modifiers changed from: 0000 */
    public int getMessageCountAndThenIncrement(String str) {
        Integer valueOf;
        if (str == null) {
            return 0;
        }
        synchronized (this) {
            Integer num = (Integer) super.get(str);
            if (num == null) {
                valueOf = Integer.valueOf(0);
            } else {
                valueOf = Integer.valueOf(num.intValue() + 1);
            }
            super.put(str, valueOf);
        }
        return valueOf.intValue();
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Entry entry) {
        return size() > this.cacheSize;
    }

    public synchronized void clear() {
        super.clear();
    }
}
