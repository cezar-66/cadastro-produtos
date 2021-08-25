package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Categoria;
import br.com.cadastroprodutos.models.Usuario;
import br.com.cadastroprodutos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository cr;

    public ModelAndView getAllCategorias(){
        ModelAndView mv = new ModelAndView("views/categorias/index");
        List<Categoria> categorias = cr.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }

    public List<Categoria> autoCompleteCategorias(String nome){
        if(nome.isEmpty()){
            List<Categoria> results = cr.findByNomeIsContaining(nome);
            return results.stream().filter(pro -> pro.getNome().contains(nome)).collect(Collectors.toList());
        }
        return null;
    }

    public ModelAndView formEditCategoria(Integer codigo){
        Categoria categoria = cr.getById(codigo);
        ModelAndView mv = new ModelAndView("views/categorias/edit-categoria");
        mv.addObject("categoria", categoria);
        return mv;
    }
}
