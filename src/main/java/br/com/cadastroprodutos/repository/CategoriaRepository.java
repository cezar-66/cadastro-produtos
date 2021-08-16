package br.com.cadastroprodutos.repository;

import br.com.cadastroprodutos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
