package com.zhong.springjdbc;

import com.zhong.BaseTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhong on 2016/5/29.
 */
public class JdbcTemplateTest extends BaseTest implements JdbcTest {

    @Test
    public void saveOrupdate(){
        ApplicationContext applicationContext = init();
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            String sql="insert into PRD_TEST(TITLE,CONTEXT,TIME)values(?,?,?)";
            int update = jdbcTemplate.update(sql,"title2","context12",new Date()); //因为jdbc数据源设置了defaultAutoCommit为false了，如果不开事务是没法保存到数据库的
            System.out.println(update);

            dataSourceTransactionManager.commit(transactionStatus);

        }catch (Exception e){
            e.printStackTrace();
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

    @Test
    public void query(){
        ApplicationContext applicationContext = init();
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.query("select *from PRD_TEST", new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()){
                    Integer id = resultSet.getInt(resultSet.findColumn("TEST_ID"));
                    String title = resultSet.getString(resultSet.findColumn("title"));
                    String context = resultSet.getString(resultSet.findColumn("context"));
//                    resultSet.getDate(resultSet.findColumn("TIME"));
                    java.sql.Date time = resultSet.getDate("TIME");
//                    System.out.println("id="+id+",title="+title+",context="+context+",time="+time);
                }
            }
        });

        List<com.zhong.module.test.domain.Test> testList = jdbcTemplate.queryForList("select *from PRD_TEST", com.zhong.module.test.domain.Test.class);
        System.out.println(testList);
//        jdbcTemplate.query
//        jdbcTemplate.u
    }

    @Test
    public void batchUpdateOrSave() {
        ApplicationContext applicationContext = init();
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            String sql="insert into PRD_TEST(TITLE,CONTEXT,TIME)values(?,?,?)";
            final List<com.zhong.module.test.domain.Test> list=new ArrayList(){{
                this.add(new com.zhong.module.test.domain.Test("title_1","context_2",new Date()));
                this.add(new com.zhong.module.test.domain.Test("title_3","context_3",new Date()));
                this.add(new com.zhong.module.test.domain.Test("title_4","context_4",new Date()));
                this.add(new com.zhong.module.test.domain.Test("title_5","context_5",new Date()));
            }};

            int[] ints = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setString(1, list.get(i).getTitle());
                    preparedStatement.setString(2, list.get(i).getContext());
                    preparedStatement.setDate(3, new java.sql.Date(list.get(i).getTime().getTime()));
                }

                @Override
                public int getBatchSize() {
                    return list.size();
                }
            });
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
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        //编程式事务
        DataSourceTransactionManager dataSourceTransactionManager= (DataSourceTransactionManager) applicationContext.getBean("dataSourceTransactionManager");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            String sql="DELETE FROM PRD_TEST WHERE TEST_ID=?";
            final List<Integer> list=new ArrayList(){{
                this.add(1);
                this.add(2);
                this.add(3);
            }};

            int[] ints = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setInt(1, list.get(i));
                }
                @Override
                public int getBatchSize() {
                    return list.size();
                }
            });
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
