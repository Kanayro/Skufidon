package org.example.appearanceservice.controllers;

import org.example.appearanceservice.services.PhotoService;
import org.example.appearanceservice.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class PhotoController {

    private final StorageService service;
    private final PhotoService photoService;

    @Autowired
    public PhotoController(StorageService service, PhotoService photoService) {
        this.service = service;
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<HttpStatus> uploadFile(@RequestParam("file")MultipartFile file){
        service.uploadObject(file);

        return ResponseEntity.ok(HttpStatus.OK);
    }


}
