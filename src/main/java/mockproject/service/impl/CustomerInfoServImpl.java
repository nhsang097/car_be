package mockproject.service.impl;

import mockproject.entity.CustomerInfoServ;
import mockproject.repository.CustomerInfoServRepository;
import mockproject.service.CustomerInfoServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInfoServImpl implements CustomerInfoServService {

  @Autowired
  private CustomerInfoServRepository customerInfoServRepository;

  @Override
  public List<CustomerInfoServ> getAllCustomerInfo() {
    return customerInfoServRepository.findAll();
  }

  @Override
  public CustomerInfoServ addCustomerInfo(CustomerInfoServ customerInfoServ) {
    return customerInfoServRepository.save(customerInfoServ);
  }

  @Override
  public List<CustomerInfoServ> addListCustomerInfo(List<CustomerInfoServ> customerInfoList) {
    return customerInfoServRepository.saveAll(customerInfoList);
  }

  @Override
  public void deleteCustomerInfoById(Long customerInfoID) {
    customerInfoServRepository.deleteById(customerInfoID);
  }


  @Override
  public CustomerInfoServ updateCustomerInfo(Long customerInfoServId, CustomerInfoServ customerInfoServ) {
    CustomerInfoServ existingCustomerInfo = customerInfoServRepository.findById(customerInfoServId)
        .orElseThrow(() -> new RuntimeException("Customer Info not found with id: " + customerInfoServId));

    existingCustomerInfo.setCustomerName(customerInfoServ.getCustomerName());
    existingCustomerInfo.setCustomerBirthday(customerInfoServ.getCustomerBirthday());
    existingCustomerInfo.setCustomerGender(customerInfoServ.getCustomerGender());
    existingCustomerInfo.setCustomerPhone(customerInfoServ.getCustomerPhone());
    existingCustomerInfo.setDateAppointment(customerInfoServ.getDateAppointment());
    existingCustomerInfo.setServiceName(customerInfoServ.getServiceName());
    existingCustomerInfo.setServiceArea(customerInfoServ.getServiceArea());
    existingCustomerInfo.setStatus(customerInfoServ.getStatus());

    return customerInfoServRepository.save(existingCustomerInfo);
  }

  @Override
  public CustomerInfoServ getCustomerInfoById(Long customerId) {
    return customerInfoServRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Could not find customerId like this"));
  }
}
