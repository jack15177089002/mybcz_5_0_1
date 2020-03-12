package com.baicizhan.client.business.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

import com.baicizhan.client.business.util.Aa.C1573an;
import com.baicizhan.client.business.util.Aa.C1580az;
import com.baicizhan.client.business.util.Aa.Request;
import com.baicizhan.client.business.util.Aa.RequestHandler;
import com.baicizhan.client.business.zpack.ZPackage;
//import com.p055f.p056a.C1573an;
//import com.p055f.p056a.C1580az;
//import com.p055f.p056a.Request;
//import com.p055f.p056a.RequestHandler;
import java.io.IOException;
import java.io.InputStream;

public class ZpkPicassoRequestHandler extends RequestHandler {
    public static final String SCHEME_ZPK = "baicizhan_zpk";

    public static Uri getImageUri(String str, String str2) {
        return new Builder().scheme(SCHEME_ZPK).appendPath(str).query(str2).build();
    }

    public boolean canHandleRequest(Request auVar) {
        Uri uri = auVar.f3676d;
        return SCHEME_ZPK.equals(uri.getScheme()) && !TextUtils.isEmpty(uri.getPath()) && !TextUtils.isEmpty(uri.getQuery());
    }

    static Options createBitmapOptions(Request auVar) {
        boolean c = auVar.mo16323c();
        boolean z = auVar.f3688p != null;
        Options options = null;
        if (c || z) {
            options = new Options();
            options.inJustDecodeBounds = c;
            if (z) {
                options.inPreferredConfig = auVar.f3688p;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void calculateInSampleSize(int i, int i2, Options options, Request auVar) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, auVar);
    }

    static void calculateInSampleSize(int i, int i2, int i3, int i4, Options options, Request auVar) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = auVar.f3683k ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeContentStream(Request auVar) {
        Options createBitmapOptions = createBitmapOptions(auVar);
        String path = auVar.f3676d.getPath();
        String query = auVar.f3676d.getQuery();
        ZPackage zPackage = new ZPackage(path, 1);
        if (requiresInSampleSize(createBitmapOptions)) {
            InputStream openFile = zPackage.openFile(query);
            try {
                BitmapFactory.decodeStream(openFile, null, createBitmapOptions);
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
            } finally {
                try {
                    openFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        InputStream openFile2 = zPackage.openFile(query);
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(openFile2, null, createBitmapOptions);
            try {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return decodeStream;
        } finally {
            try {
                zPackage.close();
                openFile2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public C1580az load(Request auVar) {
        return new C1580az(decodeContentStream(auVar), C1573an.DISK);
    }
}
