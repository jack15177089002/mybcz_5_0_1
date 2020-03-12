package com.baicizhan.client.business.util.Aa;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
//import com.tencent.android.tpush.common.MessageKey;

/* renamed from: com.f.a.ad */
final class MediaStoreRequestHandler extends ContentStreamRequestHandler {

    /* renamed from: b */
    private static final String[] f3613b = {"orientation"};

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    public final boolean canHandleRequest(Request auVar) {
        Uri uri = auVar.f3676d;
//        return MessageKey.MSG_CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());

        return false;
    }

    public final C1580az load(Request auVar) {
        Bitmap thumbnail;
        int i = 1;
        ContentResolver contentResolver = this.f3790a.getContentResolver();
        int a = m3502a(contentResolver, auVar.f3676d);
        String type = contentResolver.getType(auVar.f3676d);
        boolean z = type != null && type.startsWith("video/");
        if (auVar.mo16323c()) {
            int i2 = auVar.f3680h;
            int i3 = auVar.f3681i;
            C1567ae aeVar = (i2 > C1567ae.MICRO.f3619e || i3 > C1567ae.MICRO.f3620f) ? (i2 > C1567ae.MINI.f3619e || i3 > C1567ae.MINI.f3620f) ? C1567ae.FULL : C1567ae.MINI : C1567ae.MICRO;
            if (!z && aeVar == C1567ae.FULL) {
                return new C1580az(mo16353a(auVar), C1573an.DISK, a);
            }
            long parseId = ContentUris.parseId(auVar.f3676d);
            Options createBitmapOptions = createBitmapOptions(auVar);
            createBitmapOptions.inJustDecodeBounds = true;
            calculateInSampleSize(auVar.f3680h, auVar.f3681i, aeVar.f3619e, aeVar.f3620f, createBitmapOptions, auVar);
            if (z) {
                if (aeVar != C1567ae.FULL) {
                    i = aeVar.f3618d;
                }
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, i, createBitmapOptions);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, aeVar.f3618d, createBitmapOptions);
            }
            if (thumbnail != null) {
                return new C1580az(thumbnail, C1573an.DISK, a);
            }
        }
        return new C1580az(mo16353a(auVar), C1573an.DISK, a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m3502a(ContentResolver r8, Uri r9) {
        /*
            r6 = 0
            r7 = 0
            java.lang.String[] r2 = f3613b     // Catch:{ RuntimeException -> 0x0027, all -> 0x0030 }
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            r1 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ RuntimeException -> 0x0027, all -> 0x0030 }
            if (r1 == 0) goto L_0x0015
            boolean r0 = r1.moveToFirst()     // Catch:{ RuntimeException -> 0x003a, all -> 0x0038 }
            if (r0 != 0) goto L_0x001c
        L_0x0015:
            if (r1 == 0) goto L_0x001a
            r1.close()
        L_0x001a:
            r0 = r6
        L_0x001b:
            return r0
        L_0x001c:
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch:{ RuntimeException -> 0x003a, all -> 0x0038 }
            if (r1 == 0) goto L_0x001b
            r1.close()
            goto L_0x001b
        L_0x0027:
            r0 = move-exception
            r0 = r7
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            r0.close()
        L_0x002e:
            r0 = r6
            goto L_0x001b
        L_0x0030:
            r0 = move-exception
            r1 = r7
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            throw r0
        L_0x0038:
            r0 = move-exception
            goto L_0x0032
        L_0x003a:
            r0 = move-exception
            r0 = r1
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p055f.p056a.MediaStoreRequestHandler.m3502a(android.content.ContentResolver, android.net.Uri):int");
    }
}
