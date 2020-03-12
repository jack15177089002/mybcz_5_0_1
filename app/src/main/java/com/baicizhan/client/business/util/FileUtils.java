package com.baicizhan.client.business.util;

import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import com.baicizhan.client.framework.util.Cancelable;
import com.baicizhan.client.framework.util.archive.ZipUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class FileUtils {
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    private static final String TAG = "FileUtils";

    public static int setPermissions(File file, int i, int i2, int i3) {
        return setPermissions(file.getAbsolutePath(), i, i2, i3);
    }

    public static int setPermissions(String str, int i, int i2, int i3) {
        return 0;
    }

    public static int setPermissions(FileDescriptor fileDescriptor, int i, int i2, int i3) {
        return 0;
    }

    public static int getUid(String str) {
        return 0;
    }

    public static boolean sync(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(File r2, File r3) {
        /*
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0012 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0012 }
            boolean r0 = copyToFile(r1, r3)     // Catch:{ all -> 0x000d }
            r1.close()     // Catch:{ IOException -> 0x0012 }
        L_0x000c:
            return r0
        L_0x000d:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0012 }
            throw r0     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            r0 = move-exception
            r0 = 0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.FileUtils.copyFile(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0053=Splitter:B:30:0x0053, B:21:0x003a=Splitter:B:21:0x003a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(InputStream r5, File r6) {
        /*
            r0 = 0
            boolean r1 = r6.exists()     // Catch:{ IOException -> 0x003e }
            if (r1 == 0) goto L_0x000a
            r6.delete()     // Catch:{ IOException -> 0x003e }
        L_0x000a:
            java.io.File r1 = r6.getParentFile()     // Catch:{ IOException -> 0x003e }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x003e }
            if (r2 != 0) goto L_0x001b
            boolean r1 = r1.mkdirs()     // Catch:{ IOException -> 0x003e }
            if (r1 != 0) goto L_0x001b
        L_0x001a:
            return r0
        L_0x001b:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003e }
            r2.<init>(r6)     // Catch:{ IOException -> 0x003e }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x002f }
        L_0x0024:
            int r3 = r5.read(r1)     // Catch:{ all -> 0x002f }
            if (r3 < 0) goto L_0x0049
            r4 = 0
            r2.write(r1, r4, r3)     // Catch:{ all -> 0x002f }
            goto L_0x0024
        L_0x002f:
            r1 = move-exception
            r2.flush()     // Catch:{ IOException -> 0x003e }
            java.io.FileDescriptor r3 = r2.getFD()     // Catch:{ IOException -> 0x0058 }
            r3.sync()     // Catch:{ IOException -> 0x0058 }
        L_0x003a:
            r2.close()     // Catch:{ IOException -> 0x003e }
            throw r1     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "FileUtils"
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            com.baicizhan.client.business.util.LogWrapper.m2794e(r2, r1)
            goto L_0x001a
        L_0x0049:
            r2.flush()     // Catch:{ IOException -> 0x003e }
            java.io.FileDescriptor r1 = r2.getFD()     // Catch:{ IOException -> 0x005a }
            r1.sync()     // Catch:{ IOException -> 0x005a }
        L_0x0053:
            r2.close()     // Catch:{ IOException -> 0x003e }
            r0 = 1
            goto L_0x001a
        L_0x0058:
            r3 = move-exception
            goto L_0x003a
        L_0x005a:
            r1 = move-exception
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.FileUtils.copyToFile(java.io.InputStream, java.io.File):boolean");
    }

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static String readTextFile(File file, int i, String str) {
        String str2;
        int read;
        int read2;
        byte[] bArr = null;
        boolean z = true;
        boolean z2 = false;
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try {
            long length = file.length();
            if (i > 0 || (length > 0 && i == 0)) {
                if (length > 0 && (i == 0 || length < ((long) i))) {
                    i = (int) length;
                }
                byte[] bArr2 = new byte[(i + 1)];
                int read3 = bufferedInputStream.read(bArr2);
                if (read3 <= 0) {
                    str2 = "";
                } else if (read3 <= i) {
                    str2 = new String(bArr2, 0, read3);
                    bufferedInputStream.close();
                    fileInputStream.close();
                } else if (str == null) {
                    str2 = new String(bArr2, 0, i);
                    bufferedInputStream.close();
                    fileInputStream.close();
                } else {
                    str2 = new String(bArr2, 0, i) + str;
                    bufferedInputStream.close();
                    fileInputStream.close();
                }
            } else if (i < 0) {
                byte[] bArr3 = null;
                while (true) {
                    if (bArr != null) {
                        z2 = true;
                    }
                    if (bArr == null) {
                        bArr = new byte[(-i)];
                    }
                    read2 = bufferedInputStream.read(bArr);
                    if (read2 != bArr.length) {
                        break;
                    }
                    byte[] bArr4 = bArr;
                    bArr = bArr3;
                    bArr3 = bArr4;
                }
                if (bArr3 == null && read2 <= 0) {
                    str2 = "";
                    bufferedInputStream.close();
                    fileInputStream.close();
                } else if (bArr3 == null) {
                    str2 = new String(bArr, 0, read2);
                    bufferedInputStream.close();
                    fileInputStream.close();
                } else {
                    if (read2 > 0) {
                        System.arraycopy(bArr3, read2, bArr3, 0, bArr3.length - read2);
                        System.arraycopy(bArr, 0, bArr3, bArr3.length - read2, read2);
                    } else {
                        z = z2;
                    }
                    if (str == null || !z) {
                        str2 = new String(bArr3);
                        bufferedInputStream.close();
                        fileInputStream.close();
                    } else {
                        str2 = str + new String(bArr3);
                        bufferedInputStream.close();
                        fileInputStream.close();
                    }
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr5 = new byte[1024];
                do {
                    read = bufferedInputStream.read(bArr5);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr5, 0, read);
                        continue;
                    }
                } while (read == 1024);
                str2 = byteArrayOutputStream.toString();
                bufferedInputStream.close();
                fileInputStream.close();
            }
            return str2;
        } finally {
            bufferedInputStream.close();
            fileInputStream.close();
        }
    }

    public static void stringToFile(String str, String str2) {
        FileWriter fileWriter = new FileWriter(str);
        try {
            fileWriter.write(str2);
        } finally {
            fileWriter.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026 A[SYNTHETIC, Splitter:B:15:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long checksumCrc32(File r4) {
        /*
            java.util.zip.CRC32 r0 = new java.util.zip.CRC32
            r0.<init>()
            r2 = 0
            java.util.zip.CheckedInputStream r1 = new java.util.zip.CheckedInputStream     // Catch:{ all -> 0x0022 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0022 }
            r3.<init>(r4)     // Catch:{ all -> 0x0022 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0022 }
            r2 = 128(0x80, float:1.794E-43)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x002e }
        L_0x0014:
            int r3 = r1.read(r2)     // Catch:{ all -> 0x002e }
            if (r3 >= 0) goto L_0x0014
            long r2 = r0.getValue()     // Catch:{ all -> 0x002e }
            r1.close()     // Catch:{ IOException -> 0x002a }
        L_0x0021:
            return r2
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x002c }
        L_0x0029:
            throw r0
        L_0x002a:
            r0 = move-exception
            goto L_0x0021
        L_0x002c:
            r1 = move-exception
            goto L_0x0029
        L_0x002e:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.FileUtils.checksumCrc32(java.io.File):long");
    }

    public static boolean deleteOlderFiles(File file, int i, long j) {
        boolean z = false;
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Constraints must be positive or 0");
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, new Comparator<File>() {
                public final int compare(File file, File file2) {
                    return (int) (file2.lastModified() - file.lastModified());
                }
            });
            while (i < listFiles.length) {
                File file2 = listFiles[i];
                if (System.currentTimeMillis() - file2.lastModified() > j && file2.delete()) {
                    Log.d(TAG, "Deleted old file " + file2);
                    z = true;
                }
                i++;
            }
        }
        return z;
    }

    public static boolean contains(File file, File file2) {
        if (file2 == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w(TAG, "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    public static boolean isValidExtFilename(String str) {
        if (TextUtils.isEmpty(str) || ".".equals(str) || "..".equals(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 0 || charAt == '/') {
                return false;
            }
        }
        return true;
    }

    public static String rewriteAfterRename(File file, File file2, String str) {
        if (str == null) {
            return null;
        }
        File rewriteAfterRename = rewriteAfterRename(file, file2, new File(str));
        if (rewriteAfterRename != null) {
            return rewriteAfterRename.getAbsolutePath();
        }
        return null;
    }

    public static String[] rewriteAfterRename(File file, File file2, String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = rewriteAfterRename(file, file2, strArr[i]);
        }
        return strArr2;
    }

    public static File rewriteAfterRename(File file, File file2, File file3) {
        if (file3 != null && contains(file, file3)) {
            return new File(file2, file3.getAbsolutePath().substring(file.getAbsolutePath().length()));
        }
        return null;
    }

    public static String stripExtension(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String replaceExtension(String str, String str2) {
        if (str == null) {
            return str;
        }
        return stripExtension(str) + str2;
    }

    public static String getFileName(String str) {
        return new File(str).getName();
    }

    public static boolean checkSD() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public static boolean checkDir(String str) {
        if (!checkSD()) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        if (file.mkdirs()) {
            return true;
        }
        if (!LSwitcher.isOpened()) {
            return false;
        }
        C0789L.log.error("error fulldirObj.mkdirs:" + str);
        return false;
    }

    public static boolean copyAndUnzipFromRaw(Resources resources, int i, String str, String str2) {
        if (!checkDir(str)) {
            return false;
        }
        File file = new File(str, str2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resources.openRawResource(i));
        try {
            if (!copyToFile(bufferedInputStream, file)) {
                return false;
            }
            new ZipUtils().decompress(file, true, (Cancelable) null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                bufferedInputStream.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static boolean copyFromRaw(Resources resources, int i, String str, String str2) {
        boolean z = false;
        if (!checkDir(str)) {
            return z;
        }
        File file = new File(str, str2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resources.openRawResource(i));
        try {
            return copyToFile(bufferedInputStream, file);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                bufferedInputStream.close();
                return z;
            } catch (IOException e2) {
                e2.printStackTrace();
                return z;
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                outputStream.close();
                return;
            }
        }
    }

    public static String readAll(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        byteArrayOutputStream.close();
        return byteArrayOutputStream2;
    }

    public static String readTextStringFromRaw(Resources resources, int i) {
        return readAll(new BufferedInputStream(resources.openRawResource(i)));
    }

    public static void closeQuitely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unzipRawFileToSDCard(Resources resources, int i, String str, String str2) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resources.openRawResource(i));
        File file = new File(str, str2);
        if (!file.exists() || file.length() != ((long) bufferedInputStream.available())) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean copyToFile = copyToFile(bufferedInputStream, file);
            Log.d(TAG, "unzip " + str2 + " elapsed " + (System.currentTimeMillis() - currentTimeMillis));
            if (!copyToFile) {
                file.delete();
                throw new IOException("unzip failed " + str2);
            }
        }
    }

    public static boolean needUnzipRawFileToSDCard(Resources resources, int i, String str, String str2) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resources.openRawResource(i));
        File file = new File(str, str2);
        return !file.exists() || file.length() != ((long) bufferedInputStream.available());
    }
}
