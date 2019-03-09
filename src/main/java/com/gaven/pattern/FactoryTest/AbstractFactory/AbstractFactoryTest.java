package com.gaven.pattern.FactoryTest.AbstractFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = new XiMiFactory();

        Moblie moblie = abstractFactory.getMoblie();
        TV tv = abstractFactory.getTV();

        moblie.show();
        tv.show();
    }

}
