package p012ch.qos.logback.core.rolling.helper;

import com.baicizhan.client.business.util.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.helper.RollingCalendar */
public class RollingCalendar extends GregorianCalendar {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType = null;
    static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private static final long serialVersionUID = -5937537740925066161L;
    PeriodicityType periodicityType = PeriodicityType.ERRONEOUS;

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType;
        if (iArr == null) {
            iArr = new int[PeriodicityType.values().length];
            try {
                iArr[PeriodicityType.ERRONEOUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PeriodicityType.HALF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_HOUR.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_MILLISECOND.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_MINUTE.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_MONTH.ordinal()] = 9;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[PeriodicityType.TOP_OF_WEEK.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType = iArr;
        }
        return iArr;
    }

    public RollingCalendar() {
    }

    public RollingCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
    }

    public void init(String str) {
        this.periodicityType = computePeriodicityType(str);
    }

    private void setPeriodicityType(PeriodicityType periodicityType2) {
        this.periodicityType = periodicityType2;
    }

    public PeriodicityType getPeriodicityType() {
        return this.periodicityType;
    }

    public long getNextTriggeringMillis(Date date) {
        return getNextTriggeringDate(date).getTime();
    }

    public PeriodicityType computePeriodicityType(String str) {
        PeriodicityType[] periodicityTypeArr;
        RollingCalendar rollingCalendar = new RollingCalendar(GMT_TIMEZONE, Locale.getDefault());
        Date date = new Date(0);
        if (str != null) {
            for (PeriodicityType periodicityType2 : PeriodicityType.VALID_ORDERED_LIST) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                simpleDateFormat.setTimeZone(GMT_TIMEZONE);
                String format = simpleDateFormat.format(date);
                rollingCalendar.setPeriodicityType(periodicityType2);
                String format2 = simpleDateFormat.format(new Date(rollingCalendar.getNextTriggeringMillis(date)));
                if (format != null && format2 != null && !format.equals(format2)) {
                    return periodicityType2;
                }
            }
        }
        return PeriodicityType.ERRONEOUS;
    }

    public void printPeriodicity(ContextAwareBase contextAwareBase) {
        switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType()[this.periodicityType.ordinal()]) {
            case 2:
                contextAwareBase.addInfo("Roll-over every millisecond.");
                return;
            case 3:
                contextAwareBase.addInfo("Roll-over every second.");
                return;
            case 4:
                contextAwareBase.addInfo("Roll-over every minute.");
                return;
            case 5:
                contextAwareBase.addInfo("Roll-over at the top of every hour.");
                return;
            case 6:
                contextAwareBase.addInfo("Roll-over at midday and midnight.");
                return;
            case 7:
                contextAwareBase.addInfo("Roll-over at midnight.");
                return;
            case 8:
                contextAwareBase.addInfo("Rollover at the start of week.");
                return;
            case 9:
                contextAwareBase.addInfo("Rollover at start of every month.");
                return;
            default:
                contextAwareBase.addInfo("Unknown periodicity.");
                return;
        }
    }

    public long periodsElapsed(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("Start cannot come before end");
        }
        long j3 = j2 - j;
        switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType()[this.periodicityType.ordinal()]) {
            case 2:
                return j3;
            case 3:
                return j3 / 1000;
            case 4:
                return j3 / 60000;
            case 5:
                return (long) (((int) j3) / CoreConstants.MILLIS_IN_ONE_HOUR);
            case 7:
                return j3 / TimeUtil.DAY_MILLIS;
            case 8:
                return j3 / 604800000;
            case 9:
                return (long) diffInMonths(j, j2);
            default:
                throw new IllegalStateException("Unknown periodicity type.");
        }
    }

    public static int diffInMonths(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("startTime cannot be larger than endTime");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance2.get(2) - instance.get(2)) + ((instance2.get(1) - instance.get(1)) * 12);
    }

    public Date getRelativeDate(Date date, int i) {
        setTime(date);
        switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$PeriodicityType()[this.periodicityType.ordinal()]) {
            case 2:
                add(14, i);
                break;
            case 3:
                set(14, 0);
                add(13, i);
                break;
            case 4:
                set(13, 0);
                set(14, 0);
                add(12, i);
                break;
            case 5:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, i);
                break;
            case 7:
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(5, i);
                break;
            case 8:
                set(7, getFirstDayOfWeek());
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(3, i);
                break;
            case 9:
                set(5, 1);
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(2, i);
                break;
            default:
                throw new IllegalStateException("Unknown periodicity type.");
        }
        return getTime();
    }

    public Date getNextTriggeringDate(Date date) {
        return getRelativeDate(date, 1);
    }
}
