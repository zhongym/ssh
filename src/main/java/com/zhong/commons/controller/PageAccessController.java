package com.zhong.commons.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhong on 2016/5/21.
 */
//@Controller
public class PageAccessController {

    @RequestMapping("*")
    public void navigate2jsp(){
        System.out.println("---");
//        ModelAndView mav = new ModelAndView();
//        return mav;
    }
}
