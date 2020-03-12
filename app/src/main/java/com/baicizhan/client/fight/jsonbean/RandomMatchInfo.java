package com.baicizhan.client.fight.jsonbean;

import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import java.io.Serializable;
import java.util.List;

public class RandomMatchInfo implements Serializable {
    private static final long serialVersionUID = 8968395003144969294L;
    private int correct_count;
    private int[] details;
    private String fightId;
    private UserInfo matched;
    private int online;
    private List<Problem> problems;
    private int use_time;

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public int getOnline() {
        return this.online;
    }

    public void setOnline(int i) {
        this.online = i;
    }

    public UserInfo getMatched() {
        return this.matched;
    }

    public void setMatched(UserInfo userInfo) {
        this.matched = userInfo;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public void setProblems(List<Problem> list) {
        this.problems = list;
    }

    public int getUseTime() {
        return this.use_time;
    }

    public void setUseTime(int i) {
        this.use_time = i;
    }

    public int getCorrectCount() {
        return this.correct_count;
    }

    public void setCorrectCount(int i) {
        this.correct_count = i;
    }

    public int[] getDetails() {
        return this.details;
    }

    public void setDetails(int[] iArr) {
        this.details = iArr;
    }

    public String getFightId() {
        return this.fightId;
    }

    public void setFightId(String str) {
        this.fightId = str;
    }
}
