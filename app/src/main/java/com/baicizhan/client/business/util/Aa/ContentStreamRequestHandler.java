package com.baicizhan.client.business.util.Aa;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
//import com.tencent.android.tpush.common.MessageKey;

import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.f.a.o */
class ContentStreamRequestHandler extends RequestHandler {

    /* renamed from: a */
    final Context f3790a;

    ContentStreamRequestHandler(Context context) {
        this.f3790a = context;
    }

    public boolean canHandleRequest(Request auVar) {
//        return MessageKey.MSG_CONTENT.equals(auVar.f3676d.getScheme());
        return false;
    }

    public C1580az load(Request auVar) {
        return new C1580az(mo16353a(auVar), C1573an.DISK);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Bitmap mo16353a(Request auVar) {
        InputStream inputStream = null;
        ContentResolver contentResolver = this.f3790a.getContentResolver();
        Options createBitmapOptions = createBitmapOptions(auVar);
        if (requiresInSampleSize(createBitmapOptions)) {
            try {
                inputStream = contentResolver.openInputStream(auVar.f3676d);
                BitmapFactory.decodeStream(inputStream, null, createBitmapOptions);
                C1584bj.m3556a(inputStream);
                calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
            } catch (Throwable th) {
                C1584bj.m3556a(inputStream);
                try {
                    throw th;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        InputStream openInputStream = null;
        try {
            openInputStream = contentResolver.openInputStream(auVar.f3676d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return BitmapFactory.decodeStream(openInputStream, null, createBitmapOptions);
        } finally {
            C1584bj.m3556a(openInputStream);
        }
    }
}
