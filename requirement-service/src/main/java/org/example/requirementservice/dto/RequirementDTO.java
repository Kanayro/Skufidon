package org.example.requirementservice.dto;

public class RequirementDTO {

    private String sex;

    private int age;

    private String address;

    private String hair_color;

    private int client_id;

    public RequirementDTO(String sex, int age, String address, String hair_color, int client_id) {
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hair_color = hair_color;
        this.client_id = client_id;
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
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
