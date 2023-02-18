package mockproject.controller;

import mockproject.entity.CarServices;
import mockproject.service.CarServicesInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CarServicesController {
  @Autowired
  private CarServicesInService carServicesService;

  @PostMapping("/addCarServices")
  public CarServices addCarService(@RequestBody CarServices carService) {
    return carServicesService.addCarService(carService);
  }

  @GetMapping("/getAllCarServices")
  public List<CarServices> getAllCarServices() {
    return carServicesService.getAllCarServices();
  }

  @GetMapping("/getCarServiceById/{id}")
  public CarServices getCarServiceById(@PathVariable Long id) {
    return carServicesService.getCarServiceById(id);
  }

  @PutMapping("/updateCarService/{id}")
  public CarServices updateCarService(@PathVariable Long id, @RequestBody CarServices carService) {
    return carServicesService.updateCarService(id, carService);
  }

  @DeleteMapping("/deleteCarServiceById/{id}")
  public void deleteCarServiceById(@PathVariable Long id) {
    carServicesService.deleteCarServiceById(id);
  }

}
