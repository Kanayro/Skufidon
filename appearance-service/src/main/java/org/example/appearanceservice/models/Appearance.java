package org.example.appearanceservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "appearance")
public class Appearance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "hair_color")
    private String hair_color;

    @Column(name = "client_id")
    private int client;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "skufmark_id", referencedColumnName = "id")
    private SkufMark skufMark;

    @OneToMany(mappedBy = "appearance")
    private List<Photo> photos;

    public Appearance(int id, String name, String surname, String sex, int age, String address,
                      String hair_color, int client, Gender gender, SkufMark skufMark, List<Photo> photos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.client = client;
        this.gender = gender;
        this.skufMark = skufMark;
        this.photos = photos;
    }

    public Appearance() {
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

    public int getClient_id() {
        return client;
    }

    public void setClient_id(int client) {
        this.client = client;
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Appearance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", client=" + client +
                ", gender=" + gender +
                ", skufMark=" + skufMark +
                '}';
    }
}
