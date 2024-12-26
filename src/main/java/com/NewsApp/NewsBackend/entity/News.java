package com.NewsApp.NewsBackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "News")
public class News {


    @Id
    String id;
    private String url;
    private String auteur; // login de l'auteur
    private String titre;
    private String contenu;
    private LocalDate dateAjout;
    private int likes;
    private int dislikes;
    @Field("Commentaires")
    private List<Commentaires> commentaires; // Liste de commentaires
    public News() {
    }

    public News(String url,String auteur,String titre,String contenu,LocalDate dateAjout,int likes ,int dislikes,List<Commentaires> commentaires) {
        this.url = url;
        this.auteur = auteur;
        this.titre=titre;
        this.contenu=contenu;
        this.dateAjout = dateAjout;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentaires = commentaires;
    }

// Getters et Setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
    this.id = id;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDateAjout() { return dateAjout; }
    public void setDateAjout(LocalDate dateAjout) { this.dateAjout = dateAjout; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getDislikes() { return dislikes; }
    public void setDislikes(int dislikes) { this.dislikes = dislikes; }

    public List<Commentaires> getCommentaires() { return commentaires; }
    public void setCommentaires(List<Commentaires> commentaires) { this.commentaires = commentaires; }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +'\n'+
                ", url='" + url + '\'' +'\n'+
                ", auteur='" + auteur + '\'' + '\n'+
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' + '\n'+
                ", dateAjout=" + dateAjout + '\n'+
                ", likes=" + likes + '\n'+
                ", dislikes=" + dislikes + '\n'+
                ", commentaires=" + commentaires + '\n'+
                '}';
    }
}
