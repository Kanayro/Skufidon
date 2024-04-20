package org.example.appearanceservice.models;

import jakarta.persistence.*;

@Table(name = "photo")
@Entity
public class Photo {

    @Id
    @Column(name = "uri")
    private String uri;

    @ManyToOne
    @JoinColumn(name = "appearance_id",referencedColumnName = "id")
    private Appearance appearance;

    public Photo() {
    }

    public Photo( String uri, Appearance appearance) {
        this.uri = uri;
        this.appearance = appearance;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }
}
