package com.baicizhan.client.fight.util;

import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LocationUtils.LocationInfo;
import com.baicizhan.client.fight.jsonbean.Builder;
import com.baicizhan.client.fight.jsonbean.FriendInfo;
import com.baicizhan.client.fight.jsonbean.Score;
import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.tencent.android.tpush.common.MessageKey;
import java.util.Locale;

public class Constants {
    public static final String ASSETS_AUDIO_VS_BG = "audio/vs_bg.ogg";
    public static final String ASSETS_AUDIO_VS_RESULT = "audio/result.ogg";
    private static final String sUrlPre = "http://www.baicizhan.com/api/%d/fight_info.gz?json=%s";

    private static String buildRequestUrl(String str) {
        return String.format(Locale.US, sUrlPre, new Object[]{Long.valueOf(System.currentTimeMillis()), str});
    }

//    public static String getJoinUrl(UserInfo userInfo, LocationInfo locationInfo) {
//        if (userInfo == null) {
//            return null;
//        }
//        return buildRequestUrl(Builder.getJoinString(userInfo, locationInfo));
//    }

    public static String getMatchUrl(UserInfo userInfo, UserInfo userInfo2) {
        return buildRequestUrl(Builder.getMatchString(userInfo, userInfo2));
    }

    public static String getProblemUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("problem", userInfo));
    }

    public static String getReadyUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("ready", userInfo));
    }

//    public static String getStartUrl(UserInfo userInfo) {
//        return buildRequestUrl(Builder.getFightCommonString(MessageKey.MSG_ACCEPT_TIME_START, userInfo));
//    }

    public static String getSubmitUrl(UserInfo userInfo, Score score, String str) {
        return buildRequestUrl(Builder.getSubmitString(userInfo, score, str));
    }

    public static String getResultUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("result", userInfo));
    }

    public static String getExitUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString(ConstantsUtil.STATE_EXIT_FOR_RECREATE, userInfo));
    }

    public static String getHeartbeatUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("heartbeat", userInfo));
    }

    public static String getQueryTotalScoreUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("userscore", userInfo));
    }

    public static String getFriendRankUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("rank", userInfo));
    }

    public static String getRandomMatchUrl(UserInfo userInfo) {
        return buildRequestUrl(Builder.getFightCommonString("randommatch", userInfo));
    }

    public static String getRemoveFriendUrl(UserInfo userInfo, FriendInfo friendInfo) {
        return buildRequestUrl(Builder.getFriendCommonString("removefriend", userInfo, friendInfo));
    }
}
