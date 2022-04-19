package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import util.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE ORDERS SET IS_DELETED = 1 WHERE ID=?")
@Where(clause = "IS_DELETED = 0")
@Table(name = "ORDERS")
public class OrderEntity extends BaseEntity {
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member;

    @Basic
    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID", unique = true)
    private DeliveryEntity delivery;

    public void setMember(MemberEntity member) {
        if (this.member != null)
            this.member.getOrders().remove(this);
        if (member != null)
            member.getOrders().add(this);
        this.member = member;
    }

    public void setDelivery(DeliveryEntity delivery) {
        if (this.delivery != null)
            this.delivery.setOrder(null);
        if (delivery != null)
            delivery.setOrder(this);
        this.delivery = delivery;
    }
}