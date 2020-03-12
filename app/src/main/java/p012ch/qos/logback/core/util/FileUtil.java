package p012ch.qos.logback.core.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.util.FileUtil */
public class FileUtil extends ContextAwareBase {
    static final int BUF_SIZE = 32768;

    public FileUtil(Context context) {
        setContext(context);
    }

    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unexpected exception on file [" + file + "]", e);
        }
    }

    public static boolean isParentDirectoryCreationRequired(File file) {
        File parentFile = file.getParentFile();
        return parentFile != null && !parentFile.exists();
    }

    public static boolean createMissingParentDirectories(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IllegalStateException(file + " should not have a null parent");
        } else if (!parentFile.exists()) {
            return parentFile.mkdirs();
        } else {
            throw new IllegalStateException(file + " should not have existing parent directory");
        }
    }

    public static String prefixRelativePath(String str, String str2) {
        if (str == null || OptionHelper.isEmpty(str.trim()) || new File(str2).isAbsolute()) {
            return str2;
        }
        return new StringBuilder(String.valueOf(str)).append("/").append(str2).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[SYNTHETIC, Splitter:B:24:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A[SYNTHETIC, Splitter:B:27:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void copy(String r7, String r8) {
        /*
            r6 = this;
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0071, all -> 0x0067 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0071, all -> 0x0067 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0071, all -> 0x0067 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0071, all -> 0x0067 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0074, all -> 0x006a }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0074, all -> 0x006a }
            r0.<init>(r8)     // Catch:{ IOException -> 0x0074, all -> 0x006a }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0074, all -> 0x006a }
            r0 = 32768(0x8000, float:4.5918E-41)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x002d, all -> 0x006e }
        L_0x001a:
            int r4 = r3.read(r0)     // Catch:{ IOException -> 0x002d, all -> 0x006e }
            r5 = -1
            if (r4 != r5) goto L_0x0028
            r3.close()     // Catch:{ IOException -> 0x002d, all -> 0x006e }
            r1.close()     // Catch:{ IOException -> 0x0078 }
            return
        L_0x0028:
            r5 = 0
            r1.write(r0, r5, r4)     // Catch:{ IOException -> 0x002d, all -> 0x006e }
            goto L_0x001a
        L_0x002d:
            r0 = move-exception
            r2 = r3
        L_0x002f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Failed to copy ["
            r3.<init>(r4)     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "] to ["
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "]"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0057 }
            r6.addError(r3, r0)     // Catch:{ all -> 0x0057 }
            ch.qos.logback.core.rolling.RolloverFailure r0 = new ch.qos.logback.core.rolling.RolloverFailure     // Catch:{ all -> 0x0057 }
            r0.<init>(r3)     // Catch:{ all -> 0x0057 }
            throw r0     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r0 = move-exception
        L_0x0058:
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x0063 }
        L_0x005d:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0062:
            throw r0
        L_0x0063:
            r2 = move-exception
            goto L_0x005d
        L_0x0065:
            r1 = move-exception
            goto L_0x0062
        L_0x0067:
            r0 = move-exception
            r1 = r2
            goto L_0x0058
        L_0x006a:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x0058
        L_0x006e:
            r0 = move-exception
            r2 = r3
            goto L_0x0058
        L_0x0071:
            r0 = move-exception
            r1 = r2
            goto L_0x002f
        L_0x0074:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x002f
        L_0x0078:
            r0 = move-exception
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.core.util.FileUtil.copy(java.lang.String, java.lang.String):void");
    }
}
