package jdkcontext;

import org.junit.Test;

/**
 * Created by zhong on 2016/9/23.
 */
public class InnerClass {
    public static int aa=0;
    public int cc=0;
    @Test
    public void test(){
        new A().test();
        new A().a=0;
//        new A().c=0;
    }


     public  class A{
//        private static int c=0;
        private int a=0;
        private void test(){
            aa=20;
            InnerClass.this.cc=20;
        }
    }
}
