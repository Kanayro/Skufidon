package org.example.dataaccess.repositories;

import org.example.dataaccess.models.SkufMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkufMarkRepository extends JpaRepository<SkufMark,Long> {
    public Optional<SkufMark> findByName(String name);
}
