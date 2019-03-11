package com.gaven.pattern.SingletonTest.ThreadLocal;

//注册性容器单例，线程为key，对象为value,    threadLocalInstance.get() 时会根据key获取 intance，
//伪线程安全，同线程相同实例，不同线程实例不同
//hreadLocal则用于线程间的数据隔离 。多数据源的实现
public class ThreadLocalSingleton {

    private  ThreadLocalSingleton(){}

    private  static  final  ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };


    public  static  ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
