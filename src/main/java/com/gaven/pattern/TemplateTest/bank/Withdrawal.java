package com.gaven.pattern.TemplateTest.bank;


public class Withdrawal implements BankBusiness{

    private int num;

    @Override
    public int takeNumber() {
        num= (int)(Math.random()*10);
        System.out.println("领号"+num);
        return num;
    }

    @Override
    public boolean queue(int num) {
        return num==0?true:false;
    }

    @Override
    public void queueWait() {

        try {
            while(true){
                if(queue(num))
                    break;


                System.out.println("等待前面还有"+num);
                num--;

                Thread.sleep(1000);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void business() {

        System.out.println("取款成功");
    }
}
