package com.zhong.commons.base;

import java.util.List;

/**
 * Created by zhong on 2016/5/21.
 */
public interface IBaseService<E> {
    void save(E e) throws Exception;

    void update(E e);

    void saveOrUpdate(E e);

    void delete(E e);

    void deleteById(Integer id);

    List<E> findAll();

    E getById(Integer id);

    List<E> findByKey(String key,Object value);

    E findByUniqueKey(String key,Object value);
}
