package com.baicizhan.client.business.thrift;

import android.content.Context;
import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import com.baicizhan.client.framework.device.DeviceInfo;
import com.baicizhan.client.framework.util.PackageUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class BaicizhanCookieInflator implements CookieInflator {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String APP_NAME = "app_name";
    public static final String CHANNEL = "channel";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_NAME = "device_name";
    public static final String SERIAL = "serial";
    public static final String VERSION = "version";
    private final DateFormat SERIAL_TIMESTAMP_FORMAT = new SimpleDateFormat("ddHHmmss", Locale.US);
    private String deviceId;
    private Map<String, String> mValues = new ArrayMap();

    public BaicizhanCookieInflator(Context context) {
        this.deviceId = PackageUtils.getAndroidId(context);
        put(DEVICE_NAME, "android/" + DeviceInfo.PHONE_MODEL);
        put(VERSION, DeviceInfo.ANDROID_VERSION);
        put(DEVICE_ID, this.deviceId);
        put(APP_NAME, Integer.toString(PackageUtils.getPackageVersionCode(context)));
        put(CHANNEL, PackageUtils.getChannel(context));
    }

    public String getCookie() {
        put(SERIAL, getSerial());
        StringBuilder sb = new StringBuilder();
        Iterator it = this.mValues.entrySet().iterator();
        Entry entry = (Entry) it.next();
        sb.append((String) entry.getKey()).append("=").append((String) entry.getValue());
        while (it.hasNext()) {
            Entry entry2 = (Entry) it.next();
            sb.append("; ");
            sb.append((String) entry2.getKey()).append("=").append((String) entry2.getValue());
        }
        return sb.toString();
    }

    public boolean hasKey(String str) {
        return this.mValues.containsKey(str);
    }

    public void remove(String str) {
        this.mValues.remove(str);
    }

    public void put(String str, String str2) {
        this.mValues.put(str, str2);
    }

    private String getSerial() {
        return this.deviceId.substring(0, 5) + this.deviceId.substring(this.deviceId.length() - 5, this.deviceId.length()) + this.SERIAL_TIMESTAMP_FORMAT.format(Long.valueOf(System.currentTimeMillis()));
    }
}
