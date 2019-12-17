package neo.demo.springboot.nrc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class UserAddress {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserAddressId implements Serializable {

        @Column(name = "userId")
        protected Long userId;
        @Column(name = "addressId")
        protected Long addressId;
    }

    @EmbeddedId
    private UserAddressId id;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressId", insertable = false, updatable = false)
    private Address address;

    private LocalDate livingFrom;
    private LocalDate lastLivingDate;

    public UserAddress(User user, Address address, LocalDate livingFrom, LocalDate lastLivingDate) {
        //Creation of primary key.
        this.id = new UserAddressId(user.getId(), address.getId());

        //Intializing Attributes.
        this.user = user;
        this.address = address;
        this.livingFrom = livingFrom;
        this.lastLivingDate = lastLivingDate;

        //Updating relationships to ensure referential integrity.
        address.getUsers().add(this);
        user.getAddressList().add(this);
    }
}
