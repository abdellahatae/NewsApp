package com.NewsApp.NewsBackend.controller;

import com.NewsApp.NewsBackend.entity.Commentaires;
import com.NewsApp.NewsBackend.entity.News;
import com.NewsApp.NewsBackend.service.CommentairesService;
import com.NewsApp.NewsBackend.service.NewsService;
import com.NewsApp.NewsBackend.service.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private UtilisateursService utilisateursService;
    @Autowired
    private CommentairesService commentairesService;
    // Afficher la page de toutes les news
    @GetMapping
    public String afficherToutesLesNews(Model model) {
        List<News> newsList= newsService.getAllNews();
        // Vérifiez si la liste de news n'est pas vide
        if (newsList.isEmpty()) {
            model.addAttribute("message", "Aucune news disponible.");
        } else {
            // Pour chaque news, récupérer les commentaires associés
            for (News news : newsList) {
                List<Commentaires> commentaires = commentairesService.getCommentairesByNewsId(news.getId());
                news.setCommentaires(commentaires); // Assurez-vous que cette méthode existe dans News
            }
        }
        model.addAttribute("newsList", newsList);
        return "news"; // Utilise news.html pour afficher la liste des news
    }

    @GetMapping("/mynews")
    public String listeDesNews(@RequestParam("login") String login,Model model) {
        // Récupérer les news créées par l'auteur "Ata001"
        List<News> newsList = newsService.findAllByAuteur(login);
        model.addAttribute("newsList", newsList);
        return "news"; // Nom de votre template Thymeleaf
    }
    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("author") String author, Model model) {
        List<News> newsList = newsService.findAllByAuteur(author);
        model.addAttribute("newsList", newsList);
        model.addAttribute("searchAuthor", author); // Pour afficher l'auteur recherché
        return "news"; // Nom de votre template pour afficher les résultats
    }

    // Afficher le formulaire d'ajout de news
    @GetMapping("/ajouter")
    public String afficherFormulaireAjoutNews(Model model) {
        model.addAttribute("news", new News());
        return "ajouter-news";
    }

    // Ajouter une news
    @PostMapping("/ajouter")
    public String ajouterNews(@ModelAttribute News news, Model model) {
        try {
            newsService.ajouterNews(news);
            return "redirect:/news";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erreur", e.getMessage());
            return "ajouter-news";
        }
    }

    // Gérer les likes et dislikes
    @PostMapping("/{id}/reaction")
    public String likeOrDislikeNews(@PathVariable String id, @RequestParam String action, Model model) {
        try {
            newsService.likeOrDislikeNews(id, action);
            return "redirect:/news";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erreur", e.getMessage());
            return "news";
        }
    }

   /* @GetMapping("/ajouter/{login}")
    public String ajouterNews(@PathVariable String login) {
        NewsService.supprimerClient(login);
        return "redirect:/clients";  // Redirige vers la liste des clients
    }*/
}
