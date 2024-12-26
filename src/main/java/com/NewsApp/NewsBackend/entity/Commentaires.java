package com.NewsApp.NewsBackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "Commentaires")
public class Commentaires {

    @Id
    private String id;
    private String newsId; // ID de la news associée
    private String auteur; // login de l'auteur
    private String contenu;
    private LocalDate date;

    public Commentaires() {
    }

    public Commentaires(String newsId, String auteur, String contenu, LocalDate date) {
        this.newsId = newsId;
        this.auteur = auteur;
        this.contenu = contenu;
        this.date = date;
    }

    // Getters et Setters
   /* public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;}*/
    public String getNewsId() { return newsId; }
    public void setNewsId(String newsId) { this.newsId = newsId; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}

