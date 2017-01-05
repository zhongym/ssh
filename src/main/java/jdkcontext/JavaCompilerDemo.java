package jdkcontext;

/**
 * Created by zhong on 2016/9/19.
 */
public class JavaCompilerDemo {
    public static void main(String[] args){
        a(1);
    }

    public static void a(int a){
        a++;
        b(a);
    }

    private static void b(int a) {


        a++;
        a(a);
    }
}
