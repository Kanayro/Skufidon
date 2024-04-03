package org.example.dataaccess.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Requirement")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Size(max = 100, message = "Sex must be shorter 100 characters")
    @Column(name = "sex")
    private String sex;

    @Size(max = 0, message = "Age must be greater 0 ")
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

    public Requirement() {
    }

    public Requirement(long id, String sex, int age, String address,
                       String hair_color, Gender gender, SkufMark skufMark, Client client) {
        this.id = id;
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
