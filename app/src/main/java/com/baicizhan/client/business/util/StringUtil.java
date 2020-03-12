package com.baicizhan.client.business.util;

import com.baicizhan.client.framework.util.Common;
import java.util.regex.Pattern;

public class StringUtil {
    private static Pattern EMAIL_ADDR_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

    public static String md5Hex(String str, boolean z) {
        String md5 = Common.md5(str);
        return z ? md5.toUpperCase() : md5;
    }

    public static String unlines(String str) {
        return str.replace("\r", "").replace("\n", "");
    }

    public static String firstLine(String str) {
//        String replace = str.trim().replace(13, 10);
//        int indexOf = replace.indexOf(10);
//        return indexOf == -1 ? replace : replace.substring(0, indexOf);
        return null;
    }

    public static boolean isValidEmailAddr(String str) {
        return EMAIL_ADDR_PATTERN.matcher(str).matches();
    }

    public static boolean isAllLetters(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
