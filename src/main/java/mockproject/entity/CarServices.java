package mockproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import mockproject.enumerates.ECarServicesName;

@Data
@Entity
@Table(name = "car_services")
@AllArgsConstructor
@NoArgsConstructor
public class CarServices {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long carServiceId;
  private String carServiceName;
  private String carServiceImage;

  @Column(length = 2000)
  private String carServiceDesc;
//  @ManyToOne
//  @JoinColumn(name = "customer_Id", referencedColumnName = "customerId")
//  private CustomerInfoServ customerInfoServ;
}