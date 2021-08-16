package br.com.cadastroprodutos.resources;

import br.com.cadastroprodutos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listCategorias")
    public ModelAndView listAllProdutos(){
        return service.getAllCategorias();
    }
}
