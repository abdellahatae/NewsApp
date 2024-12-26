package com.NewsApp.NewsBackend.repository;

import com.NewsApp.NewsBackend.entity.Utilisateurs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursRepository extends MongoRepository<Utilisateurs, String> {

    // Trouver un utilisateur par son login
    Utilisateurs findByLogin(String login);
    //Utilisateurs findById(String id);
    //List<Utilisateurs> findAll();
}
