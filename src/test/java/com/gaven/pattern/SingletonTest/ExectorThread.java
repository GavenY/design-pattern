package com.gaven.pattern.SingletonTest;


import com.gaven.pattern.SingletonTest.ThreadLocal.ThreadLocalSingleton;

/**
 * Created by Tom.
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {
        //LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
       ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
