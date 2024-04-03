package org.example.dataaccess.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "appearance")
public class Appearance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Name must not be empty")
    @Size(max = 100, message = "Name must be shorter 100 characters")
    @Column(name = "name")
    private String name;

    @Size(max = 100, message = "Surname must be shorter 100 characters")
    @Column(name = "surname")
    private String surname;

    @Size(max = 100, message = "Sex must be shorter 100 characters")
    @Column(name = "sex")
    private String sex;

    @NotNull(message = "Age must not be empty")
    @Column(name = "age")
    private int age;

    @Size(max = 200, message = "Address must be shorter 200 characters")
    @Pattern(regexp = "[A-Z]\\w+,[A-Z]\\w+",message = "format is: Country,City")
    @Column(name = "address")
    private String address;

    @Size(max = 200, message = "Hair color must be shorter 200 characters")
    @Column(name = "hair_color")
    private String hair_color;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "skufmark_id", referencedColumnName = "id")
    private SkufMark skufMark;

    @OneToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    @JsonBackReference
    private Client client;

    public Appearance() {
    }

    public Appearance(long id, String name, String surname, String sex, int age, String address,
                      String hair_color, Gender gender, SkufMark skufMark, Client client) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.gender = gender;
        this.skufMark = skufMark;
        this.client = client;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public SkufMark getSkufMark() {
        return skufMark;
    }

    public void setSkufMark(SkufMark skufMark) {
        this.skufMark = skufMark;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
