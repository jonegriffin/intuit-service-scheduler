package main.helpers;

import main.entities.Customer;

import java.util.Comparator;
import java.util.Objects;

// Min heap implementation to sort customers
public class CustomerComparator implements Comparator<Customer> {
    @Override
    // custom comparator method to sort customers
    // sort first by service level, then by ticket number
    public int compare(Customer c1, Customer c2) {

        // if c1 is a lower service level than c2 (meaning c1 is VIP and c2 is not)
        // OR if they are both the same service level and c1's ticket number is lower than c2's ticket number,
        // return -1
        if (c1.getServiceLevel() < c2.getServiceLevel() ||
                (Objects.equals(c1.getServiceLevel(), c2.getServiceLevel()) && c1.getTicketNumber() < c2.getTicketNumber())) {
            return -1;
        }
        // else, if c1 has a higher service level than c2
        // OR c1 has a higher ticket number than c2,
        // return 1
        else if (c1.getServiceLevel() > c2.getServiceLevel() ||
            c1.getTicketNumber() > c2.getTicketNumber()) {
            return 1;
        }
        // otherwise, in the very unlikely event that c1 and c2 are the same service level
        // AND have the exact same ticket number (meaning they were checked in at the exact same time to the millisecond
        // return 0
        return 0;
    }
}
