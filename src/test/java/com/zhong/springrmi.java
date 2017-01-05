package com.zhong;

import com.zhong.rmiclinet.ITestServiceClinet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhong on 2016/6/22.
 */
public class springrmi {

    @Test
    public void testRMI() throws Exception {
        ApplicationContext application = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-hibernate-dao.xml","spring/applicationContext-webService.xml"});
        ITestServiceClinet testService = (ITestServiceClinet) application.getBean("rmiTestService");
        Object test = testService.getById(7);
        System.out.println(test);
    }

}
