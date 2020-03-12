package com.p013a.p014a.p015a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p013a.p014a.SwipeLayout;
import com.p013a.p014a.p016b.C0433e;
import com.p013a.p014a.p016b.SwipeItemMangerImpl;
import com.p013a.p014a.p017c.SwipeAdapterInterface;
import com.p013a.p014a.p017c.SwipeItemMangerInterface;
import java.util.List;

/* renamed from: com.a.a.a.a */
public abstract class BaseSwipeAdapter extends BaseAdapter implements SwipeAdapterInterface, SwipeItemMangerInterface {
    protected SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);

    public abstract void fillValues(int i, View view);

    public abstract View generateView(int i, ViewGroup viewGroup);

    public abstract int getSwipeLayoutResourceId(int i);

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = generateView(i, viewGroup);
            this.mItemManger.mo2847a(view, i);
        } else {
            int b = this.mItemManger.mo2849b(i);
            SwipeLayout bVar = (SwipeLayout) view.findViewById(b);
            if (bVar == null) {
                throw new IllegalStateException("can not find SwipeLayout in target view");
            }
            C0433e eVar = (C0433e) bVar.getTag(b);
            eVar.f1690b.f1687a = i;
            eVar.f1689a.f1685a = i;
            eVar.f1691c = i;
        }
        fillValues(i, view);
        return view;
    }

    public void openItem(int i) {
        this.mItemManger.mo2852c(i);
    }

    public void closeItem(int i) {
        this.mItemManger.mo2853d(i);
    }

    public void closeAllExcept(SwipeLayout bVar) {
        this.mItemManger.mo2848a(bVar);
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.mo2845a();
    }

    public List<SwipeLayout> getOpenLayouts() {
        return this.mItemManger.mo2850b();
    }

    public void removeShownLayouts(SwipeLayout bVar) {
        this.mItemManger.mo2851b(bVar);
    }

    public boolean isOpen(int i) {
        return this.mItemManger.mo2854e(i);
    }

    public int getMode$19ce7878() {
        return this.mItemManger.f1676a;
    }

    public void setMode$4942d582(int i) {
        this.mItemManger.mo2846a(i);
    }
}
