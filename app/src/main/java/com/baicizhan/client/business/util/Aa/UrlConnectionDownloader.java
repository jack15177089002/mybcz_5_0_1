package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.f.a.bi */
public final class UrlConnectionDownloader implements Downloader {

    /* renamed from: a */
    static volatile Object f3754a;

    /* renamed from: b */
    private static final Object f3755b = new Object();

    /* renamed from: c */
    private final Context f3756c;

    public UrlConnectionDownloader(Context context) {
        this.f3756c = context.getApplicationContext();
    }

    /* renamed from: a */
    public final C1598w mo16299a(Uri uri, boolean z) {
        if (VERSION.SDK_INT >= 14) {
            Context context = this.f3756c;
            if (f3754a == null) {
                try {
                    synchronized (f3755b) {
                        if (f3754a == null) {
                            File b = C1584bj.m3561b(context);
                            HttpResponseCache installed = HttpResponseCache.getInstalled();
                            if (installed == null) {
                                installed = HttpResponseCache.install(b, C1584bj.m3547a(b));
                            }
                            f3754a = installed;
                        }
                    }
                } catch (IOException e) {
                }
            }
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setUseCaches(true);
        if (z) {
            httpURLConnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = 0;
        try {
            responseCode = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (responseCode >= 300) {
            httpURLConnection.disconnect();
//            throw new C1599x(responseCode + " " + httpURLConnection.getResponseMessage( ));
        }
        long headerFieldInt = (long) httpURLConnection.getHeaderFieldInt("Content-Length", -1);
        try {
            return new C1598w(httpURLConnection.getInputStream(), C1584bj.m3560a(httpURLConnection.getHeaderField("X-Android-Response-Source")), headerFieldInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
