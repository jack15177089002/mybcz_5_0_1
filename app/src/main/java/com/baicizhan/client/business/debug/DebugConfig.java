package com.baicizhan.client.business.debug;

//import p012ch.qos.logback.core.CoreConstants;
public class DebugConfig {
    public static DebugConfig sInstance = new DebugConfig();
    public boolean enable = false;
    public boolean fixOptionPosition = false;

    public static void setInstance(DebugConfig debugConfig) {
        sInstance = debugConfig;
    }

    public static DebugConfig getsIntance() {
        return sInstance;
    }

    public String toString() {
//        return "DebugConfig{enable=" + this.enable + ", fixOptionPosition=" + this.fixOptionPosition + CoreConstants.CURLY_RIGHT;
        return null;
    }
}
