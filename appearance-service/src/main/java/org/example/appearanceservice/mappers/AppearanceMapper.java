package org.example.appearanceservice.mappers;

import org.example.appearanceservice.dto.AppearanceDTO;
import org.example.appearanceservice.models.Appearance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppearanceMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AppearanceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Appearance mapToAppearance(AppearanceDTO appearanceDTO){
        return modelMapper.map(appearanceDTO,Appearance.class);
    }

    public AppearanceDTO mapToAppearanceDTO(Appearance appearance){
        return modelMapper.map(appearance, AppearanceDTO.class);
    }
}
