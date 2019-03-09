package com.gaven.pattern.FactoryTest.AbstractFactory;


public interface AbstractFactory {

    //定义Factory的规范 提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。

    Moblie getMoblie();

    TV getTV();
}
