package org.example.appearanceservice.models;

import jakarta.persistence.*;

@Table(name = "photo")
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "appearance_id",referencedColumnName = "id")
    private Appearance appearance;

    public Photo() {
    }

    public Photo(int id, String url, Appearance appearance) {
        this.id = id;
        this.url = url;
        this.appearance = appearance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }
}
