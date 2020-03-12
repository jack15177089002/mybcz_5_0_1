package com.baicizhan.client.framework.util;

import android.annotation.SuppressLint;
import android.graphics.Color;
import com.baicizhan.client.business.util.TimeUtil;
//import com.p052e.p053a.p054a.JceStruct;
//import com.tencent.android.tpush.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"SimpleDateFormat"})
public class StringHelper {
    private static SimpleDateFormat FORMATE_DATE_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat FORMATE_DATE_DAY = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat FORMATE_DATE_DAY_NO_YEAR = new SimpleDateFormat("MM-dd");
    private static SimpleDateFormat FORMATE_DATE_MOUTH = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat FORMATE_DATE_MOUTH_TIME = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat FORMATE_DATE_TIME = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat FORMATE_DATE_YEAR = new SimpleDateFormat("yyyy年");
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static final char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String getDateStringMdHm(Date date) {
        String format;
        synchronized (FORMATE_DATE_MOUTH_TIME) {
            format = FORMATE_DATE_MOUTH_TIME.format(date);
        }
        return format;
    }

    public static String getDateStringHm(Date date) {
        String format;
        synchronized (FORMATE_DATE_TIME) {
            format = FORMATE_DATE_TIME.format(date);
        }
        return format;
    }

    public static String getDateStringYear(Date date) {
        String format;
        synchronized (FORMATE_DATE_YEAR) {
            format = FORMATE_DATE_YEAR.format(date);
        }
        return format;
    }

    public static String getDateStringMouth(Date date) {
        String format;
        synchronized (FORMATE_DATE_MOUTH) {
            format = FORMATE_DATE_MOUTH.format(date);
        }
        return format;
    }

    public static String getDateStringDay(Date date) {
        String format;
        synchronized (FORMATE_DATE_DAY) {
            format = FORMATE_DATE_DAY.format(date);
        }
        return format;
    }

    public static String getTimeString(long j) {
        String format;
        Date date = new Date(j);
        synchronized (FORMATE_DATE_ALL) {
            format = FORMATE_DATE_ALL.format(date);
        }
        return format;
    }

    public static String getCurrentString() {
        String format;
        Date date = new Date();
        synchronized (FORMATE_DATE_ALL) {
            format = FORMATE_DATE_ALL.format(date);
        }
        return format;
    }

    private static String getHourShow(int i) {
        String valueOf;
        String str;
        if (i < 10) {
            valueOf = "0" + i;
        } else {
            valueOf = String.valueOf(i);
        }
        if (i >= 0 && i < 6) {
            str = "凌晨";
        } else if (i >= 6 && i < 9) {
            str = "早晨";
        } else if (i >= 9 && i < 12) {
            str = "上午";
        } else if (i >= 12 && i < 14) {
            str = "中午";
        } else if (i >= 14 && i < 18) {
            str = "下午";
        } else if (i < 18 || i >= 24) {
            str = "";
        } else {
            str = "晚上";
        }
        return str + valueOf;
    }

    private static String getMinuteShow(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    private static String getWeekShow(int i) {
        switch (i) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return "";
        }
    }

    public static String getMicroMsgTime(long j, long j2) {
        if (j2 == 0) {
            j2 = System.currentTimeMillis() / 1000;
        }
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTimeInMillis(1000 * j);
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(3);
        int i7 = instance.get(7);
        instance.setTimeInMillis(1000 * j2);
        int i8 = instance.get(1);
        int i9 = instance.get(2) + 1;
        int i10 = instance.get(5);
        int i11 = instance.get(3);
        String hourShow = getHourShow(i4);
        String minuteShow = getMinuteShow(i5);
        if (j > j2) {
            if (i3 == i10) {
                return hourShow + ":" + minuteShow;
            }
            return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
        } else if (i < i8) {
            return i + "年" + i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
        } else {
            if (i2 < i9) {
                return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            }
            if (i3 >= i10) {
                return hourShow + ":" + minuteShow;
            }
            if (i6 < i11) {
                return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            }
            return getWeekShow(i7) + " " + hourShow + ":" + minuteShow;
        }
    }

    public static String GetTimeString(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        if (getYear(instance) != getYear(calendar)) {
            return getDateStringYear(calendar.getTime());
        }
        if (getMonth(instance) == getMonth(calendar) && getDate(instance) == getDate(calendar)) {
            return getDateStringHm(calendar.getTime());
        }
        return getDateStringMouth(calendar.getTime());
    }

    public static String GetTimeString2(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        if (getMonth(instance) == getMonth(calendar) && getDate(instance) == getDate(calendar)) {
            return getDateStringHm(calendar.getTime());
        }
        return getDateStringDay(calendar.getTime());
    }

