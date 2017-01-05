package com.zhong.springProxy;


import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by zhong on 2016/5/26.
 */
public class SpringProxyDemo {
    /***
     * 1. 使用ProxyFactory通过编程创建AOP代理
     * 2.使用ProxyFactory通过配置创建Aop代理
     * <bean id="personTarget" class="com.mycompany.PersonImpl">
        <property name="name"><value>Tony</value></property>
         <property name="age"><value>51</value></property>
      </bean>

     <bean id="myAdvisor" class="com.mycompany.MyAdvisor"/>
     <bean id="debugInterceptor" class="org.springframework.aop.interceptor.DebugInterceptor"/>

     <bean id="person"  class="org.springframework.aop.framework.ProxyFactoryBean">
         <property name="proxyInterfaces"><value>com.mycompany.Person</value></property>
         <property name="target"><ref local="personTarget"/></property>
         <property name="interceptorNames">
         <list>
             <value>myAdvisor</value>
             <value>debugInterceptor</value>
         </list>
         </property>
     </bean>

     Person person = (Person) factory.getBean("person");
     * @param args
     */
    public static void main(String[] args){

        ProxyFactory proxyFactory = new ProxyFactory(new SimplePojo());
        proxyFactory.setExposeProxy(true);
        proxyFactory.addInterface(Pojo.class);
        proxyFactory.addAdvice(new AfterReturningAdvice(){
            public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
                System.out.println("afterReturning()");
            }
        });
        Pojo pojo = (Pojo) proxyFactory.getProxy();
        pojo.foo();

        //操作代理，可将任何的代理对象转成Advised 进行操作
        Advised advised = (Advised) pojo;
        Advisor[] advisors = advised.getAdvisors();
        int oldAdvisorCount = advisors.length;
        System.out.println(oldAdvisorCount + " advisors");


    }
}

interface Pojo{
    void foo();
    void bar();
}

class SimplePojo implements Pojo {
    public void foo() {
//        this.bar(); //直接内部调用其它方法，不会觖发此方法被调理
        ((Pojo) AopContext.currentProxy()).bar(); //需要将 设置 proxyFactory.setExposeProxy(true); 这样就会触发此方法的通知执行

    }

    public void bar() {
        // some logic...
        System.out.println("bar()");
    }
}
