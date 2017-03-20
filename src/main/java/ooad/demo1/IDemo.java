package ooad.demo1;

/**
 * Created by zhongym on 2017/3/16.
 */
public interface IDemo {
    void method1();

    default void method2(){
        System.out.printf("aa");
    }

    static void method3(){
        System.out.printf("aa");
    }

    class C{
        public static void methodCc(){
            System.out.println("C.methodCc()");
        }
    }
}

class A implements IDemo{
    public static void main(String[] args) {

    }

    @Override
    public void method1() {
        System.out.println("A");
    }

    public static void methodA(){
        System.out.println("A");
    }

}


class B extends A{
    public void method1() {
        System.out.println("B");
    }

    public static void methodA(){
        System.out.println("B");
    }

    public static void main(String[] args) {
        IDemo.C.methodCc();

        B.methodA();
        new B().method1();
    }
}
