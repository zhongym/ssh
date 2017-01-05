package jdkcontext.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 2016/10/11.
 */
public class FinalConstrutorTest {

    static ThreadLocal<String> threadLocal=new ThreadLocal<String>();

    static abstract class A{
        public A(){
            display();
        }

        protected abstract void display();
    }

    static class B extends A{
        private int INT=100;
        private final int FINAL_INT=100;
        private final Integer FINAL_INTEGER=100;
        private String STR1="abc";
        private final String FINAL_STR1="abc";
        private final String FINAL_STR2=new String("abc");
        private final List<String> FIANL_LIST=new ArrayList<String>();

        public B(){
            System.out.println("abc");
        }
        @Override
        protected void display() {
            System.out.println(INT);
            System.out.println(FINAL_INT);
            System.out.println(FINAL_INTEGER);
            System.out.println(STR1);
            System.out.println(FINAL_STR1);
            System.out.println(FINAL_STR2);
            System.out.println(FIANL_LIST);
        }
    }


    public static void main(String[] args) {
        threadLocal.set("afd");
        String s = threadLocal.get();
        new B();
    }
}
