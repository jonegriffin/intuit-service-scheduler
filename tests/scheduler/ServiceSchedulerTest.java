package scheduler;

import main.entities.Customer;
import main.enums.ServiceLevelEnum;
import main.scheduler.ServiceScheduler;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ServiceSchedulerTest {

    @Test
    public void testServiceSchedulerHappyPath() {
        String phoneNumber = "555-555-5555";

        Customer normalCustomer1 = new Customer(phoneNumber, "John Doe", ServiceLevelEnum.NORMAL);
        Customer normalCustomer2 = new Customer(phoneNumber, "Jane Doe", ServiceLevelEnum.NORMAL);

        Customer vipCustomer1 = new Customer(phoneNumber, "John Smith", ServiceLevelEnum.VIP);
        Customer vipCustomer2 = new Customer(phoneNumber, "Jane Smith", ServiceLevelEnum.VIP);

        ServiceScheduler serviceScheduler = new ServiceScheduler();

        // check in the customers
        serviceScheduler.checkIn(normalCustomer2);
        serviceScheduler.checkIn(normalCustomer1);
        serviceScheduler.checkIn(vipCustomer1);
        serviceScheduler.checkIn(vipCustomer2);

        // verify that customers are dequeued in the correct order by service level and ticket number
        assertSame(vipCustomer1, serviceScheduler.getNextCustomer());
        assertSame(vipCustomer2, serviceScheduler.getNextCustomer());
        assertSame(normalCustomer2, serviceScheduler.getNextCustomer());
        assertSame(normalCustomer1, serviceScheduler.getNextCustomer());

        // make sure the queue is now clear
        assertNull(serviceScheduler.getNextCustomer());
    }
}
