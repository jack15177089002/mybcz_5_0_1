package com.baicizhan.client.business.util;

import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import java.util.Locale;
import java.util.Map;

public class Profiler {
    Map<String, Long> mStartTimeMap = new ArrayMap();

    public void openFunc(String str, String str2) {
        LogWrapper.m2796v(str, String.format(Locale.US, "[[[%s]]] - start", new Object[]{str2}));
        this.mStartTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
    }

    public long closeFunc(String str) {
        Long l = (Long) this.mStartTimeMap.get(str);
        if (l == null) {
            return -1;
        }
        return System.currentTimeMillis() - l.longValue();
    }

    public void closeAndPrintFunc(String str, String str2) {
        LogWrapper.m2796v(str, String.format(Locale.US, "[[[%s]]]] - end, elapsed %d", new Object[]{str2, Long.valueOf(closeFunc(str2))}));
    }
}
