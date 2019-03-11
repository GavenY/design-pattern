package com.gaven.pattern.SingletonTest.SingletonLazy;

public class DoubleCheckSingleton {

    public  volatile static DoubleCheckSingleton doubleCheckSingleton= null;

    private  DoubleCheckSingleton(){}

    //synchronized 保证线程安全问题但是影响性能
    public static   DoubleCheckSingleton getInstance(){

        //减少同步锁的使用，当doubleCheckSingleton不执行下面方法
        if(doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) { //同步

                if (doubleCheckSingleton == null) { //防止多个线程同时满足第一个不为null判断 doubleCheckSingleton 实例多次，浪费内存，
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;

    }

}
