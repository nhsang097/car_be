package mockproject.service;

import mockproject.entity.Car;
import mockproject.repository.CarRepository;
import mockproject.service.impl.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CarsServiceTest {

    @Mock
    private CarRepository carsRepository;

    @InjectMocks
    private CarServiceImpl carsService;

    private Car existingCar;

    @BeforeEach
    public void setup() {
        existingCar = new Car( 1L,"Toyota Camry", 10, 4, 20, "toyota_camry.jpg", "featured", "description", 25000.0, "sedan", "Toyota","abc", false,null);
        existingCar.setId(1L);
    }

    @Test
    public void testGetAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(existingCar);
        Mockito.when(carsRepository.findByIsDeletedFalse()).thenReturn(cars);

        List<Car> result = carsService.getAllCars();

        assertEquals(1, result.size());
        assertEquals(existingCar, result.get(0));
    }

    @Test
    public void testAddCar() {
        Car newCar = new Car( 1L,"Toyota Camry", 10, 4, 20, "toyota_camry.jpg", "featured", "description", 25000.0, "sedan", "Toyota","abc", false,null);
        Mockito.when(carsRepository.save(newCar)).thenReturn(newCar);

        Car result = carsService.addCar(newCar);

        assertEquals(newCar, result);
    }

    @Test
    public void testAddListCar() {
        List<Car> carList = new ArrayList<>();
        Car newCar1 = new Car( 1L,"Toyota Camry", 10, 4, 20, "toyota_camry.jpg", "featured", "description", 25000.0, "sedan", "Toyota","abc", false,null);
        Car newCar2 = new Car(2L, "Honda Civic", 12, 5, 30, "honda_civic.jpg", "featured", "description", 22000.0, "sedan", "Honda", "xyz", false, null);
        carList.add(newCar1);
        carList.add(newCar2);
        Mockito.when(carsRepository.saveAll(carList)).thenReturn(carList);

        List<Car> result = carsService.addListCar(carList);

        assertEquals(carList, result);
    }

    @Test
    public void testDeleteById() {
        Car newCar1 = new Car( 1L,"Toyota Camry", 10, 4, 20, "toyota_camry.jpg", "featured", "description", 25000.0, "sedan", "Toyota","abc", false,null);
        Long carId = existingCar.getId();
        Mockito.when(carsRepository.findById(newCar1.getId())).thenReturn(Optional.of(existingCar));

        carsService.deleteById(carId);

        Mockito.verify(carsRepository, Mockito.times(1)).deleteById(newCar1.getId());
    }

    @Test
    public void testUpdateCar() {
        Long carId = existingCar.getId();
        Car updatedCar = new Car(2L, "Honda Civic", 12, 5, 30, "honda_civic.jpg", "featured", "description", 22000.0, "sedan", "Honda", "xyz", false, null);
        updatedCar.setId(carId);
        Mockito.when(carsRepository.findById(carId)).thenReturn(Optional.of(existingCar));
        Mockito.when(carsRepository.save(existingCar)).thenReturn(updatedCar);

        Car result = carsService.updateCar(carId, updatedCar);

        assertEquals(updatedCar, result);
    }

    @Test
    public void testFindById() {
        Long carId = existingCar.getId();
        Mockito.when(carsRepository.findById(carId)).thenReturn(Optional.of(existingCar));

        Car result = carsService.findById(carId);

        assertEquals(existingCar, result);
    }

    @Test
    public void testDeleteAllCars() {
        carsService.deleteAllCars();

        Mockito.verify(carsRepository, Mockito.times(1)).deleteAll();
    }
}
