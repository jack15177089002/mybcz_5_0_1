package com.p013a.p014a.p016b;

import android.view.View;
import android.widget.BaseAdapter;
import com.p013a.p014a.SwipeLayout;
import com.p013a.p014a.p017c.SwipeAdapterInterface;
import com.p013a.p014a.p017c.SwipeItemMangerInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.a.a.b.a */
public final class SwipeItemMangerImpl implements SwipeItemMangerInterface {

    /* renamed from: a */
    public int f1676a = C0430b.f1682a;

    /* renamed from: b */
    public final int f1677b = -1;

    /* renamed from: c */
    protected int f1678c = -1;

    /* renamed from: d */
    protected Set<Integer> f1679d = new HashSet();

    /* renamed from: e */
    protected Set<SwipeLayout> f1680e = new HashSet();

    /* renamed from: f */
    protected BaseAdapter f1681f;

    public SwipeItemMangerImpl(BaseAdapter baseAdapter) {
        if (baseAdapter == null) {
            throw new IllegalArgumentException("Adapter can not be null");
        } else if (!(baseAdapter instanceof SwipeItemMangerInterface)) {
            throw new IllegalArgumentException("adapter should implement the SwipeAdapterInterface");
        } else {
            this.f1681f = baseAdapter;
        }
    }

    /* renamed from: a */
    public final void mo2846a(int i) {
        this.f1676a = i;
        this.f1679d.clear();
        this.f1680e.clear();
        this.f1678c = -1;
    }

    /* renamed from: a */
    public final void mo2847a(View view, int i) {
        int b = mo2849b(i);
        C0431c cVar = new C0431c(this, i);
        SwipeLayout bVar = (SwipeLayout) view.findViewById(b);
        if (bVar == null) {
            throw new IllegalStateException("can not find SwipeLayout in target view");
        }
        C0432d dVar = new C0432d(this, i);
        bVar.addSwipeListener(dVar);
        bVar.addOnLayoutListener(cVar);
        bVar.setTag(b, new C0433e(this, i, dVar, cVar));
        this.f1680e.add(bVar);
    }

    /* renamed from: b */
    public final int mo2849b(int i) {
        return ((SwipeAdapterInterface) this.f1681f).getSwipeLayoutResourceId(i);
    }

    /* renamed from: c */
    public final void mo2852c(int i) {
        if (this.f1676a != C0430b.f1683b) {
            this.f1678c = i;
        } else if (!this.f1679d.contains(Integer.valueOf(i))) {
            this.f1679d.add(Integer.valueOf(i));
        }
        this.f1681f.notifyDataSetChanged();
    }

    /* renamed from: d */
    public final void mo2853d(int i) {
        if (this.f1676a == C0430b.f1683b) {
            this.f1679d.remove(Integer.valueOf(i));
        } else if (this.f1678c == i) {
            this.f1678c = -1;
        }
        this.f1681f.notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void mo2848a(SwipeLayout bVar) {
        for (SwipeLayout bVar2 : this.f1680e) {
            if (bVar2 != bVar) {
                bVar2.close();
            }
        }
    }

    /* renamed from: b */
    public final void mo2851b(SwipeLayout bVar) {
        this.f1680e.remove(bVar);
    }

    /* renamed from: a */
    public final List<Integer> mo2845a() {
        if (this.f1676a == C0430b.f1683b) {
            return new ArrayList(this.f1679d);
        }
        return Arrays.asList(new Integer[]{Integer.valueOf(this.f1678c)});
    }

    /* renamed from: b */
    public final List<SwipeLayout> mo2850b() {
        return new ArrayList(this.f1680e);
    }

    /* renamed from: e */
    public final boolean mo2854e(int i) {
        if (this.f1676a == C0430b.f1683b) {
            return this.f1679d.contains(Integer.valueOf(i));
        }
        return this.f1678c == i;
    }
}
