package org.example.searchingservice.requests;

import org.example.searchingservice.dto.AppearanceDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppearanceRequest {


    public void getAppearance(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "localhost:8081/appearance/" + id;
        AppearanceDTO appearanceDTO = restTemplate.getForObject(url, AppearanceDTO.class);

    }













}
