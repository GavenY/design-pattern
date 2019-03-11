package com.gaven.pattern.SingletonTest;

public class LazyTest {

    public static void main(String[] args) {

//        System.out.println(SingletonLazy.getInstance());
//        System.out.println(SingletonLazy.getInstance());
//        System.out.println(SingletonLazy.getInstance());
//        System.out.println(SingletonLazy.getInstance());
//        System.out.println(SingletonLazy.getInstance());

        Thread thread1 = new Thread(new SingletonThread());
        Thread thread2 = new Thread(new SingletonThread());

        thread1.start();
        thread2.start();
    }
}
