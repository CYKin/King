package com.king.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author King
 * @date 2017/12/26
 */
public class FormatTest {

    public static void main(String[] args) {

        //parseInt
        System.out.println(Integer.parseInt("12", 16));

        //四舍五入保留小数点后两位
        double f = 2111231.5585;

        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));

        System.out.println(String.format("%.2f", f));

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));

        //byte转换
        byte b = 11;
        String s = String.valueOf(b);
        Long l = Long.valueOf(s);
        System.out.println(s+" "+l);

    }

}
