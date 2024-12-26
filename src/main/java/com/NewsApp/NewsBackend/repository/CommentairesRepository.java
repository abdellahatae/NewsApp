package com.NewsApp.NewsBackend.repository;

import com.NewsApp.NewsBackend.entity.Commentaires;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentairesRepository extends MongoRepository<Commentaires, String> {

    // Trouver tous les commentaires associés à une news spécifique
    List<Commentaires> findByNewsId(String newsId);
}
