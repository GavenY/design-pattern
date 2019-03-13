package com.gaven.pattern.ProxyTest;


import com.gaven.pattern.ProxyTest.DynamicProxyTest.GPProxy.MeipoGPProxy;
import com.gaven.pattern.ProxyTest.DynamicProxyTest.jdkProxy.Girl;

/**
 * Created by Tom on 2019/3/10.
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new MeipoGPProxy().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
