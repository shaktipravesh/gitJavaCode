package com.java.designpatterns.behavioral.observer.stock.notification.Observable;

import com.java.designpatterns.behavioral.observer.stock.notification.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifySubscribers(int stockAdded);
    public void setStockCount(int stockAdded);
    public int getStockCount();
}
