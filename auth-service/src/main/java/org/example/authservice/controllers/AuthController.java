package org.example.authservice.controllers;

import jakarta.validation.Valid;
import org.example.authservice.dto.AuthenticationDTO;
import org.example.authservice.dto.ClientDTO;
import org.example.authservice.exceptions.ErrorResponse;
import org.example.authservice.exceptions.UserNotCreatedException;
import org.example.authservice.mappers.ClientMapper;
import org.example.authservice.models.Client;
import org.example.authservice.security.ClientDetails;
import org.example.authservice.security.JWTUtil;
import org.example.authservice.services.ClientDetailsService;
import org.example.authservice.services.RegistrationService;
import org.example.authservice.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator validator;
    private final RegistrationService registrationService;
    private final JWTUtil jwtUtil;
    private final ClientMapper clientMapper;
    private final AuthenticationManager authenticationManager;
    private final ClientDetailsService clientDetailsService;

    @Autowired
    public AuthController(PersonValidator validator, RegistrationService registrationService, JWTUtil jwtUtil, ClientMapper clientMapper,
                          AuthenticationManager authenticationManager, ClientDetailsService clientDetailsService) {
        this.validator = validator;
        this.registrationService = registrationService;
        this.jwtUtil = jwtUtil;
        this.clientMapper = clientMapper;
        this.authenticationManager = authenticationManager;
        this.clientDetailsService = clientDetailsService;
    }

    @PostMapping("/registration")
    public Map<String, String> registrationPerform(@RequestBody @Valid ClientDTO clientDTO, BindingResult result){

        Client client = clientMapper.convertToUser(clientDTO);

        validator.validate(client,result);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new UserNotCreatedException(errorMsg.toString());
        }

        registrationService.register(client);

        String token = jwtUtil.generateToken(client);

        return Map.of("jwt-token",token);
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                authenticationDTO.getPassword());

        try{
            authenticationManager.authenticate(token);
        }catch (BadCredentialsException e){
            return Map.of("message","Bad credentials");
        }

        ClientDetails clientDetails = (ClientDetails) clientDetailsService.loadUserByUsername(token.getName());

        String jToken = jwtUtil.generateToken(clientDetails.getClient());

        return Map.of("jwt-token",jToken);


    }



    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(UserNotCreatedException e){

        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
