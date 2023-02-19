package mockproject.service;

import mockproject.entity.Car;
import java.util.List;

public interface CarsService {
//all this thing la phuong thuc truu tuong
  // sua cars thay vi datarepsonse
  public List<Car> getAllCars();

  public Car addCar(Car car);



  List<Car> addListCar(List<Car> carList);

  public void deleteById(Long id);

  public Car updateCar(Long id, Car car);

  Car findById (Long id);

  void deleteAllCars();
}
