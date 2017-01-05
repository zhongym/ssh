package jdkcontext.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 Lambda表达式与函数式接口：
 Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，通常是接口类型。
 而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
 我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，
 确保你的接口一定达到这个要求，你只需要给你的接口添加 @FunctionalInterface 注解，
 编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的。
 *
 * Created by zhong on 2016/11/8.
 */

@FunctionalInterface //只是检查是否只有一个抽象方法的作用，不加也可以
interface FuncationInterfaceA{
    String toLowerCase(String s);

    default void methodA(){
        System.out.println("函数式接口可以有默认方法");
    }
}

public class FunctionInterfaceAndLambda {

    @Test
    public void funcationInterface(){
        FuncationInterfaceA a = (s) -> s.toLowerCase();
        System.out.println(a.toLowerCase("AA"));
        a.methodA();
    }

    /**
     *  Lambda表达式
     */
    @Test
    public  void jdk8way(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(String a,String b)->{ //方式一 多条语句时，可以加上{}
            System.out.println("aa");
           return a.compareTo(b);
        });

        Collections.sort(names,(String a,String b)->a.compareTo(b));//方式二  只有一条语句时，可以不加{}

        Collections.sort(names,(a,b)->a.compareTo(b));//方式三  Java编译器可以自动推导出参数类型
        System.out.println(names);
    }
    /**
     * 以前的方式:
     * 通常做法都是创建一个匿名的比较器对象然
     */
    @Test
    public  void oldWay(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);
    }
}
