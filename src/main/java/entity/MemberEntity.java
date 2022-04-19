package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE MEMBERS SET IS_DELETED = 1 WHERE ID=?")
@Where(clause = "IS_DELETED = 0")
@Table(name = "MEMBERS")
public class MemberEntity  extends BaseEntity{
    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "CITY")
    private String city;

    @Basic
    @Column(name = "STREET")
    private String street;

    @Basic
    @Column(name = "ZIPCODE")
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<OrderEntity> orders = new ArrayList<>();
}