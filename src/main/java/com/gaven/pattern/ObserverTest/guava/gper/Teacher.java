package com.gaven.pattern.ObserverTest.guava.gper;


import com.google.common.eventbus.Subscribe;

import java.util.Map;


public class Teacher {

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

    @Subscribe
    public void update(Map<String,Object> map) {

        Gper gper = (Gper) map.get("gper");
        Question question = (Question) map.get("question");

        System.out.println("===============================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自“" + gper.getName() + "”的提问，希望您解答，问题内容如下：\n" +
                question.getQuestion() + "\n" +
                "提问者：" + question.getQname());
    }




}
