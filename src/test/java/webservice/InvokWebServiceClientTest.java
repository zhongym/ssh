package webservice;

import zhong.webservice.clinet1.User;
import zhong.webservice.clinet1.UserWebService;
import zhong.webservice.clinet1.UserWebService_Service;

/**
 * Created by zhong on 2016/6/16.
 */
public class InvokWebServiceClientTest {
    public static void main(String[] agrs){
        UserWebService userWebService = new UserWebService_Service().getUserWebServiceImplPort();
        User user = userWebService.getUserByUserId(1);
        System.out.println(user);
    }
}
