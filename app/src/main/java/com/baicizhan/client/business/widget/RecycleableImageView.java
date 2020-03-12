package com.baicizhan.client.business.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.handmark.pulltorefresh.library.p057a.C1604j;

public class RecycleableImageView extends ImageView {
    private boolean mAutoRecycle = false;

    public RecycleableImageView(Context context) {
        super(context);
        init(null, R.style.DefaultRecycleableImageView);
    }

    public RecycleableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.style.DefaultRecycleableImageView);
    }

    public RecycleableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, R.style.DefaultRecycleableImageView);
    }

    private void init(AttributeSet attributeSet, int i) {
//        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RecycleableImageView, 0, i);
//        this.mAutoRecycle = obtainStyledAttributes.getBoolean(R.styleable.RecycleableImageView_autoRecycle, false);
//        obtainStyledAttributes.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.mAutoRecycle) {
        }
    }

    public void recycleSrc() {
        recycleDrawable(getDrawable());
    }

    public void recycleBackground() {
        recycleDrawable(getBackground());
    }

    private void recycleDrawable(Drawable drawable) {
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                bitmap.isRecycled();
            }
        }
    }

    public void recycleOnDestroy() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (getDrawable() != null) {
            setImageDrawable(colorDrawable);
        }
        if (getBackground() != null) {
            C1604j.m3631a(this, colorDrawable);
        }
    }

    public void setAutoRecycle(boolean z) {
        this.mAutoRecycle = z;
    }
}
