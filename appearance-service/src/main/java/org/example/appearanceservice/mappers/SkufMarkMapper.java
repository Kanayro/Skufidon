package org.example.appearanceservice.mappers;

import org.example.appearanceservice.dto.SkufMarkDTO;
import org.example.appearanceservice.models.SkufMark;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkufMarkMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public SkufMarkMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SkufMark mapToSkufMark(SkufMarkDTO skufMarkDTO){
        return modelMapper.map(skufMarkDTO, SkufMark.class);
    }

    public SkufMarkDTO mapToSkufMarkDTO(SkufMark skufMark){
        return modelMapper.map(skufMark, SkufMarkDTO.class);
    }
}
