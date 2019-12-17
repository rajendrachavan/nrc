package neo.demo.springboot.nrc.repositories;

import neo.demo.springboot.nrc.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}