package mockproject.controller;

import mockproject.entity.CustomerInfoServ;
import mockproject.service.CustomerInfoServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class CustomerInfoServController {

  @Autowired
  private CustomerInfoServService customerInfoServService;

  @PostMapping("/addCustomerInfo")
  public CustomerInfoServ addCustomerInfo(@RequestBody CustomerInfoServ customerInfoServ) {
    return customerInfoServService.addCustomerInfo(customerInfoServ);
  }

  @PostMapping("/addListCustomerInfo")
  List<CustomerInfoServ> addListCustomerInfo(@RequestBody List<CustomerInfoServ> customerInfoList) {
    return customerInfoServService.addListCustomerInfo(customerInfoList);
  }

  @GetMapping("/getAllCustomerInfo")
  public List<CustomerInfoServ> getAllCustomerInfo() {
    return customerInfoServService.getAllCustomerInfo();
  }

  @GetMapping("/getCustomerInfoById/{id}")
  public CustomerInfoServ getCustomerInfoById(@PathVariable("id") Long customerInfoServId) {
    return customerInfoServService.getCustomerInfoById(customerInfoServId);
  }

  @PutMapping("/updateCustomerInfo/{id}")
  public CustomerInfoServ updateCustomerInfo(@PathVariable("id") Long customerInfoServId,
      @RequestBody CustomerInfoServ customerInfoServ) {
    return customerInfoServService.updateCustomerInfo(customerInfoServId, customerInfoServ);
  }

  @DeleteMapping("/deleteCustomerInfoById/{id}")
  public void deleteCustomerInfoById (@PathVariable("id") Long customerInfoId) {
    customerInfoServService.deleteCustomerInfoById(customerInfoId);

  }
}



