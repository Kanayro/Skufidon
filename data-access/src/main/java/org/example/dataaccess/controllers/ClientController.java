package org.example.dataaccess.controllers;

import jakarta.validation.Valid;
import org.example.dataaccess.converters.ClientConverter;
import org.example.dataaccess.dto.*;
import org.example.dataaccess.exceptions.AppearanceNotCreatedException;
import org.example.dataaccess.exceptions.ClientNotCreatedException;
import org.example.dataaccess.exceptions.ClientNotFoundException;
import org.example.dataaccess.exceptions.ErrorResponse;
import org.example.dataaccess.models.*;
import org.example.dataaccess.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientConverter clientConverter, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.clientConverter = clientConverter;
        this.modelMapper=modelMapper;
    }

//Add methods

   @PostMapping("/add")
   public ResponseEntity<HttpStatus> addClient(@RequestBody @Valid ClientDTO clientDTO, BindingResult result){
        Client client = clientConverter.convertToClient(clientDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new ClientNotCreatedException(errorMsg.toString());
        }
        clientService.save(client);
        return ResponseEntity.ok(HttpStatus.OK);

   }



   @PostMapping("/{id}/appearance")
   public ResponseEntity<HttpStatus> addAppearance(@RequestBody @Valid AppearanceDTO appearanceDTO,BindingResult result, @PathVariable("id") long id){
       Appearance appearance = clientConverter.convertToAppearance(appearanceDTO);

       if(result.hasErrors()){
           StringBuilder errorMsg = new StringBuilder();
           List<FieldError> errors = result.getFieldErrors();

           for(FieldError error : errors){
               errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
           }
           throw new AppearanceNotCreatedException(errorMsg.toString());
       }

       Client client = clientService.findByIdOrThrowException(id);

       appearance.setGender(clientService.findGenderByNameOrThrowException(appearance.getGender().getName()));
       appearance.setSkufMark(clientService.findSkufMarkByNameOrThrowException(appearance.getSkufMark().getName()));
       appearance.setClient(clientService.findByIdOrThrowException(id));

       clientService.saveAppearance(appearance);

       client.setAppearance(appearance);

       clientService.update(id,client);

       return ResponseEntity.ok(HttpStatus.OK);
   }


//Delete methods



   @GetMapping("/{id}/delete")
   public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id){
        clientService.findByIdOrThrowException(id);
        clientService.delete(id);
       return ResponseEntity.ok(HttpStatus.OK);
   }



//Handlers


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(AppearanceNotCreatedException e){

        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(ClientNotCreatedException e){

        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(ClientNotFoundException e){
        ErrorResponse response = new ErrorResponse("Client with name like this was not found",System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


}
