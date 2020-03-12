package p012ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.zip.ZipEntry;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.rolling.helper.Compressor */
public class Compressor extends ContextAwareBase {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode = null;
    static final int BUFFER_SIZE = 8192;
    final CompressionMode compressionMode;

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode;
        if (iArr == null) {
            iArr = new int[CompressionMode.values().length];
            try {
                iArr[CompressionMode.GZ.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CompressionMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CompressionMode.ZIP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode = iArr;
        }
        return iArr;
    }

    public Compressor(CompressionMode compressionMode2) {
        this.compressionMode = compressionMode2;
    }

    public void compress(String str, String str2, String str3) {
        switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode()[this.compressionMode.ordinal()]) {
            case 1:
                throw new UnsupportedOperationException("compress method called in NONE compression mode");
            case 2:
                gzCompress(str, str2);
                return;
            case 3:
                zipCompress(str, str2, str3);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x011c A[SYNTHETIC, Splitter:B:32:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0121 A[SYNTHETIC, Splitter:B:35:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0135 A[SYNTHETIC, Splitter:B:46:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013a A[SYNTHETIC, Splitter:B:49:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zipCompress(String r8, String r9, String r10) {
        /*
            r7 = this;
            r2 = 0
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x002a
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The file to compress named ["
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = "] does not exist."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r7)
            r7.addStatus(r0)
        L_0x0029:
            return
        L_0x002a:
            if (r10 != 0) goto L_0x0037
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus
            java.lang.String r1 = "The innerEntryName parameter cannot be null"
            r0.<init>(r1, r7)
            r7.addStatus(r0)
            goto L_0x0029
        L_0x0037:
            java.lang.String r1 = ".zip"
            boolean r1 = r9.endsWith(r1)
            if (r1 != 0) goto L_0x0052
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r9)
            r1.<init>(r3)
            java.lang.String r3 = ".zip"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r9 = r1.toString()
        L_0x0052:
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x007b
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The target compressed file named ["
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = "] exist already."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r7)
            r7.addStatus(r0)
            goto L_0x0029
        L_0x007b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "ZIP compressing ["
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "] as ["
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = "]"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.addInfo(r3)
            r7.createMissingTargetDirsIfNecessary(r1)
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x014d, all -> 0x0144 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x014d, all -> 0x0144 }
            r4.<init>(r9)     // Catch:{ Exception -> 0x014d, all -> 0x0144 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x014d, all -> 0x0144 }
            java.util.zip.ZipEntry r4 = r7.computeZipEntry(r10)     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
            r1.putNextEntry(r4)     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
        L_0x00bf:
            int r5 = r3.read(r4)     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
            r6 = -1
            if (r5 != r6) goto L_0x0129
            r3.close()     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
            r1.close()     // Catch:{ Exception -> 0x0151 }
            boolean r0 = r0.delete()     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            if (r0 != 0) goto L_0x0029
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.lang.String r3 = "Could not delete ["
            r1.<init>(r3)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.lang.String r3 = "]."
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            r0.<init>(r1, r7)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            r7.addStatus(r0)     // Catch:{ Exception -> 0x00f1, all -> 0x0131 }
            goto L_0x0029
        L_0x00f1:
            r0 = move-exception
            r1 = r2
        L_0x00f3:
            ch.qos.logback.core.status.ErrorStatus r3 = new ch.qos.logback.core.status.ErrorStatus     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            java.lang.String r5 = "Error occurred while compressing ["
            r4.<init>(r5)     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ all -> 0x014b }
            java.lang.String r5 = "] into ["
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r5 = "]."
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x014b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014b }
            r3.<init>(r4, r7, r0)     // Catch:{ all -> 0x014b }
            r7.addStatus(r3)     // Catch:{ all -> 0x014b }
            if (r2 == 0) goto L_0x011f
            r2.close()     // Catch:{ IOException -> 0x013e }
        L_0x011f:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x0029
        L_0x0126:
            r0 = move-exception
            goto L_0x0029
        L_0x0129:
            r6 = 0
            r1.write(r4, r6, r5)     // Catch:{ Exception -> 0x012e, all -> 0x0148 }
            goto L_0x00bf
        L_0x012e:
            r0 = move-exception
            r2 = r3
            goto L_0x00f3
        L_0x0131:
            r0 = move-exception
            r1 = r2
        L_0x0133:
            if (r2 == 0) goto L_0x0138
            r2.close()     // Catch:{ IOException -> 0x0140 }
        L_0x0138:
            if (r1 == 0) goto L_0x013d
            r1.close()     // Catch:{ IOException -> 0x0142 }
        L_0x013d:
            throw r0
        L_0x013e:
            r0 = move-exception
            goto L_0x011f
        L_0x0140:
            r2 = move-exception
            goto L_0x0138
        L_0x0142:
            r1 = move-exception
            goto L_0x013d
        L_0x0144:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x0133
        L_0x0148:
            r0 = move-exception
            r2 = r3
            goto L_0x0133
        L_0x014b:
            r0 = move-exception
            goto L_0x0133
        L_0x014d:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x00f3
        L_0x0151:
            r0 = move-exception
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.core.rolling.helper.Compressor.zipCompress(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: 0000 */
    public ZipEntry computeZipEntry(File file) {
        return computeZipEntry(file.getName());
    }

    /* access modifiers changed from: 0000 */
    public ZipEntry computeZipEntry(String str) {
        return new ZipEntry(computeFileNameStr_WCS(str, this.compressionMode));
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0103 A[SYNTHETIC, Splitter:B:31:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0108 A[SYNTHETIC, Splitter:B:34:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011c A[SYNTHETIC, Splitter:B:45:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0121 A[SYNTHETIC, Splitter:B:48:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gzCompress(String r8, String r9) {
        /*
            r7 = this;
            r2 = 0
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x002a
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The file to compress named ["
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = "] does not exist."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r7)
            r7.addStatus(r0)
        L_0x0029:
            return
        L_0x002a:
            java.lang.String r1 = ".gz"
            boolean r1 = r9.endsWith(r1)
            if (r1 != 0) goto L_0x0045
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r9)
            r1.<init>(r3)
            java.lang.String r3 = ".gz"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r9 = r1.toString()
        L_0x0045:
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x0069
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The target compressed file named ["
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r1 = "] exist already. Aborting file compression."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.addWarn(r0)
            goto L_0x0029
        L_0x0069:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "GZ compressing ["
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "] as ["
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = "]"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.addInfo(r3)
            r7.createMissingTargetDirsIfNecessary(r1)
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0138, all -> 0x012b }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0138, all -> 0x012b }
            r4.<init>(r9)     // Catch:{ Exception -> 0x0138, all -> 0x012b }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0138, all -> 0x012b }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0115, all -> 0x012d }
        L_0x00a6:
            int r5 = r3.read(r4)     // Catch:{ Exception -> 0x0115, all -> 0x012d }
            r6 = -1
            if (r5 != r6) goto L_0x0110
            r3.close()     // Catch:{ Exception -> 0x0115, all -> 0x012d }
            r1.close()     // Catch:{ Exception -> 0x013c, all -> 0x0130 }
            boolean r0 = r0.delete()     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            if (r0 != 0) goto L_0x0029
            ch.qos.logback.core.status.WarnStatus r0 = new ch.qos.logback.core.status.WarnStatus     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.lang.String r3 = "Could not delete ["
            r1.<init>(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.lang.String r3 = "]."
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            r0.<init>(r1, r7)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            r7.addStatus(r0)     // Catch:{ Exception -> 0x00d8, all -> 0x0118 }
            goto L_0x0029
        L_0x00d8:
            r0 = move-exception
            r1 = r2
        L_0x00da:
            ch.qos.logback.core.status.ErrorStatus r3 = new ch.qos.logback.core.status.ErrorStatus     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "Error occurred while compressing ["
            r4.<init>(r5)     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "] into ["
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "]."
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0134 }
            r3.<init>(r4, r7, r0)     // Catch:{ all -> 0x0134 }
            r7.addStatus(r3)     // Catch:{ all -> 0x0134 }
            if (r2 == 0) goto L_0x0106
            r2.close()     // Catch:{ IOException -> 0x0125 }
        L_0x0106:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0029
        L_0x010d:
            r0 = move-exception
            goto L_0x0029
        L_0x0110:
            r6 = 0
            r1.write(r4, r6, r5)     // Catch:{ Exception -> 0x0115, all -> 0x012d }
            goto L_0x00a6
        L_0x0115:
            r0 = move-exception
            r2 = r3
            goto L_0x00da
        L_0x0118:
            r0 = move-exception
            r3 = r2
        L_0x011a:
            if (r3 == 0) goto L_0x011f
            r3.close()     // Catch:{ IOException -> 0x0127 }
        L_0x011f:
            if (r2 == 0) goto L_0x0124
            r2.close()     // Catch:{ IOException -> 0x0129 }
        L_0x0124:
            throw r0
        L_0x0125:
            r0 = move-exception
            goto L_0x0106
        L_0x0127:
            r1 = move-exception
            goto L_0x011f
        L_0x0129:
            r1 = move-exception
            goto L_0x0124
        L_0x012b:
            r0 = move-exception
            goto L_0x011a
        L_0x012d:
            r0 = move-exception
            r2 = r1
            goto L_0x011a
        L_0x0130:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L_0x011a
        L_0x0134:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L_0x011a
        L_0x0138:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x00da
        L_0x013c:
            r0 = move-exception
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.core.rolling.helper.Compressor.gzCompress(java.lang.String, java.lang.String):void");
    }

    public static String computeFileNameStr_WCS(String str, CompressionMode compressionMode2) {
        int length = str.length();
        switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode()[compressionMode2.ordinal()]) {
            case 1:
                return str;
            case 2:
                if (str.endsWith(".gz")) {
                    return str.substring(0, length - 3);
                }
                return str;
            case 3:
                if (str.endsWith(".zip")) {
                    return str.substring(0, length - 4);
                }
                return str;
            default:
                throw new IllegalStateException("Execution should not reach this point");
        }
    }

    /* access modifiers changed from: 0000 */
    public void createMissingTargetDirsIfNecessary(File file) {
        if (!FileUtil.isParentDirectoryCreationRequired(file)) {
            return;
        }
        if (!FileUtil.createMissingParentDirectories(file)) {
            addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
        } else {
            addInfo("Created missing parent directories for [" + file.getAbsolutePath() + "]");
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
