package com.tonicartos.widget.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class StickyGridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {

    /* renamed from: A */
    private int f5326A;

    /* renamed from: B */
    private View f5327B;

    /* renamed from: C */
    private Runnable f5328C;

    /* renamed from: D */
    private int f5329D;

    /* renamed from: E */
    private int f5330E;

    /* renamed from: F */
    private boolean f5331F;

    /* renamed from: a */
    public C2007j f5332a;

    /* renamed from: b */
    public C2008k f5333b;

    /* renamed from: c */
    C2009l f5334c;

    /* renamed from: d */
    C2010m f5335d;

    /* renamed from: e */
    protected StickyGridHeadersBaseAdapterWrapper f5336e;

    /* renamed from: f */
    protected boolean f5337f;

    /* renamed from: g */
    protected int f5338g;

    /* renamed from: h */
    protected int f5339h;

    /* renamed from: i */
    private boolean f5340i;

    /* renamed from: j */
    private final Rect f5341j;

    /* renamed from: k */
    private boolean f5342k;

    /* renamed from: l */
    private boolean f5343l;

    /* renamed from: m */
    private int f5344m;

    /* renamed from: n */
    private long f5345n;

    /* renamed from: o */
    private DataSetObserver f5346o;

    /* renamed from: p */
    private int f5347p;

    /* renamed from: q */
    private int f5348q;

    /* renamed from: r */
    private float f5349r;

    /* renamed from: s */
    private int f5350s;

    /* renamed from: t */
    private boolean f5351t;

    /* renamed from: u */
    private int f5352u;

    /* renamed from: v */
    private OnItemClickListener f5353v;

    /* renamed from: w */
    private OnItemLongClickListener f5354w;

    /* renamed from: x */
    private OnItemSelectedListener f5355x;

    /* renamed from: y */
    private C2011n f5356y;

    /* renamed from: z */
    private OnScrollListener f5357z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C2012o();

        /* renamed from: a */
        boolean f5358a;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5358a = parcel.readByte() != 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.f5358a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.f5358a ? 1 : 0));
        }
    }

    /* renamed from: a */
    static /* synthetic */ long m5102a(StickyGridHeadersGridView stickyGridHeadersGridView, int i) {
        return i == -2 ? stickyGridHeadersGridView.f5345n : stickyGridHeadersGridView.f5336e.mo18210b(stickyGridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public StickyGridHeadersGridView(Context context) {
        this(context, null);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5340i = true;
        this.f5341j = new Rect();
        this.f5345n = -1;
        this.f5346o = new C2005h(this);
        this.f5352u = 1;
        this.f5326A = 0;
        this.f5331F = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.f5351t) {
            this.f5350s = -1;
        }
        this.f5329D = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* renamed from: a */
    public final View mo18176a(int i) {
        if (i == -2) {
            return this.f5327B;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.f5327B;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.f5331F;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5353v.onItemClick(adapterView, view, this.f5336e.mo18211c(i).f5374b, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.f5354w.onItemLongClick(adapterView, view, this.f5336e.mo18211c(i).f5374b, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5355x.onItemSelected(adapterView, view, this.f5336e.mo18211c(i).f5374b, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f5355x.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5340i = savedState.f5358a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5358a = this.f5340i;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5357z != null) {
            this.f5357z.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            m5107b(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f5357z != null) {
            this.f5357z.onScrollStateChanged(absListView, i);
        }
        this.f5326A = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = -2;
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.f5333b == null) {
                    this.f5333b = new C2008k(this);
                }
                postDelayed(this.f5333b, (long) ViewConfiguration.getTapTimeout());
                int y = (int) motionEvent.getY();
                this.f5349r = (float) y;
                float f = (float) y;
                if (this.f5327B == null || f > ((float) this.f5327B.getBottom())) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    i = 0;
                    while (true) {
                        if (firstVisiblePosition <= getLastVisiblePosition()) {
                            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                                View childAt = getChildAt(i);
                                int bottom = childAt.getBottom();
                                int top = childAt.getTop();
                                if (f <= ((float) bottom) && f >= ((float) top)) {
                                }
                            }
                            firstVisiblePosition += this.f5352u;
                            i += this.f5352u;
                        } else {
                            i = -1;
                        }
                    }
                }
                this.f5338g = i;
                if (!(this.f5338g == -1 || this.f5326A == 2)) {
                    this.f5339h = 0;
                    return true;
                }
            case 1:
                if (this.f5339h == -2) {
                    return true;
                }
                if (!(this.f5339h == -1 || this.f5338g == -1)) {
                    View a = mo18176a(this.f5338g);
                    if (a != null && !a.hasFocusable()) {
                        if (this.f5339h != 0) {
                            a.setPressed(false);
                        }
                        if (this.f5356y == null) {
                            this.f5356y = new C2011n(this, 0);
                        }
                        C2011n nVar = this.f5356y;
                        nVar.f5387a = this.f5338g;
                        nVar.mo18249a();
                        if (this.f5339h != 0 || this.f5339h != 1) {
                            Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.f5339h == 0 ? this.f5333b : this.f5332a);
                            }
                            if (!this.f5337f) {
                                this.f5339h = 1;
                                a.setPressed(true);
                                setPressed(true);
                                if (this.f5328C != null) {
                                    removeCallbacks(this.f5328C);
                                }
                                this.f5328C = new C2006i(this, a, nVar);
                                postDelayed(this.f5328C, (long) ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.f5339h = -1;
                            }
                        } else if (!this.f5337f) {
                            nVar.run();
                        }
                    }
                    this.f5339h = -1;
                    return true;
                }
                break;
            case 2:
                if (this.f5338g != -1 && Math.abs(motionEvent.getY() - this.f5349r) > ((float) this.f5329D)) {
                    this.f5339h = -1;
                    View a2 = mo18176a(this.f5338g);
                    if (a2 != null) {
                        a2.setPressed(false);
                    }
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.f5332a);
                    }
                    this.f5338g = -1;
                    break;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(ListAdapter listAdapter) {
        StickyGridHeadersBaseAdapter qVar;
        if (!(this.f5336e == null || this.f5346o == null)) {
            this.f5336e.unregisterDataSetObserver(this.f5346o);
        }
        if (!this.f5343l) {
            this.f5342k = true;
        }
        if (listAdapter instanceof StickyGridHeadersBaseAdapter) {
            qVar = (StickyGridHeadersBaseAdapter) listAdapter;
        } else if (listAdapter instanceof StickyGridHeadersSimpleAdapter) {
            qVar = new StickyGridHeadersSimpleAdapterWrapper((StickyGridHeadersSimpleAdapter) listAdapter);
        } else {
            qVar = new StickyGridHeadersListAdapterWrapper(listAdapter);
        }
        this.f5336e = new StickyGridHeadersBaseAdapterWrapper(getContext(), this, qVar);
        this.f5336e.registerDataSetObserver(this.f5346o);
        m5106b();
        super.setAdapter(this.f5336e);
    }

    public void setAreHeadersSticky(boolean z) {
        if (z != this.f5340i) {
            this.f5340i = z;
            requestLayout();
        }
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f5342k = z;
        this.f5343l = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.f5344m = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.f5348q = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.f5351t = true;
        this.f5350s = i;
        if (i != -1 && this.f5336e != null) {
            this.f5336e.mo18208a(i);
        }
    }

    public void setOnHeaderClickListener(C2009l lVar) {
        this.f5334c = lVar;
    }

    public void setOnHeaderLongClickListener(C2010m mVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f5335d = mVar;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f5353v = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.f5354w = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f5355x = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f5357z = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.f5331F = !z;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.f5330E = i;
    }

    private int getHeaderHeight() {
        if (this.f5327B != null) {
            return this.f5327B.getMeasuredHeight();
        }
        return 0;
    }

    /* renamed from: a */
    private void m5103a() {
        int makeMeasureSpec;
        if (this.f5327B != null) {
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.f5327B.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.f5327B.measure(makeMeasureSpec2, makeMeasureSpec);
            this.f5327B.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.f5327B.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5106b() {
        this.f5347p = 0;
        this.f5327B = null;
        this.f5345n = Long.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5107b(int r11) {
        /*
            r10 = this;
            r5 = 0
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            if (r0 == 0) goto L_0x0011
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            int r0 = r0.getCount()
            if (r0 == 0) goto L_0x0011
            boolean r0 = r10.f5340i
            if (r0 != 0) goto L_0x0012
        L_0x0011:
            return
        L_0x0012:
            android.view.View r0 = r10.getChildAt(r5)
            com.tonicartos.widget.stickygridheaders.g r0 = (com.tonicartos.widget.stickygridheaders.C2004g) r0
            if (r0 == 0) goto L_0x0011
            int r0 = r10.f5352u
            int r0 = r11 - r0
            if (r0 >= 0) goto L_0x0021
            r0 = r11
        L_0x0021:
            int r1 = r10.f5352u
            int r1 = r1 + r11
            com.tonicartos.widget.stickygridheaders.b r2 = r10.f5336e
            int r2 = r2.getCount()
            if (r1 < r2) goto L_0x002d
            r1 = r11
        L_0x002d:
            int r2 = r10.f5330E
            if (r2 == 0) goto L_0x00ba
            int r2 = r10.f5330E
            if (r2 >= 0) goto L_0x00a2
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            r0.mo18210b(r11)
            int r0 = r10.f5352u
            android.view.View r0 = r10.getChildAt(r0)
            int r0 = r0.getTop()
            if (r0 > 0) goto L_0x009a
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            long r2 = r0.mo18210b(r1)
            r8 = r2
            r2 = r1
            r0 = r8
        L_0x004f:
            long r6 = r10.f5345n
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0064
            com.tonicartos.widget.stickygridheaders.b r3 = r10.f5336e
            android.view.View r4 = r10.f5327B
            android.view.View r2 = r3.mo18207a(r2, r4, r10)
            r10.f5327B = r2
            r10.m5103a()
            r10.f5345n = r0
        L_0x0064:
            int r6 = r10.getChildCount()
            if (r6 == 0) goto L_0x0011
            r3 = 0
            r2 = 99999(0x1869f, float:1.40128E-40)
            r4 = r5
        L_0x006f:
            if (r4 >= r6) goto L_0x00c7
            android.view.View r0 = super.getChildAt(r4)
            com.tonicartos.widget.stickygridheaders.g r0 = (com.tonicartos.widget.stickygridheaders.C2004g) r0
            boolean r1 = r10.f5342k
            if (r1 == 0) goto L_0x00c2
            int r1 = r0.getTop()
            int r7 = r10.getPaddingTop()
            int r1 = r1 - r7
        L_0x0084:
            if (r1 < 0) goto L_0x012e
            android.view.View r7 = r0.getView()
            boolean r7 = r7 instanceof com.tonicartos.widget.stickygridheaders.C2002e
            if (r7 == 0) goto L_0x012e
            if (r1 >= r2) goto L_0x012e
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x0093:
            int r2 = r10.f5352u
            int r2 = r2 + r4
            r4 = r2
            r3 = r1
            r2 = r0
            goto L_0x006f
        L_0x009a:
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            long r0 = r0.mo18210b(r11)
            r2 = r11
            goto L_0x004f
        L_0x00a2:
            android.view.View r1 = r10.getChildAt(r5)
            int r1 = r1.getTop()
            if (r1 <= 0) goto L_0x00ba
            int r2 = r10.f5330E
            if (r1 >= r2) goto L_0x00ba
            com.tonicartos.widget.stickygridheaders.b r1 = r10.f5336e
            long r2 = r1.mo18210b(r0)
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x004f
        L_0x00ba:
            com.tonicartos.widget.stickygridheaders.b r0 = r10.f5336e
            long r0 = r0.mo18210b(r11)
            r2 = r11
            goto L_0x004f
        L_0x00c2:
            int r1 = r0.getTop()
            goto L_0x0084
        L_0x00c7:
            int r0 = r10.getHeaderHeight()
            if (r3 == 0) goto L_0x011d
            if (r11 != 0) goto L_0x00e1
            android.view.View r1 = super.getChildAt(r5)
            int r1 = r1.getTop()
            if (r1 <= 0) goto L_0x00e1
            boolean r1 = r10.f5342k
            if (r1 != 0) goto L_0x00e1
            r10.f5347p = r5
            goto L_0x0011
        L_0x00e1:
            boolean r1 = r10.f5342k
            if (r1 == 0) goto L_0x0108
            int r1 = r3.getTop()
            int r2 = r10.getPaddingTop()
            int r2 = r2 + r0
            int r1 = java.lang.Math.min(r1, r2)
            r10.f5347p = r1
            int r1 = r10.f5347p
            int r2 = r10.getPaddingTop()
            if (r1 >= r2) goto L_0x0105
            int r1 = r10.getPaddingTop()
            int r0 = r0 + r1
        L_0x0101:
            r10.f5347p = r0
            goto L_0x0011
        L_0x0105:
            int r0 = r10.f5347p
            goto L_0x0101
        L_0x0108:
            int r1 = r3.getTop()
            int r1 = java.lang.Math.min(r1, r0)
            r10.f5347p = r1
            int r1 = r10.f5347p
            if (r1 >= 0) goto L_0x011a
        L_0x0116:
            r10.f5347p = r0
            goto L_0x0011
        L_0x011a:
            int r0 = r10.f5347p
            goto L_0x0116
        L_0x011d:
            r10.f5347p = r0
            boolean r0 = r10.f5342k
            if (r0 == 0) goto L_0x0011
            int r0 = r10.f5347p
            int r1 = r10.getPaddingTop()
            int r0 = r0 + r1
            r10.f5347p = r0
            goto L_0x0011
        L_0x012e:
            r0 = r2
            r1 = r3
            goto L_0x0093
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView.m5107b(int):void");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        if (VERSION.SDK_INT < 8) {
            m5107b(getFirstVisiblePosition());
        }
        if (this.f5327B == null || !this.f5340i || this.f5327B.getVisibility() != 0) {
            z = false;
        } else {
            z = true;
        }
        int headerHeight = getHeaderHeight();
        int i = this.f5347p - headerHeight;
        if (z && this.f5331F) {
            this.f5341j.left = getPaddingLeft();
            this.f5341j.right = getWidth() - getPaddingRight();
            this.f5341j.top = this.f5347p;
            this.f5341j.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.f5341j);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.f5352u;
            i2 += this.f5352u;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                break;
            }
            C2004g gVar = (C2004g) getChildAt(((Integer) arrayList.get(i4)).intValue());
            try {
                View view = (View) gVar.getTag();
                boolean z2 = ((long) ((C2002e) gVar.getChildAt(0)).getHeaderId()) == this.f5345n && gVar.getTop() < 0 && this.f5340i;
                if (view.getVisibility() == 0 && !z2) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), gVar.getHeight());
                    this.f5341j.left = getPaddingLeft();
                    this.f5341j.right = getWidth() - getPaddingRight();
                    this.f5341j.bottom = gVar.getBottom();
                    this.f5341j.top = gVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.f5341j);
                    canvas.translate((float) getPaddingLeft(), (float) gVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                i3 = i4 + 1;
            } catch (Exception e) {
                return;
            }
        }
        if (z && this.f5331F) {
            canvas.restore();
        } else if (!z) {
            return;
        }
        if (this.f5327B.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.f5327B.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
            this.f5327B.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.f5327B.getHeight());
        }
        this.f5341j.left = getPaddingLeft();
        this.f5341j.right = getWidth() - getPaddingRight();
        this.f5341j.bottom = i + headerHeight;
        if (this.f5342k) {
            this.f5341j.top = getPaddingTop();
        } else {
            this.f5341j.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.f5341j);
        canvas.translate((float) getPaddingLeft(), (float) i);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.f5347p)) / ((float) headerHeight)), 4);
        this.f5327B.draw(canvas);
        canvas.restore();
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.f5350s == -1) {
            if (this.f5344m > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.f5344m;
                if (i4 > 0) {
                    while (i4 != 1 && (this.f5344m * i4) + ((i4 - 1) * this.f5348q) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.f5352u = i3;
        } else {
            this.f5352u = this.f5350s;
        }
        if (this.f5336e != null) {
            this.f5336e.mo18208a(this.f5352u);
        }
        m5103a();
        super.onMeasure(i, i2);
    }
}
