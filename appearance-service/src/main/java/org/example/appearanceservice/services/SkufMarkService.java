package org.example.appearanceservice.services;

import org.example.appearanceservice.exceptions.GenderNotFoundException;
import org.example.appearanceservice.exceptions.SkufMarkNotFoundException;
import org.example.appearanceservice.models.Gender;
import org.example.appearanceservice.models.SkufMark;
import org.example.appearanceservice.repositories.SkufMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkufMarkService {

    private final SkufMarkRepository repository;

    @Autowired
    public SkufMarkService(SkufMarkRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(SkufMark skufMark){
        repository.save(skufMark);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(int id, SkufMark updatedSkufMark){
        SkufMark skufMark = repository.findById(id).orElseThrow(SkufMarkNotFoundException::new);

        updatedSkufMark.setId(skufMark.getId());
        repository.save(updatedSkufMark);


    }

    public List<SkufMark> findAll(){
        return repository.findAll();
    }



    public SkufMark getSkufMark(int id){
        return repository.findById(id).orElseThrow(SkufMarkNotFoundException::new);
    }
}
