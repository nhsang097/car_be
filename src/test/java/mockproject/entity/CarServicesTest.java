package mockproject.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CarServicesTest {

    @Mock
    private CarServices carServicesMock;

    @Test
    public void testGettersAndSetters() {
        CarServices carServices = new CarServices();

        carServices.setCarServiceId(1L);
        carServices.setCarServiceName("Test Service");
        carServices.setCarServiceImage("test.png");
        carServices.setCarServiceDesc("Test service description");

        assertEquals(1L, carServices.getCarServiceId());
        assertEquals("Test Service", carServices.getCarServiceName());
        assertEquals("test.png", carServices.getCarServiceImage());
        assertEquals("Test service description", carServices.getCarServiceDesc());
    }
}
