package p012ch.qos.logback.core.util;

import com.baicizhan.client.wordtesting.doc.DocDBHelper;

/* renamed from: ch.qos.logback.core.util.ContentTypeUtil */
public class ContentTypeUtil {
    public static boolean isTextual(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(DocDBHelper.COL_TEXT);
    }

    public static String getSubType(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            return null;
        }
        int i = indexOf + 1;
        if (i < str.length()) {
            return str.substring(i);
        }
        return null;
    }
}
