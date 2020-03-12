package com.baicizhan.client.fight.jsonbean;

//import com.baicizhan.client.business.util.LocationUtils.LocationInfo;
import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = -5156676093689156922L;
    @Expose
    private Member competitor;
    private transient Fight fight;
    @Expose
    String fightId;
    @Expose
    FriendInfo friendInfo;
    @Expose
    private MatchInfo matchInfo;
    private long operationTime = 0;
//    @Expose
//    private LocationInfo position;
    @Expose
    private Score score;
    @Expose
    private Integer timeoutAutoMatch;
    @Expose
    private UserInfo userInfo;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Member)) {
            return false;
        }
        Member member = (Member) obj;
        if (this == member) {
            return true;
        }
        if (this.userInfo == null || member.userInfo == null) {
            return false;
        }
        UserInfo userInfo2 = this.userInfo;
        UserInfo userInfo3 = member.userInfo;
        if (userInfo2.getToken() != null && userInfo3.getToken() != null) {
            return userInfo2.getToken().equals(userInfo3.getToken());
        }
        if (userInfo2.getNickName() == null || userInfo3.getNickName() == null) {
            return false;
        }
        return userInfo2.getNickName().equals(userInfo3.getNickName());
    }

    public void updateOperationTime() {
        this.operationTime = System.currentTimeMillis();
    }

//    public LocationInfo getPosition() {
//        return this.position;
//    }
//
//    public void setPosition(LocationInfo locationInfo) {
//        this.position = locationInfo;
//    }

    public MatchInfo getMatchInfo() {
        return this.matchInfo;
    }

    public void setMatchInfo(MatchInfo matchInfo2) {
        this.matchInfo = matchInfo2;
    }

    public Member getCompetitor() {
        return this.competitor;
    }

    public void setCompetitor(Member member) {
        this.competitor = member;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }

    public Fight getFight() {
        return this.fight;
    }

    public void setFight(Fight fight2) {
        this.fight = fight2;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score2) {
        this.score = score2;
    }

    public long getOperationTime() {
        return this.operationTime;
    }

    public void setOperationTime(long j) {
        this.operationTime = j;
    }

    public int getTimeoutAutoMatch() {
        return this.timeoutAutoMatch.intValue();
    }

    public void setTimeoutAutoMatch(int i) {
        this.timeoutAutoMatch = Integer.valueOf(i);
    }

    public String getFightId() {
        return this.fightId;
    }

    public void setFightId(String str) {
        this.fightId = str;
    }

    public FriendInfo getFriend() {
        return this.friendInfo;
    }

    public void setFriendInfo(FriendInfo friendInfo2) {
        this.friendInfo = friendInfo2;
    }
}
