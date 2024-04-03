package org.example.requirementservice.mappers;

import org.example.requirementservice.dto.RequirementDTO;
import org.example.requirementservice.models.Requirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequirementMapper {

    private final ModelMapper mapper;

    @Autowired
    public RequirementMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Requirement mapToRequirement(RequirementDTO requirementDTO){
        return mapper.map(requirementDTO, Requirement.class);
    }

    public RequirementDTO mapToRequirementDTO(Requirement requirement){
        return mapper.map(requirement, RequirementDTO.class);
    }
}
