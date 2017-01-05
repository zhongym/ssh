package com.zhong.hibenaterdemo;

import hibernate.deom.domain.Event;
import hibernate.deom.domain.Person;
import org.hibernate.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhong on 2016/6/5.
 */
public  class HibenateTest {


    /**
     * hibernate对接的状态
     * 临时状态： new 出来的对象
     * 持久化状态 ：被绑定到某个Hibernate 的Session上（如：他们刚刚在一个单元操作被加载或者保存）
     * 胶管状态 ： Session以外修改不是处在持久化（persistent）状态下的对象（比如 当前serssion close或者事务提交了）
     */
    @Test
    public void hibernateObjecStatus(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Event event = new Event("title1",new Date()); //临时状态
        System.out.println("-------------------------="+event);
        session.save(event); //持久化状态
        System.out.println("-------------------------="+event);
        event.setTitle("title2");
        System.out.println("-------------------------="+session.load(Event.class,event.getId()));
        transaction.commit();

        event.setTitle("title3"); //胶管状态
        session = sessionFactory.getCurrentSession();
        transaction=session.beginTransaction();
        System.out.println("-------------------------="+session.load(Event.class,event.getId()));
        transaction.commit();
    }

    @Test
    public void many2many(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Person person=new Person(10,"zhong");
        Event event = new Event("title",new Date());
        person.getEvents().add(event);

        session.save(person);
        session.save(event);
        System.out.println(person);
        transaction.commit();
    }

    /**
     * 与数据库同步的时间
     */
    @Test
    public void flushTime(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        Person p1 = (Person) session.get(Person.class, 10L);
        session1.update(p1);
        p1.setName("123132");

        transaction.commit();
        transaction1.commit();
    }

    @Test
    public void testScrollableResults(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        ScrollableResults scrollableResults = session.createCriteria(Person.class).scroll();
        ScrollableResults scrollableResults = session.createQuery(" FROM Person ").scroll();
        while (scrollableResults.next()){
            Person o = (Person) scrollableResults.get(0);
            System.out.println(o);
        }
        scrollableResults.close();
        transaction.commit();
    }

    /**
     * 迫切左外连接: 返回Person对象时里面的events关联集合也会被初始化，
     * 不受  <set name="events" table="PERION_EVENT" inverse="true" lazy="true"> 配置影响
     * 由于发出的左外连接sql，所以返回的对象会有重复
     */
    @Test
    public void testLeftjoinFetch(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //
        List<Person> list = session.createQuery("from Person p left join fetch p.events where p.id>8").list();
        System.out.println("size="+list.size());

        Set<Person> set=new HashSet<Person>(list); //用set去重复的Persion对象
        System.out.println("size="+set.size());
        transaction.commit();
        session.close();
    }

    /**
     * 左外连接：返回的List里面装的是数组，每一个元素是Person，第二个是Event
     */
    @Test
    public void testLeftjoin(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //返回的List里面装的是数组，每一个元素是Person，第二个是Event
        List list = session.createQuery("from Person p left join  p.events where p.id>8").list();
        Object[] os = (Object[]) list.get(0);
        Person o = (Person) os[0];
        System.out.println(o.getEvents()); //此时才会初始化关联对象

        Event e = (Event) os[1];
        System.out.println(e.getPersons());//此时才会初始化关联对象
        transaction.commit();
        session.close();
    }

    /**
     * 左外连接：使用Select 限制返回的对象只包含Person,  返回的person对象会有重复，可以用Set去重
     */
    @Test
    public void testLeftjoin1(){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //返回的List里面装的是数组，每一个元素是Person，第二个是Event
        List list = session.createQuery("select p from Person p left join  p.events where p.id>8").list();
        Person o = (Person) list.get(0);
        System.out.println(o.getEvents()); //此时才会初始化关联对象

        transaction.commit();
        session.close();
    }

