package br.com.cadastroprodutos.repository;

import br.com.cadastroprodutos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    List<Categoria> findAllByOrderByNome();
    List<Categoria> findByNomeIsContaining(String nome);
}
