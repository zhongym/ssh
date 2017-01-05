package jdkcontext.threaddemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhong on 2016/9/8.
 */

class ReadQueueTast implements Runnable {

    private final Queue<String> tast;
    private final boolean isFist;

    @Override
    public void run() {
        String context=null;
        while ((context=read())!=null){
//            System.out.println(Thread.currentThread().getName()+"===="+context);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private  String read() {
        String poll=null;
            if(isFist) {
                poll = ((LinkedList<String>) tast).removeFirst();
            }else{
                poll = ((LinkedList<String>) tast).removeLast();
            }
            if(poll!=null)
            System.out.println(Thread.currentThread().getName()+"===="+poll);
        return poll;
    }

    ReadQueueTast(Queue<String> tast,boolean isFist){
        this.tast=tast;
        this.isFist=isFist;
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
            System.setOut(new PrintStream(new FileOutputStream(new File("D://log.txt"))));
            LinkedList<String> tast=new LinkedList<String>();
            String a="ABCDEFGHIJKLNMOPQRSTUVWYZ";
            for ( char c:a.toCharArray()){
                tast.addFirst(new String(new char[]{c}));
            }

            new Thread(new ReadQueueTast(tast,true)).start();
            new Thread(new ReadQueueTast(tast,false)).start();
    }
}
