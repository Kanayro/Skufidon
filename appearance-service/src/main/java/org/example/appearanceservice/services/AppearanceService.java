package org.example.appearanceservice.services;

import org.example.appearanceservice.exceptions.AppearanceNotFoundException;
import org.example.appearanceservice.models.Appearance;
import org.example.appearanceservice.repositories.AppearanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppearanceService {

    private final AppearanceRepository appearanceRepository;

    @Autowired
    public AppearanceService(AppearanceRepository appearanceRepository) {
        this.appearanceRepository = appearanceRepository;
    }

    @Transactional
    public void save(Appearance appearance, int client_id){
        appearance.setClient_id(client_id);
        appearanceRepository.save(appearance);
    }

    @Transactional
    public void update(Appearance updatedAppearance, int client_id){
       Appearance appearance = appearanceRepository.findByClient(client_id)
               .orElseThrow(AppearanceNotFoundException::new);

       updatedAppearance.setId(appearance.getId());
       updatedAppearance.setClient_id(client_id);

       appearanceRepository.save(updatedAppearance);

    }

    public Appearance findByClient(int client_id){
        Appearance appearance = appearanceRepository.findByClient(client_id)
                .orElseThrow(AppearanceNotFoundException::new);
        return appearance;
    }

    @Transactional
    public void delete(int client_id){
        appearanceRepository.deleteAppearanceByClient(client_id);

    }

    public Appearance get(int client_id){
        Optional<Appearance> appearance = appearanceRepository.findByClient(client_id);
        return appearance.orElseThrow(AppearanceNotFoundException::new);
    }

    public List<Appearance> findAll(){
        return appearanceRepository.findAll();
    }

    public List<Appearance> findAllBySex(String sex){
        System.out.println(sex);
        List<Appearance> appearances = appearanceRepository.findAllBySex(sex);

        System.out.println(appearances);
        return appearances;
    }


}
