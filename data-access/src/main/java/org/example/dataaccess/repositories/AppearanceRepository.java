package org.example.dataaccess.repositories;

import org.example.dataaccess.models.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearanceRepository extends JpaRepository<Appearance,Long> {
}
