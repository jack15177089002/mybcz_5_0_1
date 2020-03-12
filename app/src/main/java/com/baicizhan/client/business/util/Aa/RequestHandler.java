package com.baicizhan.client.business.util.Aa;

import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;

/* renamed from: com.f.a.ay */
public abstract class RequestHandler {
    public abstract boolean canHandleRequest(Request auVar);

    public abstract C1580az load(Request auVar);

    /* access modifiers changed from: 0000 */
    public int getRetryCount() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean supportsReplay() {
        return false;
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
                if (auVar.f3683k) {
                    i5 = Math.max(floor, floor2);
                } else {
                    i5 = Math.min(floor, floor2);
                }
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}
