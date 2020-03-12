package com.baicizhan.client.framework.network.http;

public class HttpStat {
    public long allCostTime = -1;
    public long connectTime = -1;
    public long dnsTime = -1;
    public int downloadSize = -1;
    public String exception = "";
    public int executeStatus = 0;
    public int responsedCode = -1;
    public int retry = 0;
    public long rspTime = -1;
    public int upDataSize = -1;

    public class ExecuteStatus {
        public static final int BEGIN = -1;
        public static final int CONN_BEFORE = -4;
        public static final int CONN_SUCC = -5;
        public static final int CREATE_CONN_BEFORE = -2;
        public static final int CREATE_CONN_SUCC = -3;
        public static final int GETDATA_BEFORE = -8;
        public static final int GETDATA_SUCC = -9;
        public static final int POST_BEFORE = -6;
        public static final int POST_SUCC = -7;

        public ExecuteStatus() {
        }
    }
}
