package jdkcontext;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhong on 2016/9/14.
 */
public class StringDemo {
    public StringDemo(){
        System.out.println("StringDemo()");
    }

    @Test
    public void testE(){
        String a="adfer33";
        String b=null;
        System.out.println(a==b); //true

        final Map c=new HashMap();


        System.out.println(a.hashCode());//-1146221840
        System.out.println(System.identityHashCode(a));//249253794
    }

    /**
     * 编译时优化：优化前提是不会影响整体功能
     * @return
     */
    public String getA() { return "a"; }
    @Test
    public void testjvm(){
        String a="a";
        final String c="a";
//        c="a";  //报错

        String b=a+"b";
        String d =c+"b";
        String e = getA()+"b";

        String compare="ab";
        System.out.println(b==compare);//false  a是一个变量，值是有可能改变的
        System.out.println(d==compare);//true  因为c是final的不可变的，
        System.out.println(e==compare);//false 编译器不会去看方法返回的是否是什么

    }

    /**
     * 常量池：
     */
    @Test
    public  void testConstantPool(){
        /**
         *  String 常量池。用=号会从常量池中取，
         *  intern()方法：如果池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。
         *              否则，将此 String 对象添加到池中，并返回此 String 对象的引用。
         */
        String a="a";
        String b=a+"b";
        String c="ab";
        String d = new String(b);
        System.out.println(b==c); //false
        System.out.println(c==d); //false
        System.out.println(c==d.intern()); //true
        System.out.println(b.intern()==d.intern());//true


        /**
         * Integer Long 的内部有一个常量池 -128到127
         * a=1 自动装箱编译后变成 a=valueOf（1）,而valueOf()方法是会从常量池中取
         */

        Integer a1=1;
        Integer b1=1;
        System.out.println(a1==b1); //true

        a1=128;
        b1=128;
        System.out.println(a1==b1);//false

        a1=new Integer(1);
        b1=new Integer(1);
        System.out.println(a1==b1);//false

        a1=Integer.valueOf(1);
        b1=Integer.valueOf(1);
        System.out.println(a1==b1); //true

        a1=Integer.valueOf(128);
        b1=Integer.valueOf(128);
        System.out.println(a1==b1); //false


    }





}
