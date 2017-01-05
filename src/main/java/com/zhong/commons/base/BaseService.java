package com.zhong.commons.base;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhong on 2016/5/21.
 */
public abstract class BaseService<E> implements IBaseService<E> {

    protected abstract IBaseDao<E> getEntityDao();

    @Transactional()
    public void save(E e) throws Exception {
        getEntityDao().save(e);
    }

    @Transactional
    public void update(E e) {
        getEntityDao().update(e);
    }

    @Transactional
    public void saveOrUpdate(E e) {
        getEntityDao().saveOrUpdate(e);
    }

    @Transactional
    public void delete(E e) {
          getEntityDao().delete(e);
    }

    @Override
    public List<E> findAll() {
        return getEntityDao().findAll();
    }

    @Override
    public E getById(Integer id) {
        return getEntityDao().getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        getEntityDao().deleteById(id);
    }

    @Override
    public List<E> findByKey(String key, Object value) {
        return getEntityDao().findByKey(key,value);
    }

    @Override
    public E findByUniqueKey(String key, Object value) {
        return getEntityDao().findByUniqueKey(key,value);
    }
}
