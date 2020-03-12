//package com.baicizhan.main.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.FullDialogFragment;
//import com.jiongji.andriod.card.R;
//
//public class ElseLoginFragment extends FullDialogFragment implements OnClickListener {
//    private OnElseLoginListener mListener;
//
//    public interface OnElseLoginListener {
//        void onLoginRenren();
//
//        void onLoginWeibo();
//    }
//
//    public static ElseLoginFragment newInstance() {
//        return new ElseLoginFragment();
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            this.mListener = (OnElseLoginListener) getActivity();
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement OnElseLoginListener");
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.login_else_dialog, viewGroup);
//        View findViewById = inflate.findViewById(R.id.login_else_container);
//        ThemeResUtil.setCommonBgWideRound(getActivity(), findViewById);
//        findViewById.setOnClickListener(null);
//        inflate.findViewById(R.id.login_else_renren).setOnClickListener(this);
//        inflate.findViewById(R.id.login_else_weibo).setOnClickListener(this);
//        inflate.findViewById(R.id.login_else_close).setOnClickListener(this);
//        this.mTransitionManager.cancelByMask(inflate.findViewById(R.id.login_else_bg_mask));
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
//
//    public void onClick(View view) {
//        if (R.id.login_else_renren == view.getId()) {
//            this.mListener.onLoginRenren();
//            dismiss();
//        } else if (R.id.login_else_weibo == view.getId()) {
//            this.mListener.onLoginWeibo();
//            dismiss();
//        } else if (R.id.login_else_close == view.getId()) {
//            dismiss();
//        }
//    }
//}
