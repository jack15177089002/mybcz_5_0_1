package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
//import android.support.p004v4.view.MotionEventCompat;
//import android.support.p004v4.view.VelocityTrackerCompat;
//import android.support.p004v4.view.ViewConfigurationCompat;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.a */
public final class CustomViewAbove extends ViewGroup {

    /* renamed from: e */
    private static final Interpolator f3903e = new C1634b();

    /* renamed from: A */
    private float f3904A;

    /* renamed from: a */
    protected int f3905a;

    /* renamed from: b */
    protected VelocityTracker f3906b;

    /* renamed from: c */
    protected int f3907c;

    /* renamed from: d */
    protected int f3908d;

    /* renamed from: f */
    private View f3909f;

    /* renamed from: g */
    private int f3910g;

    /* renamed from: h */
    private Scroller f3911h;

    /* renamed from: i */
    private boolean f3912i;

    /* renamed from: j */
    private boolean f3913j;

    /* renamed from: k */
    private boolean f3914k;

    /* renamed from: l */
    private boolean f3915l;

    /* renamed from: m */
    private int f3916m;

    /* renamed from: n */
    private float f3917n;

    /* renamed from: o */
    private float f3918o;

    /* renamed from: p */
    private float f3919p;

    /* renamed from: q */
    private int f3920q;

    /* renamed from: r */
    private int f3921r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CustomViewBehind f3922s;

    /* renamed from: t */
    private boolean f3923t;

    /* renamed from: u */
    private C1636d f3924u;

    /* renamed from: v */
    private C1636d f3925v;

    /* renamed from: w */
    private C1646o f3926w;

    /* renamed from: x */
    private C1648q f3927x;

    /* renamed from: y */
    private List<View> f3928y;

    /* renamed from: z */
    private boolean f3929z;

    public CustomViewAbove(Context context) {
        this(context, (byte) 0);
    }

