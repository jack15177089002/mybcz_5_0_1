package com.baicizhan.client.friend.model;

import java.io.Serializable;

public class FriendRecord implements Serializable, Cloneable {
    public static final String ACCOUNT_360 = "360";
    public static final String ACCOUNT_QQ = "qq";
    public static final String ACCOUNT_RENREN = "renren";
    public static final String ACCOUNT_UNKNOWN = "unknown";
    public static final String ACCOUNT_WEIBO = "weibo";
    public static final String ACCOUNT_WEIXIN = "weixin";
    private static final long serialVersionUID = 7723232378921643076L;
    private String accountType;
    private String book;
    private String image;
    private int learned;
    private int learnedLastWeek;
    private String localName;
    private int loseCount;
    private String publicKey;
    private String reason;
    private int vocabulary;
    private int winCount;

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
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

    public String getLocalName() {
        return this.localName;
    }

    public void setLocalName(String str) {
        this.localName = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
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

    public int getLearned() {
        return this.learned;
    }

    public void setLearned(int i) {
        this.learned = i;
    }

    public int getLearnedLastWeek() {
        return this.learnedLastWeek;
    }

    public void setLearnedLastWeek(int i) {
        this.learnedLastWeek = i;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String toString() {
        return "FriendRecord [publicKey=" + this.publicKey + ", accountType=" + this.accountType + ", localName=" + this.localName + ", image=" + this.image + ", book=" + this.book + ", vocabulary=" + this.vocabulary + ", learned=" + this.learned + ", learnedLastWeek=" + this.learnedLastWeek + ", winCount=" + this.winCount + ", loseCount=" + this.loseCount + ", reason=" + this.reason + "]";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FriendRecord)) {
            return false;
        }
        FriendRecord friendRecord = (FriendRecord) obj;
        if (this.publicKey == null || friendRecord.getPublicKey() == null) {
            return false;
        }
        return this.publicKey.equals(friendRecord.getPublicKey());
    }
}
