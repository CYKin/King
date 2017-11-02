package com.king.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 * Author : King
 * Date : 2017/11/2
 */
public class DateUtil {

    /**
     * 日期类型对象转换成指定格式字符串
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

}
