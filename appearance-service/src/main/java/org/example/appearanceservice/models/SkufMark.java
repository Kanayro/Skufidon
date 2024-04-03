package org.example.appearanceservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skufmark")
public class SkufMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "skufMark")
    private List<Appearance> appearanceList;

    public SkufMark(int id, String name, String description, List<Appearance> appearanceList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.appearanceList = appearanceList;
    }

    public SkufMark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Appearance> getAppearanceList() {
        return appearanceList;
    }

    public void setAppearanceList(List<Appearance> appearanceList) {
        this.appearanceList = appearanceList;
    }
}
