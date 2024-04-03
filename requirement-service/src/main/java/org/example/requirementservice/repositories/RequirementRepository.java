package org.example.requirementservice.repositories;

import org.example.requirementservice.models.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement,Integer> {
    Optional<Requirement> findByClient(int id);
}
