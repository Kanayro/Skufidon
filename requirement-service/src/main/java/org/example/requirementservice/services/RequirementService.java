package org.example.requirementservice.services;

import org.example.requirementservice.exceptions.RequirementNotFoundException;
import org.example.requirementservice.models.Requirement;
import org.example.requirementservice.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RequirementService {

    private final RequirementRepository repository;

    @Autowired
    public RequirementService(RequirementRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(Requirement requirement, int client_id){
        requirement.setClient_id(client_id);
        repository.save(requirement);
    }

    @Transactional
    public void update(Requirement updatedRequirement, int client_id){
        Requirement requirement = repository.findByClient(client_id)
                .orElseThrow(RequirementNotFoundException::new);

        updatedRequirement.setClient_id(client_id);
        updatedRequirement.setId(requirement.getId());

        repository.save(updatedRequirement);

    }

    public Requirement getRequirement(int client_id){
        Requirement requirement = repository.findByClient(client_id)
                .orElseThrow(RequirementNotFoundException::new);
        return requirement;
    }

    @Transactional
    public void delete(int client_id){
        repository.deleteById(client_id);
    }
}
