package com.gaven.pattern.FactoryTest.AbstractFactory;

public class XiMiFactory implements AbstractFactory {
    @Override
    public Moblie getMoblie() {
        return new XiMi_Mobile();
    }

    @Override
    public TV getTV() {
        return new XiMi_TV();
    }
}
