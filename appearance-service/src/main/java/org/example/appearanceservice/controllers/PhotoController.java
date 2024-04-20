package org.example.appearanceservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.appearanceservice.dto.JWTDTO;
import org.example.appearanceservice.models.Photo;
import org.example.appearanceservice.services.AppearanceService;
import org.example.appearanceservice.services.PhotoService;
import org.example.appearanceservice.services.StorageService;
import org.example.appearanceservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
public class PhotoController {

    private final StorageService storageService;
    private final PhotoService photoService;
    private final AppearanceService appearanceService;
    private final JWTUtil jwtUtil;

    @Autowired
    public PhotoController(StorageService storageService, PhotoService photoService,
                           AppearanceService appearanceService, JWTUtil jwtUtil) {
        this.storageService = storageService;
        this.photoService = photoService;
        this.appearanceService = appearanceService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/upload")
    public ResponseEntity<HttpStatus> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        photoService.save(storageService.uploadObject(file),appearanceService.findByClient(jwtdto.getId()));



        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/uploadFiles")
    public ResponseEntity<HttpStatus> uploadFiles(@RequestParam("file") List<MultipartFile> file, HttpServletRequest request){

        JWTDTO jwtdto = jwtUtil.validateTokenAndRetrieveClaim(jwtUtil.getJWT(request));
        photoService.savePhotos(storageService.uploadObjects(file),appearanceService.findByClient(jwtdto.getId()));



        return ResponseEntity.ok(HttpStatus.OK);
    }


}
