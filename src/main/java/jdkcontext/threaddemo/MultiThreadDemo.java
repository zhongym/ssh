package jdkcontext.threaddemo;

/**
 * Created by zhong on 2016/6/18.
 */
class Data{
    private ThreadLocal<Integer> numHodler=new ThreadLocal<Integer>();
    private int num;

    public int getNum() {
        return numHodler.get();
    }

    public void setNum(int num) {
        System.out.println(Thread.currentThread().getName()+" set:"+num);
//        this.num = num;
        numHodler.set(num);
    }
}


public class MultiThreadDemo {
    public static void main(String[] args){
        final Data data = new Data();
        final Data data2 = new Data();
        Thread thread = new Thread() {
            public void run() {
                data.setNum(10);
                data2.setNum(20);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " get:" + data.getNum());
                System.out.println(Thread.currentThread().getName() + " get:" + data2.getNum());
            }
        };

        Thread thread2 =  new Thread(){
            public void run() {
                data.setNum(100);
                data2.setNum(200);
                System.out.println(Thread.currentThread().getName()+" get:"+data.getNum());
            }
        };

        thread.start();
        thread2.start();
    }
}
