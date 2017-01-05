package jdkcontext.nio.client;

import jdkcontext.nio.SocketWrapper;
import jdkcontext.nio.comm.FileUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import static jdkcontext.nio.comm.Commons.*;

/**
 * Created by zhong on 2016/10/8.
 */
public class ClientMain {

    public static void main(String []args) throws IOException {
        for(int i = 0 ; i < 5 ; i ++) {
            final String num = String.valueOf(i);
            new Thread(String.valueOf(i)) {
                public void run() {
                    SocketWrapper socketWrapper = null;
                    FileOutputStream stream = null;
                    try {
                        stream = new FileOutputStream("d:/temp/aaa" + num +".pdf");
                        socketWrapper = new SocketWrapper("localhost" , 8888);

                        println("已经连接上服务器端.....");
                        socketWrapper.write("我是线程：" + num , DEFAULT_MESSAGE_CHARSET);
                        byte []buffer = new byte[8192];
                        int len = socketWrapper.read(buffer);
                        while(len > 0) {
                            println("我是线程：" + num + " 我接受到数据，长度为：" + len);
                            stream.write(buffer , 0 , len);
                            len = socketWrapper.read(buffer);
                        }
                        //System.in.read();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }finally {
                        FileUtils.closeStream(stream , socketWrapper);
                    }
                }
            }.start();
        }

    }

    public void testSocketChannel() throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        socketChannel.connect(InetSocketAddress.createUnresolved("",8888));
        while (true){
            selector.select();
            for (SelectionKey key:selector.selectedKeys()){
                if(key.isConnectable()){

                }else if(key.isReadable()){

                }else if(key.isWritable()){

                }
            }
        }

    }
}
