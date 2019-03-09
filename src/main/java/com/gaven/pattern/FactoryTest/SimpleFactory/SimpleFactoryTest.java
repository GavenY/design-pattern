package com.gaven.pattern.FactoryTest.SimpleFactory;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        Moblie moblie = simpleMiFactory.getMobile("com.gaven.pattern.FactoryTest.SimpleFactory.XiMi8");

        moblie.show();
    }
}
