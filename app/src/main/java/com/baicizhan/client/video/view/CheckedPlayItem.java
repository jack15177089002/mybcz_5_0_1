//package com.baicizhan.client.video.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Checkable;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.jiongji.andriod.card.R;
////import com.baicizhan.client.video.R;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CheckedPlayItem extends RelativeLayout implements Checkable {
//    private List<Checkable> mCheckableViews = new ArrayList(1);
//    private boolean mChecked = false;
//    private View mItemBg;
//    private TextView mWord;
//
//    public CheckedPlayItem(Context context) {
//        super(context);
//    }
//
//    public CheckedPlayItem(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            findCheckableChildren(getChildAt(i));
//        }
//        this.mItemBg = findViewById(R.id.video_play_item);
//        this.mWord = (TextView) findViewById(R.id.video_play_word);
//    }
//
//    private void findCheckableChildren(View view) {
//        if (view instanceof Checkable) {
//            this.mCheckableViews.add((Checkable) view);
//        }
//        if (view instanceof ViewGroup) {
//            ViewGroup viewGroup = (ViewGroup) view;
//            int childCount = viewGroup.getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                findCheckableChildren(viewGroup.getChildAt(i));
//            }
//        }
//    }
//
//    public boolean isChecked() {
//        return this.mChecked;
//    }
//
//    public void setChecked(boolean z) {
//        this.mChecked = z;
//        for (Checkable checked : this.mCheckableViews) {
//            checked.setChecked(z);
//        }
//        if (this.mChecked) {
//            this.mItemBg.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_progress));
//            this.mWord.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_common_white));
//            return;
//        }
//        this.mItemBg.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_tv_bg));
//        this.mWord.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text_mediabar));
//    }
//
//    public void toggle() {
//        this.mChecked = !this.mChecked;
//        for (Checkable checkable : this.mCheckableViews) {
//            checkable.toggle();
//        }
//    }
//}
