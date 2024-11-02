package com.java.designpatterns.observer.Observer;

import com.java.designpatterns.observer.Observable.StocksObservable;

import java.util.Observer;

public class MobileAlertObservableImpl implements NotificationAlertObserver {
    String userName;
    StocksObservable stocksObservable;
    public MobileAlertObservableImpl(String userName, StocksObservable stocksObservable) {
        this.userName = userName;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update(int stockCount) {
        if(stockCount == 0) {
            sendMessageOnMobile(userName, "Mobile Alert: Product is out of stock.");
        } else {
            sendMessageOnMobile(userName, "Mobile Alert: Product is available. Stock Count: " + stockCount);
        }
    }

    private void sendMessageOnMobile(String userName, String message) {
        System.out.println("Sending message to " +userName + " : " + message);
    }
}
