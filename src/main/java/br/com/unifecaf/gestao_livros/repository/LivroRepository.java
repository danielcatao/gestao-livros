package br.com.unifecaf.gestao_livros.repository;

import br.com.unifecaf.gestao_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}