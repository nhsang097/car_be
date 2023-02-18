package mockproject.service;

import mockproject.entity.CarServices;

import java.util.List;

public interface CarServicesInService {
  List<CarServices> getAllCarServices();
  CarServices addCarService(CarServices carService);
  List<CarServices> addListCarServices(List<CarServices> carServiceList);
  void deleteCarServiceById(Long carServiceID);
  CarServices updateCarService(Long carServiceID, CarServices carService);
  CarServices getCarServiceById(Long carServiceID);

}
