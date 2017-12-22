package com.king.test;

/**
 * @author King
 * @date 2017/12/22
 */
public class FatherTest {

    private static final String name = "King";
    private String age = "23";

    public void sayName(){
        System.out.println("father name:"+name);
        System.out.println("father age:"+age);
    }

    public static void sayAge(){
        FatherTest father = new FatherTest();
        System.out.println("father name:"+name);
        System.out.println("father age:"+father.age);
        father.sayName();
    }

    public static void main(String[] args) {
        FatherTest.sayAge();
    }
}
