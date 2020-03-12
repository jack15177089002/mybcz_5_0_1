//package com.baicizhan.client.p029fm.view;
//
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.util.ThemeUtil;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ClickEvent;
//import com.jiongji.andriod.card.R;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmStartFragment */
//public class FmStartFragment extends Fragment implements OnClickListener, IFragmentUpdator {
//    private static final String KEY_TOTAL = "total";
//    private TextView mReviewTipCount;
//    private TextView mReviewTipTime;
//    private int mTotal;
//
//    public static FmStartFragment createInstance(int i) {
//        FmStartFragment fmStartFragment = new FmStartFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(KEY_TOTAL, i);
//        fmStartFragment.setArguments(bundle);
//        return fmStartFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mTotal = getArguments() != null ? getArguments().getInt(KEY_TOTAL) : 0;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fm_line_item_start, viewGroup, false);
//        viewGroup2.setOnClickListener(this);
//        this.mReviewTipCount = (TextView) viewGroup2.findViewById(R.id.fm_start_tip_count);
//        this.mReviewTipTime = (TextView) viewGroup2.findViewById(R.id.fm_start_tip_time);
//        initViews();
//        return viewGroup2;
//    }
//
//    private void initViews() {
//        if (isNight()) {
//            String str = "您会听到<font color='#91F0FF'>" + this.mTotal + "</font>个单词";
//            this.mReviewTipCount.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_fm_firstcard));
//            this.mReviewTipCount.setText(Html.fromHtml(str));
//            String str2 = "大约需要<font color='#91F0FF'>" + (this.mTotal / 2) + "</font>分钟";
//            if (1 == this.mTotal) {
//                str2 = "大约需要<font color='#91F0FF'>0.5</font>分钟";
//            }
//            this.mReviewTipTime.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_fm_firstcard));
//            this.mReviewTipTime.setText(Html.fromHtml(str2));
//            return;
//        }
//        String str3 = "您会听到<font color='#7DADDB'>" + this.mTotal + "</font>个单词";
//        this.mReviewTipCount.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_fm_firstcard));
//        this.mReviewTipCount.setText(Html.fromHtml(str3));
//        String str4 = "大约需要<font color='#7DADDB'>" + (this.mTotal / 2) + "</font>分钟";
//        if (1 == this.mTotal) {
//            str4 = "大约需要<font color='#7DADDB'>0.5</font>分钟";
//        }
//        this.mReviewTipTime.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_fm_firstcard));
//        this.mReviewTipTime.setText(Html.fromHtml(str4));
//    }
//
//    private static boolean isNight() {
//        if (PropertyHelper.getInt(PropertyHelper.NIGHT_MODE) == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public void onClick(View view) {
//        ClickEvent clickEvent = new ClickEvent();
//        clickEvent.setClickType(0);
////        EventBus.m0a().mo9c((Object) clickEvent);
//    }
//
//    public void setEnabled(boolean z) {
//    }
//}
