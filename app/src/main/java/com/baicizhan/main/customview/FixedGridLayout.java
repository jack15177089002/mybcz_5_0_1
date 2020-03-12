//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.view.View.MeasureSpec;
//import android.widget.FrameLayout;
//import com.jiongji.andriod.card.C1651b;
//
//public class FixedGridLayout extends FrameLayout {
//    private int mCellHeight;
//    private int mCellHeightWeight;
//    private int mCellWidth;
//    private int mCellWidthWeight;
//    private int mHorizontalSpacing;
//    private int mNumOfCols;
//    private int mNumOfRows;
//    private int mTotalCellHeight;
//    private int mTotalCellWidth;
//    private int mVerticalSpacing;
//
//    public FixedGridLayout(Context context) {
//        this(context, null);
//    }
//
//    public FixedGridLayout(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0);
//    }
//
//    public FixedGridLayout(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mNumOfRows = 2;
//        this.mNumOfCols = 2;
//        this.mCellWidth = 0;
//        this.mCellHeight = 0;
//        this.mCellWidthWeight = 4;
//        this.mCellHeightWeight = 3;
//        this.mTotalCellWidth = 0;
//        this.mTotalCellHeight = 0;
//        this.mHorizontalSpacing = 10;
//        this.mVerticalSpacing = 10;
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1651b.FixedGridLayout, i, 0);
//        this.mNumOfRows = obtainStyledAttributes.getInt(1, 0);
//        this.mNumOfCols = obtainStyledAttributes.getInt(0, 0);
//        this.mCellWidthWeight = obtainStyledAttributes.getInt(4, 0);
//        this.mCellHeightWeight = obtainStyledAttributes.getInt(5, 0);
//        this.mHorizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(3, 0);
//        this.mVerticalSpacing = obtainStyledAttributes.getDimensionPixelSize(2, 0);
//        obtainStyledAttributes.recycle();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        int size = MeasureSpec.getSize(i);
//        int size2 = MeasureSpec.getSize(i2);
//        if (this.mNumOfRows == 0 || this.mNumOfCols == 0) {
//            super.onMeasure(i, i2);
//            return;
//        }
//        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - ((this.mNumOfCols - 1) * this.mVerticalSpacing)) / this.mNumOfCols;
//        int paddingTop = (((size2 - getPaddingTop()) - getPaddingBottom()) - ((this.mNumOfRows - 1) * this.mHorizontalSpacing)) / this.mNumOfRows;
//        if (this.mCellWidthWeight <= 0 || this.mCellHeightWeight <= 0) {
//            this.mCellWidth = paddingLeft;
//            this.mCellHeight = paddingTop;
//        } else {
//            int i3 = this.mCellHeightWeight * paddingLeft;
//            int i4 = this.mCellWidthWeight * paddingTop;
//            if (i3 > i4) {
//                this.mCellHeight = paddingTop;
//                this.mCellWidth = i4 / this.mCellHeightWeight;
//            } else {
//                this.mCellWidth = paddingLeft;
//                this.mCellHeight = i3 / this.mCellWidthWeight;
//            }
//        }
//        this.mTotalCellWidth = ((this.mNumOfCols - 1) * this.mHorizontalSpacing) + (this.mNumOfCols * this.mCellWidth) + getPaddingLeft() + getPaddingRight();
//        this.mTotalCellHeight = ((this.mNumOfRows - 1) * this.mVerticalSpacing) + (this.mNumOfRows * this.mCellHeight) + getPaddingTop() + getPaddingBottom();
//        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mCellWidth, 1073741824);
//        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.mCellHeight, 1073741824);
//        for (int i5 = 0; i5 < getChildCount(); i5++) {
//            getChildAt(i5).measure(makeMeasureSpec, makeMeasureSpec2);
//        }
//        setMeasuredDimension(size, size2);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
//        if (this.mNumOfRows != 0 && this.mNumOfCols != 0) {
//            int i5 = i4 - i2;
//            int paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalCellWidth) / 2);
//            int paddingTop = ((i5 - this.mTotalCellHeight) / 2) + getPaddingTop();
//            for (int i6 = 0; i6 < getChildCount(); i6++) {
//                int i7 = ((i6 / this.mNumOfCols) * (this.mCellHeight + this.mVerticalSpacing)) + paddingTop;
//                int i8 = ((i6 % this.mNumOfCols) * (this.mCellWidth + this.mHorizontalSpacing)) + paddingLeft;
//                int i9 = this.mCellWidth + i8;
//                getChildAt(i6).layout(i8, i7, i9, this.mCellHeight + i7);
//            }
//        }
//    }
//}
