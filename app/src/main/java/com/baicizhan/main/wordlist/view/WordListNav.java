//package com.baicizhan.main.wordlist.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.jiongji.andriod.card.R;
//
//public class WordListNav extends LinearLayout implements OnClickListener {
//    public static final int NAV_KILLED = 2;
//    public static final int NAV_LEARNED = 0;
//    public static final int NAV_UNLEARNED = 1;
//    private int mCurNav = -1;
//    private TextView mKilled;
//    private TextView mLearned;
//    private View mLearnedDiv;
//    private OnWordListNavigation mListener;
//    private TextView mUnlearned;
//    private View mUnlearnedDiv;
//
//    public interface OnWordListNavigation {
//        void OnWordListNavChanged(int i);
//    }
//
//    public WordListNav(Context context) {
//        super(context);
//    }
//
//    public WordListNav(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mLearned = (TextView) findViewById(R.id.wordlist_nav_leanrned);
//        ThemeResUtil.setWordListNavBg(getContext(), this.mLearned);
//        this.mLearned.setOnClickListener(this);
//        this.mLearnedDiv = findViewById(R.id.wordlist_nav_learned_div);
//        this.mUnlearned = (TextView) findViewById(R.id.wordlist_nav_unleanrned);
//        ThemeResUtil.setWordListNavBg(getContext(), this.mUnlearned);
//        this.mUnlearned.setOnClickListener(this);
//        this.mUnlearnedDiv = findViewById(R.id.wordlist_nav_unlearned_div);
//        this.mKilled = (TextView) findViewById(R.id.wordlist_nav_killed);
//        ThemeResUtil.setWordListNavBg(getContext(), this.mKilled);
//        this.mKilled.setOnClickListener(this);
//    }
//
//    public void onClick(View view) {
//        int i = -1;
//        if (view == this.mLearned) {
//            i = 0;
//        } else if (view == this.mUnlearned) {
//            i = 1;
//        } else if (view == this.mKilled) {
//            i = 2;
//        }
//        if (i >= 0) {
//            navigateCallback(i);
//            navigateTo(i);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void navigateTo(int i, OnWordListNavigation onWordListNavigation) {
//        this.mListener = onWordListNavigation;
//        navigateTo(i);
//    }
//
//    private void navigateTo(int i) {
//        if (i != this.mCurNav) {
//            this.mCurNav = i;
//            switch (i) {
//                case 0:
//                    this.mLearned.setSelected(true);
//                    this.mUnlearned.setSelected(false);
//                    this.mKilled.setSelected(false);
//                    this.mLearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_progress));
//                    this.mUnlearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mKilled.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mLearnedDiv.setVisibility(4);
//                    this.mUnlearnedDiv.setVisibility(0);
//                    return;
//                case 1:
//                    this.mLearned.setSelected(false);
//                    this.mUnlearned.setSelected(true);
//                    this.mKilled.setSelected(false);
//                    this.mLearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mUnlearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_progress));
//                    this.mKilled.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mLearnedDiv.setVisibility(4);
//                    this.mUnlearnedDiv.setVisibility(4);
//                    return;
//                case 2:
//                    this.mLearned.setSelected(false);
//                    this.mUnlearned.setSelected(false);
//                    this.mKilled.setSelected(true);
//                    this.mLearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mUnlearned.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text));
//                    this.mKilled.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_progress));
//                    this.mLearnedDiv.setVisibility(0);
//                    this.mUnlearnedDiv.setVisibility(4);
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    private void navigateCallback(int i) {
//        Log.d("whiz", "nav callback, pos: " + i + "; listener: " + this.mListener);
//        if (i != this.mCurNav && this.mListener != null) {
//            this.mListener.OnWordListNavChanged(i);
//        }
//    }
//}
