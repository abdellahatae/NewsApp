package com.NewsApp.NewsBackend.repository;

import com.NewsApp.NewsBackend.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {

    // Trouver toutes les news par un auteur spécifique
    List<News> findByAuteur(String auteur);

  //  @Override
    //Optional<News> findById(String s);
}
