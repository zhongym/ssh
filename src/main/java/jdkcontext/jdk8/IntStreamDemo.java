package jdkcontext.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by zhongym on 2017/4/5.
 */
public class IntStreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer>  list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(i);
        }

//        List<String> collect = Stream.generate(() -> String.valueOf(Math.random())).limit(10).collect(Collectors.toList());
        IntStream.generate(()->Double.valueOf(Math.random()*100).intValue()).limit(10).forEach(System.out::println);
//        list.stream().
//        StreamS
    }
}
