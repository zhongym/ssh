package jdkcontext.thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * i=1
 * 10个线程并发i++
 * 每个线程100次
 * 正确结果应该是 1001
 *
 * 如果没做好并发处理，结果往往比1001小
 *
 */
public class AtomicIntegerTest {
    /**
     *AtomicInteger 可以用原子方式更新的 int 值。有关原子变量属性的描述，请参阅 java.util.concurrent.atomic 包规范。AtomicInteger 可用在应用程序中（如以原子方式增加的计数器），并且不能用于替换 Integer。但是，此类确实扩展了 Number，允许那些处理基于数字类的工具和实用工具进行统一访问。
     *int addAndGet(int delta)以原子方式将给定值与当前值相加。
     boolean compareAndSet(int expect, int update)如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
     int decrementAndGet()以原子方式将当前值减 1。
     double doubleValue()以 double 形式返回指定的数值。
     float floatValue()以 float 形式返回指定的数值。
     int get()获取当前值。
     int getAndAdd(int delta)以原子方式将给定值与当前值相加。
     int getAndDecrement()以原子方式将当前值减 1。
     int getAndIncrement()以原子方式将当前值加 1。
     int getAndSet(int newValue)以原子方式设置为给定值，并返回旧值。
     int incrementAndGet()以原子方式将当前值加 1。

     */
    static class AtomicTest{
        public  static AtomicInteger integer=new AtomicInteger(1);
        private static int integer2=1;
        public static void run() throws InterruptedException {
            final CountDownLatch startCountDown=new CountDownLatch(1);
            final Thread[] threads=new Thread[10];
            for(int i=0;i<10;i++){
                threads[i]=new Thread(){
                    @Override
                    public void run() {
                        try {
                            startCountDown.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        for (int j=0;j<100;j++){
                            integer.incrementAndGet();//增加一，返回增加后的值
                            integer2++;
                        }
                    }
                };
                threads[i].start();
            }

            Thread.sleep(1000);
            startCountDown.countDown();
            for (Thread t:threads){
                t.join();
            }

            System.out.println("AtomicTest结果："+integer.get());
            System.out.println("AtomicTest index 结果："+integer2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicTest.run();
    }

}
