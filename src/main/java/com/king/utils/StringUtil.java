package com.king.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 字符串处理工具类
 * @author King
 * @date 2017/11/2
 */
public class StringUtil {

    /**
     * 手机号脱敏(123****4567)
     * @param phoneNo
     * @return
     */
    public static String formatPhoneNo(String phoneNo) {
        if (StringUtils.isEmpty(phoneNo)) {
            return "";
        }
        return StringUtils.left(phoneNo, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(phoneNo, 4), StringUtils.length(phoneNo), "*"), "***"));
    }

    /**
     * 银行卡号脱敏 (123456*****7890)
     * @param cardNo
     * @return
     */
    public static String formatCardNo(String cardNo) {
        if (StringUtils.isEmpty(cardNo)) {
            return "";
        }
        return StringUtils.left(cardNo, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNo, 4), StringUtils.length(cardNo), "*"), "******"));
    }

    /**
     * 身份证号脱敏(1234**********5678)
     * @param idCardNo
     * @return
     */
    public static String formatIdCardNo(String idCardNo) {
        if (StringUtils.isEmpty(idCardNo)) {
            return "";
        }
        return StringUtils.left(idCardNo, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(idCardNo, 4), StringUtils.length(idCardNo), "*"), "******"));
    }

    /**
     * 只显示第一个汉字(李**)
     * @param fullName
     * @return
     */
    public static String surname(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(fullName, 1), StringUtils.length(fullName), "*");
    }

    /**
     * 只显示第二个后的汉字(*四)
     * @param fullName
     * @return
     */
    public static String name(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(fullName, fullName.length() - 1), StringUtils.length(fullName), "*");
    }

    /**
     * 邮箱前缀仅显示第一个字母，前缀其他*代替，@及后面的地址显示(1****@123.com)
     * @param email
     * @return
     */
    public static String email(String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        } else {
            return StringUtils.rightPad(StringUtils.left(email, 1), index, "*").concat(StringUtils.mid(email, index, StringUtils.length(email)));
        }
    }

    /**
     * 小数转百分数
     */
    public static String toPercent(Double str) {
        StringBuffer sb = new StringBuffer(Double.toString(str * 100.0000d));
        return sb.append("%").toString();
    }

    /**
     * 百分数转小数
     */
    public static Double toDecimal(String str) {
        if (str.charAt(str.length() - 1) == '%'){
            return Double.parseDouble(str.substring(0, str.length() - 1)) / 100.0000d;
        }
        return 0d;
    }

    /**
     * 首字母变小写
     */
    public static String firstCharToLowerCase(String str) {
        Character firstChar = str.charAt(0);
        String tail = str.substring(1);
        str = Character.toLowerCase(firstChar) + tail;
        return str;
    }

    /**
     * 首字母变大写
     */
    public static String firstCharToUpperCase(String str) {
        Character firstChar = str.charAt(0);
        String tail = str.substring(1);
        str = Character.toUpperCase(firstChar) + tail;
        return str;
    }
}
