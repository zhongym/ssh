package jdkcontext.thread;

/**
 * Created by zhong on 2016/10/18.
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                synchronized (SynchronizedDemo.class){
                    System.out.println("aaa");
                   throw  new RuntimeException("");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (SynchronizedDemo.class){
                    System.out.println("bbbb");
                }
            }
        }.start();

    }
}
