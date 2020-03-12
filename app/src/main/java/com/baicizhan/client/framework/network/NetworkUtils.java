package com.baicizhan.client.framework.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.conn.util.InetAddressUtils;

public class NetworkUtils {
    public static final int TYPE_2G = 3;
    public static final int TYPE_3G = 2;
    public static final int TYPE_4G = 1;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_WIFI = 0;

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static int getActiveNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        int subtype = activeNetworkInfo.getSubtype();
        if (1 == type) {
            return 0;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 11:
                return 3;
            case 8:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
                return 1;
            default:
                return 2;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWiFiConnected(Context context) {
        return getActiveNetworkType(context) == 0;
    }

    public static boolean isSmoothNetwork(Context context) {
        int activeNetworkType = getActiveNetworkType(context);
        if (activeNetworkType == 0 || 1 == activeNetworkType || 2 == activeNetworkType) {
            return true;
        }
        return false;
    }

    public static String getIPAddress(boolean z) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String upperCase = inetAddress.getHostAddress().toUpperCase(Locale.US);
                            boolean isIPv4Address = InetAddressUtils.isIPv4Address(upperCase);
                            if (z) {
                                if (isIPv4Address) {
                                    return upperCase;
                                }
                            } else if (!isIPv4Address) {
                                int indexOf = upperCase.indexOf(37);
                                if (indexOf >= 0) {
                                    return upperCase.substring(0, indexOf);
                                }
                                return upperCase;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }
}
