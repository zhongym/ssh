package com.zhong.module.test.controller;

import com.zhong.module.test.domain.Test;
import com.zhong.service.test.IMDataSourceSerivce;
import com.zhong.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhong on 2016/5/20.
 */
//@Scope("session")
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @Autowired
    private IMDataSourceSerivce mDataSourceSerivce;

    @RequestMapping("/create")
    public void save(ModelMap modelMap,Test test) throws Exception {
        testService.save(test);
        modelMap.put("sesscut","true");
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/list")
    public void findAll(ModelMap modelMap){
        System.out.println(this);
        modelMap.put("result",testService.findAll());
    }

    @RequestMapping("/{id}")
    public void get(ModelMap modelMap,@PathVariable  Integer id){
        modelMap.put("result",testService.getById(id));
    }

    @RequestMapping("/testMData")
    public void testMdata() throws Exception {
        mDataSourceSerivce.testMdata();
    }
}
