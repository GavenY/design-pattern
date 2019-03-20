package com.gaven.pattern.ObserverTest.guava.gper;


import com.google.common.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Gper {

    String name = "咕泡生态圈";

    private Gper(){}

    public static Gper gper = null;
    private static EventBus eventBus = new EventBus();

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


    }

    public void publishQuestion(Question question,List<Teacher> teachers){

        System.out.println(question.getQname()+"在"+getName()+"提问"+question.getQuestion());
        for (Teacher teacher:teachers) {
            eventBus.register(teacher);
        }

        Map<String,Object> map = new HashMap<>();
        map.put("gper",gper);
        map.put("question",question);

        eventBus.post(map);
    }


}
