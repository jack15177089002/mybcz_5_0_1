package com.baicizhan.client.framework.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.baicizhan.client.framework.BaseAppHandler;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileHelper {
    public static final int ERR_FILE_IO_SD = 3;
    public static final int ERR_FILE_NO_SD = 1;
    public static final int ERR_FILE_OK = 0;
    public static final int ERR_FILE_SHARED_SD = 2;
    public static final File EXTERNAL_STORAGE_DIRECTORY = BaseAppHandler.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    public static final int SD_MIN_AVAILAALE_SIZE = 2;

    public static boolean checkSD() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public static int getSdError() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            return 0;
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable") || externalStorageState.equals("removed")) {
            return 1;
        }
        if (externalStorageState.equals("shared")) {
            return 2;
        }
        return 3;
    }

    public static String getPath(String str) {
        return str != null ? str : EXTERNAL_STORAGE_DIRECTORY + "/";
    }

    public static String getFilePath(String str, String str2) {
        if (str != null) {
            return str + "/" + str2;
        }
        return EXTERNAL_STORAGE_DIRECTORY + "/" + str2;
    }

    public static boolean checkSDHasSpace() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (((getAvailableBlocks(statFs) * getBlockSize(statFs)) / 1024) / 1024 > 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static long getAvailableBlocks(StatFs statFs) {
        if (VERSION.SDK_INT >= 18) {
            return _API18_getAvailableBlocks(statFs);
        }
        return _getAvailableBlocks(statFs);
    }

    private static long _getAvailableBlocks(StatFs statFs) {
        return (long) statFs.getAvailableBlocks();
    }

    @TargetApi(18)
    private static long _API18_getAvailableBlocks(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private static long getBlockSize(StatFs statFs) {
        if (VERSION.SDK_INT >= 18) {
            return _API18_getBlockSize(statFs);
        }
        return _getBlockSize(statFs);
    }

    private static long _getBlockSize(StatFs statFs) {
        return (long) statFs.getBlockSize();
    }

    @TargetApi(18)
    private static long _API18_getBlockSize(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    public static String getFilePath(String str) {
        return getFilePath(null, str);
    }

    public static boolean checkDir(String str) {
        String path = getPath(str);
        if (!checkSD()) {
            return false;
        }
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        if (file.mkdirs()) {
            return true;
        }
        if (!LSwitcher.isOpened()) {
            return false;
        }
        C0789L.log.error("error fulldirObj.mkdirs:" + path);
        return false;
    }

    private static String getDir(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean checkAndMkdirs(String str, String str2) {
        String dir = getDir(getFilePath(str, str2));
        File file = new File(dir);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    if (!LSwitcher.isOpened()) {
                        return false;
                    }
                    C0789L.log.error("error fulldirObj.mkdirs:" + dir);
                    return false;
                }
            } catch (Exception e) {
                if (!LSwitcher.isOpened()) {
                    return false;
                }
                C0789L.log.error("error fulldirObj.mkdirs error:" + e.getMessage() + " " + dir);
                return false;
            }
        }
        return true;
    }

    public static boolean checkFile(String str, String str2) {
        if (!checkSD()) {
            return false;
        }
        try {
            if (getFile(str, str2).exists()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return false;
            }
            C0789L.log.error("error = " + e.getMessage());
            return false;
        }
    }

    public static boolean checkFile(String str) {
        return checkFile(null, str);
    }

    public static File getFile(String str, String str2) {
        if (!checkDir(str)) {
            return null;
        }
        try {
            return new File(getFilePath(str, str2));
        } catch (SecurityException e) {
            if (!LSwitcher.isOpened()) {
                return null;
            }
            C0789L.log.error("error = " + e.getMessage());
            return null;
        }
    }

    public static File getFile(String str) {
        return getFile(null, str);
    }

    public static File createFile(String str, String str2) {
        if (checkDir(str)) {
            try {
                if (checkAndMkdirs(str, str2)) {
                    File file = getFile(str, str2);
                    if (!file.exists() || file.delete()) {
                        if (file.createNewFile()) {
                            return file;
                        }
                        if (!LSwitcher.isOpened()) {
                            return null;
                        }
                        C0789L.log.error("error createNewFile" + str + str2);
                        return null;
                    } else if (!LSwitcher.isOpened()) {
                        return null;
                    } else {
                        C0789L.log.error("error file.delete");
                        return null;
                    }
                } else if (!LSwitcher.isOpened()) {
                    return null;
                } else {
                    C0789L.log.error("error checkAndMkdirs");
                    return null;
                }
            } catch (Exception e) {
                if (!LSwitcher.isOpened()) {
                    return null;
                }
                C0789L.log.error("error = " + e.getMessage() + " input:" + str + str2);
                return null;
            }
        } else if (!LSwitcher.isOpened()) {
            return null;
        } else {
            C0789L.log.error("error checkDir");
            return null;
        }
    }

    public static File createFile(String str) {
        return createFile(null, str);
    }

    public static File createFileIfNotFound(String str, String str2) {
        if (!checkDir(str)) {
            return null;
        }
        try {
            File file = getFile(str, str2);
            if (file.exists()) {
                return file;
            }
            if (file.createNewFile()) {
                return file;
            }
            return null;
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return null;
            }
            C0789L.log.error("error = " + e.getMessage());
            return null;
        }
    }

    public static File createFileIfNotFound(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        String str2 = null;
        if (lastIndexOf >= 0) {
            String substring = str.substring(lastIndexOf + 1);
            String substring2 = str.substring(0, lastIndexOf);
            str = substring;
            str2 = substring2;
        }
        return createFileIfNotFound(str2, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[SYNTHETIC, Splitter:B:27:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveGifFile(String r6, String r7, byte[] r8) {
        /*
            r1 = 1
            r0 = 0
            boolean r2 = checkDir(r6)
            if (r2 != 0) goto L_0x0009
        L_0x0008:
            return r0
        L_0x0009:
            if (r8 == 0) goto L_0x0008
            r3 = 0
            java.io.File r4 = createFile(r6, r7)     // Catch:{ Exception -> 0x0023, all -> 0x004b }
            if (r4 == 0) goto L_0x0008
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0023, all -> 0x004b }
            r5 = 1
            r2.<init>(r4, r5)     // Catch:{ Exception -> 0x0023, all -> 0x004b }
            r2.write(r8)     // Catch:{ Exception -> 0x0066 }
            r2.flush()     // Catch:{ Exception -> 0x0066 }
            r2.close()     // Catch:{ Exception -> 0x0066 }
            r0 = r1
            goto L_0x0008
        L_0x0023:
            r1 = move-exception
            r2 = r3
        L_0x0025:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x0034
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r3.error(r1)     // Catch:{ all -> 0x0064 }
        L_0x0034:
            if (r2 == 0) goto L_0x0008
            r2.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x0008
        L_0x003a:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x0008
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r1 = r1.getMessage()
            r2.error(r1)
            goto L_0x0008
        L_0x004b:
            r0 = move-exception
            r2 = r3
        L_0x004d:
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0052:
            throw r0
        L_0x0053:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x0052
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r1 = r1.getMessage()
            r2.error(r1)
            goto L_0x0052
        L_0x0064:
            r0 = move-exception
            goto L_0x004d
        L_0x0066:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.util.FileHelper.saveGifFile(java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static boolean saveGifFile(String str, byte[] bArr) {
        return saveGifFile(null, str, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[SYNTHETIC, Splitter:B:16:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a A[SYNTHETIC, Splitter:B:25:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0047 A[SYNTHETIC, Splitter:B:32:0x0047] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0023=Splitter:B:13:0x0023, B:22:0x0035=Splitter:B:22:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isGif(String r6, String r7) {
        /*
            r5 = 6
            r3 = 0
            r1 = 0
            java.io.File r0 = getFile(r6, r7)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x0031, all -> 0x0043 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x0031, all -> 0x0043 }
            r0 = 7
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0052 }
            r1 = 0
            r4 = 6
            int r1 = r2.read(r0, r1, r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0052 }
            if (r1 != r5) goto L_0x005e
            boolean r0 = isGif(r0)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0052 }
        L_0x001b:
            r2.close()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0056 }
        L_0x001e:
            return r0
        L_0x001f:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r3
        L_0x0023:
            r1.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x001e
            r2.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x001e
        L_0x002c:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x001e
        L_0x0031:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r3
        L_0x0035:
            r1.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x001e
            r2.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x001e
        L_0x003e:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x001e
        L_0x0043:
            r0 = move-exception
            r2 = r1
        L_0x0045:
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ Exception -> 0x004b }
        L_0x004a:
            throw r0
        L_0x004b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x004a
        L_0x0050:
            r0 = move-exception
            goto L_0x0045
        L_0x0052:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L_0x0035
        L_0x0056:
            r1 = move-exception
            goto L_0x0035
        L_0x0058:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L_0x0023
        L_0x005c:
            r1 = move-exception
            goto L_0x0023
        L_0x005e:
            r0 = r3
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.util.FileHelper.isGif(java.lang.String, java.lang.String):boolean");
    }

    public static boolean isGif(String str) {
        return isGif(null, str);
    }

    public static boolean isGif(byte[] bArr) {
        try {
            if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[SYNTHETIC, Splitter:B:26:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0 A[SYNTHETIC, Splitter:B:34:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveFile(String r6, String r7, byte[] r8) {
        /*
            r1 = 1
            r0 = 0
            boolean r2 = checkDir(r6)
            if (r2 != 0) goto L_0x0009
        L_0x0008:
            return r0
        L_0x0009:
            boolean r2 = checkAndMkdirs(r6, r7)
            if (r2 == r1) goto L_0x002e
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r1 == 0) goto L_0x0008
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "checkAndMkdirs fail:"
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r1.error(r2)
            goto L_0x0008
        L_0x002e:
            java.io.File r4 = getFile(r6, r7)
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ IOException -> 0x0057 }
            if (r3 == 0) goto L_0x003f
            boolean r3 = r4.delete()     // Catch:{ IOException -> 0x0057 }
            if (r3 == 0) goto L_0x0008
        L_0x003f:
            boolean r3 = r4.createNewFile()     // Catch:{ IOException -> 0x0057 }
            if (r3 == 0) goto L_0x0008
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0057 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0057 }
            r2 = 0
            int r4 = r8.length     // Catch:{ IOException -> 0x00c7, all -> 0x00c4 }
            r3.write(r8, r2, r4)     // Catch:{ IOException -> 0x00c7, all -> 0x00c4 }
            r3.flush()     // Catch:{ IOException -> 0x00c7, all -> 0x00c4 }
            r3.close()     // Catch:{ IOException -> 0x00c7, all -> 0x00c4 }
            r0 = r1
            goto L_0x0008
        L_0x0057:
            r1 = move-exception
        L_0x0058:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x009d }
            if (r3 == 0) goto L_0x0076
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x009d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
            java.lang.String r5 = "error = "
            r4.<init>(r5)     // Catch:{ all -> 0x009d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x009d }
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch:{ all -> 0x009d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009d }
            r3.error(r1)     // Catch:{ all -> 0x009d }
        L_0x0076:
            if (r2 == 0) goto L_0x0008
            r2.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x0008
        L_0x007c:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x0008
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error = "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.error(r1)
            goto L_0x0008
        L_0x009d:
            r0 = move-exception
        L_0x009e:
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ Exception -> 0x00a4 }
        L_0x00a3:
            throw r0
        L_0x00a4:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x00a3
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error = "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.error(r1)
            goto L_0x00a3
        L_0x00c4:
            r0 = move-exception
            r2 = r3
            goto L_0x009e
        L_0x00c7:
            r1 = move-exception
            r2 = r3
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.util.FileHelper.saveFile(java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static boolean saveFile(String str, byte[] bArr) {
        return saveFile(null, str, bArr);
    }

    public static byte[] getFileData(String str, String str2) {
        byte[] bArr = null;
        if (!checkDir(str)) {
            return bArr;
        }
        File file = getFile(str, str2);
        try {
            if (!file.exists()) {
                return bArr;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr2, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (!LSwitcher.isOpened()) {
                return bArr;
            }
            C0789L.log.error("error = " + e.getMessage());
            return bArr;
        }
    }

    public static byte[] getFileData(String str) {
        return getFileData(null, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[Catch:{ all -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC, Splitter:B:21:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042 A[SYNTHETIC, Splitter:B:24:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0075 A[SYNTHETIC, Splitter:B:42:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007a A[SYNTHETIC, Splitter:B:45:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(String r7, String r8, String r9, String r10) {
        /*
            r2 = 0
            r6 = 0
            java.io.File r0 = getFile(r7, r8)     // Catch:{ Exception -> 0x00a9, all -> 0x0071 }
            java.io.File r4 = getFile(r9, r10)     // Catch:{ Exception -> 0x00a9, all -> 0x0071 }
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x00a9, all -> 0x0071 }
            if (r1 != 0) goto L_0x0011
        L_0x0010:
            return r6
        L_0x0011:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a9, all -> 0x0071 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00a9, all -> 0x0071 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ac, all -> 0x00a0 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x00ac, all -> 0x00a0 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x002a, all -> 0x00a4 }
        L_0x001f:
            int r4 = r3.read(r0)     // Catch:{ Exception -> 0x002a, all -> 0x00a4 }
            if (r4 <= 0) goto L_0x0057
            r5 = 0
            r1.write(r0, r5, r4)     // Catch:{ Exception -> 0x002a, all -> 0x00a4 }
            goto L_0x001f
        L_0x002a:
            r0 = move-exception
            r2 = r3
        L_0x002c:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x003b
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a7 }
            r3.error(r0)     // Catch:{ all -> 0x00a7 }
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0040:
            if (r1 == 0) goto L_0x0010
            r1.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x0010
        L_0x0046:
            r0 = move-exception
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r1 == 0) goto L_0x0010
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r0 = r0.toString()
            r1.error(r0)
            goto L_0x0010
        L_0x0057:
            r3.close()     // Catch:{ Exception -> 0x002a, all -> 0x00a4 }
            r1.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x0010
        L_0x005e:
            r0 = move-exception
            goto L_0x002c
        L_0x0060:
            r0 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x0040
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r0 = r0.toString()
            r2.error(r0)
            goto L_0x0040
        L_0x0071:
            r0 = move-exception
            r1 = r2
        L_0x0073:
            if (r2 == 0) goto L_0x0078
            r2.close()     // Catch:{ Exception -> 0x007e }
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ Exception -> 0x008f }
        L_0x007d:
            throw r0
        L_0x007e:
            r2 = move-exception
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r3 == 0) goto L_0x0078
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r2 = r2.toString()
            r3.error(r2)
            goto L_0x0078
        L_0x008f:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x007d
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r1 = r1.toString()
            r2.error(r1)
            goto L_0x007d
        L_0x00a0:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x0073
        L_0x00a4:
            r0 = move-exception
            r2 = r3
            goto L_0x0073
        L_0x00a7:
            r0 = move-exception
            goto L_0x0073
        L_0x00a9:
            r0 = move-exception
            r1 = r2
            goto L_0x002c
        L_0x00ac:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.util.FileHelper.copyFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(null, str, null, str2);
    }

    public static boolean renameFile(String str, String str2, String str3, String str4) {
        try {
            if (checkAndMkdirs(str3, str4)) {
                File file = getFile(str, str2);
                File file2 = getFile(str3, str4);
                if (!file.exists()) {
                    if (!LSwitcher.isOpened()) {
                        return false;
                    }
                    C0789L.log.error("src File not exist:" + str + str2 + " " + str3 + str4);
                    return false;
                } else if (!file2.exists()) {
                    return file.renameTo(file2);
                } else {
                    if (!LSwitcher.isOpened()) {
                        return false;
                    }
                    C0789L.log.error("dst File exist:" + str + str2 + " " + str3 + str4);
                    return false;
                }
            } else if (!LSwitcher.isOpened()) {
                return false;
            } else {
                C0789L.log.error("error checkAndMkdirs");
                return false;
            }
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return false;
            }
            C0789L.log.error(e.toString());
            return false;
        }
    }

    public static boolean renameFile(String str, String str2) {
        return renameFile(null, str, null, str2);
    }

    public static InputStream getInStreamFromFile(String str, String str2) {
        return getInStreamFromFile(getFile(str, str2));
    }

    public static InputStream getInStreamFromFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            if (LSwitcher.isOpened()) {
                C0789L.log.error("error = " + e.getMessage());
            }
            return null;
        }
    }

    public static OutputStream getOutStreamFromFile(String str, String str2) {
        return getOutStreamFromFile(getFile(str, str2));
    }

    public static OutputStream getOutStreamFromFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileOutputStream(file);
        } catch (Exception e) {
            if (LSwitcher.isOpened()) {
                C0789L.log.error("error = " + e.getMessage());
            }
            return null;
        }
    }

    public static boolean delFile(String str, String str2) {
        if (!checkDir(str)) {
            return false;
        }
        File file = getFile(str, str2);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return false;
            }
            C0789L.log.error("error = " + e.getMessage());
            return false;
        }
    }

    public static boolean delFile(String str) {
        return delFile(null, str);
    }

    public static boolean deleteDir(String str, String str2) {
        if (LSwitcher.isOpened()) {
            C0789L.log.info("*********Note del:" + str + str2);
        }
        return deleteDir(getFile(str, str2));
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteDir(File file, boolean z) {
        if (z) {
            return deleteDir(file);
        }
        if (file == null || !file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        String[] list = file.list();
        for (String file2 : list) {
            if (!deleteDir(new File(file, file2), false)) {
                return false;
            }
        }
        return true;
    }

    public static void writeAmrFileHeader(OutputStream outputStream) {
        try {
            outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeWaveFileHeader(DataOutputStream dataOutputStream, long j, long j2, long j3, int i, long j4) {
        try {
            dataOutputStream.write(new byte[]{82, 73, 70, 70, (byte) ((int) (255 & j2)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i, 0, (byte) ((int) (255 & j3)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((int) (255 & j4)), (byte) ((int) ((j4 >> 8) & 255)), (byte) ((int) ((j4 >> 16) & 255)), (byte) ((int) ((j4 >> 24) & 255)), 4, 0, 16, 0, 100, 97, 116, 97, (byte) ((int) (255 & j)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255))}, 0, 44);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long getDirectorySize(String str, boolean z) {
        return getDirectorySize(new File(str), z);
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].isDirectory() || z) {
                length = listFiles[i].length();
            } else {
                length = getDirectorySize(listFiles[i], false);
            }
            j += length;
        }
        return j;
    }

    public static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            if (LSwitcher.isOpened()) {
                C0789L.log.error("error = " + e.getMessage());
            }
        }
    }

    public static long getFileSize(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    j = (long) fileInputStream.available();
                } catch (Exception e) {
                    fileInputStream2 = fileInputStream;
                    CloseHelper.close((InputStream) fileInputStream2);
                    return j;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    fileInputStream2 = fileInputStream;
                    th = th2;
                    CloseHelper.close((InputStream) fileInputStream2);
                    throw th;
                }
            } else {
                fileInputStream = null;
            }
            CloseHelper.close((InputStream) fileInputStream);
        } catch (Exception e2) {
            CloseHelper.close((InputStream) fileInputStream2);
            return j;
        } catch (Throwable th3) {
//            th = th3;
//            CloseHelper.close((InputStream) fileInputStream2);
//            throw th;
        }
        return j;
    }
}
