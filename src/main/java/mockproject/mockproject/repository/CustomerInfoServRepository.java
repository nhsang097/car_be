package mockproject.mockproject.repository;

import mockproject.entity.CustomerInfoServ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerInfoServRepository extends JpaRepository<CustomerInfoServ, Long> {
  Optional<CustomerInfoServ> findByCustomerPhone(String phone);
  List<CustomerInfoServ> findByStatus(String incomplete);
}
