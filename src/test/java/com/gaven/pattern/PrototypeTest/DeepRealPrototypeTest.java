package com.gaven.pattern.PrototypeTest;

import java.util.ArrayList;
import java.util.List;

public class DeepRealPrototypeTest {

    public static void main(String[] args) {


        try{
            DeepRealPrototype realPrototype = new DeepRealPrototype();
            realPrototype.setName("NO");
            List<String> list = new ArrayList<>();
            list.add("gaven");
            realPrototype.setList(list);
            DeepRealPrototype clonePrototype = realPrototype.clone();

            System.out.println(realPrototype == clonePrototype);//false
            System.out.println(realPrototype.getName() == clonePrototype.getName());//true
            System.out.println(realPrototype.getList() == clonePrototype.getList()); // false

            clonePrototype.setName("YES");
            System.out.println( clonePrototype.getName());
            System.out.println( realPrototype.getName());

            List<String> cloneList = clonePrototype.getList();
            cloneList.add("YJW");

            System.out.println(realPrototype.getList().size());// 1 具体原型对象没有被修改了
            System.out.println(clonePrototype.getList().size());//clone Prototype 的list 修改，但不影响原型对象
;        }catch (Exception e){

            e.printStackTrace();
        }




    }
}
