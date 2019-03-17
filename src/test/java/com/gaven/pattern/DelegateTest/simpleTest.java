package com.gaven.pattern.DelegateTest;

import com.gaven.pattern.DelegateTest.simple.Boss;
import com.gaven.pattern.DelegateTest.simple.Leader;

public class simpleTest {

    public static void main(String[] args) {


        Boss boss = new Boss();
        boss.command("登录",new Leader());

    }
}
