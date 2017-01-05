package webservice.demo;

import javax.jws.WebService;

/**
 *@WebService(endpointInterface=&quot;&quot;)  可选，指定实现的接口。接口是对外的，必须通过注释来声明，而Impl是内部的，声明是可选的。
 */
@WebService(serviceName="UserWebService",endpointInterface = "webservice.demo.UserWebService",targetNamespace = "www.zhong.webservice.demo")
public class UserWebServiceImpl implements UserWebService{

    private UserService userService;
    public void setUserService(UserService userService) { //用于spirng注入bean
        this.userService = userService;
    }
    public User getUser(Integer userId) {
        return userService.getUser(userId);
    }
    public void createUser(String name, Integer age) {
      userService.createUser(name,age);
    }
}
