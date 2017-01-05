package jdkcontext.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
 * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，
 * 而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
 * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。
 * Stream的操作可以串行执行或者并行执行
 *
 * Created by zhong on 2016/11/8.
 */
public class StreamInterfaceDemo {

    /**
     * 并行 stream
     * 串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行
     */
    @Test
    public void parallelStream(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //串行排序1000000 元素需要的时间
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));//sequential sort took: 714 ms

        //并行排序100000 元素需要的时间
         t0 = System.nanoTime();
         count = values.parallelStream().sorted().count();
         System.out.println(count);
         t1 = System.nanoTime();
         millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
         System.out.println(String.format("paralle sort took: %d ms", millis));//paralle sort took: 317 ms

        System.out.println(System.nanoTime());//5868177787612 返回值表示从某一固定但任意的时间算起的毫微秒数 系统计时器的当前值，以毫微秒为单位
        System.out.println(System.nanoTime());//5868177806896
        System.out.println(System.currentTimeMillis());//1478657759921 当前时间与协调世界时 1970 年 1 月 1 日午夜之间的时间差（以毫秒为单位测量）。
        System.out.println(System.currentTimeMillis());//1478657759921
    }


    /**
     * stream 普通方法
     * @param args
     */
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>(){
            {
                add("abc");
                add("a");
                add("dfdfsbc");
                add("edf");
                add("rtdsg");
                add("rtsdfds");
            }
        };
        System.out.println("----------------------------");
        list.stream()
                .filter((s)->s.startsWith("a")) //过滤 Predicate 断言函数式接口
                .forEach(System.out::println); //Consumer 消费 函数式接口

        System.out.println("----------------------------");
        list.stream().sorted((s1,s2)-> s1.compareTo(s2))//排序 Comparator 比较函数式接口
                .forEach(System.out::println);

        System.out.println("----------------------------");
        list.stream().map(String::toUpperCase).forEach(System.out::println); //map会将元素根据指定的Function接口来依次将元素转成另外的对象

        System.out.println("----------------------------");
        boolean anyMatch = list.stream().anyMatch((s) -> s.startsWith("a")); //任意有一个是a开头的 就返回true
        System.out.println(anyMatch);//true

        System.out.println("----------------------------");
        boolean allMatch = list.stream().allMatch((s) -> s.startsWith("a")); //是否全部匹配
        System.out.println(allMatch); //false

        long count = list.stream().filter((s) -> s.startsWith("a")).count(); //计数

        System.out.println("----------------------------");
        Optional<String> reduce = list.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
        reduce.ifPresent(System.out::println);
    }
}
