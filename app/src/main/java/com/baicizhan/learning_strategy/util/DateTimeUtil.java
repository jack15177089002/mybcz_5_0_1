package com.baicizhan.learning_strategy.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        if (date.getTime() >= getStartOfTodayInMillis()) {
            return true;
        }
        return false;
    }

    public static long getStartOfTodayInMillis() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }
}
