package com.java.designpatterns.behavioral.observer.Observable;

import com.java.designpatterns.behavioral.observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class StocksObservableImpl implements StocksObservable {

    public List<NotificationAlertObserver> observersList = new ArrayList<NotificationAlertObserver>();
    public int stockCount = 0;

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers(int stockCount) {
        observersList.forEach(observer -> observer.update(stockCount));
    }

    @Override
    public void setStockCount(int stockAdded) {
        System.out.println("New stock added: " + stockAdded);
        if (stockCount==0 || stockCount+stockAdded==0) {
            notifySubscribers(stockCount+stockAdded);
        }

        stockCount += stockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
