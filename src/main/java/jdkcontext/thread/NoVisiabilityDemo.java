package jdkcontext.thread;

/**
 * Created by zhong on 2016/10/11.
 * 在同一对象内部，一个线程将该对象的属性修改后，另一个线程不会马上能够访问，因为每个对象内部都有该对象的副本，不会每次都会到主内存中读取
 * 如果该属性添加了volatile字段，或者在while中添加THread.yield() System.out.println(); 程序就可以正常退出，否则子线各会一直while()
 */
public class NoVisiabilityDemo {
    private static class ReadThread extends Thread{
        private volatile boolean ready;
        private int number;
        @Override
        public void run() {
            while (!ready) {
                number++;
//                Thread.yield();
//                System.out.println();
            }
            System.out.println(ready);
        }

        public void setReadyOn(){
            this.ready=true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread=new ReadThread();
        readThread.start();
        Thread.sleep(200);
        readThread.setReadyOn();
        System.out.println(readThread.ready);
    }
}
