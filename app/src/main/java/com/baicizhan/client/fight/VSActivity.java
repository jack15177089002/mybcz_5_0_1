//package com.baicizhan.client.fight;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Point;
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
////import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.fight.VSManager.RivalType;
//import com.baicizhan.client.fight.VSManager.VSState;
//import com.baicizhan.client.fight.customview.MultiColorsProgress;
//import com.baicizhan.client.fight.customview.RoundProgress;
//import com.baicizhan.client.fight.customview.VSAnswerView;
//import com.baicizhan.client.fight.customview.VSAnswerView.OnAnswerListener;
//import com.baicizhan.client.fight.jsonbean.Problem;
//import com.baicizhan.client.fight.jsonbean.Result;
//import com.baicizhan.client.fight.jsonbean.Score;
//import com.baicizhan.client.fight.jsonbean.Score.Detail;
//import com.baicizhan.client.fight.jsonbean.SubmitReply;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.jsonbean.UserScore;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.VSRequest;
//import com.baicizhan.client.fight.util.VSRequest.OnPollingTimeoutListener;
//import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.umeng.p092a.MobclickAgent;
//import java.util.ArrayList;
//import java.util.List;
//import p012ch.qos.logback.core.spi.AbstractComponentTracker;
//
//public class VSActivity extends Activity {
//    private static final int ERROR_COLOR = -5231832;
//    private static final int PER_ROUND_MS = 10000;
//    private static final int PER_ROUND_SECONDS = 10;
//    private static final int RIGHT_COLOR = -16666201;
//    private static final int ROUND_COUNT_DOWN_INTERVAL_MS = 1000;
//    private static final int ROUND_COUNT_DOWN_INTERVAL_SECONDS = 1;
//    private static final int SUBMIT_WAIT_TIMEOUT = 3000;
//    public static final String TAG = "VSActivity";
//    private OnAnswerListener mAnswerListener = new OnAnswerListener() {
//        public void onFinish() {
//            VSActivity.this.nextRound();
//        }
//
//        public void onAnswer(int i) {
//            VSActivity.this.endRound(i);
//            if (i == -1) {
//                Toast.makeText(VSActivity.this, R.string.fight_tip_answer_error, 0).show();
//            }
//        }
//    };
//    AudioPlayer mAudioPlayer;
//    View mContent;
//    private int mCorrectNum = 0;
//    RoundProgress mCountDNProg;
//    private Runnable mCountDownRunnable = new Runnable() {
//        public void run() {
//            VSActivity.this.onRoundCountDown();
//        }
//    };
//    private int mCurrentRound = 0;
//    private int mCurrentRoundElapsedSeconds = 0;
//    private Handler mHandler = new Handler();
//    private int mMaxUseTime = 0;
//    ImageView mMeHead;
//    TextView mMeNick;
//    ImageView mPartHead;
//    TextView mPartNick;
//    private VSRequest<?> mPollingJudgeRequest;
//    private List<Problem> mProblems;
//    private ArrayList<Detail> mResults;
//    private long mRoundBeginTime = 0;
//    private Runnable mSubmitWaitTimeoutRunnable = new Runnable() {
//        public void run() {
//            VSActivity.this.mVSTip.setVisibility(0);
//            VSActivity.this.mVSTip.setGravity(17);
//            VSActivity.this.mVSTip.setText(R.string.fight_default_wait_result_prompt);
//        }
//    };
//    private int mUseTime = 0;
//    VSAnswerView mVSAnswer;
//    MultiColorsProgress mVSAnswerProg;
//    TextView mVSTip;
//    private ErrorListener mVolleyErrorListener = new ErrorListener() {
//        public void onErrorResponse(VolleyError volleyError) {
//            VSManager.getInstance().reportVolleyError(VSActivity.this, volleyError);
//            VSActivity.this.killActivity();
//        }
//    };
//    private ArrayList<Integer> mWrongWords;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.fight_activity_vs);
//            this.mContent = findViewById(R.id.vs_content);
//            this.mMeHead = (ImageView) findViewById(R.id.vs_me);
//            this.mMeNick = (TextView) findViewById(R.id.me_nick);
//            this.mPartHead = (ImageView) findViewById(R.id.vs_part);
//            this.mPartNick = (TextView) findViewById(R.id.part_nick);
//            this.mCountDNProg = (RoundProgress) findViewById(R.id.count_down);
//            this.mVSAnswer = (VSAnswerView) findViewById(R.id.vs_answer);
//            this.mVSAnswerProg = (MultiColorsProgress) findViewById(R.id.color_progress);
//            this.mVSTip = (TextView) findViewById(R.id.vs_tip);
//            VSManager instance = VSManager.getInstance();
//            UserInfo avatar = instance.getAvatar();
//            UserInfo rival = instance.getRival();
//            this.mProblems = VSManager.getInstance().getProblems();
//            if (avatar == null || rival == null || this.mProblems == null || this.mProblems.size() == 0) {
//                finish();
//                return;
//            }
//            this.mMeNick.setText(avatar.getDisplayName());
//            PicassoUtil.loadAccountUserImage(this, Settings.getString(Settings.PREF_BAICIZHAN_PATH), avatar.getImage(), this.mMeHead, R.drawable.userinfo_photo_normal_default);
//            this.mPartNick.setText(rival.getDisplayName());
//            PicassoUtil.loadUserImage(this, this.mPartHead, rival.getImage());
//            this.mResults = new ArrayList<>(this.mProblems.size());
//            this.mWrongWords = new ArrayList<>(this.mProblems.size());
//            this.mAudioPlayer = new AudioPlayer(this);
//            fight();
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
//        this.mAudioPlayer.play();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(TAG);
//        this.mHandler.removeCallbacksAndMessages(null);
//        stopRoundCountDown();
//        if (this.mPollingJudgeRequest != null) {
//            this.mPollingJudgeRequest.cancel();
//        }
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//        System.gc();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.pause();
//        }
//        try {
//            MobclickAgent.m5132a((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onServerError(ErrorInfo errorInfo) {
//        VSManager.getInstance().reportServerError(this, errorInfo);
//        killActivity();
//    }
//
//    /* access modifiers changed from: private */
//    public void killActivity() {
//        this.mHandler.postDelayed(new Runnable() {
//            public void run() {
//                VSActivity.this.finish();
//            }
//        }, 1000);
//    }
//
//    /* access modifiers changed from: private */
//    public void showErrorTip(int i) {
//        showErrorTip((CharSequence) getString(i));
//    }
//
//    private void showErrorTip(CharSequence charSequence) {
//        Toast.makeText(this, charSequence, 0).show();
//    }
//
//    private void setAnswerProgress(int i, boolean z) {
//        if (z) {
//            this.mVSAnswerProg.setProgress(i, RIGHT_COLOR);
//        } else {
//            this.mVSAnswerProg.setProgress(i, ERROR_COLOR);
//        }
//    }
//
//    private void fight() {
//        VSManager.getInstance().setState(VSState.FIGHT);
//        Point displayPixelSize = DisplayUtils.getDisplayPixelSize(this);
//        this.mContent.measure(MeasureSpec.makeMeasureSpec(displayPixelSize.x, 1073741824), MeasureSpec.makeMeasureSpec(displayPixelSize.y, 1073741824));
//        this.mAudioPlayer.newPlayAssets(Constants.ASSETS_AUDIO_VS_BG, true);
//        this.mUseTime = 0;
//        this.mCurrentRound = 0;
//        this.mCorrectNum = 0;
//        this.mMaxUseTime = this.mProblems.size() * 10000;
//        setAnswerProgress(0, true);
//        nextRound();
//    }
//
//    /* access modifiers changed from: private */
//    public void nextRound() {
//        if (this.mCurrentRound >= this.mProblems.size()) {
//            submit();
//            return;
//        }
//        this.mCurrentRoundElapsedSeconds = 0;
//        this.mRoundBeginTime = System.currentTimeMillis();
//        this.mVSAnswer.updateProblem((Problem) this.mProblems.get(this.mCurrentRound), this.mAnswerListener);
//        startRoundCountDown();
//    }
//
//    /* access modifiers changed from: private */
//    public void endRound(int i) {
//        stopRoundCountDown();
////        Detail detail = new Detail();
////        detail.f2272id = this.mCurrentRound;
////        detail.res = i;
////        this.mResults.add(detail);
////        int size = ((this.mCurrentRound + 1) * 100) / this.mProblems.size();
////        if (i == 0) {
////            this.mCorrectNum++;
////            setAnswerProgress(size, true);
////        } else {
////            this.mWrongWords.add(Integer.valueOf(((Problem) this.mProblems.get(this.mCurrentRound)).getTopicId()));
////            setAnswerProgress(size, false);
////        }
////        this.mUseTime = (int) (Math.min(System.currentTimeMillis() - this.mRoundBeginTime, AbstractComponentTracker.LINGERING_TIMEOUT) + ((long) this.mUseTime));
////        this.mCurrentRound++;
//    }
//
//    private void startRoundCountDown() {
//        this.mCountDNProg.startCountDown(AbstractComponentTracker.LINGERING_TIMEOUT);
//        onRoundCountDown();
//    }
//
//    private void stopRoundCountDown() {
//        this.mHandler.removeCallbacks(this.mCountDownRunnable);
//        this.mCountDNProg.pauseCountDown();
//    }
//
//    /* access modifiers changed from: private */
//    public void onRoundCountDown() {
//        if (!isFinishing()) {
//            this.mCountDNProg.setProgText((CharSequence) String.valueOf(10 - this.mCurrentRoundElapsedSeconds));
//            if (this.mCurrentRoundElapsedSeconds >= 10) {
//                endRound(-1);
//                this.mVSAnswer.showAnswer(-1);
//                return;
//            }
//            this.mCurrentRoundElapsedSeconds++;
//            this.mHandler.postDelayed(this.mCountDownRunnable, 1000);
//        }
//    }
//
//    private void submit() {
//        String submitUrl;
//        this.mCountDNProg.setVisibility(8);
//        this.mAudioPlayer.stop();
//        this.mCountDNProg.setVisibility(4);
//        this.mVSAnswer.setVisibility(4);
//        Score score = new Score();
//        score.setCorrectCount(this.mCorrectNum);
//        score.setUseTimeSecond(this.mUseTime);
//        score.setDetails(this.mResults);
//        if (VSManager.getInstance().getRivalType() == RivalType.ONLINE) {
//            submitUrl = Constants.getSubmitUrl(VSManager.getInstance().getAvatar(), score, null);
//        } else {
//            Result result = VSManager.getInstance().getResult();
//            result.setA(score);
//            result.judge();
//            score.setLocalResult(result.getRes());
//            submitUrl = Constants.getSubmitUrl(VSManager.getInstance().getAvatar(), score, result.getFightId());
//        }
//        this.mHandler.postDelayed(this.mSubmitWaitTimeoutRunnable, 3000);
////        new VSRequest(TAG, submitUrl, new TypeToken<Response<SubmitReply>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<SubmitReply>() {
////            public boolean onResponse(ErrorInfo errorInfo, SubmitReply submitReply) {
////                if (errorInfo.getCode() == 0) {
////                    VSActivity.this.onSubmit(submitReply);
////                } else {
////                    VSActivity.this.onServerError(errorInfo);
////                }
////                return true;
////            }
////        }, this.mVolleyErrorListener).start();
//    }
//
//    /* access modifiers changed from: private */
//    public void onSubmit(SubmitReply submitReply) {
//        if (this.mVSTip.getVisibility() == 8 || TextUtils.isEmpty(this.mVSTip.getText())) {
//            this.mHandler.removeCallbacks(this.mSubmitWaitTimeoutRunnable);
//            this.mVSTip.setVisibility(0);
//            this.mVSTip.setText(submitReply.getPrompt());
//        }
//        if (VSManager.getInstance().getRivalType() == RivalType.ONLINE) {
//            VSManager.getInstance().setState(VSState.JUDGE);
//            pollingJudge();
//            return;
//        }
//        final Result result = VSManager.getInstance().getResult();
//        result.setPrize(submitReply.getPrize());
//        result.setShareDetailURLWeibo(submitReply.getShareDetailURLWeibo());
//        result.setShareDetailURLWeixin(submitReply.getShareDetailURLWeixin());
//        long useTimeSecond = (long) (result.getB().getUseTimeSecond() - result.getA().getUseTimeSecond());
//        if (useTimeSecond > 0) {
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    VSActivity.this.onGetResult(result);
//                }
//            }, useTimeSecond);
//        } else {
//            onGetResult(result);
//        }
//    }
//
//    private void pollingJudge() {
////        this.mPollingJudgeRequest = new VSRequest<>(TAG, Constants.getResultUrl(VSManager.getInstance().getAvatar()), new TypeToken<Response<Result>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<Result>() {
////            public boolean onResponse(ErrorInfo errorInfo, Result result) {
////                if (errorInfo.getCode() == 0) {
////                    VSActivity.this.onGetResult(result);
////                    return true;
////                } else if (errorInfo.equals(ErrorInfo.WAITING)) {
////                    return false;
////                } else {
////                    VSActivity.this.onServerError(errorInfo);
////                    return true;
////                }
////            }
////        }, this.mVolleyErrorListener);
//        int i = this.mMaxUseTime - this.mUseTime;
//        this.mPollingJudgeRequest.setPollingInterval(Math.min(VSManager.getInstance().getConfig().resultIntervalMS, 1000));
//        this.mPollingJudgeRequest.setPollingTimeout(i);
//        this.mPollingJudgeRequest.setOnPollingTimeoutListener(new OnPollingTimeoutListener() {
//            public void onPollingTimeout() {
//                VSActivity.this.showErrorTip(R.string.fight_tip_wait_judge_timeout);
//                VSActivity.this.killActivity();
//            }
//        });
//        this.mPollingJudgeRequest.start();
//    }
//
//    /* access modifiers changed from: private */
//    public void onGetResult(Result result) {
//        if (result == null) {
//            showErrorTip(R.string.fight_tip_result_null);
//            killActivity();
//            return;
//        }
//        UserScore totalScore = VSManager.getInstance().getTotalScore();
//        if (totalScore != null) {
//            switch (result.getRes()) {
//                case -1:
//                    totalScore.setLoseCount(totalScore.getLoseCount() + 1);
//                    break;
//                case 1:
//                    totalScore.setWinCount(totalScore.getWinCount() + 1);
//                    break;
//            }
//        }
//        VSManager instance = VSManager.getInstance();
//        instance.setResult(result);
//        instance.setState(VSState.RESULT);
//        instance.isInfoPanelSynced = false;
//        recordWrongWords(this.mWrongWords);
//        startActivity(new Intent(this, ResultActivity.class));
//        finish();
//    }
//
//    private void recordWrongWords(List<Integer> list) {
//        for (Integer intValue : list) {
////            LearnRecordManager.getInstance().doneWrongForReview(intValue.intValue());
//        }
//    }
//}
