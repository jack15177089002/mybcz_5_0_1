package com.baicizhan.client.business.util.Aa;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
//import com.tencent.android.tpush.common.MessageKey;
import java.io.InputStream;

/* renamed from: com.f.a.n */
final class ContactsPhotoRequestHandler extends RequestHandler {

    /* renamed from: b */
    private static final UriMatcher f3788b;

    /* renamed from: a */
    final Context f3789a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f3788b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f3788b.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f3788b.addURI("com.android.contacts", "contacts/#/photo", 2);
        f3788b.addURI("com.android.contacts", "contacts/#", 3);
        f3788b.addURI("com.android.contacts", "display_photo/#", 4);
    }

    ContactsPhotoRequestHandler(Context context) {
        this.f3789a = context;
    }

    public final boolean canHandleRequest(Request auVar) {
        Uri uri = auVar.f3676d;
//        return MessageKey.MSG_CONTENT.equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && !uri.getPathSegments().contains("photo");
        return false;
    }

    public final C1580az load(Request auVar) {
        InputStream inputStream = null;
        try {
            inputStream = m3584a(auVar);
            return new C1580az(m3583a(inputStream, auVar), C1573an.DISK);
        } finally {
            C1584bj.m3556a(inputStream);
        }
    }

    /* renamed from: a */
    private InputStream m3584a(Request auVar) {
        ContentResolver contentResolver = this.f3789a.getContentResolver();
        Uri uri = auVar.f3676d;
        switch (f3788b.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
//                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private Bitmap m3583a(InputStream inputStream, Request auVar) {
        if (inputStream == null) {
            return null;
        }
        Options createBitmapOptions = createBitmapOptions(auVar);
        if (requiresInSampleSize(createBitmapOptions)) {
            InputStream a = m3584a(auVar);
            try {
                BitmapFactory.decodeStream(a, null, createBitmapOptions);
                C1584bj.m3556a(a);
                calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
            } catch (Throwable th) {
                C1584bj.m3556a(a);
                throw th;
            }
        }
        return BitmapFactory.decodeStream(inputStream, null, createBitmapOptions);
    }
}
