package jdkcontext.cu;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhongym on 2017/3/28.
 */

class Task implements Runnable{
    private final CountDownLatch countDownLatch;
    private List<String> list = new ArrayList<>();
    Task(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
//        long startTime = System.currentTimeMillis();
//        while (System.currentTimeMillis()-startTime<1000) {
            list.add(BillUtils.genSerialCode());
//        }

//        System.out.println(Thread.currentThread().getName()+"-完成");
        countDownLatch.countDown();
    }

    public List<String> getList() {
        return list;
    }
}

public class Demo {
//    public static void main(String[] args) throws IOException, InterruptedException {
//
//        long startTime = System.currentTimeMillis();
//        List<String> list = new ArrayList<>();
//        while (System.currentTimeMillis()-startTime<1000) {
//            list.add(BillUtils.genSerialCode());
//        }
//
//        System.out.println(Thread.currentThread().getName()+"-完成");
//
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File("out")));
//            for(String s:list){
//                fileWriter.write(s);
//                fileWriter.newLine();
//            }
//            fileWriter.flush();
//        fileWriter.close();
//    }
    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        List<Task> tasks = new ArrayList<>();
        for (int i=0;i<=1000;i++){
            Task task = new Task(countDownLatch);
            executorService.submit(task);
            tasks.add(task);
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("完成:"+(System.currentTimeMillis()-startTime));

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File("out")));
        for(Task task:tasks){
            for(String s:task.getList()){
                fileWriter.write(s);
                fileWriter.newLine();
            }
            fileWriter.flush();
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
