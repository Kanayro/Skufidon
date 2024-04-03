package org.example.authservice.repositories;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.example.authservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Optional<Client> findByUsername(String username);

}
