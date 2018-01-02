package com.miui.player.util;

import android.text.TextUtils;
import android.util.Log;
import com.miui.player.meta.MetaManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.xml.sax.SAXException;

public class DateTimeHelper {
    private static final String LOG_TAG = "common/DateTimeHelper";
    static final String TAG = DateTimeHelper.class.getName();
    public static final TimeZone sBeijingTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
    public static final long sDayInMilliseconds = 86400000;
    public static final long sDayInMinutes = 1440;
    public static final long sHourInMilliseconds = 3600000;
    public static final long sHourInMinutes = 60;
    public static final long sMinuteInMilliseconds = 60000;

    public static final long getCurrentTiemstamp() {
        return Calendar.getInstance(sBeijingTimeZone).getTimeInMillis();
    }

    public static final long getTodayStartTimestamp() {
        return getTodayStartTimestamp(getCurrentTiemstamp());
    }

    public static final long getTodayStartTimestamp(long timestamp) {
        return timestamp - (timestamp % 86400000);
    }

    public static final long getTomorrowStartTimestamp(long timestamp) {
        return (timestamp - (timestamp % 86400000)) + 86400000;
    }

    public static final long getElapsedMinutesFromToday() {
        return getElapsedMinutesFromToday(getCurrentTiemstamp());
    }

    public static final long getElapsedMinutesFromToday(long timestamp) {
        return (timestamp - getTodayStartTimestamp(timestamp)) / 60000;
    }

    public static final long getElapsedMinutesFromHour() {
        return getElapsedMinutesFromHour(getCurrentTiemstamp());
    }

    public static final long getElapsedMinutesFromHour(long timestamp) {
        return getElapsedMinutesFromToday(timestamp) % 60;
    }

    public static long parseDate(String date) throws SAXException {
        long j = -1;
        if (!TextUtils.isEmpty(date)) {
            GregorianCalendar gc = new GregorianCalendar();
            try {
                gc.setTime(new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date));
                gc.setTimeZone(sBeijingTimeZone);
                j = gc.getTimeInMillis();
            } catch (ParseException e) {
                Log.e(LOG_TAG, "Failed to parse date", e);
            }
        }
        return j;
    }

    public static Date fromString(String src, String pattern) {
        Date date = null;
        if (!TextUtils.isEmpty(src)) {
            try {
                date = new SimpleDateFormat(pattern).parse(src);
            } catch (ParseException e) {
                Log.d(TAG, MetaManager.UNKNOWN_STRING, e);
            }
        }
        return date;
    }

    public static String toString(Date date, String pattern) {
        String ret = MetaManager.UNKNOWN_STRING;
        if (date != null) {
            return new SimpleDateFormat(pattern).format(date);
        }
        return ret;
    }

    public static String getCurrentString(String pattern) {
        return getTimeString(System.currentTimeMillis(), pattern);
    }

    public static String getTimeString(long time, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(time));
    }
}
