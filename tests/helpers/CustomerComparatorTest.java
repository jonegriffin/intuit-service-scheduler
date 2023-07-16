package helpers;

import main.entities.Customer;
import main.enums.ServiceLevelEnum;
import main.helpers.CustomerComparator;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class CustomerComparatorTest {

    @Test
    public void testComparatorSameServiceLevel() {
        CustomerComparator comparator = new CustomerComparator();

        String phoneNumber = "555-555-5555";

        Customer customer1 = new Customer(phoneNumber, "John Doe", ServiceLevelEnum.VIP);
        Customer customer2 = new Customer(phoneNumber, "Jane Doe", ServiceLevelEnum.VIP);

        customer1.setTicketNumber();
        customer2.setTicketNumber();

        assertSame(-1, comparator.compare(customer1, customer2));
    }

    @Test
    public void testComparatorDifferentServiceLevels() {
        CustomerComparator comparator = new CustomerComparator();

        String phoneNumber = "555-555-5555";

        Customer customer1 = new Customer(phoneNumber, "John Doe", ServiceLevelEnum.NORMAL);
        Customer customer2 = new Customer(phoneNumber, "John Doe", ServiceLevelEnum.VIP);

        customer1.setTicketNumber();
        customer2.setTicketNumber();

        assertSame(1, comparator.compare(customer1, customer2));
    }

    // test the comparator inside a real PriorityQueue
    @Test
    public void testComparatorWithPriorityQueue() {
        String phoneNumber = "555-555-5555";

        PriorityQueue<Customer> queue = new PriorityQueue<>(new CustomerComparator());

        Customer normalCustomer1 = new Customer(phoneNumber, "John Doe", ServiceLevelEnum.NORMAL);
        Customer normalCustomer2 = new Customer(phoneNumber, "Jane Doe", ServiceLevelEnum.NORMAL);

        Customer vipCustomer1 = new Customer(phoneNumber, "John Smith", ServiceLevelEnum.VIP);
        Customer vipCustomer2 = new Customer(phoneNumber, "Jane Smith", ServiceLevelEnum.VIP);

        normalCustomer2.setTicketNumber();
        normalCustomer1.setTicketNumber();

        vipCustomer1.setTicketNumber();
        vipCustomer2.setTicketNumber();

        queue.add(normalCustomer1);
        queue.add(normalCustomer2);
        queue.add(vipCustomer1);
        queue.add(vipCustomer2);

        // make sure vipCustomer 1 is at the front of the queue, since it's a VIP customer and it was checked in
        // before the other VIP customer
        assertSame(vipCustomer1, queue.poll());

        // next customer in the queue should be the other VIP
        assertSame(vipCustomer2, queue.poll());

        // now that the VIP customers are cleared from the queue, the normal customers are next
        // first is the first customer to be assigned a ticket number
        assertSame(normalCustomer2, queue.poll());

        // and then the other normal customer
        assertSame(normalCustomer1, queue.poll());

        // queue should now be empty
        assertNull(queue.poll());
    }
}
