//package com.baicizhan.client.fight;
//
//import android.app.Activity;
//import android.os.Bundle;
//import androidx.fragment.app.DialogFragment;//import android.support.p004v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.fight.customview.VSScoreView;
//import com.baicizhan.client.fight.jsonbean.Result;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.DisplayUtils;
//
//public class ShareScoreDialog extends DialogFragment {
//    public static final String TAG = "ShowScoreDialog";
//    /* access modifiers changed from: private */
//    public ShareListener mListener;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setStyle(0, C0691R.style.Fight_DialogStyle);
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            this.mListener = (ShareListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement ShareListener");
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C0691R.layout.fight_dialog_share_score, viewGroup, false);
//        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(C0691R.id.dialog_content);
//        LayoutParams layoutParams = viewGroup3.getLayoutParams();
//        layoutParams.height = DisplayUtils.getDisplayPixelHeight(getActivity()) - (DisplayUtils.dpToPx(getActivity(), 10.0f) * 2);
//        viewGroup3.setLayoutParams(layoutParams);
//        VSScoreView vSScoreView = (VSScoreView) viewGroup2.findViewById(C0691R.id.vs_score_view);
//        TextView textView = (TextView) viewGroup2.findViewById(C0691R.id.share_score_slogan);
//        View findViewById = viewGroup2.findViewById(C0691R.id.close);
//        View findViewById2 = viewGroup2.findViewById(C0691R.id.share_to_weixin_session);
//        View findViewById3 = viewGroup2.findViewById(C0691R.id.share_to_weixin_timeline);
//        findViewById.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                ShareScoreDialog.this.dismiss();
//            }
//        });
//        findViewById2.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                C0789L.log.debug("share to weibo");
//                OperationStats.statPKShareWXFriend();
//                ShareScoreDialog.this.mListener.onShareToWeixin(0);
//                ShareScoreDialog.this.dismiss();
//            }
//        });
//        findViewById3.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                C0789L.log.debug("share to weixin");
//                OperationStats.statPKShareWXMoments();
//                ShareScoreDialog.this.mListener.onShareToWeixin(1);
//                ShareScoreDialog.this.dismiss();
//            }
//        });
//        VSManager instance = VSManager.getInstance();
//        UserInfo avatar = instance.getAvatar();
//        UserInfo rival = instance.getRival();
//        Result result = instance.getResult();
//        vSScoreView.setVSScore(result, avatar, rival);
//        if (!(result == null || result.getPrize() == null)) {
//            textView.setText(result.getPrize().getData());
//        }
//        return viewGroup2;
//    }
//}
