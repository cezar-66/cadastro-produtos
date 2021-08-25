package br.com.cadastroprodutos.resources;

import br.com.cadastroprodutos.models.Categoria;
import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listCategorias")
    public ModelAndView listAllProdutos(){
        return service.getAllCategorias();
    }

    @RequestMapping(path = "/autocompleteCategorias", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Categoria> autoCompleteOperador(@RequestParam String name){
        return service.autoCompleteCategorias(name);
    }

    @RequestMapping(value="/formEditCategoria/{codigoCategoria}", method=RequestMethod.GET)
    public ModelAndView formEditCategoria(@RequestParam Integer codigo){
        ModelAndView mv = service.formEditCategoria(codigo);
        return mv;
    }
}
