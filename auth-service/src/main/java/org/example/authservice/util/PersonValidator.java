package org.example.authservice.util;

import org.example.authservice.models.Client;
import org.example.authservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final ClientService service;

    @Autowired
    public PersonValidator(ClientService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;

        if(service.findClientByUsername(client.getUsername()).isPresent()){
            errors.rejectValue("username","","Данное имя уже используется");
        }

    }
}
