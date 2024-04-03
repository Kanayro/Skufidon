package org.example.appearanceservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.appearanceservice.dto.SkufMarkDTO;
import org.example.appearanceservice.exceptions.*;
import org.example.appearanceservice.mappers.SkufMarkMapper;
import org.example.appearanceservice.models.SkufMark;
import org.example.appearanceservice.services.SkufMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skufmark")
public class SkufMarkController {

    private final SkufMarkService skufMarkService;
    private final SkufMarkMapper skufMarkMapper;

    @Autowired
    public SkufMarkController(SkufMarkService skufMarkService, SkufMarkMapper skufMarkMapper) {
        this.skufMarkService = skufMarkService;
        this.skufMarkMapper = skufMarkMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addSkufMark(@RequestBody @Valid SkufMarkDTO skufMarkDTO, BindingResult result, HttpServletRequest request){
        SkufMark skufMark = skufMarkMapper.mapToSkufMark(skufMarkDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new SkufMarkNotCreatedException(errorMsg.toString());
        }
        skufMarkService.save(skufMark);

        return ResponseEntity.ok(HttpStatus.OK);

    }
    @GetMapping("/all")
    public List<SkufMarkDTO> findAll(){
        return skufMarkService.findAll().stream().map(skufMarkMapper::mapToSkufMarkDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SkufMarkDTO get(@PathVariable("id") int id){
        SkufMark skufMark = skufMarkService.getSkufMark(id);
        return skufMarkMapper.mapToSkufMarkDTO(skufMark);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        skufMarkService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") int id,@RequestBody @Valid SkufMarkDTO skufMarkDTO, BindingResult result){
        SkufMark skufMark = skufMarkMapper.mapToSkufMark(skufMarkDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new SkufMarkNotCreatedException(errorMsg.toString());
        }
        skufMarkService.update(id,skufMark);
        return ResponseEntity.ok(HttpStatus.OK);

    }


    //Exception handlers

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(SkufMarkNotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(SkufMarkNotFoundException e){

        ErrorResponse response = new ErrorResponse("Данная метка скуфа не была найдена",System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
