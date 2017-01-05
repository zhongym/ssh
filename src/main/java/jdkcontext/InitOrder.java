package jdkcontext;

/**
 * Created by zhong on 2016/3/30.
 */
class InitOrderParen{
    public final static  long l=l();
    public final static  StringDemo s=new StringDemo();
    public static int a=a();
    public  InitOrderParen(){
        System.out.println("InitOrderParen()");
    }
    static {
        System.out.println("InitOrderParen static{}");
    }

    {
        System.out.println("InitOrderParen {}");
    }

    public static long l(){
        System.out.println("InitOrderParen public final static  long l=");
        return 1;
    }

    public static int a(){
        System.out.println("InitOrderParen public static int a=");
        return 1;
    }
}


public class InitOrder extends  InitOrderParen{
    public  InitOrder(){
        System.out.println("InitOrder()");
    }
    static {
        System.out.println("static{}");
    }

    {
        System.out.println("{}");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        InitOrder instance = new InitOrder();
        /*输出
        InitOrderParen public final static  long l=
        StringDemo()
        InitOrderParen public static int a=
        InitOrderParen static{}
        static{}
        InitOrderParen {}
        InitOrderParen()
        {}
        InitOrder()
        */
//        Class.forName("jdkcontext.InitOrder");
        /* 输出
        InitOrderParen public final static  long l=
        StringDemo()
        InitOrderParen public static int a=
        InitOrderParen static{}
        static{}
        */
    }

}
