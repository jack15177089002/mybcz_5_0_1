package com.tonicartos.widget.stickygridheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tonicartos.widget.stickygridheaders.t */
public final class StickyGridHeadersSimpleAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public StickyGridHeadersSimpleAdapter f5394a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C2016v> f5395b;

    public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter sVar) {
        this.f5394a = sVar;
        sVar.registerDataSetObserver(new C2015u(this, 0));
        this.f5395b = mo18259a(sVar);
    }

    public final int getCount() {
        return this.f5394a.getCount();
    }

    public final int getCountForHeader(int i) {
        return ((C2016v) this.f5395b.get(i)).f5397a;
    }

    public final View getHeaderView(int i, View view, ViewGroup viewGroup) {
        StickyGridHeadersSimpleAdapter sVar = this.f5394a;
        this.f5395b.get(i);
        return sVar.mo18258b();
    }

    public final Object getItem(int i) {
        return this.f5394a.getItem(i);
    }

    public final long getItemId(int i) {
        return this.f5394a.getItemId(i);
    }

    public final int getNumHeaders() {
        return this.f5395b.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.f5394a.getView(i, view, viewGroup);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final List<C2016v> mo18259a(StickyGridHeadersSimpleAdapter sVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sVar.getCount()) {
                return arrayList;
            }
            long a = sVar.mo18257a();
            C2016v vVar = (C2016v) hashMap.get(Long.valueOf(a));
            if (vVar == null) {
                vVar = new C2016v(this, i2);
                arrayList.add(vVar);
            }
            vVar.f5397a++;
            hashMap.put(Long.valueOf(a), vVar);
            i = i2 + 1;
        }
    }
}
