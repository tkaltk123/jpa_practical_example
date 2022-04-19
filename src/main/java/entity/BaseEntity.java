package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createdAt;

    @Basic
    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;

    @Basic(optional = false)
    @Column(name = "IS_DELETED")
    private int isDeleted = 0;
}
