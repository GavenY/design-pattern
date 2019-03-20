package com.gaven.pattern.DecoratorTest.battercake.v2;

public abstract class BattercakeDecorator extends  Battercake{


    //特殊的静态代理，委派模式
    private Battercake battercake;

    public  BattercakeDecorator(Battercake battercake){
        this.battercake = battercake;
    }


    protected  abstract void add();


    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
