//package com.baicizhan.client.fight;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.FragmentActivity;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LocationUtils;
//import com.baicizhan.client.fight.VSManager.VSState;
//import com.baicizhan.client.fight.customview.ResultDetailAdapter;
//import com.baicizhan.client.fight.customview.VSScoreView;
//import com.baicizhan.client.fight.jsonbean.JoinReply;
//import com.baicizhan.client.fight.jsonbean.Result;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.VSRequest;
//import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.umeng.p092a.MobclickAgent;
//import java.lang.reflect.Type;
//
//public class ResultActivity extends FragmentActivity implements OnClickListener, ShareListener {
//    private static final long JOIN_TIMEOUT = 120000;
//    public static final String TAG = "ResultActivity";
//    private ResultDetailAdapter mAdapter;
//    private AudioPlayer mAudioPlayer;
//    private TextView mDTMeNick;
//    private TextView mDTPartNick;
//    private VSRequest<JoinReply> mJoinRequest;
//    /* access modifiers changed from: private */
//    public long mLastJoinTime;
//    private VSScoreView mScoreView;
//    private AuthCallback<Void> mShareCallback = new AuthCallback<Void>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(Void voidR) {
//            ResultActivity.this.showErrorTip("分享成功");
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            ResultActivity.this.showErrorTip("分享失败，原因:" + th.getMessage());
//        }
//    };
//    /* access modifiers changed from: private */
//    public Button mVSAgain;
//    private ErrorListener mVolleyErrorListener = new ErrorListener() {
//        public void onErrorResponse(VolleyError volleyError) {
//            VSManager.getInstance().reportVolleyError(ResultActivity.this, volleyError);
//            ResultActivity.this.finish();
//        }
//    };
//    private WeixinShare mWeixinShare;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            VSManager.getInstance().pauseHeartBeat();
//            initView();
//            showView();
//            autoJoin();
//        }
//    }
//
//    private void initView() {
//        setContentView(R.layout.fight_activity_result);
//        this.mScoreView = (VSScoreView) findViewById(R.id.vs_score_view);
//        this.mVSAgain = (Button) findViewById(R.id.vs_again);
//        Button button = (Button) findViewById(R.id.vs_show_score);
//        this.mDTMeNick = (TextView) findViewById(R.id.dt_me_nick);
//        this.mDTPartNick = (TextView) findViewById(R.id.dt_part_nick);
//        ListView listView = (ListView) findViewById(16908298);
//        this.mAdapter = new ResultDetailAdapter(this);
//        listView.setAdapter(this.mAdapter);
//        this.mVSAgain.setOnClickListener(this);
//        button.setOnClickListener(this);
//    }
//
//    private void showView() {
//        VSManager instance = VSManager.getInstance();
//        UserInfo avatar = instance.getAvatar();
//        UserInfo rival = instance.getRival();
//        Result result = instance.getResult();
//        if (avatar == null || rival == null || result == null) {
//            finish();
//            return;
//        }
//        this.mScoreView.setVSScore(result, avatar, rival);
//        this.mDTMeNick.setText(VSManager.getInstance().getAvatar().getDisplayName());
//        this.mDTPartNick.setText(VSManager.getInstance().getRival().getDisplayName());
//        this.mAdapter.setResult(result);
//        this.mAdapter.notifyDataSetChanged();
//        this.mAudioPlayer = new AudioPlayer(this);
//        this.mAudioPlayer.newPlayAssets(Constants.ASSETS_AUDIO_VS_RESULT, false);
//    }
//
//    private void autoJoin() {
//        VSManager instance = VSManager.getInstance();
//        String joinUrl = Constants.getJoinUrl(instance.getAvatar(), LocationUtils.with(this).getLocation());
//        Type type = new TypeToken<Response<JoinReply>>() {
//        }.getType();
//        instance.setState(VSState.JOIN);
//        this.mVSAgain.setEnabled(false);
////        this.mJoinRequest = new VSRequest<>(TAG, joinUrl, type, (OnResponseListener<T>) new OnResponseListener<JoinReply>() {
////            public boolean onResponse(ErrorInfo errorInfo, JoinReply joinReply) {
////                if (errorInfo.equals(ErrorInfo.NO_ERROR)) {
////                    VSManager.getInstance().getConfig().resultIntervalMS = joinReply.getResultIntervalMS();
////                    ResultActivity.this.mVSAgain.setEnabled(true);
////                    if (ResultActivity.this.mLastJoinTime == 0) {
////                        ResultActivity.this.mLastJoinTime = System.currentTimeMillis();
////                    } else {
////                        ResultActivity.this.repeatMatch();
////                    }
////                } else {
////                    VSManager.getInstance().reportServerError(ResultActivity.this, errorInfo);
////                    ResultActivity.this.finish();
////                }
////                return true;
////            }
////        }, this.mVolleyErrorListener);
////        this.mJoinRequest.start();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        try {
//            MobclickAgent.m5136b((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        try {
//            MobclickAgent.m5132a((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void showErrorTip(CharSequence charSequence) {
//        Toast.makeText(this, charSequence, 0).show();
//    }
//
//    public void showScoreDialog() {
////        C0066v supportFragmentManager = getSupportFragmentManager();
////        if (supportFragmentManager.mo312a(ShareScoreDialog.TAG) == null) {
////            new ShareScoreDialog().show(supportFragmentManager.mo313a(), ShareScoreDialog.TAG);
////        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        if (this.mWeixinShare != null) {
//            this.mWeixinShare.onNewIntent(intent);
//        }
//    }
//
//    public void onShareToWeixin(int i) {
//        Result result = VSManager.getInstance().getResult();
//        if (result != null) {
//            String shareDetailURLWeixin = result.getShareDetailURLWeixin();
//            if (shareDetailURLWeixin != null) {
//                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.fight_weixin_share_thumb);
//                String weixinTitle = result.getPrize().getWeixinTitle();
//                if (weixinTitle == null) {
//                    weixinTitle = "";
//                }
//                String data = result.getPrize().getData();
//                if (data == null) {
//                    data = "";
//                }
//                this.mWeixinShare = new WeixinShare(this, shareDetailURLWeixin, data, weixinTitle, decodeResource, i, this.mShareCallback);
//                this.mWeixinShare.share();
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void repeatMatch() {
//        VSManager instance = VSManager.getInstance();
//        UserInfo rival = instance.getRival();
//        instance.reset();
//        instance.isRepeatMatch = true;
//        instance.setRival(rival);
//        finish();
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            onBackPressed();
//            VSManager.getInstance().exit();
//        } else if (id == R.id.vs_again) {
//            if (System.currentTimeMillis() - this.mLastJoinTime >= JOIN_TIMEOUT) {
//                this.mJoinRequest.start();
//                this.mVSAgain.setEnabled(false);
//                return;
//            }
//            repeatMatch();
//        } else if (id == R.id.vs_show_score) {
//            OperationStats.statPKShare();
//            showScoreDialog();
//        }
//    }
//}
