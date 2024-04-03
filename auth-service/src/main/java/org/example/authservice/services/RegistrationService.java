package org.example.authservice.services;

import org.example.authservice.models.Client;
import org.example.authservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Client client){

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRole("ROLE_USER");

        clientRepository.save(client);
    }
}
