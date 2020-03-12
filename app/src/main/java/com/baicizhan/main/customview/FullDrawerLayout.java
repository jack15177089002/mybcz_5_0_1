//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.support.p004v4.view.GravityCompat;
//import android.support.p004v4.view.ViewCompat;
//import android.support.p004v4.widget.C0221i;
//import android.support.p004v4.widget.DrawerLayout;
//import android.util.AttributeSet;
//import android.view.View;
//
//public class FullDrawerLayout extends DrawerLayout {
//    private static final int MIN_DRAWER_MARGIN = 0;
//    private static final String TAG = "FullDrawerLayout";
//
//    public FullDrawerLayout(Context context) {
//        super(context);
//    }
//
//    public FullDrawerLayout(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public FullDrawerLayout(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    /* access modifiers changed from: protected */
//    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
//        if (r4 == 0) goto L_0x0029;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void onMeasure(int r11, int r12) {
//        /*
//            r10 = this;
//            r1 = 300(0x12c, float:4.2E-43)
//            r6 = -2147483648(0xffffffff80000000, float:-0.0)
//            r9 = 1073741824(0x40000000, float:2.0)
//            int r3 = android.view.View.MeasureSpec.getMode(r11)
//            int r4 = android.view.View.MeasureSpec.getMode(r12)
//            int r2 = android.view.View.MeasureSpec.getSize(r11)
//            int r0 = android.view.View.MeasureSpec.getSize(r12)
//            if (r3 != r9) goto L_0x001a
//            if (r4 == r9) goto L_0x00e3
//        L_0x001a:
//            boolean r5 = r10.isInEditMode()
//            if (r5 == 0) goto L_0x006a
//            if (r3 == r6) goto L_0x0025
//            if (r3 != 0) goto L_0x0025
//            r2 = r1
//        L_0x0025:
//            if (r4 == r6) goto L_0x00e3
//            if (r4 != 0) goto L_0x00e3
//        L_0x0029:
//            r10.setMeasuredDimension(r2, r1)
//            int r4 = r10.getChildCount()
//            r0 = 0
//            r3 = r0
//        L_0x0032:
//            if (r3 >= r4) goto L_0x00e2
//            android.view.View r5 = r10.getChildAt(r3)
//            int r0 = r5.getVisibility()
//            r6 = 8
//            if (r0 == r6) goto L_0x0066
//            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
//            android.support.v4.widget.i r0 = (android.support.p004v4.widget.C0221i) r0
//            boolean r6 = r10._isContentView(r5)
//            if (r6 == 0) goto L_0x0072
//            int r6 = r0.leftMargin
//            int r6 = r2 - r6
//            int r7 = r0.rightMargin
//            int r6 = r6 - r7
//            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
//            int r7 = r0.topMargin
//            int r7 = r1 - r7
//            int r0 = r0.bottomMargin
//            int r0 = r7 - r0
//            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
//            r5.measure(r6, r0)
//        L_0x0066:
//            int r0 = r3 + 1
//            r3 = r0
//            goto L_0x0032
//        L_0x006a:
//            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
//            java.lang.String r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
//            r0.<init>(r1)
//            throw r0
//        L_0x0072:
//            boolean r6 = r10._isDrawerView(r5)
//            if (r6 == 0) goto L_0x00bd
//            int r6 = r10._getDrawerViewAbsoluteGravity(r5)
//            r6 = r6 & 7
//            r7 = r6 & 0
//            if (r7 == 0) goto L_0x00a1
//            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
//            java.lang.StringBuilder r1 = new java.lang.StringBuilder
//            java.lang.String r2 = "Child drawer has absolute gravity "
//            r1.<init>(r2)
//            java.lang.String r2 = gravityToString(r6)
//            java.lang.StringBuilder r1 = r1.append(r2)
//            java.lang.String r2 = " but this FullDrawerLayout already has a drawer view along that edge"
//            java.lang.StringBuilder r1 = r1.append(r2)
//            java.lang.String r1 = r1.toString()
//            r0.<init>(r1)
//            throw r0
//        L_0x00a1:
//            int r6 = r0.leftMargin
//            int r6 = r6 + 0
//            int r7 = r0.rightMargin
//            int r6 = r6 + r7
//            int r7 = r0.width
//            int r6 = getChildMeasureSpec(r11, r6, r7)
//            int r7 = r0.topMargin
//            int r8 = r0.bottomMargin
//            int r7 = r7 + r8
//            int r0 = r0.height
//            int r0 = getChildMeasureSpec(r12, r7, r0)
//            r5.measure(r6, r0)
//            goto L_0x0066
//        L_0x00bd:
//            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
//            java.lang.StringBuilder r1 = new java.lang.StringBuilder
//            java.lang.String r2 = "Child "
//            r1.<init>(r2)
//            java.lang.StringBuilder r1 = r1.append(r5)
//            java.lang.String r2 = " at index "
//            java.lang.StringBuilder r1 = r1.append(r2)
//            java.lang.StringBuilder r1 = r1.append(r3)
//            java.lang.String r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY"
//            java.lang.StringBuilder r1 = r1.append(r2)
//            java.lang.String r1 = r1.toString()
//            r0.<init>(r1)
//            throw r0
//        L_0x00e2:
//            return
//        L_0x00e3:
//            r1 = r0
//            goto L_0x0029
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.customview.FullDrawerLayout.onMeasure(int, int):void");
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean _isContentView(View view) {
//        return ((C0221i) view.getLayoutParams()).f577a == 0;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean _isDrawerView(View view) {
//        return (GravityCompat.m789a(((C0221i) view.getLayoutParams()).f577a, ViewCompat.m557i(view)) & 7) != 0;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public int _getDrawerViewAbsoluteGravity(View view) {
//        return GravityCompat.m789a(((C0221i) view.getLayoutParams()).f577a, ViewCompat.m557i(this));
//    }
//
//    static String gravityToString(int i) {
//        if ((i & 3) == 3) {
//            return "LEFT";
//        }
//        if ((i & 5) == 5) {
//            return "RIGHT";
//        }
//        return Integer.toHexString(i);
//    }
//}
