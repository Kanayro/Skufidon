package org.example.appearanceservice.services;

import org.example.appearanceservice.exceptions.GenderNotFoundException;
import org.example.appearanceservice.models.Appearance;
import org.example.appearanceservice.models.Gender;
import org.example.appearanceservice.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenderService {

    private final GenderRepository repository;

    @Autowired
    public GenderService(GenderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(Gender gender){
        repository.save(gender);
    }

    @Transactional
    public void update(int id, Gender updatedGender){
        Gender gender = repository.findById(id).orElseThrow(GenderNotFoundException::new);

        updatedGender.setId(gender.getId());
        repository.save(updatedGender);

    }


    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
    public List<Gender> findAll(){
        return repository.findAll();
    }

    public Gender getGender(int id){
        return repository.findById(id).orElseThrow(GenderNotFoundException::new);
    }


}
