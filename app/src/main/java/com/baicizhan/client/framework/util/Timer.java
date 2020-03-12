package com.baicizhan.client.framework.util;

public class Timer {
    private long end;
    private long start;

    public void start() {
        this.start = System.currentTimeMillis();
        this.end = this.start;
    }

    public long stop() {
        this.end = System.currentTimeMillis();
        return this.end - this.start;
    }

    public long time() {
        return this.end - this.start;
    }
}
