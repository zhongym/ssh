package jdkcontext;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * Created by zhong on 2016/9/20.
 */
public class ClassLoader {
    public static void main(String[] args) throws IOException {
        /**
         * 输出当前类来自哪个jar包
         */
        String path = StringUtils.class.getResource("").getPath();
        System.out.println(path);

        BufferedInputStream resourceAsStream = (BufferedInputStream) ClassLoader.class.getClassLoader().getResourceAsStream("appConfig.local.properties");
        BufferedReader br=new BufferedReader(new InputStreamReader(resourceAsStream));
        System.out.println(new String(br.readLine().getBytes("utf-8"),"utf-8"));

    }
}
