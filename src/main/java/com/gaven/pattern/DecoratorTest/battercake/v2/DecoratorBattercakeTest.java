package com.gaven.pattern.DecoratorTest.battercake.v2;

public class DecoratorBattercakeTest {



    public static void main(String[] args) {

        Battercake battercake = new BaseBattercake();
        System.out.println(battercake.getMsg() + ",总价格：" + battercake.getPrice());

        battercake = new BattercakeEggDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg() + ",总价格：" + battercake.getPrice());

    }

}
