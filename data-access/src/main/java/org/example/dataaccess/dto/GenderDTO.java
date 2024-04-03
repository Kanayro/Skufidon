package org.example.dataaccess.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class GenderDTO {

    @Max(value= 100, message = "Name must be shorter 100 characters")
    @NotNull(message = "Name must not be empty")
    private String name;

    public GenderDTO() {
    }

    public GenderDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
