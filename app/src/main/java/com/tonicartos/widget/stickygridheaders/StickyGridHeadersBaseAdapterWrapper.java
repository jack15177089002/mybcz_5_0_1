package com.tonicartos.widget.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tonicartos.widget.stickygridheaders.b */
public final class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {

    /* renamed from: d */
    private static boolean f5359d;

    /* renamed from: a */
    final StickyGridHeadersBaseAdapter f5360a;

    /* renamed from: b */
    int f5361b;

    /* renamed from: c */
    int f5362c = 1;

    /* renamed from: e */
    private final Context f5363e;

    /* renamed from: f */
    private DataSetObserver f5364f = new C2000c(this);

    /* renamed from: g */
    private StickyGridHeadersGridView f5365g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<View> f5366h = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View[] f5367i;

    public StickyGridHeadersBaseAdapterWrapper(Context context, StickyGridHeadersGridView stickyGridHeadersGridView, StickyGridHeadersBaseAdapter aVar) {
        this.f5363e = context;
        this.f5360a = aVar;
        this.f5365g = stickyGridHeadersGridView;
        aVar.registerDataSetObserver(this.f5364f);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        this.f5361b = 0;
        int numHeaders = this.f5360a.getNumHeaders();
        if (numHeaders == 0) {
            return this.f5360a.getCount();
        }
        for (int i = 0; i < numHeaders; i++) {
            this.f5361b += this.f5360a.getCountForHeader(i) + m5113e(i) + this.f5362c;
        }
        return this.f5361b;
    }

    public final Object getItem(int i) {
        C2003f c = mo18211c(i);
        if (c.f5374b == -1 || c.f5374b == -2) {
            return null;
        }
        return this.f5360a.getItem(c.f5374b);
    }

    public final long getItemId(int i) {
        C2003f c = mo18211c(i);
        if (c.f5374b == -2) {
            return -1;
        }
        if (c.f5374b == -1) {
            return -2;
        }
        return this.f5360a.getItemId(c.f5374b);
    }

