package jdkcontext.jdk8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhong on 2016/11/9.
 */
public class MapNewFeatures {

    @Test
    public void test1(){
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "val" + i);
        }
        map.putIfAbsent(0,"13213"); //如果不存在，就存值
        String s = map.get(0);
        System.out.println(s);//val0

//        map.forEach((id, val) -> System.out.println(id+"#"+val));

        map.computeIfAbsent(20,i->i+1+""); //如果不存在key  ,就将key和计算出来的值put进去
        String s1 = map.get(20);
        System.out.println(s1);//21

        map.computeIfPresent(20,(i,v)->i+"#"+v); //如果存在key,就将计算出来的值覆盖原来的value ,如果计算出来的新值等于null,就 remove(key);
        s1 = map.get(20);
        System.out.println(s1);//20#21

        boolean remove = map.remove(20, "21"); //false, 移除键值全都匹配的项
//        remove = map.remove(20, "20#21"); //true

        String orDefault = map.getOrDefault(42, "not found"); //如果找不到，返回设置的默认值
        System.out.println(orDefault);

        map.merge(20,"12313",(oldValue,newValue)->oldValue.concat(newValue));// 合并当前key的old 值和新传进来的值 传给后面的 ld表达式进行处理后，重新put进去
        String s2 = map.get(20);
        System.out.println(s2);
    }
}
