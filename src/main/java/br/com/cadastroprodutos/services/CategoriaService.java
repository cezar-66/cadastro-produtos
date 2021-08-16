package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Categoria;
import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository cr;

    public ModelAndView getAllCategorias(){
        ModelAndView mv = new ModelAndView("views/categorias/listaCategorias");
        List<Categoria> categorias = cr.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }
}
