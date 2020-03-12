//package com.baicizhan.client.business.widget;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.Common;
//
//public class CommentCircleProgressView extends LinearLayout {
//    private TextView mComment;
//    private CircleProgressView mProgress;
//
//    public CommentCircleProgressView(Context context) {
//        super(context);
//        init(context, null);
//    }
//
//    public CommentCircleProgressView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init(context, attributeSet);
//    }
//
//    private void init(Context context, AttributeSet attributeSet) {
//        setOrientation(1);
//        setGravity(1);
//        this.mProgress = new CircleProgressView(context, attributeSet);
//        addView(this.mProgress, -2, -2);
//        this.mComment = new TextView(context);
//        this.mComment.setPadding(0, Common.dip2px(context, 2.0f), 0, 0);
//        this.mComment.setIncludeFontPadding(false);
//        this.mComment.setGravity(17);
//        this.mComment.setTextColor(ThemeUtil.getThemeColorWithAttr(context, R.attr.color_button_text_mediabar));
//        this.mComment.setTextSize(0, getResources().getDimension(R.dimen.f2213T1));
//        addView(this.mComment, -2, -2);
//    }
//
//    public void setProgress(int i) {
//        this.mProgress.setProgress(i);
//    }
//
//    public void setMaxProgress(int i) {
//        this.mProgress.setMaxProgress(i);
//    }
//
//    public void setComment(CharSequence charSequence) {
//        this.mComment.setText(charSequence);
//    }
//
//    public void setComment(int i) {
//        this.mComment.setText(i);
//    }
//
//    public void setCommentSize(int i) {
//        this.mComment.setTextSize(0, (float) i);
//    }
//
//    public void setCommentColor(int i) {
//        this.mComment.setTextColor(i);
//    }
//
//    public void setDividerHeight(int i) {
//        this.mComment.setPadding(this.mComment.getPaddingLeft(), i, this.mComment.getPaddingRight(), this.mComment.getPaddingBottom());
//    }
//}
