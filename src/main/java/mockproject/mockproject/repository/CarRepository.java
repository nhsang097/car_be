package mockproject.mockproject.repository;

import mockproject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
  // JPA la gi?? khi nao dung no
  // la 1 framework duoc xay dung tren nen tang Hibernate,...
  List<Car> findByIsDeletedFalse();
}
