package neo.demo.springboot.nrc.bootstrap;

import neo.demo.springboot.nrc.model.Address;
import neo.demo.springboot.nrc.model.User;
import neo.demo.springboot.nrc.model.UserAddress;
import neo.demo.springboot.nrc.repositories.AddressRepository;
import neo.demo.springboot.nrc.repositories.UserAddressRepository;
import neo.demo.springboot.nrc.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserAddressRepository userAddressRepository;

    public DataLoader(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User userChild = new User();
        userChild.setName("Snehal shelke");
        userRepository.save(userChild);
        System.out.println("########## - Added UserChild - ##########");

        User userSpouse = new User();
        userSpouse.setName("Mom_name shelke");
        userRepository.save(userSpouse);
        System.out.println("########## - Added UserSpouse - ##########");

        User user1 = new User();
        user1.setName("Ramesh Shelke");
        user1.setChildren(Collections.singletonList(userChild));
        user1.setSpouses(Collections.singletonList(userSpouse));
        userRepository.save(user1);
        System.out.println("########## - Added User - ##########");

        Address address1 = new Address();
        address1.setArea("Parel");
        address1.setCity("Mumbai");
        addressRepository.save(address1);
        System.out.println("########## - Added Address - ##########");

        UserAddress userAddress = new UserAddress(2L, user1, address1, LocalDate.now().minusYears(2), LocalDate.now());
        userAddressRepository.save(userAddress);
        System.out.println("########## - Added UserAddress - ##########");

    }
}