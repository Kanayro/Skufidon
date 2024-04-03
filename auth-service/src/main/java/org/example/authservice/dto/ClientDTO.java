package org.example.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ClientDTO {

    @NotNull(message = "Имя пользователя должно быть указано")
    private String username;

    @Email
    @NotNull(message = "Электронная почта должна быть указана")
    private String email;

    @NotNull(message = "Номер телефона должен быть указан")
    private String phone_number;

    @NotNull(message = "Пароль должен быть указан")
    private String password;

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
}
