package com.baicizhan.client.fight.jsonbean;

import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;
import java.util.List;

public class MatchInfo implements Serializable {
    private static final long serialVersionUID = 3428525186545978433L;
    private List<UserInfo> candidates;
    @Expose
    private UserInfo matched;
    @Expose
    private UserInfo selected;
    private List<String> selectedMe;

    public UserInfo getSelected() {
        return this.selected;
    }

    public void setSelected(UserInfo userInfo) {
        this.selected = userInfo;
    }

    public UserInfo getMatched() {
        return this.matched;
    }

    public void setMatched(UserInfo userInfo) {
        this.matched = userInfo;
    }

    public List<UserInfo> getCandidates() {
        return this.candidates;
    }

    public void setCandidates(List<UserInfo> list) {
        this.candidates = list;
    }

    public List<String> getSelectedMe() {
        return this.selectedMe;
    }

    public void setSelectedMe(List<String> list) {
        this.selectedMe = list;
    }
}
