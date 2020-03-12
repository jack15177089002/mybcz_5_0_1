package kankan.wheel.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.p098a.WheelViewAdapter;

public class WheelView extends View {

    /* renamed from: a */
    boolean f5729a = false;

    /* renamed from: b */
    List<Object> f5730b = new LinkedList();

    /* renamed from: c */
    C2081g f5731c = new C2082h(this);

    /* renamed from: d */
    private int[] f5732d = {-15658735, 11184810, 11184810};

    /* renamed from: e */
    private int f5733e = 0;

    /* renamed from: f */
    private int f5734f = 5;

    /* renamed from: g */
    private int f5735g = 0;

    /* renamed from: h */
    private Drawable f5736h;

    /* renamed from: i */
    private Drawable f5737i = null;

    /* renamed from: j */
    private Drawable f5738j = null;

    /* renamed from: k */
    private GradientDrawable f5739k;

    /* renamed from: l */
    private GradientDrawable f5740l;

    /* renamed from: m */
    private boolean f5741m = true;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public WheelScroller f5742n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f5743o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f5744p;

    /* renamed from: q */
    private LinearLayout f5745q;

    /* renamed from: r */
    private int f5746r;

    /* renamed from: s */
    private WheelViewAdapter f5747s;

    /* renamed from: t */
    private WheelRecycle f5748t = new WheelRecycle(this);

    /* renamed from: u */
    private List<OnWheelChangedListener> f5749u = new LinkedList();

    /* renamed from: v */
    private List<Object> f5750v = new LinkedList();

