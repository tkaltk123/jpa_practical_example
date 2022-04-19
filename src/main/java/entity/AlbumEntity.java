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
@SQLDelete(sql = "UPDATE ITEMS SET IS_DELETED = 1 WHERE ID=?")
@DiscriminatorValue("A")
public class AlbumEntity extends ItemEntity {
    @Basic
    @Column(name = "ARTIST")
    private String artist;

    @Basic
    @Column(name = "ETC")
    private String etc;
}