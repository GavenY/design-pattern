package com.gaven.pattern.FactoryTest.SimpleFactory;

public class simpleMiFactory {


    public  static  Moblie getMobile(String name) {

        Moblie moblie = null;

        try {
            Class<?> clzss =   Class.forName(name);
            moblie = (Moblie) clzss.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return moblie;
    }

}