    /* renamed from: w */
    private DataSetObserver f5751w = new C2083i(this);

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5384a();
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5384a();
    }

    public WheelView(Context context) {
        super(context);
        m5384a();
    }

    /* renamed from: a */
    private void m5384a() {
        this.f5742n = new WheelScroller(getContext(), this.f5731c);
    }

    public void setInterpolator(Interpolator interpolator) {
        WheelScroller dVar = this.f5742n;
        dVar.f5763d.forceFinished(true);
        dVar.f5763d = new Scroller(dVar.f5761b, interpolator);
    }

    public int getVisibleItems() {
        return this.f5734f;
    }

    public void setVisibleItems(int i) {
        this.f5734f = i;
    }

    public WheelViewAdapter getViewAdapter() {
        return this.f5747s;
    }

    public void setViewAdapter(WheelViewAdapter dVar) {
        if (this.f5747s != null) {
            this.f5747s.unregisterDataSetObserver(this.f5751w);
        }
        this.f5747s = dVar;
        if (this.f5747s != null) {
            this.f5747s.registerDataSetObserver(this.f5751w);
        }
        mo18386a(true);
    }

    /* renamed from: a */
    public final void mo18385a(OnWheelChangedListener bVar) {
        this.f5749u.add(bVar);
    }

    /* renamed from: b */
    public final void mo18387b(OnWheelChangedListener bVar) {
        this.f5749u.remove(bVar);
    }

    public int getCurrentItem() {
        return this.f5733e;
    }

    private void setCurrentItem$2563266(int i) {
        if (this.f5747s != null && this.f5747s.getItemsCount() != 0) {
            int itemsCount = this.f5747s.getItemsCount();
            if (i < 0 || i >= itemsCount) {
                if (this.f5729a) {
                    while (i < 0) {
                        i += itemsCount;
                    }
                    i %= itemsCount;
                } else {
                    return;
                }
            }
            if (i != this.f5733e) {
                this.f5744p = 0;
                int i2 = this.f5733e;
                this.f5733e = i;
                int i3 = this.f5733e;
                for (OnWheelChangedListener onChanged : this.f5749u) {
                    onChanged.onChanged(this, i2, i3);
                }
                invalidate();
            }
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem$2563266(i);
    }

    public void setCyclic(boolean z) {
        this.f5729a = z;
        mo18386a(false);
    }

    public void setDrawShadows(boolean z) {
        this.f5741m = z;
    }

    public void setWheelBackground(int i) {
        this.f5737i = getContext().getResources().getDrawable(i);
        if (VERSION.SDK_INT >= 16) {
            setBackground(this.f5737i);
        } else {
            setBackgroundDrawable(this.f5737i);
        }
    }

    public void setWheelBackgroundDrawable(Drawable drawable) {
        this.f5737i = drawable;
        if (VERSION.SDK_INT >= 16) {
            setBackground(this.f5737i);
        } else {
            setBackgroundDrawable(this.f5737i);
        }
    }

    public void setWheelForeground(int i) {
        this.f5738j = getContext().getResources().getDrawable(i);
        this.f5736h = this.f5738j;
    }

    public void setWheelForegroundDrawable(Drawable drawable) {
        this.f5738j = drawable;
        this.f5736h = this.f5738j;
    }

    /* renamed from: a */
    public final void mo18386a(boolean z) {
        if (z) {
            WheelRecycle cVar = this.f5748t;
            if (cVar.f5757a != null) {
                cVar.f5757a.clear();
            }
            if (cVar.f5758b != null) {
                cVar.f5758b.clear();
            }
            if (this.f5745q != null) {
                this.f5745q.removeAllViews();
            }
            this.f5744p = 0;
        } else if (this.f5745q != null) {
            this.f5748t.mo18422a(this.f5745q, this.f5746r, new ItemsRange());
        }
        invalidate();
    }

    private int getItemHeight() {
        if (this.f5735g != 0) {
            return this.f5735g;
        }
        if (this.f5745q == null || this.f5745q.getChildAt(0) == null) {
            return getHeight() / this.f5734f;
        }
        this.f5735g = this.f5745q.getChildAt(0).getHeight();
        return this.f5735g;
    }

    /* renamed from: a */
    private int m5382a(int i, int i2) {
        if (this.f5736h == null) {
            this.f5736h = this.f5738j;
        }
        if (this.f5739k == null) {
            this.f5739k = new GradientDrawable(Orientation.TOP_BOTTOM, this.f5732d);
        }
        if (this.f5740l == null) {
            this.f5740l = new GradientDrawable(Orientation.BOTTOM_TOP, this.f5732d);
        }
        if (VERSION.SDK_INT >= 16) {
            setBackground(this.f5737i);
        } else {
            setBackgroundDrawable(this.f5737i);
        }
        this.f5745q.setLayoutParams(new LayoutParams(-2, -2));
        this.f5745q.measure(MeasureSpec.makeMeasureSpec(i, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.f5745q.getMeasuredWidth();
        if (i2 != 1073741824) {
            int max = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
            }
        }
        this.f5745q.measure(MeasureSpec.makeMeasureSpec(i - 20, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int max;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f5745q != null) {
            this.f5748t.mo18422a(this.f5745q, this.f5746r, new ItemsRange());
        } else {
            m5390b();
        }
        int i3 = this.f5734f / 2;
        for (int i4 = this.f5733e + i3; i4 >= this.f5733e - i3; i4--) {
            if (m5388a(i4, true)) {
                this.f5746r = i4;
            }
        }
        int a = m5382a(size, mode);
        if (mode2 == 1073741824) {
            max = size2;
        } else {
            LinearLayout linearLayout = this.f5745q;
            if (!(linearLayout == null || linearLayout.getChildAt(0) == null)) {
                this.f5735g = linearLayout.getChildAt(0).getMeasuredHeight();
            }
            max = Math.max((this.f5735g * this.f5734f) - ((this.f5735g * 0) / 50), getSuggestedMinimumHeight());
            if (mode2 == Integer.MIN_VALUE) {
                max = Math.min(max, size2);
            }
        }
        setMeasuredDimension(a, max);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m5391b(i3 - i, i4 - i2);
    }

    /* renamed from: b */
    private void m5391b(int i, int i2) {
        this.f5745q.layout(0, 0, i - 20, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        super.onDraw(canvas);
        if (this.f5747s != null && this.f5747s.getItemsCount() > 0) {
            ItemsRange itemsRange = getItemsRange();
            if (this.f5745q != null) {
                int a = this.f5748t.mo18422a(this.f5745q, this.f5746r, itemsRange);
                z = this.f5746r != a;
                this.f5746r = a;
            } else {
                m5390b();
                z = true;
            }
            if (!z) {
                z = (this.f5746r == itemsRange.f5752a && this.f5745q.getChildCount() == itemsRange.f5753b) ? false : true;
            }
            if (this.f5746r > itemsRange.f5752a && this.f5746r <= itemsRange.mo18405a()) {
                int i = this.f5746r;
                while (true) {
                    i--;
                    if (i < itemsRange.f5752a || !m5388a(i, true)) {
                        break;
                    }
                    this.f5746r = i;
                }
            } else {
                this.f5746r = itemsRange.f5752a;
            }
            int i2 = this.f5746r;
            for (int childCount = this.f5745q.getChildCount(); childCount < itemsRange.f5753b; childCount++) {
                if (!m5388a(this.f5746r + childCount, false) && this.f5745q.getChildCount() == 0) {
                    i2++;
                }
            }
            this.f5746r = i2;
            if (z) {
                m5382a(getWidth(), 1073741824);
                m5391b(getWidth(), getHeight());
            }
            canvas.save();
            canvas.translate(10.0f, (float) ((-(((this.f5733e - this.f5746r) * getItemHeight()) + ((getItemHeight() - getHeight()) / 2))) + this.f5744p));
            this.f5745q.draw(canvas);
            canvas.restore();
            int height = getHeight() / 2;
            int itemHeight = (int) (((double) (getItemHeight() / 2)) * 1.2d);
            if (this.f5736h != null) {
                this.f5736h.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
                this.f5736h.draw(canvas);
            }
        }
        if (this.f5741m) {
            int itemHeight2 = (int) (1.5d * ((double) getItemHeight()));
            this.f5739k.setBounds(0, 0, getWidth(), itemHeight2);
            this.f5739k.draw(canvas);
            this.f5740l.setBounds(0, getHeight() - itemHeight2, getWidth(), getHeight());
            this.f5740l.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int itemHeight;
        if (isEnabled() && getViewAdapter() != null) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (!this.f5743o) {
                        int y = ((int) motionEvent.getY()) - (getHeight() / 2);
                        if (y > 0) {
                            itemHeight = y + (getItemHeight() / 2);
                        } else {
                            itemHeight = y - (getItemHeight() / 2);
                        }
                        int itemHeight2 = itemHeight / getItemHeight();
                        if (itemHeight2 != 0 && m5387a(itemHeight2 + this.f5733e)) {
                            Iterator it = this.f5750v.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    break;
            }
            WheelScroller dVar = this.f5742n;
            switch (motionEvent.getAction()) {
                case 0:
                    dVar.f5765f = motionEvent.getY();
                    dVar.f5763d.forceFinished(true);
                    dVar.mo18425b();
                    break;
                case 2:
                    int y2 = (int) (motionEvent.getY() - dVar.f5765f);
                    if (y2 != 0) {
                        dVar.mo18427d();
                        dVar.f5760a.mo18432a(y2);
                        dVar.f5765f = motionEvent.getY();
                        break;
                    }
                    break;
            }
            if (!dVar.f5762c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                dVar.mo18426c();
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m5385a(WheelView wheelView, int i) {
        int i2;
        int i3 = 0;
        wheelView.f5744p += i;
        int itemHeight = wheelView.getItemHeight();
        int i4 = wheelView.f5744p / itemHeight;
        int i5 = wheelView.f5733e - i4;
        int itemsCount = wheelView.f5747s.getItemsCount();
        int i6 = wheelView.f5744p % itemHeight;
        if (Math.abs(i6) <= itemHeight / 2) {
            i6 = 0;
        }
        if (wheelView.f5729a && itemsCount > 0) {
            if (i6 > 0) {
                i5--;
                i2 = i4 + 1;
            } else if (i6 < 0) {
                i5++;
                i2 = i4 - 1;
            } else {
                i2 = i4;
            }
            while (i5 < 0) {
                i5 += itemsCount;
            }
            i3 = i5 % itemsCount;
        } else if (i5 < 0) {
            i2 = wheelView.f5733e;
        } else if (i5 >= itemsCount) {
            i2 = (wheelView.f5733e - itemsCount) + 1;
            i3 = itemsCount - 1;
        } else if (i5 > 0 && i6 > 0) {
            i3 = i5 - 1;
            i2 = i4 + 1;
        } else if (i5 >= itemsCount - 1 || i6 >= 0) {
            i3 = i5;
            i2 = i4;
        } else {
            i3 = i5 + 1;
            i2 = i4 - 1;
        }
        int i7 = wheelView.f5744p;
        if (i3 != wheelView.f5733e) {
            wheelView.setCurrentItem$2563266(i3);
        } else {
            wheelView.invalidate();
        }
        wheelView.f5744p = i7 - (i2 * itemHeight);
        if (wheelView.f5744p > wheelView.getHeight()) {
            wheelView.f5744p = (wheelView.f5744p % wheelView.getHeight()) + wheelView.getHeight();
        }
    }

    private ItemsRange getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.f5733e;
        int i2 = 1;
        while (getItemHeight() * i2 < getHeight()) {
            i--;
            i2 += 2;
        }
        if (this.f5744p != 0) {
            if (this.f5744p > 0) {
                i--;
            }
            int itemHeight = this.f5744p / getItemHeight();
            i -= itemHeight;
            i2 = (int) (Math.asin((double) itemHeight) + ((double) (i2 + 1)));
        }
        return new ItemsRange(i, i2);
    }

    /* renamed from: b */
    private void m5390b() {
        if (this.f5745q == null) {
            this.f5745q = new LinearLayout(getContext());
            this.f5745q.setOrientation(1);
        }
    }

    /* renamed from: a */
    private boolean m5388a(int i, boolean z) {
        View view;
        if (this.f5747s == null || this.f5747s.getItemsCount() == 0) {
            view = null;
        } else {
            int itemsCount = this.f5747s.getItemsCount();
            if (!m5387a(i)) {
                view = this.f5747s.getEmptyItem(WheelRecycle.m5398a(this.f5748t.f5758b), this.f5745q);
            } else {
                while (i < 0) {
                    i += itemsCount;
                }
                view = this.f5747s.getItem(i % itemsCount, WheelRecycle.m5398a(this.f5748t.f5757a), this.f5745q);
            }
        }
        if (view == null) {
            return false;
        }
        if (z) {
            this.f5745q.addView(view, 0);
        } else {
            this.f5745q.addView(view);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m5387a(int i) {
        return this.f5747s != null && this.f5747s.getItemsCount() > 0 && (this.f5729a || (i >= 0 && i < this.f5747s.getItemsCount()));
    }
}
