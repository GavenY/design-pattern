package com.gaven.pattern.ObserverTest.guava.gper;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuavaGPerTest {

    public static void main(String[] args) {

        Gper gper = Gper.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        Question question = new Question();
        question.setQname("小明");
        question.setQuestion("观察者设计模式适用于哪些场景？");


        List<Teacher> teacherss = new ArrayList<>();
        teacherss.add(tom);
        teacherss.add(mic);

        gper.publishQuestion(question,teacherss);








    }
}
