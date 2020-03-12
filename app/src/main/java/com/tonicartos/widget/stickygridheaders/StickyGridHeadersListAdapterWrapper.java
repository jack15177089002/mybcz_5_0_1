package com.tonicartos.widget.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* renamed from: com.tonicartos.widget.stickygridheaders.q */
public final class StickyGridHeadersListAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {

    /* renamed from: a */
    private ListAdapter f5391a;

    /* renamed from: b */
    private DataSetObserver f5392b = new C2014r(this);

    public StickyGridHeadersListAdapterWrapper(ListAdapter listAdapter) {
        this.f5391a = listAdapter;
        listAdapter.registerDataSetObserver(this.f5392b);
    }

    public final int getCount() {
        return this.f5391a.getCount();
    }

    public final Object getItem(int i) {
        return this.f5391a.getItem(i);
    }

    public final long getItemId(int i) {
        return this.f5391a.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.f5391a.getView(i, view, viewGroup);
    }

    public final int getCountForHeader(int i) {
        return 0;
    }

    public final int getNumHeaders() {
        return 0;
    }

    public final View getHeaderView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
