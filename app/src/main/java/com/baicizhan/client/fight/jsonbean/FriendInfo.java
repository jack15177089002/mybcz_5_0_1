package com.baicizhan.client.fight.jsonbean;

import android.text.TextUtils;
import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;

public class FriendInfo implements Serializable {
    private static final long serialVersionUID = -4855298968662645169L;
    private int drawCount;
    private String image;
    private boolean isSelf;
    private String localName;
    private int loseCount;
    @Expose
    private String nickName;
    private int rank;

    /* renamed from: ut */
    private String f2268ut;
    private int winCount;

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public void setWinCount(int i) {
        this.winCount = i;
    }

    public int getLoseCount() {
        return this.loseCount;
    }

    public void setLoseCount(int i) {
        this.loseCount = i;
    }

    public int getDrawCount() {
        return this.drawCount;
    }

    public void setDrawCount(int i) {
        this.drawCount = i;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getNickname() {
        return this.nickName;
    }

    public void SetNickName(String str) {
        this.nickName = str;
    }

    public String getLocalName() {
        return this.localName;
    }

    public void SetLocalName(String str) {
        this.localName = str;
    }

    public String getDisplayName() {
        return TextUtils.isEmpty(this.localName) ? this.nickName : this.localName;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public String toString() {
        return "FriendInfo [nickName=" + this.nickName + ", localName=" + this.localName + ", image=" + this.image + ", ut=" + this.f2268ut + ", isSelf=" + this.isSelf + ", winCount=" + this.winCount + ", loseCount=" + this.loseCount + ", drawCount=" + this.drawCount + ", rank=" + this.rank + "]";
    }

    public String getUt() {
        return this.f2268ut;
    }

    public void setUt(String str) {
        this.f2268ut = str;
    }
}
