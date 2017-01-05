package com.zhong.service.test;

import com.zhong.commons.base.IBaseService;
import com.zhong.module.test.domain.Test;

/**
 * 些接口用于通过切面配置给ITestService实现添加新的方法
 */
public interface ITestServiceExt{
    void extMethod();
}
