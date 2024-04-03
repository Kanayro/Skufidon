package org.example.appearanceservice.repositories;

import org.example.appearanceservice.models.SkufMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkufMarkRepository extends JpaRepository<SkufMark,Integer> {
}
