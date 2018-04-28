package com.king.entity;

import com.king.annotation.AttributeAnnotation;

/**
 * @author King
 * @date 2017/11/30
 */
public class UserInfo extends BaseEntity{

    @AttributeAnnotation(isNull = true, explain = "姓名")
    private String name;

    @AttributeAnnotation(isNull = true, explain = "年龄")
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
