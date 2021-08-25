package br.com.cadastroprodutos.repository;

import br.com.cadastroprodutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeIsContaining(String nome);
}
