package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import p012ch.qos.logback.core.joran.action.Action;

/* renamed from: com.f.a.c */
final class AssetRequestHandler extends RequestHandler {

    /* renamed from: a */
    private static final int f3758a = 22;

    /* renamed from: b */
    private final AssetManager f3759b;

    public AssetRequestHandler(Context context) {
        this.f3759b = context.getAssets();
    }

    public final boolean canHandleRequest(Request auVar) {
        Uri uri = auVar.f3676d;
        if (!Action.FILE_ATTRIBUTE.equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public final C1580az load(Request auVar) {
        return new C1580az(m3568a(auVar, auVar.f3676d.toString().substring(f3758a)), C1573an.DISK);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private Bitmap m3568a(Request auVar, String str) {
        InputStream inputStream = null;
        Options createBitmapOptions = createBitmapOptions(auVar);
        if (requiresInSampleSize(createBitmapOptions)) {
            try {
                inputStream = this.f3759b.open(str);
                BitmapFactory.decodeStream(inputStream, null, createBitmapOptions);
                C1584bj.m3556a(inputStream);
                calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
            } catch (Throwable th) {
                C1584bj.m3556a(inputStream);
                try {
                    throw th;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        InputStream open = null;
        try {
            open = this.f3759b.open(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return BitmapFactory.decodeStream(open, null, createBitmapOptions);
        } finally {
            C1584bj.m3556a(open);
        }
    }
}
