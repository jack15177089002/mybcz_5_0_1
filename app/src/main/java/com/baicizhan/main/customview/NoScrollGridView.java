//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.os.Build.VERSION;
//import android.util.AttributeSet;
//import android.view.View.MeasureSpec;
//import android.widget.GridView;
//import java.lang.reflect.Field;
//import p012ch.qos.logback.classic.Level;
//
//public class NoScrollGridView extends GridView {
//    public NoScrollGridView(Context context) {
//        super(context);
//    }
//
//    public NoScrollGridView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Level.ALL_INT));
//    }
//
//    public int getRequestedColumnWidth() {
//        if (VERSION.SDK_INT >= 16) {
//            return super.getRequestedColumnWidth();
//        }
//        try {
//            Field declaredField = GridView.class.getDeclaredField("mRequestedColumnWidth");
//            declaredField.setAccessible(true);
//            Integer num = (Integer) declaredField.get(this);
//            declaredField.setAccessible(false);
//            return num.intValue();
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e2) {
//            throw new RuntimeException(e2);
//        }
//    }
//
//    public int getRequestedHorizontalSpacing() {
//        if (VERSION.SDK_INT >= 16) {
//            return super.getRequestedHorizontalSpacing();
//        }
//        try {
//            Field declaredField = GridView.class.getDeclaredField("mRequestedHorizontalSpacing");
//            declaredField.setAccessible(true);
//            Integer num = (Integer) declaredField.get(this);
//            declaredField.setAccessible(false);
//            return num.intValue();
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e2) {
//            throw new RuntimeException(e2);
//        }
//    }
//}
