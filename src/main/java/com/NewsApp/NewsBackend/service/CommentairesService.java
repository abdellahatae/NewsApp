package com.NewsApp.NewsBackend.service;

import com.NewsApp.NewsBackend.entity.Commentaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NewsApp.NewsBackend.repository.CommentairesRepository;
import com.NewsApp.NewsBackend.repository.NewsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service
public class CommentairesService {
    private static  NewsRepository newsRepository;
    private static  CommentairesRepository commentaireRepository; // Assurez-vous d'avoir ce repository

    @Autowired
    public CommentairesService(NewsRepository newsRepository, CommentairesRepository commentaireRepository) {
        this.newsRepository = newsRepository;
        this.commentaireRepository = commentaireRepository;
    }


    // Ajouter un commentaire pour une news spécifique
    public static Commentaires ajouterCommentaire(Commentaires commentaire) {
        if (!newsRepository.existsById(commentaire.getNewsId())) {
            throw new IllegalArgumentException("News non trouvée");
        }
        // Dans votre méthode d'ajout de commentaire
        //commentaire.setId(UUID.randomUUID().toString());
        commentaire.setDate(LocalDate.now());
        return commentaireRepository.save(commentaire);
    }

    // Récupérer tous les commentaires pour une news
    public List<Commentaires> getCommentairesByNewsId(String newsId) {
        if (!newsRepository.existsById(newsId)) {
            throw new IllegalArgumentException("News non trouvée");
        }
        return commentaireRepository.findByNewsId(newsId);
    }

   /* public List<Commentaires> findByNewsId(String newsId) {

        return commentaireRepository.findByNewsId(newsId);
    }*/
}
