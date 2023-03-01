package mockproject.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerInfoServTest {

    @Mock
    private CustomerInfoServ customerInfoServMock;

    @Test
    public void testGettersAndSetters() {
        CustomerInfoServ customerInfoServ = new CustomerInfoServ();

        customerInfoServ.setCustomerId(1L);
        customerInfoServ.setCustomerName("Test Customer");
        customerInfoServ.setCustomerBirthday(new Date());
        customerInfoServ.setCustomerGender("Male");
        customerInfoServ.setCustomerPhone("123456789");
        customerInfoServ.setDateAppointment(new Date());
        customerInfoServ.setServiceName("Test Service");
        customerInfoServ.setServiceArea("Test Area");
        customerInfoServ.setStatus("Test Status");

        assertEquals(1L, customerInfoServ.getCustomerId());
        assertEquals("Test Customer", customerInfoServ.getCustomerName());
        assertNotNull(customerInfoServ.getCustomerBirthday());
        assertEquals("Male", customerInfoServ.getCustomerGender());
        assertEquals("123456789", customerInfoServ.getCustomerPhone());
        assertNotNull(customerInfoServ.getDateAppointment());
        assertEquals("Test Service", customerInfoServ.getServiceName());
        assertEquals("Test Area", customerInfoServ.getServiceArea());
        assertEquals("Test Status", customerInfoServ.getStatus());
    }
}
