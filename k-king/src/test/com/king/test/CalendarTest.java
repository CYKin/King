package com.king.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author King
 * @date 2017/12/19
 */
public class CalendarTest {

    public static void main(String[] args) throws ParseException {

        String now = "2017-12-01 14:29:26";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(now));

        System.out.println("当前时间:"+calendar.get(Calendar.YEAR)+"(年)");
        System.out.println("当前时间:"+(calendar.get(Calendar.MONTH)+1)+"(月)");
        System.out.println("当前时间:"+calendar.get(Calendar.DATE)+"(日)");

        System.out.println("当前时间为一年第:"+calendar.get(Calendar.WEEK_OF_YEAR)+"(周)");
        System.out.println("当前时间为一月第:"+calendar.get(Calendar.WEEK_OF_MONTH)+"(周--日历中第几周)");
        System.out.println("当前时间为一月中第:"+calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"(周--一个月中第几周)");

        System.out.println("当前时间为一年第:"+calendar.get(Calendar.DAY_OF_YEAR)+"(天)");
        System.out.println("当前时间为一月第:"+calendar.get(Calendar.DAY_OF_MONTH)+"(天)");

        int weekDay = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(weekDay == 0){
            weekDay = 7;
        }
        System.out.println("当前时间为一周第:"+weekDay+"(天)");


        System.out.println("当前时间:"+calendar.get(Calendar.HOUR_OF_DAY)+"(时--24H)");
        System.out.println("当前时间:"+calendar.get(Calendar.HOUR)+"(时--12H)");
        System.out.println("当前时间:"+calendar.get(Calendar.MINUTE)+"(分)");
        System.out.println("当前时间:"+calendar.get(Calendar.SECOND)+"(秒)");

    }
}
