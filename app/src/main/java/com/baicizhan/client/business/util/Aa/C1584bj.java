package com.baicizhan.client.business.util.Aa;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
//import com.tencent.android.tpush.common.Constants;
import com.squareup.picasso.Request;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/* renamed from: com.f.a.bj */
/* compiled from: Utils */
public final class C1584bj {

    /* renamed from: a */
    static final StringBuilder f3757a = new StringBuilder();

    /* renamed from: a */
    static int m3546a(Bitmap bitmap) {
        int rowBytes;
        if (VERSION.SDK_INT >= 12) {
            rowBytes = bitmap.getByteCount();
        } else {
            rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (rowBytes >= 0) {
            return rowBytes;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* renamed from: a */
    static void m3555a() {
        if (!m3562b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: b */
    static boolean m3562b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: a */
    static String m3553a(BitmapHunter dVar) {
        return m3554a(dVar, "");
    }

    /* renamed from: a */
    static String m3554a(BitmapHunter dVar, String str) {
        StringBuilder sb = new StringBuilder(str);
//        Action aVar = dVar.f3773j;
//        if (aVar != null) {
//            sb.append(aVar.f3590b.mo16321a());
//        }
//        List<Action> list = dVar.f3774k;
//        if (list != null) {
//            int size = list.size();
//            for (int i = 0; i < size; i++) {
//                if (i > 0 || aVar != null) {
//                    sb.append(", ");
//                }
//                sb.append(((Action) list.get(i)).f3590b.mo16321a());
//            }
//        }
        return sb.toString();
    }

    /* renamed from: a */
    static void m3557a(String str, String str2, String str3) {
        m3558a(str, str2, str3, "");
    }

    /* renamed from: a */
    static void m3558a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    /* renamed from: a */
    static String m3551a(Request auVar) {
        String a = m3552a(auVar, f3757a);
        f3757a.setLength(0);
        return a;
    }

    /* renamed from: a */
    public static String m3552a(Request auVar, StringBuilder sb) {
//        if (auVar.f3678f != null) {
//            sb.ensureCapacity(auVar.f3678f.length() + 50);
//            sb.append(auVar.f3678f);
//        } else if (auVar.f3676d != null) {
//            String uri = auVar.f3676d.toString();
//            sb.ensureCapacity(uri.length() + 50);
//            sb.append(uri);
//        } else {
//            sb.ensureCapacity(50);
//            sb.append(auVar.f3677e);
//        }
//        sb.append(10);
//        if (auVar.f3684l != 0.0f) {
//            sb.append("rotation:").append(auVar.f3684l);
//            if (auVar.f3687o) {
//                sb.append('@').append(auVar.f3685m).append('x').append(auVar.f3686n);
//            }
//            sb.append(10);
//        }
//        if (auVar.mo16323c()) {
//            sb.append("resize:").append(auVar.f3680h).append('x').append(auVar.f3681i);
//            sb.append(10);
//        }
//        if (auVar.f3682j) {
//            sb.append("centerCrop\n");
//        } else if (auVar.f3683k) {
//            sb.append("centerInside\n");
//        }
//        if (auVar.f3679g != null) {
//            int size = auVar.f3679g.size();
//            for (int i = 0; i < size; i++) {
//                sb.append(((Transformation) auVar.f3679g.get(i)).key());
//                sb.append(10);
//            }
//        }
        return sb.toString();
    }

    /* renamed from: a */
    static void m3556a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    static boolean m3560a(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!"CONDITIONAL_CACHE".equals(split[0]) || Integer.parseInt(split[1]) != 304) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: a */
//    static Downloader m3549a(Context context) {
//        boolean z;
//        boolean z2 = true;
//        try {
//            Class.forName("com.squareup.okhttp.OkUrlFactory");
//            z = true;
//        } catch (ClassNotFoundException e) {
//            z = false;
//        }
//        try {
//            Class.forName("com.squareup.okhttp.OkHttpClient");
//        } catch (ClassNotFoundException e2) {
//            z2 = false;
//        }
//        if (z2 == z) {
//            return z2 ? new OkHttpDownloader(context) : new UrlConnectionDownloader(context);
//        }
//        throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
//    }

    /* renamed from: a */
    static void m3559a(Throwable th) {
//        throw th;
    }

    /* renamed from: b */
    static File m3561b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    static long m3547a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    /* renamed from: c */
    static int m3565c(Context context) {
//        int i;
//        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
//        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
//        int memoryClass = activityManager.getMemoryClass();
//        if (!z || VERSION.SDK_INT < 11) {
//            i = memoryClass;
//        } else {
//            i = activityManager.getLargeMemoryClass();
//        }
//        return (i * 1048576) / 7;

        return -1;
    }

    /* renamed from: d */
    static boolean m3567d(Context context) {
        if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static <T> T m3550a(Context context, String str) {
//        return context.getSystemService(str);

        return null;
    }

    /* renamed from: b */
    static boolean m3563b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    static byte[] m3564b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
//            int read = inputStream.read(bArr);
//            if (-1 == read) {
//                return byteArrayOutputStream.toByteArray();
//            }
//            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: c */
    static boolean m3566c(InputStream inputStream) {
        byte[] bArr = new byte[12];
//        if (inputStream.read(bArr, 0, 12) != 12 || !"RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) || !"WEBP".equals(new String(bArr, 8, 4, "US-ASCII"))) {
//            return false;
//        }
        return true;
    }

    /* renamed from: a */
    static int m3545a(Resources resources, Request auVar) {
//        if (auVar.f3677e != 0 || auVar.f3676d == null) {
//            return auVar.f3677e;
//        }
//        String authority = auVar.f3676d.getAuthority();
//        if (authority == null) {
//            throw new FileNotFoundException("No package provided: " + auVar.f3676d);
//        }
//        List pathSegments = auVar.f3676d.getPathSegments();
//        if (pathSegments == null || pathSegments.isEmpty()) {
//            throw new FileNotFoundException("No path segments: " + auVar.f3676d);
//        } else if (pathSegments.size() == 1) {
//            try {
//                return Integer.parseInt((String) pathSegments.get(0));
//            } catch (NumberFormatException e) {
//                throw new FileNotFoundException("Last path segment is not a resource ID: " + auVar.f3676d);
//            }
//        } else if (pathSegments.size() == 2) {
//            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
//        } else {
//            throw new FileNotFoundException("More than two path segments: " + auVar.f3676d);
//        }

        return -1;
    }

    /* renamed from: a */
    static Resources m3548a(Context context, Request auVar) {
//        if (auVar.f3677e != 0 || auVar.f3676d == null) {
//            return context.getResources();
//        }
//        String authority = auVar.f3676d.getAuthority();
//        if (authority == null) {
//            throw new FileNotFoundException("No package provided: " + auVar.f3676d);
//        }
//        try {
//            return context.getPackageManager().getResourcesForApplication(authority);
//        } catch (NameNotFoundException e) {
//            throw new FileNotFoundException("Unable to obtain resources for package: " + auVar.f3676d);
//        }
        return null;
    }
}
