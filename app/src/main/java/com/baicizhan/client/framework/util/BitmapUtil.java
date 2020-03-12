package com.baicizhan.client.framework.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.File;
import java.io.FileOutputStream;

public class BitmapUtil {
    public static final int CROP_CENTER = 2;
    public static final int CROP_END = 1;
    public static final int CROP_START = 0;

    static class CroppedRect {
        int height;
        int width;

        /* renamed from: x */
        int f2303x;

        /* renamed from: y */
        int f2304y;

        CroppedRect() {
        }
    }

    public static final Bitmap cropSameScale(Bitmap bitmap, int i, int i2) {
        return cropSameScale(bitmap, i, i2, 2);
    }

    public static final Bitmap cropSameScale(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        if (i3 < 0 || i3 > 2) {
            i3 = 2;
        }
        CroppedRect croppedRect = getCroppedRect(bitmap.getWidth(), bitmap.getHeight(), i, i2, i3);
        if (croppedRect == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, croppedRect.f2303x, croppedRect.f2304y, croppedRect.width, croppedRect.height);
        if (createBitmap == bitmap) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    private static final CroppedRect getCroppedRect(int i, int i2, int i3, int i4, int i5) {
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
            return null;
        }
        CroppedRect croppedRect = new CroppedRect();
        if (((float) i3) / ((float) i4) > ((float) i) / ((float) i2)) {
            int i6 = (i4 * i) / i3;
            croppedRect.f2303x = 0;
            switch (i5) {
                case 0:
                    croppedRect.f2304y = 0;
                    break;
                case 1:
                    croppedRect.f2304y = i2 - i6;
                    break;
                default:
                    croppedRect.f2304y = (i2 - i6) / 2;
                    break;
            }
            croppedRect.width = i;
            croppedRect.height = i6;
            return croppedRect;
        }
        int i7 = (i3 * i2) / i4;
        switch (i5) {
            case 0:
                croppedRect.f2303x = 0;
                break;
            case 1:
                croppedRect.f2303x = i - i7;
                break;
            default:
                croppedRect.f2303x = (i - i7) / 2;
                break;
        }
        croppedRect.f2304y = 0;
        croppedRect.width = i7;
        croppedRect.height = i2;
        return croppedRect;
    }

    public static final Bitmap rotate(Bitmap bitmap, int i) {
        float height;
        float width;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        if (90 == i) {
            height = (float) bitmap.getHeight();
            width = 0.0f;
        } else {
            height = (float) bitmap.getHeight();
            width = (float) bitmap.getWidth();
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        matrix.postTranslate(height - fArr[2], width - fArr[5]);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    public static final void saveBitmapToFile(Bitmap bitmap, String str, boolean z) {
        while (bitmap != null) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } else if (z) {
                file.delete();
                z = true;
            } else {
                return;
            }
        }
    }
}
