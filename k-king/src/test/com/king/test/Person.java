package com.king.test;

/**
 * @author King
 * @date 2018/1/5
 */
public class Person {

    protected String name;
    protected int age;
    protected String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {
        System.out.println("Person Constructor...");
    }

    public String toStr() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void  say(){
        System.out.println("Person...");
    }
}