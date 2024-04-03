package org.example.authservice.services;

import org.example.authservice.models.Client;
import org.example.authservice.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findClientByUsername(String username){
        return clientRepository.findByUsername(username);
    }
}
