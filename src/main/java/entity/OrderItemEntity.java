package entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS_ITEMS")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private ItemEntity item;

    @Column(name = "ORDER_PRICE")
    private Integer orderPrice;

    @Column(name = "COUNT")
    private Integer count;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        if (this.order != null)
            this.order.getOrderItems().remove(this);
        if (order != null)
            order.getOrderItems().add(this);
        this.order = order;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}