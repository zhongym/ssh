package com.zhong.commons.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhong on 2016/11/7.
 */
public interface IDockingEntityManager<E, PK extends Serializable> {

    public void insert(E obj);

    public void update(E obj);

    public void delete(E obj);

    public List<E> findAll(String fieldName, boolean isDesc);

    public List<E> findAll();

    public List<E> findByKey(String keyName, Object value);

    public E getById(PK id);
}