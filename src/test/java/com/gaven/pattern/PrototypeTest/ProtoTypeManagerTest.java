package com.gaven.pattern.PrototypeTest;

import com.gaven.pattern.PrototypeTest.manager.PrototypeManager;
import com.gaven.pattern.PrototypeTest.manager.Shape;

public class ProtoTypeManagerTest {

    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();

        Shape corcle  = (Shape) prototypeManager.getShape("Circle");
        corcle.countArea();

        Shape square  = (Shape) prototypeManager.getShape("Square");
        square.countArea();


    }
}
