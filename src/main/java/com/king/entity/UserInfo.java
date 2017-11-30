package com.king.entity;

/**
 * @author King
 * @date 2017/11/30
 */
public class UserInfo extends BaseEntity{

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

}
