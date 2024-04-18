package org.example.appearanceservice.controllers;

import org.example.appearanceservice.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class StorageController {

    private final StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<HttpStatus> uploadFile(@RequestParam("file")MultipartFile file){
        service.uploadObject(file);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
