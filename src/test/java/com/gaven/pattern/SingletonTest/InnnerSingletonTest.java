package com.gaven.pattern.SingletonTest;

import com.gaven.pattern.SingletonTest.SingletonLazy.InnerLazySingleton;

import java.lang.reflect.Constructor;

public class InnnerSingletonTest {

   /* public static void main(String[] args) {

        try {
        Class<?> clazz = InnerLazySingleton.class;

        //clazz.newInstance();  构造器私有化，无法直接new

        //通过反射拿到私有的构造方
            Constructor c = clazz.getDeclaredConstructor(null);

            //强制访问，访问私有类
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        //System.out.println(InnerLazySingleton.i);

        InnerLazySingleton.getInstance();
    }
}
