package com.java.designpatterns.observer.Observer;

import com.java.designpatterns.observer.Observable.StocksObservable;

import java.util.Observer;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update(int stockCount) {
        if(stockCount == 0) {
            sendMail(emailId, "Email Alert: Product is out of stock.");
        } else {
            sendMail(emailId, "Email Alert: Product is available. Stock Count: " + stockCount);
        }
    }

    private void sendMail(String emailId, String message) {
        System.out.println("Sending mail to " + emailId + ": " + message);
    }
}
