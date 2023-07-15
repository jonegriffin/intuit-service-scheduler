import main.entities.Customer;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    @Test
    public void testCustomerHappyPath() {
        String customerName = "John Doe";
        String customerPhoneNumber = "555-555-5555";

        Integer customerServiceLevel = 1;

        Customer customer = new Customer(customerPhoneNumber, customerName, customerServiceLevel);

        assertEquals(customerName, customer.getName());
        assertEquals(customerPhoneNumber, customer.getPhoneNumber());
        assertEquals(customerServiceLevel, customer.getServiceLevel());
    }
}
