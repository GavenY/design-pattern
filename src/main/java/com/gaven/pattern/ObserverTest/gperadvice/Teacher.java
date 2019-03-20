package com.gaven.pattern.ObserverTest.gperadvice;

import java.util.Observable;
import java.util.Observer;

/**
 *  观察者,实现Observer接口的upadte() 方法
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {

        Gper gper = (Gper) o;

        Question question = (Question) arg;

        System.out.println("===============================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自“" + gper.getName() + "”的提问，希望您解答，问题内容如下：\n" +
                question.getQuestion() + "\n" +
                "提问者：" + question.getQname());
    }




}
