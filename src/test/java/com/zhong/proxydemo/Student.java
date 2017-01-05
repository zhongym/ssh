package com.zhong.proxydemo;

/**
 * Created by zhong on 2016/5/24.
 */
public class Student implements IPerson{
    @Override
    public void say(String ln) {
        System.out.println(ln);
    }

    @Override
    public double withet() {
        return 100;
    }
}
