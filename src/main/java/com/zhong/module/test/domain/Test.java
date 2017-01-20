package com.zhong.module.test.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhong on 2016/5/20.
 */
@Entity
@Table(name = "PRD_TEST")
@NamedQuery(name = "Test.findByTitle1",query = "from Test t where t.title =?")
public class Test implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEST_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private Integer testId;

    @Column(name = "TITLE", unique = true, nullable = true, insertable = true, updatable = true, length = 32)
    private String title;

    @Column(name = "CONTEXT", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
    private String context;

    @Column(name = "TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
    private Date time;

    @Version
    @Column(name = "verion", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
    private Integer verion;

    public Test() {
    }

    public Test(String title, String context, Date time) {
        this.title = title;
        this.context = context;
        this.time = time;
    }


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getVerion() {
        return verion;
    }

    public void setVerion(Integer verion) {
        this.verion = verion;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", time=" + time +
                '}';
    }
}
