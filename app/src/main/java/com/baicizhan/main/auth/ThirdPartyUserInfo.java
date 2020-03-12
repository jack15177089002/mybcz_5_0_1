package com.baicizhan.main.auth;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import p012ch.qos.logback.core.CoreConstants;

public class ThirdPartyUserInfo implements Serializable {
    public static final String GENDER_FEMALE = "f";
    public static final String GENDER_MALE = "m";
    public static final String PROVIDER_RENREN = "renren";
    public static final String PROVIDER_WEIBO = "weibo";
    public static final String PROVIDER_WEIXIN = "weixin";
    private static final long serialVersionUID = 1;
    public String asecret;
    public String atoken;
    public String city;
    public String country;
    public long expireAt;
    public String gender;
    public String imageUrl;
    public int loginType;
    public String nickName;
    public String openid;
    public String provider;
    public String province;
    public String refreshToken;
    public String uid;
    public String unionid;

    public void setExpireIn(String str) {
        try {
            this.expireAt = TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) + Long.valueOf(str).longValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExpired() {
        return this.expireAt > 0 && TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) >= this.expireAt;
    }

    public String toString() {
        return "ThirdPartyUserInfo{asecret='" + this.asecret + CoreConstants.SINGLE_QUOTE_CHAR + ", loginType=" + this.loginType + ", provider='" + this.provider + CoreConstants.SINGLE_QUOTE_CHAR + ", uid='" + this.uid + CoreConstants.SINGLE_QUOTE_CHAR + ", openid='" + this.openid + CoreConstants.SINGLE_QUOTE_CHAR + ", unionid='" + this.unionid + CoreConstants.SINGLE_QUOTE_CHAR + ", atoken='" + this.atoken + CoreConstants.SINGLE_QUOTE_CHAR + ", refreshToken='" + this.refreshToken + CoreConstants.SINGLE_QUOTE_CHAR + ", expireAt=" + this.expireAt + ", nickName='" + this.nickName + CoreConstants.SINGLE_QUOTE_CHAR + ", imageUrl='" + this.imageUrl + CoreConstants.SINGLE_QUOTE_CHAR + ", gender='" + this.gender + CoreConstants.SINGLE_QUOTE_CHAR + ", country='" + this.country + CoreConstants.SINGLE_QUOTE_CHAR + ", province='" + this.province + CoreConstants.SINGLE_QUOTE_CHAR + ", city='" + this.city + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }
}
