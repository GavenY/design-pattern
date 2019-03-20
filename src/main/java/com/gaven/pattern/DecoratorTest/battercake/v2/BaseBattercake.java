package com.gaven.pattern.DecoratorTest.battercake.v2;

public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }

}
