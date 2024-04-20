package org.example.appearanceservice.services;

import org.example.appearanceservice.exceptions.PhotoNotFoundException;
import org.example.appearanceservice.models.Appearance;
import org.example.appearanceservice.models.Photo;
import org.example.appearanceservice.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public void save(String uri, Appearance appearance){
        Photo photo = new Photo(uri,appearance);
        photoRepository.save(photo);
    }

    public void savePhotos(List<String> uri,Appearance appearance){
        Photo photo = new Photo();
        photo.setAppearance(appearance);
        for (String i : uri){
            photo.setUri(i);
            photoRepository.save(photo);
        }
    }

    public void delete(String uri){
        photoRepository.deleteById(uri);

    }

    public Photo getPhoto(String uri){
        return photoRepository.findById(uri).orElseThrow(PhotoNotFoundException::new);
    }

    public List<Photo> getPhotosById(int appearance_id){
        return photoRepository.findByAppearanceId(appearance_id);
    }


}

