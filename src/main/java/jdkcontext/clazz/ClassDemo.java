package jdkcontext.clazz;

import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongym on 2017/2/4.
 */

 interface InterfaceA{

}

class ClassA implements InterfaceA{

}

public class ClassDemo {


    private int a;
    private Integer b;

    public static void main(String[] args) {
//        Class<? extends InterfaceA> aClass = ClassA.class.asSubclass(InterfaceA.class);
//        System.out.println(aClass);
//
//        ClassA a=new ClassA();
//        InterfaceA cast = InterfaceA.class.cast(a);
//        System.out.println(cast);
//
//        boolean isInstance = InterfaceA.class.isInstance(a);
//        System.out.println(isInstance);
//
//        Object[] signers = a.getClass().getSigners();
//        System.out.println(signers);
//
//        ProtectionDomain protectionDomain = a.getClass().getProtectionDomain();
//        System.out.println(protectionDomain);
//
//        boolean primitive = a.getClass().isPrimitive();
//        System.out.println(primitive);
//
//        boolean synthetic = a.getClass().isSynthetic();
//        System.out.println(synthetic);
//
//        System.out.println(Long.TYPE);
//        System.out.println(Long.class);
         int a = 0;
         Integer b = null;

        System.out.println(a);
        System.out.println(b);

        ClassDemo classDemo = new ClassDemo();
        System.out.println(classDemo.a);
    }
}
