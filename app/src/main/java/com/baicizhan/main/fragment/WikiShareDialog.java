//package com.baicizhan.main.fragment;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.jiongji.andriod.card.R;
//
//public class WikiShareDialog extends Dialog implements OnClickListener {
//    private static final String TAG = WikiShareDialog.class.getSimpleName();
//    private OnClickListener mShareClickListener;
//
//    public WikiShareDialog(Context context) {
//        super(context, R.style.bczDialogStyle);
//        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.share_weixin_dialog, null, false);
//        inflate.findViewById(R.id.share_weixin_close).setOnClickListener(this);
//        inflate.findViewById(R.id.share_weixin_friends).setOnClickListener(this);
//        inflate.findViewById(R.id.share_weixin_timeline).setOnClickListener(this);
//        ThemeResUtil.setBackgroundShape(getContext(), inflate, R.attr.color_message_sharebg, 4.0f);
//        setContentView(inflate);
//    }
//
//    public void setShareClickListener(OnClickListener onClickListener) {
//        this.mShareClickListener = onClickListener;
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.share_weixin_close /*2131297007*/:
//                dismiss();
//                return;
//            case R.id.share_weixin_timeline /*2131297009*/:
//                this.mShareClickListener.onClick(view);
//                dismiss();
//                OperationStats.statWikiShareEXMoments();
//                return;
//            case R.id.share_weixin_friends /*2131297010*/:
//                this.mShareClickListener.onClick(view);
//                dismiss();
//                OperationStats.statWikiShareWXFriend();
//                return;
//            default:
//                return;
//        }
//    }
//}
