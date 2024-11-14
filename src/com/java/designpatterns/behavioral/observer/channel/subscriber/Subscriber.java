package com.java.designpatterns.behavioral.observer.channel.subscriber;

public class Subscriber {
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(this.name + ": " + message );
    }

    public void subscribeChannel(Channel channel) {
        this.channel = channel;
    }
}
