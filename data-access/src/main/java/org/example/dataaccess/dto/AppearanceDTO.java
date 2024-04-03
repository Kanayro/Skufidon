package org.example.dataaccess.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AppearanceDTO {

    @NotNull(message = "Name must not be empty")
//    @Max(value = 100, message = "Name must be shorter 100 characters")
    private String name;

//    @Max(value = 100, message = "Surname must be shorter 100 characters")
    private String surname;

//    @Max(value = 100, message = "Sex must be shorter 100 characters")
    private String sex;

//    @Min(value = 0, message = "Age must be greater 0 ")
    private int age;

//    @Max(value = 200, message = "Address must be shorter 200 characters")
//    @Pattern(regexp = "[A-Z]\\w+,[A-Z]\\w+",message = "format is: Country,City")
    private String address;

//    @Max(value = 200, message = "Hair color must be shorter 200 characters")
    private String hair_color;

    private GenderDTO gender;

    private SkufMarkDTO skufMark;

    public AppearanceDTO() {
    }

    public AppearanceDTO(String name, String surname, String sex, int age,
                         String address, String hair_color, GenderDTO gender, SkufMarkDTO skufMark) {

        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.gender = gender;
        this.skufMark = skufMark;
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

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }

    public SkufMarkDTO getSkufMark() {
        return skufMark;
    }

    public void setSkufMark(SkufMarkDTO skufMark) {
        this.skufMark = skufMark;
    }
}
