package org.example.searchingservice.requests;

import org.example.searchingservice.dto.AppearanceDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    public List<AppearanceDTO> findAll(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/appearance/getAll";
        List<AppearanceDTO> appearanceDTOList = restTemplate.getForObject(url,List.class);
        return appearanceDTOList;

    }

    public List<AppearanceDTO> findAllBySex(String sex){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/appearance/getAll?sex="+sex;
        List<AppearanceDTO> appearanceDTOList = restTemplate.getForObject(url,List.class);
        return appearanceDTOList;

    }













}
