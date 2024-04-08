package org.example.searchingservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.searchingservice.dto.AppearanceDTO;
import org.example.searchingservice.dto.JWTDTO;
import org.example.searchingservice.requests.AppearanceRequest;
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

    @Autowired
    public MainController(JWTUtil jwtUtil, AppearanceRequest appearanceRequest) {
        this.jwtUtil = jwtUtil;
        this.appearanceRequest = appearanceRequest;
    }

    @GetMapping("/get")
    public AppearanceDTO getCapacity(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        AppearanceDTO appearanceDTO = appearanceRequest.getAppearance(jwtdto.getId());

        return appearanceDTO;

    }




}
