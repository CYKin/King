package com.king.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于注解的切面实现
 * Aspect：指定当前类为切面类
 * @author King
 * @date 2017/12/19
 */
@Aspect
@Component
public class AopAnnotate {

    //指定切入点表达式，拦截那些方法
    @Pointcut("execution(* com.king.web.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----- 开始处理 ......");
        pjp.proceed();
        System.out.println("----- 处理成功 ......");
    }
}

//    @Before("pointCut()")
//    public void begin(){
//        System.out.println("----- 开启事务 ......");
//    }
//    @After("pointCut()")
//    public void close(){
//        System.out.println("----- 关闭事务 ......");
//    }
//}
