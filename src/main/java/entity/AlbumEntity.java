package entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class AlbumEntity extends ItemEntity {
    @Column(name = "ARTIST")
    private String artist;

    @Column(name = "ETC")
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}