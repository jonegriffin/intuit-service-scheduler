package main.scheduler;

import main.entities.Customer;
import main.helpers.CustomerComparator;

import java.util.PriorityQueue;

public class ServiceScheduler {

    // queue for customers
    // ranked by following priority:
    // 1. service level (VIP customers must be served before normal)
    // 2. ticket number (lower ticket numbers are handled first)
    private PriorityQueue<Customer> queue;

    public ServiceScheduler() {
        this.queue = new PriorityQueue<Customer>(new CustomerComparator());
    }

    // method for checking in customers
    public void checkIn(Customer customer) {

        customer.setTicketNumber();

        this.queue.add(customer);
    }

    // fetches next customer in queue
    public Customer getNextCustomer() {
        return this.queue.poll();
    }
}