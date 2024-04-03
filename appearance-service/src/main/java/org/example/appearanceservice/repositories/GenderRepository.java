package org.example.appearanceservice.repositories;

import org.example.appearanceservice.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender,Integer> {
}
