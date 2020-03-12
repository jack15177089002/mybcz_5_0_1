package com.baicizhan.client.business.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeUtil {
    public static final SimpleDateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
    public static final long DAY_MILLIS = 86400000;
    public static final long HOUR_MILLIS = 3600000;
    public static final long MINUTE_MILLIS = 60000;
    public static final long SECOND_MILLIS = 1000;

    public static String getTodayDateString() {
        return COMMON_DATE_FORMAT.format(Calendar.getInstance().getTime());
    }

    public static String getDateString(Date date) {
        return COMMON_DATE_FORMAT.format(date);
    }

    public static long secondsToMillis(long j) {
        return 1000 * j;
    }

    public static long currentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static long getStartOfDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static long getStartSecondOfDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 1);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static int getBetweenDays(long j, long j2) {
        return (int) (Math.abs(getStartOfDay(j) - getStartOfDay(j2)) / DAY_MILLIS);
    }

    public static long todayStart() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 1);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTime().getTime();
    }
}
