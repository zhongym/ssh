package com.zhong.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhong on 2016/5/24.
 */
public class ProxyDemo {
    public static void main(String[] args){

        IPerson student = new Student();
        IPerson person = (IPerson) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(),new PersonInvocationHandler(student));
        person.say("afsdsafdsfd");
        System.out.println(person.withet());
    }
}
class PersonInvocationHandler implements InvocationHandler{

    private  IPerson person=null;

    public PersonInvocationHandler(IPerson person){
        this.person=person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("方法调用前");
        return method.invoke(person,args);
    }
}
