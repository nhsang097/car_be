package mockproject.mockproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Images {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long imageId;
  private String url;

}
