package com.zhong.module.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zhong on 2016/5/21.
 */

@Aspect
@Component
@Order(1) //通知的优先级，如果多个前置（或者后置）通知应用到一个连接点上，这个优先级会有用
public class TestServiceAop implements Ordered {

    /**
     * @DeclareParents注解由3部分组成：
    value属性等同于<aop:delcare-parents>的types-matching属性。它标识应该被引入指定接口的Bean类型。
    defaultImpl属性等同于<aop:declare-parents>的default-impl属性。它标识该类提供了所引入接口的实现。
    由@DeclaeParents注解所标注的static属性指定了将被引入的接口。

    （该注解类AspectJAnnotationAdvisingObj需要声明为Spring应用上下文中的一个Bean。）
     */
//    @DeclareParents(value = "com.zhong.module.test.service.TestService",defaultImpl = com.zhong.module.test.service.TestServiceExt.class)
//    private ITestServiceExt testServiceExt;

    //切入点方法必须为当前类的方法（不能是继承的方法，如果要切入继承的方法，必须重写些方法）
//    @AfterReturning("execution(public * com.zhong.module.test.service.TestService.save(..))")
    public void afterSava(JoinPoint joinpoint){
        System.out.println("afterSava");
//       throw new RuntimeException("");
    }


    //通知的优先级，如果多个前置（或者后置）通知应用到一个连接点上，这个优先级会有用
   // @Order(1)
//    @Before("execution(public * com.zhong.module.test.service.TestService.save(..))")
    public void jionPoinMeth(){
        System.out.println(" @Before()");
    }


    public void xmlMethod(JoinPoint joinpoint) throws Exception {
        String name = joinpoint.getSignature().getName();
        System.out.println("xmlMethod（）");
        throw new Exception("");
    }

    @Override
    public int getOrder() { //实现Ordered 接口控制通知执行顺序
        return 1;
    }
}
