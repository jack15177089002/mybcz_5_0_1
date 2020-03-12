package com.baicizhan.client.fight.jsonbean;

import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;

public class Request {
    @Expose
    private String action;
    @Expose
    private Member member;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member2) {
        this.member = member2;
    }
}
