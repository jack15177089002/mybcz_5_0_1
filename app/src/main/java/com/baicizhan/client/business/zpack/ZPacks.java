package com.baicizhan.client.business.zpack;

import com.baicizhan.client.business.zpack.ZPackage.FileEntry;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ZPacks {
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void extract(com.baicizhan.client.business.zpack.ZPackage r5, String r6, String r7) {
        /*
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0049, all -> 0x0041 }
            java.io.InputStream r0 = r5.openFile(r6)     // Catch:{ IOException -> 0x0049, all -> 0x0041 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0049, all -> 0x0041 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x004c, all -> 0x0044 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004c, all -> 0x0044 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x004c, all -> 0x0044 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x004c, all -> 0x0044 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0023, all -> 0x0046 }
        L_0x0018:
            int r2 = r3.read(r0)     // Catch:{ IOException -> 0x0023, all -> 0x0046 }
            if (r2 <= 0) goto L_0x0037
            r4 = 0
            r1.write(r0, r4, r2)     // Catch:{ IOException -> 0x0023, all -> 0x0046 }
            goto L_0x0018
        L_0x0023:
            r0 = move-exception
            r2 = r3
        L_0x0025:
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r0 = move-exception
            r3 = r2
            r2 = r1
        L_0x0029:
            if (r3 == 0) goto L_0x002e
            r3.close()
        L_0x002e:
            if (r2 == 0) goto L_0x0036
            r2.flush()
            r2.close()
        L_0x0036:
            throw r0
        L_0x0037:
            r3.close()
            r1.flush()
            r1.close()
            return
        L_0x0041:
            r0 = move-exception
            r3 = r2
            goto L_0x0029
        L_0x0044:
            r0 = move-exception
            goto L_0x0029
        L_0x0046:
            r0 = move-exception
            r2 = r1
            goto L_0x0029
        L_0x0049:
            r0 = move-exception
            r1 = r2
            goto L_0x0025
        L_0x004c:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.zpack.ZPacks.extract(com.baicizhan.client.business.zpack.ZPackage, java.lang.String, java.lang.String):void");
    }

    public static void unpack(ZPackage zPackage) {
        unpack(zPackage, FileHelper.splitext(zPackage.getPackageFilename())[0]);
    }

    public static void unpack(ZPackage zPackage, String str) {
        if (!FileHelper.makePath(str)) {
            throw new IOException("Cannot create unpack dir: " + str);
        }
        for (int i = 0; i < zPackage.getFileCount(); i++) {
            FileEntry fileEntry = zPackage.getFileEntry(i);
            String str2 = str + File.separator + fileEntry.filename;
            FileHelper.createFile(str2);
            extract(zPackage, fileEntry.filename, str2);
        }
    }

    public static void pack(ZPackage zPackage, String str) {
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("path not exists: " + str);
        }
        packImpl(zPackage, file);
        zPackage.close();
    }

    private static void packImpl(ZPackage zPackage, File file) {
        System.out.println("packImpl" + file.getPath());
        if (file.isDirectory()) {
            for (File packImpl : file.listFiles()) {
                packImpl(zPackage, packImpl);
            }
        } else if (file.isFile() && !file.isHidden()) {
            zPackage.addFile(file.getPath(), file.getPath());
            System.out.println("inject " + file.getPath());
        }
    }

    public static void merge(ZPackage zPackage, ZPackage zPackage2) {
        byte[] bArr = new byte[4096];
        for (int i = 0; i < zPackage.getFileCount(); i++) {
            FileEntry fileEntry = zPackage.getFileEntry(i);
            InputStream openFile = zPackage.openFile(fileEntry.filename);
            OutputStream createFile = zPackage2.createFile(fileEntry.filename, fileEntry.availableSize);
            while (true) {
                int read = openFile.read(bArr);
                if (read <= 0) {
                    break;
                }
                createFile.write(bArr, 0, read);
            }
            openFile.close();
            createFile.close();
        }
        zPackage2.flush();
    }
}