    public static String getTimeString3(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        String timeStringWithinMonth = getTimeStringWithinMonth(calendar);
        return timeStringWithinMonth == null ? getDateStringDay(calendar.getTime()) : timeStringWithinMonth;
    }

    public static String getTimeStringNoYear(Calendar calendar) {
        String format;
        if (calendar == null) {
            return "";
        }
        String timeStringWithinMonth = getTimeStringWithinMonth(calendar);
        if (timeStringWithinMonth != null) {
            return timeStringWithinMonth;
        }
        synchronized (FORMATE_DATE_DAY_NO_YEAR) {
            format = FORMATE_DATE_DAY_NO_YEAR.format(calendar);
        }
        return format;
    }

    public static String getTimeStringWithinMonth(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        int day = getDay(instance) - getDay(calendar);
        long time = instance.getTime().getTime() - calendar.getTime().getTime();
        if (time < 30000) {
            return "刚刚";
        }
        if (time < 60000) {
            return "半分钟前";
        }
        if (time < TimeUtil.HOUR_MILLIS) {
            return String.valueOf((time * 60) / TimeUtil.HOUR_MILLIS) + "分钟前";
        }
        if (time < TimeUtil.DAY_MILLIS) {
            if (day == 0) {
                return getDateStringHm(calendar.getTime());
            }
            return "1天前";
        } else if (time < 2678400000L) {
            return String.valueOf((time * 31) / 2678400000L) + "天前";
        } else {
            if (time < 2764800000L) {
                return "1个月前";
            }
            return null;
        }
    }

    private static final int getYear(Calendar calendar) {
        return calendar.get(1) - 1900;
    }

    private static final int getMonth(Calendar calendar) {
        return calendar.get(2);
    }

    private static final int getDay(Calendar calendar) {
        return calendar.get(7);
    }

