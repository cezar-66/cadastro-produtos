package br.com.cadastroprodutos.repository;

import br.com.cadastroprodutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
