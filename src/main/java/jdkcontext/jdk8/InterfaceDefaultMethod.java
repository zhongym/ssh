package jdkcontext.jdk8;

/**
 * 接口默认方法
 *
 * Created by zhong on 2016/11/8.
 */

interface A{
    void methodA();

    /**
     * 接口默认方法
     */
    default void methodB(){
        System.out.println("methodB()");
    }

    static void methodC(){
        System.out.println("methodC");
    }
}

public class InterfaceDefaultMethod  {
    public static void main(String[] args) {
        A a=new A(){
            @Override
            public void methodA() {
                System.out.println("methodA()");
            }
        };

        a.methodA();
        a.methodB();
        A.methodC();
    }
}
