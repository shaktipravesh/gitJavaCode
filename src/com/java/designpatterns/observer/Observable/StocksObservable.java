package com.java.designpatterns.observer.Observable;

import com.java.designpatterns.observer.Observer.NotificationAlertObserver;

import java.util.Observer;

public interface StocksObservable {
    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifySubscribers(int stockAdded);
    public void setStockCount(int stockAdded);
    public int getStockCount();
}
