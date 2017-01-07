package com.zhong.hibenaterdemo;

import hibernate.deom.domain.Event;
import hibernate.deom.domain.Person;
import org.hibernate.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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
    public void initEve() throws SQLException {
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


        Person o = (Person) session.get(Person.class, 1L,LockOptions.UPGRADE);
        System.out.println(o.getName());
    }

    @Test
    public void testCache1(){
        List list = session.createSQLQuery("select * from PERSON where PERSION_ID=1 lock in share mode").list();
        System.out.println(list.get(0));
    }

    @Test
    public void testCache3(){
        Person o = (Person) session.get(Person.class, 1L);
        System.out.println(o.getName());
        session.clear();
        o = (Person) session.get(Person.class, 1L);
    }


    /**
     * 一个持久化对象，不管修改了多少次其属性，只会发出一条update sql
     *
     */
    @Test
    public void testCache4(){
        for (int i=0;i<4;i++){
            Person o = (Person) session.get(Person.class, 1L);
            o.setAge(i);
            System.out.println(o.getAge());
        }

//        Hibernate: select person0_.PERSION_ID as PERSION1_2_0_, person0_.age as age2_0_, person0_.name as name2_0_ from PERSON person0_ where person0_.PERSION_ID=?
//        0
//        1
//        2
//        3
//        Hibernate: update PERSON set age=?, name=? where PERSION_ID=?
    }

    /**
     *  并不是所有查询之前都会flush()
     */
    @Test
    public void testCache5(){
        Person o = (Person) session.get(Person.class, 1L);
        o.setAge(new Random().nextInt(2000));
session.flush();
         o = (Person) session.get(Person.class, 2L);
        System.out.println("---");

//        Hibernate: select person0_.PERSION_ID as PERSION1_2_0_, person0_.age as age2_0_, person0_.name as name2_0_ from PERSON person0_ where person0_.PERSION_ID=?
//        Hibernate: select person0_.PERSION_ID as PERSION1_2_0_, person0_.age as age2_0_, person0_.name as name2_0_ from PERSON person0_ where person0_.PERSION_ID=?
//        ---
//        Hibernate: update PERSON set age=?, name=? where PERSION_ID=?
    }

    /**
     *  当查询所有，或者 条件查询的时候，会调用flush()方法，发出update语句
     */
    @Test
    public void testCache6(){
            Person o = (Person) session.get(Person.class, 1L);
            o.setAge(2000);

            List list = session.createCriteria(Person.class).list();
            System.out.println("---");

//        Hibernate: select person0_.PERSION_ID as PERSION1_2_0_, person0_.age as age2_0_, person0_.name as name2_0_ from PERSON person0_ where person0_.PERSION_ID=?
//        Hibernate: update PERSON set age=?, name=? where PERSION_ID=?
//        Hibernate: select this_.PERSION_ID as PERSION1_2_0_, this_.age as age2_0_, this_.name as name2_0_ from PERSON this_
//        ---
    }



    @Test
    public void testIterate(){
        Iterator iterate = session.createQuery("from Person p").iterate();
        while (iterate.hasNext()){
            Person person= (Person) iterate.next();
            System.out.println(person.getName());

        }
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
