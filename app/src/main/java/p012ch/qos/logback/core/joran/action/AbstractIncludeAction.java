package p012ch.qos.logback.core.joran.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.JoranException;
import p012ch.qos.logback.core.util.Loader;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.AbstractIncludeAction */
public abstract class AbstractIncludeAction extends Action {
    private static final String FILE_ATTR = "file";
    private static final String OPTIONAL_ATTR = "optional";
    private static final String RESOURCE_ATTR = "resource";
    private static final String URL_ATTR = "url";
    private String attributeInUse;
    private boolean optional;
    private URL urlInUse;

    public abstract void processInclude(InterpretationContext interpretationContext, URL url);

    public URL getUrl() {
        return this.urlInUse;
    }

    public void handleError(String str, Exception exc) {
        addError(str, exc);
    }

    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.attributeInUse = null;
        this.optional = OptionHelper.toBoolean(attributes.getValue(OPTIONAL_ATTR), false);
        if (checkAttributes(attributes)) {
            try {
                URL inputURL = getInputURL(interpretationContext, attributes);
                if (inputURL != null) {
                    processInclude(interpretationContext, inputURL);
                }
            } catch (JoranException e) {
                handleError("Error while parsing " + this.attributeInUse, e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private boolean checkAttributes(Attributes attributes) {
        int i;
        String value = attributes.getValue("file");
        String value2 = attributes.getValue(URL_ATTR);
        String value3 = attributes.getValue(RESOURCE_ATTR);
        if (!OptionHelper.isEmpty(value)) {
            i = 1;
        } else {
            i = 0;
        }
        if (!OptionHelper.isEmpty(value2)) {
            i++;
        }
        if (!OptionHelper.isEmpty(value3)) {
            i++;
        }
        if (i == 0) {
            handleError(String.format("One of \"%1$s\", \"%2$s\" or \"%3$s\" attributes must be set.", new Object[]{"file", RESOURCE_ATTR, URL_ATTR}), null);
            return false;
        } else if (i > 1) {
            handleError(String.format("Only one of \"%1$s\", \"%2$s\" or \"%3$s\" attributes should be set.", new Object[]{"file", RESOURCE_ATTR, URL_ATTR}), null);
            return false;
        } else if (i == 1) {
            return true;
        } else {
            throw new IllegalStateException("Count value [" + i + "] is not expected");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private URL attributeToURL(String r4) {
        /*
            r3 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x000d, IOException -> 0x002c }
            r0.<init>(r4)     // Catch:{ MalformedURLException -> 0x000d, IOException -> 0x002c }
            java.io.InputStream r1 = r0.openStream()     // Catch:{ MalformedURLException -> 0x000d, IOException -> 0x002c }
            r1.close()     // Catch:{ MalformedURLException -> 0x000d, IOException -> 0x002c }
        L_0x000c:
            return r0
        L_0x000d:
            r0 = move-exception
            boolean r1 = r3.optional
            if (r1 != 0) goto L_0x002a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "URL ["
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r2 = "] is not well formed."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r3.handleError(r1, r0)
        L_0x002a:
            r0 = 0
            goto L_0x000c
        L_0x002c:
            r0 = move-exception
            boolean r1 = r3.optional
            if (r1 != 0) goto L_0x002a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "URL ["
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r2 = "] cannot be opened."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r3.handleError(r1, r0)
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.core.joran.action.AbstractIncludeAction.attributeToURL(java.lang.String):java.net.URL");
    }

    private URL resourceAsURL(String str) {
        URL resourceBySelfClassLoader = Loader.getResourceBySelfClassLoader(str);
        if (resourceBySelfClassLoader != null) {
            return resourceBySelfClassLoader;
        }
        if (this.optional) {
            return null;
        }
        handleError("Could not find resource corresponding to [" + str + "]", null);
        return null;
    }

    private URL filePathAsURL(String str) {
        URL url = null;
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                return file.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return url;
            }
        } else if (this.optional) {
            return url;
        } else {
            handleError("File does not exist [" + str + "]", new FileNotFoundException(str));
            return url;
        }
    }

    /* access modifiers changed from: protected */
    public String getAttributeInUse() {
        return this.attributeInUse;
    }

    /* access modifiers changed from: protected */
    public boolean isOptional() {
        return this.optional;
    }

    private URL getInputURL(InterpretationContext interpretationContext, Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue(URL_ATTR);
        String value3 = attributes.getValue(RESOURCE_ATTR);
        if (!OptionHelper.isEmpty(value)) {
            this.attributeInUse = interpretationContext.subst(value);
            return filePathAsURL(this.attributeInUse);
        } else if (!OptionHelper.isEmpty(value2)) {
            this.attributeInUse = interpretationContext.subst(value2);
            return attributeToURL(this.attributeInUse);
        } else if (!OptionHelper.isEmpty(value3)) {
            this.attributeInUse = interpretationContext.subst(value3);
            return resourceAsURL(this.attributeInUse);
        } else {
            throw new IllegalStateException("A URL stream should have been returned");
        }
    }

    public void end(InterpretationContext interpretationContext, String str) {
    }
}
