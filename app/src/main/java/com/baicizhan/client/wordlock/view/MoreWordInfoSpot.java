//package com.baicizhan.client.wordlock.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.TextView;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordlock.C0882R;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DispMoreInfoEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DropBackEvent;
//import com.baicizhan.client.wordlock.view.drag.DragSource;
//import com.baicizhan.client.wordlock.view.drag.DragView;
//import com.baicizhan.client.wordlock.view.drag.DropSpot;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p050c.ViewHelper;
//import p000a.p001a.p002a.EventBus;
//
//public class MoreWordInfoSpot extends DropSpot {
//    public MoreWordInfoSpot(Context context) {
//        super(context);
//    }
//
//    public MoreWordInfoSpot(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public MoreWordInfoSpot(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    /* access modifiers changed from: protected */
//    public int getEnteredBackgroundRes() {
//        return C0882R.color.wordlock_drag_enter_more_info_color;
//    }
//
//    /* access modifiers changed from: protected */
//    public void doDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
//        View view = (View) obj;
//        int left = (i - i3) + getLeft();
//        int top = getTop() + (i2 - i4);
//        float popScale = dragView.getPopScale();
//        float f = popScale / 2.0f;
//        if (view instanceof TextView) {
//            f = Math.min(((float) getContext().getResources().getDimensionPixelSize(C0882R.dimen.wordlock_mini_word_size)) / ((TextView) view).getTextSize(), 1.0f);
//        }
//        ViewHelper.m3390b(view, 0.0f);
//        ViewHelper.m3391c(view, 0.0f);
//        float dip2px = ((float) Common.dip2px(getContext(), 28.0f)) - (((float) view.getPaddingTop()) * f);
//        View view2 = view;
//        ObjectAnimator a = ObjectAnimator.m3360a(view2, "translationX", (float) (left - view.getLeft()), (((float) Common.dip2px(getContext(), 26.0f)) - (((float) view.getPaddingLeft()) * f)) + ((float) (-view.getLeft()))).mo16215a(300);
//        View view3 = view;
//        ObjectAnimator a2 = ObjectAnimator.m3360a(view3, "translationY", (float) (top - view.getTop()), dip2px + ((float) (-view.getTop()))).mo16215a(300);
//        View view4 = view;
//        ObjectAnimator a3 = ObjectAnimator.m3360a(view4, "scaleX", popScale, f).mo16215a(300);
//        View view5 = view;
//        ObjectAnimator a4 = ObjectAnimator.m3360a(view5, "scaleY", popScale, f).mo16215a(300);
//        a.mo16161a();
//        a2.mo16161a();
//        a3.mo16161a();
//        a4.mo16161a();
//        ObjectAnimator.m3360a(view, "alpha", 1.0f, 0.6f).mo16215a(300).mo16161a();
//        DispMoreInfoEvent dispMoreInfoEvent = new DispMoreInfoEvent();
//        dispMoreInfoEvent.setDelayed(300);
//        EventBus.m0a().mo9c((Object) dispMoreInfoEvent);
//        DropBackEvent dropBackEvent = new DropBackEvent();
//        dropBackEvent.setFrom(1);
//        dropBackEvent.setAnimdur(300);
//        EventBus.m0a().mo9c((Object) dropBackEvent);
//    }
//}
