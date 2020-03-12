package com.baicizhan.client.fight.jsonbean;

import java.io.Serializable;
import p012ch.qos.logback.core.CoreConstants;

public class UserScore implements Serializable {
    private static final long serialVersionUID = -7549071252056133020L;
    private String book;
    private int loseCount;
    private Prize prize;
    private int rank;
    private String share_url_weixin;
    private int vocabulary;
    private int winCount;

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

    public String toString() {
        return "UserScore{book='" + this.book + CoreConstants.SINGLE_QUOTE_CHAR + ", winCount=" + this.winCount + ", loseCount=" + this.loseCount + ", vocabulary=" + this.vocabulary + ", rank=" + this.rank + ", prize=" + this.prize + ", share_url_weixin='" + this.share_url_weixin + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }

    public String getBook() {
        return this.book;
    }

    public void setBook(String str) {
        this.book = str;
    }

    public int getVocabulary() {
        return this.vocabulary;
    }

    public void setVocabulary(int i) {
        this.vocabulary = i;
    }

    public Prize getPrize() {
        return this.prize;
    }

    public void setPrize(Prize prize2) {
        this.prize = prize2;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public String getShareURLWeixin() {
        return this.share_url_weixin;
    }

    public void setShareURLWeixin(String str) {
        this.share_url_weixin = str;
    }
}
