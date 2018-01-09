package com.king.test;

/**
 * @author King
 * @date 2018/1/5
 */
public class Husband extends Person {

    public Husband() {
        System.out.println("Husband Constructor...");
    }

    public void  say(){
        System.out.println("Husband...");
    }

    public static void main(String[] args) {
        Person person = new Husband();
        person.say();
    }
}
