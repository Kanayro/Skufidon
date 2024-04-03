package org.example.requirementservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "requirement")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    public Requirement(int id, String sex, int age, String address, String hair_color, int client) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.client = client;
    }

    public Requirement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getClient_id() {
        return client;
    }

    public void setClient_id(int client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", client_id=" + client +
                '}';
    }
}
