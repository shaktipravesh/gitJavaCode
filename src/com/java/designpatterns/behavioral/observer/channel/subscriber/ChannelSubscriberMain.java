package com.java.designpatterns.behavioral.observer.channel.subscriber;

public class ChannelSubscriberMain {
    public static void main(String[] args) {
        Channel ch = new Channel();
        Subscriber subscriber1 = new Subscriber("Shakti");
        Subscriber subscriber2 = new Subscriber("Pravesh");
        Subscriber subscriber3 = new Subscriber("Suhasini");
        Subscriber subscriber4 = new Subscriber("Rathore");
        Subscriber subscriber5 = new Subscriber("Vincit");
        Subscriber subscriber6 = new Subscriber("Beena");

        ch.addSubScriber(subscriber1);
        ch.addSubScriber(subscriber2);
        ch.addSubScriber(subscriber3);
        ch.addSubScriber(subscriber4);
        ch.addSubScriber(subscriber5);
        ch.addSubScriber(subscriber6);

        subscriber1.subscribeChannel(ch);
        subscriber2.subscribeChannel(ch);
        subscriber3.subscribeChannel(ch);
        subscriber4.subscribeChannel(ch);
        subscriber5.subscribeChannel(ch);
        subscriber6.subscribeChannel(ch);

        ch.uploadNewVideo("Panchayat Season 4");

    }
}
