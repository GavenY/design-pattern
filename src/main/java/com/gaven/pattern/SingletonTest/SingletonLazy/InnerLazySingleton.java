package com.gaven.pattern.SingletonTest.SingletonLazy;

//性能最优的写法。无需synchronized同步线程安全，也是被调时才创建
public class InnerLazySingleton {


    private   InnerLazySingleton(){

        //防止反射实例对象
        if(LazyHolder.LAZY_SINGLETON != null){
            throw new RuntimeException("不允许创建多个实例");
        }

    }
    //默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的


    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //final保证这个方法不会被重写，重载
    public  static  final  InnerLazySingleton getInstance(){

        return LazyHolder.LAZY_SINGLETON;
    }


    //默认不加载
    private  static  class  LazyHolder{


        private  static  final InnerLazySingleton  LAZY_SINGLETON  =  new InnerLazySingleton();
    }

}
