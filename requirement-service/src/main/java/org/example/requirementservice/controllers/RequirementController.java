package org.example.requirementservice.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.requirementservice.dto.JWTDTO;
import org.example.requirementservice.dto.RequirementDTO;
import org.example.requirementservice.exceptions.ErrorResponse;
import org.example.requirementservice.exceptions.RequirementNotCreatedException;
import org.example.requirementservice.exceptions.RequirementNotFoundException;
import org.example.requirementservice.mappers.RequirementMapper;
import org.example.requirementservice.models.Requirement;
import org.example.requirementservice.services.RequirementService;
import org.example.requirementservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requirement")
public class RequirementController {

    private final RequirementMapper mapper;
    private final RequirementService service;
    private final JWTUtil jwtUtil;

    @Autowired
    public RequirementController(RequirementMapper mapper, RequirementService service, JWTUtil jwtUtil) {
        this.mapper = mapper;
        this.service = service;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addAppearance(@RequestBody @Valid RequirementDTO requirementDTO, BindingResult result, HttpServletRequest request){

        Requirement requirement = mapper.mapToRequirement(requirementDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new RequirementNotCreatedException(errorMsg.toString());
        }

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        service.save(requirement, jwtdto.getId());


        return ResponseEntity.ok(HttpStatus.OK);

    }


    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateAppearance(@RequestBody @Valid RequirementDTO requirementDTO, BindingResult result, HttpServletRequest request){
        Requirement requirement = mapper.mapToRequirement(requirementDTO);

        if(result.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
            }
            throw new RequirementNotCreatedException(errorMsg.toString());
        }

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));

        service.update(requirement, jwtdto.getId());

        return ResponseEntity.ok(HttpStatus.OK);


    }

    @GetMapping("/get")
    public RequirementDTO getRequirement(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        return mapper.mapToRequirementDTO(service.getRequirement(jwtdto.getId()));

    }




    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> delete(HttpServletRequest request){
        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        service.delete(jwtdto.getId());

        return ResponseEntity.ok(HttpStatus.OK);

    }


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(RequirementNotCreatedException e){

        ErrorResponse response = new ErrorResponse(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(RequirementNotFoundException e){

        ErrorResponse response = new ErrorResponse("Данные требования не были найдены",System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
}
