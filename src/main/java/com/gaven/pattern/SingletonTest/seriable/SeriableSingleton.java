package com.gaven.pattern.SingletonTest.seriable;

import java.io.Serializable;

/**
 * Created by Tom.
 */

//反序列化时导致单例破坏
public class SeriableSingleton implements Serializable {


    public  final static SeriableSingleton INSTANCE = new SeriableSingleton();
    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }


    // 重写readResolve(),覆盖反序列化出来的的对象，，还是创建了两次对象， 但是发生在jvm层较安全，之前的对象会被GC回收
    private  Object readResolve(){
        return  INSTANCE;
    }

}
