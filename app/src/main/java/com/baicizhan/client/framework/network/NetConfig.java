package com.baicizhan.client.framework.network;

public interface NetConfig {
    public static final int HTTP_CONNECT_TIME_OUT_MS_2G = 20000;
    public static final int HTTP_CONNECT_TIME_OUT_MS_3G = 10000;
    public static final int HTTP_CONNECT_TIME_OUT_MS_WIFI = 5000;
    public static final int HTTP_RETRY_COUNT = 5;
    public static final int HTTP_TIME_OUT_MS_2G = 30000;
    public static final int HTTP_TIME_OUT_MS_3G = 20000;
    public static final int HTTP_TIME_OUT_MS_WIFI = 10000;
    public static final int PRIORITY_HIGH = -1;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_SUPER_HIGH = -3;
    public static final int PRIORITY_VERY_HIGH = -2;
    public static final int SOCKET_MAX_RETYR_CONNECT = 3;
    public static final int SOCKET_MIN_TIME_OUT = 5000;
    public static final int SOCKET_RETRY_COUNT = 3;
    public static final int SOCKET_TIME_OUT_MS_2G = 20000;
    public static final int SOCKET_TIME_OUT_MS_3G = 10000;
    public static final int SOCKET_TIME_OUT_MS_WIFI = 5000;
    public static final int[] reconStrategy = {30, 60, 300, 600, 1800, 3600, 7200, 14400};
}
