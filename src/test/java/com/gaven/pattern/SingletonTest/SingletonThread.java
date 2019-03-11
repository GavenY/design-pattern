package com.gaven.pattern.SingletonTest;

import com.gaven.pattern.SingletonTest.SingletonLazy.DoubleCheckSingleton;
import com.gaven.pattern.SingletonTest.SingletonLazy.InnerLazySingleton;
import com.gaven.pattern.SingletonTest.SingletonLazy.SingletonLazy;

public class SingletonThread implements Runnable {


    @Override
    public void run() {

        //SingletonLazy singleton = SingletonLazy.getInstance();


//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
       // System.out.println(Thread.currentThread().getName() + ":" + singleton);


//        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + doubleCheckSingleton);


        InnerLazySingleton  innerLazySingleton = InnerLazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + innerLazySingleton);

    }
}
