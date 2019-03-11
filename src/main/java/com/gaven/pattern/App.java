package com.gaven.pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        StringBuffer a = new StringBuffer("abc");
        StringBuffer b = new StringBuffer("abc");

        String e = new String("asd");
        String f = new String("asd");

        System.out.println(e==f);

        Integer c=128,d=128;

        System.out.println(c==d);//false
        System.out.println(c.equals(d));//true

        System.out.println(a==b);//false
        System.out.println(a.equals(b));//false

        System.out.println( "Hello World!" );
    }
}
