//package com.baicizhan.client.wordtesting.activity;
//
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnKeyListener;
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import com.baicizhan.client.business.widget.FullDialogFragment;
//import com.baicizhan.client.wordtesting.C0933R;
//
//public class BaoguoGayFragment extends FullDialogFragment implements OnClickListener {
//    private View mBaoguo;
//    private View mBaoguoShade;
//    private View mBaoguoTip;
//    private View mBaoguoTipBack;
//    private View mClose;
//    /* access modifiers changed from: private */
//    public boolean mInning = true;
//    private View mMask;
//    /* access modifiers changed from: private */
//    public boolean mOutting = false;
//
//    public static BaoguoGayFragment newInstance() {
//        return new BaoguoGayFragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(C0933R.layout.wordtesting_baoguo, viewGroup);
//        this.mClose = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo_close);
//        this.mMask = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo_mask);
//        this.mBaoguo = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo);
//        this.mBaoguoShade = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo_shade);
//        this.mBaoguoTipBack = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo_tip_back);
//        this.mBaoguoTip = inflate.findViewById(C0933R.C0934id.wordtesting_baoguo_tip);
//        this.mClose.setOnClickListener(this);
//        this.mMask.setOnClickListener(this);
//        m2800in();
//        return inflate;
//    }
//
//    public void onResume() {
//        super.onResume();
//        getDialog().setOnKeyListener(new OnKeyListener() {
//            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
//                if (4 != i) {
//                    return false;
//                }
//                if (1 != keyEvent.getAction()) {
//                    return true;
//                }
//                BaoguoGayFragment.this.dismiss();
//                return true;
//            }
//        });
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (C0933R.C0934id.wordtesting_baoguo_close == id || C0933R.C0934id.wordtesting_baoguo_mask == id) {
//            dismiss();
//        }
//    }
//
//    public void dismiss() {
//        if (!this.mInning && !this.mOutting) {
//            out();
//        }
//    }
//
//    /* renamed from: in */
//    private void m2800in() {
//        this.mBaoguo.setVisibility(0);
//        this.mBaoguoTipBack.setVisibility(0);
//        this.mBaoguoShade.setVisibility(0);
//        this.mBaoguoTip.setVisibility(0);
//        this.mClose.setVisibility(0);
//        this.mMask.startAnimation(AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_fadein));
//        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_translate_in);
//        loadAnimation.setStartOffset(466);
//        this.mBaoguo.startAnimation(loadAnimation);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_tipback_translate_in);
//        loadAnimation2.setStartOffset(466);
//        this.mBaoguoTipBack.startAnimation(loadAnimation2);
//        Animation loadAnimation3 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_shade_translate_in);
//        loadAnimation3.setStartOffset(2466);
//        this.mBaoguoShade.startAnimation(loadAnimation3);
//        Animation loadAnimation4 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_tip_translate_in);
//        loadAnimation4.setStartOffset(2466);
//        this.mBaoguoTip.startAnimation(loadAnimation4);
//        Animation loadAnimation5 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_fadein);
//        loadAnimation5.setStartOffset(2466);
//        this.mClose.startAnimation(loadAnimation5);
//        loadAnimation4.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//                BaoguoGayFragment.this.mInning = false;
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationStart(Animation animation) {
//            }
//        });
//    }
//
//    private void out() {
//        this.mOutting = true;
//        this.mBaoguo.setVisibility(4);
//        this.mBaoguoTipBack.setVisibility(4);
//        this.mBaoguoShade.setVisibility(4);
//        this.mBaoguoTip.setVisibility(4);
//        this.mClose.setVisibility(4);
//        this.mClose.startAnimation(AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_fadeout));
//        this.mBaoguoTip.startAnimation(AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_tip_translate_out));
//        this.mBaoguoShade.startAnimation(AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_shade_translate_out));
//        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_tipback_translate_out);
//        loadAnimation.setStartOffset(700);
//        this.mBaoguoTipBack.startAnimation(loadAnimation);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_translate_out);
//        loadAnimation2.setStartOffset(700);
//        this.mBaoguo.startAnimation(loadAnimation2);
//        Animation loadAnimation3 = AnimationUtils.loadAnimation(getActivity(), C0933R.anim.wordtesting_baoguo_fadeout);
//        loadAnimation3.setStartOffset(2700);
//        this.mMask.startAnimation(loadAnimation3);
//        loadAnimation3.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//                BaoguoGayFragment.this.superDismiss();
//                BaoguoGayFragment.this.mOutting = false;
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationStart(Animation animation) {
//            }
//        });
//    }
//}
