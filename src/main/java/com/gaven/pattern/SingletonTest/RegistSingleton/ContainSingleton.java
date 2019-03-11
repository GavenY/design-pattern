package com.gaven.pattern.SingletonTest.RegistSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 容器注册单例，Spring中的做法，就是用这种注册式单例,方便管理实例，懒汉式加载，线程不安全需要syn
public class ContainSingleton {

    private  ContainSingleton(){}

    public  static Map<String,Object> ioc = new ConcurrentHashMap<>();


    public static  Object getInstance(String name){
        synchronized (ioc) {
            if (!ioc.containsKey(name)) {
                Object obj = null;
                try {
                    obj = Class.forName(name).newInstance();
                    ioc.put(name, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return obj;
            }

            return ioc.get(name);
        }
    }

}
