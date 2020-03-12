//package com.baicizhan.client.wordtesting.activity;
//
//import android.annotation.SuppressLint;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.RandomStringCreator;
//import com.baicizhan.client.business.widget.FullDialogFragment;
//import com.baicizhan.client.framework.conf.Configure;
//import com.baicizhan.client.wordtesting.C0933R;
//import java.util.Locale;
//
//public class ShareDialogFragment extends FullDialogFragment implements OnClickListener {
//    private static final String ARG_GOSSIP = "gossip";
//    private static final String ARG_SCORE_NUM = "score_num";
//    private View mClose;
//    private TextView mGossip;
//    private String mGossipText;
//    private View mMask;
//    private TextView mScore;
//    private int mScoreNum;
//    private ImageView mShare2Weixin;
//    private ImageView mShare2WeixinTimeline;
//
//    public static ShareDialogFragment newInstance() {
//        return new ShareDialogFragment();
//    }
//
//    public ShareDialogFragment setScoreNum(int i) {
//        Bundle arguments = getArguments();
//        if (arguments == null) {
//            arguments = new Bundle();
//        }
//        arguments.putInt(ARG_SCORE_NUM, i);
//        setArguments(arguments);
//        return this;
//    }
//
//    public ShareDialogFragment setGossip(String str) {
//        Bundle arguments = getArguments();
//        if (arguments == null) {
//            arguments = new Bundle();
//        }
//        arguments.putString(ARG_GOSSIP, str);
//        setArguments(arguments);
//        return this;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mScoreNum = getArguments().getInt(ARG_SCORE_NUM);
//        this.mGossipText = getArguments().getString(ARG_GOSSIP);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(C0933R.layout.wordtesting_result_share, viewGroup);
//        this.mScore = (TextView) inflate.findViewById(C0933R.C0934id.wordtesting_share_score_num);
//        this.mGossip = (TextView) inflate.findViewById(C0933R.C0934id.wordtesting_share_chedan_text);
//        this.mShare2Weixin = (ImageView) inflate.findViewById(C0933R.C0934id.wordtesting_share_to_weixin);
//        this.mShare2WeixinTimeline = (ImageView) inflate.findViewById(C0933R.C0934id.wordtesting_share_to_weixin_timeline);
//        this.mClose = inflate.findViewById(C0933R.C0934id.wordtesting_close);
//        this.mMask = inflate.findViewById(C0933R.C0934id.wordtesting_mask);
//        this.mScore.setText(String.valueOf(this.mScoreNum));
//        this.mGossip.setText(this.mGossipText);
//        this.mShare2Weixin.setOnClickListener(this);
//        this.mShare2WeixinTimeline.setOnClickListener(this);
//        this.mClose.setOnClickListener(this);
//        this.mMask.setOnClickListener(this);
//        inflate.findViewById(C0933R.C0934id.wordtesting_result_share).setOnTouchListener(new OnTouchListener() {
//            @SuppressLint({"ClickableViewAccessibility"})
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });
//        return inflate;
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (C0933R.C0934id.wordtesting_close == id || C0933R.C0934id.wordtesting_mask == id) {
//            dismiss();
//        } else if (C0933R.C0934id.wordtesting_share_to_weixin == id) {
//            OperationStats.statVocabShareWXFriend();
//            share(0);
//            dismiss();
//        } else if (C0933R.C0934id.wordtesting_share_to_weixin_timeline == id) {
//            OperationStats.statVocabShareWXMoments();
//            share(1);
//            dismiss();
//        }
//    }
//
//    private void share(int i) {
//        String value = Configure.getInstance().getValue("wordtesting_logic", "url.share");
//        new WeixinShare(getActivity(), String.format(Locale.US, value, new Object[]{RandomStringCreator.bornDomain(), RandomStringCreator.bornNumCharString(), RandomStringCreator.bornNumCharString(), RandomStringCreator.bornNumCharString()}), this.mGossipText, "我的单词量大概在 " + this.mScoreNum + " 个左右", BitmapFactory.decodeResource(getResources(), C0933R.drawable.business_baicizhan), i, new AuthCallback<Void>() {
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
