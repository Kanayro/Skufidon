package org.example.dataaccess.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class RequirementDTO {

//    @Max(value = 100, message = "Sex must be shorter 100 characters")
    private String sex;

//    @Min(value = 0, message = "Age must be greater 0 ")
    private int age;

//    @Pattern(regexp = "[A-Z]\\w+,[A-Z]\\w+",message = "format is: Country,City")
//    @Max(value = 200, message = "Address must be shorter 200 characters")
    private String address;

//    @Max(value = 200, message = "Hair color must be shorter 200 characters")
    private String hair_color;

    private GenderDTO gender;

    private SkufMarkDTO skufMark;

    public RequirementDTO() {
    }

    public RequirementDTO(String sex, int age, String address, String hair_color, GenderDTO gender, SkufMarkDTO skufMark) {
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.gender = gender;
        this.skufMark = skufMark;
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
