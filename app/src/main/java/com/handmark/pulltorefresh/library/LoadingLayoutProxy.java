package com.handmark.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.p057a.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.handmark.pulltorefresh.library.b */
public final class LoadingLayoutProxy implements ILoadingLayout {

    /* renamed from: a */
    private final HashSet<LoadingLayout> f3847a = new HashSet<>();

    LoadingLayoutProxy() {
    }

    /* renamed from: a */
    public final void mo16404a(LoadingLayout fVar) {
        if (fVar != null) {
            this.f3847a.add(fVar);
        }
    }

    public final void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator it = this.f3847a.iterator();
        while (it.hasNext()) {
            ((LoadingLayout) it.next()).setLastUpdatedLabel(charSequence);
        }
    }

    public final void setLoadingDrawable(Drawable drawable) {
        Iterator it = this.f3847a.iterator();
        while (it.hasNext()) {
            ((LoadingLayout) it.next()).setLoadingDrawable(drawable);
        }
    }

    public final void setRefreshingLabel(CharSequence charSequence) {
        Iterator it = this.f3847a.iterator();
        while (it.hasNext()) {
            ((LoadingLayout) it.next()).setRefreshingLabel(charSequence);
        }
    }

    public final void setPullLabel(CharSequence charSequence) {
        Iterator it = this.f3847a.iterator();
        while (it.hasNext()) {
            ((LoadingLayout) it.next()).setPullLabel(charSequence);
        }
    }

    public final void setReleaseLabel(CharSequence charSequence) {
        Iterator it = this.f3847a.iterator();
        while (it.hasNext()) {
            ((LoadingLayout) it.next()).setReleaseLabel(charSequence);
        }
    }
}
