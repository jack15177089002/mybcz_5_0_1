package com.baicizhan.client.business.util;

import android.os.StatFs;
import p012ch.qos.logback.core.CoreConstants;

public class StorageUtils {
    private static final String TAG = "StorageUtils";

    public class StorageInfo {
        public final int display_number;
        public final boolean internal;
        public final String path;
        public final boolean readonly;

        StorageInfo(String str, boolean z, boolean z2, int i) {
            this.path = str;
            this.internal = z;
            this.readonly = z2;
            this.display_number = i;
        }

        public String getDisplayName() {
            StringBuilder sb = new StringBuilder();
            if (this.internal) {
                sb.append("Internal SD card");
            } else if (this.display_number > 1) {
                sb.append("SD card " + this.display_number);
            } else {
                sb.append("SD card");
            }
            if (this.readonly) {
                sb.append(" (Read only)");
            }
            return sb.toString();
        }

        public String toString() {
            return "StorageInfo{path='" + this.path + CoreConstants.SINGLE_QUOTE_CHAR + ", internal=" + this.internal + ", readonly=" + this.readonly + ", display_number=" + this.display_number + CoreConstants.CURLY_RIGHT;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab A[SYNTHETIC, Splitter:B:30:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012c A[SYNTHETIC, Splitter:B:64:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0138 A[SYNTHETIC, Splitter:B:70:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<StorageInfo> getStorageList() {
        /*
            r1 = 1
            r2 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r6 = r0.getPath()
            boolean r0 = android.os.Environment.isExternalStorageRemovable()
            if (r0 != 0) goto L_0x00af
            r0 = r1
        L_0x0016:
            java.lang.String r3 = android.os.Environment.getExternalStorageState()
            java.lang.String r4 = "mounted"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = "mounted_ro"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x002b
        L_0x002a:
            r2 = r1
        L_0x002b:
            java.lang.String r3 = android.os.Environment.getExternalStorageState()
            java.lang.String r4 = "mounted_ro"
            boolean r7 = r3.equals(r4)
            r3 = 0
            java.util.HashSet r8 = new java.util.HashSet     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
            java.io.FileReader r9 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
            java.lang.String r10 = "/proc/mounts"
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
            r4.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0125, all -> 0x0134 }
        L_0x0047:
            java.lang.String r3 = r4.readLine()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r3 == 0) goto L_0x010d
            java.lang.String r9 = "vfat"
            boolean r9 = r3.contains(r9)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r9 != 0) goto L_0x0065
            java.lang.String r9 = "/mnt"
            boolean r9 = r3.contains(r9)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r9 != 0) goto L_0x0065
            java.lang.String r9 = ""
            boolean r9 = r3.contains(r9)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r9 == 0) goto L_0x0047
        L_0x0065:
            java.util.StringTokenizer r9 = new java.util.StringTokenizer     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r10 = " "
            r9.<init>(r3, r10)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r9.nextToken()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r10 = r9.nextToken()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            boolean r11 = r8.contains(r10)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 != 0) goto L_0x0047
            r9.nextToken()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r9 = r9.nextToken()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r11 = ","
            java.lang.String[] r9 = r9.split(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.util.List r9 = java.util.Arrays.asList(r9)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r11 = "ro"
            boolean r9 = r9.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            boolean r11 = r10.equals(r6)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 == 0) goto L_0x00b2
            r8.add(r6)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r3 = 0
            com.baicizhan.client.business.util.StorageUtils$StorageInfo r10 = new com.baicizhan.client.business.util.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r11 = -1
            r10.<init>(r6, r0, r9, r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r5.add(r3, r10)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            goto L_0x0047
        L_0x00a4:
            r0 = move-exception
            r1 = r4
        L_0x00a6:
            r0.printStackTrace()     // Catch:{ all -> 0x0143 }
            if (r1 == 0) goto L_0x00ae
            r1.close()     // Catch:{ IOException -> 0x013c }
        L_0x00ae:
            return r5
        L_0x00af:
            r0 = r2
            goto L_0x0016
        L_0x00b2:
            java.lang.String r11 = "/dev/block/vold"
            boolean r11 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 == 0) goto L_0x00f3
            java.lang.String r11 = "/mnt/secure"
            boolean r11 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 != 0) goto L_0x0047
            java.lang.String r11 = "/mnt/asec"
            boolean r11 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 != 0) goto L_0x0047
            java.lang.String r11 = "/mnt/obb"
            boolean r11 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 != 0) goto L_0x0047
            java.lang.String r11 = "/dev/mapper"
            boolean r11 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r11 != 0) goto L_0x0047
            java.lang.String r11 = "tmpfs"
            boolean r3 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r3 != 0) goto L_0x0047
            r8.add(r10)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            com.baicizhan.client.business.util.StorageUtils$StorageInfo r11 = new com.baicizhan.client.business.util.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r12 = 0
            int r3 = r1 + 1
            r11.<init>(r10, r12, r9, r1)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r5.add(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r1 = r3
            goto L_0x0047
        L_0x00f3:
            java.lang.String r3 = r10.toLowerCase()     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            java.lang.String r11 = "sd"
            boolean r3 = r3.contains(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r3 == 0) goto L_0x0047
            com.baicizhan.client.business.util.StorageUtils$StorageInfo r11 = new com.baicizhan.client.business.util.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r12 = 0
            int r3 = r1 + 1
            r11.<init>(r10, r12, r9, r1)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r5.add(r11)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r1 = r3
            goto L_0x0047
        L_0x010d:
            boolean r1 = r8.contains(r6)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            if (r1 != 0) goto L_0x011f
            if (r2 == 0) goto L_0x011f
            r1 = 0
            com.baicizhan.client.business.util.StorageUtils$StorageInfo r2 = new com.baicizhan.client.business.util.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r3 = -1
            r2.<init>(r6, r0, r7, r3)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
            r5.add(r1, r2)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0146 }
        L_0x011f:
            r4.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x00ae
        L_0x0123:
            r0 = move-exception
            goto L_0x00ae
        L_0x0125:
            r0 = move-exception
            r4 = r3
        L_0x0127:
            r0.printStackTrace()     // Catch:{ all -> 0x0141 }
            if (r4 == 0) goto L_0x00ae
            r4.close()     // Catch:{ IOException -> 0x0131 }
            goto L_0x00ae
        L_0x0131:
            r0 = move-exception
            goto L_0x00ae
        L_0x0134:
            r0 = move-exception
            r4 = r3
        L_0x0136:
            if (r4 == 0) goto L_0x013b
            r4.close()     // Catch:{ IOException -> 0x013f }
        L_0x013b:
            throw r0
        L_0x013c:
            r0 = move-exception
            goto L_0x00ae
        L_0x013f:
            r1 = move-exception
            goto L_0x013b
        L_0x0141:
            r0 = move-exception
            goto L_0x0136
        L_0x0143:
            r0 = move-exception
            r4 = r1
            goto L_0x0136
        L_0x0146:
            r0 = move-exception
            goto L_0x0127
        L_0x0148:
            r0 = move-exception
            r1 = r3
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.StorageUtils.getStorageList():java.util.List");
    }

    public static long getAvailableBytes(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }
}
