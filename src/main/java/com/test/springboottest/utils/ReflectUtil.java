package com.test.springboottest.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 5:32 PM 2018/10/18
 * @ Description：
 * @ Modified By：
 */
public class ReflectUtil {

//    public static void main(String[] args) {
//
//    }

    public static void getPropFromAnotherClass(Object source,Object target){
        Method  method=null;
        Field[] fields=source.getClass().getDeclaredFields();//获取源中所有属性

        for (int i = 0; i < fields.length; i++) {
            Field field=fields[i];//属性
            String fieldName=field.getName();//属性名
            String fieldNameUp=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            String getMethod="get"+fieldNameUp;//get方法名
            String setMethod="set"+fieldNameUp;//set方法名
            method=null;

            try {
                try {
                    method=target.getClass().getMethod(setMethod, (Class<?>) field.getGenericType());
                } catch (NoSuchMethodException e) {
                    method=target.getClass().getSuperclass().getMethod(setMethod, (Class<?>) field.getGenericType());
                }
            } catch (NoSuchMethodException e) {
                System.out.println(fieldName+"不需要设置...");
            }

            if(method!=null){
                Object val=null;
                try {
                    val=source.getClass().getDeclaredMethod(getMethod).invoke(source);
                } catch (Exception e) {
                    System.out.println("调用get方法失败");
                    e.printStackTrace();
                }

                try {
                    if(val!=null)
                        method.invoke(target,val);
                } catch (Exception e) {
                    System.out.println("调用set方法失败");
                    e.printStackTrace();
                }
            }
        }
    }
}
