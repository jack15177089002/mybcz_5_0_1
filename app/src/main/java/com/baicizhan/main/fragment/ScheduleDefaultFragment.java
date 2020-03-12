//package com.baicizhan.main.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.jiongji.andriod.card.R;
//
//public class ScheduleDefaultFragment extends Fragment implements OnClickListener {
//    private OnDefaultScheduleSetListener mListener;
//
//    public interface OnDefaultScheduleSetListener {
//        void onDefaultScheduleSet(boolean z, Fragment fragment);
//    }
//
//    public static ScheduleDefaultFragment newInstance() {
//        return new ScheduleDefaultFragment();
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            this.mListener = (OnDefaultScheduleSetListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement OnDefaultScheduleSetListener");
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.fragment_schedule_default, viewGroup, false);
//        RoundedButton roundedButton = (RoundedButton) inflate.findViewById(R.id.schedule_more_settings);
//        roundedButton.setFillColor(ColorStateListUtils.getSimpleColorStateList(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_plan_bg2), ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_bar_bottom)));
//        roundedButton.setOnClickListener(this);
//        RoundedButton roundedButton2 = (RoundedButton) inflate.findViewById(R.id.schedule_start_default);
//        roundedButton2.setFillColor(ColorStateListUtils.getSimpleColorStateList(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_blue_btn), ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_blue_btn_pressed)));
//        roundedButton2.setOnClickListener(this);
//        return inflate;
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (R.id.schedule_more_settings == id) {
//            toMoreSettings();
//        } else if (R.id.schedule_start_default == id) {
//            toStartDefault();
//        }
//    }
//
//    private void toMoreSettings() {
//        if (this.mListener != null) {
//            this.mListener.onDefaultScheduleSet(false, this);
//        }
//    }
//
//    private void toStartDefault() {
//        if (this.mListener != null) {
//            this.mListener.onDefaultScheduleSet(true, this);
//        }
//    }
//}
