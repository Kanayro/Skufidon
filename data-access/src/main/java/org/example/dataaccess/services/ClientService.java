package org.example.dataaccess.services;

import org.example.dataaccess.exceptions.ClientNotCreatedException;
import org.example.dataaccess.exceptions.ClientNotFoundException;
import org.example.dataaccess.exceptions.GenderNotFoundException;
import org.example.dataaccess.exceptions.SkufMarkNotFoundException;
import org.example.dataaccess.models.Appearance;
import org.example.dataaccess.models.Client;
import org.example.dataaccess.models.Gender;
import org.example.dataaccess.models.SkufMark;
import org.example.dataaccess.repositories.AppearanceRepository;
import org.example.dataaccess.repositories.ClientRepository;
import org.example.dataaccess.repositories.GenderRepository;
import org.example.dataaccess.repositories.SkufMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dataaccess.interfaces.iClientService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientService implements iClientService{

    private final ClientRepository clientRepository;
    private final AppearanceRepository appearanceRepository;
    private final GenderRepository genderRepository;
    private final SkufMarkRepository skufMarkRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository, AppearanceRepository appearanceRepository,GenderRepository genderRepository, SkufMarkRepository skufMarkRepository) {
        this.clientRepository = clientRepository;
        this.appearanceRepository = appearanceRepository;
        this.genderRepository=genderRepository;
        this.skufMarkRepository=skufMarkRepository;
    }

    @Transactional
    public void save(Client client){
        clientRepository.save(client);
    }

    @Transactional
    public void delete(long id){
        clientRepository.deleteById(id);

    }

    public Optional<Client> getClient(long id){
        return clientRepository.findClientById(id);
    }



    @Transactional
    public void update(long id, Client updatedClient){
        updatedClient.setId(id);
        clientRepository.save(updatedClient);
    }

    @Transactional
    public void saveAppearance(Appearance appearance){
        appearanceRepository.save(appearance);
    }

    public Client findByIdOrThrowException(long id){
        Optional<Client> client = clientRepository.findClientById(id);
        return client.orElseThrow(ClientNotFoundException::new);
    }

    public Gender findGenderByNameOrThrowException(String name){
        Optional<Gender> gender = genderRepository.findByName(name);
        return gender.orElseThrow(GenderNotFoundException::new);
    }

    public SkufMark findSkufMarkByNameOrThrowException(String name){
        Optional<SkufMark> skufMark = skufMarkRepository.findByName(name);
        return skufMark.orElseThrow(SkufMarkNotFoundException::new);
    }


}
