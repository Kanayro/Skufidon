package org.example.searchingservice.requests;

import org.example.searchingservice.dto.AppearanceDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppearanceRequest {


    public AppearanceDTO getAppearance(int id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/appearance/" + id;
        AppearanceDTO appearanceDTO = restTemplate.getForObject(url, AppearanceDTO.class);
        return appearanceDTO;

    }

    public AppearanceDTO[] findAll(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/appearance/getAll";
        AppearanceDTO[] appearanceDTOList =  restTemplate.getForObject(url, AppearanceDTO[].class);
        return appearanceDTOList;

    }

    public AppearanceDTO[] findAllBySex(String sex){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/appearance/getAll?sex="+sex;
        AppearanceDTO[] appearanceDTOList =  restTemplate.getForObject(url, AppearanceDTO[].class);
        return appearanceDTOList;

    }













}
