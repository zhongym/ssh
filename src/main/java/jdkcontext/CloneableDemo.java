package jdkcontext;

/**
 * Created by zhong on 2016/9/22.
 */

/**
 * ⑴clone方法将对象复制了一份并返回给调用者。一般而言，clone（）方法满足：
 ①对任何的对象x，都有x.clone() !=x//克隆对象与原对象不是同一个对象
 ②对任何的对象x，都有x.clone().getClass()= =x.getClass()//克隆对象与原对象的类型一样
 ③如果对象x的equals()方法定义恰当，那么x.clone().equals(x)应该成立。

 ⑵Java中对象的克隆
 ①为了获取对象的一份拷贝，我们可以利用Object类的clone()方法。
 ②在派生类中覆盖基类的clone()方法，并声明为public。
 ③在派生类的clone()方法中，调用super.clone()。
 ④在派生类中实现Cloneable接口
 */
class Cat{
    int age;

    @Override
    public String toString() {
        return age+"";
    }
}
class Person implements Cloneable{
    int a;
    Cat cat;
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        return clone;
    }
}

public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.a=5;
        person.cat=new Cat();
        person.cat.age=10;
        System.out.println("原来的："+person.a);
        System.out.println("原来的："+person.cat);

        Person clone = (Person) person.clone();
        System.out.println("复制的："+clone.a);
        System.out.println("复制的："+clone.cat);

        clone.a=50;
        clone.cat.age=100;

//        System.out.println("更改后的clone.a："+clone.a);
//        System.out.println("更改后的clone.cat:"+clone.cat);
//        System.out.println("更改后的person.a："+person.a);
//        System.out.println("更改后的person.cat:"+person.cat);

    }
}

