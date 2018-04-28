package com.king.test;

/**
 * @author King
 * @date 2017/11/29
 */
public class StaticTest {

    // 静态成员
    public static String string = "static成员";
    // 普通成员
    public String string2 = "非static成员";

    // 静态方法
    public static void method() {
        string = "sss";
//       string2 = "sss";
        // method2();//编译报错,因为静态方法里面只能调用静态方法或静态成员
        System.out.println("这是static方法,static方法与对象无关");
    }

    // 普通方法
    public void method2() {
        string = "string1";
        string2 = "string2";
        method();// 非静态方法里面可以发出对static方法的调用
        System.out.println("这是非static方法,此方法必须和指定的对象关联起来才起作用");
    }

    public static void main(String[] args) {
        StaticTest test = new StaticTest();
        test.method2();// 引用调用普通方法
        test.method();// 引用调用静态方法
    }
}
