package com.gaven.pattern.FactoryTest.AbstractFactory;

public class HuaWeiFactory implements AbstractFactory {
    @Override
    public Moblie getMoblie() {
        return null;
    }

    @Override
    public TV getTV() {
        return new HuaWei_TV();
    }
}
