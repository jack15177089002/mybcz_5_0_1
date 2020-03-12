package com.baicizhan.client.fight.jsonbean;

import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;
import java.util.List;

public class Fight implements Serializable {
    private static final long serialVersionUID = 3522088620952552966L;
    @Expose

    /* renamed from: a */
    private Member f2266a;
    @Expose

    /* renamed from: b */
    private Member f2267b;
    @Expose
    private List<Problem> problems;

    public Fight(Member member, Member member2) {
        this.f2266a = member;
        this.f2267b = member2;
    }

    public void setProblems(List<Problem> list) {
        this.problems = list;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public Member getCompetitor(Member member) {
        if (member == null || (!member.equals(this.f2266a) && !member.equals(this.f2267b))) {
            return null;
        }
        return member.equals(this.f2266a) ? this.f2267b : this.f2266a;
    }

    public Member getMe(Member member) {
        if (member == null || (!member.equals(this.f2266a) && !member.equals(this.f2267b))) {
            return null;
        }
        return member.equals(this.f2266a) ? this.f2266a : this.f2267b;
    }
}
