package com.p013a.p014a;

import android.content.Context;
import android.graphics.Rect;
//import android.support.p004v4.view.ViewCompat;
//import android.support.p004v4.widget.C0213az;

import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;

import androidx.customview.widget.ViewDragHelper;//import android.support.p004v4.widget.ViewDragHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.a.a.b */
public class SwipeLayout extends FrameLayout {
    private GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public C0436e mDoubleClickListener;
    /* access modifiers changed from: private */
    public int mDragDistance;
    /* access modifiers changed from: private */
    public int mDragEdge$85cc13e;
    private ViewDragHelper mDragHelper;
//    private C0213az mDragHelperCallback;
    private int mEventCounter;
    private List<C0438g> mOnLayoutListeners;
    private Map<View, ArrayList<C0439h>> mRevealListeners;
    private Map<View, Boolean> mShowEntirely;
    /* access modifiers changed from: private */
    public int mShowMode$66cb888d;
    private List<C0442k> mSwipeDeniers;
    private boolean mSwipeEnabled;
    /* access modifiers changed from: private */
    public List<C0444m> mSwipeListeners;
    private boolean mTouchConsumedByChild;

    /* renamed from: sX */
    private float f1674sX;

    /* renamed from: sY */
    private float f1675sY;

    public SwipeLayout(Context context) {
        this(context, null);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDragDistance = 0;
        this.mSwipeListeners = new ArrayList();
        this.mSwipeDeniers = new ArrayList();
        this.mRevealListeners = new HashMap();
        this.mShowEntirely = new HashMap();
        this.mSwipeEnabled = true;
//        this.mDragHelperCallback = new C0434c(this);
        this.mEventCounter = 0;
        this.mTouchConsumedByChild = false;
        this.f1674sX = -1.0f;
        this.f1675sY = -1.0f;
        this.gestureDetector = new GestureDetector(getContext(), new C0443l(this));
//        this.mDragHelper = ViewDragHelper.m913a((ViewGroup) this, this.mDragHelperCallback);
        this.mDragEdge$85cc13e = C0437f.m2344a()[1];
        this.mShowMode$66cb888d = C0440i.m2346a()[1];
    }

    public void addSwipeListener(C0444m mVar) {
        this.mSwipeListeners.add(mVar);
    }

    public void removeSwipeListener(C0444m mVar) {
        this.mSwipeListeners.remove(mVar);
    }

    public void addSwipeDenier(C0442k kVar) {
        this.mSwipeDeniers.add(kVar);
    }

    public void removeSwipeDenier(C0442k kVar) {
        this.mSwipeDeniers.remove(kVar);
    }

    public void removeAllSwipeDeniers() {
        this.mSwipeDeniers.clear();
    }

    public void addRevealListener(int i, C0439h hVar) {
        View findViewById = findViewById(i);
        if (findViewById == null) {
            throw new IllegalArgumentException("Child does not belong to SwipeListener.");
        }
        if (!this.mShowEntirely.containsKey(findViewById)) {
            this.mShowEntirely.put(findViewById, Boolean.valueOf(false));
        }
        if (this.mRevealListeners.get(findViewById) == null) {
            this.mRevealListeners.put(findViewById, new ArrayList());
        }
        ((ArrayList) this.mRevealListeners.get(findViewById)).add(hVar);
    }

    public void addRevealListener(int[] iArr, C0439h hVar) {
        for (int addRevealListener : iArr) {
            addRevealListener(addRevealListener, hVar);
        }
    }

