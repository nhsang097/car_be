package mockproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private String customerName;

    @Column(nullable = false)
    private Date customerBirthday;

    @Column(nullable = false)
    private String customerGender;

    @Column(nullable = false)
    private String customerPhone;

    @Column(nullable = false)
    private Date dateAppointment;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String serviceArea;

    @Column(nullable = false)
    private String status;

  @OneToMany( cascade = CascadeType.ALL)
  @JoinColumn(name = "Customer_id", referencedColumnName = "customerId")
  private List<CarServices> carServices;
}

