package com.baicizhan.client.friend.model;

//import com.p020b.p021a.JsonObject;

import com.google.gson.JsonObject;

public class FriendFeed implements Comparable<FriendFeed> {
    private JsonObject content;
    private int msgType;
    private long updateTime;

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public JsonObject getContent() {
        return this.content;
    }

    public void setContent(JsonObject zVar) {
        this.content = zVar;
    }

    public String toString() {
        return "FriendFeed [updateTime=" + this.updateTime + ", msgType=" + this.msgType + ", content=" + this.content + "]";
    }

    public int compareTo(FriendFeed friendFeed) {
        long updateTime2 = getUpdateTime() - friendFeed.getUpdateTime();
        if (updateTime2 == 0) {
            return 0;
        }
        if (updateTime2 < 0) {
            return 1;
        }
        return -1;
    }
}
