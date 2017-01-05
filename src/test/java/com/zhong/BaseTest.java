package com.zhong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhong on 2016/5/29.
 */
public class BaseTest {
    protected ApplicationContext applicationContext=null;

    public BaseTest(){
        init();
    }

    public ApplicationContext init(){
       return applicationContext=new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-hibernate-dao.xml"});
    }

    public Object getBean(String name){
        return applicationContext.getBean(name);
    }
}
