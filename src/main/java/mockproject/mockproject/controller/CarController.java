package mockproject.mockproject.controller;

import mockproject.entity.Car;
import mockproject.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CarController {
// move to datareponse to controller
  @Autowired
  private CarsService carsService;

  @PostMapping("/addCar")
  public Car addCar(@RequestBody Car car) throws NullPointerException {
    return carsService.addCar(car);
  }
  @DeleteMapping("/deleteAllCars")
  public void deleteAllCars() {
    carsService.deleteAllCars();
  }
  @PostMapping("/listcars")
  public List<Car> addListCar(@RequestBody List<Car> carList){
    return carsService.addListCar(carList);
  }

  @GetMapping("/getAllCars")
  public List<Car> getAllCar() {
    return carsService.getAllCars();
  }

  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") long Id) {
    carsService.deleteById(Id);
  }

  @PutMapping("/update/{id}")
  public Car updateCar(@RequestParam("id") long id, @RequestBody Car car) {
    return carsService.updateCar(id, car);
  }
  @GetMapping("/findById/{id}")
  public Car findById(@PathVariable("id") long id){
    return carsService.findById(id);
  }

}
