package 大话设计模式.策略模式.context;

import 大话设计模式.策略模式.strategies.MemberStrategy;

import java.util.*;

/**
 * Created by zhongym on 2017/3/20.
 */
public class Price {
    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double calcPrice(double price){
        return memberStrategy.calcPrice(price);
    }

    public static void main(String[] args) {
        HashSet<Long> set = new HashSet<>();
        set.add(null);
//        set.add(null);
//        set.add(1L);
//        System.out.println(set);

        Map<String,String> map = new HashMap<>();
        map.put(null,null);
        map.put(null,null);
        map.put("a","b");
        System.out.println(map);

        Map<String,String> table = new Hashtable<>();
        table.put(null,"s");
        map.put("a","a");
        System.out.println(table);

    }
}
