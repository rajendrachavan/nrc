package neo.demo.springboot.nrc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressId", insertable = false, updatable = false)
    private Address address;

    private LocalDate livingFrom;
    private LocalDate lastLivingDate;

    public UserAddress(Long id, User user, Address address, LocalDate livingFrom, LocalDate lastLivingDate) {

        //Intializing Attributes.
        this.id = id;
        this.user = user;
        this.address = address;
        this.livingFrom = livingFrom;
        this.lastLivingDate = lastLivingDate;

        //Updating relationships to ensure referential integrity.
        user.getAddressList().add(this);
    }
}
