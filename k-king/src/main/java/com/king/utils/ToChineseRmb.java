package com.king.utils;

import org.springframework.util.StringUtils;

/**
 * @author: KingCY
 * @create: 2018/1/9 14:43
 */
public class ToChineseRmb {

    private static final char[] ChineseNum = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final char[] ChineseUnit = {'里', '分', '角', '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿', '拾', '佰', '仟', '万'};

    private static final String ling = "0";
    private static final String lingZH = "零元";

    /**
     * 返回金额的中文式大写金额,支仅持到万亿
     * 支持到小数点后3位,如果大于3位,那么会四舍五入到3位
     */
    public static String arabNumToChineseRMB(String moneyValue) throws Exception {
        if (ling.equals(moneyValue)) {
            return lingZH;
        }
        if (StringUtils.isEmpty(moneyValue)) {
            return "";
        }
        //整数
        int i = 3;
        String inteStr = "";
        //小数
        int j = 0;
        String deciStr = "";
        //去掉数字前面的零
        moneyValue = moneyValue.replaceFirst("^0+", "");
        //去掉数字中的逗号
        moneyValue = moneyValue.replaceAll(",", "");
        //格式化小数点
        String money = String.format("%.3f", Double.valueOf(moneyValue));

        //整数部分
        String inte = money.split("\\.")[0];
        if (!ling.equals(inte)) {
            int len = inte.length();
            if (len > 13) {
                throw new Exception("money too large, only support to trillions");
            }
            for (len--; len >= 0; len--) {
                inteStr = ChineseUnit[i++] + inteStr;
                int num = Integer.parseInt(inte.charAt(len) + "");
                inteStr = ChineseNum[num] + inteStr;
            }
            inteStr = inteStr.replaceAll("零[拾佰仟]", "零")
                    .replaceAll("零+亿", "亿").replaceAll("零+万", "万")
                    .replaceAll("零+元", "元").replaceAll("零+", "零");
        }

        //小数部分
        int deci = Integer.parseInt(money.split("\\.")[1]);
        if (!ling.equals(String.valueOf(deci))) {
            while (deci > 0) {
                deciStr = ChineseUnit[j++] + deciStr;
                deciStr = ChineseNum[deci % 10] + deciStr;
                deci /= 10;
            }
            deciStr = deciStr.replaceAll("零[里分角]", "零");
            if (j < 3) {
                deciStr = "零" + deciStr;
            }
            deciStr = deciStr.replaceAll("零+", "零");
            if (deciStr.endsWith("零")) {
                deciStr = deciStr.substring(0, deciStr.length() - 1);
            }
        }
        return inteStr + deciStr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(arabNumToChineseRMB("103054301032.002"));
    }

}
