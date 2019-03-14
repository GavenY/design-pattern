package com.gaven.pattern.PrototypeTest;

import java.util.List;

// 具体原型类 实现 抽象原型类Cloneable 接口
public class RealPrototype implements  Cloneable{

    //简单克隆只能克隆属性值，跟对象引用
    private String name;

    private List<String> list;

    RealPrototype()
    {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("克隆原型复制成功！");
        return (RealPrototype)super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
