package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE ORDERS_ITEMS SET IS_DELETED = 1 WHERE ID=?")
@Where(clause = "IS_DELETED = 0")
@Table(name = "ORDERS_ITEMS")
public class OrderItemEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private ItemEntity item;

    @Basic
    @Column(name = "ORDER_PRICE")
    private Integer orderPrice;

    @Basic
    @Column(name = "COUNT")
    private Integer count;

    public void setOrder(OrderEntity order) {
        if (this.order != null)
            this.order.getOrderItems().remove(this);
        if (order != null)
            order.getOrderItems().add(this);
        this.order = order;
    }
}