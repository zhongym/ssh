package com.zhong.module.test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *   事先定义系统需要用的的所有切入点
 *   之后就可以直接这样调用
 *    @AfterReturning("com.zhong.module.test.aop.SystemArchitecture.businessService()")
 */
//@Aspect
public class SystemArchitecture {
   /* *//**
     *//*
    @Pointcut("within（com.zhong.module.*.controller.*）")
    public void inWebLayer(){}

    *//**
     *//*
    @Pointcut("within（com.zhong.module.*.service.*）")
    public void inServiceLayer(){}

    *//**
     *//*
//    @Pointcut("within（com.zhong.module.*.dao.*）")
    public void inDataAccessLayer(){}

    *//**
     *//*
    @Pointcut(value = "execution（* com.zhong.module.*.service.*(..)）" )
    public void businessService(){}

    *//**
     *//*
//    @Pointcut("execution（* com.zhong.module.*.dao.*(..)）")
    public void dataAccessOperation(){}
*/
}
