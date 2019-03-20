package com.gaven.pattern.ObserverTest.guava;

import com.google.common.eventbus.EventBus;

public class EventTest {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        eventBus.register(new GuavaEvent());

        eventBus.post("tom");

    }
}
