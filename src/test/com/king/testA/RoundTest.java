package com.king.testA;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author King
 * @date 2018/1/8
 */
public class RoundTest {

    public static void main(String[] args) {

        //ceil = 向上取整
        //floor = 向下取整
        //round = Math.floor(x+0.5)
        float f1 = 3.51f;
        float f2 = -3.51f;
        System.out.println(Math.round(f1));
        System.out.println(Math.round(f2));


        BigDecimal big = new BigDecimal("3.1415926");
        DecimalFormat format = new DecimalFormat("#.00");

        System.out.println(format.format(big));
        System.out.println(big.setScale(2, RoundingMode.HALF_UP));

    }
}
