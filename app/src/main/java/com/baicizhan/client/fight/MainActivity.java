//package com.baicizhan.client.fight;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.os.Handler;
////import android.support.p004v4.app.FragmentActivity;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.LinearInterpolator;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import androidx.fragment.app.FragmentActivity;
//
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LocationUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.fight.VSManager.RivalType;
//import com.baicizhan.client.fight.VSManager.VSState;
//import com.baicizhan.client.fight.customview.InformationTabs;
//import com.baicizhan.client.fight.customview.MatchChallengersView;
//import com.baicizhan.client.fight.customview.MatchOptsView;
//import com.baicizhan.client.fight.jsonbean.JoinReply;
//import com.baicizhan.client.fight.jsonbean.MatchInfo;
//import com.baicizhan.client.fight.jsonbean.RandomMatchInfo;
//import com.baicizhan.client.fight.jsonbean.Result;
//import com.baicizhan.client.fight.jsonbean.Score;
//import com.baicizhan.client.fight.jsonbean.Score.Detail;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.jsonbean.UserScore;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.Events.OnGetTotalScore;
//import com.baicizhan.client.fight.util.Events.OnSelectRival;
//import com.baicizhan.client.fight.util.VSRequest;
//import com.baicizhan.client.fight.util.VSRequest.OnPollingTimeoutListener;
//import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
//import com.baicizhan.client.fight.util.VSRequest.URLFactory;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.framework.util.PackageUtils;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.p047d.p048a.C1548at;
//import com.p047d.p048a.ValueAnimator;
//import com.umeng.p092a.MobclickAgent;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
////import p000a.p001a.p002a.EventBus;
//
//public class MainActivity extends FragmentActivity implements ShareListener {
//    /* access modifiers changed from: private */
//    public static final List<String> EMPTY_SELECTED_ME = Collections.emptyList();
//    /* access modifiers changed from: private */
//    public static final List<UserInfo> EMPTY_USERS = Collections.emptyList();
//    private static final int ENTRY_AJACENT = 2;
//    private static final int ENTRY_RANDOM = 1;
//    private static final int MATCH_NOT_SELECT_ME_TIMEOUT = 15000;
//    private static final int MATCH_POLLING_INTERVAL = 3000;
//    private static final int MATCH_POLLING_TIMEOUT = 120000;
//    private static final String TAG = "MainActivity";
//    private final int PAGE_MATCHING = 1;
//    private final int PAGE_OPTION = 2;
//    private final int PAGE_START = 0;
//    View mAdjacentMatchButton;
//    private OnClickListener mAdjacentMatchListener = new OnClickListener() {
//        public void onClick(View view) {
//            view.setEnabled(false);
//            view.setSelected(true);
//            MainActivity.this.switchPage(1);
//            MainActivity.this.startJoin(2);
//        }
//    };
//    /* access modifiers changed from: private */
//    public MatchChallengersView mChallengerPanel;
//    private int mCurrentPage;
//    private Handler mHandler = new Handler();
//    private InformationTabs mInfoPanel;
//    /* access modifiers changed from: private */
//    public long mLastTimeNotSelectMe = 0;
//    /* access modifiers changed from: private */
//    public MatchOptsView mOptionPanel;
//    private int[][] mPages;
//    private View[] mPanels;
//    VSRequest<?> mPollingMatchRequest;
//    View mRandomMatchButton;
//    private OnClickListener mRandomMatchListener = new OnClickListener() {
//        public void onClick(View view) {
//            view.setEnabled(false);
//            view.setSelected(true);
//            MainActivity.this.showErrorTip(R.string.fight_random_match_waiting_tip);
//            MainActivity.this.startJoin(1);
//        }
//    };
//    ValueAnimator mSearchRadarAnimator = ValueAnimator.m3296b(10000, 0);
//    private AuthCallback<Void> mShareCallback = new AuthCallback<Void>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(Void voidR) {
//            MainActivity.this.showErrorTip((CharSequence) "分享成功");
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            MainActivity.this.showErrorTip((CharSequence) "分享失败，原因:" + th.getMessage());
//        }
//    };
//    private Toast mToast;
//    private ErrorListener mVolleyErrorListener = new ErrorListener() {
//        public void onErrorResponse(VolleyError volleyError) {
//            VSManager.getInstance().reportVolleyError(MainActivity.this, volleyError);
//            MainActivity.this.onMatchFailed();
//        }
//    };
//    private WeixinShare mWeixinShare;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            LogWrapper.m2793d(TAG, "onCreate");
//            overridePendingTransition(R.anim.business_push_up_in, R.anim.business_push_up_out);
//            setContentView(R.layout.fight_activity_main);
//            try {
//                MobclickAgent.m5133a(this, UMStats.EVENT_FIGHT_MAIN_ACTIVITY_LOCATION);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            initPanels();
//            findViewById(R.id.back).setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    MainActivity.this.onBackPressed();
//                }
//            });
////            EventBus.m0a().mo5a((Object) this);
//            initAvatar();
//        }
//    }
//
//    private void resetButtonState() {
//        this.mRandomMatchButton.setEnabled(true);
//        this.mRandomMatchButton.setSelected(false);
//        this.mAdjacentMatchButton.setEnabled(true);
//        this.mAdjacentMatchButton.setSelected(false);
//    }
//
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.business_push_down_in, R.anim.business_push_down_out);
//    }
//
//    private void initAvatar() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setNickName(Settings.getString(Settings.PREF_USER_NAME));
//        userInfo.setLocalName(Settings.getString(Settings.PREF_USER_NICKNAME));
//        userInfo.setToken(Settings.getString(Settings.PREF_USER_TOKEN));
//        userInfo.setLocalImagePath(Settings.getString(Settings.PREF_USER_IMAGE));
//        String string = Settings.getString(Settings.PREF_USER_IMAGE_URL);
//        if (TextUtils.isEmpty(string)) {
//            userInfo.setImage("");
//        } else {
//            userInfo.setImage(string);
//        }
//        userInfo.setAppVersion(Float.valueOf(PackageUtils.getFloatPackageVersion(this)));
//        userInfo.setNetwork(NetworkUtils.getActiveNetworkType(this));
//        userInfo.setOs("android");
//        onGetAvatar(userInfo);
//        C0789L.log.info("BaicizhanPath " + Settings.getString(Settings.PREF_BAICIZHAN_PATH));
//        C0789L.log.info("onGetAvatar " + userInfo);
//    }
//
//    public void onResume() {
//        C0789L.log.debug("onResume");
//        super.onResume();
//        try {
//            MobclickAgent.m5136b((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        VSManager instance = VSManager.getInstance();
//        if (!instance.isInfoPanelSynced) {
//            this.mInfoPanel.refreshInformation();
//        }
//        if (instance.isRepeatMatch) {
//            C0789L.log.debug("fast match !!!");
//            instance.isRepeatMatch = false;
//            switchPage(2, false);
//            pollingMatch();
//            return;
//        }
//        C0789L.log.debug("normal match");
//        instance.pauseHeartBeat();
//        switchPage(0, false);
//    }
//
//    public void onPause() {
//        C0789L.log.debug("onPause");
//        super.onPause();
//        try {
//            MobclickAgent.m5132a((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void onDestroy() {
//        C0789L.log.debug("onDestroy");
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(TAG);
//        cancelPollingMatch();
//        this.mHandler.removeCallbacksAndMessages(null);
//        this.mInfoPanel.onDestroy();
//        VSManager.getInstance().isInfoPanelSynced = false;
//        VSManager.getInstance().isRepeatMatch = false;
////        EventBus.m0a().mo8b((Object) this);
//    }
//
//    public void onConfigurationChanged(Configuration configuration) {
//        super.onConfigurationChanged(configuration);
//    }
//
//    private void initPanels() {
//        this.mInfoPanel = (InformationTabs) findViewById(R.id.info_panel);
//        View findViewById = findViewById(R.id.entrance_panel);
//        this.mChallengerPanel = (MatchChallengersView) findViewById(R.id.challenger_panel);
//        View findViewById2 = findViewById(R.id.search_panel);
//        this.mOptionPanel = (MatchOptsView) findViewById(R.id.option_panel);
//        this.mPanels = new View[]{this.mInfoPanel, findViewById, this.mChallengerPanel, findViewById2, this.mOptionPanel};
//        this.mPages = new int[][]{new int[]{0, 1}, new int[]{2, 3}, new int[]{2, 4}};
//        this.mRandomMatchButton = findViewById(R.id.random_match_button);
//        this.mRandomMatchButton.setOnClickListener(this.mRandomMatchListener);
//        this.mAdjacentMatchButton = findViewById(R.id.adjacent_match_button);
//        this.mAdjacentMatchButton.setOnClickListener(this.mAdjacentMatchListener);
//        final ImageView imageView = (ImageView) findViewById2.findViewById(R.id.radar_sweep);
//        this.mSearchRadarAnimator.mo16163a((Object) imageView);
//        this.mSearchRadarAnimator.mo16188b(4000);
//        this.mSearchRadarAnimator.f3481i = -1;
//        this.mSearchRadarAnimator.f3482j = 1;
//        this.mSearchRadarAnimator.f3483k = new LinearInterpolator();
//        this.mSearchRadarAnimator.mo16184a((C1548at) new C1548at() {
//            public void onAnimationUpdate(ValueAnimator amVar) {
//                imageView.setImageLevel(((Integer) amVar.mo16192g()).intValue());
//            }
//        });
//    }
//
//    private void onGetAvatar(UserInfo userInfo) {
//        if (userInfo == null) {
//            showErrorTip(R.string.fight_tip_avatar_null);
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    MainActivity.this.finish();
//                }
//            }, 500);
//            return;
//        }
//        this.mChallengerPanel.setAvatar(userInfo);
//        this.mInfoPanel.setAvatar(userInfo);
//        UserInfo avatar = VSManager.getInstance().getAvatar();
//        if (!userInfo.equals(avatar) || !TextUtils.equals(userInfo.getLocalName(), avatar.getLocalName())) {
//            VSManager.getInstance().setAvatar(userInfo);
//            this.mInfoPanel.refreshInformation();
//        }
//    }
//
//    private boolean checkNetwork() {
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            return true;
//        }
//        showErrorTip(R.string.fight_tip_err_net_diabled);
//        return false;
//    }
//
//    /* access modifiers changed from: private */
//    public void showErrorTip(int i) {
//        showErrorTip((CharSequence) getString(i));
//    }
//
//    /* access modifiers changed from: private */
//    public void showErrorTip(CharSequence charSequence) {
//        if (this.mToast != null) {
//            this.mToast.cancel();
//        }
//        this.mToast = Toast.makeText(this, charSequence, 0);
//        this.mToast.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void switchPage(int i) {
//        switchPage(i, true);
//    }
//
//    private void switchPage(int i, boolean z) {
//        Animation animation;
//        Animation animation2 = null;
//        if (!z) {
//            animation = null;
//        } else if (i > this.mCurrentPage) {
//            animation = AnimationUtils.loadAnimation(this, R.anim.business_push_up_in);
//            animation2 = AnimationUtils.loadAnimation(this, R.anim.business_push_up_out);
//        } else {
//            animation = AnimationUtils.loadAnimation(this, R.anim.business_push_down_in);
//            animation2 = AnimationUtils.loadAnimation(this, R.anim.business_push_down_out);
//        }
//        switch (i) {
//            case 0:
//                this.mChallengerPanel.update(EMPTY_USERS);
//                this.mOptionPanel.update(EMPTY_USERS);
//                this.mSearchRadarAnimator.mo16164b();
//                resetButtonState();
//                break;
//            case 1:
//                this.mSearchRadarAnimator.mo16161a();
//                break;
//        }
//        switchPanel(this.mCurrentPage, i, 0, animation, animation2);
//        switchPanel(this.mCurrentPage, i, 1, animation, animation2);
//        this.mCurrentPage = i;
//    }
//
//    private void switchPanel(int i, int i2, int i3, Animation animation, Animation animation2) {
//        View view = this.mPanels[this.mPages[i][i3]];
//        View view2 = this.mPanels[this.mPages[i2][i3]];
//        if (view2 != view) {
//            view.setVisibility(8);
//            if (animation2 != null) {
//                view.startAnimation(animation2);
//            }
//            view2.setVisibility(0);
//            if (animation != null) {
//                view2.startAnimation(animation);
//            }
//        }
//    }
//
//    public void onBackPressed() {
//        if (this.mCurrentPage == 0) {
//            super.onBackPressed();
//            return;
//        }
//        C0789L.log.debug("onBackPressed");
//        onMatchFailed();
//    }
//
//    public void onEventMainThread(OnGetTotalScore onGetTotalScore) {
//        UserScore totalScore = VSManager.getInstance().getTotalScore();
//        if (totalScore != null) {
//            this.mChallengerPanel.setBook(totalScore.getBook());
//            this.mChallengerPanel.setVocabulary(totalScore.getVocabulary());
//        }
//    }
//
//    public void onEventMainThread(OnSelectRival onSelectRival) {
//        VSManager.getInstance().setRival(onSelectRival.rival);
//        this.mPollingMatchRequest.request();
//        switch (onSelectRival.type) {
//            case TYPE_ACCEPT:
//                this.mOptionPanel.clearSelection();
//                return;
//            case TYPE_CHALLENGE:
//                this.mChallengerPanel.clearSelection();
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void onServerError(ErrorInfo errorInfo) {
//        VSManager.getInstance().reportServerError(this, errorInfo);
//        onMatchFailed();
//    }
//
//    public void startJoin(final int i) {
//        if (!checkNetwork()) {
//            resetButtonState();
//            return;
//        }
//        VSManager instance = VSManager.getInstance();
//        instance.reset();
//        instance.setState(VSState.JOIN);
////        new VSRequest(TAG, Constants.getJoinUrl(instance.getAvatar(), LocationUtils.with(this).getLocation()), new TypeToken<Response<JoinReply>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<JoinReply>() {
////            public boolean onResponse(ErrorInfo errorInfo, JoinReply joinReply) {
////                if (errorInfo.equals(ErrorInfo.NO_ERROR)) {
////                    VSManager instance = VSManager.getInstance();
////                    instance.resumeHeartBeat();
////                    if (joinReply != null) {
////                        instance.getConfig().resultIntervalMS = joinReply.getResultIntervalMS();
////                    }
////                    if (i == 2) {
////                        MainActivity.this.pollingMatch();
////                    } else if (i == 1) {
////                        MainActivity.this.randomMatch();
////                    }
////                } else {
////                    MainActivity.this.onServerError(errorInfo);
////                }
////                return true;
////            }
////        }, this.mVolleyErrorListener).start();
//    }
//
//    /* access modifiers changed from: private */
//    public void randomMatch() {
////        new VSRequest(TAG, Constants.getRandomMatchUrl(VSManager.getInstance().getAvatar()), new TypeToken<Response<RandomMatchInfo>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<RandomMatchInfo>() {
////            public boolean onResponse(ErrorInfo errorInfo, RandomMatchInfo randomMatchInfo) {
////                if (errorInfo.equals(ErrorInfo.NO_ERROR)) {
////                    MainActivity.this.onRandomMatchSuccess(randomMatchInfo);
////                } else if (randomMatchInfo == null || randomMatchInfo.getMatched() == null) {
////                    C0789L.log.debug("random match failed");
////                    MainActivity.this.showErrorTip(R.string.fight_tip_match_timeout);
////                    MainActivity.this.onMatchFailed();
////                }
////                return true;
////            }
////        }, this.mVolleyErrorListener).start();
//    }
//
//    /* access modifiers changed from: private */
//    public void pollingMatch() {
//        VSManager.getInstance().setState(VSState.MATCHING);
//        this.mLastTimeNotSelectMe = System.currentTimeMillis();
////        this.mPollingMatchRequest = new VSRequest<>(TAG, (URLFactory) new URLFactory() {
////            public String get() {
////                return Constants.getMatchUrl(VSManager.getInstance().getAvatar(), VSManager.getInstance().getRivalEncoded());
////            }
////        }, new TypeToken<Response<MatchInfo>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<MatchInfo>() {
////            public boolean onResponse(ErrorInfo errorInfo, MatchInfo matchInfo) {
////                if (errorInfo.getCode() < 0) {
////                    MainActivity.this.onServerError(errorInfo);
////                    return true;
////                } else if (matchInfo == null) {
////                    return false;
////                } else {
////                    UserInfo matched = matchInfo.getMatched();
////                    long currentTimeMillis = System.currentTimeMillis();
////                    VSManager instance = VSManager.getInstance();
////                    if (instance.getRival() != null && (matched == null || !matched.equals(instance.getRival()))) {
////                        long rivalSetTime = currentTimeMillis - instance.getRivalSetTime();
////                        if (rivalSetTime > 15000 && currentTimeMillis - MainActivity.this.mLastTimeNotSelectMe > 15000) {
////                            int i = (int) (rivalSetTime / 15000);
////                            MainActivity.this.mLastTimeNotSelectMe = currentTimeMillis;
////                            if (i == 1) {
////                                MainActivity.this.showErrorTip(R.string.fight_tip_not_select_me_short);
////                            } else {
////                                MainActivity.this.showErrorTip(R.string.fight_tip_not_select_me_long);
////                            }
////                        }
////                    }
////                    if (matched != null) {
////                        MainActivity.this.onMatchSuccess(matched);
////                        return true;
////                    }
////                    List candidates = matchInfo.getCandidates();
////                    if (candidates == null) {
////                        candidates = MainActivity.EMPTY_USERS;
////                    }
////                    List selectedMe = matchInfo.getSelectedMe();
////                    if (selectedMe == null) {
////                        selectedMe = MainActivity.EMPTY_SELECTED_ME;
////                    }
////                    MainActivity.this.onMatchOption(candidates, selectedMe);
////                    return false;
////                }
////            }
////        }, this.mVolleyErrorListener);
//        this.mPollingMatchRequest.setPollingInterval(MATCH_POLLING_INTERVAL);
//        this.mPollingMatchRequest.setPollingTimeout(MATCH_POLLING_TIMEOUT);
//        this.mPollingMatchRequest.setOnPollingTimeoutListener(new OnPollingTimeoutListener() {
//            public void onPollingTimeout() {
//                MainActivity.this.showErrorTip(R.string.fight_tip_match_timeout);
//                MainActivity.this.onMatchFailed();
//            }
//        });
//        this.mPollingMatchRequest.start();
//    }
//
//    private void cancelPollingMatch() {
//        if (this.mPollingMatchRequest != null) {
//            C0789L.log.debug("cancelPollingMatch");
//            this.mPollingMatchRequest.cancel();
//            this.mPollingMatchRequest = null;
//        }
//    }
//
//    private void nextActivity() {
//        cancelPollingMatch();
//        startActivity(new Intent(this, FetchProblemActivity.class));
//        this.mHandler.postDelayed(new Runnable() {
//            public void run() {
//                MainActivity.this.mChallengerPanel.update(MainActivity.EMPTY_USERS);
//                MainActivity.this.mOptionPanel.update(MainActivity.EMPTY_USERS);
//            }
//        }, 1000);
//        VSManager.getInstance().setState(VSState.PREPARE);
//    }
//
//    /* access modifiers changed from: private */
//    public void onRandomMatchSuccess(RandomMatchInfo randomMatchInfo) {
//        VSManager instance = VSManager.getInstance();
//        C0789L.log.debug("onRandomMatchSuccess " + randomMatchInfo);
//        if (randomMatchInfo.getOnline() == 1) {
//            C0789L.log.debug("onRandomMatchSuccess online " + instance.getState());
//            onMatchSuccess(randomMatchInfo.getMatched());
//            return;
//        }
//        C0789L.log.debug("onRandomMatchSuccess offline " + instance.getState());
//        List problems = randomMatchInfo.getProblems();
//        UserInfo matched = randomMatchInfo.getMatched();
//        int[] details = randomMatchInfo.getDetails();
//        Score score = new Score();
//        score.setCorrectCount(randomMatchInfo.getCorrectCount());
//        score.setUseTimeSecond(randomMatchInfo.getUseTime());
//        ArrayList arrayList = new ArrayList(problems.size());
////        for (int i = 0; i < problems.size(); i++) {
////            Detail detail = new Detail();
////            detail.f2272id = i;
////            detail.res = details[i];
////            arrayList.add(detail);
////        }
//        score.setDetails(arrayList);
//        Result result = new Result();
//        result.setB(score);
//        result.setFightId(randomMatchInfo.getFightId());
//        instance.setResult(result);
//        instance.setProblems(problems);
//        instance.setRival(matched);
//        instance.setRivalType(RivalType.OFFLINE);
//        nextActivity();
//    }
//
//    /* access modifiers changed from: private */
//    public void onMatchSuccess(UserInfo userInfo) {
//        C0789L.log.info("Matched, start vs activity..");
//        VSManager instance = VSManager.getInstance();
//        if (instance.getState() == VSState.MATCHING) {
//            instance.setRival(userInfo);
//            instance.setRivalType(RivalType.ONLINE);
//            if (!userInfo.equals(VSManager.getInstance().getRival())) {
//                showErrorTip(R.string.fight_tip_random_matched);
//            }
//            nextActivity();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onMatchFailed() {
//        C0789L.log.debug("onMatchFailed");
//        resetButtonState();
//        VSManager instance = VSManager.getInstance();
//        instance.pauseHeartBeat();
//        instance.reset();
//        VolleyUtils.cancelAllTagRequest(TAG);
//        cancelPollingMatch();
//        if (this.mCurrentPage != 0) {
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    MainActivity.this.switchPage(0);
//                }
//            }, 500);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onMatchOption(List<UserInfo> list, List<String> list2) {
//        if (list.size() == 0) {
//            this.mChallengerPanel.update(EMPTY_USERS);
//            this.mOptionPanel.update(EMPTY_USERS);
//            return;
//        }
//        LinkedList linkedList = new LinkedList();
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            UserInfo userInfo = (UserInfo) it.next();
//            if (list2.contains(userInfo.getToken())) {
//                it.remove();
//                linkedList.add(userInfo);
//            }
//        }
//        this.mChallengerPanel.update(linkedList);
//        this.mOptionPanel.update(list);
//        if (this.mCurrentPage == 1) {
//            switchPage(2);
//        }
//    }
//
//    public void onShareToWeixin(int i) {
//        UserScore totalScore = VSManager.getInstance().getTotalScore();
//        if (totalScore != null) {
//            String shareURLWeixin = totalScore.getShareURLWeixin();
//            if (shareURLWeixin != null) {
//                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.fight_weixin_share_thumb);
//                String weixinTitle = totalScore.getPrize().getWeixinTitle();
//                String data = totalScore.getPrize().getData();
//                if (weixinTitle == null) {
//                    weixinTitle = getString(R.string.fight_share_total_score_slogan, new Object[]{Integer.valueOf(totalScore.getRank())});
//                }
//                if (data == null) {
//                    data = "";
//                }
//                this.mWeixinShare = new WeixinShare(this, shareURLWeixin, data, weixinTitle, decodeResource, i, this.mShareCallback);
//                this.mWeixinShare.share();
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onNewIntent(Intent intent) {
//        LogWrapper.m2793d(TAG, "onNewIntent " + intent);
//        super.onNewIntent(intent);
//        if (this.mWeixinShare != null) {
//            this.mWeixinShare.onNewIntent(intent);
//        }
//    }
//}
