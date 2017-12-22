package com.king.test;

/**
 * final测试
 * @author King
 * @date 2017/12/22
 */
public class FinalTest {


    public static void main(String[] args) {


        final StringBuffer sb = new StringBuffer("abce");
        sb.append("fgh");
        System.out.println(sb.toString());

    }

}
