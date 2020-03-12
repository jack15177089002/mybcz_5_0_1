package p012ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker */
public abstract class AbstractComponentTracker<C> implements ComponentTracker<C> {
    private static final boolean ACCESS_ORDERED = true;
    public static final long LINGERING_TIMEOUT = 10000;
    public static final long WAIT_BETWEEN_SUCCESSIVE_REMOVAL_ITERATIONS = 1000;
    private RemovalPredicator<C> byExcedent = new RemovalPredicator<C>() {
        public boolean isSlatedForRemoval(Entry<C> entry, long j) {
            return AbstractComponentTracker.this.liveMap.size() > AbstractComponentTracker.this.maxComponents;
        }
    };
    private RemovalPredicator<C> byLingering = new RemovalPredicator<C>() {
        public boolean isSlatedForRemoval(Entry<C> entry, long j) {
            return AbstractComponentTracker.this.isEntryDoneLingering(entry, j);
        }
    };
    private RemovalPredicator<C> byTimeout = new RemovalPredicator<C>() {
        public boolean isSlatedForRemoval(Entry<C> entry, long j) {
            return AbstractComponentTracker.this.isEntryStale(entry, j);
        }
    };
    long lastCheck = 0;
    LinkedHashMap<String, Entry<C>> lingerersMap = new LinkedHashMap<>(16, 0.75f, true);
    LinkedHashMap<String, Entry<C>> liveMap = new LinkedHashMap<>(32, 0.75f, true);
    protected int maxComponents = Integer.MAX_VALUE;
    protected long timeout = 1800000;

    /* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker$Entry */
    static class Entry<C> {
        C component;
        String key;
        long timestamp;

        Entry(String str, C c, long j) {
            this.key = str;
            this.component = c;
            this.timestamp = j;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.key == null) {
                if (entry.key != null) {
                    return false;
                }
            } else if (!this.key.equals(entry.key)) {
                return false;
            }
            if (this.component == null) {
                if (entry.component != null) {
                    return false;
                }
                return true;
            } else if (!this.component.equals(entry.component)) {
                return false;
            } else {
                return true;
            }
        }

        public String toString() {
            return "(" + this.key + ", " + this.component + ")";
        }
    }

    /* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker$RemovalPredicator */
    interface RemovalPredicator<C> {
        boolean isSlatedForRemoval(Entry<C> entry, long j);
    }

    public abstract C buildComponent(String str);

    public abstract boolean isComponentStale(C c);

    public abstract void processPriorToRemoval(C c);

    public int getComponentCount() {
        return this.liveMap.size() + this.lingerersMap.size();
    }

    private Entry<C> getFromEitherMap(String str) {
        Entry<C> entry = (Entry) this.liveMap.get(str);
        return entry != null ? entry : (Entry) this.lingerersMap.get(str);
    }

    public synchronized C find(String str) {
        C c;
        Entry fromEitherMap = getFromEitherMap(str);
        if (fromEitherMap == null) {
            c = null;
        } else {
            c = (C) fromEitherMap.component;
        }
        return c;
    }

    public synchronized C getOrCreate(String str, long j) {
        Entry fromEitherMap;
        fromEitherMap = getFromEitherMap(str);
        if (fromEitherMap == null) {
            fromEitherMap = new Entry(str, buildComponent(str), j);
            this.liveMap.put(str, fromEitherMap);
        } else {
            fromEitherMap.setTimestamp(j);
        }
        return (C) fromEitherMap.component;
    }

    public void endOfLife(String str) {
        Entry entry = (Entry) this.liveMap.remove(str);
        if (entry != null) {
            this.lingerersMap.put(str, entry);
        }
    }

    public synchronized void removeStaleComponents(long j) {
        if (!isTooSoonForRemovalIteration(j)) {
            removeExcedentComponents();
            removeStaleComponentsFromMainMap(j);
            removeStaleComponentsFromLingerersMap(j);
        }
    }

    private void removeExcedentComponents() {
        genericStaleComponentRemover(this.liveMap, 0, this.byExcedent);
    }

    private void removeStaleComponentsFromMainMap(long j) {
        genericStaleComponentRemover(this.liveMap, j, this.byTimeout);
    }

    private void removeStaleComponentsFromLingerersMap(long j) {
        genericStaleComponentRemover(this.lingerersMap, j, this.byLingering);
    }

    private void genericStaleComponentRemover(LinkedHashMap<String, Entry<C>> linkedHashMap, long j, RemovalPredicator<C> removalPredicator) {
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) ((java.util.Map.Entry) it.next()).getValue();
            if (removalPredicator.isSlatedForRemoval(entry, j)) {
                it.remove();
                processPriorToRemoval((C) entry.component);
            } else {
                return;
            }
        }
    }

    private boolean isTooSoonForRemovalIteration(long j) {
        if (this.lastCheck + 1000 > j) {
            return true;
        }
        this.lastCheck = j;
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isEntryStale(Entry<C> entry, long j) {
        if (!isComponentStale(entry.component) && entry.timestamp + this.timeout >= j) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isEntryDoneLingering(Entry entry, long j) {
        return entry.timestamp + LINGERING_TIMEOUT < j;
    }

    public Set<String> allKeys() {
        HashSet hashSet = new HashSet(this.liveMap.keySet());
        hashSet.addAll(this.lingerersMap.keySet());
        return hashSet;
    }

    public Collection<C> allComponents() {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.liveMap.values()) {
            arrayList.add(entry.component);
        }
        for (Entry entry2 : this.lingerersMap.values()) {
            arrayList.add(entry2.component);
        }
        return arrayList;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setTimeout(long j) {
        this.timeout = j;
    }

    public int getMaxComponents() {
        return this.maxComponents;
    }

    public void setMaxComponents(int i) {
        this.maxComponents = i;
    }
}
