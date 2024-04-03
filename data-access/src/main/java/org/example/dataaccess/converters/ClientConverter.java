package org.example.dataaccess.converters;

import org.example.dataaccess.dto.AppearanceDTO;
import org.example.dataaccess.dto.ClientDTO;
import org.example.dataaccess.models.Appearance;
import org.example.dataaccess.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public ClientConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClientDTO convertToClientDTO(Client client){
        return modelMapper.map(client,ClientDTO.class);
    }

    public Client convertToClient(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, Client.class);
    }

    public Appearance convertToAppearance(AppearanceDTO appearanceDTO){
        return modelMapper.map(appearanceDTO,Appearance.class);
    }
}
