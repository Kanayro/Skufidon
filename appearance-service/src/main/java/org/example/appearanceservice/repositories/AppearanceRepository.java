package org.example.appearanceservice.repositories;

import org.example.appearanceservice.models.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppearanceRepository extends JpaRepository<Appearance,Integer> {
    Optional<Appearance> findByClient(int id);
    void deleteAppearanceByClient(int id);
    List<Appearance> findAllBySex(String sex);
}
