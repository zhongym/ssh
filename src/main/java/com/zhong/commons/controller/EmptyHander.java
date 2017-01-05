package com.zhong.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: lxd
 * Date: 11-5-19
 * Time: 下午1:49
 *  将这个处理器设置到HandlerExecutionChain 中，当没找到匹配的处理器，就会用这个默认的处理器
 *  由于这个处理器没有返回ModelAndView 为空，没有返回逻辑视图 就会触发DispatcherServlet里面的成员变量DefaultRequestToViewNameTranslator
 *
 *  DefaultRequestToViewNameTranslator从请求的URL生成一个逻辑视图名称、结合InternalResourceViewResolver中的前序和后序，就得出了真正的jsp
 *  比如访问 /wap/index.ac
 *  生成的逻辑视图为/wap/index     <property name="prefix" value="/template/green/"/>+/wap/index+ <property name="suffix" value=".jsp"/>
 *
 */
@Controller
public class EmptyHander {
    @RequestMapping
    public void doRedirect(){
//        System.out.println("---");
    }
}
