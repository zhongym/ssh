package com.zhong.commons.base;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zhong on 2016/11/7.
 */
public abstract class DockingEntityManager<D,E,PK extends Serializable> implements IDockingEntityManager<E, PK>, InitializingBean, ApplicationContextAware {

    protected Logger logger = Logger.getLogger(this.getClass());

    private Class<E> daoClass;
    protected DockingHibernateDao<E,PK> entityDao;
    private ApplicationContext applicationContext;

    public DockingEntityManager(){
        Class typeCls = getClass();
        Type genType = typeCls.getGenericSuperclass();
        while (true) {
            if (!(genType instanceof ParameterizedType)) {
                typeCls = typeCls.getSuperclass();
                genType = typeCls.getGenericSuperclass();
            } else {
                break;
            }
        }
        this.daoClass = (Class<E>) ((ParameterizedType) genType).getActualTypeArguments()[0];
    }

    @Override
    public void insert(E obj) {
        entityDao.insert(obj);
    }

    @Override
    public void update(E obj) {
        entityDao.update(obj);
    }

    @Override
    public void delete(E obj) {
        entityDao.delete(obj);
    }

    @Override
    public List<E> findAll(String fieldName, boolean isDesc) {
        return entityDao.findAll(fieldName, isDesc);
    }

    @Override
    public List<E> findAll() {
        return entityDao.findAll();
    }

    @Override
    public List<E> findByKey(String keyName, Object value){
        return entityDao.findByKey(keyName,value);
    }

    @Override
    public E getById(PK id) {
        return entityDao.getById(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        entityDao = (DockingHibernateDao<E,PK>)applicationContext.getBean(daoClass);
        entityDao.initDao();
    }

}