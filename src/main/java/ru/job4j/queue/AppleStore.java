package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = "";
        for (int i = 0; i <= count; i++) {
            firstUpsetCustomer = queue.poll().name();
        }
        return firstUpsetCustomer;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomer = "";
        for (int i = 0; i < count; i++) {
            lastHappyCustomer = queue.poll().name();
        }
        return lastHappyCustomer;
    }
}
