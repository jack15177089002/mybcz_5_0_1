package com.baicizhan.client.wordlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baicizhan.client.framework.util.Common;
import com.jiongji.andriod.card.R;
//import com.baicizhan.client.wordlock.R;
import java.util.ArrayList;

public class DotsNavigation extends LinearLayout {
    private int mCur;
    private int mDotCount;
    private int mDotMargine;
    private int mDotSize;
    private ArrayList<View> mDots;

    public DotsNavigation(Context context) {
        super(context);
    }

    public DotsNavigation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 0;
        applayDefaultAttrs(context);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotsNavigation);
//        int indexCount = obtainStyledAttributes.getIndexCount();
//        for (int i2 = 0; i2 < indexCount; i2++) {
//            int index = obtainStyledAttributes.getIndex(i2);
//            if (R.styleable.DotsNavigation_wordlock_dotCount == index) {
////                this.mDotCount = obtainStyledAttributes.getInteger(index, 0);
////            } else if (R.styleable.DotsNavigation_wordlock_dotSize == index) {
////                this.mDotSize = obtainStyledAttributes.getDimensionPixelSize(index, Common.dip2px(context, 4.0f));
////            } else if (R.styleable.DotsNavigation_wordlock_dotMargine == index) {
////                this.mDotMargine = obtainStyledAttributes.getDimensionPixelSize(index, Common.dip2px(context, 4.0f));
////            }
//        }
//        obtainStyledAttributes.recycle();
        if (this.mDotCount > 0) {
            setOrientation(0);
            this.mDots = new ArrayList<>(this.mDotCount);
            while (true) {
                int i3 = i;
                if (i3 < this.mDotCount) {
                    View view = new View(context);
                    LayoutParams layoutParams = new LayoutParams(this.mDotSize, this.mDotSize);
                    layoutParams.leftMargin = this.mDotMargine;
                    layoutParams.rightMargin = this.mDotMargine;
                    view.setLayoutParams(layoutParams);
                    view.setBackgroundResource(i3 == 0 ? R.drawable.wordlock_pointer_selected : R.drawable.wordlock_pointer);
                    addView(view);
                    this.mDots.add(view);
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void applayDefaultAttrs(Context context) {
        this.mDotCount = 0;
        this.mDotSize = Common.dip2px(context, 4.0f);
        this.mDotMargine = Common.dip2px(context, 4.0f);
    }

    public void setCount(int i, int i2) {
        if (i >= 0 && i2 >= 0 && i2 < i) {
            if (this.mDots == null) {
                this.mDots = new ArrayList<>(i);
            }
            if (this.mCur < i && !this.mDots.isEmpty()) {
                ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer);
            }
            int i3 = i - this.mDotCount;
            if (i3 < 0) {
                int i4 = this.mDotCount;
                while (true) {
                    i4--;
                    if (i4 < this.mDotCount + i3) {
                        break;
                    }
                    this.mDots.remove(i4);
                    removeViewAt(i4);
                }
            } else {
                for (int i5 = this.mDotCount; i5 < this.mDotCount + i3; i5++) {
                    View view = new View(getContext());
                    LayoutParams layoutParams = new LayoutParams(this.mDotSize, this.mDotSize);
                    layoutParams.leftMargin = this.mDotMargine;
                    layoutParams.rightMargin = this.mDotMargine;
                    view.setLayoutParams(layoutParams);
                    view.setBackgroundResource(R.drawable.wordlock_pointer);
                    addView(view);
                    this.mDots.add(view);
                }
            }
            ((View) this.mDots.get(i2)).setBackgroundResource(R.drawable.wordlock_pointer_selected);
            this.mDotCount = i;
            this.mCur = i2;
        }
    }

    public void setCur(int i) {
        if (this.mDotCount > 0 && i >= 0 && i < this.mDotCount) {
            ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer);
            ((View) this.mDots.get(i)).setBackgroundResource(R.drawable.wordlock_pointer_selected);
            this.mCur = i;
        }
    }

    public void next() {
        if (this.mDotCount > 0) {
            ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer);
            this.mCur = (this.mCur + 1) % this.mDotCount;
            ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer_selected);
        }
    }

    public void prev() {
        if (this.mDotCount > 0) {
            ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer);
            this.mCur = ((this.mCur - 1) + this.mDotCount) % this.mDotCount;
            ((View) this.mDots.get(this.mCur)).setBackgroundResource(R.drawable.wordlock_pointer_selected);
        }
    }
}
