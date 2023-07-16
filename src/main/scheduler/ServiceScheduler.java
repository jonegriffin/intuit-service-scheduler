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

        // re: part 3, wasn' quite sure exactly what it was asking. Maintaining a 2:1 VIP:Normal customer processing ratio
        // seems to contradict with what is required in part 2, where all VIP customers must be served before normal customers.
        // I did have some initial ideas about how to create this ratio (such as keeping track of the number of each customer served,
        // and waiting for more customers of either type to be checked in and processed before continuing in order to maintain this ratio).
        // We can discuss this.
        return this.queue.poll();
    }
}