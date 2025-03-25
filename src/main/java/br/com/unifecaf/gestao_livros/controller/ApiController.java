package br.com.unifecaf.gestao_livros.controller;

import br.com.unifecaf.gestao_livros.model.Livro;
import br.com.unifecaf.gestao_livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class ApiController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        return livro;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro createLivro(@RequestBody Livro body) {
        System.out.println("Recebido: " + body.getTitulo() + ", " + body.getAutor() + ", " + body.getEditora() + ", " + body.getGenero());
        return livroService.save(body);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro updatedLivro) {
        Livro livro = livroService.findById(id);
        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        livro.setTitulo(updatedLivro.getTitulo());
        livro.setAutor(updatedLivro.getAutor());
        livro.setEditora(updatedLivro.getEditora());
        livro.setGenero(updatedLivro.getGenero());
        return livroService.save(livro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        livroService.delete(id);
    }
}
