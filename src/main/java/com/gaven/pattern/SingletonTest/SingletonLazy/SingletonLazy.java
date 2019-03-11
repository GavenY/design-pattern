package com.gaven.pattern.SingletonTest.SingletonLazy;


//懒汉单例模式，使用时创建，但是存在多线程安全问题
public class SingletonLazy {

    public  static  SingletonLazy singletonLazy = null;

    private static boolean flag = true;

    private SingletonLazy(){


        if(flag){
            flag = !flag;
        }else{
            throw new RuntimeException("不能创建多个实例");
        }





    }

    public static synchronized  SingletonLazy getInstance(){
        if(singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }

        return singletonLazy;
    }



}
