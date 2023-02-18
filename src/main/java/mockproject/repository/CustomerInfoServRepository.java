package mockproject.repository;

import mockproject.entity.CustomerInfoServ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoServRepository extends JpaRepository<CustomerInfoServ, Long> {

}
