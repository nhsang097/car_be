package mockproject.service;

import mockproject.entity.CarServices;
import mockproject.repository.CarServicesRepository;
import mockproject.service.impl.CarServicesInServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class CarServicesInServiceTest {

    @Mock
    private CarServicesRepository carServicesRepository;

    @InjectMocks
    private CarServicesInService carServicesInService = new CarServicesInServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCarServices() {
        List<CarServices> carServices = new ArrayList<>();
        carServices.add(new CarServices(1L, "oil change", null, null));
        carServices.add(new CarServices(2L, "tire rotation", null, null));
        when(carServicesRepository.findAll()).thenReturn(carServices);

        List<CarServices> returnedCarServices = carServicesInService.getAllCarServices();
        Assertions.assertEquals(carServices.size(), returnedCarServices.size());
        Assertions.assertEquals(carServices.get(0).getCarServiceName(), returnedCarServices.get(0).getCarServiceName());
        Assertions.assertEquals(carServices.get(1).getCarServiceName(), returnedCarServices.get(1).getCarServiceName());
    }

    @Test
    public void testAddCarService() {
        CarServices carService = new CarServices(1L, "oil change", null, null);
        when(carServicesRepository.save(carService)).thenReturn(carService);

        CarServices returnedCarService = carServicesInService.addCarService(carService);
        Assertions.assertEquals(carService.getCarServiceName(), returnedCarService.getCarServiceName());
    }

    @Test
    public void testAddListCarServices() {
        List<CarServices> carServices = new ArrayList<>();
        carServices.add(new CarServices(1L, "oil change", null, null));
        carServices.add(new CarServices(2L, "tire rotation", null, null));
        when(carServicesRepository.saveAll(carServices)).thenReturn(carServices);

        List<CarServices> returnedCarServices = carServicesInService.addListCarServices(carServices);
        Assertions.assertEquals(carServices.size(), returnedCarServices.size());
        Assertions.assertEquals(carServices.get(0).getCarServiceName(), returnedCarServices.get(0).getCarServiceName());
        Assertions.assertEquals(carServices.get(1).getCarServiceName(), returnedCarServices.get(1).getCarServiceName());
    }

    @Test
    public void testUpdateCarService() {
        Long carServiceId = 1L;
        CarServices carService = new CarServices(1L, "oil change", null, null);
        when(carServicesRepository.findById(carServiceId)).thenReturn(Optional.of(carService));
        when(carServicesRepository.save(carService)).thenReturn(carService);

        CarServices returnedCarService = carServicesInService.updateCarService(carServiceId, carService);
        Assertions.assertEquals(carService.getCarServiceName(), returnedCarService.getCarServiceName());
    }
}