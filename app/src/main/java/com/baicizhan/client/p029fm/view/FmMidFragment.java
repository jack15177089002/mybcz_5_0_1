//package com.baicizhan.client.p029fm.view;
//
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.data.FmData;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ClickEvent;
//import com.jiongji.andriod.card.R;
//
//import java.util.ArrayList;
//import java.util.Iterator;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmMidFragment */
//public class FmMidFragment extends Fragment implements OnClickListener, IFragmentUpdator {
//    private static final String KEY_DATAS = "datas";
//    private ArrayList<FmData> mDatas;
//    private View mDivider;
//    private LinearLayout mReviewLeft;
//    private LinearLayout mReviewRight;
//    private TextView mReviewTitle;
//    private TextView mReviewTitleEn;
//
//    public static FmMidFragment createInstance(ArrayList<FmData> arrayList) {
//        FmMidFragment fmMidFragment = new FmMidFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList(KEY_DATAS, arrayList);
//        fmMidFragment.setArguments(bundle);
//        return fmMidFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (getArguments() != null) {
//            this.mDatas = getArguments().getParcelableArrayList(KEY_DATAS);
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fm_line_item_mid, viewGroup, false);
//        viewGroup2.setOnClickListener(this);
//        this.mReviewTitle = (TextView) viewGroup2.findViewById(R.id.fm_line_review);
//        this.mReviewTitleEn = (TextView) viewGroup2.findViewById(R.id.fm_line_review_en);
//        this.mDivider = viewGroup2.findViewById(R.id.fm_line_mid_divider);
//        this.mReviewLeft = (LinearLayout) viewGroup2.findViewById(R.id.fm_line_review_left);
//        this.mReviewRight = (LinearLayout) viewGroup2.findViewById(R.id.fm_line_review_right);
//        initDatas();
//        return viewGroup2;
//    }
//
//    private void initDatas() {
//        LayoutParams layoutParams = new LayoutParams(-1, -2);
//        layoutParams.topMargin = Common.dip2px(getActivity(), 9.0f);
//        Iterator it = this.mDatas.iterator();
//        int i = 0;
//        while (it.hasNext()) {
//            FmData fmData = (FmData) it.next();
//            TextView textView = new TextView(getActivity());
//            textView.setTextColor(getResources().getColor(R.color.C13));
//            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.business_fs4));
//            textView.setText(fmData.getWord());
//            textView.setLayoutParams(layoutParams);
//            textView.setGravity(1);
//            if (i < 5) {
//                this.mReviewLeft.addView(textView);
//            } else {
//                this.mReviewRight.addView(textView);
//            }
//            i++;
//        }
//    }
//
//    public void onClick(View view) {
//        ClickEvent clickEvent = new ClickEvent();
//        clickEvent.setClickType(0);
////        EventBus.m0a().mo9c((Object) clickEvent);
//    }
//
//    public void setEnabled(boolean z) {
//        setReviewEnabled(this.mReviewLeft, z);
//        setReviewEnabled(this.mReviewRight, z);
//        this.mReviewTitle.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_firstcard : R.attr.color_fm_disabled));
//        this.mReviewTitleEn.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_firstcard : R.attr.color_fm_disabled));
//        this.mDivider.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_line_fm : R.attr.color_fm_disabled));
//    }
//
//    private void setReviewEnabled(LinearLayout linearLayout, boolean z) {
//        int childCount = linearLayout.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            ((TextView) linearLayout.getChildAt(i)).setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_deep_blue : R.attr.color_fm_disabled));
//        }
//    }
//}
