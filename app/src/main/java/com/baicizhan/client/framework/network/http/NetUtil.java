package com.baicizhan.client.framework.network.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baicizhan.client.framework.BaseAppHandler;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;

public class NetUtil {

    public enum NetTpyeEnmu {
        UNAVAIL,
        WIFI,
        NET,
        WAP
    }

    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG
    }

    public static NetworkStateInfo getStatusInfo() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseAppHandler.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                return NetworkStateInfo.UNAVAIL;
            }
            if (activeNetworkInfo.getType() == 1) {
                return NetworkStateInfo.WIFI;
            }
            switch (((TelephonyManager) BaseAppHandler.getApp().getSystemService("phone")).getNetworkType()) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NetworkStateInfo.TwoG;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                    return NetworkStateInfo.ThreeG;
                default:
                    return NetworkStateInfo.TwoG;
            }
        } catch (Exception e) {
            return NetworkStateInfo.UNAVAIL;
        }
    }

    public static NetTpyeEnmu getNetType() {
        NetTpyeEnmu netTpyeEnmu = NetTpyeEnmu.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseAppHandler.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && activeNetworkInfo.isAvailable())) {
                return NetTpyeEnmu.UNAVAIL;
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return NetTpyeEnmu.WIFI;
            }
            String defaultHost = getDefaultHost();
            if (defaultHost == null || defaultHost.length() <= 0) {
                return NetTpyeEnmu.NET;
            }
            return NetTpyeEnmu.WAP;
        } catch (Exception e) {
            e.printStackTrace();
            if (LSwitcher.isOpened()) {
                C0789L.log.error("get net type error.", (Throwable) e);
            }
            return netTpyeEnmu;
        }
    }

    public static final String getDefaultHost() {
        String property = System.getProperty("http.proxyHost");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property;
    }

    public static final int getDefaultPort() {
        int i = -1;
        if (getDefaultHost() == null) {
            return i;
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
