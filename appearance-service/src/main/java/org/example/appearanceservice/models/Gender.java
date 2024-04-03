package org.example.appearanceservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<Appearance> appearanceList;

    public Gender(int id, String name, List<Appearance> appearanceList) {
        this.id = id;
        this.name = name;
        this.appearanceList = appearanceList;
    }

    public Gender() {
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

    public List<Appearance> getAppearanceList() {
        return appearanceList;
    }

    public void setAppearanceList(List<Appearance> appearanceList) {
        this.appearanceList = appearanceList;
    }
}
