package p012ch.qos.logback.core.util;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: ch.qos.logback.core.util.LocationUtil */
public class LocationUtil {
    public static final String CLASSPATH_SCHEME = "classpath:";
    public static final String SCHEME_PATTERN = "^\\p{Alpha}[\\p{Alnum}+.-]*:.*$";

    public static URL urlForResource(String str) {
        URL url;
        if (str == null) {
            throw new NullPointerException("location is required");
        }
        if (!str.matches(SCHEME_PATTERN)) {
            url = Loader.getResourceBySelfClassLoader(str);
        } else if (str.startsWith(CLASSPATH_SCHEME)) {
            String substring = str.substring(10);
            if (substring.startsWith("/")) {
                substring = substring.substring(1);
            }
            if (substring.length() == 0) {
                throw new MalformedURLException("path is required");
            }
            url = Loader.getResourceBySelfClassLoader(substring);
        } else {
            url = new URL(str);
        }
        if (url != null) {
            return url;
        }
        throw new FileNotFoundException(str);
    }
}
