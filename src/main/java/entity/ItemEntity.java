package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Where(clause = "IS_DELETED = 0")
@Table(name = "ITEMS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class ItemEntity extends BaseEntity {
    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "PRICE")
    private Integer price;

    @Basic
    @Column(name = "STOCK_QUANTITY")
    private Integer stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<CategoryEntity> categories;
}