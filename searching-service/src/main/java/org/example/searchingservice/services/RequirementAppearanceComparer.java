package org.example.searchingservice.services;

import org.example.searchingservice.dto.AppearanceDTO;
import org.example.searchingservice.dto.RequirementDTO;
import org.springframework.stereotype.Component;

@Component
public class RequirementAppearanceComparer {

    public boolean compare(AppearanceDTO appearanceDTO, RequirementDTO requirementDTO){

        if(requirementDTO == null){
            return true;
        }

        if(requirementDTO.getAge()<=appearanceDTO.getAge()+1 && requirementDTO.getAge()>=appearanceDTO.getAge()-1 ){

            if(requirementDTO.getAddress() == appearanceDTO.getAddress() || requirementDTO.getAddress()==null){

                if(requirementDTO.getHair_color() == appearanceDTO.getHair_color() || requirementDTO.getHair_color() == null){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}
