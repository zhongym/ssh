package com.zhong.spring;

import com.zhong.module.test.dao.TestDao;
import com.zhong.module.test.service.TestService;
import com.zhong.service.test.ITestService;
import com.zhong.service.test.ITestServiceExt;
import hibernate.deom.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by zhong on 2016/5/26.
 */
public class SpringTest{

    @Test
    public void springXmlAop(){
        ApplicationContext application = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-hibernate-dao.xml"});
        ITestService testService = (ITestService) application.getBean("testService");
        testService.myMethod();
//        testService.save(new com.zhong.module.test.domain.Test());

        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.getBean("");
    }
    @Test
    public void testRMI() throws Exception {
        ApplicationContext application = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-hibernate-dao.xml","spring/applicationContext-webService.xml"});
        ITestService testService = (ITestService) application.getBean("testService");
        com.zhong.module.test.domain.Test test = testService.getById(7);
        System.out.println(test);
    }

    @Test
    public void testBeanNameOrId(){
        ApplicationContext application = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-hibernate-dao.xml"});
        Person person = (Person) application.getBean("person");
        System.out.println(person);
    }

}
