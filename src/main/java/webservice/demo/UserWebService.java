package webservice.demo;

/**
 * Created by zhong on 2016/6/16.
 */

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 @WebService 必须，(name="UserService")可选，配置Service的名称，默认为类名。targetNamespace(如果不写，wsdl上面就不会生成接口上面配置的@WebResult类型)可选，默认为http:// package的倒序，
 @WebResult 可选，配置方法的返回值在WSDL的名称,CXF默认为return。
 @WebParam 可选，配置参数在WSDL的名称，CX比较笨，不会反射，默认为arg0,arg1....
 @WebMethod 可选，默认接口的所有方法均输出为WebService。 有一个方法有此注释，则其他无注释的方法非WebService。
 */
@WebService(targetNamespace = "www.zhong.webservice.demo")
public interface UserWebService {
    @WebMethod(operationName = "getUserByUserId")
    @WebResult(name ="User")
    public User getUser(@WebParam(name = "userId") Integer userId);

    @WebMethod()
    public void createUser(@WebParam(name = "name")String name,@WebParam(name = "age")Integer age);
}
