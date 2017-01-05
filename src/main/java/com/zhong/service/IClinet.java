package com.zhong.service;

import com.zhong.module.test.domain.Test;

import java.util.List;

/**
 * Created by zhong on 2016/10/30.
 */
public interface IClinet {
    void save();
    List<Test> findeByTitle(String title);
    void test();
}
