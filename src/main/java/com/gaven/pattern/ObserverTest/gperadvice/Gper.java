package com.gaven.pattern.ObserverTest.gperadvice;

import java.util.Observable;

/**
 *  jdk 自带的观察模式， 被观察者。继承Observable，调用通知方法时,先修改被观察者的状态 setChange（）,然后notifyOberver（），通知观察者
 */
public class Gper extends Observable{

    String name = "咕泡生态圈";

    private Gper(){}

    public static Gper gper = null;

    public static Gper getInstance(){
        if(gper == null){
            gper = new Gper();
        }

        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){

        System.out.println(question.getQname()+"在"+getName()+"提问"+question.getQuestion());

        setChanged();
        notifyObservers(question);

    }
}
