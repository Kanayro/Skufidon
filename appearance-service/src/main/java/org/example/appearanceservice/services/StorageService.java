package org.example.appearanceservice.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
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

    private final Credentials credentials;

    @Autowired
    public StorageService(AmazonS3 s3, Credentials credentials) {
        this.s3 = s3;
        this.credentials = credentials;
    }

    public String uploadObject(MultipartFile file){
        File fileobj = convertMultiPartFileToFile(file);
        String filename = file.getOriginalFilename();

        String file_url = storage_url + filename;

        System.out.println(file_url);

        s3.putObject(new PutObjectRequest(bucket_name,filename,fileobj));
        fileobj.delete();

        return "File uploaded :" + filename;


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
