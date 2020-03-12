package com.baicizhan.client.friend.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baicizhan.client.framework.util.DisplayUtils;
import com.jiongji.andriod.card.R;
//import com.baicizhan.client.friend.R;

public class FriendFacetTab extends FrameLayout {
    private TextView mContent;
    private int mDotIntervalX;
    private int mDotRadius;
    private View mIndicator;
    private boolean mNeedCheck;
    private Paint mPromptPaint;

    public FriendFacetTab(Context context) {
        this(context, null, 0);
    }

    public FriendFacetTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendFacetTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNeedCheck = false;
        LayoutInflater.from(context).inflate(R.layout.friend_facet_tab, this);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FriendFacetTab);
//        CharSequence text = obtainStyledAttributes.getText(R.styleable.FriendFacetTab_contentText);
//        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FriendFacetTab_contentTextSize, 0);
//        this.mDotRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FriendFacetTab_dotRadius, 0);
//        int color = obtainStyledAttributes.getColor(R.styleable.FriendFacetTab_dotColor, 0);
//        obtainStyledAttributes.recycle();
//        this.mContent = (TextView) findViewById(R.C0798id.tab_content);
//        this.mContent.setText(text);
//        if (dimensionPixelSize > 0) {
//            this.mContent.setTextSize(0, (float) dimensionPixelSize);
//        }
//        this.mIndicator = findViewById(R.C0798id.tab_indicator);
//        this.mIndicator.setVisibility(4);
//        this.mPromptPaint = new Paint(1);
//        this.mPromptPaint.setColor(color);
//        this.mDotIntervalX = DisplayUtils.dpToPx(context, 1.0f);
    }

    public void setSelected(boolean z) {
        this.mContent.setSelected(z);
        if (z) {
            this.mIndicator.setVisibility(0);
        } else {
            this.mIndicator.setVisibility(4);
        }
        setNeedCheck(false);
    }

    public void setNeedCheck(boolean z) {
        if (this.mNeedCheck != z) {
            this.mNeedCheck = z;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int right = this.mContent.getRight() + this.mDotRadius + this.mDotIntervalX;
        FontMetrics fontMetrics = this.mContent.getPaint().getFontMetrics();
        int top = (int) (((((float) this.mContent.getTop()) + fontMetrics.ascent) - fontMetrics.top) + ((float) this.mDotRadius));
        if (this.mNeedCheck) {
            canvas.drawCircle((float) right, (float) top, (float) this.mDotRadius, this.mPromptPaint);
        }
    }
}
