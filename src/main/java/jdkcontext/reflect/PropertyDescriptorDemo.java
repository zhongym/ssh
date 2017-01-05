package jdkcontext.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by zhong on 2016/11/3.
 */

class User{
    private String userName;
    private int age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class PropertyDescriptorDemo {
    public static void main(String[] args) throws IntrospectionException {
        Field[] fields = User.class.getDeclaredFields();
        for (Field field:fields) {
            if(Modifier.isStatic(field.getModifiers())){
                return;
            }
            PropertyDescriptor descriptor=new PropertyDescriptor(field.getName(),User.class);
            System.out.println("getDisplayName="+descriptor.getDisplayName());
            System.out.println("getShortDescription="+descriptor.getShortDescription());
            System.out.println(descriptor.getPropertyEditorClass());
            System.out.println(descriptor.getPropertyType());
            System.out.println(descriptor.getWriteMethod());
            System.out.println(descriptor.getReadMethod());
        }
    }

}
