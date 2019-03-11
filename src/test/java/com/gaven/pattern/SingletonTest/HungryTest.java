package com.gaven.pattern.SingletonTest;

import com.gaven.pattern.SingletonTest.SingletonHungry.HungrySingleton;
import com.gaven.pattern.SingletonTest.SingletonLazy.DoubleCheckSingleton;

public class HungryTest {

    public static void main(String[] args) {

        System.out.println(HungrySingleton.getHungrySingleton());
        System.out.println(HungrySingleton.getHungrySingleton());
        System.out.println(HungrySingleton.getHungrySingleton());
        System.out.println(HungrySingleton.getHungrySingleton());
        System.out.println(HungrySingleton.getHungrySingleton());


    }
}
