package org.example.appearanceservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.appearanceservice.dto.GenderDTO;
import org.example.appearanceservice.exceptions.AppearanceNotCreatedException;
import org.example.appearanceservice.exceptions.ErrorResponse;
import org.example.appearanceservice.exceptions.GenderNotCreatedException;
import org.example.appearanceservice.exceptions.GenderNotFoundException;
import org.example.appearanceservice.mappers.GenderMapper;
import org.example.appearanceservice.models.Gender;
import org.example.appearanceservice.models.SkufMark;
import org.example.appearanceservice.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gender")
public class GenderController {

    private final GenderService genderService;
    private final GenderMapper genderMapper;

    @Autowired
    public GenderController(GenderService genderService, GenderMapper genderMapper) {
        this.genderService = genderService;
        this.genderMapper = genderMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid GenderDTO genderDTO, BindingResult result, HttpServletRequest request){
        Gender gender = genderMapper.mapToGender(genderDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new GenderNotCreatedException(errorMsg.toString());
        }

        genderService.save(gender);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/all")
    public List<GenderDTO> findAll(){
        return genderService.findAll().stream().map(genderMapper::mapToGenderDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        genderService.delete(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public GenderDTO getGender(@PathVariable("id") int id){
        Gender gender = genderService.getGender(id);
        return genderMapper.mapToGenderDTO(gender);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<HttpStatus> update(@PathVariable("id")int id,@RequestBody @Valid GenderDTO genderDTO, BindingResult result){
        Gender gender = genderMapper.mapToGender(genderDTO);
        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new GenderNotCreatedException(errorMsg.toString());
        }

        genderService.update(id,gender);

        return ResponseEntity.ok(HttpStatus.OK);
    }




    //Exception handlers

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(GenderNotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(GenderNotFoundException e){

        ErrorResponse response = new ErrorResponse("Данный гендер не был найден",System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }







}
