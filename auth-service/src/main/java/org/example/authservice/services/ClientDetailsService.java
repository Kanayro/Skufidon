package org.example.authservice.services;

import org.example.authservice.models.Client;
import org.example.authservice.repositories.ClientRepository;
import org.example.authservice.security.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepository.findByUsername(username);

        if(client.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return new ClientDetails(client.get());
    }
}
