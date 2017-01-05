package com.zhong.commons.base;

import cn.org.rapid_framework.page.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zhong on 2016/5/21.
 */
public abstract class BaseHibernateDao<E> /*extends HibernateDaoSupport*/ implements IBaseDao<E> {

    private Class<E> claszz;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public BaseHibernateDao(){
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        claszz= (Class<E>) pt.getActualTypeArguments()[0];
    }

    public Class getEntityClass() {
        return claszz;
    }

    @Override
    public void save(E e) {
        getSession().save(e);
        /**
         *  直接使用getSessionFactory().openSession()或者getCurrentSession()获取session进行数据库操作，
         *  事务将无法正常动作。因为新打开的session和spirng 事务管理者持有的session不一致
         *
         *  可使用spring提供的工具类 SessionFactoryUtils
         */
//          SessionFactoryUtils.getSession(getSessionFactory(),false).save(e);
//        Session session = getSessionFactory().openSession();
//        session.save(e);

//        getSessionFactory().getCurrentSession().save(e);

//        getHibernateTemplate().save(e);
    }

    @Override
    public void update(E e) {
        getSession().update(e);
    }

    @Override
    public void saveOrUpdate(E e) {
        getSession().saveOrUpdate(e);
    }

    @Override
    public void delete(E e) {
        getSession().delete(e);
    }

    @Override
    public void deleteById(Integer id) {
        Object o = getSession().get(getEntityClass(), id);
        if(o!=null) {
            getSession().delete(o);
        }
    }

    @Override
    public List<E> findByKey(String key, Object value) {
        Criteria criteria = getSession().createCriteria(getEntityClass()).add(Restrictions.eq(key,value));
        return criteria.list();
    }

    @Override
    public List<E> findAll() {
        Criteria criteria = getSession() .createCriteria(this.getEntityClass());
        return  criteria.list();
    }

    @Override
    public E getById(Integer id) {
        return (E)getSession().get(getEntityClass(),id);
    }

    @Override
    public E findByUniqueKey(String key, Object value) {
        Criteria criteria = getSession() .createCriteria(this.getEntityClass()).add(Restrictions.eq(key,value));
        return (E) criteria.list().get(0);
    }

    @Override
    public Page<E> pageQuery(int pageNumber, int pageSize, Criteria criteria) {
        //get totalCount
        int totalCount = ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        criteria.setProjection(null);
        if(pageNumber<=0){
            throw  new IllegalArgumentException("[pageSize] must great than zero");
        }
        List<E> list = criteria.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).list();
        return new Page<E>(pageNumber,pageSize,totalCount,list);
    }
}
