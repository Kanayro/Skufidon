package org.example.authservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.authservice.models.Client;
import org.example.authservice.security.ClientDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public Client hel(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ClientDetails userDetails = (ClientDetails) authentication.getPrincipal();


        return userDetails.getClient();
    }



}
