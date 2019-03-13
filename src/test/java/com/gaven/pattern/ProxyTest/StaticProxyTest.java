package com.gaven.pattern.ProxyTest;

import com.gaven.pattern.ProxyTest.simpleproxy.Proxy;
import com.gaven.pattern.ProxyTest.simpleproxy.RealSubject;

public class StaticProxyTest {

    public static void main(String[] args) {
        Proxy proxy  = new Proxy(new RealSubject());

        proxy.request();
    }
}
