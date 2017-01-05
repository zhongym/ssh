package jdkcontext;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by zhong on 2016/9/19.
 */
public class CharSetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        String a="钏加压苛";
        System.out.println(a);
        byte[] bytes = a.getBytes("utf-8");

        String gbk = new String(bytes, "gbk");
        System.out.println(gbk);

        String utf = new String(gbk.getBytes("gbk"), "utf-8");
        System.out.println(utf);

//        char c='钟';
        Thread.sleep(1500000);

        System.gc();
        System.out.println(Charset.defaultCharset());//输出默认的字符集

                ByteBuffer bn=null;

    }
}
