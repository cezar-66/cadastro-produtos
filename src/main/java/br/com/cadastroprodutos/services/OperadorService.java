package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.models.Usuario;
import br.com.cadastroprodutos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class OperadorService {

    @Autowired
    private UsuarioRepository ur;

    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("views/operadores/listaOperadores");
        List<Usuario> usuarios = ur.findAll();
        mv.addObject("operadores", usuarios);
        return mv;
    }

    public ModelAndView detalhesOperador(Integer codigo){
        Usuario operador = ur.getById(codigo);
        ModelAndView mv = new ModelAndView("views/operadores/detalhesOperador");
        mv.addObject("operador", operador);
        return mv;
    }
}
