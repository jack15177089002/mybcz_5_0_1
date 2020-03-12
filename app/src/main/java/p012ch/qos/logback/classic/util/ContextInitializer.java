package p012ch.qos.logback.classic.util;

import java.io.InputStream;
import java.net.URL;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.classic.joran.JoranConfigurator;
import p012ch.qos.logback.core.android.CommonPathUtil;
import p012ch.qos.logback.core.status.InfoStatus;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.util.Loader;

/* renamed from: ch.qos.logback.classic.util.ContextInitializer */
public class ContextInitializer {
    private static final String ASSETS_DIR = CommonPathUtil.getAssetsDirectoryPath();
    public static final String AUTOCONFIG_FILE = "logback.xml";
    public static final String CONFIG_FILE_PROPERTY = "logback.configurationFile";
    public static final String STATUS_LISTENER_CLASS = "logback.statusListenerClass";
    final ClassLoader classLoader = Loader.getClassLoaderOfObject(this);
    final LoggerContext loggerContext;

    public ContextInitializer(LoggerContext loggerContext2) {
        this.loggerContext = loggerContext2;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.net.URL] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.URL] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0, types: [java.net.URL]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String]
  uses: [?[OBJECT, ARRAY], ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.URL, java.lang.String]
  mth insns count: 52
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private URL findConfigFileFromSystemProperties(boolean r5) {
        /*
            r4 = this;
            r1 = 0
            java.lang.String r0 = "logback.configurationFile"
            java.lang.String r2 = p012ch.qos.logback.core.util.OptionHelper.getSystemProperty(r0)
            if (r2 == 0) goto L_0x0061
            java.io.File r0 = new java.io.File     // Catch:{ MalformedURLException -> 0x003d }
            r0.<init>(r2)     // Catch:{ MalformedURLException -> 0x003d }
            boolean r3 = r0.exists()     // Catch:{ MalformedURLException -> 0x003d }
            if (r3 == 0) goto L_0x0037
            boolean r3 = r0.isFile()     // Catch:{ MalformedURLException -> 0x003d }
            if (r3 == 0) goto L_0x0037
            if (r5 == 0) goto L_0x0021
            java.lang.ClassLoader r3 = r4.classLoader     // Catch:{ MalformedURLException -> 0x003d }
            r4.statusOnResourceSearch(r2, r3, r2)     // Catch:{ MalformedURLException -> 0x003d }
        L_0x0021:
            java.net.URI r0 = r0.toURI()     // Catch:{ MalformedURLException -> 0x003d }
            java.net.URL r0 = r0.toURL()     // Catch:{ MalformedURLException -> 0x003d }
        L_0x0029:
            if (r5 == 0) goto L_0x0036
            java.lang.ClassLoader r3 = r4.classLoader
            if (r0 == 0) goto L_0x0033
            java.lang.String r1 = r0.toString()
        L_0x0033:
            r4.statusOnResourceSearch(r2, r3, r1)
        L_0x0036:
            return r0
        L_0x0037:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x003d }
            r0.<init>(r2)     // Catch:{ MalformedURLException -> 0x003d }
            goto L_0x0029
        L_0x003d:
            r0 = move-exception
            java.lang.ClassLoader r0 = r4.classLoader     // Catch:{ all -> 0x0065 }
            java.net.URL r0 = p012ch.qos.logback.core.util.Loader.getResource(r2, r0)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0054
            if (r5 == 0) goto L_0x0036
            java.lang.ClassLoader r3 = r4.classLoader
            if (r0 == 0) goto L_0x0050
            java.lang.String r1 = r0.toString()
        L_0x0050:
            r4.statusOnResourceSearch(r2, r3, r1)
            goto L_0x0036
        L_0x0054:
            if (r5 == 0) goto L_0x0061
            java.lang.ClassLoader r3 = r4.classLoader
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = r0.toString()
        L_0x005e:
            r4.statusOnResourceSearch(r2, r3, r0)
        L_0x0061:
            r0 = r1
            goto L_0x0036
        L_0x0063:
            r0 = r1
            goto L_0x005e
        L_0x0065:
            r0 = move-exception
            if (r5 == 0) goto L_0x0073
            java.lang.ClassLoader r3 = r4.classLoader
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = r1.toString()
        L_0x0070:
            r4.statusOnResourceSearch(r2, r3, r1)
        L_0x0073:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.classic.util.ContextInitializer.findConfigFileFromSystemProperties(boolean):java.net.URL");
    }

    private InputStream findConfigFileURLFromAssets(boolean z) {
        return getResource(ASSETS_DIR + "/logback.xml", this.classLoader, z);
    }

    private InputStream getResource(String str, ClassLoader classLoader2, boolean z) {
        InputStream resourceAsStream = classLoader2.getResourceAsStream(str);
        if (z) {
            String str2 = null;
            if (resourceAsStream != null) {
                str2 = str;
            }
            statusOnResourceSearch(str, classLoader2, str2);
        }
        return resourceAsStream;
    }

    public void autoConfig() {
        StatusListenerConfigHelper.installIfAsked(this.loggerContext);
        boolean z = false;
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(this.loggerContext);
        URL findConfigFileFromSystemProperties = findConfigFileFromSystemProperties(true);
        if (findConfigFileFromSystemProperties != null) {
            joranConfigurator.doConfigure(findConfigFileFromSystemProperties);
            z = true;
        }
        if (!z) {
            InputStream findConfigFileURLFromAssets = findConfigFileURLFromAssets(true);
            if (findConfigFileURLFromAssets != null) {
                joranConfigurator.doConfigure(findConfigFileURLFromAssets);
            }
        }
    }

    private void statusOnResourceSearch(String str, ClassLoader classLoader2, String str2) {
        StatusManager statusManager = this.loggerContext.getStatusManager();
        if (str2 == null) {
            statusManager.add((Status) new InfoStatus("Could NOT find resource [" + str + "]", this.loggerContext));
        } else {
            statusManager.add((Status) new InfoStatus("Found resource [" + str + "] at [" + str2 + "]", this.loggerContext));
        }
    }
}
