package org.example.appearanceservice.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.example.appearanceservice.models.Photo;
import org.example.appearanceservice.util.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class StorageService {


    @Value("${bucket_name}")
    private String bucket_name;

    @Value("${storage_url}")
    private String storage_url;

    private final AmazonS3 s3;

    private final PhotoService service;

    @Autowired
    public StorageService(AmazonS3 s3, PhotoService service) {
        this.s3 = s3;
        this.service = service;
    }


    public String uploadObject(MultipartFile file) {

        File fileobj = convertMultiPartFileToFile(file);
        String filename = file.getOriginalFilename();
        s3.putObject(new PutObjectRequest(bucket_name,filename,fileobj));
        fileobj.delete();



        return storage_url + filename;


    }








    //converters

    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        }catch (IOException e){
            System.err.println("Error converting multipart file");
        }
        return convertedFile;
    }

}
