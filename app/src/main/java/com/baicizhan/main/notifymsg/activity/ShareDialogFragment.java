//package com.baicizhan.main.notifymsg.activity;
//
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import androidx.fragment.app.DialogFragment;//import android.support.p004v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Toast;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.main.notifymsg.data.NotifyMsgRecord;
//import com.jiongji.andriod.card.R;
//
//public class ShareDialogFragment extends DialogFragment implements OnClickListener {
//    private static final String ARG_MESSAGE = "message";
//    private NotifyMsgRecord mMessage;
//
//    public static ShareDialogFragment newInstance(NotifyMsgRecord notifyMsgRecord) {
//        ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(ARG_MESSAGE, notifyMsgRecord);
//        shareDialogFragment.setArguments(bundle);
//        return shareDialogFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setStyle(1, R.style.bczDialogStyle);
//        this.mMessage = getArguments() != null ? (NotifyMsgRecord) getArguments().getParcelable(ARG_MESSAGE) : null;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.share_weixin_dialog, viewGroup);
//        View findViewById = inflate.findViewById(R.id.share_weixin_container);
//        findViewById.setOnClickListener(null);
//        ThemeResUtil.setMessageShareBg(getActivity(), findViewById);
//        inflate.findViewById(R.id.share_weixin_close).setOnClickListener(this);
//        inflate.findViewById(R.id.share_weixin_timeline).setOnClickListener(this);
//        inflate.findViewById(R.id.share_weixin_friends).setOnClickListener(this);
//        return inflate;
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.share_weixin_close /*2131297007*/:
//                dismiss();
//                return;
//            case R.id.share_weixin_timeline /*2131297009*/:
//                shareToTimeline();
//                return;
//            case R.id.share_weixin_friends /*2131297010*/:
//                shareToFriends();
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void shareToTimeline() {
//        share(1);
//        dismiss();
//        OperationStats.statNotificationShareWXMoments(this.mMessage.getId());
//    }
//
//    private void shareToFriends() {
//        share(0);
//        dismiss();
//        OperationStats.statNotificationShareWXFriend(this.mMessage.getId());
//    }
//
//    private void share(int i) {
//        new WeixinShare(getActivity(), this.mMessage.getContentUrl(), this.mMessage.getTitleDesc(), this.mMessage.getTitle(), BitmapFactory.decodeResource(getResources(), R.drawable.business_baicizhan), i, new AuthCallback<Void>() {
//            /* access modifiers changed from: protected */
//            public void onSuccess(Void voidR) {
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Throwable th) {
//                Toast.makeText(ShareDialogFragment.this.getActivity(), "分享失败，原因:" + th.getMessage(), 0).show();
//            }
//        }).share();
//    }
//}
