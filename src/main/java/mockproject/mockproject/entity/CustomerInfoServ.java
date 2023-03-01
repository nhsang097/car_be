package mockproject.mockproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

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
  @NotNull
  @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name cannot contain special characters")
    private String customerName;

  @Column(nullable = false)
  private Date customerBirthday;

  @Column(nullable = false)
  @NotEmpty
  private String customerGender;

  public static final String PHONE_PATTERN = "^\\+84\\d{9,10}$";
  @Pattern(regexp = PHONE_PATTERN, message = "Please provide a valid phone number")
  @Column(nullable = false)
  private String customerPhone;

  @Column(nullable = false)
  private Date dateAppointment;

  @Column(nullable = false)
  private String serviceArea;

  @Column(nullable = false)
  private String ServiceName;

  @Column(nullable = false)
  private String status;

}

