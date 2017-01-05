package jdkcontext.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhong on 2016/11/3.
 */

class AopHandler implements InvocationHandler{

    private  Object tager;

    AopHandler(Object tager){
        this.tager=tager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName());

        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class pt:parameterTypes) {
            System.out.println(pt);
        }

//       System.out.println("---");
      if (args!=null&&args.length>0){
          for (Object obj : args) {
              System.out.println(obj);
          }
      }

        method.invoke(tager,args);

        return null;
    }
}

interface UserService{
    void save();
}

class UserServiceImpl implements UserService{

    @Override
    public void save() {
        System.out.println("UserServiceImpl.save()");
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl=new UserServiceImpl();
        UserService userService1= (UserService) Proxy.newProxyInstance(userServiceImpl.getClass().getClassLoader(),
                userServiceImpl.getClass().getInterfaces(),new AopHandler(userServiceImpl));
        userService1.save();
    }
}
