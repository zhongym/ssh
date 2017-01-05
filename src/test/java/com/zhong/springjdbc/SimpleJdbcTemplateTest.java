package com.zhong.springjdbc;

import com.zhong.BaseTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.validation.ObjectError;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhong on 2016/5/29.
 * SimpleJdbcTemplate这个类结合了JdbcTemplate和NamedParameterJdbcTemplate(对JdbcTemplate做了封装，
 * 提供了更加便捷的基于命名参数的使用方式而不是传统的JDBC所使用的“?”作为参数的占位符)的最常用的功能，
 * 同时它也利用了一些Java 5的特性所带来的优势，例如泛型、varargs和autoboxing等
 */
public class SimpleJdbcTemplateTest extends BaseTest implements JdbcTest {
    @Override
    @Test
    public void saveOrupdate() {
        ApplicationContext applicationContext = init();
        SimpleJdbcTemplate jdbcTemplate = (SimpleJdbcTemplate) applicationContext.getBean("simpleJdbcTemplate");
        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            //对JdbcTemplate做了封装， 提供了更加便捷的基于命名参数的使用方式而不是传统的JDBC所使用的“?”作为参数的占位符
            String sql = "insert into PRD_TEST(TITLE,CONTEXT,TIME)values(:title,:context,:time)";
            int update = jdbcTemplate.update(sql, new HashMap<String, Object>() {
                {
                    this.put("title", "title234");
                    this.put("context", "context3432");
                    this.put("time", new Date());
                }
            });
            System.out.println(update == 1 ? "成功" : "失败");
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

    @Override
    @Test
    public void query() {
        ApplicationContext applicationContext = init();
        SimpleJdbcTemplate jdbcTemplate = (SimpleJdbcTemplate) applicationContext.getBean("simpleJdbcTemplate");
        List<com.zhong.module.test.domain.Test> list = jdbcTemplate.query("select *from PRD_TEST", new RowMapper<com.zhong.module.test.domain.Test>() {
            @Override
            public com.zhong.module.test.domain.Test mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                com.zhong.module.test.domain.Test test =new  com.zhong.module.test.domain.Test();
                test.setTestId(resultSet.getInt("TEST_ID"));
                test.setTitle(resultSet.getString("title"));
                test.setContext(resultSet.getString("context"));
                test.setTime(resultSet.getDate("time")!=null?new Date(resultSet.getDate("time").getTime()):null);
                return test;
            }
        });
        System.out.println(list);
    }

    @Override
    @Test
    public void batchUpdateOrSave() {
        ApplicationContext applicationContext = init();
        SimpleJdbcTemplate jdbcTemplate = (SimpleJdbcTemplate) applicationContext.getBean("simpleJdbcTemplate");
        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            //对JdbcTemplate做了封装， 提供了更加便捷的基于命名参数的使用方式而不是传统的JDBC所使用的“?”作为参数的占位符
            String sql = "insert into PRD_TEST(TITLE,CONTEXT,TIME)values(:title,:context,:time)";
            final List<com.zhong.module.test.domain.Test> list=new ArrayList(){{
                this.add(new com.zhong.module.test.domain.Test("title_11","context_21",new Date()));
                this.add(new com.zhong.module.test.domain.Test("title_41","context_41",new Date()));
                this.add(new com.zhong.module.test.domain.Test("title_51","context_51",new Date()));
            }};
            SqlParameterSource[] batchData = SqlParameterSourceUtils.createBatch(list.toArray());
            int[] ints = jdbcTemplate.batchUpdate(sql, batchData);
            for (int i:ints) {
                System.out.println(i==1?"成功":"失败");
            }
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

    @Override
    @Test
    public void batchDelete() {
        ApplicationContext applicationContext = init();
        SimpleJdbcTemplate jdbcTemplate = (SimpleJdbcTemplate) applicationContext.getBean("simpleJdbcTemplate");
        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            //对JdbcTemplate做了封装， 提供了更加便捷的基于命名参数的使用方式而不是传统的JDBC所使用的“?”作为参数的占位符
            String sql="DELETE FROM PRD_TEST WHERE TEST_ID=?";

            List<Object[]> list=new ArrayList(){{
                this.add(new Object[]{4});
                this.add(new Object[]{5});
                this.add(new Object[]{6});
            }};
            int[] ints = jdbcTemplate.batchUpdate(sql, list);
            for (int i:ints) {
                System.out.println(i==1?"成功":"失败");
            }
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }
}
