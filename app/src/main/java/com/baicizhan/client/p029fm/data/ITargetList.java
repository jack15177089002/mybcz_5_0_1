package com.baicizhan.client.p029fm.data;

/* renamed from: com.baicizhan.client.fm.data.ITargetList */
public interface ITargetList<E> {
    void clear();

    void extractOfflines();

    E get(int i);

    String getLocalPath(int i);

    String getPath(int i, boolean z);

    String getSavedPath(int i, boolean z);

    boolean isEmpty();

    int size();
}
