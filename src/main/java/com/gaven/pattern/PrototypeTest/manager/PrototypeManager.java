package com.gaven.pattern.PrototypeTest.manager;

import java.util.HashMap;

//原型模式管理器
public class PrototypeManager {

    private HashMap<String, Shape>ht=new HashMap<String,Shape>();

    public PrototypeManager()
    {
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
    }
    public void addshape(String key,Shape obj)
    {
        ht.put(key,obj);
    }
    public Shape getShape(String key)
    {
        Shape temp=ht.get(key);
        return (Shape) temp.clone();
    }


}
