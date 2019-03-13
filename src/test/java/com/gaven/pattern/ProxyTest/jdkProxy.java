package com.gaven.pattern.ProxyTest;

import com.gaven.pattern.ProxyTest.DynamicProxyTest.jdkProxy.Girl;
import com.gaven.pattern.ProxyTest.DynamicProxyTest.jdkProxy.MeipoJdkProxy;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class jdkProxy {

    public static void main(String[] args) {

        try{
            Object obj = new MeipoJdkProxy().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove",null);
            method.invoke(obj);

                        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