    public void removeRevealListener(int i, C0439h hVar) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            this.mShowEntirely.remove(findViewById);
            if (this.mRevealListeners.containsKey(findViewById)) {
                ((ArrayList) this.mRevealListeners.get(findViewById)).remove(hVar);
            }
        }
    }

    public void removeAllRevealListeners(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            this.mRevealListeners.remove(findViewById);
            this.mShowEntirely.remove(findViewById);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isViewTotallyFirstShowed$3a90b43c(View view, Rect rect, int i, int i2, int i3, int i4, int i5) {
        boolean z;
        if (((Boolean) this.mShowEntirely.get(view)).booleanValue()) {
            return false;
        }
        int i6 = rect.left;
        int i7 = rect.right;
        int i8 = rect.top;
        int i9 = rect.bottom;
        if (getShowMode$655cb86e() == C0440i.f1700a) {
            if ((i == C0437f.f1696b && i4 <= i6) || ((i == C0437f.f1695a && i2 >= i7) || ((i == C0437f.f1697c && i3 >= i9) || (i == C0437f.f1698d && i5 <= i8)))) {
                z = true;
            }
            z = false;
        } else {
            if (getShowMode$655cb86e() == C0440i.f1701b && ((i == C0437f.f1696b && i7 <= getWidth()) || ((i == C0437f.f1695a && i6 >= getPaddingLeft()) || ((i == C0437f.f1697c && i8 >= getPaddingTop()) || (i == C0437f.f1698d && i9 <= getHeight()))))) {
                z = true;
            }
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean isViewShowing$3a90b43c(View view, Rect rect, int i, int i2, int i3, int i4, int i5) {
        int i6 = rect.left;
        int i7 = rect.right;
        int i8 = rect.top;
        int i9 = rect.bottom;
        if (getShowMode$655cb86e() == C0440i.f1700a) {
            switch (C0435d.f1694a[i - 1]) {
                case 1:
                    if (i3 >= i8 && i3 < i9) {
                        return true;
                    }
                case 2:
                    if (i5 > i8 && i5 <= i9) {
                        return true;
                    }
                case 3:
                    if (i2 < i7 && i2 >= i6) {
                        return true;
                    }
                case 4:
                    if (i4 > i6 && i4 <= i7) {
                        return true;
                    }
            }
        } else if (getShowMode$655cb86e() == C0440i.f1701b) {
            switch (C0435d.f1694a[i - 1]) {
                case 1:
                    if (i8 < getPaddingTop() && i9 >= getPaddingTop()) {
                        return true;
                    }
                case 2:
                    if (i8 < getHeight() && i8 >= getPaddingTop()) {
                        return true;
                    }
                case 3:
                    if (i7 >= getPaddingLeft() && i6 < getPaddingLeft()) {
                        return true;
                    }
                case 4:
                    if (i6 <= getWidth() && i7 > getWidth()) {
                        return true;
                    }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Rect getRelativePosition(View view) {
        Rect rect = new Rect(view.getLeft(), view.getTop(), 0, 0);
        View view2 = view;
        while (view2.getParent() != null && view2 != getRootView()) {
            view2 = (View) view2.getParent();
            if (view2 == this) {
                break;
            }
            rect.left += view2.getLeft();
            rect.top += view2.getTop();
        }
        rect.right = rect.left + view.getMeasuredWidth();
        rect.bottom = rect.top + view.getMeasuredHeight();
        return rect;
    }

    /* access modifiers changed from: protected */
    public void dispatchSwipeEvent(int i, int i2, int i3, int i4) {
        boolean z = false;
        int dragEdge$6edf11f = getDragEdge$6edf11f();
        if (dragEdge$6edf11f != C0437f.f1695a ? dragEdge$6edf11f != C0437f.f1696b ? dragEdge$6edf11f != C0437f.f1697c ? dragEdge$6edf11f != C0437f.f1698d || i4 <= 0 : i4 >= 0 : i3 <= 0 : i3 >= 0) {
            z = true;
        }
        dispatchSwipeEvent(i, i2, z);
    }

    /* access modifiers changed from: protected */
    public void dispatchSwipeEvent(int i, int i2, boolean z) {
        safeBottomView();
        int openStatus$3ce369e0 = getOpenStatus$3ce369e0();
        if (!this.mSwipeListeners.isEmpty()) {
            this.mEventCounter++;
            for (C0444m mVar : this.mSwipeListeners) {
                if (this.mEventCounter == 1 && z) {
                    mVar.mo2786a(this);
                }
                getPaddingLeft();
                getPaddingTop();
            }
            if (openStatus$3ce369e0 == C0441j.f1705c) {
                for (C0444m a : this.mSwipeListeners) {
                    a.mo2785a();
                }
                this.mEventCounter = 0;
            }
            if (openStatus$3ce369e0 == C0441j.f1704b) {
                getBottomView().setEnabled(true);
                for (C0444m b : this.mSwipeListeners) {
                    b.mo2787b(this);
                }
                this.mEventCounter = 0;
            }
        }
    }

    private void safeBottomView() {
        int openStatus$3ce369e0 = getOpenStatus$3ce369e0();
        ViewGroup bottomView = getBottomView();
        if (openStatus$3ce369e0 == C0441j.f1705c) {
            if (bottomView.getVisibility() != 4) {
                bottomView.setVisibility(4);
            }
        } else if (bottomView.getVisibility() != 0) {
            bottomView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRevealEvent(int i, int i2, int i3, int i4) {
        float f;
        if (!this.mRevealListeners.isEmpty()) {
            for (Entry entry : this.mRevealListeners.entrySet()) {
                View view = (View) entry.getKey();
                Rect relativePosition = getRelativePosition(view);
                if (isViewShowing$3a90b43c(view, relativePosition, this.mDragEdge$85cc13e, i, i2, i3, i4)) {
                    this.mShowEntirely.put(view, Boolean.valueOf(false));
                    float f2 = 0.0f;
                    if (getShowMode$655cb86e() == C0440i.f1700a) {
                        switch (C0435d.f1694a[this.mDragEdge$85cc13e - 1]) {
                            case 1:
                                f = ((float) (relativePosition.top - i2)) / ((float) view.getHeight());
                                break;
                            case 2:
                                f2 = ((float) (relativePosition.bottom - i4)) / ((float) view.getHeight());
                                break;
                            case 3:
                                f = ((float) (relativePosition.left - i)) / ((float) view.getWidth());
                                break;
                            case 4:
                                f = ((float) (relativePosition.right - i3)) / ((float) view.getWidth());
                                break;
                        }
                        f = f2;
                    } else {
                        if (getShowMode$655cb86e() == C0440i.f1701b) {
                            switch (C0435d.f1694a[this.mDragEdge$85cc13e - 1]) {
                                case 1:
                                    f = ((float) (relativePosition.bottom - getPaddingTop())) / ((float) view.getHeight());
                                    break;
                                case 2:
                                    f = ((float) (relativePosition.top - getHeight())) / ((float) view.getHeight());
                                    break;
                                case 3:
                                    f = ((float) (relativePosition.right - getPaddingLeft())) / ((float) view.getWidth());
                                    break;
                                case 4:
                                    f = ((float) (relativePosition.left - getWidth())) / ((float) view.getWidth());
                                    break;
                            }
                        }
                        f = 0.0f;
                    }
                    Iterator it = ((ArrayList) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        it.next();
                        Math.abs(f);
                        if (Math.abs(f) == 1.0f) {
                            this.mShowEntirely.put(view, Boolean.valueOf(true));
                        }
                    }
                }
                if (isViewTotallyFirstShowed$3a90b43c(view, relativePosition, this.mDragEdge$85cc13e, i, i2, i3, i4)) {
                    this.mShowEntirely.put(view, Boolean.valueOf(true));
                    Iterator it2 = ((ArrayList) entry.getValue()).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                        if (this.mDragEdge$85cc13e == C0437f.f1695a || this.mDragEdge$85cc13e == C0437f.f1696b) {
                            view.getWidth();
                        } else {
                            view.getHeight();
                        }
                    }
                }
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
//        if (this.mDragHelper.mo998c()) {
//            ViewCompat.m551e(this);
//        }
    }

    public void addOnLayoutListener(C0438g gVar) {
        if (this.mOnLayoutListeners == null) {
            this.mOnLayoutListeners = new ArrayList();
        }
        this.mOnLayoutListeners.add(gVar);
    }

    public void removeOnLayoutListener(C0438g gVar) {
        if (this.mOnLayoutListeners != null) {
            this.mOnLayoutListeners.remove(gVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (getChildCount() != 2) {
            throw new IllegalStateException("You need 2  views in SwipeLayout");
        } else if (!(getChildAt(0) instanceof ViewGroup) || !(getChildAt(1) instanceof ViewGroup)) {
            throw new IllegalArgumentException("The 2 children in SwipeLayout must be an instance of ViewGroup");
        } else {
            if (this.mShowMode$66cb888d == C0440i.f1701b) {
                layoutPullOut();
            } else if (this.mShowMode$66cb888d == C0440i.f1700a) {
                layoutLayDown();
            }
            safeBottomView();
            if (this.mOnLayoutListeners != null) {
                while (true) {
                    int i6 = i5;
                    if (i6 < this.mOnLayoutListeners.size()) {
                        ((C0438g) this.mOnLayoutListeners.get(i6)).mo2855a(this);
                        i5 = i6 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void layoutPullOut() {
        Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
        getSurfaceView().layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
        Rect computeBottomLayoutAreaViaSurface$1ca508b6 = computeBottomLayoutAreaViaSurface$1ca508b6(C0440i.f1701b, computeSurfaceLayoutArea);
        getBottomView().layout(computeBottomLayoutAreaViaSurface$1ca508b6.left, computeBottomLayoutAreaViaSurface$1ca508b6.top, computeBottomLayoutAreaViaSurface$1ca508b6.right, computeBottomLayoutAreaViaSurface$1ca508b6.bottom);
        bringChildToFront(getSurfaceView());
    }

    /* access modifiers changed from: 0000 */
    public void layoutLayDown() {
        Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
        getSurfaceView().layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
        Rect computeBottomLayoutAreaViaSurface$1ca508b6 = computeBottomLayoutAreaViaSurface$1ca508b6(C0440i.f1700a, computeSurfaceLayoutArea);
        getBottomView().layout(computeBottomLayoutAreaViaSurface$1ca508b6.left, computeBottomLayoutAreaViaSurface$1ca508b6.top, computeBottomLayoutAreaViaSurface$1ca508b6.right, computeBottomLayoutAreaViaSurface$1ca508b6.bottom);
        bringChildToFront(getSurfaceView());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mDragEdge$85cc13e == C0437f.f1695a || this.mDragEdge$85cc13e == C0437f.f1696b) {
            this.mDragDistance = getBottomView().getMeasuredWidth();
        } else {
            this.mDragDistance = getBottomView().getMeasuredHeight();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (!isEnabled() || !isEnabledInAdapterView()) {
            return true;
        }
        if (!isSwipeEnabled()) {
            return false;
        }
        for (C0442k kVar : this.mSwipeDeniers) {
            if (kVar != null && kVar.mo2856a()) {
                return false;
            }
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                int openStatus$3ce369e0 = getOpenStatus$3ce369e0();
                if (openStatus$3ce369e0 != C0441j.f1705c) {
                    if (openStatus$3ce369e0 == C0441j.f1704b) {
                        if (childNeedHandleTouchEvent(getBottomView(), motionEvent) == null) {
                            z = false;
                        }
                        this.mTouchConsumedByChild = z;
                        break;
                    }
                } else {
                    this.mTouchConsumedByChild = childNeedHandleTouchEvent(getSurfaceView(), motionEvent) != null;
                    break;
                }
                break;
            case 1:
            case 3:
                this.mTouchConsumedByChild = false;
                break;
        }
        if (!this.mTouchConsumedByChild) {
//            return this.mDragHelper.mo994a(motionEvent);
        }
        return false;
    }

    private View childNeedHandleTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup.onTouchEvent(motionEvent)) {
            return viewGroup;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                View childNeedHandleTouchEvent = childNeedHandleTouchEvent((ViewGroup) childAt, motionEvent);
                if (childNeedHandleTouchEvent != null) {
                    return childNeedHandleTouchEvent;
                }
            } else if (childNeedHandleTouchEvent(viewGroup.getChildAt(childCount), motionEvent)) {
                return viewGroup.getChildAt(childCount);
            }
        }
        return null;
    }

    private boolean childNeedHandleTouchEvent(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getRawX() <= ((float) i) || motionEvent.getRawX() >= ((float) (i + view.getWidth())) || motionEvent.getRawY() <= ((float) i2) || motionEvent.getRawY() >= ((float) (i2 + view.getHeight()))) {
            return false;
        }
        return view.onTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent r14) {
        /*
            r13 = this;
            r12 = 1106247680(0x41f00000, float:30.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 0
            r1 = 0
            r2 = 1
            boolean r0 = r13.isEnabledInAdapterView()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r13.isEnabled()
            if (r0 != 0) goto L_0x0014
        L_0x0013:
            return r2
        L_0x0014:
            boolean r0 = r13.isSwipeEnabled()
            if (r0 != 0) goto L_0x001f
            boolean r2 = super.onTouchEvent(r14)
            goto L_0x0013
        L_0x001f:
            int r3 = r14.getActionMasked()
            android.view.ViewParent r5 = r13.getParent()
            android.view.GestureDetector r0 = r13.gestureDetector
            r0.onTouchEvent(r14)
            int r6 = r13.getOpenStatus$3ce369e0()
            r0 = 0
            int r4 = com.p013a.p014a.C0441j.f1705c
            if (r6 != r4) goto L_0x0046
            android.view.ViewGroup r0 = r13.getSurfaceView()
            r4 = r0
        L_0x003a:
            switch(r3) {
                case 0: goto L_0x0050;
                case 1: goto L_0x016f;
                case 2: goto L_0x006a;
                case 3: goto L_0x016f;
                default: goto L_0x003d;
            }
        L_0x003d:
            r5.requestDisallowInterceptTouchEvent(r2)
            android.support.v4.widget.aw r0 = r13.mDragHelper
            r0.mo997b(r14)
            goto L_0x0013
        L_0x0046:
            int r4 = com.p013a.p014a.C0441j.f1704b
            if (r6 != r4) goto L_0x017d
            android.view.ViewGroup r0 = r13.getBottomView()
            r4 = r0
            goto L_0x003a
        L_0x0050:
            android.support.v4.widget.aw r0 = r13.mDragHelper
            r0.mo997b(r14)
            r5.requestDisallowInterceptTouchEvent(r2)
            float r0 = r14.getRawX()
            r13.f1674sX = r0
            float r0 = r14.getRawY()
            r13.f1675sY = r0
            if (r4 == 0) goto L_0x0013
            r4.setPressed(r2)
            goto L_0x0013
        L_0x006a:
            float r0 = r13.f1674sX
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0076
            float r0 = r13.f1675sY
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x008e
        L_0x0076:
            r14.setAction(r1)
            android.support.v4.widget.aw r0 = r13.mDragHelper
            r0.mo997b(r14)
            r5.requestDisallowInterceptTouchEvent(r2)
            float r0 = r14.getRawX()
            r13.f1674sX = r0
            float r0 = r14.getRawY()
            r13.f1675sY = r0
            goto L_0x0013
        L_0x008e:
            float r0 = r14.getRawX()
            float r3 = r13.f1674sX
            float r3 = r0 - r3
            float r0 = r14.getRawY()
            float r7 = r13.f1675sY
            float r7 = r0 - r7
            float r0 = r7 / r3
            float r0 = java.lang.Math.abs(r0)
            double r8 = (double) r0
            double r8 = java.lang.Math.atan(r8)
            double r8 = java.lang.Math.toDegrees(r8)
            float r8 = (float) r8
            int r0 = r13.mDragEdge$85cc13e
            int r9 = com.p013a.p014a.C0437f.f1696b
            if (r0 != r9) goto L_0x017a
            int r0 = com.p013a.p014a.C0441j.f1704b
            if (r6 != r0) goto L_0x00bc
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x00c4
        L_0x00bc:
            int r0 = com.p013a.p014a.C0441j.f1705c
            if (r6 != r0) goto L_0x014e
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x014e
        L_0x00c4:
            r0 = r2
        L_0x00c5:
            if (r0 != 0) goto L_0x00cb
            int r0 = com.p013a.p014a.C0441j.f1703a
            if (r6 != r0) goto L_0x0151
        L_0x00cb:
            r0 = r2
        L_0x00cc:
            int r9 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x00d2
            if (r0 != 0) goto L_0x017a
        L_0x00d2:
            r0 = r2
        L_0x00d3:
            int r9 = r13.mDragEdge$85cc13e
            int r10 = com.p013a.p014a.C0437f.f1695a
            if (r9 != r10) goto L_0x00f8
            int r9 = com.p013a.p014a.C0441j.f1704b
            if (r6 != r9) goto L_0x00e1
            int r9 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r9 < 0) goto L_0x00e9
        L_0x00e1:
            int r9 = com.p013a.p014a.C0441j.f1705c
            if (r6 != r9) goto L_0x0154
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0154
        L_0x00e9:
            r3 = r2
        L_0x00ea:
            if (r3 != 0) goto L_0x00f0
            int r3 = com.p013a.p014a.C0441j.f1703a
            if (r6 != r3) goto L_0x0156
        L_0x00f0:
            r3 = r2
        L_0x00f1:
            int r9 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x00f7
            if (r3 != 0) goto L_0x00f8
        L_0x00f7:
            r0 = r2
        L_0x00f8:
            int r3 = r13.mDragEdge$85cc13e
            int r9 = com.p013a.p014a.C0437f.f1697c
            if (r3 != r9) goto L_0x011f
            int r3 = com.p013a.p014a.C0441j.f1704b
            if (r6 != r3) goto L_0x0106
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 < 0) goto L_0x010e
        L_0x0106:
            int r3 = com.p013a.p014a.C0441j.f1705c
            if (r6 != r3) goto L_0x0158
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0158
        L_0x010e:
            r3 = r2
        L_0x010f:
            if (r3 != 0) goto L_0x0115
            int r3 = com.p013a.p014a.C0441j.f1703a
            if (r6 != r3) goto L_0x015a
        L_0x0115:
            r3 = r2
        L_0x0116:
            r9 = 1114636288(0x42700000, float:60.0)
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x011e
            if (r3 != 0) goto L_0x011f
        L_0x011e:
            r0 = r2
        L_0x011f:
            int r3 = r13.mDragEdge$85cc13e
            int r9 = com.p013a.p014a.C0437f.f1698d
            if (r3 != r9) goto L_0x0146
            int r3 = com.p013a.p014a.C0441j.f1704b
            if (r6 != r3) goto L_0x012d
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x0135
        L_0x012d:
            int r3 = com.p013a.p014a.C0441j.f1705c
            if (r6 != r3) goto L_0x015c
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x015c
        L_0x0135:
            r3 = r2
        L_0x0136:
            if (r3 != 0) goto L_0x013c
            int r3 = com.p013a.p014a.C0441j.f1703a
            if (r6 != r3) goto L_0x015e
        L_0x013c:
            r3 = r2
        L_0x013d:
            r6 = 1114636288(0x42700000, float:60.0)
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0145
            if (r3 != 0) goto L_0x0146
        L_0x0145:
            r0 = r2
        L_0x0146:
            if (r0 == 0) goto L_0x0160
            r5.requestDisallowInterceptTouchEvent(r1)
            r2 = r1
            goto L_0x0013
        L_0x014e:
            r0 = r1
            goto L_0x00c5
        L_0x0151:
            r0 = r1
            goto L_0x00cc
        L_0x0154:
            r3 = r1
            goto L_0x00ea
        L_0x0156:
            r3 = r1
            goto L_0x00f1
        L_0x0158:
            r3 = r1
            goto L_0x010f
        L_0x015a:
            r3 = r1
            goto L_0x0116
        L_0x015c:
            r3 = r1
            goto L_0x0136
        L_0x015e:
            r3 = r1
            goto L_0x013d
        L_0x0160:
            if (r4 == 0) goto L_0x0165
            r4.setPressed(r1)
        L_0x0165:
            r5.requestDisallowInterceptTouchEvent(r2)
            android.support.v4.widget.aw r0 = r13.mDragHelper
            r0.mo997b(r14)
            goto L_0x0013
        L_0x016f:
            r13.f1674sX = r7
            r13.f1675sY = r7
            if (r4 == 0) goto L_0x003d
            r4.setPressed(r1)
            goto L_0x003d
        L_0x017a:
            r0 = r1
            goto L_0x00d3
        L_0x017d:
            r4 = r0
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p013a.p014a.SwipeLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isEnabledInAdapterView() {
        AdapterView adapterView = getAdapterView();
        if (adapterView != null) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                int positionForView = adapterView.getPositionForView(this);
                if (adapter instanceof BaseAdapter) {
                    return ((BaseAdapter) adapter).isEnabled(positionForView);
                }
                if (adapter instanceof ListAdapter) {
                    return ((ListAdapter) adapter).isEnabled(positionForView);
                }
            }
        }
        return true;
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
    }

    public boolean isSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    private boolean insideAdapterView() {
        return getAdapterView() != null;
    }

    private AdapterView getAdapterView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AdapterView) {
                return (AdapterView) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void performAdapterViewItemClick(MotionEvent motionEvent) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) parent;
                int positionForView = adapterView.getPositionForView(this);
                if (positionForView != -1 && adapterView.performItemClick(adapterView.getChildAt(positionForView), positionForView, adapterView.getAdapter().getItemId(positionForView))) {
                    return;
                }
            } else if ((parent instanceof View) && ((View) parent).performClick()) {
                return;
            }
        }
    }

    public void setDragEdge$10bf1267(int i) {
        this.mDragEdge$85cc13e = i;
        requestLayout();
    }

    public void setDragDistance(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Drag distance can not be < 0");
        }
        this.mDragDistance = dp2px((float) i);
        requestLayout();
    }

    public void setShowMode$6d1b1d28(int i) {
        this.mShowMode$66cb888d = i;
        requestLayout();
    }

    public int getDragEdge$6edf11f() {
        return this.mDragEdge$85cc13e;
    }

    public int getDragDistance() {
        return this.mDragDistance;
    }

    public int getShowMode$655cb86e() {
        return this.mShowMode$66cb888d;
    }

    public ViewGroup getSurfaceView() {
        return (ViewGroup) getChildAt(1);
    }

    public ViewGroup getBottomView() {
        return (ViewGroup) getChildAt(0);
    }

    public int getOpenStatus$3ce369e0() {
        int left = getSurfaceView().getLeft();
        int top = getSurfaceView().getTop();
        if (left == getPaddingLeft() && top == getPaddingTop()) {
            return C0441j.f1705c;
        }
        if (left == getPaddingLeft() - this.mDragDistance || left == getPaddingLeft() + this.mDragDistance || top == getPaddingTop() - this.mDragDistance || top == getPaddingTop() + this.mDragDistance) {
            return C0441j.f1704b;
        }
        return C0441j.f1703a;
    }

    /* access modifiers changed from: private */
    public void processSurfaceRelease(float f, float f2) {
        if (f == 0.0f && getOpenStatus$3ce369e0() == C0441j.f1703a) {
            close();
        }
        if (this.mDragEdge$85cc13e == C0437f.f1695a || this.mDragEdge$85cc13e == C0437f.f1696b) {
            if (f > 0.0f) {
                if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                    open();
                } else {
                    close();
                }
            }
            if (f >= 0.0f) {
                return;
            }
            if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                close();
            } else {
                open();
            }
        } else {
            if (f2 > 0.0f) {
                if (this.mDragEdge$85cc13e == C0437f.f1697c) {
                    open();
                } else {
                    close();
                }
            }
            if (f2 >= 0.0f) {
                return;
            }
            if (this.mDragEdge$85cc13e == C0437f.f1697c) {
                close();
            } else {
                open();
            }
        }
    }

    /* access modifiers changed from: private */
    public void processBottomPullOutRelease(float f, float f2) {
        if (f == 0.0f && getOpenStatus$3ce369e0() == C0441j.f1703a) {
            close();
        }
        if (this.mDragEdge$85cc13e == C0437f.f1695a || this.mDragEdge$85cc13e == C0437f.f1696b) {
            if (f > 0.0f) {
                if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                    open();
                } else {
                    close();
                }
            }
            if (f >= 0.0f) {
                return;
            }
            if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                close();
            } else {
                open();
            }
        } else {
            if (f2 > 0.0f) {
                if (this.mDragEdge$85cc13e == C0437f.f1697c) {
                    open();
                } else {
                    close();
                }
            }
            if (f2 >= 0.0f) {
                return;
            }
            if (this.mDragEdge$85cc13e == C0437f.f1697c) {
                close();
            } else {
                open();
            }
        }
    }

    /* access modifiers changed from: private */
    public void processBottomLayDownMode(float f, float f2) {
        if (f == 0.0f && getOpenStatus$3ce369e0() == C0441j.f1703a) {
            close();
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (f < 0.0f && this.mDragEdge$85cc13e == C0437f.f1696b) {
            paddingLeft -= this.mDragDistance;
        }
        if (f > 0.0f && this.mDragEdge$85cc13e == C0437f.f1695a) {
            paddingLeft += this.mDragDistance;
        }
        if (f2 > 0.0f && this.mDragEdge$85cc13e == C0437f.f1697c) {
            paddingTop += this.mDragDistance;
        }
        if (f2 < 0.0f && this.mDragEdge$85cc13e == C0437f.f1698d) {
            paddingTop -= this.mDragDistance;
        }
//        this.mDragHelper.mo995a((View) getSurfaceView(), paddingLeft, paddingTop);
        invalidate();
    }

    public void open() {
        open(true, true);
    }

    public void open(boolean z) {
        open(z, true);
    }

    public void open(boolean z, boolean z2) {
        ViewGroup surfaceView = getSurfaceView();
        ViewGroup bottomView = getBottomView();
        Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(true);
        if (z) {
//            this.mDragHelper.mo995a((View) getSurfaceView(), computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top);
        } else {
            int left = computeSurfaceLayoutArea.left - surfaceView.getLeft();
            int top = computeSurfaceLayoutArea.top - surfaceView.getTop();
            surfaceView.layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
            if (getShowMode$655cb86e() == C0440i.f1701b) {
                Rect computeBottomLayoutAreaViaSurface$1ca508b6 = computeBottomLayoutAreaViaSurface$1ca508b6(C0440i.f1701b, computeSurfaceLayoutArea);
                bottomView.layout(computeBottomLayoutAreaViaSurface$1ca508b6.left, computeBottomLayoutAreaViaSurface$1ca508b6.top, computeBottomLayoutAreaViaSurface$1ca508b6.right, computeBottomLayoutAreaViaSurface$1ca508b6.bottom);
            }
            if (z2) {
                dispatchRevealEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                dispatchSwipeEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, left, top);
            } else {
                safeBottomView();
            }
        }
        invalidate();
    }

    public void close() {
        close(true, true);
    }

    public void close(boolean z) {
        close(z, true);
    }

    public void close(boolean z, boolean z2) {
        ViewGroup surfaceView = getSurfaceView();
        if (z) {
//            this.mDragHelper.mo995a((View) getSurfaceView(), getPaddingLeft(), getPaddingTop());
        } else {
            Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
            int left = computeSurfaceLayoutArea.left - surfaceView.getLeft();
            int top = computeSurfaceLayoutArea.top - surfaceView.getTop();
            surfaceView.layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
            if (z2) {
                dispatchRevealEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                dispatchSwipeEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, left, top);
            } else {
                safeBottomView();
            }
        }
        invalidate();
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        if (getOpenStatus$3ce369e0() == C0441j.f1704b) {
            close(z);
        } else if (getOpenStatus$3ce369e0() == C0441j.f1705c) {
            open(z);
        }
    }

    private Rect computeSurfaceLayoutArea(boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (z) {
            if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                paddingLeft = getPaddingLeft() + this.mDragDistance;
            } else if (this.mDragEdge$85cc13e == C0437f.f1696b) {
                paddingLeft = getPaddingLeft() - this.mDragDistance;
            } else {
                paddingTop = this.mDragEdge$85cc13e == C0437f.f1697c ? getPaddingTop() + this.mDragDistance : getPaddingTop() - this.mDragDistance;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    private Rect computeBottomLayoutAreaViaSurface$1ca508b6(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = rect.left;
        int i7 = rect.top;
        int i8 = rect.right;
        int i9 = rect.bottom;
        if (i == C0440i.f1701b) {
            if (this.mDragEdge$85cc13e == C0437f.f1695a) {
                i6 = rect.left - this.mDragDistance;
            } else if (this.mDragEdge$85cc13e == C0437f.f1696b) {
                i6 = rect.right;
            } else {
                i7 = this.mDragEdge$85cc13e == C0437f.f1697c ? rect.top - this.mDragDistance : rect.bottom;
            }
            if (this.mDragEdge$85cc13e == C0437f.f1695a || this.mDragEdge$85cc13e == C0437f.f1696b) {
                i2 = i7;
                i3 = rect.bottom;
                i4 = i6;
                i5 = getBottomView().getMeasuredWidth() + i6;
            } else {
                i2 = i7;
                i3 = getBottomView().getMeasuredHeight() + i7;
                i4 = i6;
                i5 = rect.right;
            }
        } else if (i != C0440i.f1700a) {
            int i10 = i9;
            i2 = i7;
            i3 = i10;
            int i11 = i8;
            i4 = i6;
            i5 = i11;
        } else if (this.mDragEdge$85cc13e == C0437f.f1695a) {
            int i12 = i9;
            i2 = i7;
            i3 = i12;
            i4 = i6;
            i5 = this.mDragDistance + i6;
        } else if (this.mDragEdge$85cc13e == C0437f.f1696b) {
            int i13 = i9;
            i2 = i7;
            i3 = i13;
            int i14 = i8;
            i4 = i8 - this.mDragDistance;
            i5 = i14;
        } else if (this.mDragEdge$85cc13e == C0437f.f1697c) {
            i2 = i7;
            i3 = this.mDragDistance + i7;
            int i15 = i8;
            i4 = i6;
            i5 = i15;
        } else {
            int i16 = i9;
            i2 = i9 - this.mDragDistance;
            i3 = i16;
            int i17 = i8;
            i4 = i6;
            i5 = i17;
        }
        return new Rect(i4, i2, i5, i3);
    }

    /* access modifiers changed from: private */
    public Rect computeBottomLayDown$4fc6f390(int i) {
        int i2;
        int i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (i == C0437f.f1696b) {
            paddingLeft = getMeasuredWidth() - this.mDragDistance;
        } else if (i == C0437f.f1698d) {
            paddingTop = getMeasuredHeight() - this.mDragDistance;
        }
        if (i == C0437f.f1695a || i == C0437f.f1696b) {
            i2 = paddingLeft + this.mDragDistance;
            i3 = getMeasuredHeight() + paddingTop;
        } else {
            i2 = paddingLeft + getMeasuredWidth();
            i3 = this.mDragDistance + paddingTop;
        }
        return new Rect(paddingLeft, paddingTop, i2, i3);
    }

    public void setOnDoubleClickListener(C0436e eVar) {
        this.mDoubleClickListener = eVar;
    }

    private int dp2px(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
