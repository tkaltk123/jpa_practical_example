package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import util.DeliveryStatus;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE DELIVERIES SET IS_DELETED = 1 WHERE ID=?")
@Where(clause = "IS_DELETED = 0")
@Table(name = "DELIVERIES")
public class DeliveryEntity extends BaseEntity {
    @Basic
    @Column(name = "CITY")
    private String city;

    @Basic
    @Column(name = "STREET")
    private String street;

    @Basic
    @Column(name = "ZIPCODE")
    private String zipcode;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    private OrderEntity order;
}