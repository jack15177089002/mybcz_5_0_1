package com.baicizhan.client.friend.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baicizhan.client.business.util.PicassoUtil;
import com.jiongji.andriod.card.R;
//import com.baicizhan.client.friend.R;

public class FriendFeedView extends RelativeLayout {
    private static final int DEFAULT_DIVIDER_HEIGHT = 1;
    private static final int DEFAULT_LINE_COLOR = -13882324;
    private static final int DEFAULT_LINE_WIDTH = 8;
    private static final int DEFAULT_MARKER_RADIUS = 12;
    private TextView mContent;
    private TextView mDateTime;
    private Paint mDividerPaint;
    private int mLineColor;
    private Paint mLinePaint;
    private int mLineWidth;
    private int mMarkerColor;
    private int mMarkerMode;
    private Paint mMarkerPaint;
    private int mMarkerRadius;
    private ImageView mThumb;

    public class MarkerMode {
        public static final int HIDE_BOTTOM = 2;
        public static final int HIDE_NONE = 0;
        public static final int HIDE_TOP = 1;
    }

    public FriendFeedView(Context context) {
        this(context, null);
    }

    public FriendFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FriendFeedView);
//        this.mLineWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FriendFeedView_markerLineWidth, 8);
//        this.mLineColor = obtainStyledAttributes.getColor(R.styleable.FriendFeedView_markerLineColor, DEFAULT_LINE_COLOR);
//        this.mMarkerRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.FriendFeedView_markerRadius, 12);
//        this.mMarkerColor = obtainStyledAttributes.getColor(R.styleable.FriendFeedView_markerColor, 0);
//        this.mMarkerMode = obtainStyledAttributes.getInt(R.styleable.FriendFeedView_markerMode, 0);
//        obtainStyledAttributes.recycle();
        this.mLinePaint = new Paint();
        this.mLinePaint.setColor(this.mLineColor);
        this.mLinePaint.setStrokeWidth((float) this.mLineWidth);
        this.mLinePaint.setStyle(Style.STROKE);
        this.mDividerPaint = new Paint();
        this.mDividerPaint.setColor(this.mLineColor);
        this.mDividerPaint.setStrokeWidth(1.0f);
        this.mDividerPaint.setStyle(Style.STROKE);
        this.mMarkerPaint = new Paint(1);
        this.mMarkerPaint.setColor(this.mMarkerColor);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mThumb = (ImageView) findViewById(R.id.thumb);
        this.mContent = (TextView) findViewById(R.id.content);
        this.mDateTime = (TextView) findViewById(R.id.datetime);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        float left = (float) this.mDateTime.getLeft();
        float height = ((float) getHeight()) / 2.0f;
        if ((this.mMarkerMode & 1) == 0) {
            canvas.drawLine(left, 0.0f, left, height, this.mLinePaint);
        }
        if ((this.mMarkerMode & 2) == 0) {
            canvas.drawLine(left, height, left, (float) getHeight(), this.mLinePaint);
        }
        canvas.drawCircle(left, height, (float) this.mMarkerRadius, this.mMarkerPaint);
        canvas.drawLine((float) this.mContent.getLeft(), (float) (getHeight() - 1), (float) (getWidth() - this.mThumb.getLeft()), (float) (getHeight() - 1), this.mDividerPaint);
    }

    public void setMarkerMode(int i) {
        this.mMarkerMode = i;
        invalidate();
    }

    public void setMarkerRadius(int i) {
        if (this.mMarkerRadius != i) {
            this.mMarkerRadius = i;
            this.mMarkerPaint.setStrokeWidth((float) this.mMarkerRadius);
            invalidate();
        }
    }

    public void setLineColor(int i) {
        if (i != this.mLineColor) {
            this.mLineColor = i;
            this.mLinePaint.setColor(this.mLineColor);
            this.mDividerPaint.setColor(this.mLineColor);
            invalidate();
        }
    }

    public void setMarkerColor(int i) {
        if (i != this.mMarkerColor) {
            this.mMarkerColor = i;
            this.mMarkerPaint.setColor(this.mMarkerColor);
            invalidate();
        }
    }

    public void setThumb(String str) {
        PicassoUtil.loadUserImage(getContext(), this.mThumb, str);
    }

    public void setThumb(int i) {
        this.mThumb.setImageResource(i);
    }

    public void setContent(Spanned spanned) {
        this.mContent.setText(spanned);
    }

    public void setDateTime(String str) {
        this.mDateTime.setText(str);
    }
}
