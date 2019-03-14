package com.gaven.pattern.PrototypeTest;

import java.util.ArrayList;
import java.util.List;

public class RealPrototypeTest {

    public static void main(String[] args) {


        try{
            RealPrototype realPrototype = new RealPrototype();
            realPrototype.setName("NO");
            List<String> list = new ArrayList<>();
            list.add("gaven");
            realPrototype.setList(list);
            RealPrototype clonePrototype = (RealPrototype)realPrototype.clone();

            System.out.println(realPrototype == clonePrototype);//false
            System.out.println(realPrototype.getName() == clonePrototype.getName());//true
            System.out.println(realPrototype.getList() == clonePrototype.getList()); // true

            clonePrototype.setName("YES");
            System.out.println( clonePrototype.getName());//YES
            System.out.println( realPrototype.getName());//NO

            List<String> cloneList = clonePrototype.getList();
            cloneList.add("YJW");

            System.out.println(realPrototype.getList().size());// 2 具体原型对象被修改了
;        }catch (Exception e){

            e.printStackTrace();
        }




    }
}
