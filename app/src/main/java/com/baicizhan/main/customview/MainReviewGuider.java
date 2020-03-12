//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.animation.AlphaAnimation;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.HollowDrawable;
//import com.baicizhan.client.business.widget.HollowDrawable.CircleHollow;
//import com.baicizhan.client.business.widget.HollowDrawable.RectHollow;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.utils.GuideFlags;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//
//public class MainReviewGuider extends FrameLayout {
//    private View mGuideTipPK;
//    private TextView mGuideTipReview;
//    private HollowDrawable mHoleBackground;
//
//    public MainReviewGuider(Context context) {
//        super(context);
//        init();
//    }
//
//    public MainReviewGuider(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init();
//    }
//
//    public MainReviewGuider(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        init();
//    }
//
//    private void init() {
//        this.mHoleBackground = HollowDrawable.born().setMaskColor(getResources().getColor(R.color.C50));
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mGuideTipReview = (TextView) findViewById(R.id.guide_tip_review);
//        ThemeResUtil.setShape(getContext(), this.mGuideTipReview, getResources().getColor(R.color.C32), 4);
//        this.mGuideTipPK = findViewById(R.id.guide_tip_pk);
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if (motionEvent.getAction() == 0) {
//            gone();
//        }
//        return false;
//    }
//
//    public void gone() {
//        if (getVisibility() != 8) {
//            setVisibility(8);
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation.setDuration(200);
//            startAnimation(alphaAnimation);
//            GuideFlags.disableGuide(2048);
//        }
//    }
//
//    public MainReviewGuider setPKLocation(ImageView imageView) {
//        if (imageView != null) {
//            int[] iArr = new int[2];
//            imageView.getLocationInWindow(iArr);
//            this.mHoleBackground.digCircleHollow(new CircleHollow(getValideRect(imageView, Common.dip2px(getContext(), 3.0f))));
//            this.mGuideTipPK.setX((float) (iArr[0] + imageView.getWidth()));
//            this.mGuideTipPK.setY((float) iArr[1]);
//        }
//        return this;
//    }
//
//    public MainReviewGuider setPlusreviewLocation(ImageView imageView) {
//        if (imageView != null) {
//            this.mHoleBackground.digRectHollow(new RectHollow(getValideRect(imageView), (float) Common.dip2px(getContext(), 4.0f)));
//        }
//        return this;
//    }
//
//    public MainReviewGuider setFmTvLocation(ImageView imageView) {
//        if (imageView != null) {
//            this.mHoleBackground.digRectHollow(new RectHollow(getValideRect(imageView), (float) Common.dip2px(getContext(), 4.0f)));
//        }
//        return this;
//    }
//
//    private static RectF getValideRect(ImageView imageView) {
//        return getValideRect(imageView, 0);
//    }
//
//    private static RectF getValideRect(ImageView imageView, int i) {
//        int[] iArr = new int[2];
//        imageView.getLocationInWindow(iArr);
//        Rect bounds = imageView.getDrawable().getBounds();
//        return new RectF((float) ((iArr[0] + imageView.getPaddingLeft()) - i), (float) ((iArr[1] + imageView.getPaddingTop()) - i), (float) (iArr[0] + imageView.getPaddingLeft() + bounds.width() + i), (float) (iArr[1] + imageView.getPaddingTop() + bounds.height() + i));
//    }
//
//    public MainReviewGuider showUp() {
//        C1604j.m3631a(this, this.mHoleBackground);
//        return this;
//    }
//}
