package com.zhong.jpademo;

import org.junit.Test;
import sun.instrument.InstrumentationImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by zhong on 2016/7/25.
 */
public class JpaDemo {
    public static void main(String[] args) {


//        System.out.println(JpaDemo.class.getClassLoader().getResource(""));
//
//        // Start EntityManagerFactory
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("helloworld");
//
//        // First unit of work
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        Message message = new Message("Hello World with JPA");
//        em.persist(message);
//
//        tx.commit();
//        em.close();
//
//        // Second unit of work
//        EntityManager newEm = emf.createEntityManager();
//        EntityTransaction newTx = newEm.getTransaction();
//        newTx.begin();
//
//        List messages =
//                newEm.createQuery("select m from Message m order by m.text asc").getResultList();
//
//        System.out.println( messages.size() + " message(s) found:" );
//
//        for (Object m : messages) {
//            Message loadedMsg = (Message) m;
//            System.out.println(loadedMsg.getText());
//        }
//
//        newTx.commit();
//        newEm.close();
//
//        // Shutting down the application
//        emf.close();
    }


}
