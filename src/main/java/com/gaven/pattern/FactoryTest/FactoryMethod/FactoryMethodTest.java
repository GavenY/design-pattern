package com.gaven.pattern.FactoryTest.FactoryMethod;

public class FactoryMethodTest {



    public static void main(String[] args) {
        AbstractFactory ab = new MiFactory();

        Product mobliePhone = ab.getInstance();
        mobliePhone.speak();

        try {
            Class<?> t = Class.forName("com.gaven.pattern.FactoryTest.FactoryMethod.HorseFarm");
            t.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }



}
