package com.gaven.pattern.PrototypeTest.manager;

public interface Shape extends  Cloneable{

    Object clone();
    void countArea();
}
