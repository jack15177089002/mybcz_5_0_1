package com.baicizhan.client.fight.jsonbean;

import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import java.io.Serializable;

public class Result implements Serializable {
    public static final int DRAW = 0;
    public static final int INVALID_RESULT = -100;
    public static final int LOSE = -1;
    public static final int WIN = 1;
    private static final long serialVersionUID = 2888537222516137010L;

    /* renamed from: a */
    private Score f2270a;

    /* renamed from: b */
    private Score f2271b;
    private transient String fightId;
    private Prize prize;
    private int res;
    private String share_detail_url_weibo;
    private String share_detail_url_weixin;

    public String getShareDetailURLWeixin() {
        return this.share_detail_url_weixin;
    }

    public void setShareDetailURLWeixin(String str) {
        this.share_detail_url_weixin = str;
    }

    public String getShareDetailURLWeibo() {
        return this.share_detail_url_weibo;
    }

    public void setShareDetailURLWeibo(String str) {
        this.share_detail_url_weibo = str;
    }

    public Score getA() {
        return this.f2270a;
    }

    public void setA(Score score) {
        this.f2270a = score;
    }

    public Score getB() {
        return this.f2271b;
    }

    public void setB(Score score) {
        this.f2271b = score;
    }

    public int getRes() {
        return this.res;
    }

    public void setRes(int i) {
        this.res = i;
    }

    public Prize getPrize() {
        return this.prize;
    }

    public void setPrize(Prize prize2) {
        this.prize = prize2;
    }

    public String getFightId() {
        return this.fightId;
    }

    public void setFightId(String str) {
        this.fightId = str;
    }

    public void judge() {
        if (this.f2270a != null && this.f2271b != null) {
            if (this.f2270a.getCorrectCount() < this.f2271b.getCorrectCount()) {
                this.res = -1;
            } else if (this.f2270a.getCorrectCount() > this.f2271b.getCorrectCount()) {
                this.res = 1;
            } else if (this.f2270a.getUseTimeSecond() > this.f2271b.getUseTimeSecond()) {
                this.res = -1;
            } else if (this.f2270a.getUseTimeSecond() < this.f2271b.getUseTimeSecond()) {
                this.res = 1;
            } else {
                this.res = 0;
            }
        }
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
