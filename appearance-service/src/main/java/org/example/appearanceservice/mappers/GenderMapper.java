package org.example.appearanceservice.mappers;

import org.example.appearanceservice.dto.GenderDTO;
import org.example.appearanceservice.models.Gender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public GenderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Gender mapToGender(GenderDTO genderDTO){
        return modelMapper.map(genderDTO,Gender.class);
    }

    public GenderDTO mapToGenderDTO(Gender gender){
        return modelMapper.map(gender,GenderDTO.class);
    }
}
