package org.example.dataaccess.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class SkufMarkDTO {

    @Max(value= 100, message = "Name must be shorter 100 characters")
    @NotNull(message = "Name must not be empty")
    private String name;

    @Max(value= 400, message = "Description must be shorter 400 characters")
    @NotNull(message = "Description must not be empty")
    private String description;

    public SkufMarkDTO() {
    }

    public SkufMarkDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
