package com.gaven.pattern.ProxyTest.DynamicProxyTest.jdkProxy;


import com.gaven.pattern.ProxyTest.Person;

/**
 * Created by Tom on 2019/3/10.
 */
public class Girl implements Person {


    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
