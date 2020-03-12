package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.f.a.ag */
public final class OkHttpDownloader implements Downloader {

    /* renamed from: a */
    private final OkUrlFactory f3623a;

    public OkHttpDownloader(Context context) {
        this(C1584bj.m3561b(context));
    }

    private OkHttpDownloader(File file) {
        this(file, C1584bj.m3547a(file));
    }

    private OkHttpDownloader(File file, long j) {
        this(new OkHttpClient());
        try {
            this.f3623a.client().setCache(new Cache(file, j));
        } catch (Exception e) {
        }
    }

    private OkHttpDownloader(OkHttpClient okHttpClient) {
        this.f3623a = new OkUrlFactory(okHttpClient);
    }

    /* renamed from: a */
    public final C1598w mo16299a(Uri uri, boolean z) throws IOException {
        HttpURLConnection open = null;
        try {
            open = this.f3623a.open(new URL(uri.toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        open.setConnectTimeout(15000);
        open.setReadTimeout(20000);
        open.setUseCaches(true);
        if (z) {
            open.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = 0;
        try {
            responseCode = open.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (responseCode >= 300) {
            open.disconnect();
            throw new C1599x(responseCode + " " + open.getResponseMessage());
        }
        String headerField = open.getHeaderField("OkHttp-Response-Source");
        if (headerField == null) {
            headerField = open.getHeaderField("X-Android-Response-Source");
        }
        long headerFieldInt = (long) open.getHeaderFieldInt("Content-Length", -1);
        return new C1598w(open.getInputStream(), C1584bj.m3560a(headerField), headerFieldInt);
    }
}
