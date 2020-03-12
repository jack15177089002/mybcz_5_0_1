package com.baicizhan.client.business.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.baicizhan.client.business.util.Aa.C1566ab;
import com.baicizhan.client.business.util.Aa.C1569aj;
import com.baicizhan.client.business.util.Aa.C1573an;
import com.baicizhan.client.framework.BaseAppHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;


//import com.p055f.p056a.C1566ab;
//import com.p055f.p056a.C1573an;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import com.p055f.p056a.Target;
//import com.p055f.p056a.Transformation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PicassoUtil {
    /* access modifiers changed from: private */
    public static final String TAG = PicassoUtil.class.getSimpleName();
    private static C1566ab sPicassoMemoryCache = null;

    public enum Corners {
        NONE(0),
        TOP(8),
        BOTTOM(4),
        LEFT(2),
        RIGHT(1),
        TOP_LEFT(10),
        TOP_RIGHT(9),
        BOTTOM_LEFT(6),
        BOTTOM_RIGHT(5),
        ALL(15);
        
        private int code;

        private Corners(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public abstract class DownloadOnFailTarget extends StrongRefTarget {
        private File file;
        private ImageView imageView;
        private ImageFileLoadFailListener listener;
        private String url;

        public DownloadOnFailTarget(ImageView imageView2, File file2, String str, ImageFileLoadFailListener imageFileLoadFailListener) {
            this.imageView = imageView2;
            this.file = file2;
            this.url = str;
            this.listener = imageFileLoadFailListener;
        }

        public void onBitmapLoadedImpl(Bitmap bitmap, C1573an anVar) {
            this.imageView.setImageBitmap(bitmap);
            LogWrapper.m2793d(PicassoUtil.TAG, "onBitmapLoaded " + anVar);
        }

        public void onBitmapFailedImpl(Drawable drawable) {
            if (this.listener != null) {
                this.listener.onFailed(this.file);
            }
            try {
                this.file.delete();
            } catch (Exception e) {
            }
            if (!TextUtils.isEmpty(this.url)) {
                LogWrapper.m2793d(PicassoUtil.TAG, "load failed try url " + this.url);
//                Picasso.with((Context) BaseAppHandler.getApp()).load(this.url).into((Target) new LoadAndSaveTarget(this.imageView, this.file));
            }
            LogWrapper.m2793d(PicassoUtil.TAG, "onBitmapFailed ");
        }

        public void onPrepareLoadImpl(Drawable drawable) {
            LogWrapper.m2793d(PicassoUtil.TAG, "onPrepareLoad");
        }
    }

    public interface ImageFileLoadFailListener {
        void onFailed(File file);
    }

    public abstract class LoadAndSaveTarget extends StrongRefTarget {
        File mFile;
        ImageView mImageView;

        public LoadAndSaveTarget(ImageView imageView, File file) {
            this.mImageView = imageView;
            this.mFile = file;
        }

        public void onBitmapFailedImpl(Drawable drawable) {
            if (this.mImageView != null) {
                this.mImageView.setImageDrawable(drawable);
            }
        }

        public void onBitmapLoadedImpl(Bitmap bitmap, C1573an anVar) {
            if (anVar == C1573an.NETWORK && this.mFile != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
                    bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.mImageView != null) {
                this.mImageView.setImageBitmap(bitmap);
            }
        }

        public void onPrepareLoadImpl(Drawable drawable) {
            if (this.mImageView != null) {
                this.mImageView.setImageDrawable(drawable);
            }
        }
    }

    public class RoundedTransformation implements Transformation {
        private final Corners corners;
        private final int radius;
        private String uniqueCode;

        public RoundedTransformation(int i, Corners corners2) {
            this.radius = i;
            this.corners = corners2;
            this.uniqueCode = "rounded(radius=" + i + ", corners=" + corners2 + ")";
        }

        public Bitmap transform(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, width, height);
            RectF rectF = new RectF(rect);
            float f = (float) this.radius;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-15658735);
            canvas.drawRoundRect(rectF, f, f, paint);
            boolean z = (this.corners.getCode() & Corners.TOP.getCode()) > 0;
            boolean z2 = (this.corners.getCode() & Corners.BOTTOM.getCode()) > 0;
            canvas.drawRect((this.corners.getCode() & Corners.LEFT.getCode()) > 0 ? f : 0.0f, z ? f : 0.0f, (this.corners.getCode() & Corners.RIGHT.getCode()) > 0 ? ((float) width) - f : (float) width, z2 ? ((float) height) - f : (float) height, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            bitmap.recycle();
            return createBitmap;
        }

        public String key() {
            return this.uniqueCode;
        }
    }

    public static void initPicasso(Context context) {
        sPicassoMemoryCache = new C1566ab(5242880);
        C1569aj ajVar = new C1569aj(context);
        ZpkPicassoRequestHandler zpkPicassoRequestHandler = new ZpkPicassoRequestHandler();
        if (ajVar.f3641b == null) {
            ajVar.f3641b = new ArrayList();
        }
        if (ajVar.f3641b.contains(zpkPicassoRequestHandler)) {
            throw new IllegalStateException("RequestHandler already registered.");
        }
//        ajVar.f3641b.add(zpkPicassoRequestHandler);
        C1566ab abVar = sPicassoMemoryCache;
        if (abVar == null) {
            throw new IllegalArgumentException("Memory cache must not be null.");
        } else if (ajVar.f3640a != null) {
            throw new IllegalStateException("Memory cache already set.");
        } else {
            ajVar.f3640a = abVar;
//            Picasso.m3505a(ajVar.mo16310a());
        }
    }

    public static void releaseMemory() {
        if (sPicassoMemoryCache != null) {
            sPicassoMemoryCache.mo16282a(-1);
        }
    }

    public static Point getBitmapSize(File file) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        Point point = new Point();
        point.x = options.outWidth;
        point.y = options.outHeight;
        return point;
    }

    public static void loadUserImage(Context context, ImageView imageView, String str) {
//        Picasso.with(context).mo16306a((Object) imageView);
        if (str == null || TextUtils.isEmpty(str.trim())) {
//            imageView.setImageResource(R.drawable.userinfo_photo_middle_normal_default);
        } else {
//            Picasso.with(context).load(str).placeholder(R.drawable.userinfo_photo_middle_normal_default).error(R.drawable.userinfo_photo_middle_normal_default).into(imageView, (Callback) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a A[Catch:{ Exception -> 0x004f }, LOOP:0: B:10:0x0040->B:12:0x004a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A[EDGE_INSN: B:21:0x0070->B:22:? ?: BREAK  
EDGE_INSN: B:21:0x0070->B:22:? ?: BREAK  
EDGE_INSN: B:21:0x0070->B:22:? ?: BREAK  , SYNTHETIC, Splitter:B:21:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A[EDGE_INSN: B:21:0x0070->B:22:? ?: BREAK  
EDGE_INSN: B:21:0x0070->B:22:? ?: BREAK  , SYNTHETIC, Splitter:B:21:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094 A[SYNTHETIC, Splitter:B:24:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e A[Catch:{ Exception -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap tryDecodeBitmap(String r7) {
        /*
            r0 = 0
            java.io.File r2 = com.baicizhan.client.business.util.PathUtil.getBaicizhanResourceFile(r7)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "try again, error load "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r3 = r3.toString()
            com.baicizhan.client.business.util.LogWrapper.m2793d(r1, r3)
            java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00bb }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1)     // Catch:{ Exception -> 0x00bb }
            if (r1 != 0) goto L_0x005d
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "decodeFile failed"
            com.baicizhan.client.business.util.LogWrapper.m2793d(r0, r3)     // Catch:{ Exception -> 0x0065 }
        L_0x0030:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x004f }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004f }
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)     // Catch:{ Exception -> 0x004f }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x004f }
        L_0x0040:
            r4 = 0
            r5 = 1024(0x400, float:1.435E-42)
            int r4 = r0.read(r3, r4, r5)     // Catch:{ Exception -> 0x004f }
            r5 = -1
            if (r4 == r5) goto L_0x0070
            r5 = 0
            r2.write(r3, r5, r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0040
        L_0x004f:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
        L_0x0053:
            java.lang.String r2 = "picasso"
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            com.baicizhan.client.business.util.LogWrapper.m2794e(r2, r1)
        L_0x005c:
            return r0
        L_0x005d:
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "decodeFile success"
            com.baicizhan.client.business.util.LogWrapper.m2793d(r0, r3)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0030
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            java.lang.String r3 = "picasso"
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            com.baicizhan.client.business.util.LogWrapper.m2794e(r3, r0)
            goto L_0x0030
        L_0x0070:
            r0.close()     // Catch:{ Exception -> 0x004f }
            byte[] r0 = r2.toByteArray()     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = "picasso"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = "read data length "
            r3.<init>(r4)     // Catch:{ Exception -> 0x004f }
            int r4 = r0.length     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004f }
            com.baicizhan.client.business.util.LogWrapper.m2795i(r2, r3)     // Catch:{ Exception -> 0x004f }
            r2 = 0
            int r3 = r0.length     // Catch:{ Exception -> 0x004f }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r3)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x009e
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = "decodeByteArray failed"
            com.baicizhan.client.business.util.LogWrapper.m2793d(r1, r2)     // Catch:{ Exception -> 0x009c }
            goto L_0x005c
        L_0x009c:
            r1 = move-exception
            goto L_0x0053
        L_0x009e:
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = "decodeByteArray success"
            com.baicizhan.client.business.util.LogWrapper.m2793d(r1, r2)     // Catch:{ Exception -> 0x009c }
            goto L_0x005c
        L_0x00a6:
            java.lang.String r1 = "picasso"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "!!!file not exist "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            com.baicizhan.client.business.util.LogWrapper.m2794e(r1, r2)
            goto L_0x005c
        L_0x00bb:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.PicassoUtil.tryDecodeBitmap(java.lang.String):android.graphics.Bitmap");
    }

    public static void safeLoadTopicImage(Context context, ImageView imageView, File file, int i, String str, boolean z) {
        LogWrapper.m2793d(TAG, "safeLoaTopicImage " + context + ", " + file + ", " + str);
        if (TextUtils.isEmpty(str) || !z) {
            LogWrapper.m2793d(TAG, "into image");
            RequestCreator a = Picasso.with(context).load(file);
//            a.f3707c = true;
            a.into(imageView, (Callback) null);
            return;
        }
        LogWrapper.m2793d(TAG, "into DownloadOnFailTarget");
        RequestCreator a2 = Picasso.with(context).load(file);
//        a2.f3707c = true;
//        a2.into((Target) new DownloadOnFailTarget(imageView, file, str, null));
    }

    public static void loadAccountUserImage(Context context, String str, String str2, ImageView imageView, int i) {
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str, StringUtil.md5Hex(str2, false));
            if (!file.exists()) {
                RequestCreator a = Picasso.with(context).load(str2);
                if (i != 0) {
                    a.placeholder(i).error(i);
                }
//                a.into((Target) new LoadAndSaveTarget(imageView, file));
            } else if (imageView != null) {
                RequestCreator a2 = Picasso.with(context).load(file);
                if (i != 0) {
                    a2.placeholder(i).error(i);
                }
                a2.into(imageView, (Callback) null);
            }
        } else if (i != 0 && imageView != null) {
            Picasso.with(context).load(i).into(imageView, (Callback) null);
        }
    }

    public static BitmapDrawable flip(Resources resources, BitmapDrawable bitmapDrawable) {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        createBitmap.setDensity(160);
        return new BitmapDrawable(resources, createBitmap);
    }

    public static void setImageViewWithFile(ImageView imageView, String str) {
        imageView.setImageBitmap(BitmapFactory.decodeFile(str));
    }

    public static RequestCreator loadFromZpk(String str, String str2) {
        return Picasso.with((Context) null).load(ZpkPicassoRequestHandler.getImageUri(str, str2));
    }
}
