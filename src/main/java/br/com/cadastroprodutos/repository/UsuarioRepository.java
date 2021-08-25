package br.com.cadastroprodutos.repository;

import br.com.cadastroprodutos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

    List<Usuario> findByNomeIsContaining(String nome);
}
