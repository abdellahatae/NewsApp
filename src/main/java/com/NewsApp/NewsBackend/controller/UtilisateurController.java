package com.NewsApp.NewsBackend.controller;

import com.NewsApp.NewsBackend.entity.Utilisateurs;
import com.NewsApp.NewsBackend.service.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UtilisateurController {

    @Autowired
    private UtilisateursService utilisateurService;

    // Afficher le formulaire d'inscription
    @GetMapping("/inscription")
    public String afficherFormulaireInscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateurs());
        return "inscription";
    }
    // Créer un nouvel utilisateur et rediriger vers la liste des utilisateurs
    @PostMapping("/inscription")
    public String inscrireUtilisateur(@ModelAttribute Utilisateurs utilisateur, Model model) {
        try {
            utilisateurService.inscrireUtilisateur(utilisateur);
            return "redirect:/utilisateurs";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erreur", e.getMessage());
            return "inscription";
        }
    }


    // Afficher tous les utilisateurs
    @GetMapping("utilisateurs")
    public String afficherUtilisateurs(Model model) {
        List<Utilisateurs> utilisateur = utilisateurService.getAllUtilisateurs();
        model.addAttribute("utilisateurs", utilisateur );
        return "utilisateurs"; // Thymeleaf va utiliser utilisateurs.html pour afficher la liste
    }

    @GetMapping("connexion")
    public String formulaireConnexion() {
        return "connexion";
    }
    @PostMapping("connexion")
    public String connexionUtilisateur(@RequestParam String login,String mdp, Model model) {
        Utilisateurs utilisateur = utilisateurService.connecterUtilisateur(login);
        if (utilisateur.getLogin() != null) {
            model.addAttribute("utilisateur", utilisateur.getLogin());
            return "redirect:/news";
        } else {
            model.addAttribute("message", "Login incorrect !");
            return "connexion";
        }
    }










    /*
    @GetMapping("/connexion")
    public String formulaireConnexion() {
        return "news";
    }
    @PostMapping("/connexion")
    public String connexionUtilisateur(@RequestParam String login,String mdp, Model model) {
        Utilisateurs utilisateur = utilisateurService.connecterUtilisateur(login);
        if (utilisateur.getLogin() == null) {
            model.addAttribute("utilisateur", utilisateur.getLogin());
            return "news";
        } else {
            model.addAttribute("message", "Login incorrect !");
            return "connexion";
        }
    }
*/
/*
    // Afficher le formulaire de connexion
    @GetMapping("/inscription")
    public String afficherFormulaireConnexion(Model model) {
        model.addAttribute("loginForm", new Utilisateurs()); // Utilisé pour stocker le login
        return "inscription";
    }
    // Traiter le formulaire de connexion
    @PostMapping("/inscription")
    public String connecterUtilisateur(@ModelAttribute("loginForm") Utilisateurs loginForm, Model model) {
        Utilisateurs utilisateur = utilisateurService.connecterUtilisateur(loginForm.getLogin());
        if (utilisateur != null) {
            return "redirect:/news"; // Redirige vers la page News si l'utilisateur est trouvé
        } else {
            model.addAttribute("erreur", "Utilisateur non trouvé. Veuillez vérifier votre login.");
            return "news"; // Retourne à la page de connexion avec le message d'erreur
        }
    }
*/
    // se connecter un utilisateur deja existe
    /*@PostMapping("/login")
    public String loginUtilisateur(@ModelAttribute Utilisateurs utilisateur, Model model) {
        try {
            utilisateurService.loginUtilisateur(utilisateur);
            return "news";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erreur", e.getMessage());
            return "inscription";
        }
    }*/


}
