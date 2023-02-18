package mockproject.repository;

import mockproject.entity.CarServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServicesRepository extends JpaRepository<CarServices,Long> {

}
