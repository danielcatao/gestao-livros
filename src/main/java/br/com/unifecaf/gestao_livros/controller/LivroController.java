package br.com.unifecaf.gestao_livros.controller;

import br.com.unifecaf.gestao_livros.model.Livro;
import br.com.unifecaf.gestao_livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("livros", livroService.findAll());
        model.addAttribute("livro", new Livro());
        return "index";
    }

    @PostMapping("/")
    public String saveLivro(@ModelAttribute Livro livro) {
        livroService.save(livro);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editLivro(@PathVariable Long id, Model model) {
        Livro livro = livroService.findById(id);
        if (livro == null) {
            return "redirect:/";
        }
        model.addAttribute("livros", livroService.findAll());
        model.addAttribute("livro", livro);
        return "index";
    }

    @PostMapping("/delete/{id}")
    public String deleteLivro(@PathVariable Long id) {
        livroService.delete(id);
        return "redirect:/";
    }
}