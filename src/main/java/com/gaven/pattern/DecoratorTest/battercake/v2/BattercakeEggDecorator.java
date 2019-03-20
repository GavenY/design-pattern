package com.gaven.pattern.DecoratorTest.battercake.v2;

public class BattercakeEggDecorator extends BattercakeDecorator {

    public BattercakeEggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void add(){

    }


    @Override
    protected String getMsg() {
        return super.getMsg()+"+一个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
