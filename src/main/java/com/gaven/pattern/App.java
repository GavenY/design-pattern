package com.gaven.pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String cName = "com.gaven.pattern.FactoryTest.FactoryMethod.HorseFarm";

        try {
            Class<?> c = Class.forName(cName);
            Object obj=c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println( "Hello World!" );
    }
}
