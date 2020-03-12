package com.baicizhan.client.fight.jsonbean;

import android.text.TextUtils;
import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;

public class UserInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = -8836335784805678926L;
    @Expose
    private Float appVersion;
    @Expose
    private String book;
    private double distance;
    @Expose
    private String image;
    private String localImagePath;
    @Expose
    private String localName;
    @Expose
    private int network;
    private String nickName;
    @Expose

    /* renamed from: os */
    private String f2274os;
    @Expose
    private String token;
    @Expose
    private Integer vocabulary;

    public Float getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(Float f) {
        this.appVersion = f;
    }

    public String getOs() {
        return this.f2274os;
    }

    public void setOs(String str) {
        this.f2274os = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getLocalName() {
        return this.localName;
    }

    public void setLocalName(String str) {
        this.localName = str;
    }

    public String getDisplayName() {
        return TextUtils.isEmpty(this.localName) ? this.nickName : this.localName;
    }

    public void setNetwork(int i) {
        this.network = i;
    }

    public int getNetwork() {
        return this.network;
    }

    public UserInfo clone() {
        try {
            return (UserInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }

    public String toString() {
        return "UserInfo [token=" + this.token + ", network=" + this.network + ", nickName=" + this.nickName + ", localName=" + this.localName + ", image=" + this.image + ", distance=" + this.distance + ", book=" + this.book + ", vocabulary=" + this.vocabulary + "]";
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public String getBook() {
        return this.book;
    }

    public void setBook(String str) {
        this.book = str;
    }

    public int getVocabulary() {
        return this.vocabulary.intValue();
    }

    public void setVocabulary(int i) {
        this.vocabulary = Integer.valueOf(i);
    }

    public String getLocalImagePath() {
        return this.localImagePath;
    }

    public void setLocalImagePath(String str) {
        this.localImagePath = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UserInfo) || obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (this.token == null || userInfo.getToken() == null) {
            return false;
        }
        return this.token.equals(userInfo.getToken());
    }
}
