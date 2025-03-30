package com.java.designpatterns.behavioral.strategy;

import static java.lang.System.*;

interface SortingStrategy {
    void sort(int[] numbers);
}

class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] numbers) {
        out.println("Bubble Sort");
    }
}
class SelectionSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        out.println("Selection Sort");
    }
}
class InsertionSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        out.println("Insertion Sort");
    }
}

class SortContext {
    private SortingStrategy sortingStrategy;
    public SortContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void getSortingStrategy(int[] numbers) {
        sortingStrategy.sort(numbers);
}

public static class SortingUsingStrategyPattern {
    public static void main(String[] args) {
        SortingStrategy sortingStrategy = new BubbleSortStrategy();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        sortingStrategy.sort(numbers);

        sortingStrategy = new SelectionSortStrategy();
        sortingStrategy.sort(numbers);

        sortingStrategy = new InsertionSortStrategy();
        sortingStrategy.sort(numbers);

        SortContext sortContext = new SortContext(sortingStrategy);
        sortContext.getSortingStrategy(numbers);
    }
}
}
