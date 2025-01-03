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
        int servedCustomers = 0;
        for (Customer customer : queue) {
            if (servedCustomers < count) {
                servedCustomers++;
            } else {

                return customer.name();
            }
        }

        return "";
    }

    public String getLastHappyCustomer() {
        int availableCount = count;
        String lastHappyCustomer = "";

        for (int i = 0; i < queue.size(); i++) {
            Customer customer = queue.poll();

            if (customer.amount() > availableCount) {
                availableCount -= customer.amount();
                lastHappyCustomer = customer.name();
            } else {
                queue.offer(customer);
            }
        }

        return lastHappyCustomer;
    }

}
