package com.gaven.pattern.FactoryTest.FactoryMethod;

public class ConcreProduct implements Product {
    @Override
    public void speak() {
        System.out.println(" i am a ConcreteProduct");
    }
}
