package com.king.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 *
 * @author King
 * @date 2017/11/2
 */
public class DateUtil {

    /**
     * 日期类型对象转换成指定格式字符串
     *
     * @param date    时间
     * @param pattern 格式
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        return formater.format(date);
    }

    /**
     * 日期对象转换成字符串（yyyy-MM-dd）
     *
     * @param date 时间
     * @return
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date);
    }

    /**
     * 日期对象转换成字符串（yyyy-MM-dd HH:mm:ss）
     *
     * @param date 时间
     * @return
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(date);
    }

    /**
     * 按照指定的格式，将字符串转换成日期类型对象（yyyy-MM-dd、yyyy-MM-dd HH:mm:ss...）
     *
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            return formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期增加减少addSecond秒
     *
     * @param date
     * @param addSecond
     * @return
     */
    public static Date addSecond(Date date, int addSecond) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.SECOND, addSecond);
        return ca.getTime();
    }

    /**
     * 日期增加减少addMin分钟
     *
     * @param date
     * @param addMin
     * @return
     */
    public static Date addMin(Date date, int addMin) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MINUTE, addMin);
        return ca.getTime();
    }

    /**
     * 日期增加减少addHour小时
     *
     * @param date
     * @param addHour
     * @return
     */
    public static Date addHour(Date date, int addHour) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR, addHour);
        return ca.getTime();
    }

    /**
     * 日期增加减少addDay天
     *
     * @param date
     * @param addDay
     * @return
     */
    public static Date addDay(Date date, int addDay) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_WEEK, addDay);
        return ca.getTime();
    }

    /**
     * 日期增加减少addMonth月
     *
     * @param date
     * @param addMonth
     * @return
     */
    public static Date addMonth(Date date, int addMonth) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, addMonth);
        return ca.getTime();
    }

    /**
     * 计算两个日期之间相差的小时数
     *
     * @param startday
     * @param endday
     * @return
     */
    public static int getIntervalHour(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long interval = endday.getTime() - startday.getTime();
        long day = interval / (24 * 60 * 60 * 1000);
        long hour = day * 24 + (interval / (60 * 60 * 1000) - day * 24);
        return (int) hour;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startday
     * @param endday
     * @return
     */
    public static int getIntervalDays(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 设置时间为这一天的第一毫秒
     *
     * @param date
     * @return
     */
    public static Date setDateToOneDayFirstMilliSecond(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, ca.getActualMinimum(Calendar.HOUR_OF_DAY));
        ca.set(Calendar.MINUTE, ca.getActualMinimum(Calendar.MINUTE));
        ca.set(Calendar.SECOND, ca.getActualMinimum(Calendar.SECOND));
        ca.set(Calendar.MILLISECOND, ca.getActualMinimum(Calendar.MILLISECOND));
        return ca.getTime();
    }

    /**
     * 设置时间为这一天的最后一毫秒
     *
     * @param date
     * @return
     */
    public static Date setDateToOneDayLastMilliSecond(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, ca.getActualMaximum(Calendar.HOUR_OF_DAY));
        ca.set(Calendar.MINUTE, ca.getActualMaximum(Calendar.MINUTE));
        ca.set(Calendar.SECOND, ca.getActualMaximum(Calendar.SECOND));
        ca.set(Calendar.MILLISECOND, ca.getActualMaximum(Calendar.MILLISECOND));
        return ca.getTime();
    }
}
