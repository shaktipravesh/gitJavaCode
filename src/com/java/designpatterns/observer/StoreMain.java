package com.java.designpatterns.observer;

import com.java.designpatterns.observer.Observable.StocksObservableImpl;
import com.java.designpatterns.observer.Observable.StocksObservable;
import com.java.designpatterns.observer.Observer.EmailAlertObserverImpl;
import com.java.designpatterns.observer.Observer.MobileAlertObservableImpl;
import com.java.designpatterns.observer.Observer.NotificationAlertObserver;

public class StoreMain {
    public static void main(String[] args) {
        StocksObservable mobileStockObservable = new StocksObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("shaktipravesh@gmail.com", mobileStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("rathorebeena@gmail.com", mobileStockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("shaktipravesh@yahoo.co.in", mobileStockObservable);

        NotificationAlertObserver observerMobile = new MobileAlertObservableImpl("9910337716", mobileStockObservable);

        mobileStockObservable.addObserver(observer1);
        mobileStockObservable.addObserver(observer2);
        mobileStockObservable.addObserver(observer3);
        mobileStockObservable.addObserver(observerMobile);

        mobileStockObservable.setStockCount(4);
        System.out.println();
        mobileStockObservable.setStockCount(3);
        System.out.println();
        mobileStockObservable.setStockCount(-7);
        System.out.println();
        mobileStockObservable.removeObserver(observer1);
        mobileStockObservable.setStockCount(3);
        System.out.println("Stock Count: " + mobileStockObservable.getStockCount());

    }
}
