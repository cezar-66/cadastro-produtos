package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Usuario;
import br.com.cadastroprodutos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository or;

    public ModelAndView getAllOperadores(){
        ModelAndView mv = new ModelAndView("views/usuarios/index");
        List<Usuario> usuarios = or.findAll();
        mv.addObject("usuario", usuarios);
        return mv;
    }

    public List<Usuario> autoCompleteUsuarios(String nome){
        if(!nome.isEmpty()){
            List<Usuario> results = or.findByNomeIsContaining(nome);
            return results.stream().filter(op -> op.getNome().contains(nome)).collect(Collectors.toList());
        }
        return null;
    }

    public ModelAndView formEditUser(Integer codigo){
        Usuario usuario = or.getById(codigo);
        ModelAndView mv = new ModelAndView("views/usuarios/edit-usuario");
        mv.addObject("usuario", usuario);
        return mv;
    }
}
