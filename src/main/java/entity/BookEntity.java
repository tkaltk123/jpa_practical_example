package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@SQLDelete(sql = "UPDATE ITEMS SET IS_DELETED = 1 WHERE ID=?")
@DiscriminatorValue("B")
public class BookEntity extends ItemEntity {
    @Basic
    @Column(name = "AUTHOR")
    private String author;

    @Basic
    @Column(name = "ISBN")
    private String isbn;
}