    private static final int getDate(Calendar calendar) {
        return calendar.get(5);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String ToMd5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    inputStream.close();
                    return toHexString(instance.digest());
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String ToMd5(String str) {
        boolean z = false;
        try {
            return ToMd5((InputStream) new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e) {
//            return z;
        }
        //test
        return "";
    }

    public static boolean ContentChinese(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isChinese(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChinese(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean isAccount(String str) {
        if (!Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches()) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (String.valueOf(str.charAt(i2)).getBytes().length == 1) {
                i++;
            } else {
                i += 2;
            }
        }
        if (i <= 0 || i > 14) {
            return false;
        }
        return true;
    }

    public static boolean isPassword(String str) {
        int length = str.length();
        if (length < 6 || length > 14 || str.getBytes().length > length) {
            return false;
        }
        return true;
    }

    public static boolean isForumName(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isMobileNo(String str) {
        return Pattern.compile("1\\d{10}").matcher(str).matches();
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || str.equals("null")) {
            return true;
        }
        return false;
    }

    public static String getUrlEncode(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getUrlDecode(String str) {
        boolean z = false;
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
//            return z;
        }

        return null;
    }

    public static int byteLength(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Integer.toHexString(str.charAt(i2)).length() == 4) {
                i += 2;
            } else {
                i++;
            }
        }
        return i;
    }

    public static String cutString(String str, int i) {
        if (str == null || i <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (isChinese(str.charAt(i2))) {
                i3 += 2;
            } else {
                i3++;
            }
            if (i3 >= i) {
                break;
            }
            i2++;
        }
        if (i2 < length) {
            return str.substring(0, i2 + 1) + "...";
        }
        return str;
    }

    public static String base64Encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
//            byte b = bArr[i] & Constants.NETWORK_TYPE_UNCONNECTED;
//            if (i2 == length) {
//                stringBuffer.append(base64EncodeChars[b >>> 2]);
//                stringBuffer.append(base64EncodeChars[(b & 3) << 4]);
//                stringBuffer.append("==");
//                break;
//            }
//            int i3 = i2 + 1;
//            byte b2 = bArr[i2] & Constants.NETWORK_TYPE_UNCONNECTED;
//            if (i3 == length) {
//                stringBuffer.append(base64EncodeChars[b >>> 2]);
//                stringBuffer.append(base64EncodeChars[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
//                stringBuffer.append(base64EncodeChars[(b2 & 15) << 2]);
//                stringBuffer.append("=");
//                break;
//            }
//            i = i3 + 1;
//            byte b3 = bArr[i3] & Constants.NETWORK_TYPE_UNCONNECTED;
//            stringBuffer.append(base64EncodeChars[b >>> 2]);
//            stringBuffer.append(base64EncodeChars[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
//            stringBuffer.append(base64EncodeChars[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
//            stringBuffer.append(base64EncodeChars[b3 & 63]);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[LOOP:0: B:1:0x000e->B:26:0x006c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075 A[EDGE_INSN: B:32:0x0075->B:27:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075 A[EDGE_INSN: B:35:0x0075->B:27:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075 A[EDGE_INSN: B:36:0x0075->B:27:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075 A[EDGE_INSN: B:37:0x0075->B:27:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e A[LOOP:2: B:6:0x001e->B:30:0x007e, LOOP_START, PHI: r1 
  PHI: (r1v1 int) = (r1v0 int), (r1v11 int) binds: [B:5:0x001c, B:30:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] base64Decode(String r9) {
        /*
            r8 = 61
            r7 = -1
            byte[] r2 = r9.getBytes()
            int r3 = r2.length
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>(r3)
            r0 = 0
        L_0x000e:
            if (r0 >= r3) goto L_0x0075
        L_0x0010:
            byte[] r5 = base64DecodeChars
            int r1 = r0 + 1
            byte r0 = r2[r0]
            byte r5 = r5[r0]
            if (r1 >= r3) goto L_0x001c
            if (r5 == r7) goto L_0x0080
        L_0x001c:
            if (r5 == r7) goto L_0x0075
        L_0x001e:
            byte[] r6 = base64DecodeChars
            int r0 = r1 + 1
            byte r1 = r2[r1]
            byte r6 = r6[r1]
            if (r0 >= r3) goto L_0x002a
            if (r6 == r7) goto L_0x007e
        L_0x002a:
            if (r6 == r7) goto L_0x0075
            int r1 = r5 << 2
            r5 = r6 & 48
            int r5 = r5 >>> 4
            r1 = r1 | r5
            r4.write(r1)
        L_0x0036:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            if (r0 != r8) goto L_0x0041
            byte[] r0 = r4.toByteArray()
        L_0x0040:
            return r0
        L_0x0041:
            byte[] r5 = base64DecodeChars
            byte r5 = r5[r0]
            if (r1 >= r3) goto L_0x0049
            if (r5 == r7) goto L_0x007c
        L_0x0049:
            if (r5 == r7) goto L_0x0075
            r0 = r6 & 15
            int r0 = r0 << 4
            r6 = r5 & 60
            int r6 = r6 >>> 2
            r0 = r0 | r6
            r4.write(r0)
        L_0x0057:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            if (r1 != r8) goto L_0x0062
            byte[] r0 = r4.toByteArray()
            goto L_0x0040
        L_0x0062:
            byte[] r6 = base64DecodeChars
            byte r1 = r6[r1]
            if (r0 >= r3) goto L_0x006a
            if (r1 == r7) goto L_0x007a
        L_0x006a:
            if (r1 == r7) goto L_0x0075
            r5 = r5 & 3
            int r5 = r5 << 6
            r1 = r1 | r5
            r4.write(r1)
            goto L_0x000e
        L_0x0075:
            byte[] r0 = r4.toByteArray()
            goto L_0x0040
        L_0x007a:
            r1 = r0
            goto L_0x0057
        L_0x007c:
            r0 = r1
            goto L_0x0036
        L_0x007e:
            r1 = r0
            goto L_0x001e
        L_0x0080:
            r0 = r1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.util.StringHelper.base64Decode(java.lang.String):byte[]");
    }

    public static String getNameFromUrl(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return str;
            }
            if (lastIndexOf < lastIndexOf2) {
                return str.substring(lastIndexOf, lastIndexOf2);
            }
            return str.substring(lastIndexOf);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getNameMd5FromUrl(String str) {
        return ToMd5(str);
    }

    public static String getHighLightString(String str, Color color) {
        if (str == null) {
            return "";
        }
        boolean z = false;
        try {
            return str.replaceAll("<em>", "<font color='#007bd1'>").replaceAll("</em>", "</font>");
        } catch (Exception e) {
//            return z;
        }

        return null;
    }

    private static long[] parseVersion(String str) {
        long[] jArr = new long[3];
        if (str != null) {
            String[] split = str.replace(".", "#").split("#");
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
        }
        return jArr;
    }

    public static int compareVersion(String str, String str2) {
        long j = 0;
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        long[] parseVersion = parseVersion(str);
        long[] parseVersion2 = parseVersion(str2);
        long j2 = 0;
        for (int i = 0; i < 3; i++) {
            j2 += parseVersion[i] << (24 - (i * 8));
        }
        for (int i2 = 0; i2 < 3; i2++) {
            j += parseVersion2[i2] << (24 - (i2 * 8));
        }
        if (j2 > j) {
            return 1;
        }
        if (j2 == j) {
            return 0;
        }
        return -1;
    }

    public static String StringFilter(String str) {
        return Pattern.compile("[/\\:*?<>|\"\n\t]").matcher(str).replaceAll("").trim();
    }

    public static String join(List<Object> list, String str) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            if (list.get(i) != null) {
                stringBuffer.append(list.get(i).toString());
            }
        }
        return stringBuffer.toString();
    }
}
