package org.example.appearanceservice.repositories;

import org.example.appearanceservice.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,String> {
    List<Photo> findByAppearanceId(int id);
}
