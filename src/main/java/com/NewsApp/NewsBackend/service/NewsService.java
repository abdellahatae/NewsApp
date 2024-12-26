package com.NewsApp.NewsBackend.service;

import com.NewsApp.NewsBackend.entity.News;
import com.NewsApp.NewsBackend.entity.Utilisateurs;
import com.NewsApp.NewsBackend.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NewsApp.NewsBackend.repository.NewsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UtilisateursRepository utilisateursRepository;

    // Récupérer toutes les news
    public List<News> getAllNews() {

        return newsRepository.findAll();
    }

    // Ajouter une nouvelle news
    public News ajouterNews(News news) {
       // if (newsRepository.findById(news.getId()).isPresent()) {
           // throw new IllegalArgumentException("La news existe déjà");
       // }
        news.setDateAjout(LocalDate.now());
        news.setLikes(0);
        news.setDislikes(0);
        news.getCommentaires();
        return newsRepository.save(news);
    }

    // Récupérer toutes les news creer par un auteur
    public List<News> findAllByAuteur(String auteur) {

        return newsRepository.findByAuteur(auteur);
    }

    // Gérer les likes et dislikes
    public News likeOrDislikeNews(String id, String action) {
        Optional<News> newsOpt = newsRepository.findById(id);
        if (!newsOpt.isPresent()) {
            throw new IllegalArgumentException("News non trouvée");
        }

        News news = newsOpt.get();
        if ("like".equalsIgnoreCase(action)) {
            news.setLikes(news.getLikes() + 1);
        } else if ("dislike".equalsIgnoreCase(action)) {
            news.setDislikes(news.getDislikes() + 1);
        } else {
            throw new IllegalArgumentException("Action non reconnue");
        }
        return newsRepository.save(news);
    }
}
