package com.baicizhan.client.business.util;

import android.content.res.AssetManager;
import android.os.Environment;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    private FileUtil() {
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

    public static boolean saveFile(String str, byte[] bArr) {
        return saveFile(null, str, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[SYNTHETIC, Splitter:B:25:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c A[SYNTHETIC, Splitter:B:33:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveFile(String r6, String r7, byte[] r8) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0013
            if (r7 == 0) goto L_0x0013
            java.lang.String r1 = "/"
            int r1 = r7.lastIndexOf(r1)
            java.lang.String r6 = r7.substring(r0, r1)
            java.lang.String r7 = r7.substring(r1)
        L_0x0013:
            boolean r1 = checkDir(r6)
            if (r1 != 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            java.io.File r1 = new java.io.File
            r1.<init>(r6, r7)
            r2 = 0
            boolean r3 = r1.exists()     // Catch:{ IOException -> 0x0044 }
            if (r3 == 0) goto L_0x002c
            boolean r3 = r1.delete()     // Catch:{ IOException -> 0x0044 }
            if (r3 == 0) goto L_0x0019
        L_0x002c:
            boolean r3 = r1.createNewFile()     // Catch:{ IOException -> 0x0044 }
            if (r3 == 0) goto L_0x0019
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0044 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0044 }
            r1 = 0
            int r2 = r8.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r3.write(r8, r1, r2)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r3.flush()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r3.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r0 = 1
            goto L_0x0019
        L_0x0044:
            r1 = move-exception
        L_0x0045:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0063
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = "error = "
            r4.<init>(r5)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0089 }
            r3.error(r1)     // Catch:{ all -> 0x0089 }
        L_0x0063:
            if (r2 == 0) goto L_0x0019
            r2.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x0019
        L_0x0069:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x0019
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error = "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.error(r1)
            goto L_0x0019
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ Exception -> 0x0090 }
        L_0x008f:
            throw r0
        L_0x0090:
            r1 = move-exception
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x008f
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error = "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.error(r1)
            goto L_0x008f
        L_0x00b0:
            r0 = move-exception
            r2 = r3
            goto L_0x008a
        L_0x00b3:
            r1 = move-exception
            r2 = r3
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.FileUtil.saveFile(java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static byte[] getFileData(String str) {
        return getFileData(null, str);
    }

    public static byte[] getFileData(String str, String str2) {
        byte[] bArr = null;
        if (str == null && str2 != null) {
            int lastIndexOf = str2.lastIndexOf("/");
            str = str2.substring(0, lastIndexOf);
            str2 = str2.substring(lastIndexOf);
        }
        if (!checkDir(str)) {
            return bArr;
        }
        File file = new File(str, str2);
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

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[SYNTHETIC, Splitter:B:26:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC, Splitter:B:29:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC, Splitter:B:32:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A[SYNTHETIC, Splitter:B:35:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0097 A[SYNTHETIC, Splitter:B:53:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A[SYNTHETIC, Splitter:B:56:0x009f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFromAssetsToLocal(AssetManager r8, String r9, String r10) {
        /*
            r3 = 0
            r1 = 0
            boolean r0 = checkDir(r10)
            if (r0 != 0) goto L_0x000a
            r0 = r1
        L_0x0009:
            return r0
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            getAllPathsFromAssets(r8, r9, r0)
            java.util.Iterator r5 = r0.iterator()
        L_0x0016:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00bc
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            java.io.File r6 = new java.io.File
            r6.<init>(r10, r0)
            boolean r2 = r6.exists()
            if (r2 != 0) goto L_0x0016
            boolean r2 = mkdirs(r0)
            if (r2 != 0) goto L_0x0035
            r0 = r1
            goto L_0x0009
        L_0x0035:
            java.io.InputStream r4 = r8.open(r0)     // Catch:{ IOException -> 0x00c8, all -> 0x00bf }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c3 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c3 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x00cb, all -> 0x00c3 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x00cb, all -> 0x00c3 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x00cb, all -> 0x00c3 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0057, all -> 0x00c6 }
        L_0x004b:
            int r6 = r4.read(r0)     // Catch:{ IOException -> 0x0057, all -> 0x00c6 }
            r7 = -1
            if (r6 == r7) goto L_0x0078
            r7 = 0
            r2.write(r0, r7, r6)     // Catch:{ IOException -> 0x0057, all -> 0x00c6 }
            goto L_0x004b
        L_0x0057:
            r0 = move-exception
            r3 = r4
        L_0x0059:
            r0.printStackTrace()     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x0064
            r2.flush()     // Catch:{ IOException -> 0x008e }
            r2.close()     // Catch:{ IOException -> 0x008e }
        L_0x0064:
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ IOException -> 0x00a3 }
        L_0x0069:
            if (r2 == 0) goto L_0x0071
            r2.flush()     // Catch:{ IOException -> 0x00a8 }
            r2.close()     // Catch:{ IOException -> 0x00a8 }
        L_0x0071:
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ IOException -> 0x00ad }
        L_0x0076:
            r0 = r1
            goto L_0x0009
        L_0x0078:
            r2.flush()     // Catch:{ IOException -> 0x0089 }
            r2.close()     // Catch:{ IOException -> 0x0089 }
        L_0x007e:
            if (r4 == 0) goto L_0x0016
            r4.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0016
        L_0x0084:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0016
        L_0x0089:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x007e
        L_0x008e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0093 }
            goto L_0x0064
        L_0x0093:
            r0 = move-exception
            r4 = r3
        L_0x0095:
            if (r2 == 0) goto L_0x009d
            r2.flush()     // Catch:{ IOException -> 0x00b2 }
            r2.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x009d:
            if (r4 == 0) goto L_0x00a2
            r4.close()     // Catch:{ IOException -> 0x00b7 }
        L_0x00a2:
            throw r0
        L_0x00a3:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0093 }
            goto L_0x0069
        L_0x00a8:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0071
        L_0x00ad:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0076
        L_0x00b2:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x009d
        L_0x00b7:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x00a2
        L_0x00bc:
            r0 = 1
            goto L_0x0009
        L_0x00bf:
            r0 = move-exception
            r2 = r3
            r4 = r3
            goto L_0x0095
        L_0x00c3:
            r0 = move-exception
            r2 = r3
            goto L_0x0095
        L_0x00c6:
            r0 = move-exception
            goto L_0x0095
        L_0x00c8:
            r0 = move-exception
            r2 = r3
            goto L_0x0059
        L_0x00cb:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.FileUtil.copyFromAssetsToLocal(android.content.res.AssetManager, java.lang.String, java.lang.String):boolean");
    }

    public static boolean mkdirs(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf < 0) {
                return true;
            }
            str = str.substring(0, lastIndexOf);
        }
        return checkDir(str);
    }

    public static void getAllPathsFromAssets(AssetManager assetManager, String str, List<String> list) {
        try {
            String[] list2 = assetManager.list(str);
            if (list2 == null) {
                list.add(str);
                return;
            }
            int length = list2.length;
            for (int i = 0; i < length; i++) {
                getAllPathsFromAssets(assetManager, str + File.separator + list2[i], list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
