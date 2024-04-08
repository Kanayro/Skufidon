package org.example.searchingservice.requests;

import org.example.searchingservice.dto.RequirementDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequirementRequest {

    public RequirementDTO getRequirement(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/requirement/"+id;

        RequirementDTO requirementDTO = restTemplate.getForObject(url, RequirementDTO.class);
        return requirementDTO;

    }

}
