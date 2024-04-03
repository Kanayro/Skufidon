package org.example.dataaccess.repositories;

import org.example.dataaccess.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender,Long> {
    public Optional<Gender> findByName(String name);
}
