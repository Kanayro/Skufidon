package org.example.searchingservice.services;

import org.example.searchingservice.dto.AppearanceDTO;
import org.example.searchingservice.dto.RequirementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class AppearanceSortService {

    private final RequirementAppearanceComparer comparer;

    @Autowired
    public AppearanceSortService(RequirementAppearanceComparer comparer) {
        this.comparer = comparer;
    }

    public List<AppearanceDTO> sortByRequirement(AppearanceDTO[] appearanceDTOList,
                                                 RequirementDTO requirementDTO ){

        List<AppearanceDTO> appearanceDTOs = new ArrayList<>(10);
        for (int i=0;i<appearanceDTOList.length;i++){

            if(comparer.compare(appearanceDTOList[i],requirementDTO)) {
                appearanceDTOs.add(appearanceDTOList[i]);
            }

        }

        return appearanceDTOs;
    }





}
