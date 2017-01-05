package jdkcontext;

/**
 * java 内部类初始化时机
 */
public class JavaInnerClassInitTime {

    private JavaInnerClassInitTime(){
        System.out.println("JavaInnerClassInitTime()");
    }

    private static class InnerClass{
        private static final JavaInnerClassInitTime javaInnerClassInitTime=new JavaInnerClassInitTime();
    }

    public static JavaInnerClassInitTime getInstace(){
        return  InnerClass.javaInnerClassInitTime;
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        new InnerClass();
       Class.forName("JavaInnerClassInitTime");
        System.out.println("---------------------");
        JavaInnerClassInitTime.getInstace();
    }

}
