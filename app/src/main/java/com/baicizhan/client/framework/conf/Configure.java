package com.baicizhan.client.framework.conf;

import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configure {
    private static Configure sInstance = new Configure();
    private Map<String, Properties> mConfDict = new HashMap();
    private String mConfName;

    public static Configure getInstance() {
        return sInstance;
    }

    private Configure() {
        init();
    }

    private void init() {
        try {
            this.mConfName = getConfName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getConfName() {
        if (this.mConfName != null) {
            return this.mConfName;
        }
        Properties valuesFromPKG = getValuesFromPKG("config/system.conf");
        String str = "config/conf";
        if (valuesFromPKG == null) {
            return str;
        }
        String property = valuesFromPKG.getProperty("mod");
        if (property == null || "".equals(property.trim())) {
            return str;
        }
        return str + "_" + property;
    }

    private Properties getValuesFromPKG(String str) {
        URL resource = getClass().getClassLoader().getResource(str);
        if (resource == null) {
            return null;
        }
        if (!"jar".equals(resource.getProtocol())) {
            return getFromFile(resource.getPath());
        }
        String path = resource.getPath();
        int indexOf = path.indexOf("file:");
        if (indexOf < 0) {
            return null;
        }
        int i = indexOf + 5;
        int lastIndexOf = path.lastIndexOf("!");
        if (lastIndexOf < 0 || lastIndexOf >= path.length() - 1) {
            return null;
        }
        String substring = path.substring(lastIndexOf + 1);
        if (substring.startsWith("/")) {
            substring = substring.substring(1);
        }
        return getFromJarFile(path.substring(i, lastIndexOf), substring);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Properties getFromJarFile(String r4, String r5) {
        /*
            r3 = this;
            r1 = 0
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ all -> 0x0031 }
            r2.<init>(r4)     // Catch:{ all -> 0x0031 }
            java.util.jar.JarEntry r0 = r2.getJarEntry(r5)     // Catch:{ all -> 0x0022 }
            java.io.InputStream r1 = r2.getInputStream(r0)     // Catch:{ all -> 0x0022 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x0022 }
            r0.<init>()     // Catch:{ all -> 0x0022 }
            r0.load(r1)     // Catch:{ all -> 0x0022 }
            r3.convertCharset(r0)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x001e
            r1.close()     // Catch:{ all -> 0x0029 }
        L_0x001e:
            r2.close()
            return r0
        L_0x0022:
            r0 = move-exception
            if (r1 == 0) goto L_0x0028
            r1.close()     // Catch:{ all -> 0x0029 }
        L_0x0028:
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r0 = move-exception
            r1 = r2
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            throw r0
        L_0x0031:
            r0 = move-exception
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.conf.Configure.getFromJarFile(java.lang.String, java.lang.String):java.util.Properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Properties getFromFile(String r4) {
        /*
            r3 = this;
            r2 = 0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x001a }
            r0.<init>(r4)     // Catch:{ all -> 0x001a }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x001a }
            r1.<init>(r0)     // Catch:{ all -> 0x001a }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x0022 }
            r0.<init>()     // Catch:{ all -> 0x0022 }
            r0.load(r1)     // Catch:{ all -> 0x0022 }
            r3.convertCharset(r0)     // Catch:{ all -> 0x0022 }
            r1.close()
            return r0
        L_0x001a:
            r0 = move-exception
            r1 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()
        L_0x0021:
            throw r0
        L_0x0022:
            r0 = move-exception
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.conf.Configure.getFromFile(java.lang.String):java.util.Properties");
    }

    private void convertCharset(Properties properties) {
        for (String str : properties.stringPropertyNames()) {
            String property = properties.getProperty(str);
            if (property != null) {
                properties.setProperty(str, new String(property.getBytes("ISO-8859-1"), "utf-8").trim());
            }
        }
    }

    public String getValue(String str, String str2) {
        return getValue(str, str2, null);
    }

    public String getValue(String str, String str2, String str3) {
        Properties properties = (Properties) this.mConfDict.get(str);
        if (properties != null) {
            return properties.getProperty(str2, str3);
        }
        try {
            Properties valuesFromPKG = getValuesFromPKG(this.mConfName + "/" + str);
            this.mConfDict.put(str, valuesFromPKG);
            return valuesFromPKG.getProperty(str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }

    public int getIntValue(String str, String str2) {
        return getIntValue(str, str2, 0);
    }

    public int getIntValue(String str, String str2, int i) {
        String value = getValue(str, str2, String.valueOf(i));
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return i;
            }
            C0789L.log.warn(String.format("parse (%s:%s) in %s to int error", new Object[]{str2, value, str}), (Throwable) e);
            return i;
        }
    }

    public boolean getBooleanValue(String str, String str2) {
        return getBooleanValue(str, str2, false);
    }

    public boolean getBooleanValue(String str, String str2, boolean z) {
        String value = getValue(str, str2, String.valueOf(z));
        try {
            boolean parseBoolean = Boolean.parseBoolean(value);
            if (parseBoolean || value.equals("false")) {
                return parseBoolean;
            }
            throw new IllegalArgumentException("It's not a legal boolean value.");
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return z;
            }
            C0789L.log.warn(String.format("parse (%s:%s) in %s to boolean error", new Object[]{str2, value, str}), (Throwable) e);
            return z;
        }
    }

    public double getDoubleValue(String str, String str2) {
        return getDoubleValue(str, str2, 0.0d);
    }

    public double getDoubleValue(String str, String str2, double d) {
        String value = getValue(str, str2, String.valueOf(d));
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            if (!LSwitcher.isOpened()) {
                return d;
            }
            C0789L.log.warn(String.format("parse (%s:%s) in %s to double error", new Object[]{str2, value, str}), (Throwable) e);
            return d;
        }
    }
}
