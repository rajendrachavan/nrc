package neo.demo.springboot.nrc.repositories;

import neo.demo.springboot.nrc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
