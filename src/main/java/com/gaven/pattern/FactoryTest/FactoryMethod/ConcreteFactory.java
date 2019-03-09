package com.gaven.pattern.FactoryTest.FactoryMethod;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public Product getInstance() {
        return new ConcreProduct();
    }
}
