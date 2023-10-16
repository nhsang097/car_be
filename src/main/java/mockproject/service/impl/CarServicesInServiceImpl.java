package mockproject.service.impl;

import mockproject.entity.CarServices;
import mockproject.repository.CarServicesRepository;
import mockproject.service.CarServicesInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServicesInServiceImpl implements CarServicesInService {
  @Autowired
  private CarServicesRepository carServicesRepository;

  @Override
  public List<CarServices> getAllCarServices() {
    return carServicesRepository.findAll();
  }

  @Override
  public CarServices addCarService(CarServices carService) {
    return carServicesRepository.save(carService);
  }

  @Override
  public List<CarServices> addListCarServices(List<CarServices> carServiceList) {
    return carServicesRepository.saveAll(carServiceList);
  }

  @Override
  public void deleteCarServiceById(Long carServiceID) {
    CarServices carService = carServicesRepository.findById(carServiceID)
        .orElseThrow(() -> new RuntimeException("Could not find car service with id: " + carServiceID));
    carServicesRepository.deleteById(carServiceID);
  }

  @Override
  public CarServices updateCarService(Long carServiceID, CarServices carService) {
    CarServices existingCarService = carServicesRepository.findById(carServiceID)
        .orElseThrow(() -> new RuntimeException("Could not find car service with id: " + carServiceID));

    existingCarService.setCarServiceName(carService.getCarServiceName());
    existingCarService.setCarServiceImage(carService.getCarServiceImage());
    existingCarService.setCarServiceDesc(carService.getCarServiceDesc());
//sang2
    return carServicesRepository.save(existingCarService);
  }

  @Override
  public CarServices getCarServiceById(Long carServiceId) {
    return carServicesRepository.findById(carServiceId)
        .orElseThrow(() -> new RuntimeException("Could not find car service with id: " + carServiceId));
  }

}
