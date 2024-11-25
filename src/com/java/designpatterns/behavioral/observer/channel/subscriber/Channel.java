package com.java.designpatterns.behavioral.observer.channel.subscriber;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notify(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public void removeVideo(String Title) {
        if(titleList.contains(Title)) {
            titleList.remove(Title);
            notify("Removed video: " + Title);
        }
    }

    public void uploadNewVideo(String title) {
        titleList.add(title);
        notify("New Video Upload: " + title);
    }
}