    public final int getItemViewType(int i) {
        C2003f c = mo18211c(i);
        if (c.f5374b == -2) {
            return 1;
        }
        if (c.f5374b == -1) {
            return 0;
        }
        int itemViewType = this.f5360a.getItemViewType(c.f5374b);
        return itemViewType != -1 ? itemViewType + 2 : itemViewType;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v3, types: [com.tonicartos.widget.stickygridheaders.d] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.tonicartos.widget.stickygridheaders.d] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int r8, View r9, ViewGroup r10) {
        /*
            r7 = this;
            r2 = 0
            r3 = 1
            r6 = 0
            boolean r0 = r9 instanceof com.tonicartos.widget.stickygridheaders.C2004g
            if (r0 == 0) goto L_0x00b7
            com.tonicartos.widget.stickygridheaders.g r9 = (com.tonicartos.widget.stickygridheaders.C2004g) r9
            android.view.View r0 = r9.getChildAt(r6)
        L_0x000d:
            com.tonicartos.widget.stickygridheaders.f r4 = r7.mo18211c(r8)
            int r1 = r4.f5374b
            r5 = -2
            if (r1 != r5) goto L_0x0079
            com.tonicartos.widget.stickygridheaders.e r1 = new com.tonicartos.widget.stickygridheaders.e
            android.content.Context r0 = r7.f5363e
            r1.<init>(r7, r0)
            com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView r0 = r7.f5365g
            int r0 = r0.getWidth()
            r1.setHeaderWidth(r0)
            r0 = r1
            com.tonicartos.widget.stickygridheaders.e r0 = (com.tonicartos.widget.stickygridheaders.C2002e) r0
            int r5 = r4.f5373a
            r0.setHeaderId(r5)
            java.lang.Object r0 = r1.getTag()
            android.view.View r0 = (android.view.View) r0
            com.tonicartos.widget.stickygridheaders.a r5 = r7.f5360a
            int r4 = r4.f5373a
            android.view.View r0 = r5.getHeaderView(r4, r0, r10)
            r1.setTag(r0)
        L_0x003f:
            if (r9 != 0) goto L_0x0048
            com.tonicartos.widget.stickygridheaders.g r9 = new com.tonicartos.widget.stickygridheaders.g
            android.content.Context r0 = r7.f5363e
            r9.<init>(r7, r0)
        L_0x0048:
            r9.removeAllViews()
            r9.addView(r1)
            r9.setPosition(r8)
            int r0 = r7.f5362c
            r9.setNumColumns(r0)
            android.view.View[] r0 = r7.f5367i
            int r1 = r7.f5362c
            int r1 = r8 % r1
            r0[r1] = r9
            int r0 = r7.f5362c
            int r0 = r8 % r0
            if (r0 != 0) goto L_0x0096
            f5359d = r3
            r0 = r3
        L_0x0067:
            android.view.View[] r1 = r7.f5367i
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0094
            android.view.View[] r1 = r7.f5367i
            int r3 = r8 + r0
            android.view.View r3 = r7.getView(r3, r2, r10)
            r1[r0] = r3
            int r0 = r0 + 1
            goto L_0x0067
        L_0x0079:
            int r1 = r4.f5374b
            r5 = -1
            if (r1 != r5) goto L_0x008b
            com.tonicartos.widget.stickygridheaders.d r0 = (com.tonicartos.widget.stickygridheaders.C2001d) r0
            if (r0 != 0) goto L_0x0089
            com.tonicartos.widget.stickygridheaders.d r0 = new com.tonicartos.widget.stickygridheaders.d
            android.content.Context r1 = r7.f5363e
            r0.<init>(r7, r1)
        L_0x0089:
            r1 = r0
            goto L_0x003f
        L_0x008b:
            com.tonicartos.widget.stickygridheaders.a r1 = r7.f5360a
            int r4 = r4.f5374b
            android.view.View r1 = r1.getView(r4, r0, r10)
            goto L_0x003f
        L_0x0094:
            f5359d = r6
        L_0x0096:
            android.view.View[] r0 = r7.f5367i
            r9.setRowSiblings(r0)
            boolean r0 = f5359d
            if (r0 != 0) goto L_0x00b6
            int r0 = r7.f5362c
            int r0 = r8 % r0
            int r1 = r7.f5362c
            int r1 = r1 + -1
            if (r0 == r1) goto L_0x00b1
            int r0 = r7.getCount()
            int r0 = r0 + -1
            if (r8 != r0) goto L_0x00b6
        L_0x00b1:
            int r0 = r7.f5362c
            r7.m5112d(r0)
        L_0x00b6:
            return r9
        L_0x00b7:
            r0 = r9
            r9 = r2
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final int getViewTypeCount() {
        return this.f5360a.getViewTypeCount() + 2;
    }

    public final boolean hasStableIds() {
        return this.f5360a.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.f5360a.isEmpty();
    }

    public final boolean isEnabled(int i) {
        C2003f c = mo18211c(i);
        if (c.f5374b == -1 || c.f5374b == -2) {
            return false;
        }
        return this.f5360a.isEnabled(c.f5374b);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f5360a.registerDataSetObserver(dataSetObserver);
    }

    /* renamed from: a */
    public final void mo18208a(int i) {
        this.f5362c = i;
        m5112d(i);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f5360a.unregisterDataSetObserver(dataSetObserver);
    }

    /* renamed from: d */
    private void m5112d(int i) {
        this.f5367i = new View[i];
        Arrays.fill(this.f5367i, null);
    }

    /* renamed from: e */
    private int m5113e(int i) {
        int countForHeader = this.f5360a.getCountForHeader(i) % this.f5362c;
        if (countForHeader == 0) {
            return 0;
        }
        return this.f5362c - countForHeader;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final long mo18210b(int i) {
        return (long) mo18211c(i).f5373a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo18207a(int i, View view, ViewGroup viewGroup) {
        if (this.f5360a.getNumHeaders() == 0) {
            return null;
        }
        return this.f5360a.getHeaderView(mo18211c(i).f5373a, view, viewGroup);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final C2003f mo18211c(int i) {
        int i2 = 0;
        int numHeaders = this.f5360a.getNumHeaders();
        if (numHeaders != 0) {
            int i3 = i;
            while (i2 < numHeaders) {
                int countForHeader = this.f5360a.getCountForHeader(i2);
                if (i3 == 0) {
                    return new C2003f(this, -2, i2);
                }
                int i4 = i3 - this.f5362c;
                if (i4 < 0) {
                    return new C2003f(this, -1, i2);
                }
                int i5 = i - this.f5362c;
                if (i4 < countForHeader) {
                    return new C2003f(this, i5, i2);
                }
                int e = m5113e(i2);
                i = i5 - e;
                i2++;
                i3 = i4 - (countForHeader + e);
            }
            return new C2003f(this, -1, i2);
        } else if (i >= this.f5360a.getCount()) {
            return new C2003f(this, -1, 0);
        } else {
            return new C2003f(this, i, 0);
        }
    }
}
