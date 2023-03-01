package mockproject.mockproject.service.impl;

import mockproject.entity.CustomerInfoServ;
import mockproject.exception.PhoneNumberExistedException;
import mockproject.repository.CarServicesRepository;
import mockproject.repository.CustomerInfoServRepository;
import mockproject.service.CustomerInfoServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerInfoServImpl implements CustomerInfoServService {

  @Autowired
  private CustomerInfoServRepository customerInfoServRepository;
  @Autowired
  private CarServicesRepository carServicesRepository;

  @Override
  public List<CustomerInfoServ> getAllCustomerInfo() {
    return customerInfoServRepository.findByStatus("Incomplete");
  }

  @Override
  public CustomerInfoServ addCustomerInfo(CustomerInfoServ customerInfoServ) throws PhoneNumberExistedException {
    if (!customerInfoServ.getCustomerName().matches("^[a-zA-Z ]+$")) {
      throw new RuntimeException("Invalid name - name should only contain letters not numbers");
    }
    Optional<CustomerInfoServ> existingCustomerInfo = customerInfoServRepository.findByCustomerPhone(
        customerInfoServ.getCustomerPhone());
    if (existingCustomerInfo.isPresent()) {
      throw new PhoneNumberExistedException(" " + customerInfoServ.getCustomerPhone() + " ");
    }

    else  {
      return customerInfoServRepository.save(customerInfoServ);
    }
  }


  @Override
  public List<CustomerInfoServ> addListCustomerInfo(List<CustomerInfoServ> customerInfoList) {
    return customerInfoServRepository.saveAll(customerInfoList);
  }

  @Override
  public void deleteCustomerInfoById(Long customerInfoID) {
    CustomerInfoServ customerInfoServ = customerInfoServRepository.findById(customerInfoID).orElseThrow(() -> new RuntimeException("Not found"));
    customerInfoServ.setStatus("completed");
    customerInfoServRepository.save(customerInfoServ);
  }


  @Override
  public CustomerInfoServ updateCustomerInfo(Long customerInfoServId,
      CustomerInfoServ customerInfoServ) {
    CustomerInfoServ existingCustomerInfo = customerInfoServRepository.findById(customerInfoServId)
        .orElseThrow(
            () -> new RuntimeException("Customer Info not found with id: " + customerInfoServId));

    existingCustomerInfo.setCustomerName(customerInfoServ.getCustomerName());
    existingCustomerInfo.setCustomerBirthday(customerInfoServ.getCustomerBirthday());
    existingCustomerInfo.setCustomerGender(customerInfoServ.getCustomerGender());
    existingCustomerInfo.setCustomerPhone(customerInfoServ.getCustomerPhone());
    existingCustomerInfo.setDateAppointment(customerInfoServ.getDateAppointment());
    existingCustomerInfo.setServiceArea(customerInfoServ.getServiceArea());
    existingCustomerInfo.setStatus(customerInfoServ.getStatus());

    return customerInfoServRepository.save(existingCustomerInfo);
  }

  @Override
  public CustomerInfoServ getCustomerInfoById(Long customerId) {
    return customerInfoServRepository.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Could not find customerId like this"));
  }
}
