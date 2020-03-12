package com.baicizhan.client.business.util;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

    public interface Filter<T> {
        boolean filter(T t);
    }

    public interface Mapper<T, R> {
        R map(T t);
    }

    public interface Processor<T> {
        void process(T t);
    }

    public interface Reducer<T, R> {
        R reduce(R r, T t);
    }

    private CollectionUtils() {
    }

    public static <T> void foreach(Collection<T> collection, Processor<T> processor) {
        if (!isEmpty(collection)) {
            foreach(collection.iterator(), processor);
        }
    }

    public static <T> void foreach(Iterator<T> it, Processor<T> processor) {
        if (it != null && it.hasNext()) {
            while (it.hasNext()) {
                processor.process(it.next());
            }
        }
    }

    public static <T, R> List<R> map(Collection<T> collection, Mapper<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return map(collection.iterator(), mapper);
    }

    public static <T, R> List<R> map(Iterator<T> it, Mapper<T, R> mapper) {
        if (it == null || !it.hasNext()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(mapper.map(it.next()));
        }
        return arrayList;
    }

    public static <T, R> R reduce(Collection<T> collection, Reducer<T, R> reducer, R r) {
        return isEmpty(collection) ? r : reduce(collection.iterator(), reducer, r);
    }

    public static <T, R> R reduce(Iterator<T> it, Reducer<T, R> reducer, R r) {
        while (it.hasNext()) {
            r = reducer.reduce(r, it.next());
        }
        return r;
    }

    public static <T> List<T> filter(Collection<T> collection, Filter<T> filter) {
        if (collection == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (T next : collection) {
            if (filter.filter(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filter(Iterator<T> it, Filter<T> filter) {
        if (it == null || !it.hasNext()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            T next = it.next();
            if (filter.filter(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> void filterInPlace(Iterator<T> it, Filter<T> filter, Collection<T> collection) {
        if (it != null && it.hasNext()) {
            while (it.hasNext()) {
                T next = it.next();
                if (!filter.filter(next)) {
                    it.remove();
                    if (collection != null) {
                        collection.add(next);
                    }
                }
            }
        }
    }

    public static <T> int count(Collection<T> collection, Filter<T> filter) {
        if (isEmpty(collection)) {
            return 0;
        }
        return count(collection.iterator(), filter);
    }

    public static <T> int count(Iterator<T> it, Filter<T> filter) {
        int i = 0;
        if (it != null && it.hasNext()) {
            while (it.hasNext()) {
                if (filter.filter(it.next())) {
                    i++;
                }
            }
        }
        return i;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static <T> List<T> sparseArrayToList(SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            Object valueAt = sparseArray.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }
}
