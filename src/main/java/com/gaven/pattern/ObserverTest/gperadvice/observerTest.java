package com.gaven.pattern.ObserverTest.gperadvice;

public class observerTest {

    public static void main(String[] args) {
        Gper gper = Gper.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");


        //这为没有@Tom老师
        Question question = new Question();
        question.setQname("小明");
        question.setQuestion("观察者设计模式适用于哪些场景？");

        //添加通知者
        gper.addObserver(tom);
        gper.addObserver(mic);

        //触发通知方法
        gper.publishQuestion(question);
    }
}
