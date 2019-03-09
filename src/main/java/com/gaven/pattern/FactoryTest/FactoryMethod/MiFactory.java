package com.gaven.pattern.FactoryTest.FactoryMethod;

public class MiFactory implements AbstractFactory {
    @Override
    public Product getInstance() {
        return new MobliePhone();
    }
}
