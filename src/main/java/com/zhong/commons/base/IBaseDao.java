package com.zhong.commons.base;

import cn.org.rapid_framework.page.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by zhong on 2016/5/21.
 */
public interface IBaseDao<E> {
    void save(E e);

    void update(E e);

    void saveOrUpdate(E e);

    void delete(E e);

    void deleteById(Integer id);

    E getById(Integer id);

    List<E> findAll();

    List<E> findByKey(String key,Object value);

    E findByUniqueKey(String key,Object value);

    Page<E> pageQuery(int pageNumber, int pageSize, Criteria criteria);

}
