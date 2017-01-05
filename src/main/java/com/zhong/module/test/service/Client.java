package com.zhong.module.test.service;

import com.zhong.module.test.domain.Test;
import com.zhong.module.test.repository.TestRepository;
import com.zhong.service.IClinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by zhong on 2016/10/29.
 */

//@Service
//@Transactional
public class Client implements IClinet {
    @Autowired
    private TestRepository testRepository;
    public void save(){
        testRepository.save(new Test("1231231","sfsaf",new Date()));
    }

    public List<Test> findeByTitle(String title){
        return testRepository.findByTitle(title);
    }

    public void test(){
        /**
         * 自定义 方法
         */
        long i = testRepository.countById();
        System.out.println("countById()="+i);

        List<Test> testList = testRepository.findByTitle1("123123");
        System.out.println("findBylikeTitle()="+testList);

        List<Test> byTitle = testRepository.findByTitle("123123");
        System.out.println("findByTitle()="+byTitle);

        /**
         * 自带方法
         */

        //简单分页
        Page<Test> all = testRepository.findAll(new PageRequest(0,20));
        System.out.println(all.getContent());
        System.out.println(all.getNumber());
        System.out.println(all.getSize());
        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());


        //Specification条件查询
        Specification<Test> sper=new Specification<Test>() {
            @Override
            public Predicate toPredicate(Root<Test> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate title = cb.like(root.get("title").as(String.class), "%1%");
                Predicate equal = cb.equal(root.get("context").as(String.class), "sfsaf");
                cq.where(title,equal);
//                cq.orderBy()
                return cq.getRestriction();
            }
        };
        List<Test> all1 = testRepository.findAll(sper);
        System.out.println(all1);

        //Specification 条件查询+分页
        all = testRepository.findAll(sper, new PageRequest(0, 20));
        System.out.println(all.getContent());
        System.out.println(all.getNumber());
        System.out.println(all.getSize());
        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());

    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-jpa-dao.xml");
        IClinet client = (IClinet) ctx.getBean("client");
        client.test();


    }
}
