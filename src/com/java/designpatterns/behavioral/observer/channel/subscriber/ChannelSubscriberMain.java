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

        ch.addSubscriber(subscriber1);
        ch.addSubscriber(subscriber2);
        ch.addSubscriber(subscriber3);
        ch.addSubscriber(subscriber4);
        ch.addSubscriber(subscriber5);
        ch.addSubscriber(subscriber6);

        subscriber1.subscribeChannel(ch);
        subscriber2.subscribeChannel(ch);
        subscriber3.subscribeChannel(ch);
        subscriber4.subscribeChannel(ch);
        subscriber5.subscribeChannel(ch);
        subscriber6.subscribeChannel(ch);

        ch.uploadNewVideo("Panchayat Season 4");
        ch.removeSubscriber(subscriber1);
        System.out.println();

        ch.uploadNewVideo("Gullak Season 4");
        ch.removeSubscriber(subscriber2);
        System.out.println();

        ch.removeVideo("Panchayat Season 4");



    }
}
