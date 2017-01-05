package jdkcontext.thread;

/**
 * Created by zhong on 2016/10/8.
 * 线程多种状态的切换
 */
public class ThreadStatDemo {
    public static void main(String[] args) throws InterruptedException {
        final Object lok=new Object();
        new Thread(){
            @Override
            public void run() {
                synchronized (lok){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

       Thread thread= new Thread(){
            @Override
            public void run() {
                System.out.println("run()"+Thread.currentThread().getState().toString());//RUNNABLE start()后 正在运行状态
                synchronized (lok){
                    System.out.println("geted lok");
                    try {
                        lok.wait(); //释放锁（使得其他线程可以使用同步控制块或者方法） 等待锁通知
                        Thread.sleep(500);//  lok.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        System.out.println(thread.getState().toString());//NEW 线程对象刚new出来，还没调用start()方法
        thread.start();
        Thread.sleep(500);
        System.out.println(thread.getState().toString());//BLOCKED  当线程等待同步锁的时候

        Thread.sleep(600);
        System.out.println(thread.getState().toString());//WAITING 当线程获得锁对象进入代码区域后，
                                                        // 调用锁对象的wait() （LockSupport.park(),Thread.join()）方法

        synchronized (lok){
            lok.notify(); //通知线程向下执行
        }
        System.out.println(thread.getState().toString());//TIMED_WAITING 调用Thread.sleep(500) lok.wait(500); 线程等待

        Thread.sleep(1000);
        System.out.println(thread.getState().toString());//TERMINATED  线程结束
    }
}
