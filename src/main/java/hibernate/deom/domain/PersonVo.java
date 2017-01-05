package hibernate.deom.domain;

/**
 * Created by zhong on 2016/9/1.
 */
public class PersonVo {
    private int age;
    private String name;

    public PersonVo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
