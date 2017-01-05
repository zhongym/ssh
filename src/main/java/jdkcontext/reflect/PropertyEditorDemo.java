package jdkcontext.reflect;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by zhong on 2016/11/3.
 *
 *  通过反射PropertyDescriptor读取field的writeMethod方法设值时，会遇到类型转换问题
 *  一般都是从String转换成属性对应的类型，可以继续PropertyEditor来自定义自己的属性转换器
 *  spring 扩展了好多 PropertyEditor
 *      @InitBinder
        public void initBinder(WebDataBinder binder) {
              binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        }
 */

class String2DateEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
           setValue(dateFormat.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


public class PropertyEditorDemo {
    public static void main(String[] args) {
        String dateStr="2016-10-11";
        String2DateEditor string2Date=new String2DateEditor();
        string2Date.setAsText(dateStr);
        System.out.println(string2Date.getValue());
    }
}
