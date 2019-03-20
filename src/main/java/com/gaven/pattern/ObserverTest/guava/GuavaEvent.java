package com.gaven.pattern.ObserverTest.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void Subscribe(String str){

        System.out.println("执行Subscribe 方法， 传入的 ： "+str);
    }

}
