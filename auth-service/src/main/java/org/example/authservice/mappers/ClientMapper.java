package org.example.authservice.mappers;

import org.example.authservice.dto.ClientDTO;
import org.example.authservice.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Client convertToUser(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, Client.class);
    }

    public Client convertToUserDTO(Client client){
        return modelMapper.map(client, Client.class);
    }
}
