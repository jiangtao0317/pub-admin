package com.fanle.moka.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static final String DF_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String DF_yyMMddHHmmss = "yyMMddHHmmss";
    public static final String DF_yyyyMMdd = "yyyyMMdd";
    public static final String DF_yyMMdd = "yyMMdd";
    public static final String DF_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String DF_yy_MM_dd_HHmmss = "yy-MM-dd HH:mm:ss";
    public static final String DF_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String DF_yy_MM_dd = "yy-MM-dd";
    public static final String DF_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DF_DEFAULT_DAY = "yyyy-MM-dd";
    public static final String DF_DEFAULT_GMT = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final DateFormat UNSAFE_DF_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final DateFormat UNSAFE_DF_yyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss");
    public static final DateFormat UNSAFE_DF_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static final DateFormat UNSAFE_DF_yyMMdd = new SimpleDateFormat("yyMMdd");
    public static final DateFormat UNSAFE_DF_yyyy_MM_dd_HHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateFormat UNSAFE_DF_yy_MM_dd_HHmmss = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    public static final DateFormat UNSAFE_DF_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat UNSAFE_DF_yy_MM_dd = new SimpleDateFormat("yy-MM-dd");
    public static final SimpleDateFormat HH = new SimpleDateFormat("HH");
    public static final SimpleDateFormat milSecDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static final int DEFAULT_COMPARE_YEAR = 1986;
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date now() {
        return new Date();
    }

    public DateUtil() {
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public static String dateDir(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        return year+ StringUtils.leftPad(month+"",2,"0");
    }

    public static Integer getAllSeconds(){
        return Integer.valueOf(now().getTime()/1000+"");
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    public static ThreadLocal<DateFormat> makeDateFormatPerThread(final String pattern, final Locale locale, final boolean lenient, final TimeZone zone) {
        return new ThreadLocal<DateFormat>() {
            @Override
            protected synchronized DateFormat initialValue() {
                try {
                    DateFormat df = locale == null ? new SimpleDateFormat(pattern) : new SimpleDateFormat(pattern, locale);
                    df.setLenient(lenient);
                    if (zone != null) {
                        df.setTimeZone(zone);
                    }
                    return df;
                } catch (Exception var2) {
                    return null;
                }
            }
        };
    }

    public static ThreadLocal<DateFormat> makeDateFormatPerThread(String pattern) {
        return makeDateFormatPerThread(pattern, (Locale) null, true, (TimeZone) null);
    }

    public static String toString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date.getTime());
        } else {
            return null;
        }
    }

    public static String toString(Date date) {
        return toString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toString(Calendar calendar, String format) {
        if (calendar != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(calendar.getTime());
        } else {
            return null;
        }
    }

    public static String toString(Calendar calendar) {
        return toString(calendar, "yyyy-MM-dd HH:mm:ss");
    }

    public static String currentString(String format) {
        Calendar calendar = Calendar.getInstance();
        return toString(calendar, format);
    }

    public static String currentString() {
        return currentString("yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(String date, String format) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            try {
                return dateFormat.parse(date);
            } catch (ParseException var4) {
                throw new IllegalStateException("format error.", var4.getCause());
            }
        } else {
            return null;
        }
    }

    public static Date toDate(String date) {
        return toDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Calendar toCalendar(String calendar, String format) {
        if (calendar != null) {
            Date date = toDate(calendar, format);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return instance;
        } else {
            return null;
        }
    }

    public static Calendar toCalendar(String calendar) {
        return toCalendar(calendar, "yyyy-MM-dd HH:mm:ss");
    }

    public static String nextDay(String day, String format) {
        if (day != null) {
            Date date = toDate(day, format);
            date.setDate(date.getDate() + 1);
            return toString(date, format);
        } else {
            return null;
        }
    }

    public static String nextDay(String day) {
        return nextDay(day, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatTime(long time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time / 3600000L).append(":");
        time %= 3600000L;
        sb.append(time / 60000L).append(":");
        time %= 60000L;
        sb.append(time / 1000L).append(" ").append(time % 1000L);
        return sb.toString();
    }

    public static String[] daterange(String startDate, String endDate) {
        List<String> dates = new ArrayList<String>();

        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(toDate(startDate, "yyyy-MM-dd"));
        dates.add(toString(calBegin.getTime(), "yyyy-MM-dd"));

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(toDate(endDate, "yyyy-MM-dd"));
        while (toDate(endDate, "yyyy-MM-dd").after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(toString(calBegin.getTime(), "yyyy-MM-dd"));
        }
        return dates.toArray(new String[dates.size()]);
    }

    public static void main(String[] args) {
        String[] daterange = daterange("2018-07-25", "2018-07-27");
        System.out.println(Arrays.toString(daterange));
    }
}
