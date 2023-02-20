package mockproject.repository;

import java.util.Optional;
import mockproject.entity.CarServices;
import mockproject.entity.CustomerInfoServ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServicesRepository extends JpaRepository<CarServices,Long> {

}
