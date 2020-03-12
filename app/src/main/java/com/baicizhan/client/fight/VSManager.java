package com.baicizhan.client.fight;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.baicizhan.client.business.jsonbean.ErrorInfo;
import com.baicizhan.client.business.jsonbean.Response;
import com.baicizhan.client.fight.jsonbean.Problem;
import com.baicizhan.client.fight.jsonbean.Result;
import com.baicizhan.client.fight.jsonbean.UserInfo;
import com.baicizhan.client.fight.jsonbean.UserScore;
import com.baicizhan.client.fight.util.Constants;
import com.baicizhan.client.fight.util.GsonRequest;
import com.baicizhan.client.fight.util.VSRequest;
import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
import com.baicizhan.client.fight.util.VSUtils;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.VolleyUtils;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.util.List;

public final class VSManager {
    public static final String TAG = "VSManager";
    static VSManager sInstance = null;
    public boolean isInfoPanelSynced = false;
    public boolean isRepeatMatch = false;
    private UserInfo mAvatar = null;
    private Config mConfig = new Config();
    private VSRequest<?> mHeartBeatRequest = null;
    private List<Problem> mProblems = null;
    private Result mResult = null;
    private UserInfo mRival = null;
    private UserInfo mRivalEncoded = null;
    private long mRivalSetTime = 0;
    private RivalType mRivalType = RivalType.ONLINE;
    private VSState mState = VSState.IDLE;
    private UserScore mTotalScore = null;

    public class Config {
        public static final int MIN_INTERVAL_MS = 1000;
        public boolean hideServerError = false;
        public int resultIntervalMS = 1000;
    }

    public enum RivalType {
        OFFLINE,
        ONLINE
    }

    public enum VSState {
        IDLE,
        JOIN,
        MATCHING,
        PREPARE,
        READY,
        FIGHT,
        JUDGE,
        RESULT
    }

    public final Config getConfig() {
        return this.mConfig;
    }

    public static VSManager getInstance() {
        if (sInstance == null) {
            synchronized (VSManager.class) {
                if (sInstance == null) {
                    sInstance = new VSManager();
                }
            }
        }
        return sInstance;
    }

    public final RivalType getRivalType() {
        return this.mRivalType;
    }

    public final void setRivalType(RivalType rivalType) {
        this.mRivalType = rivalType;
    }

    public final void setResult(Result result) {
        this.mResult = result;
    }

    public final Result getResult() {
        return this.mResult;
    }

    public final UserScore getTotalScore() {
        return this.mTotalScore;
    }

    public final void setTotalScore(UserScore userScore) {
        this.mTotalScore = userScore;
    }

    public final void setState(VSState vSState) {
        C0789L.log.debug("setState " + vSState.toString());
        this.mState = vSState;
    }

    public final VSState getState() {
        return this.mState;
    }

    public final UserInfo getAvatar() {
        return this.mAvatar;
    }

    public final void setAvatar(UserInfo userInfo) {
        this.mAvatar = userInfo;
    }

    public final UserInfo getRival() {
        return this.mRival;
    }

    public final UserInfo getRivalEncoded() {
        return this.mRivalEncoded;
    }

    public final long getRivalSetTime() {
        return this.mRivalSetTime;
    }

    public final void setRival(UserInfo userInfo) {
        this.mRival = userInfo;
        this.mRivalEncoded = userInfo.clone();
        this.mRivalSetTime = System.currentTimeMillis();
    }

    public final List<Problem> getProblems() {
        return this.mProblems;
    }

    public final void setProblems(List<Problem> list) {
        this.mProblems = list;
    }

    public final void resumeHeartBeat() {
        C0789L.log.debug("resumeHeartBeat");
        if (this.mHeartBeatRequest == null) {
            this.mHeartBeatRequest = new VSRequest<>(TAG, Constants.getHeartbeatUrl(this.mAvatar), new TypeToken<Response<Object>>() {
            }.getType(), (OnResponseListener<Object>) new OnResponseListener<Object>() {
                public boolean onResponse(ErrorInfo errorInfo, Object obj) {
                    return false;
                }
            }, (ErrorListener) new ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                }
            });
            this.mHeartBeatRequest.setPollingTimeout(0);
            this.mHeartBeatRequest.setPollingInterval(15000);
        }
        this.mHeartBeatRequest.start();
    }

    public final void pauseHeartBeat() {
        C0789L.log.debug("pauseHeartBeat");
        if (this.mHeartBeatRequest != null) {
            this.mHeartBeatRequest.cancel();
        }
    }

    public final void exit() {
        if (this.mAvatar != null) {
            GsonRequest gsonRequest = new GsonRequest(0, Constants.getExitUrl(this.mAvatar), new TypeToken<Response<Object>>() {
            }.getType(), null, new Listener<Response<Object>>() {
                public void onResponse(Response<Object> response) {
                    C0789L.log.debug("notify server exit success");
                }
            }, null);
            gsonRequest.setTag("Exit");
            VolleyUtils.send(gsonRequest);
        }
    }

    public final void clearRival() {
        this.mRival = null;
        this.mRivalEncoded = null;
        this.mRivalSetTime = 0;
    }

    public final void reset() {
        C0789L.log.debug("VSManager reset");
        clearRival();
        setState(VSState.IDLE);
        setResult(null);
        setProblems(null);
    }

    public final void reportVolleyError(Context context, VolleyError volleyError) {
        C0789L.log.error("onVolleyError:" + volleyError.getMessage() + ", code=" + VolleyUtils.statusCodeFromVolleyError(volleyError));
        Toast.makeText(context, VSUtils.volleyErrorToTip(context, volleyError), 0).show();
    }

    public final void reportServerError(Context context, ErrorInfo errorInfo) {
        String str;
        C0789L.log.error("onServerError:" + errorInfo);
        Resources resources = context.getResources();
//        if (errorInfo.equals(ErrorInfo.COMPETITOR_EXIT)) {
//            str = resources.getString(C0691R.string.fight_tip_on_err_server_part_exit);
//        } else if (getConfig().hideServerError) {
//            str = resources.getString(C0691R.string.fight_tip_err_net_unspec);
//        } else {
//            str = "Error: " + errorInfo.getCode();
//        }
//        Toast.makeText(context, str, 0).show();
    }
}
