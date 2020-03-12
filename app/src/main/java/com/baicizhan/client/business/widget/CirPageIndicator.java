//package com.baicizhan.client.business.widget;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Paint.Style;
//import android.support.p004v4.view.C0156bm;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import p012ch.qos.logback.classic.Level;
//
//public class CirPageIndicator extends View implements C0156bm {
//    public static final int SELECTED_COLOR = Color.parseColor("#99ff2a00");
//    public static final int UNSELECTED_COLOR = Color.parseColor("#99cccccc");
//    private int actualWidth;
//    private int dotMargin;
//    private int mCount;
//    private int paddingBottom;
//    private int paddingTop;
//    private int radius;
//    private Paint selectedPaint;
//    private int selectedPos;
//    private Paint unselectedPaint;
//    private int viewWidth;
//
//    public CirPageIndicator(Context context) {
//        this(context, null);
//    }
//
//    public CirPageIndicator(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.mCount = 0;
//        this.viewWidth = 0;
//        this.actualWidth = 0;
//        this.selectedPos = 0;
//        this.dotMargin = dip2px(getContext(), 12.0f);
//        this.radius = dip2px(getContext(), 3.0f);
//        this.paddingTop = dip2px(getContext(), 2.0f);
//        this.paddingBottom = dip2px(getContext(), 2.0f);
//        this.selectedPaint = new Paint();
//        this.selectedPaint.setAntiAlias(true);
//        this.selectedPaint.setColor(SELECTED_COLOR);
//        this.selectedPaint.setStyle(Style.FILL);
//        this.unselectedPaint = new Paint(this.selectedPaint);
//        this.unselectedPaint.setColor(UNSELECTED_COLOR);
//    }
//
//    public void setViewPager(ViewPager viewPager) {
//        viewPager.setOnPageChangeListener(this);
//        this.mCount = viewPager.getAdapter().getCount();
//        this.actualWidth = (this.dotMargin * (this.mCount - 1)) + (this.radius * 2 * this.mCount);
//        postInvalidate();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        drawDots(canvas);
//    }
//
//    private void drawDots(Canvas canvas) {
//        boolean z;
//        int i = ((this.viewWidth - this.actualWidth) / 2) + this.radius;
//        int i2 = this.radius;
//        int i3 = i;
//        for (int i4 = 0; i4 < this.mCount; i4++) {
//            if (this.selectedPos == i4) {
//                z = true;
//            } else {
//                z = false;
//            }
//            canvas.drawCircle((float) i3, (float) i2, (float) this.radius, z ? this.selectedPaint : this.unselectedPaint);
//            i3 += (this.radius * 2) + this.dotMargin;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        int measureHeight = measureHeight(i2);
//        this.viewWidth = measureWidth(i);
//        setMeasuredDimension(this.viewWidth, measureHeight);
//    }
//
//    private int measureWidth(int i) {
//        return getMeasurement(i, this.actualWidth);
//    }
//
//    private int measureHeight(int i) {
//        return getMeasurement(i, (this.radius * 2) + this.paddingBottom + this.paddingTop);
//    }
//
//    private int getMeasurement(int i, int i2) {
//        int size = MeasureSpec.getSize(i);
//        switch (MeasureSpec.getMode(i)) {
//            case Level.ALL_INT /*-2147483648*/:
//                return Math.min(i2, size);
//            case 1073741824:
//                return size;
//            default:
//                return i2;
//        }
//    }
//
//    public void onPageScrolled(int i, float f, int i2) {
//    }
//
//    public void onPageSelected(int i) {
//        this.selectedPos = i;
//        postInvalidate();
//    }
//
//    public void onPageScrollStateChanged(int i) {
//    }
//
//    public static int dip2px(Context context, float f) {
//        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
//    }
//}
