package jdkcontext.jdk8;

import org.junit.Test;

/**
 * 方法与构造函数引用
 * Created by zhong on 2016/11/8.
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
//
//class Con {
//    Integer convert(String from){
//        return Integer.valueOf(from);
//    }
//}

public class MethodAndConstructorReference {

    /**
     * 静态方法与对象方法的引用：会将引用方法的参数和返回值对就的函数式表达式的抽象方法中
     */
    @Test
    public void test1(){
        Converter<String, Integer> converter = Integer::valueOf; //静态方法引用
//        Con con=new Con();
//        Converter<String, Integer> converter = con::convert; //对象方法引用
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }

    /**
     * 构造函数引用
     */
    @Test
    public void test2(){
        PersonFactory factory=Person::new;//我们只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
        Person person = factory.create("123", "32");
        System.out.println(person.firstName);
    }
}
class Person {
    String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

