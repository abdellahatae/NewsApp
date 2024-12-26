package com.NewsApp.NewsBackend.controller;

import com.NewsApp.NewsBackend.entity.Commentaires;
import com.NewsApp.NewsBackend.service.CommentairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentairesService commentaireService;

    // Afficher le formulaire d'ajout de commentaire
    /*@GetMapping("/ajouter/add")
    public String afficherFormulaireAjoutCommentaire(@RequestParam("newsId") Long newsId, Model model) {
        model.addAttribute("newsId", newsId);
        model.addAttribute("commentaire", new Commentaires());
        return "ajouter-commentaire"; // Assurez-vous que ce nom correspond à votre template
    }*/
    // Afficher le formulaire d'ajout de commentaire
    @GetMapping("/ajouter/add")
    public String afficherFormulaireAjoutCommentaire(@RequestParam("newsId") String newsId, Model model) {
        model.addAttribute("newsId", newsId);
        model.addAttribute("commentaire", new Commentaires());
        return "ajouter-commentaire";
    }

    // Ajouter un commentaire
    @PostMapping("/ajouter")
    public String ajouterCommentaire(@ModelAttribute("commentaire") Commentaires commentaire, Model model) {
        try {
            // Enregistrez le commentaire dans la base de données
            CommentairesService.ajouterCommentaire(commentaire);
          //  return "redirect:/news/" + commentaire.getNewsId();
            return "redirect:/news";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erreur", e.getMessage());
            return "ajouter-commentaire";
        }
    }

    // Afficher les commentaires d'une news spécifique
    @GetMapping("/news/{newsId}")
    public String afficherCommentairesParNewsId(@PathVariable String newsId, Model model) {
        model.addAttribute("commentaires", commentaireService.getCommentairesByNewsId(newsId));
        return "commentaires"; // Utilise commentaires.html pour afficher la liste des commentaires
    }
}
