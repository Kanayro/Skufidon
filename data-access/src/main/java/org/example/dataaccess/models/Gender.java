package org.example.dataaccess.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Size(max= 100, message = "Name must be shorter 100 characters")
    @NotNull(message = "Name must not be empty")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private List<Appearance> appearanceList;

    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private List<Requirement> requirementList;

    public Gender() {
    }

    public Gender(long id, String name, List<Appearance> appearanceList, List<Requirement> requirementList) {
        this.id = id;
        this.name = name;
        this.appearanceList = appearanceList;
        this.requirementList = requirementList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }
}
