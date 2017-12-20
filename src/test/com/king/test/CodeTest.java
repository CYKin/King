package com.king.test;

/**
 * @author King
 * @date 2017/11/3
 */
public class CodeTest {

    public static void main(String[] args) {
        //线程
        //threadTest();

        //数组
        //arrayTest();

//        System.out.println(Math.round(11.4));

        System.out.println(System.currentTimeMillis());
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(-11.4));
//        System.out.println(Math.round(-11.5));
    }

    public static  void  threadTest(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //身份证解析
                    idCard("");
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * 身份证解析
     * @param str
     */
    public static void idCard(String str) {
        String a = str.substring(0, 2);//2
        String b = str.substring(2, 4);//2
        String c = str.substring(4, 6);//2
        String d = str.substring(6, 10);//4
        String e = str.substring(10, 12);//2
        String f = str.substring(12, 14);//2
        String g = str.substring(14, 16);//2
        String h = str.substring(16, 17);//1
        String i = str.substring(17, 18);//1
        System.out.println("所在省份代码：" + a);
        System.out.println("所在城市代码：" + b);
        System.out.println("所在区县代码：" + c);
        System.out.println("出生年月日: " + d + "-" + e + "-" + f);
        System.out.println("所在地派出所代码：" + g);
        System.out.println("性别：" + h);
        System.out.println("校验码：" + i);
    }


    /**
     * 数组
     */
    public static void arrayTest() {
        char charArray1[] = new char[10];
        char[] charArray2 = new char[10];
    }

}
