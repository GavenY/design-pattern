package com.gaven.pattern.TemplateTest.bank;

public interface BankBusiness   {



    //java 1.8 新特性，接口利用default可以实现函数体，实现类可以继承重写
    default void execute(){

        System.out.println("小明取银行");

        int num = takeNumber();


            if(!queue(num)){

              queueWait();
          }
        System.out.println("轮到");
        business();

        System.out.println("吃大餐");
    }

    //取号
     int takeNumber();



    //排队
     boolean queue(int num);

     //等待
     void queueWait();

     //处理业务 存款/取款
     void business();

}
