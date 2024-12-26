package com.NewsApp.NewsBackend.service;

import com.NewsApp.NewsBackend.entity.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NewsApp.NewsBackend.repository.UtilisateursRepository;

import java.util.List;
//import java.util.Optional;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateurRepository;

    // Créer un nouvel utilisateur
    public Utilisateurs inscrireUtilisateur(Utilisateurs utilisateur) {
        if (utilisateurRepository.findByLogin(utilisateur.getLogin()) != null) {
            throw new IllegalArgumentException("Login déjà utilisé");
        }
        return utilisateurRepository.save(utilisateur);
    }
     //recuperer tous les utilisateurs dans BD
    public List<Utilisateurs> getAllUtilisateurs() {
        return  utilisateurRepository.findAll();

    }
    // Méthode de connexion pour vérifier si l'utilisateur existe
    public Utilisateurs connecterUtilisateur(String login) {
        return utilisateurRepository.findByLogin(login); // Renvoie null si l'utilisateur n'existe pas
    }















    /*
    // Méthode de connexion pour vérifier si l'utilisateur existe
    public Utilisateurs connecterUtilisateur(String login) {
        return utilisateurRepository.findByLogin(login); // Renvoie null si l'utilisateur n'existe pas
    }
    */










    /*// login d'un utilisateur
    public String loginUtilisateur(Utilisateurs utilisateur) {
        if (utilisateurRepository.findByLogin(utilisateur.getLogin()) == null) {
            throw new IllegalArgumentException("Login n'existe pas");
        }
        return utilisateur.getId();
    }
*/

/*
    // Ajouter un ami
    public Utilisateurs ajouterAmi(String login, String amiLogin) {
        Utilisateurs utilisateur = utilisateurRepository.findByLogin(login);
        Utilisateurs ami = utilisateurRepository.findByLogin(amiLogin);

        if (utilisateur == null || ami == null) {
            throw new IllegalArgumentException("Utilisateur ou ami non trouvé");
        }
        if (!utilisateur.getAmis().contains(amiLogin)) {
            utilisateur.getAmis().add(amiLogin);
            utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }


*/

}
