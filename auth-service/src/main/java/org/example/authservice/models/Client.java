package org.example.authservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Имя пользователя должно быть указано")
    @Column(name = "username")
    private String username;

    @Email
    @NotNull(message = "Электронная почта должна быть указана")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Номер телефона должен быть указан")
    @Column(name = "phone_number")
    private String phone_number;

    @NotNull(message = "Пароль должен быть указан")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public Client() {
    }

    public Client(int id, String username, String email,
                String phone_number, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
