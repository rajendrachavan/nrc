package neo.demo.springboot.nrc.repositories;

import neo.demo.springboot.nrc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
