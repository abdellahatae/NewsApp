package com.NewsApp.NewsBackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Utilisateurs")
public class Utilisateurs {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private List<String> amis; // Liste des logins des amis

    public Utilisateurs() {
    }

    public Utilisateurs(String nom,String prenom,String login,String password,List<String> amis) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.amis = amis;
    }


    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public List<String> getAmis() { return amis; }
    public void setAmis(List<String> amis) { this.amis = amis; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
