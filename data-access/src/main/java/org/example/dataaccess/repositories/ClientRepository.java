package org.example.dataaccess.repositories;

import org.example.dataaccess.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByAppearanceName(String name);
    Optional<Client> findByLogin(String login);
    Optional<Client> findClientById(long id);



}
