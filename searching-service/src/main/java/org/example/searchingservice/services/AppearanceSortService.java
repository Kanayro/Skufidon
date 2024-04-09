package org.example.searchingservice.services;

import org.example.searchingservice.dto.AppearanceDTO;
import org.example.searchingservice.dto.RequirementDTO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class AppearanceSortService {

    public List<AppearanceDTO> sortByRequirement(List<AppearanceDTO> appearanceDTOList,
                                                 RequirementDTO requirementDTO ){

        Queue<AppearanceDTO> appearanceDTOQueue = new LinkedList<>();
        for (AppearanceDTO appearanceDTO : appearanceDTOList){

        }

    }





}
