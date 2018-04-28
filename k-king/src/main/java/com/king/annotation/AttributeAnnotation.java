package com.king.annotation;

import java.lang.annotation.*;

/**
 * 自定义属性注解
 * @author wangchangyong
 * @create 2018/03/02 9:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface AttributeAnnotation {

    /**
     * 是否为空（默认false为空）
     * @return
     */
    boolean isNull() default false;

    /**
     * 字段说明
     * @return
     */
    String explain() default "";
}
