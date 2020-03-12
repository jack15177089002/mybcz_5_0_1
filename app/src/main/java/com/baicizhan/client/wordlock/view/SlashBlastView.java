package com.baicizhan.client.wordlock.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
//import com.baicizhan.client.wordlock.R;
import com.jiongji.andriod.card.R;

import java.util.ArrayList;
import java.util.List;

public class SlashBlastView extends View {
    public static final int[] SLASH_NUM_IDS = {R.drawable.wordlock_slash_num_0, R.drawable.wordlock_slash_num_1, R.drawable.wordlock_slash_num_2, R.drawable.wordlock_slash_num_3, R.drawable.wordlock_slash_num_4, R.drawable.wordlock_slash_num_5, R.drawable.wordlock_slash_num_6, R.drawable.wordlock_slash_num_7, R.drawable.wordlock_slash_num_8, R.drawable.wordlock_slash_num_9};
    private int mCalHeight = 0;
    private int mCalWidth = 0;
    private int mDisplayedNum = 0;
    private Rect mDrawRect = new Rect();
    private int mHalfHeight;
    private List<BitmapDrawable> mToBeDisplayedDrawable = new ArrayList();

    public SlashBlastView(Context context) {
        super(context);
    }

    public void setSlashNum(int i) {
        this.mDisplayedNum = i;
        this.mToBeDisplayedDrawable.clear();
        if (i == 0) {
            requestLayout();
            return;
        }
        this.mCalWidth = 0;
        this.mCalHeight = 0;
        Resources resources = getResources();
        String valueOf = String.valueOf(this.mDisplayedNum);
        int length = valueOf.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = valueOf.charAt(i2);
            if ('0' <= charAt && charAt <= '9') {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) resources.getDrawable(SLASH_NUM_IDS[Integer.parseInt(String.valueOf(charAt))]);
                this.mToBeDisplayedDrawable.add(bitmapDrawable);
                this.mCalWidth += bitmapDrawable.getIntrinsicWidth();
                this.mCalHeight = Math.max(this.mCalHeight, bitmapDrawable.getIntrinsicHeight());
            }
        }
        this.mHalfHeight = this.mCalHeight / 2;
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) resources.getDrawable(R.drawable.wordlock_slash_char);
        this.mToBeDisplayedDrawable.add(bitmapDrawable2);
        this.mCalWidth += bitmapDrawable2.getIntrinsicWidth();
        this.mCalHeight = Math.max(this.mCalHeight, bitmapDrawable2.getIntrinsicHeight());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
//        super.onMeasure(MeasureSpec.makeMeasureSpec(this.mCalWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mCalHeight, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        for (BitmapDrawable bitmapDrawable : this.mToBeDisplayedDrawable) {
            this.mDrawRect.left = i;
            this.mDrawRect.right = this.mDrawRect.left + bitmapDrawable.getIntrinsicWidth();
            this.mDrawRect.top = this.mHalfHeight - (bitmapDrawable.getIntrinsicHeight() / 2);
            this.mDrawRect.bottom = this.mDrawRect.top + bitmapDrawable.getIntrinsicHeight();
            i = this.mDrawRect.right;
            canvas.drawBitmap(bitmapDrawable.getBitmap(), null, this.mDrawRect, null);
        }
    }

    public int getCalWidth() {
        return this.mCalWidth;
    }

    public int getCalHeight() {
        return this.mCalHeight;
    }
}
