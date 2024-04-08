package org.example.searchingservice.controllers;

import org.example.searchingservice.requests.AppearanceRequest;
import org.example.searchingservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final JWTUtil jwtUtil;
    private final AppearanceRequest appearanceRequest;

    @Autowired
    public MainController(JWTUtil jwtUtil, AppearanceRequest appearanceRequest) {
        this.jwtUtil = jwtUtil;
        this.appearanceRequest = appearanceRequest;
    }


}
