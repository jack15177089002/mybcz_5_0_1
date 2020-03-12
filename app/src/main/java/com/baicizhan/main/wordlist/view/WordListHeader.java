//package com.baicizhan.main.wordlist.view;
//
//import android.app.Activity;
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.DeviceUtil;
//import com.baicizhan.main.wordlist.view.WordListNav.OnWordListNavigation;
//import com.jiongji.andriod.card.R;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p050c.ViewHelper;
//
//public class WordListHeader extends LinearLayout implements OnClickListener {
//    public static final int MODE_BOTTOM = 1;
//    public static final int MODE_HIDE = 3;
//    public static final int MODE_TOP = 0;
//    private View mBottom;
//    private Button mEdit;
//    private boolean mEditMode = false;
//    private View mHome;
//    private OnHeaderActionListener mListener;
//    private int mMode = -1;
//    private View mTop;
//    /* access modifiers changed from: private */
//    public TextView mWordCount;
//    private WordListNav mWordListNav;
//    private View mWrongCount;
//
//    public interface OnHeaderActionListener {
//        void onEditModeChanged(boolean z);
//    }
//
//    public WordListHeader(Context context) {
//        super(context);
//    }
//
//    public WordListHeader(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mHome = findViewById(R.id.wordlist_header_home);
//        this.mHome.setOnClickListener(this);
//        this.mWordListNav = (WordListNav) findViewById(R.id.wordlist_navigation);
//        this.mTop = findViewById(R.id.wordlist_header_top);
//        this.mBottom = findViewById(R.id.wordlist_header_bottom);
//        this.mWordCount = (TextView) findViewById(R.id.wordlist_header_word_count);
//        this.mEdit = (Button) findViewById(R.id.wordlist_header_edit);
//        this.mEdit.setOnClickListener(this);
//        this.mWrongCount = findViewById(R.id.wordlist_header_wrong_count);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mEdit) {
//            switchEditMode(true);
//        } else if (view == this.mHome) {
//            Context context = getContext();
//            if (context instanceof Activity) {
//                ((Activity) context).finish();
//            }
//        }
//    }
//
//    public void navigateTo(int i, OnWordListNavigation onWordListNavigation) {
//        this.mWordListNav.navigateTo(i, onWordListNavigation);
//    }
//
//    public void setHeaderActionListener(OnHeaderActionListener onHeaderActionListener) {
//        this.mListener = onHeaderActionListener;
//    }
//
//    public void setWordCount(final int i) {
//        if (shouldPostSetWordCount()) {
//            post(new Runnable() {
//                public void run() {
//                    WordListHeader.this.mWordCount.setText(WordListHeader.this.getResources().getString(R.string.wordlist_header_word_count, new Object[]{Integer.valueOf(i)}));
//                }
//            });
//            return;
//        }
//        this.mWordCount.setText(getResources().getString(R.string.wordlist_header_word_count, new Object[]{Integer.valueOf(i)}));
//    }
//
//    private static boolean shouldPostSetWordCount() {
//        return DeviceUtil.IS_HONG_MI_1S;
//    }
//
//    public void switchEditMode(boolean z) {
//        this.mEditMode = !this.mEditMode;
//        if (this.mEditMode) {
//            this.mEdit.setText(R.string.wordlist_header_complete);
//            this.mWrongCount.setVisibility(8);
//        } else {
//            this.mEdit.setText(R.string.wordlist_header_edit);
//            this.mWrongCount.setVisibility(0);
//        }
//        if (this.mListener != null && z) {
//            this.mListener.onEditModeChanged(this.mEditMode);
//        }
//    }
//
//    public void setEditMode(boolean z) {
//        setEditMode(z, true);
//    }
//
//    public void setEditMode(boolean z, boolean z2) {
//        if (z != this.mEditMode) {
//            switchEditMode(z2);
//        }
//    }
//
//    public boolean isEditMode() {
//        return this.mEditMode;
//    }
//
//    public View getTopPart() {
//        return this.mTop;
//    }
//
//    public View getBottomPart() {
//        return this.mBottom;
//    }
//
//    public int getPartHeight() {
//        return getResources().getDimensionPixelSize(R.dimen.wordlist_header_height);
//    }
//
//    public void setMode(int i, boolean z) {
//        if (this.mMode != i) {
//            int partHeight = getPartHeight();
//            switch (i) {
//                case 0:
//                    setVisibility(0);
//                    if (!z) {
//                        ViewHelper.m3395g(this, 0.0f);
//                        break;
//                    } else {
//                        ObjectAnimator.m3360a(this, "translationY", (float) (-partHeight), 0.0f).mo16215a(200).mo16161a();
//                        break;
//                    }
//                case 1:
//                    setVisibility(0);
//                    if (!z) {
//                        ViewHelper.m3395g(this, (float) (-partHeight));
//                        break;
//                    } else {
//                        ObjectAnimator.m3360a(this, "translationY", 0.0f, (float) (-partHeight)).mo16215a(200).mo16161a();
//                        break;
//                    }
//                case 3:
//                    setVisibility(8);
//                    ViewHelper.m3395g(this, (float) (partHeight * -2));
//                    break;
//            }
//            this.mMode = i;
//        }
//    }
//
//    public int getMode() {
//        return this.mMode;
//    }
//}
