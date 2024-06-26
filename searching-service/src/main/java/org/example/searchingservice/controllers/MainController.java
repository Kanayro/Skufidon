package org.example.searchingservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.searchingservice.dto.AppearanceDTO;
import org.example.searchingservice.dto.JWTDTO;
import org.example.searchingservice.dto.RequirementDTO;
import org.example.searchingservice.requests.AppearanceRequest;
import org.example.searchingservice.requests.RequirementRequest;
import org.example.searchingservice.services.AppearanceSortService;
import org.example.searchingservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class MainController {

    private final JWTUtil jwtUtil;
    private final AppearanceRequest appearanceRequest;
    private final RequirementRequest requirementRequest;
    private final AppearanceSortService sortService;

    @Autowired
    public MainController(JWTUtil jwtUtil, AppearanceRequest appearanceRequest,
                          RequirementRequest requirementRequest, AppearanceSortService sortService) {
        this.jwtUtil = jwtUtil;
        this.appearanceRequest = appearanceRequest;
        this.requirementRequest = requirementRequest;
        this.sortService = sortService;
    }

    @GetMapping("/get")
    public List<AppearanceDTO> getCapacity(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        RequirementDTO requirementDTO = requirementRequest.getRequirement(jwtdto.getId());
        AppearanceDTO[] appearanceDTOList = appearanceRequest.findAllBySex(requirementDTO.getSex());

        List<AppearanceDTO> sortList = sortService.sortByRequirement(appearanceDTOList,requirementDTO);

        return sortList;

    }




}
