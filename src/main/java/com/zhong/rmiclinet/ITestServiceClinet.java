package com.zhong.rmiclinet;

import java.util.List;
import  com.zhong.module.test.domain.Test;

/**
 * Created by zhong on 2016/6/22.
 */
public interface ITestServiceClinet {
    void save(Test e) throws Exception;

    void update(Test e);

    void saveOrUpdate(Test e);

    void delete(Test e);

    void deleteById(Integer id);

    List<Test> findAll();

    Test getById(Integer id);

    List<Test> findByKey(String key,Object value);

    Test findByUniqueKey(String key,Object value);

}
