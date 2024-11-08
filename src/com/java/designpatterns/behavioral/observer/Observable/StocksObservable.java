package com.java.designpatterns.behavioral.observer.Observable;

import com.java.designpatterns.behavioral.observer.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifySubscribers(int stockAdded);
    public void setStockCount(int stockAdded);
    public int getStockCount();
}
