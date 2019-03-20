package com.gaven.pattern.ObserverTest.events;

import com.gaven.pattern.ObserverTest.events.mouseEvent.Mouse;
import com.gaven.pattern.ObserverTest.events.mouseEvent.MouseEventCallback;
import com.gaven.pattern.ObserverTest.events.mouseEvent.MouseEventType;

public class eventTest {

    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.click();
    }
}
