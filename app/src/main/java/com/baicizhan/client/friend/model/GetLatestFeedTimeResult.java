package com.baicizhan.client.friend.model;

public class GetLatestFeedTimeResult {
    private boolean hasNewFeeds;
    private long updateTime;

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public boolean hasNewFeeds() {
        return this.hasNewFeeds;
    }

    public void setHasNewFeeds(boolean z) {
        this.hasNewFeeds = z;
    }

    public String toString() {
        return "GetLatestFeedTimeResult [updateTime=" + this.updateTime + ", hasNewFeeds=" + this.hasNewFeeds + "]";
    }
}
