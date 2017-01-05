package jdkcontext.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhong on 2016/9/19.
 * 对Socket进行一下包装
 *
 */
public class SocketWrapper {

    private final Socket socket;
    private final BufferedReader inputReader;
    private final BufferedWriter outputWriter;

    public SocketWrapper(Socket socket) throws IOException {
        this.socket=socket;
        this.inputReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        this.outputWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF8"));
    }

    public String readLine() throws IOException {
        return inputReader.readLine();
    }

    public void writeLine(String line) throws IOException {
        outputWriter.write(line);
        outputWriter.newLine();
        outputWriter.flush();
    }

    public void close(){
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
