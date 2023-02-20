package mockproject.service;

import java.util.Optional;
import mockproject.entity.CustomerInfoServ;

import java.util.List;

public interface CustomerInfoServService {
  List<CustomerInfoServ> getAllCustomerInfo();
  CustomerInfoServ addCustomerInfo(CustomerInfoServ customerInfoServ);
  List<CustomerInfoServ> addListCustomerInfo(List<CustomerInfoServ> customerInfoList);
  void deleteCustomerInfoById(Long customerInfoID);
  CustomerInfoServ updateCustomerInfo(Long customerInfoServId, CustomerInfoServ CustomerInfoServ);
  CustomerInfoServ getCustomerInfoById(Long CustomerInfoServId);

}
