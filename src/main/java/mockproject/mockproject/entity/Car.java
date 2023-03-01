package mockproject.mockproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mockproject.entity.Images;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity // ORM = Object relational Mapping - key = mapping database vs nhung field tren java
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column
  private String name;

  private int stock;

  private int stars;

  private int reviews;
  private String image;
  private String featured;
  private String videoDesc;
  private double price;
  @Column (length = 2000 )
  private String description;
  private String category;
  private String company;

  private boolean isDeleted = false;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "car_id",
      referencedColumnName = "id"
  )
  private List<Images> images;

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}

