package com.king.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author King
 * @date 2017/12/18
 */
public class BigDecimalTest {

    public static void main(String[] args) throws ParseException {

        BigDecimal big = new BigDecimal(2.35);

        //System.out.println(big.setScale(1));
        System.out.println(big.setScale(2,BigDecimal.ROUND_HALF_UP));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date start = format.parse("2017-12-02 14:56:07");

        Date end = format.parse("2017-12-03 00:00:00");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        int t1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(end);
        int t2 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(t2 - t1);


    }

}
