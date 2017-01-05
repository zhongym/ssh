package com.zhong.commons.base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zhong on 2016/11/7.
 */
public abstract class DockingHibernateDao<E, PK extends Serializable> extends DaoSupport {

    @Autowired
    @Qualifier("dockingSessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private Class<E> entityClass;
    protected Logger logger = LoggerFactory.getLogger(getClass()); //NOSONAR
    private static final int DEFAULT_MAX_RESULTS = 10000;

    //Oracle排序兼容性
    private Class<?> idFieldType;

    @SuppressWarnings("unchecked") //NOSONAR
    public DockingHibernateDao() {
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
        this.entityClass = (Class<E>) ((ParameterizedType) genType).getActualTypeArguments()[0];

    }


    @Override
    protected final void checkDaoConfig() {
        if (this.sessionFactory == null) {
            throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
        }
    }

    @Override
    public void initDao() {
      
    }

    /**
     * 插入记录.
     *
     * @param obj
     */
    public void insert(E obj) {
        getSession().save(obj);
    }

    /**
     * 更新记录.
     *
     * @param obj
     */
    public void update(E obj) {
        getSession().update(obj);
    }

    /**
     * 删除记录.
     *
     * @param obj
     */
    public void delete(E obj) {
        getSession().delete(obj);
    }



    public List<E> findAll(String fieldName, boolean isDesc){
       return null;
    }

    /**
     * 查询数据表所有数据.
     *
     * @return List
     */
    @SuppressWarnings("unchecked") //NOSONAR
    public List<E> findAll() {
        return this.getSession().createCriteria(entityClass).list();
    }

    @SuppressWarnings("unchecked") //NOSONAR
    public List<E> findByKey(String keyName, Object value) {
        Criteria criteria = getSession().createCriteria(entityClass).add(Restrictions.eq(keyName,value));
        return criteria.list();
    }

    public E getById(PK id) {
        return (E) this.getSession().get(entityClass, id);
    }
}