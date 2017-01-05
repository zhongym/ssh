package com.zhong.module.test.service;


import com.zhong.commons.base.BaseService;
import com.zhong.commons.base.IBaseDao;
import com.zhong.module.test.dao.TestDao;
import com.zhong.module.test.domain.Test;
import com.zhong.service.test.ITestService;
import com.zhong.service.test.ITestServiceExt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ITestServiceExt 接口的默认实现
 */
//@Service
public class TestServiceExt  implements ITestServiceExt {
    @Override
    public void extMethod() {
        System.out.println("extMethod()");
    }
}
