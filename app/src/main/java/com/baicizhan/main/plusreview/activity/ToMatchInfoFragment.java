//package com.baicizhan.main.plusreview.activity;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.FullDialogFragment;
//import com.jiongji.andriod.card.R;
//
//public class ToMatchInfoFragment extends FullDialogFragment {
//    public static ToMatchInfoFragment newInstance() {
//        return new ToMatchInfoFragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.plusreview_phrase_match_info_dialog, viewGroup);
//        ThemeResUtil.setWindowOutline(getActivity(), inflate.findViewById(R.id.plusreview_outline));
//        ThemeResUtil.setCommonBg(getActivity(), inflate.findViewById(R.id.plusreview_intline));
//        this.mTransitionManager.cancelByMask(inflate.findViewById(R.id.plusreview_bg_mask));
//        this.mTransitionManager.fadeIn(inflate);
//        return inflate;
//    }
//
//    public void onResume() {
//        super.onResume();
//        this.mTransitionManager.overBackOnResume();
//    }
//
//    public void dismiss() {
//        this.mTransitionManager.fadeOut(getView());
//    }
//}
