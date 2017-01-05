package com.zhong.module.test.service;


import com.zhong.commons.base.BaseService;
import com.zhong.commons.base.IBaseDao;
import com.zhong.module.test.dao.TestDao;
import com.zhong.module.test.domain.Test;
import com.zhong.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhong on 2016/5/20.
 */
@Service
public class TestService extends BaseService<Test> implements ITestService {

//    public TestService(TestDao testDao) {
//        this.testDao=testDao;
//    }

//    @Value("#{ T(java.lang.Math).random() * 100.0 }")//动态计算值(详细请查看spel表达式)
//    private Double randomNumber;
//
//    public void setRandomNumber(Double randomNumber) {
//        this.randomNumber= randomNumber;
//    }

    @Autowired(required = false)
    private TestDao testDao;

    @Override
    protected IBaseDao<Test> getEntityDao() {
        return testDao;
    }

    @Override
    @Transactional()
    public void save(Test test) throws Exception {
        testDao.save(test);
    }

    @Override
    public List<Test> findAll() {
        return super.findAll();
    }

    @Override
    public void myMethod() {
        System.out.println("myMethod()");
    }
}
