package org.example.appearanceservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.appearanceservice.dto.AppearanceDTO;
import org.example.appearanceservice.dto.JWTDTO;
import org.example.appearanceservice.exceptions.AppearanceNotCreatedException;
import org.example.appearanceservice.exceptions.AppearanceNotFoundException;
import org.example.appearanceservice.exceptions.ErrorResponse;
import org.example.appearanceservice.exceptions.GenderNotFoundException;
import org.example.appearanceservice.mappers.AppearanceMapper;
import org.example.appearanceservice.models.Appearance;
import org.example.appearanceservice.services.AppearanceService;
import org.example.appearanceservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appearance")
public class AppearanceController {


    private final JWTUtil jwtUtil;
    private final AppearanceService appearanceService;
    private final AppearanceMapper mapper;

    @Autowired
    public AppearanceController(JWTUtil jwtUtil, AppearanceService appearanceService, AppearanceMapper mapper) {
        this.jwtUtil = jwtUtil;
        this.appearanceService = appearanceService;
        this.mapper = mapper;
    }



    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addAppearance(@RequestBody @Valid AppearanceDTO appearanceDTO, BindingResult result, HttpServletRequest request){

        Appearance appearance = mapper.mapToAppearance(appearanceDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new AppearanceNotCreatedException(errorMsg.toString());
        }

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        appearanceService.save(appearance,jwtdto.getId());


        return ResponseEntity.ok(HttpStatus.OK);

    }


    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateAppearance(@RequestBody @Valid AppearanceDTO appearanceDTO, BindingResult result, HttpServletRequest request){
        Appearance appearance = mapper.mapToAppearance(appearanceDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new AppearanceNotCreatedException(errorMsg.toString());
        }

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        appearanceService.update(appearance,jwtdto.getId());

        return ResponseEntity.ok(HttpStatus.OK);


    }


    @GetMapping("/get")
    public AppearanceDTO getAppearance(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        return mapper.mapToAppearanceDTO(appearanceService.get(jwtdto.getId()));


    }




    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> delete(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        appearanceService.delete(jwtdto.getId());

        return ResponseEntity.ok(HttpStatus.OK);

    }




    //Exception handlers

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(AppearanceNotCreatedException e){

        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(AppearanceNotFoundException e){

        ErrorResponse response = new ErrorResponse("Данные характеристики не были найдены",System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