    private CustomViewAbove(Context context, byte b) {
        super(context, null);
        this.f3905a = -1;
        this.f3923t = true;
        this.f3928y = new ArrayList();
        this.f3908d = 0;
        this.f3929z = false;
        this.f3904A = 0.0f;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f3911h = new Scroller(context2, f3903e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
//        this.f3916m = ViewConfigurationCompat.m673a(viewConfiguration);
//        this.f3920q = viewConfiguration.getScaledMinimumFlingVelocity();
//        this.f3907c = viewConfiguration.getScaledMaximumFlingVelocity();
//        this.f3925v = new C1635c(this);
//        this.f3921r = (int) (context2.getResources().getDisplayMetrics().density * 25.0f);
    }

    public final void setCurrentItem(int i) {
        mo16556a(i, true, false);
    }

    public final int getCurrentItem() {
        return this.f3910g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16556a(int i, boolean z, boolean z2) {
        m3660a(i, z, z2, 0);
    }

    /* renamed from: a */
    private void m3660a(int i, boolean z, boolean z2, int i2) {
        int i3;
        if (z2 || this.f3910g != i) {
            CustomViewBehind fVar = this.f3922s;
            if (i > 1) {
                i = 2;
            } else if (i <= 0) {
                i = 0;
            }
            if (fVar.f3945e == 0 && i > 1) {
                i = 0;
            } else if (fVar.f3945e == 1 && i <= 0) {
                i = 2;
            }
            boolean z3 = this.f3910g != i;
            this.f3910g = i;
            int a = m3657a(this.f3910g);
            if (z3 && this.f3924u != null) {
                this.f3924u.mo16599a(i);
            }
            if (z3 && this.f3925v != null) {
                this.f3925v.mo16599a(i);
            }
            if (!z) {
                m3663b();
                scrollTo(a, 0);
            } else if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i4 = a - scrollX;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    m3663b();
                    return;
                }
                setScrollingCacheEnabled(true);
                this.f3913j = true;
                int behindWidth = getBehindWidth();
                int i6 = behindWidth / 2;
//                float sin = (FloatMath.sin((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i4))) / ((float) behindWidth)) - 0.5f)) * 0.4712389167638204d)) * ((float) i6)) + ((float) i6);
//                int abs = Math.abs(i2);
//                if (abs > 0) {
//                    i3 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
//                } else {
//                    Math.abs(i4);
//                    i3 = 600;
//                }
//                this.f3911h.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
                invalidate();
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public final void setOnPageChangeListener(C1636d dVar) {
        this.f3924u = dVar;
    }

    public final void setOnOpenedListener(C1648q qVar) {
        this.f3927x = qVar;
    }

    public final void setOnClosedListener(C1646o oVar) {
        this.f3926w = oVar;
    }

    /* renamed from: a */
    private int m3657a(int i) {
        switch (i) {
            case 0:
            case 2:
                CustomViewBehind fVar = this.f3922s;
                View view = this.f3909f;
                if (fVar.f3945e == 0) {
                    switch (i) {
                        case 0:
                            return view.getLeft() - fVar.getBehindWidth();
                        case 2:
                            return view.getLeft();
                    }
                } else if (fVar.f3945e == 1) {
                    switch (i) {
                        case 0:
                            return view.getLeft();
                        case 2:
                            return fVar.getBehindWidth() + view.getLeft();
                    }
                } else if (fVar.f3945e == 2) {
                    switch (i) {
                        case 0:
                            return view.getLeft() - fVar.getBehindWidth();
                        case 2:
                            return fVar.getBehindWidth() + view.getLeft();
                    }
                }
                return view.getLeft();
            case 1:
                return this.f3909f.getLeft();
            default:
                return 0;
        }
    }

    private int getLeftBound() {
        CustomViewBehind fVar = this.f3922s;
        View view = this.f3909f;
        if (fVar.f3945e == 0 || fVar.f3945e == 2) {
            return view.getLeft() - fVar.getBehindWidth();
        }
        if (fVar.f3945e == 1) {
            return view.getLeft();
        }
        return 0;
    }

    private int getRightBound() {
        CustomViewBehind fVar = this.f3922s;
        View view = this.f3909f;
        if (fVar.f3945e == 0) {
            return view.getLeft();
        }
        if (fVar.f3945e != 1 && fVar.f3945e != 2) {
            return 0;
        }
        return fVar.getBehindWidth() + view.getLeft();
    }

    public final int getContentLeft() {
        return this.f3909f.getLeft() + this.f3909f.getPaddingLeft();
    }

    /* renamed from: a */
    private boolean m3661a() {
        return this.f3910g == 0 || this.f3910g == 2;
    }

    public final int getBehindWidth() {
        if (this.f3922s == null) {
            return 0;
        }
        return this.f3922s.getBehindWidth();
    }

    public final void setSlidingEnabled(boolean z) {
        this.f3923t = z;
    }

    public final void setContent(View view) {
        if (this.f3909f != null) {
            removeView(this.f3909f);
        }
        this.f3909f = view;
        addView(this.f3909f);
    }

    public final View getContent() {
        return this.f3909f;
    }

    public final void setCustomViewBehind(CustomViewBehind fVar) {
        this.f3922s = fVar;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.f3909f.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m3663b();
            scrollTo(m3657a(this.f3910g), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f3909f.layout(0, 0, i3 - i, i4 - i2);
    }

    public final void setAboveOffset(int i) {
        this.f3909f.setPadding(i, this.f3909f.getPaddingTop(), this.f3909f.getPaddingRight(), this.f3909f.getPaddingBottom());
    }

    public final void computeScroll() {
        if (this.f3911h.isFinished() || !this.f3911h.computeScrollOffset()) {
            m3663b();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f3911h.getCurrX();
        int currY = this.f3911h.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            getWidth();
        }
        invalidate();
    }

    /* renamed from: b */
    private void m3663b() {
        if (this.f3913j) {
            setScrollingCacheEnabled(false);
            this.f3911h.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f3911h.getCurrX();
            int currY = this.f3911h.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f3913j = false;
    }

    public final void setTouchMode(int i) {
        this.f3908d = i;
    }

    public final int getTouchMode() {
        return this.f3908d;
    }

    /* renamed from: a */
    private boolean m3662a(MotionEvent motionEvent) {
        boolean z = false;
        int x = (int) (motionEvent.getX() + this.f3904A);
        if (m3661a()) {
            CustomViewBehind fVar = this.f3922s;
            View view = this.f3909f;
            int i = this.f3910g;
            float f = (float) x;
            switch (fVar.f3941a) {
                case 0:
                    return fVar.mo16600a(view, i, f);
                case 1:
                    return true;
                default:
                    return false;
            }
        } else {
            switch (this.f3908d) {
                case 0:
                    CustomViewBehind fVar2 = this.f3922s;
                    View view2 = this.f3909f;
                    int left = view2.getLeft();
                    int right = view2.getRight();
                    if (fVar2.f3945e == 0) {
                        return x >= left && x <= fVar2.f3944d + left;
                    }
                    if (fVar2.f3945e == 1) {
                        return x <= right && x >= right - fVar2.f3944d;
                    }
                    if (fVar2.f3945e == 2) {
                        return (x >= left && x <= left + fVar2.f3944d) || (x <= right && x >= right - fVar2.f3944d);
                    }
                    return false;
                case 1:
                    Rect rect = new Rect();
                    Iterator it = this.f3928y.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ((View) it.next()).getHitRect(rect);
                            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                                z = true;
                            }
                        } else {
                            z = false;
                        }

                        //test
                        break;
                    }
                    return !z;
                case 2:
                    return false;
                default:
                    return false;
            }
        }
    }

    /* renamed from: a */
    private int m3658a(MotionEvent motionEvent, int i) {
//        int a = MotionEventCompat.m809a(motionEvent, i);
//        if (a == -1) {
//            this.f3905a = -1;
//        }
//        return a;

        return -1;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f3923t) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1 || (action != 0 && this.f3915l)) {
            m3666c();
            return false;
        }
//        switch (action) {
//            case 0:
//                int b = MotionEventCompat.m810b(motionEvent);
//                this.f3905a = MotionEventCompat.m811b(motionEvent, b);
//                if (this.f3905a != -1) {
//                    float c = MotionEventCompat.m812c(motionEvent, b);
//                    this.f3917n = c;
//                    this.f3918o = c;
//                    this.f3919p = MotionEventCompat.m814d(motionEvent, b);
//                    if (!m3662a(motionEvent)) {
//                        this.f3915l = true;
//                        break;
//                    } else {
//                        this.f3914k = false;
//                        this.f3915l = false;
//                        if (m3661a() && this.f3922s.mo16600a(this.f3909f, this.f3910g, motionEvent.getX() + this.f3904A)) {
//                            this.f3929z = true;
//                            break;
//                        }
//                    }
//                }
//                break;
//            case 2:
//                m3664b(motionEvent);
//                break;
//            case 6:
//                m3667c(motionEvent);
//                break;
//        }
        if (!this.f3914k) {
            if (this.f3906b == null) {
                this.f3906b = VelocityTracker.obtain();
            }
            this.f3906b.addMovement(motionEvent);
        }
        if (this.f3914k || this.f3929z) {
            return true;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3923t) {
            return false;
        }
        if (!this.f3914k && !m3662a(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.f3906b == null) {
            this.f3906b = VelocityTracker.obtain();
        }
        this.f3906b.addMovement(motionEvent);
//        switch (action & 255) {
//            case 0:
//                m3663b();
//                this.f3905a = MotionEventCompat.m811b(motionEvent, MotionEventCompat.m810b(motionEvent));
//                float x = motionEvent.getX();
//                this.f3917n = x;
//                this.f3918o = x;
//                break;
//            case 1:
//                if (!this.f3914k) {
//                    if (this.f3929z && this.f3922s.mo16600a(this.f3909f, this.f3910g, motionEvent.getX() + this.f3904A)) {
//                        setCurrentItem(1);
//                        m3666c();
//                        break;
//                    }
//                } else {
//                    VelocityTracker velocityTracker = this.f3906b;
//                    velocityTracker.computeCurrentVelocity(1000, (float) this.f3907c);
//                    int a = (int) VelocityTrackerCompat.m525a(velocityTracker, this.f3905a);
//                    float scrollX = ((float) (getScrollX() - m3657a(this.f3910g))) / ((float) getBehindWidth());
//                    int a2 = m3658a(motionEvent, this.f3905a);
//                    if (this.f3905a != -1) {
//                        int c = (int) (MotionEventCompat.m812c(motionEvent, a2) - this.f3917n);
//                        int i = this.f3910g;
//                        if (Math.abs(c) <= this.f3921r || Math.abs(a) <= this.f3920q) {
//                            i = Math.round(((float) this.f3910g) + scrollX);
//                        } else if (a > 0 && c > 0) {
//                            i--;
//                        } else if (a < 0 && c < 0) {
//                            i++;
//                        }
//                        m3660a(i, true, true, a);
//                    } else {
//                        m3660a(this.f3910g, true, true, a);
//                    }
//                    this.f3905a = -1;
//                    m3666c();
//                    break;
//                }
//                break;
//            case 2:
//                if (!this.f3914k) {
//                    m3664b(motionEvent);
//                    if (this.f3915l) {
//                        return false;
//                    }
//                }
//                if (this.f3914k) {
//                    int a3 = m3658a(motionEvent, this.f3905a);
//                    if (this.f3905a != -1) {
//                        float c2 = MotionEventCompat.m812c(motionEvent, a3);
//                        float f = this.f3918o - c2;
//                        this.f3918o = c2;
//                        float scrollX2 = ((float) getScrollX()) + f;
//                        float leftBound = (float) getLeftBound();
//                        float rightBound = (float) getRightBound();
//                        if (scrollX2 >= leftBound) {
//                            if (scrollX2 > rightBound) {
//                                leftBound = rightBound;
//                            } else {
//                                leftBound = scrollX2;
//                            }
//                        }
//                        this.f3918o += leftBound - ((float) ((int) leftBound));
//                        scrollTo((int) leftBound, getScrollY());
//                        getWidth();
//                        break;
//                    }
//                }
//                break;
//            case 3:
//                if (this.f3914k) {
//                    mo16556a(this.f3910g, true, true);
//                    this.f3905a = -1;
//                    m3666c();
//                    break;
//                }
//                break;
//            case 5:
//                int b = MotionEventCompat.m810b(motionEvent);
//                this.f3918o = MotionEventCompat.m812c(motionEvent, b);
//                this.f3905a = MotionEventCompat.m811b(motionEvent, b);
//                break;
//            case 6:
//                m3667c(motionEvent);
//                int a4 = m3658a(motionEvent, this.f3905a);
//                if (this.f3905a != -1) {
//                    this.f3918o = MotionEventCompat.m812c(motionEvent, a4);
//                    break;
//                }
//                break;
//        }
        return true;
    }

    /* renamed from: b */
    private void m3664b(MotionEvent motionEvent) {
        boolean z;
        int i = this.f3905a;
        int a = m3658a(motionEvent, i);
//        if (i != -1 && a != -1) {
//            float c = MotionEventCompat.m812c(motionEvent, a);
//            float f = c - this.f3918o;
//            float abs = Math.abs(f);
//            float d = MotionEventCompat.m814d(motionEvent, a);
//            float abs2 = Math.abs(d - this.f3919p);
//            if (abs > ((float) (m3661a() ? this.f3916m / 2 : this.f3916m)) && abs > abs2) {
//                if (m3661a()) {
//                    CustomViewBehind fVar = this.f3922s;
//                    z = fVar.f3945e == 0 ? f < 0.0f : fVar.f3945e == 1 ? f > 0.0f : fVar.f3945e == 2;
//                } else {
//                    CustomViewBehind fVar2 = this.f3922s;
//                    z = fVar2.f3945e == 0 ? f > 0.0f : fVar2.f3945e == 1 ? f < 0.0f : fVar2.f3945e == 2;
//                }
//                if (z) {
//                    this.f3914k = true;
//                    this.f3929z = false;
//                    this.f3918o = c;
//                    this.f3919p = d;
//                    setScrollingCacheEnabled(true);
//                    return;
//                }
//            }
//            if (abs > ((float) this.f3916m)) {
//                this.f3915l = true;
//            }
//        }
    }

    public final void scrollTo(int i, int i2) {
        int i3 = 0;
        int i4;
        boolean z;
        int i5 = 0;
        super.scrollTo(i, i2);
        this.f3904A = (float) i;
        CustomViewBehind fVar = this.f3922s;
        View view = this.f3909f;
        if (fVar.f3945e == 0) {
            if (i >= view.getLeft()) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            fVar.scrollTo((int) (((float) (fVar.getBehindWidth() + i)) * fVar.f3948h), i2);
        } else if (fVar.f3945e == 1) {
            if (i <= view.getLeft()) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            fVar.scrollTo((int) (((float) (fVar.getBehindWidth() - fVar.getWidth())) + (((float) (i - fVar.getBehindWidth())) * fVar.f3948h)), i2);
        } else if (fVar.f3945e == 2) {
            fVar.f3942b.setVisibility(i >= view.getLeft() ? 4 : 0);
            fVar.f3943c.setVisibility(i <= view.getLeft() ? 4 : 0);
            i3 = i == 0 ? 4 : 0;
            if (i <= view.getLeft()) {
                fVar.scrollTo((int) (((float) (fVar.getBehindWidth() + i)) * fVar.f3948h), i2);
            } else {
                fVar.scrollTo((int) (((float) (fVar.getBehindWidth() - fVar.getWidth())) + (((float) (i - fVar.getBehindWidth())) * fVar.f3948h)), i2);
            }
        } else {
            i3 = 0;
        }
        if (i3 == 4) {
            Log.v("CustomViewBehind", "behind INVISIBLE");
        }
        fVar.setVisibility(i3);
        SlidingMenu slidingMenu = (SlidingMenu) getParent();
        float percentOpen = getPercentOpen();
        if (VERSION.SDK_INT >= 11) {
            if (percentOpen <= 0.0f || percentOpen >= 1.0f) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i5 = 2;
            }
            if (i5 != slidingMenu.getContent().getLayerType()) {
                slidingMenu.getHandler().post(new C1643l(slidingMenu, i5));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final float getPercentOpen() {
        return Math.abs(this.f3904A - ((float) this.f3909f.getLeft())) / ((float) getBehindWidth());
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int left = 0;
        super.dispatchDraw(canvas);
        CustomViewBehind fVar = this.f3922s;
        View view = this.f3909f;
        if (fVar.f3949i != null && fVar.f3951k > 0) {
            if (fVar.f3945e != 0) {
                if (fVar.f3945e == 1) {
                    left = view.getRight();
                } else if (fVar.f3945e != 2) {
                    left = 0;
                } else if (fVar.f3950j != null) {
                    int right = view.getRight();
                    fVar.f3950j.setBounds(right, 0, fVar.f3951k + right, fVar.getHeight());
                    fVar.f3950j.draw(canvas);
                }
                fVar.f3949i.setBounds(left, 0, fVar.f3951k + left, fVar.getHeight());
                fVar.f3949i.draw(canvas);
            }
            left = view.getLeft() - fVar.f3951k;
            fVar.f3949i.setBounds(left, 0, fVar.f3951k + left, fVar.getHeight());
            fVar.f3949i.draw(canvas);
        }
        CustomViewBehind fVar2 = this.f3922s;
        View view2 = this.f3909f;
        float percentOpen = getPercentOpen();
        if (fVar2.f3946f) {
            fVar2.f3947g.setColor(Color.argb((int) (Math.abs(1.0f - percentOpen) * fVar2.f3952l * 255.0f), 0, 0, 0));
            if (fVar2.f3945e == 0) {
                i2 = view2.getLeft() - fVar2.getBehindWidth();
                i = view2.getLeft();
            } else if (fVar2.f3945e == 1) {
                i2 = view2.getRight();
                i = view2.getRight() + fVar2.getBehindWidth();
            } else if (fVar2.f3945e == 2) {
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) (view2.getLeft() - fVar2.getBehindWidth()), 0.0f, (float) view2.getLeft(), (float) fVar2.getHeight(), fVar2.f3947g);
                i2 = view2.getRight();
                i = view2.getRight() + fVar2.getBehindWidth();
            } else {
                i = 0;
                i2 = 0;
            }
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) fVar2.getHeight(), fVar2.f3947g);
        }
        CustomViewBehind fVar3 = this.f3922s;
        View view3 = this.f3909f;
        float percentOpen2 = getPercentOpen();
        if (fVar3.f3953m && fVar3.f3954n != null && fVar3.f3955o != null && ((String) fVar3.f3955o.getTag(C1639h.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width = (int) (((float) fVar3.f3954n.getWidth()) * percentOpen2);
            if (fVar3.f3945e == 0) {
                int left2 = view3.getLeft();
                int i3 = left2 - width;
                canvas.clipRect(i3, 0, left2, fVar3.getHeight());
                canvas.drawBitmap(fVar3.f3954n, (float) i3, (float) fVar3.getSelectorTop(), null);
            } else if (fVar3.f3945e == 1) {
                int right2 = view3.getRight();
                int i4 = width + right2;
                canvas.clipRect(right2, 0, i4, fVar3.getHeight());
                canvas.drawBitmap(fVar3.f3954n, (float) (i4 - fVar3.f3954n.getWidth()), (float) fVar3.getSelectorTop(), null);
            }
            canvas.restore();
        }
    }

    /* renamed from: c */
    private void m3667c(MotionEvent motionEvent) {
//        int b = MotionEventCompat.m810b(motionEvent);
//        if (MotionEventCompat.m811b(motionEvent, b) == this.f3905a) {
//            int i = b == 0 ? 1 : 0;
//            this.f3918o = MotionEventCompat.m812c(motionEvent, i);
//            this.f3905a = MotionEventCompat.m811b(motionEvent, i);
//            if (this.f3906b != null) {
//                this.f3906b.clear();
//            }
//        }
    }

    /* renamed from: c */
    private void m3666c() {
        this.f3929z = false;
        this.f3914k = false;
        this.f3915l = false;
        this.f3905a = -1;
        if (this.f3906b != null) {
            this.f3906b.recycle();
            this.f3906b = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f3912i != z) {
            this.f3912i = z;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            r1 = 1
            r0 = 0
            boolean r2 = super.dispatchKeyEvent(r5)
            if (r2 != 0) goto L_0x0018
            int r2 = r5.getAction()
            if (r2 != 0) goto L_0x0015
            int r2 = r5.getKeyCode()
            switch(r2) {
                case 21: goto L_0x001a;
                case 22: goto L_0x0021;
                case 61: goto L_0x0028;
                default: goto L_0x0015;
            }
        L_0x0015:
            r2 = r0
        L_0x0016:
            if (r2 == 0) goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            return r0
        L_0x001a:
            r2 = 17
            boolean r2 = r4.m3665b(r2)
            goto L_0x0016
        L_0x0021:
            r2 = 66
            boolean r2 = r4.m3665b(r2)
            goto L_0x0016
        L_0x0028:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 11
            if (r2 < r3) goto L_0x0015
            boolean r2 = android.support.p004v4.view.KeyEventCompat.m794b(r5)
            if (r2 == 0) goto L_0x003a
            r2 = 2
            boolean r2 = r4.m3665b(r2)
            goto L_0x0016
        L_0x003a:
            boolean r2 = android.support.p004v4.view.KeyEventCompat.m793a(r5)
            if (r2 == 0) goto L_0x0015
            boolean r2 = r4.m3665b(r1)
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeremyfeinstein.slidingmenu.lib.CustomViewAbove.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r7 != 2) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3665b(int r7) {
        /*
            r6 = this;
            r5 = 66
            r4 = 17
            r1 = 1
            r2 = 0
            android.view.View r0 = r6.findFocus()
            if (r0 != r6) goto L_0x000d
            r0 = 0
        L_0x000d:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            if (r3 == 0) goto L_0x003d
            if (r3 == r0) goto L_0x003d
            if (r7 != r4) goto L_0x002a
            boolean r1 = r3.requestFocus()
        L_0x001f:
            r2 = r1
        L_0x0020:
            if (r2 == 0) goto L_0x0029
            int r0 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r0)
        L_0x0029:
            return r2
        L_0x002a:
            if (r7 != r5) goto L_0x0020
            if (r0 == 0) goto L_0x0038
            int r4 = r3.getLeft()
            int r0 = r0.getLeft()
            if (r4 <= r0) goto L_0x0056
        L_0x0038:
            boolean r1 = r3.requestFocus()
            goto L_0x001f
        L_0x003d:
            if (r7 == r4) goto L_0x0041
            if (r7 != r1) goto L_0x0051
        L_0x0041:
            int r0 = r6.f3910g
            if (r0 <= 0) goto L_0x004f
            int r0 = r6.f3910g
            int r0 = r0 + -1
            r6.mo16556a(r0, r1, r2)
            r0 = r1
        L_0x004d:
            r2 = r0
            goto L_0x0020
        L_0x004f:
            r0 = r2
            goto L_0x004d
        L_0x0051:
            if (r7 == r5) goto L_0x0056
            r0 = 2
            if (r7 != r0) goto L_0x0020
        L_0x0056:
            int r0 = r6.f3910g
            if (r0 > 0) goto L_0x0062
            int r0 = r6.f3910g
            int r0 = r0 + 1
            r6.mo16556a(r0, r1, r2)
            goto L_0x001f
        L_0x0062:
            r1 = r2
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeremyfeinstein.slidingmenu.lib.CustomViewAbove.m3665b(int):boolean");
    }
}
