package com.baicizhan.client.friend.model;

public class FriendWeekLearnedInfo {
    private int learned;
    private int learnedLastWeek;
    private String publicKey;

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
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

    public String toString() {
        return "FriendLearnedInfo [publicKey=" + this.publicKey + ", learned=" + this.learned + ", learnedLastWeek=" + this.learnedLastWeek + "]";
    }
}
