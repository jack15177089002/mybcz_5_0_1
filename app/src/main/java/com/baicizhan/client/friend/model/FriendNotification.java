package com.baicizhan.client.friend.model;

import com.google.gson.JsonObject;//import com.p020b.p021a.JsonObject;

public class FriendNotification {
    public static int ACCEPT = 102;
    public static int APPLY = 100;
    public static int IGNORE = 103;
    private JsonObject content;

    /* renamed from: id */
    private long f2326id;
    private int msgType;
    private FriendRecord source;

    public long getId() {
        return this.f2326id;
    }

    public void setId(long j) {
        this.f2326id = j;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public FriendRecord getSource() {
        return this.source;
    }

    public void setSource(FriendRecord friendRecord) {
        this.source = friendRecord;
    }

    public JsonObject getContent() {
        return this.content;
    }

    public void setContent(JsonObject zVar) {
        this.content = zVar;
    }

    public String toString() {
        return "FriendNotification [id=" + this.f2326id + ", msgType=" + this.msgType + ", source=" + this.source + ", content=" + this.content + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FriendNotification)) {
            return false;
        }
        if (this.source.getPublicKey() != ((FriendNotification) obj).source.getPublicKey()) {
            return false;
        }
        return true;
    }
}
