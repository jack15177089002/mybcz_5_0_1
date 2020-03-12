package p012ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p012ch.qos.logback.core.filter.Filter;

/* renamed from: ch.qos.logback.core.spi.FilterAttachableImpl */
public final class FilterAttachableImpl<E> implements FilterAttachable<E> {
    CopyOnWriteArrayList<Filter<E>> filterList = new CopyOnWriteArrayList<>();

    public final void addFilter(Filter<E> filter) {
        this.filterList.add(filter);
    }

    public final void clearAllFilters() {
        this.filterList.clear();
    }

    public final FilterReply getFilterChainDecision(E e) {
        Iterator it = this.filterList.iterator();
        while (it.hasNext()) {
            FilterReply decide = ((Filter) it.next()).decide(e);
            if (decide == FilterReply.DENY) {
                return decide;
            }
            if (decide == FilterReply.ACCEPT) {
                return decide;
            }
        }
        return FilterReply.NEUTRAL;
    }

    public final List<Filter<E>> getCopyOfAttachedFiltersList() {
        return new ArrayList(this.filterList);
    }
}
