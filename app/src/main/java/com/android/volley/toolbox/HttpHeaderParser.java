package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser {
    public static Entry parseCacheHeaders(NetworkResponse networkResponse) {
        long j;
        long j2;
        long j3;
        boolean z = false;
        long j4 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = (String) map.get("Date");
        if (str != null) {
            j = parseDateAsEpoch(str);
        } else {
            j = 0;
        }
        String str2 = (String) map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            long j5 = 0;
            for (String trim : split) {
                String trim2 = trim.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j5 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j5 = 0;
                }
            }
            j2 = j5;
            z = true;
        } else {
            j2 = 0;
        }
        String str3 = (String) map.get("Expires");
        if (str3 != null) {
            j3 = parseDateAsEpoch(str3);
        } else {
            j3 = 0;
        }
        String str4 = (String) map.get("ETag");
        if (z) {
            j4 = (1000 * j2) + currentTimeMillis;
        } else if (j > 0 && j3 >= j) {
            j4 = (j3 - j) + currentTimeMillis;
        }
        Entry entry = new Entry();
        entry.data = networkResponse.data;
        entry.etag = str4;
        entry.softTtl = j4;
        entry.ttl = entry.softTtl;
        entry.serverDate = j;
        entry.responseHeaders = map;
        return entry;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static String parseCharset(Map<String, String> map) {
        String str = (String) map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }
}
