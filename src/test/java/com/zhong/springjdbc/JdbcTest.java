package com.zhong.springjdbc;

import org.junit.Test;

/**
 * Created by zhong on 2016/5/29.
 */
public interface JdbcTest {
    void saveOrupdate();
    void query();
    void batchUpdateOrSave();
    void batchDelete();
}
