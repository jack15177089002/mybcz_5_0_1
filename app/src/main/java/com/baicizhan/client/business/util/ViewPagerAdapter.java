package com.baicizhan.client.business.util;

import androidx.viewpager.widget.PagerAdapter;//import android.support.p004v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ViewPagerAdapter extends PagerAdapter {
    private List<View> mPageViewPool = new ArrayList();
    private SparseArray<View> mPageViews = new SparseArray<>();

    public abstract View getView(View view, int i);

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = getView(pullViewFromPool(), i);
        this.mPageViews.put(i, view);
        viewGroup.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) this.mPageViews.get(i);
        pushViewToPool(view);
        viewGroup.removeView(view);
    }

    private View pullViewFromPool() {
        View view = null;
        Iterator it = this.mPageViewPool.iterator();
        if (it.hasNext()) {
            view = (View) it.next();
        }
        if (view != null) {
            this.mPageViewPool.remove(view);
        }
        return view;
    }

    private void pushViewToPool(View view) {
        if (!this.mPageViewPool.contains(view)) {
            this.mPageViewPool.add(view);
        }
    }
}