     SessionFactory sessionFactory=null;
     Session session=null;
     Transaction transaction=null;

    /**
     * 单元测试方法之前执行
     */
    @Before
    public void initEve(){
         sessionFactory= HibernateUtil.getSessionFactory();
         session = sessionFactory.openSession();
         transaction = session.beginTransaction();
    }

    /**
     * 单元测试方法之后执行
     */
    @After
    public void clear(){
        transaction.commit();
        session.close();
    }

    /**
     * 投影查询，用select 设置要返回的列
     * 1、HQL语句不能使用 select * from XXX,   select x.* from Xxxx x;
     * 2、SELECT p.age , p.name FROM Person p  返回的是一个List<Object[]> 数据里面每个元素是要返回的列  可使用distinct 去重
     * 3、要想返回的对象的封装好的对象，可以使用 持久化类的构造方法进行查询，也可以单独写一个类封装
     */
    @Test
    public void testProjection(){
//        List list = session.createQuery("SELECT p.age , p.name FROM Person p WHERE id>9").list();
//        List list = session.createQuery("SELECT new Person(p.age , p.name) FROM Person p WHERE id>9").list();
        List list = session.createQuery("SELECT new hibernate.deom.domain.PersonVo(p.age , p.name) FROM Person p WHERE p.id>9").list();
        System.out.println(list.size());

    }


    /**
     * 关联对象集合的过滤，检索，分页
     */
    @Test
    public void testCollectionFiter(){
        Person p = (Person) session.get(Person.class, 10L);
        Set events = p.getEvents(); //取出所有关联Event对象
        session.createQuery("").iterate();
        List list = session.createFilter(p.getEvents(), "where this.id=6").list();
        System.out.println(list.size());

    }

    /**
     * 动态更新：默认情况下hiberante启动的时候就已经生成了实体的crud sql保存在sessionFatary中，更新和插入语句都包含了所有字段
     * 如果只想让发出的sql包含更新的字段，可以在<class></class>元素中配置dynamic-update="true"属性。就会在session.update()的时候时生成sql
     */
    @Test
    public void testDynamicUpdate(){
        Person p = (Person) session.get(Person.class, 10L);
        Person p2 = (Person) session.get(Person.class, 10L);
//        p.setName("newName");//dynamic-update="true" 发出包含修改过字段的update语句： update PERSON set name=? where PERSION_ID=?
        p.setName("newName1");//dynamic-update="false" 更新所有字段  update PERSON set age=?, name=? where PERSION_ID=?
    }
    /**
     * 动态插入：默认情况下hiberante启动的时候就已经生成了实体的crud sql保存在sessionFatary中，更新和插入语句都包含了所有字段
     * 如果只想让发出的sql包含非空的的字段，可以在<class></class>元素中配置dynamic-insert="true"属性。就会在session.update()的时候时生成sql
     */
    @Test
    public void testDynamicInsert(){
        Person p = new Person();
        p.setName("123132");
//       session.save(p);// dynamic-insert="true"  insert into PERSON (name) values (?)
       session.save(p);// dynamic-insert="false"  insert into PERSON (age, name) values (?, ?)
    }

    @Test
    public void testCache(){

        Person o = (Person) session.get(Person.class, 1L);
        o.setName("newe");
        session.setFlushMode(FlushMode.MANUAL);
        List<Person> list = session.createCriteria(Person.class).list();
        System.out.println(o==list.get(0));
        System.out.println(o==list.get(1));
        System.out.println(list.get(0).getName());
        System.out.println(list.get(1).getName());

        List list1 = session.createSQLQuery("select * from PERSON").addEntity(Person.class).list();
        System.out.println(list1.get(0)==o);
    }

    private static  Integer[] val;
    @Test
    public void testDump() throws IOException {
        val=new Integer[1024*1024*100];
        for (int i=0;i<1024;i++){
            val[i]=i;
        }
        System.in.read();
    }

}
