//package com.baicizhan.client.fight;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.fragment.app.DialogFragment;//import android.support.p004v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.fight.customview.TotalScoreView;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.jsonbean.UserScore;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.DisplayUtils;
//
//public class ShareTotalScoreDialog extends DialogFragment {
//    public static final String TAG = "ShareTotalScoreDialog";
//    /* access modifiers changed from: private */
//    public ShareListener mListener;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setStyle(1, C0691R.style.Fight_DialogStyle);
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
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C0691R.layout.fight_dialog_share_total_score, viewGroup, false);
//        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(C0691R.id.dialog_content);
//        TotalScoreView totalScoreView = (TotalScoreView) viewGroup2.findViewById(C0691R.id.total_score_view);
//        totalScoreView.hideBook();
//        TextView textView = (TextView) viewGroup2.findViewById(C0691R.id.share_total_score_slogan);
//        View findViewById = viewGroup2.findViewById(C0691R.id.close);
//        View findViewById2 = viewGroup2.findViewById(C0691R.id.share_to_weixin_session);
//        View findViewById3 = viewGroup2.findViewById(C0691R.id.share_to_weixin_timeline);
//        LayoutParams layoutParams = viewGroup3.getLayoutParams();
//        layoutParams.height = DisplayUtils.getDisplayPixelHeight(getActivity()) - (DisplayUtils.dpToPx(getActivity(), 10.0f) * 2);
//        viewGroup3.setLayoutParams(layoutParams);
//        findViewById.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                ShareTotalScoreDialog.this.dismiss();
//            }
//        });
//        findViewById2.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                C0789L.log.debug("share to weixin session");
//                OperationStats.statPKShareWXFriend();
//                ShareTotalScoreDialog.this.mListener.onShareToWeixin(0);
//                ShareTotalScoreDialog.this.dismiss();
//            }
//        });
//        findViewById3.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                C0789L.log.debug("share to weixin timeline");
//                OperationStats.statPKShareWXMoments();
//                ShareTotalScoreDialog.this.mListener.onShareToWeixin(1);
//                ShareTotalScoreDialog.this.dismiss();
//            }
//        });
//        VSManager instance = VSManager.getInstance();
//        UserInfo avatar = instance.getAvatar();
//        UserScore totalScore = instance.getTotalScore();
//        totalScoreView.setUserInfo(avatar);
//        totalScoreView.setTotalScore(totalScore);
//        if (!(totalScore == null || totalScore.getPrize() == null)) {
//            String string = getActivity().getString(C0691R.string.fight_share_total_score_slogan, new Object[]{Integer.valueOf(totalScore.getRank())});
//            if (DisplayUtils.getDisplayPixelHeight(getActivity()) <= 480) {
//                textView.setText(string);
//                textView.setGravity(17);
//            } else {
//                textView.setText(string + "。" + totalScore.getPrize().getData());
//            }
//        }
//        return viewGroup2;
//    }
//
//    public void onActivityResult(int i, int i2, Intent intent) {
//        super.onActivityResult(i, i2, intent);
//    }
//}
