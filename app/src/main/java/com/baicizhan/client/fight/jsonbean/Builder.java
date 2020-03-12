package com.baicizhan.client.fight.jsonbean;

//import com.baicizhan.client.business.util.LocationUtils.LocationInfo;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.google.gson.GsonBuilder;//import com.p020b.p021a.GsonBuilder;
import com.google.gson.internal.Excluder;
//import com.p020b.p021a.p023b.Excluder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Builder {
    private static Gson sGson;

    static {
        GsonBuilder rVar = new GsonBuilder();
//        Excluder a = rVar.f2186a.clone();
//        a.f2105e = true;
//        rVar.f2186a = a;
//        sGson = rVar.mo3215a();
    }

    private static String urlEscape(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

//    public static String getJoinString(UserInfo userInfo, LocationInfo locationInfo) {
//        Request request = new Request();
//        Member member = new Member();
//        member.setUserInfo(userInfo);
//        member.setPosition(locationInfo);
//        member.setTimeoutAutoMatch(0);
//        request.setAction("join");
//        request.setMember(member);
////        return urlEscape(sGson.toJson((Object) request));
//
//        return null;
//    }

    public static String getMatchString(UserInfo userInfo, UserInfo userInfo2) {
        Request request = new Request();
        String str = "match";
        MatchInfo matchInfo = null;
        if (userInfo2 != null) {
            matchInfo = new MatchInfo();
            matchInfo.setSelected(getBriefUserInfo(userInfo2));
        }
        Member member = new Member();
        member.setUserInfo(getBriefUserInfo(userInfo));
        member.setMatchInfo(matchInfo);
        member.setTimeoutAutoMatch(0);
        request.setAction(str);
        request.setMember(member);
//        return urlEscape(sGson.toJson((Object) request));
        return null;
    }

    public static String getFightCommonString(String str, UserInfo userInfo) {
        Request request = new Request();
        Member member = new Member();
        member.setUserInfo(getBriefUserInfo(userInfo));
        request.setAction(str);
        request.setMember(member);
//        return urlEscape(sGson.toJson((Object) request));
        return null;
    }

    public static String getSubmitString(UserInfo userInfo, Score score, String str) {
        Request request = new Request();
        Member member = new Member();
        member.setUserInfo(getBriefUserInfo(userInfo));
        member.setScore(score);
        if (str != null) {
            member.setFightId(str);
        }
        request.setAction("submit");
        request.setMember(member);
//        return urlEscape(sGson.toJson((Object) request));

        return null;
    }

    public static String getFriendCommonString(String str, UserInfo userInfo, FriendInfo friendInfo) {
        Request request = new Request();
        request.setAction(str);
        Member member = new Member();
        member.setUserInfo(getBriefUserInfo(userInfo));
        member.setFriendInfo(friendInfo);
        request.setMember(member);
//        return urlEscape(sGson.toJson((Object) request));

        return null;
    }

    private static UserInfo getBriefUserInfo(UserInfo userInfo) {
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setToken(userInfo.getToken());
        userInfo2.setNetwork(userInfo.getNetwork());
        userInfo2.setAppVersion(userInfo.getAppVersion());
        userInfo2.setOs(userInfo.getOs());
        return userInfo2;
    }
}
