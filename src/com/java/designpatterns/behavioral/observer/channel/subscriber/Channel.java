package com.java.designpatterns.behavioral.observer.channel.subscriber;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String title;

    public void addSubScriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubScriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notify(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public void uploadNewVideo(String title) {
        this.title = title;
        notify("New Video Upload: " + title);
    }
}
