package webservice.demo;

import javax.xml.bind.annotation.XmlType;

/**
 *
 @XmlType(name = "User")  可选的
 JAXB的智能化较高，基本上不需要手工映射。
 默认的@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER )根据公共getter/setter与公共属性反射(XmlAccessType.PROPERTY根据getter/setter反射，XmlAccessType.FIELD 根据成员变量反射)
 如果有需要注释@XMLElement，@XMLAttribute，需配合XmlAccessorType定义，默认的PUBLIC_MEMBER，需要在getter/setter上定义，如果要写在成员变量上定义，则XmlAccessType改为FIELD。
 @XmlType(name = "User") 指定WSDL上的类型名称，否则CXF奇怪，DTO的类名是小写开头的。
 @XmlTransient 可以注释某个字段，取消该字段的反射。

 */
@XmlType(name = "User")
public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
