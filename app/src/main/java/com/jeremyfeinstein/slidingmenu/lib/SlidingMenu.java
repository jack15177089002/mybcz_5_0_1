package com.jeremyfeinstein.slidingmenu.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SlidingMenu extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f3895b = SlidingMenu.class.getSimpleName();

    /* renamed from: a */
    public CustomViewAbove f3896a;

    /* renamed from: c */
    private boolean f3897c;

    /* renamed from: d */
    private CustomViewBehind f3898d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1647p f3899e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1647p f3900f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1645n f3901g;

    public class SavedState extends BaseSavedState {
        public  final Creator<SavedState> CREATOR = new C1649r();

        /* renamed from: a */
        final int f3902a;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f3902a = i;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3902a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3902a);
        }
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingMenu(Activity activity, int i) {
        this((Context) activity, (AttributeSet) null);
        mo16502a(activity, i);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3897c = false;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f3898d = new CustomViewBehind(context);
        addView(this.f3898d, layoutParams);
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        this.f3896a = new CustomViewAbove(context);
        addView(this.f3896a, layoutParams2);
        this.f3896a.setCustomViewBehind(this.f3898d);
        this.f3898d.setCustomViewAbove(this.f3896a);
        this.f3896a.setOnPageChangeListener(new C1642k(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1641j.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(C1641j.SlidingMenu_mode, 0));
        int resourceId = obtainStyledAttributes.getResourceId(C1641j.SlidingMenu_viewAbove, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent((View) new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(C1641j.SlidingMenu_viewBehind, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu((View) new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(C1641j.SlidingMenu_touchModeAbove, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(C1641j.SlidingMenu_touchModeBehind, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(C1641j.SlidingMenu_behindOffset, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(C1641j.SlidingMenu_behindWidth, -1.0f);
        if (dimension == -1 || dimension2 == -1) {
            if (dimension != -1) {
                setBehindOffset(dimension);
            } else if (dimension2 != -1) {
                setBehindWidth(dimension2);
            } else {
                setBehindOffset(0);
            }
            setBehindScrollScale(obtainStyledAttributes.getFloat(C1641j.SlidingMenu_behindScrollScale, 0.33f));
            int resourceId3 = obtainStyledAttributes.getResourceId(C1641j.SlidingMenu_shadowDrawable, -1);
            if (resourceId3 != -1) {
                setShadowDrawable(resourceId3);
            }
            setShadowWidth((int) obtainStyledAttributes.getDimension(C1641j.SlidingMenu_shadowWidth, 0.0f));
            setFadeEnabled(obtainStyledAttributes.getBoolean(C1641j.SlidingMenu_fadeEnabled, true));
            setFadeDegree(obtainStyledAttributes.getFloat(C1641j.SlidingMenu_fadeDegree, 0.33f));
            setSelectorEnabled(obtainStyledAttributes.getBoolean(C1641j.SlidingMenu_selectorEnabled, false));
            int resourceId4 = obtainStyledAttributes.getResourceId(C1641j.SlidingMenu_selectorDrawable, -1);
            if (resourceId4 != -1) {
                setSelectorDrawable(resourceId4);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
    }

    /* renamed from: a */
    public final void mo16502a(Activity activity, int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        } else if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        } else {
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            switch (i) {
                case 0:
                    this.f3897c = false;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                    viewGroup2.setBackgroundResource(resourceId);
                    viewGroup.removeView(viewGroup2);
                    viewGroup.addView(this);
                    setContent((View) viewGroup2);
                    return;
                case 1:
                    this.f3897c = false;
                    ViewGroup viewGroup3 = (ViewGroup) activity.findViewById(16908290);
                    View childAt = viewGroup3.getChildAt(0);
                    viewGroup3.removeView(childAt);
                    viewGroup3.addView(this);
                    setContent(childAt);
                    if (childAt.getBackground() == null) {
                        childAt.setBackgroundResource(resourceId);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, null));
    }

    public void setContent(View view) {
        this.f3896a.setContent(view);
        mo16506c(true);
    }

    public View getContent() {
        return this.f3896a.getContent();
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, null));
    }

    public void setMenu(View view) {
        this.f3898d.setContent(view);
    }

    public View getMenu() {
        return this.f3898d.getContent();
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, null));
    }

    public void setSecondaryMenu(View view) {
        this.f3898d.setSecondaryContent(view);
    }

    public View getSecondaryMenu() {
        return this.f3898d.getSecondaryContent();
    }

    public void setSlidingEnabled(boolean z) {
        this.f3896a.setSlidingEnabled(z);
    }

    public void setMode(int i) {
        if (i == 0 || i == 1 || i == 2) {
            this.f3898d.setMode(i);
            return;
        }
        throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
    }

    public int getMode() {
        return this.f3898d.getMode();
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.f3896a.setCustomViewBehind(null);
            this.f3896a.setCurrentItem(1);
            return;
        }
        this.f3896a.setCurrentItem(1);
        this.f3896a.setCustomViewBehind(this.f3898d);
        setSlidingEnabled(true);
    }

    /* renamed from: a */
    public final void mo16503a(boolean z) {
        this.f3896a.mo16556a(0, z, false);
    }

    /* renamed from: b */
    public final void mo16505b(boolean z) {
        this.f3896a.mo16556a(2, z, false);
    }

    /* renamed from: c */
    public final void mo16506c(boolean z) {
        this.f3896a.mo16556a(1, z, false);
    }

    /* renamed from: a */
    public final boolean mo16504a() {
        return this.f3896a.getCurrentItem() == 0 || this.f3896a.getCurrentItem() == 2;
    }

    public int getBehindOffset() {
        return ((LayoutParams) this.f3898d.getLayoutParams()).rightMargin;
    }

    public void setBehindOffset(int i) {
        this.f3898d.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setAboveOffset(int i) {
        this.f3896a.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Class<Display> cls = Display.class;
        try {
            Class[] clsArr = {Point.class};
            Point point = new Point();
            cls.getMethod("getSize", clsArr).invoke(defaultDisplay, new Object[]{point});
            width = point.x;
        } catch (Exception e) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public float getBehindScrollScale() {
        return this.f3898d.getScrollScale();
    }

    public int getTouchmodeMarginThreshold() {
        return this.f3898d.getMarginThreshold();
    }

    public void setTouchmodeMarginThreshold(int i) {
        this.f3898d.setMarginThreshold(i);
    }

    public void setBehindScrollScale(float f) {
        if (f >= 0.0f || f <= 1.0f) {
            this.f3898d.setScrollScale(f);
            return;
        }
        throw new IllegalStateException("ScrollScale must be between 0 and 1");
    }

    public void setBehindCanvasTransformer(C1644m mVar) {
        this.f3898d.setCanvasTransformer(mVar);
    }

    public int getTouchModeAbove() {
        return this.f3896a.getTouchMode();
    }

    public void setTouchModeAbove(int i) {
        if (i == 1 || i == 0 || i == 2) {
            this.f3896a.setTouchMode(i);
            return;
        }
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    }

    public void setTouchModeBehind(int i) {
        if (i == 1 || i == 0 || i == 2) {
            this.f3898d.setTouchMode(i);
            return;
        }
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f3898d.setShadowDrawable(drawable);
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f3898d.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setShadowWidth(int i) {
        this.f3898d.setShadowWidth(i);
    }

    public void setFadeEnabled(boolean z) {
        this.f3898d.setFadeEnabled(z);
    }

    public void setFadeDegree(float f) {
        this.f3898d.setFadeDegree(f);
    }

    public void setSelectorEnabled(boolean z) {
        this.f3898d.setSelectorEnabled(true);
    }

    public void setSelectedView(View view) {
        this.f3898d.setSelectedView(view);
    }

    public void setSelectorDrawable(int i) {
        this.f3898d.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f3898d.setSelectorBitmap(bitmap);
    }

    public void setOnOpenListener(C1647p pVar) {
        this.f3899e = pVar;
    }

    public void setSecondaryOnOpenListner(C1647p pVar) {
        this.f3900f = pVar;
    }

    public void setOnCloseListener(C1645n nVar) {
        this.f3901g = nVar;
    }

    public void setOnOpenedListener(C1648q qVar) {
        this.f3896a.setOnOpenedListener(qVar);
    }

    public void setOnClosedListener(C1646o oVar) {
        this.f3896a.setOnClosedListener(oVar);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f3896a.getCurrentItem());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3896a.setCurrentItem(savedState.f3902a);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (!this.f3897c) {
            Log.v(f3895b, "setting padding!");
            setPadding(i, i3, i2, i4);
        }
        return true;
    }
}
