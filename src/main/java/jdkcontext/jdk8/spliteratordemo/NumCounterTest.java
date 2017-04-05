package jdkcontext.jdk8.spliteratordemo;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试类
 * 问题：求这个字符串"12%3 21sdas s34d dfsdz45 R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd"中所有的数字之和例子：比如这种"12%sdf3"，和就是12+3=15，这种"12%3 21sdas"和就是12+3+21=36
     思路：字符串要用到Stream，只有把整个字符串拆分成一个个Character，而是否是并行，按道理讲只需要改一个标志位即可
 */
public class NumCounterTest {

    public static void main(String[] args) {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        System.out.println("ordered total: " + countNum(stream)); //432

    }

    private static int countNum(Stream<Character> stream){
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }
}