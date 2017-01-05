package jdkcontext.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhong on 2016/9/19.
 */

public class SocketClinet {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        SocketWrapper socketWrapper=new SocketWrapper(new Socket(InetAddress.getLocalHost(),8888));
        try {
            System.out.println("Clinet connented");
            String inMes = scanner.nextLine();
            socketWrapper.writeLine(inMes);
            String line = socketWrapper.readLine();
            while (!"close".equals(line)){
                System.out.println("clinet1 receive:"+line);
                inMes=scanner.nextLine();
                socketWrapper.writeLine(inMes);
                line=socketWrapper.readLine();
            }

        }finally {
            if(socketWrapper!=null)
                socketWrapper.close();
        }

    }
}
