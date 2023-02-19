package mockproject.service.impl;

import mockproject.entity.Car;
import mockproject.repository.CarRepository;
import mockproject.service.CarsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarsService {

  @Autowired //=> la nhung bean de tai su dung lai no
  private CarRepository carRepository;


  @Override

  public List<Car> getAllCars() {
    return carRepository.findByIsDeletedFalse();
  }

  @Override
  public Car addCar(Car car) {
    // khi add phai add toyota ko add hang khac
    return carRepository.save(car);
  }

  @Override
  public List<Car> addListCar(List<Car> carList){
    return carRepository.saveAll(carList);
  }

  @Override
  public void deleteById(Long id) {
    // Check if id exist in database
    Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found this car"));
    carRepository.deleteById(id);
      //"".equalsIgnoreCase()
      //"".startsWith("");
    }



  @Override
  public Car updateCar(Long id, Car car) {
    // Tao DTO se xu ly update
    Car cars = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found this car"));
      Car tempCar = carRepository.findById(id).get();
      tempCar.setName(car.getName());
      tempCar.setCompany((car.getCompany()));
      tempCar.setCategory(car.getCategory());
      tempCar.setDescription(car.getDescription());
      tempCar.setImage(car.getImage());
      tempCar.setPrice(car.getPrice());
      return carRepository.saveAndFlush(tempCar);
    }

  @Override
  public Car findById(Long id) {
    return carRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Could not find this car!!"));
  }
}


