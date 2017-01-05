package jdkcontext.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhong on 2016/9/19.
 *
 * 服务器
 */
class MySocket implements Runnable{
    Socket socket;
    MySocket(Socket socket){
        this.socket=socket;

    }

    @Override
    public void run() {
        SocketWrapper socketWrapper=null;
        try {
            socketWrapper=new SocketWrapper(socket);
            String line = socketWrapper.readLine();
            while (!"bye".equals(line)){
                System.out.println("clinet1"+Thread.currentThread().getName()+":"+line);
                socketWrapper.writeLine("SocketServer receive:"+line);
                line=socketWrapper.readLine();
            }
            socketWrapper.writeLine("close");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socketWrapper!=null)
                socketWrapper.close();
        }
    }
}

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            System.out.println("SocketServer stared----------");
            while (true){
                executorService.execute(new MySocket(serverSocket.accept()));
//                System.out.println("启动一个客户端");
            }
        }finally {
            serverSocket.close();
        }
    }
}
