package mockproject.entity;

import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import mockproject.enumerates.ECustomerGender;
import mockproject.enumerates.EServiceArea;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoServ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Name cannot contain special characters")
    private String customerName;

    @Column(nullable = false)
    private Date customerBirthday;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ECustomerGender customerGender;

    @Column(nullable = false)
    private String customerPhone;

    @Column(nullable = false)
    private Date dateAppointment;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EServiceArea serviceArea;

    @Column(nullable = false)
    private String status;

  @OneToMany( cascade = CascadeType.ALL)
  @JoinColumn(name = "Customer_id", referencedColumnName = "customerId")
  private List<CarServices> carServices;
}

