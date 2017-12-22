package com.king.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 基于spring配置的切面实现
 * @author King
 * @date 2017/12/20
 */
@Component
public class AopXml {

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----- 开始处理 ......");
        pjp.proceed();
        System.out.println("----- 处理成功 ......");
    }

}
